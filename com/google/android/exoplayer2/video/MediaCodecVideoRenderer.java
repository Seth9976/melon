package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int v, int v1, int v2) {
            this.width = v;
            this.height = v1;
            this.inputSize = v2;
        }
    }

    @TargetApi(23)
    final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodec mediaCodec0) {
            Handler handler0 = new Handler(this);
            this.handler = handler0;
            mediaCodec0.setOnFrameRenderedListener(this, handler0);
        }

        private void handleFrameRendered(long v) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer0 = MediaCodecVideoRenderer.this;
            if(this != mediaCodecVideoRenderer0.tunnelingOnFrameRenderedListener) {
                return;
            }
            if(v == 0x7FFFFFFFFFFFFFFFL) {
                mediaCodecVideoRenderer0.onProcessedTunneledEndOfStream();
                return;
            }
            mediaCodecVideoRenderer0.onProcessedTunneledBuffer(v);
        }

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            if(message0.what != 0) {
                return false;
            }
            this.handleFrameRendered(message0.arg2);
            return true;
        }

        @Override  // android.media.MediaCodec$OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec0, long v, long v1) {
            if(Util.SDK_INT < 30) {
                Message message0 = Message.obtain(this.handler, 0, ((int)(v >> 0x20)), ((int)v));
                this.handler.sendMessageAtFrontOfQueue(message0);
                return;
            }
            this.handleFrameRendered(v);
        }
    }

    public static final class VideoDecoderException extends DecoderException {
        public final boolean isSurfaceValid;
        public final int surfaceIdentityHashCode;

        public VideoDecoderException(Throwable throwable0, MediaCodecInfo mediaCodecInfo0, Surface surface0) {
            super(throwable0, mediaCodecInfo0);
            this.surfaceIdentityHashCode = System.identityHashCode(surface0);
            this.isSurfaceValid = surface0 == null || surface0.isValid();
        }
    }

    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = null;
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = 0x7FFFFFFFFFFFFFFFL;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private MediaFormat currentMediaFormat;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    static {
        MediaCodecVideoRenderer.STANDARD_LONG_EDGE_VIDEO_PX = new int[]{0x780, 1600, 0x5A0, 0x500, 960, 854, 640, 540, 480};
    }

    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0) {
        this(context0, mediaCodecSelector0, 0L);
    }

    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, long v) {
        this(context0, mediaCodecSelector0, v, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, long v, Handler handler0, VideoRendererEventListener videoRendererEventListener0, int v1) {
        this(context0, mediaCodecSelector0, v, null, false, handler0, videoRendererEventListener0, v1);
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, long v, DrmSessionManager drmSessionManager0, boolean z, Handler handler0, VideoRendererEventListener videoRendererEventListener0, int v1) {
        this(context0, mediaCodecSelector0, v, drmSessionManager0, z, false, handler0, videoRendererEventListener0, v1);
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, long v, DrmSessionManager drmSessionManager0, boolean z, boolean z1, Handler handler0, VideoRendererEventListener videoRendererEventListener0, int v1) {
        super(2, mediaCodecSelector0, drmSessionManager0, z, z1, 30.0f);
        this.allowedJoiningTimeMs = v;
        this.maxDroppedFramesToNotify = v1;
        Context context1 = context0.getApplicationContext();
        this.context = context1;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(context1);
        this.eventDispatcher = new EventDispatcher(handler0, videoRendererEventListener0);
        this.deviceNeedsNoPostProcessWorkaround = MediaCodecVideoRenderer.deviceNeedsNoPostProcessWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = 0x8000000000000001L;
        this.lastInputTimeUs = 0x8000000000000001L;
        this.joiningDeadlineMs = 0x8000000000000001L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.clearReportedVideoSize();
    }

    public MediaCodecVideoRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, long v, boolean z, Handler handler0, VideoRendererEventListener videoRendererEventListener0, int v1) {
        this(context0, mediaCodecSelector0, v, null, false, z, handler0, videoRendererEventListener0, v1);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(MediaCodec mediaCodec0, MediaCodecInfo mediaCodecInfo0, Format format0, Format format1) {
        if(mediaCodecInfo0.isSeamlessAdaptationSupported(format0, format1, true) && (format1.width <= this.codecMaxValues.width && format1.height <= this.codecMaxValues.height && MediaCodecVideoRenderer.getMaxInputSize(mediaCodecInfo0, format1) <= this.codecMaxValues.inputSize)) {
            return format0.initializationDataEquals(format1) ? 3 : 2;
        }
        return 0;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
        if(Util.SDK_INT >= 23 && this.tunneling) {
            MediaCodec mediaCodec0 = this.getCodec();
            if(mediaCodec0 != null) {
                this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(this, mediaCodec0);
            }
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    // 去混淆评级： 低(40)
    public boolean codecNeedsSetOutputSurfaceWorkaround(String s) {
        int v = 0;
        if(s.startsWith("OMX.google")) {
            return false;
        }
        synchronized(MediaCodecVideoRenderer.class) {
            if(!MediaCodecVideoRenderer.evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                String s1 = Util.DEVICE;
                if("dangal".equals(s1)) {
                    MediaCodecVideoRenderer.deviceNeedsSetOutputSurfaceWorkaround = true;
                }
                else {
                    int v2 = Util.SDK_INT;
                    if(v2 <= 27 && "HWEML".equals(s1)) {
                        MediaCodecVideoRenderer.deviceNeedsSetOutputSurfaceWorkaround = true;
                    }
                    else if(v2 < 27) {
                        switch(s1) {
                            case "1601": 
                            case "1713": 
                            case "1714": 
                            case "A10-70F": 
                            case "A10-70L": 
                            case "A1601": 
                            case "A2016a40": 
                            case "A7000-a": 
                            case "A7000plus": 
                            case "A7010a48": 
                            case "A7020a48": 
                            case "ASUS_X00AD_2": 
                            case "AquaPowerM": 
                            case "Aura_Note_2": 
                            case "BLACK-1X": 
                            case "BRAVIA_ATV2": 
                            case "BRAVIA_ATV3_4K": 
                            case "C1": 
                            case "CP8676_I02": 
                            case "CPH1609": 
                            case "CPY83_I00": 
                            case "ComioS1": 
                            case "E5643": 
                            case "ELUGA_A3_Pro": 
                            case "ELUGA_Note": 
                            case "ELUGA_Prim": 
                            case "ELUGA_Ray_X": 
                            case "EverStar_S": 
                            case "F3111": 
                            case "F3113": 
                            case "F3116": 
                            case "F3211": 
                            case "F3213": 
                            case "F3215": 
                            case "F3311": 
                            case "GIONEE_GBL7360": 
                            case "GIONEE_SWW1609": 
                            case "GIONEE_SWW1627": 
                            case "GIONEE_SWW1631": 
                            case "GIONEE_WBL5708": 
                            case "GIONEE_WBL7365": 
                            case "GIONEE_WBL7519": 
                            case "GiONEE_CBL7513": 
                            case "GiONEE_GBL7319": 
                            case "HWBLN-H": 
                            case "HWCAM-H": 
                            case "HWVNS-H": 
                            case "HWWAS-H": 
                            case "Infinix-X572": 
                            case "JGZ": 
                            case "K50a40": 
                            case "LS-5017": 
                            case "M5c": 
                            case "MEIZU_M5": 
                            case "MX6": 
                            case "NX541J": 
                            case "NX573J": 
                            case "OnePlus5T": 
                            case "P681": 
                            case "P85": 
                            case "PB2-670M": 
                            case "PGN528": 
                            case "PGN610": 
                            case "PGN611": 
                            case "PLE": 
                            case "PRO7S": 
                            case "Phantom6": 
                            case "Pixi4-7_3G": 
                            case "Pixi5-10_4G": 
                            case "Q350": 
                            case "Q4260": 
                            case "Q427": 
                            case "Q4310": 
                            case "Q5": 
                            case "QM16XE_U": 
                            case "QX1": 
                            case "SVP-DTV15": 
                            case "Slate_Pro": 
                            case "TB3-730F": 
                            case "TB3-730X": 
                            case "TB3-850F": 
                            case "TB3-850M": 
                            case "V1": 
                            case "V23GB": 
                            case "V5": 
                            case "X3_HK": 
                            case "XE2X": 
                            case "XT1663": 
                            case "Z12_PRO": 
                            case "Z80": 
                            case "cv1": 
                            case "cv3": 
                            case "deb": 
                            case "flo": 
                            case "fugu": 
                            case "griffin": 
                            case "htc_e56ml_dtul": 
                            case "hwALE-H": 
                            case "i9031": 
                            case "iball8735_9806": 
                            case "iris60": 
                            case "itel_S41": 
                            case "j2xlteins": 
                            case "kate": 
                            case "l5460": 
                            case "le_x6": 
                            case "manning": 
                            case "marino_f": 
                            case "mh": 
                            case "mido": 
                            case "namath": 
                            case "nicklaus_f": 
                            case "p212": 
                            case "panell_d": 
                            case "panell_dl": 
                            case "panell_ds": 
                            case "panell_dt": 
                            case "s905x018": 
                            case "santoni": 
                            case "taido_row": 
                            case "tcl_eu": 
                            case "vernee_M5": 
                            case "watson": 
                            case "whyred": 
                            case "woods_f": 
                            case "woods_fn": {
                                MediaCodecVideoRenderer.deviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                        }
                        switch(Util.MODEL) {
                            case "AFTA": {
                                break;
                            }
                            case "AFTN": {
                                v = 1;
                                break;
                            }
                            case "JSN-L21": {
                                v = 2;
                                break;
                            }
                            default: {
                                v = -1;
                            }
                        }
                        if(v == 0 || v == 1 || v == 2) {
                            MediaCodecVideoRenderer.deviceNeedsSetOutputSurfaceWorkaround = true;
                        }
                    }
                }
                MediaCodecVideoRenderer.evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
            return MediaCodecVideoRenderer.deviceNeedsSetOutputSurfaceWorkaround;
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo0, MediaCodec mediaCodec0, Format format0, MediaCrypto mediaCrypto0, float f) {
        CodecMaxValues mediaCodecVideoRenderer$CodecMaxValues0 = this.getCodecMaxValues(mediaCodecInfo0, format0, this.getStreamFormats());
        this.codecMaxValues = mediaCodecVideoRenderer$CodecMaxValues0;
        MediaFormat mediaFormat0 = this.getMediaFormat(format0, mediaCodecInfo0.codecMimeType, mediaCodecVideoRenderer$CodecMaxValues0, f, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if(this.surface == null) {
            Assertions.checkState(this.shouldUseDummySurface(mediaCodecInfo0));
            if(this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo0.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec0.configure(mediaFormat0, this.surface, mediaCrypto0, 0);
        if(Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(this, mediaCodec0);
        }
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat0, int v) {
        mediaFormat0.setFeatureEnabled("tunneled-playback", true);
        mediaFormat0.setInteger("audio-session-id", v);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderException createDecoderException(Throwable throwable0, MediaCodecInfo mediaCodecInfo0) {
        return new VideoDecoderException(throwable0, mediaCodecInfo0, this.surface);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() [...] // 潜在的解密器

    public void dropOutputBuffer(MediaCodec mediaCodec0, int v, long v1) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec0.releaseOutputBuffer(v, false);
        TraceUtil.endSection();
        this.updateDroppedBufferCounters(1);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean flushOrReleaseCodec() {
        try {
            boolean z = super.flushOrReleaseCodec();
            this.buffersInCodecCount = 0;
            return z;
        }
        catch(Throwable throwable0) {
            this.buffersInCodecCount = 0;
            throw throwable0;
        }
    }

    private static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo0, String s, int v, int v1) {
        if(v != -1 && v1 != -1) {
            s.getClass();
            switch(s) {
                case "video/3gpp": {
                    return v * v1 * 3 / 4;
                }
                case "video/avc": {
                    return "BRAVIA 4K 2015".equals(Util.MODEL) || "Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(Util.MODEL) || "AFTS".equals(Util.MODEL) && mediaCodecInfo0.secure) ? -1 : (v1 + 15) / 16 * ((v + 15) / 16) * 0x300 / 4;
                }
                case "video/hevc": {
                    return v * v1 * 3 / 8;
                }
                case "video/mp4v-es": {
                    return v * v1 * 3 / 4;
                }
                case "video/x-vnd.on2.vp8": {
                    return v * v1 * 3 / 4;
                }
                case "video/x-vnd.on2.vp9": {
                    return v * v1 * 3 / 8;
                }
                default: {
                    return -1;
                }
            }
        }
        return -1;
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo0, Format format0) {
        int v = format0.height;
        int v1 = format0.width;
        int v2 = 0;
        boolean z = v > v1;
        int v3 = z ? v : v1;
        if(z) {
            v = v1;
        }
        int[] arr_v = MediaCodecVideoRenderer.STANDARD_LONG_EDGE_VIDEO_PX;
        while(v2 < arr_v.length) {
            int v4 = arr_v[v2];
            int v5 = (int)(((float)v4) * (((float)v) / ((float)v3)));
            if(v4 <= v3 || v5 <= v) {
                break;
            }
            if(Util.SDK_INT >= 21) {
                int v6 = z ? v5 : v4;
                if(!z) {
                    v4 = v5;
                }
                Point point0 = mediaCodecInfo0.alignVideoSizeV21(v6, v4);
                if(mediaCodecInfo0.isVideoSizeAndRateSupportedV21(point0.x, point0.y, ((double)format0.frameRate))) {
                    return point0;
                }
            }
            else {
                try {
                    int v7 = (v4 + 15) / 16 * 16;
                    int v8 = (v5 + 15) / 16 * 16;
                    if(v7 * v8 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int v9 = z ? v8 : v7;
                        if(!z) {
                            v7 = v8;
                        }
                        return new Point(v9, v7);
                    }
                    ++v2;
                    continue;
                }
                catch(DecoderQueryException unused_ex) {
                }
                break;
            }
            ++v2;
        }
        return null;
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo0, Format format0, Format[] arr_format) {
        int v = format0.width;
        int v1 = format0.height;
        int v2 = MediaCodecVideoRenderer.getMaxInputSize(mediaCodecInfo0, format0);
        if(arr_format.length == 1) {
            if(v2 != -1) {
                int v3 = MediaCodecVideoRenderer.getCodecMaxInputSize(mediaCodecInfo0, format0.sampleMimeType, format0.width, format0.height);
                if(v3 != -1) {
                    v2 = Math.min(((int)(((float)v2) * 1.5f)), v3);
                }
            }
            return new CodecMaxValues(v, v1, v2);
        }
        int v5 = 0;
        for(int v4 = 0; v4 < arr_format.length; ++v4) {
            Format format1 = arr_format[v4];
            if(mediaCodecInfo0.isSeamlessAdaptationSupported(format0, format1, false)) {
                v5 |= (format1.width == -1 || format1.height == -1 ? 1 : 0);
                v = Math.max(v, format1.width);
                v1 = Math.max(v1, format1.height);
                v2 = Math.max(v2, MediaCodecVideoRenderer.getMaxInputSize(mediaCodecInfo0, format1));
            }
        }
        if(v5 != 0) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + v + "x" + v1);
            Point point0 = MediaCodecVideoRenderer.getCodecMaxSize(mediaCodecInfo0, format0);
            if(point0 != null) {
                v = Math.max(v, point0.x);
                v1 = Math.max(v1, point0.y);
                v2 = Math.max(v2, MediaCodecVideoRenderer.getCodecMaxInputSize(mediaCodecInfo0, format0.sampleMimeType, v, v1));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + v + "x" + v1);
            }
        }
        return new CodecMaxValues(v, v1, v2);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format0, Format[] arr_format) {
        float f1 = -1.0f;
        for(int v = 0; v < arr_format.length; ++v) {
            float f2 = arr_format[v].frameRate;
            if(f2 != -1.0f) {
                f1 = Math.max(f1, f2);
            }
        }
        return f1 == -1.0f ? -1.0f : f1 * f;
    }

    private static List getDecoderInfos(MediaCodecSelector mediaCodecSelector0, Format format0, boolean z, boolean z1) {
        String s = format0.sampleMimeType;
        if(s == null) {
            return Collections.EMPTY_LIST;
        }
        List list0 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector0.getDecoderInfos(s, z, z1), format0);
        if("video/dolby-vision".equals(s)) {
            Pair pair0 = MediaCodecUtil.getCodecProfileAndLevel(format0);
            if(pair0 != null) {
                switch(((int)(((Integer)pair0.first)))) {
                    case 16: 
                    case 0x100: {
                        list0.addAll(mediaCodecSelector0.getDecoderInfos("video/hevc", z, z1));
                        break;
                    }
                    case 0x200: {
                        list0.addAll(mediaCodecSelector0.getDecoderInfos("video/avc", z, z1));
                        return Collections.unmodifiableList(list0);
                    }
                    default: {
                        return Collections.unmodifiableList(list0);
                    }
                }
            }
        }
        return Collections.unmodifiableList(list0);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List getDecoderInfos(MediaCodecSelector mediaCodecSelector0, Format format0, boolean z) {
        return MediaCodecVideoRenderer.getDecoderInfos(mediaCodecSelector0, format0, z, this.tunneling);
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo0, Format format0) {
        if(format0.maxInputSize != -1) {
            int v = format0.initializationData.size();
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                v2 += ((byte[])format0.initializationData.get(v1)).length;
            }
            return format0.maxInputSize + v2;
        }
        return MediaCodecVideoRenderer.getCodecMaxInputSize(mediaCodecInfo0, format0.sampleMimeType, format0.width, format0.height);
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format0, String s, CodecMaxValues mediaCodecVideoRenderer$CodecMaxValues0, float f, boolean z, int v) {
        MediaFormat mediaFormat0 = new MediaFormat();
        mediaFormat0.setString("mime", s);
        mediaFormat0.setInteger("width", format0.width);
        mediaFormat0.setInteger("height", format0.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat0, format0.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat0, "frame-rate", format0.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat0, "rotation-degrees", format0.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat0, format0.colorInfo);
        if("video/dolby-vision".equals(format0.sampleMimeType)) {
            Pair pair0 = MediaCodecUtil.getCodecProfileAndLevel(format0);
            if(pair0 != null) {
                MediaFormatUtil.maybeSetInteger(mediaFormat0, "profile", ((int)(((Integer)pair0.first))));
            }
        }
        mediaFormat0.setInteger("max-width", mediaCodecVideoRenderer$CodecMaxValues0.width);
        mediaFormat0.setInteger("max-height", mediaCodecVideoRenderer$CodecMaxValues0.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat0, "max-input-size", mediaCodecVideoRenderer$CodecMaxValues0.inputSize);
        if(Util.SDK_INT >= 23) {
            mediaFormat0.setInteger("priority", 0);
            if(f != -1.0f) {
                mediaFormat0.setFloat("operating-rate", f);
            }
        }
        if(z) {
            mediaFormat0.setInteger("no-post-process", 1);
            mediaFormat0.setInteger("auto-frc", 0);
        }
        if(v != 0) {
            MediaCodecVideoRenderer.configureTunnelingV21(mediaFormat0, v);
        }
        return mediaFormat0;
    }

    public long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    public Surface getSurface() {
        return this.surface;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer0) {
        if(this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(decoderInputBuffer0.supplementalData);
            if(byteBuffer0.remaining() >= 7) {
                int v = byteBuffer0.get();
                int v1 = byteBuffer0.getShort();
                int v2 = byteBuffer0.getShort();
                int v3 = byteBuffer0.get();
                int v4 = byteBuffer0.get();
                byteBuffer0.position(0);
                if(v == -75 && v1 == 60 && v2 == 1 && v3 == 4 && v4 == 0) {
                    byte[] arr_b = new byte[byteBuffer0.remaining()];
                    byteBuffer0.get(arr_b);
                    byteBuffer0.position(0);
                    MediaCodecVideoRenderer.setHdr10PlusInfoV29(this.getCodec(), arr_b);
                }
            }
        }
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void handleMessage(int v, Object object0) {
        switch(v) {
            case 1: {
                this.setSurface(((Surface)object0));
                return;
            }
            case 4: {
                this.scalingMode = (int)(((Integer)object0));
                MediaCodec mediaCodec0 = this.getCodec();
                if(mediaCodec0 != null) {
                    mediaCodec0.setVideoScalingMode(this.scalingMode);
                }
                return;
            }
            case 6: {
                this.frameMetadataListener = (VideoFrameMetadataListener)object0;
                return;
            }
            default: {
                super.handleMessage(v, object0);
            }
        }
    }

    private static boolean isBufferLate(long v) {
        return v < -30000L;
    }

    private static boolean isBufferVeryLate(long v) {
        return v < -500000L;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean isReady() {
        if(super.isReady() && (this.renderedFirstFrame || (this.dummySurface != null && this.surface == this.dummySurface || this.getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = 0x8000000000000001L;
            return true;
        }
        if(Long.compare(this.joiningDeadlineMs, 0x8000000000000001L) == 0) {
            return false;
        }
        if(SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = 0x8000000000000001L;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec0, int v, long v1, long v2, boolean z) {
        int v3 = this.skipSource(v2);
        if(v3 == 0) {
            return false;
        }
        DecoderCounters decoderCounters0 = this.decoderCounters;
        ++decoderCounters0.droppedToKeyframeCount;
        int v4 = this.buffersInCodecCount + v3;
        if(z) {
            decoderCounters0.skippedOutputBufferCount += v4;
        }
        else {
            this.updateDroppedBufferCounters(v4);
        }
        this.flushOrReinitializeCodec();
        return true;
    }

    private void maybeNotifyDroppedFrames() {
        if(this.droppedFrames > 0) {
            long v = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, v - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = v;
        }
    }

    public void maybeNotifyRenderedFirstFrame() {
        if(!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int v = this.currentWidth;
        if(v == -1 && this.currentHeight == -1 || this.reportedWidth == v && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(v, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if(this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int v = this.reportedWidth;
        if(v == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(v, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void notifyFrameMetadataListener(long v, long v1, Format format0, MediaFormat mediaFormat0) {
        VideoFrameMetadataListener videoFrameMetadataListener0 = this.frameMetadataListener;
        if(videoFrameMetadataListener0 != null) {
            videoFrameMetadataListener0.onVideoFrameAboutToBeRendered(v, v1, format0, mediaFormat0);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String s, long v, long v1) {
        this.eventDispatcher.decoderInitialized(s, v, v1);
        this.codecNeedsSetOutputSurfaceWorkaround = this.codecNeedsSetOutputSurfaceWorkaround(s);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo)Assertions.checkNotNull(this.getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onDisabled() {
        this.lastInputTimeUs = 0x8000000000000001L;
        this.outputStreamOffsetUs = 0x8000000000000001L;
        this.pendingOutputStreamOffsetCount = 0;
        this.currentMediaFormat = null;
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        }
        finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onEnabled(boolean z) {
        super.onEnabled(z);
        int v = this.tunnelingAudioSessionId;
        int v1 = this.getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = v1;
        this.tunneling = v1 != 0;
        if(v1 != v) {
            this.releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(FormatHolder formatHolder0) {
        super.onInputFormatChanged(formatHolder0);
        Format format0 = formatHolder0.format;
        this.eventDispatcher.inputFormatChanged(format0);
        this.pendingPixelWidthHeightRatio = format0.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format0.rotationDegrees;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec0, MediaFormat mediaFormat0) {
        this.currentMediaFormat = mediaFormat0;
        boolean z = mediaFormat0.containsKey("crop-right") && mediaFormat0.containsKey("crop-left") && mediaFormat0.containsKey("crop-bottom") && mediaFormat0.containsKey("crop-top");
        this.processOutputFormat(mediaCodec0, (z ? mediaFormat0.getInteger("crop-right") - mediaFormat0.getInteger("crop-left") + 1 : mediaFormat0.getInteger("width")), (z ? mediaFormat0.getInteger("crop-bottom") - mediaFormat0.getInteger("crop-top") + 1 : mediaFormat0.getInteger("height")));
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onPositionReset(long v, boolean z) {
        super.onPositionReset(v, z);
        this.clearRenderedFirstFrame();
        this.initialPositionUs = 0x8000000000000001L;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = 0x8000000000000001L;
        int v1 = this.pendingOutputStreamOffsetCount;
        if(v1 != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[v1 - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if(z) {
            this.setJoiningDeadlineMs();
            return;
        }
        this.joiningDeadlineMs = 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedOutputBuffer(long v) {
        if(!this.tunneling) {
            --this.buffersInCodecCount;
        }
        while(true) {
            int v1 = this.pendingOutputStreamOffsetCount;
            if(v1 == 0 || v < this.pendingOutputStreamSwitchTimesUs[0]) {
                break;
            }
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[0];
            this.pendingOutputStreamOffsetCount = v1 - 1;
            System.arraycopy(this.pendingOutputStreamOffsetsUs, 1, this.pendingOutputStreamOffsetsUs, 0, v1 - 1);
            System.arraycopy(this.pendingOutputStreamSwitchTimesUs, 1, this.pendingOutputStreamSwitchTimesUs, 0, this.pendingOutputStreamOffsetCount);
            this.clearRenderedFirstFrame();
        }
    }

    public void onProcessedTunneledBuffer(long v) {
        Format format0 = this.updateOutputFormatForTime(v);
        if(format0 != null) {
            this.processOutputFormat(this.getCodec(), format0.width, format0.height);
        }
        this.maybeNotifyVideoSizeChanged();
        ++this.decoderCounters.renderedOutputBufferCount;
        this.maybeNotifyRenderedFirstFrame();
        this.onProcessedOutputBuffer(v);
    }

    private void onProcessedTunneledEndOfStream() {
        this.setPendingOutputEndOfStream();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer0) {
        if(!this.tunneling) {
            ++this.buffersInCodecCount;
        }
        this.lastInputTimeUs = Math.max(decoderInputBuffer0.timeUs, this.lastInputTimeUs);
        if(Util.SDK_INT < 23 && this.tunneling) {
            this.onProcessedTunneledBuffer(decoderInputBuffer0.timeUs);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onReset() {
        Surface surface0;
        try {
            super.onReset();
            surface0 = this.dummySurface;
        }
        catch(Throwable throwable0) {
            if(this.dummySurface != null) {
                Surface surface1 = this.dummySurface;
                if(this.surface == surface1) {
                    this.surface = null;
                }
                surface1.release();
                this.dummySurface = null;
            }
            throw throwable0;
        }
        if(surface0 != null) {
            if(this.surface == surface0) {
                this.surface = null;
            }
            surface0.release();
            this.dummySurface = null;
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000L;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onStopped() {
        this.joiningDeadlineMs = 0x8000000000000001L;
        this.maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        if(this.outputStreamOffsetUs == 0x8000000000000001L) {
            this.outputStreamOffsetUs = v;
        }
        else {
            int v1 = this.pendingOutputStreamOffsetCount;
            long[] arr_v = this.pendingOutputStreamOffsetsUs;
            if(v1 == arr_v.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + arr_v[v1 - 1]);
            }
            else {
                this.pendingOutputStreamOffsetCount = v1 + 1;
            }
            int v2 = this.pendingOutputStreamOffsetCount;
            this.pendingOutputStreamOffsetsUs[v2 - 1] = v;
            this.pendingOutputStreamSwitchTimesUs[v2 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(arr_format, v);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long v, long v1, MediaCodec mediaCodec0, ByteBuffer byteBuffer0, int v2, int v3, long v4, boolean z, boolean z1, Format format0) {
        boolean z4;
        long v10;
        long v9;
        if(this.initialPositionUs == 0x8000000000000001L) {
            this.initialPositionUs = v;
        }
        long v5 = v4 - this.outputStreamOffsetUs;
        if(z && !z1) {
            this.skipOutputBuffer(mediaCodec0, v2, v5);
            return true;
        }
        long v6 = v4 - v;
        if(this.surface == this.dummySurface) {
            if(MediaCodecVideoRenderer.isBufferLate(v6)) {
                this.skipOutputBuffer(mediaCodec0, v2, v5);
                return true;
            }
            return false;
        }
        long v7 = SystemClock.elapsedRealtime();
        long v8 = v7 * 1000L - this.lastRenderTimeUs;
        boolean z2 = this.getState() == 2;
        if(Long.compare(this.joiningDeadlineMs, 0x8000000000000001L) != 0 || v < this.outputStreamOffsetUs) {
            v10 = v5;
            v9 = v6;
        }
        else {
            if(this.renderedFirstFrame) {
                v9 = v6;
                if(!z2 || !this.shouldForceRenderOutputBuffer(v9, v8)) {
                    v10 = v5;
                    goto label_30;
                }
            }
            long v11 = System.nanoTime();
            this.notifyFrameMetadataListener(v5, v11, format0, this.currentMediaFormat);
            if(Util.SDK_INT >= 21) {
                this.renderOutputBufferV21(mediaCodec0, v2, v5, v11);
                return true;
            }
            this.renderOutputBuffer(mediaCodec0, v2, v5);
            return true;
        }
    label_30:
        if(z2 && v != this.initialPositionUs) {
            long v12 = System.nanoTime();
            long v13 = this.frameReleaseTimeHelper.adjustReleaseTime(v4, (v9 - (v7 * 1000L - v1)) * 1000L + v12);
            long v14 = (v13 - v12) / 1000L;
            boolean z3 = this.joiningDeadlineMs != 0x8000000000000001L;
            if(this.shouldDropBuffersToKeyframe(v14, v1, z1)) {
                z4 = z3;
                if(this.maybeDropBuffersToKeyframe(mediaCodec0, v2, v10, v, z4)) {
                    return false;
                }
            }
            else {
                z4 = z3;
            }
            if(this.shouldDropOutputBuffer(v14, v1, z1)) {
                if(z4) {
                    this.skipOutputBuffer(mediaCodec0, v2, v10);
                    return true;
                }
                this.dropOutputBuffer(mediaCodec0, v2, v10);
                return true;
            }
            if(Util.SDK_INT >= 21) {
                if(v14 < 50000L) {
                    this.notifyFrameMetadataListener(v10, v13, format0, this.currentMediaFormat);
                    this.renderOutputBufferV21(mediaCodec0, v2, v10, v13);
                    return true;
                }
            }
            else if(v14 < 30000L) {
                if(v14 > 11000L) {
                    try {
                        Thread.sleep((v14 - 10000L) / 1000L);
                    }
                    catch(InterruptedException unused_ex) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                this.notifyFrameMetadataListener(v10, v13, format0, this.currentMediaFormat);
                this.renderOutputBuffer(mediaCodec0, v2, v10);
                return true;
            }
        }
        return false;
    }

    private void processOutputFormat(MediaCodec mediaCodec0, int v, int v1) {
        this.currentWidth = v;
        this.currentHeight = v1;
        float f = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if(Util.SDK_INT < 21) {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        else if(this.pendingRotationDegrees == 90 || this.pendingRotationDegrees == 270) {
            this.currentWidth = v1;
            this.currentHeight = v;
            this.currentPixelWidthHeightRatio = 1.0f / f;
        }
        mediaCodec0.setVideoScalingMode(this.scalingMode);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void releaseCodec() {
        try {
            super.releaseCodec();
            this.buffersInCodecCount = 0;
        }
        catch(Throwable throwable0) {
            this.buffersInCodecCount = 0;
            throw throwable0;
        }
    }

    public void renderOutputBuffer(MediaCodec mediaCodec0, int v, long v1) {
        this.maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec0.releaseOutputBuffer(v, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000L;
        ++this.decoderCounters.renderedOutputBufferCount;
        this.consecutiveDroppedFrameCount = 0;
        this.maybeNotifyRenderedFirstFrame();
    }

    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec0, int v, long v1, long v2) {
        this.maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec0.releaseOutputBuffer(v, v2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000L;
        ++this.decoderCounters.renderedOutputBufferCount;
        this.consecutiveDroppedFrameCount = 0;
        this.maybeNotifyRenderedFirstFrame();
    }

    @TargetApi(29)
    private static void setHdr10PlusInfoV29(MediaCodec mediaCodec0, byte[] arr_b) {
        Bundle bundle0 = new Bundle();
        bundle0.putByteArray("hdr10-plus-info", arr_b);
        mediaCodec0.setParameters(bundle0);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs <= 0L ? 0x8000000000000001L : SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec mediaCodec0, Surface surface0) {
        mediaCodec0.setOutputSurface(surface0);
    }

    private void setSurface(Surface surface0) {
        if(surface0 == null) {
            Surface surface1 = this.dummySurface;
            if(surface1 == null) {
                MediaCodecInfo mediaCodecInfo0 = this.getCodecInfo();
                if(mediaCodecInfo0 != null && this.shouldUseDummySurface(mediaCodecInfo0)) {
                    surface0 = DummySurface.newInstanceV17(this.context, mediaCodecInfo0.secure);
                    this.dummySurface = surface0;
                }
            }
            else {
                surface0 = surface1;
            }
        }
        if(this.surface != surface0) {
            this.surface = surface0;
            int v = this.getState();
            MediaCodec mediaCodec0 = this.getCodec();
            if(mediaCodec0 != null) {
                if(Util.SDK_INT < 23 || surface0 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    this.releaseCodec();
                    this.maybeInitCodec();
                }
                else {
                    MediaCodecVideoRenderer.setOutputSurfaceV23(mediaCodec0, surface0);
                }
            }
            if(surface0 == null || surface0 == this.dummySurface) {
                this.clearReportedVideoSize();
                this.clearRenderedFirstFrame();
                return;
            }
            this.maybeRenotifyVideoSizeChanged();
            this.clearRenderedFirstFrame();
            if(v == 2) {
                this.setJoiningDeadlineMs();
            }
        }
        else if(surface0 != null && surface0 != this.dummySurface) {
            this.maybeRenotifyVideoSizeChanged();
            this.maybeRenotifyRenderedFirstFrame();
        }
    }

    // 去混淆评级： 低(20)
    public boolean shouldDropBuffersToKeyframe(long v, long v1, boolean z) {
        return MediaCodecVideoRenderer.isBufferVeryLate(v) && !z;
    }

    // 去混淆评级： 低(20)
    public boolean shouldDropOutputBuffer(long v, long v1, boolean z) {
        return MediaCodecVideoRenderer.isBufferLate(v) && !z;
    }

    public boolean shouldForceRenderOutputBuffer(long v, long v1) {
        return MediaCodecVideoRenderer.isBufferLate(v) && v1 > 100000L;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo0) {
        return this.surface != null || this.shouldUseDummySurface(mediaCodecInfo0);
    }

    // 去混淆评级： 低(40)
    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo0) {
        return Util.SDK_INT >= 23 && !this.tunneling && !this.codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo0.name) && (!mediaCodecInfo0.secure || DummySurface.isSecureSupported(this.context));
    }

    public void skipOutputBuffer(MediaCodec mediaCodec0, int v, long v1) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec0.releaseOutputBuffer(v, false);
        TraceUtil.endSection();
        ++this.decoderCounters.skippedOutputBufferCount;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, Format format0) {
        int v = 0;
        if(!MimeTypes.isVideo(format0.sampleMimeType)) {
            return 0;
        }
        DrmInitData drmInitData0 = format0.drmInitData;
        List list0 = MediaCodecVideoRenderer.getDecoderInfos(mediaCodecSelector0, format0, drmInitData0 != null, false);
        if(drmInitData0 != null && list0.isEmpty()) {
            list0 = MediaCodecVideoRenderer.getDecoderInfos(mediaCodecSelector0, format0, false, false);
        }
        if(list0.isEmpty()) {
            return 1;
        }
        if(drmInitData0 != null && !FrameworkMediaCrypto.class.equals(format0.exoMediaCryptoType) && (format0.exoMediaCryptoType != null || !BaseRenderer.supportsFormatDrm(drmSessionManager0, drmInitData0))) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo0 = (MediaCodecInfo)list0.get(0);
        boolean z = mediaCodecInfo0.isFormatSupported(format0);
        int v1 = mediaCodecInfo0.isSeamlessAdaptationSupported(format0) ? 16 : 8;
        if(z) {
            List list1 = MediaCodecVideoRenderer.getDecoderInfos(mediaCodecSelector0, format0, drmInitData0 != null, true);
            if(!list1.isEmpty()) {
                MediaCodecInfo mediaCodecInfo1 = (MediaCodecInfo)list1.get(0);
                if(mediaCodecInfo1.isFormatSupported(format0) && mediaCodecInfo1.isSeamlessAdaptationSupported(format0)) {
                    v = 0x20;
                }
            }
        }
        return z ? 4 | v1 | v : 3 | v1 | v;
    }

    public void updateDroppedBufferCounters(int v) {
        this.decoderCounters.droppedBufferCount += v;
        this.droppedFrames += v;
        int v1 = this.consecutiveDroppedFrameCount + v;
        this.consecutiveDroppedFrameCount = v1;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(v1, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        if(this.maxDroppedFramesToNotify > 0 && this.droppedFrames >= this.maxDroppedFramesToNotify) {
            this.maybeNotifyDroppedFrames();
        }
    }
}

