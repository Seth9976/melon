package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import b3.Z;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaCodecRenderer extends BaseRenderer {
    public static class DecoderException extends Exception {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;

        public DecoderException(Throwable throwable0, MediaCodecInfo mediaCodecInfo0) {
            String s = null;
            String s1 = String.valueOf((mediaCodecInfo0 == null ? null : mediaCodecInfo0.name));
            super((s1.length() == 0 ? new String("Decoder failed: ") : "Decoder failed: " + s1), throwable0);
            this.codecInfo = mediaCodecInfo0;
            if(Util.SDK_INT >= 21) {
                s = DecoderException.getDiagnosticInfoV21(throwable0);
            }
            this.diagnosticInfo = s;
        }

        // 去混淆评级： 低(20)
        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable throwable0) {
            return throwable0 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException)throwable0).getDiagnosticInfo() : null;
        }
    }

    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = 0xFFFF3CB2;
        private static final int NO_SUITABLE_DECODER_ERROR = 0xFFFF3CB1;
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format0, Throwable throwable0, boolean z, int v) {
            String s = DecoderInitializationException.buildCustomDiagnosticInfo(v);
            this("Decoder init failed: [" + v + "], " + format0, throwable0, format0.sampleMimeType, z, null, s, null);
        }

        public DecoderInitializationException(Format format0, Throwable throwable0, boolean z, MediaCodecInfo mediaCodecInfo0) {
            String s = Util.SDK_INT < 21 ? null : DecoderInitializationException.getDiagnosticInfoV21(throwable0);
            this("Decoder init failed: " + mediaCodecInfo0.name + ", " + format0, throwable0, format0.sampleMimeType, z, mediaCodecInfo0, s, null);
        }

        private DecoderInitializationException(String s, Throwable throwable0, String s1, boolean z, MediaCodecInfo mediaCodecInfo0, String s2, DecoderInitializationException mediaCodecRenderer$DecoderInitializationException0) {
            super(s, throwable0);
            this.mimeType = s1;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo0;
            this.diagnosticInfo = s2;
            this.fallbackDecoderInitializationException = mediaCodecRenderer$DecoderInitializationException0;
        }

        public static DecoderInitializationException access$000(DecoderInitializationException mediaCodecRenderer$DecoderInitializationException0, DecoderInitializationException mediaCodecRenderer$DecoderInitializationException1) {
            return mediaCodecRenderer$DecoderInitializationException0.copyWithFallbackException(mediaCodecRenderer$DecoderInitializationException1);
        }

        // 去混淆评级： 低(40)
        private static String buildCustomDiagnosticInfo(int v) {
            return v >= 0 ? "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + Math.abs(v) : "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_" + Math.abs(v);
        }

        private DecoderInitializationException copyWithFallbackException(DecoderInitializationException mediaCodecRenderer$DecoderInitializationException0) {
            return new DecoderInitializationException(this.getMessage(), this.getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, mediaCodecRenderer$DecoderInitializationException0);
        }

        // 去混淆评级： 低(20)
        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable throwable0) {
            return throwable0 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException)throwable0).getDiagnosticInfo() : null;
        }
    }

    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = null;
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 0x20;
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    private static final int DRAIN_ACTION_FLUSH = 1;
    private static final int DRAIN_ACTION_NONE = 0;
    private static final int DRAIN_ACTION_REINITIALIZE = 3;
    private static final int DRAIN_ACTION_UPDATE_DRM_SESSION = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int DRAIN_STATE_WAIT_END_OF_STREAM = 2;
    protected static final int KEEP_CODEC_RESULT_NO = 0;
    protected static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 3;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_FLUSH = 1;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 2;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000L;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final String TAG = "MediaCodecRenderer";
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque availableCodecInfos;
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private Format codecFormat;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private final ArrayList decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private boolean drmResourcesAcquired;
    private final DrmSessionManager drmSessionManager;
    private final boolean enableDecoderFallback;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue formatQueue;
    private ByteBuffer[] inputBuffers;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private boolean pendingOutputEndOfStream;
    private final boolean playClearSamplesWithoutKeys;
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs;
    private float rendererOperatingRate;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean skipMediaCodecStopOnRelease;
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForFirstSyncSample;
    private boolean waitingForKeys;

    static {
        MediaCodecRenderer.ADAPTATION_WORKAROUND_BUFFER = new byte[]{0, 0, 1, 103, 66, (byte)0xC0, 11, -38, 37, (byte)0x90, 0, 0, 1, 104, -50, 15, 19, 0x20, 0, 0, 1, 101, -120, (byte)0x84, 13, -50, 0x71, 24, (byte)0xA0, 0, 0x2F, -65, 28, 49, -61, 39, 93, 120};
    }

    public MediaCodecRenderer(int v, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, boolean z1, float f) {
        super(v);
        this.mediaCodecSelector = (MediaCodecSelector)Assertions.checkNotNull(mediaCodecSelector0);
        this.drmSessionManager = drmSessionManager0;
        this.playClearSamplesWithoutKeys = z;
        this.enableDecoderFallback = z1;
        this.assumedMinimumCodecOperatingRate = f;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatQueue = new TimedValueQueue();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecOperatingRate = -1.0f;
        this.rendererOperatingRate = 1.0f;
        this.renderTimeLimitMs = 0x8000000000000001L;
    }

    public int canKeepCodec(MediaCodec mediaCodec0, MediaCodecInfo mediaCodecInfo0, Format format0, Format format1) {
        return 0;
    }

    // 去混淆评级： 低(27)
    private int codecAdaptationWorkaroundMode(String s) {
        int v = Util.SDK_INT;
        if(v <= 25 && "OMX.Exynos.avc.dec.secure".equals(s) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        return v >= 24 || !"OMX.Nvidia.h264.decode".equals(s) && !"OMX.Nvidia.h264.decode.secure".equals(s) || !"flounder".equals(Util.DEVICE) && !"flounder_lte".equals(Util.DEVICE) && !"grouper".equals(Util.DEVICE) && !"tilapia".equals(Util.DEVICE) ? 0 : 1;
    }

    // 去混淆评级： 低(20)
    private static boolean codecNeedsDiscardToSpsWorkaround(String s, Format format0) {
        return Util.SDK_INT < 21 && format0.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(s);
    }

    // 去混淆评级： 中等(60)
    private static boolean codecNeedsEosFlushWorkaround(String s) {
        return Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(s) || Util.SDK_INT <= 19 && (("hb2000".equals(Util.DEVICE) || "stvm8".equals(Util.DEVICE)) && ("OMX.amlogic.avc.decoder.awesome".equals(s) || "OMX.amlogic.avc.decoder.awesome.secure".equals(s)));
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String s) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(s);
    }

    // 去混淆评级： 中等(70)
    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo0) {
        return Util.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(mediaCodecInfo0.name) || Util.SDK_INT <= 17 && "OMX.allwinner.video.decoder.avc".equals(mediaCodecInfo0.name) || "Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo0.secure;
    }

    // 去混淆评级： 中等(60)
    private static boolean codecNeedsFlushWorkaround(String s) {
        return Util.SDK_INT < 18 || Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(s) || "OMX.SEC.avc.dec.secure".equals(s)) || Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(s) || "OMX.Exynos.avc.dec.secure".equals(s));
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String s, Format format0) {
        return Util.SDK_INT <= 18 && format0.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(s);
    }

    // 去混淆评级： 低(20)
    private static boolean codecNeedsReconfigureWorkaround(String s) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(s);
    }

    private static boolean codecNeedsSosFlushWorkaround(String s) {
        return Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(s);
    }

    public abstract void configureCodec(MediaCodecInfo arg1, MediaCodec arg2, Format arg3, MediaCrypto arg4, float arg5);

    public DecoderException createDecoderException(Throwable throwable0, MediaCodecInfo mediaCodecInfo0) {
        return new DecoderException(throwable0, mediaCodecInfo0);
    }

    private void drainAndFlushCodec() {
        if(this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 1;
        }
    }

    private void drainAndReinitializeCodec() {
        if(this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
            return;
        }
        this.reinitializeCodec();
    }

    private void drainAndUpdateCodecDrmSession() {
        if(Util.SDK_INT < 23) {
            this.drainAndReinitializeCodec();
            return;
        }
        if(this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 2;
            return;
        }
        this.updateDrmSessionOrReinitializeCodecV23();
    }

    private boolean drainOutputBuffer(long v, long v1) {
        boolean z;
        int v2;
        if(!this.hasOutputBuffer()) {
            if(!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
                v2 = this.codec.dequeueOutputBuffer(this.outputBufferInfo, 0L);
            }
            else {
                try {
                    v2 = this.codec.dequeueOutputBuffer(this.outputBufferInfo, 0L);
                }
                catch(IllegalStateException unused_ex) {
                    this.processEndOfStream();
                    if(this.outputStreamEnded) {
                        this.releaseCodec();
                    }
                    return false;
                }
            }
            if(v2 < 0) {
                switch(v2) {
                    case -3: {
                        this.processOutputBuffersChanged();
                        return true;
                    }
                    case -2: {
                        this.processOutputFormat();
                        return true;
                    }
                    default: {
                        if(this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecDrainState == 2)) {
                            this.processEndOfStream();
                        }
                        return false;
                    }
                }
            }
            if(this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                this.codec.releaseOutputBuffer(v2, false);
                return true;
            }
            if(this.outputBufferInfo.size == 0 && (this.outputBufferInfo.flags & 4) != 0) {
                this.processEndOfStream();
                return false;
            }
            this.outputIndex = v2;
            ByteBuffer byteBuffer0 = this.getOutputBuffer(v2);
            this.outputBuffer = byteBuffer0;
            if(byteBuffer0 != null) {
                byteBuffer0.position(this.outputBufferInfo.offset);
                this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
            }
            this.isDecodeOnlyOutputBuffer = this.isDecodeOnlyBuffer(this.outputBufferInfo.presentationTimeUs);
            this.isLastOutputBuffer = this.lastBufferInStreamPresentationTimeUs == this.outputBufferInfo.presentationTimeUs;
            this.updateOutputFormatForTime(this.outputBufferInfo.presentationTimeUs);
        }
        if(!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
            z = this.processOutputBuffer(v, v1, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
        }
        else {
            try {
                z = this.processOutputBuffer(v, v1, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
            }
            catch(IllegalStateException unused_ex) {
                this.processEndOfStream();
                if(this.outputStreamEnded) {
                    this.releaseCodec();
                }
                return false;
            }
        }
        if(z) {
            this.onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            boolean z1 = (this.outputBufferInfo.flags & 4) != 0;
            this.resetOutputBuffer();
            if(!z1) {
                return true;
            }
            this.processEndOfStream();
        }
        return false;
    }

    public void experimental_setRenderTimeLimitMs(long v) {
        this.renderTimeLimitMs = v;
    }

    public void experimental_setSkipMediaCodecStopOnRelease(boolean z) {
        this.skipMediaCodecStopOnRelease = z;
    }

    private boolean feedInputBuffer() {
        int v2;
        int v1;
        MediaCodec mediaCodec0 = this.codec;
        if(mediaCodec0 != null && this.codecDrainState != 2 && !this.inputStreamEnded) {
            if(this.inputIndex < 0) {
                int v = mediaCodec0.dequeueInputBuffer(0L);
                this.inputIndex = v;
                if(v < 0) {
                    return false;
                }
                this.buffer.data = this.getInputBuffer(v);
                this.buffer.clear();
            }
            if(this.codecDrainState == 1) {
                if(!this.codecNeedsEosPropagation) {
                    this.codecReceivedEos = true;
                    this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    this.resetInputBuffer();
                }
                this.codecDrainState = 2;
                return false;
            }
            if(this.codecNeedsAdaptationWorkaroundBuffer) {
                this.codecNeedsAdaptationWorkaroundBuffer = false;
                this.buffer.data.put(MediaCodecRenderer.ADAPTATION_WORKAROUND_BUFFER);
                this.codec.queueInputBuffer(this.inputIndex, 0, MediaCodecRenderer.ADAPTATION_WORKAROUND_BUFFER.length, 0L, 0);
                this.resetInputBuffer();
                this.codecReceivedBuffers = true;
                return true;
            }
            FormatHolder formatHolder0 = this.getFormatHolder();
            if(this.waitingForKeys) {
                v1 = -4;
                v2 = 0;
            }
            else {
                if(this.codecReconfigurationState == 1) {
                    for(int v3 = 0; v3 < this.codecFormat.initializationData.size(); ++v3) {
                        byte[] arr_b = (byte[])this.codecFormat.initializationData.get(v3);
                        this.buffer.data.put(arr_b);
                    }
                    this.codecReconfigurationState = 2;
                }
                v2 = this.buffer.data.position();
                v1 = this.readSource(formatHolder0, this.buffer, false);
            }
            if(this.hasReadStreamToEnd()) {
                this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
            }
            switch(v1) {
                case -5: {
                    if(this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    this.onInputFormatChanged(formatHolder0);
                    return true;
                }
                case -3: {
                    return false;
                }
                default: {
                    if(this.buffer.isEndOfStream()) {
                        if(this.codecReconfigurationState == 2) {
                            this.buffer.clear();
                            this.codecReconfigurationState = 1;
                        }
                        this.inputStreamEnded = true;
                        if(!this.codecReceivedBuffers) {
                            this.processEndOfStream();
                            return false;
                        }
                        try {
                            if(!this.codecNeedsEosPropagation) {
                                this.codecReceivedEos = true;
                                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                                this.resetInputBuffer();
                            }
                            return false;
                        }
                        catch(MediaCodec.CryptoException mediaCodec$CryptoException0) {
                            throw this.createRendererException(mediaCodec$CryptoException0, this.inputFormat);
                        }
                    }
                    if(this.waitingForFirstSyncSample && !this.buffer.isKeyFrame()) {
                        this.buffer.clear();
                        if(this.codecReconfigurationState == 2) {
                            this.codecReconfigurationState = 1;
                        }
                        return true;
                    }
                    this.waitingForFirstSyncSample = false;
                    boolean z = this.buffer.isEncrypted();
                    boolean z1 = this.shouldWaitForKeys(z);
                    this.waitingForKeys = z1;
                    if(z1) {
                        return false;
                    }
                    if(this.codecNeedsDiscardToSpsWorkaround && !z) {
                        NalUnitUtil.discardToSps(this.buffer.data);
                        if(this.buffer.data.position() == 0) {
                            return true;
                        }
                        this.codecNeedsDiscardToSpsWorkaround = false;
                    }
                    try {
                        long v4 = this.buffer.timeUs;
                        if(this.buffer.isDecodeOnly()) {
                            this.decodeOnlyPresentationTimestamps.add(v4);
                        }
                        if(this.waitingForFirstSampleInFormat) {
                            this.formatQueue.add(v4, this.inputFormat);
                            this.waitingForFirstSampleInFormat = false;
                        }
                        this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, v4);
                        this.buffer.flip();
                        if(this.buffer.hasSupplementalData()) {
                            this.handleInputBufferSupplementalData(this.buffer);
                        }
                        this.onQueueInputBuffer(this.buffer);
                        if(z) {
                            MediaCodec.CryptoInfo mediaCodec$CryptoInfo0 = MediaCodecRenderer.getFrameworkCryptoInfo(this.buffer, v2);
                            this.codec.queueSecureInputBuffer(this.inputIndex, 0, mediaCodec$CryptoInfo0, v4, 0);
                        }
                        else {
                            this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), v4, 0);
                        }
                        this.resetInputBuffer();
                        this.codecReceivedBuffers = true;
                        this.codecReconfigurationState = 0;
                        ++this.decoderCounters.inputBufferCount;
                        return true;
                    }
                    catch(MediaCodec.CryptoException mediaCodec$CryptoException1) {
                    }
                    throw this.createRendererException(mediaCodec$CryptoException1, this.inputFormat);
                }
            }
        }
        return false;
    }

    public final boolean flushOrReinitializeCodec() {
        boolean z = this.flushOrReleaseCodec();
        if(z) {
            this.maybeInitCodec();
        }
        return z;
    }

    public boolean flushOrReleaseCodec() {
        MediaCodec mediaCodec0 = this.codec;
        if(mediaCodec0 == null) {
            return false;
        }
        if(this.codecDrainAction != 3 && !this.codecNeedsFlushWorkaround && (!this.codecNeedsSosFlushWorkaround || this.codecHasOutputMediaFormat) && (!this.codecNeedsEosFlushWorkaround || !this.codecReceivedEos)) {
            mediaCodec0.flush();
            this.resetInputBuffer();
            this.resetOutputBuffer();
            this.codecHotswapDeadlineMs = 0x8000000000000001L;
            this.codecReceivedEos = false;
            this.codecReceivedBuffers = false;
            this.waitingForFirstSyncSample = true;
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
            this.isDecodeOnlyOutputBuffer = false;
            this.isLastOutputBuffer = false;
            this.waitingForKeys = false;
            this.decodeOnlyPresentationTimestamps.clear();
            this.largestQueuedPresentationTimeUs = 0x8000000000000001L;
            this.lastBufferInStreamPresentationTimeUs = 0x8000000000000001L;
            this.codecDrainState = 0;
            this.codecDrainAction = 0;
            this.codecReconfigurationState = this.codecReconfigured;
            return false;
        }
        this.releaseCodec();
        return true;
    }

    private List getAvailableCodecInfos(boolean z) {
        List list0 = this.getDecoderInfos(this.mediaCodecSelector, this.inputFormat, z);
        if(list0.isEmpty() && z) {
            List list1 = this.getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if(!list1.isEmpty()) {
                String s = this.inputFormat.sampleMimeType;
                String s1 = String.valueOf(list1);
                StringBuilder stringBuilder0 = Z.o(s1.length() + Z.e(99, s), "Drm session requires secure decoder for ", s, ", but no secure decoder available. Trying to proceed with ", s1);
                stringBuilder0.append(".");
                Log.w("MediaCodecRenderer", stringBuilder0.toString());
            }
            return list1;
        }
        return list0;
    }

    public final MediaCodec getCodec() {
        return this.codec;
    }

    private void getCodecBuffers(MediaCodec mediaCodec0) {
        if(Util.SDK_INT < 21) {
            this.inputBuffers = mediaCodec0.getInputBuffers();
            this.outputBuffers = mediaCodec0.getOutputBuffers();
        }
    }

    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRateV23(float f, Format format0, Format[] arr_format) {
        return -1.0f;
    }

    public abstract List getDecoderInfos(MediaCodecSelector arg1, Format arg2, boolean arg3);

    public long getDequeueOutputBufferTimeoutUs() [...] // Inlined contents

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer0, int v) {
        MediaCodec.CryptoInfo mediaCodec$CryptoInfo0 = decoderInputBuffer0.cryptoInfo.getFrameworkCryptoInfo();
        if(v == 0) {
            return mediaCodec$CryptoInfo0;
        }
        if(mediaCodec$CryptoInfo0.numBytesOfClearData == null) {
            mediaCodec$CryptoInfo0.numBytesOfClearData = new int[1];
        }
        mediaCodec$CryptoInfo0.numBytesOfClearData[0] += v;
        return mediaCodec$CryptoInfo0;
    }

    private ByteBuffer getInputBuffer(int v) {
        return Util.SDK_INT < 21 ? this.inputBuffers[v] : this.codec.getInputBuffer(v);
    }

    private ByteBuffer getOutputBuffer(int v) {
        return Util.SDK_INT < 21 ? this.outputBuffers[v] : this.codec.getOutputBuffer(v);
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer0) {
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void initCodec(MediaCodecInfo mediaCodecInfo0, MediaCrypto mediaCrypto0) {
        long v1;
        long v;
        MediaCodec mediaCodec0;
        String s = mediaCodecInfo0.name;
        float f = Util.SDK_INT >= 23 ? this.getCodecOperatingRateV23(this.rendererOperatingRate, this.inputFormat, this.getStreamFormats()) : -1.0f;
        float f1 = f <= this.assumedMinimumCodecOperatingRate ? -1.0f : f;
        try {
            mediaCodec0 = null;
            v = SystemClock.elapsedRealtime();
            String s1 = String.valueOf(s);
            TraceUtil.beginSection((s1.length() == 0 ? new String("createCodec:") : "createCodec:" + s1));
            mediaCodec0 = MediaCodec.createByCodecName(s);
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            this.configureCodec(mediaCodecInfo0, mediaCodec0, this.inputFormat, mediaCrypto0, f1);
            TraceUtil.endSection();
            TraceUtil.beginSection("startCodec");
            mediaCodec0.start();
            TraceUtil.endSection();
            v1 = SystemClock.elapsedRealtime();
            this.getCodecBuffers(mediaCodec0);
            goto label_23;
        label_19:
            if(mediaCodec0 == null) {
                throw exception0;
            }
        }
        catch(Exception exception0) {
            goto label_19;
        }
        this.resetCodecBuffers();
        mediaCodec0.release();
        throw exception0;
    label_23:
        this.codec = mediaCodec0;
        this.codecInfo = mediaCodecInfo0;
        this.codecOperatingRate = f1;
        this.codecFormat = this.inputFormat;
        this.codecAdaptationWorkaroundMode = this.codecAdaptationWorkaroundMode(s);
        this.codecNeedsReconfigureWorkaround = MediaCodecRenderer.codecNeedsReconfigureWorkaround(s);
        this.codecNeedsDiscardToSpsWorkaround = MediaCodecRenderer.codecNeedsDiscardToSpsWorkaround(s, this.codecFormat);
        this.codecNeedsFlushWorkaround = MediaCodecRenderer.codecNeedsFlushWorkaround(s);
        this.codecNeedsSosFlushWorkaround = MediaCodecRenderer.codecNeedsSosFlushWorkaround(s);
        this.codecNeedsEosFlushWorkaround = MediaCodecRenderer.codecNeedsEosFlushWorkaround(s);
        this.codecNeedsEosOutputExceptionWorkaround = MediaCodecRenderer.codecNeedsEosOutputExceptionWorkaround(s);
        this.codecNeedsMonoChannelCountWorkaround = MediaCodecRenderer.codecNeedsMonoChannelCountWorkaround(s, this.codecFormat);
        this.codecNeedsEosPropagation = MediaCodecRenderer.codecNeedsEosPropagationWorkaround(mediaCodecInfo0) || this.getCodecNeedsEosPropagation();
        this.resetInputBuffer();
        this.resetOutputBuffer();
        this.codecHotswapDeadlineMs = this.getState() == 2 ? SystemClock.elapsedRealtime() + 1000L : 0x8000000000000001L;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.largestQueuedPresentationTimeUs = 0x8000000000000001L;
        this.lastBufferInStreamPresentationTimeUs = 0x8000000000000001L;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.waitingForFirstSyncSample = true;
        ++this.decoderCounters.decoderInitCount;
        this.onCodecInitialized(s, v1, v1 - v);
    }

    private boolean isDecodeOnlyBuffer(long v) {
        int v1 = this.decodeOnlyPresentationTimestamps.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            if(((long)(((Long)this.decodeOnlyPresentationTimestamps.get(v2)))) == v) {
                this.decodeOnlyPresentationTimestamps.remove(v2);
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    private static boolean isMediaCodecException(IllegalStateException illegalStateException0) {
        if(Util.SDK_INT >= 21 && MediaCodecRenderer.isMediaCodecExceptionV21(illegalStateException0)) {
            return true;
        }
        StackTraceElement[] arr_stackTraceElement = illegalStateException0.getStackTrace();
        return arr_stackTraceElement.length > 0 && arr_stackTraceElement[0].getClassName().equals("android.media.MediaCodec");
    }

    @TargetApi(21)
    private static boolean isMediaCodecExceptionV21(IllegalStateException illegalStateException0) {
        return illegalStateException0 instanceof MediaCodec.CodecException;
    }

    // 去混淆评级： 低(30)
    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.inputFormat != null && !this.waitingForKeys && (this.isSourceReady() || this.hasOutputBuffer() || this.codecHotswapDeadlineMs != 0x8000000000000001L && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs);
    }

    public final void maybeInitCodec() {
        MediaCrypto mediaCrypto0;
        if(this.codec == null && this.inputFormat != null) {
            this.setCodecDrmSession(this.sourceDrmSession);
            String s = this.inputFormat.sampleMimeType;
            DrmSession drmSession0 = this.codecDrmSession;
            if(drmSession0 == null) {
                goto label_20;
            }
            if(this.mediaCrypto != null) {
                goto label_16;
            }
            FrameworkMediaCrypto frameworkMediaCrypto0 = (FrameworkMediaCrypto)drmSession0.getMediaCrypto();
            if(frameworkMediaCrypto0 != null) {
                goto label_10;
            }
            if(this.codecDrmSession.getError() != null) {
                goto label_16;
                try {
                label_10:
                    mediaCrypto0 = new MediaCrypto(frameworkMediaCrypto0.uuid, frameworkMediaCrypto0.sessionId);
                    this.mediaCrypto = mediaCrypto0;
                }
                catch(MediaCryptoException mediaCryptoException0) {
                    throw this.createRendererException(mediaCryptoException0, this.inputFormat);
                }
                this.mediaCryptoRequiresSecureDecoder = !frameworkMediaCrypto0.forceAllowInsecureDecoderComponents && mediaCrypto0.requiresSecureDecoderComponent(s);
            label_16:
                if(FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                    switch(this.codecDrmSession.getState()) {
                        case 1: {
                            throw this.createRendererException(this.codecDrmSession.getError(), this.inputFormat);
                        }
                        case 4: {
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                }
                try {
                label_20:
                    this.maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
                }
                catch(DecoderInitializationException mediaCodecRenderer$DecoderInitializationException0) {
                    throw this.createRendererException(mediaCodecRenderer$DecoderInitializationException0, this.inputFormat);
                }
            }
        }
    }

    private void maybeInitCodecWithFallback(MediaCrypto mediaCrypto0, boolean z) {
        if(this.availableCodecInfos == null) {
            try {
                List list0 = this.getAvailableCodecInfos(z);
                ArrayDeque arrayDeque0 = new ArrayDeque();
                this.availableCodecInfos = arrayDeque0;
                if(this.enableDecoderFallback) {
                    arrayDeque0.addAll(list0);
                }
                else if(!list0.isEmpty()) {
                    this.availableCodecInfos.add(((MediaCodecInfo)list0.get(0)));
                }
                this.preferredDecoderInitializationException = null;
                goto label_13;
            }
            catch(DecoderQueryException mediaCodecUtil$DecoderQueryException0) {
            }
            throw new DecoderInitializationException(this.inputFormat, mediaCodecUtil$DecoderQueryException0, z, 0xFFFF3CB2);
        }
    label_13:
        if(this.availableCodecInfos.isEmpty()) {
            throw new DecoderInitializationException(this.inputFormat, null, z, 0xFFFF3CB1);
        }
        while(this.codec == null) {
            MediaCodecInfo mediaCodecInfo0 = (MediaCodecInfo)this.availableCodecInfos.peekFirst();
            if(!this.shouldInitCodec(mediaCodecInfo0)) {
                return;
            }
            try {
                this.initCodec(mediaCodecInfo0, mediaCrypto0);
            }
            catch(Exception exception0) {
                Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo0, exception0);
                this.availableCodecInfos.removeFirst();
                DecoderInitializationException mediaCodecRenderer$DecoderInitializationException0 = new DecoderInitializationException(this.inputFormat, exception0, z, mediaCodecInfo0);
                this.preferredDecoderInitializationException = this.preferredDecoderInitializationException == null ? mediaCodecRenderer$DecoderInitializationException0 : DecoderInitializationException.access$000(this.preferredDecoderInitializationException, mediaCodecRenderer$DecoderInitializationException0);
                if(this.availableCodecInfos.isEmpty()) {
                    throw this.preferredDecoderInitializationException;
                }
                if(false) {
                    break;
                }
            }
        }
        this.availableCodecInfos = null;
    }

    private static boolean maybeRequiresSecureDecoder(DrmSession drmSession0, Format format0) {
        MediaCrypto mediaCrypto0;
        FrameworkMediaCrypto frameworkMediaCrypto0 = (FrameworkMediaCrypto)drmSession0.getMediaCrypto();
        if(frameworkMediaCrypto0 == null) {
            return true;
        }
        if(frameworkMediaCrypto0.forceAllowInsecureDecoderComponents) {
            return false;
        }
        try {
            mediaCrypto0 = new MediaCrypto(frameworkMediaCrypto0.uuid, frameworkMediaCrypto0.sessionId);
        }
        catch(MediaCryptoException unused_ex) {
            return true;
        }
        try {
            return mediaCrypto0.requiresSecureDecoderComponent(format0.sampleMimeType);
        }
        finally {
            mediaCrypto0.release();
        }
    }

    public void onCodecInitialized(String s, long v, long v1) {
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.inputFormat = null;
        if(this.sourceDrmSession == null && this.codecDrmSession == null) {
            this.flushOrReleaseCodec();
            return;
        }
        this.onReset();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) {
        DrmSessionManager drmSessionManager0 = this.drmSessionManager;
        if(drmSessionManager0 != null && !this.drmResourcesAcquired) {
            this.drmResourcesAcquired = true;
            drmSessionManager0.prepare();
        }
        this.decoderCounters = new DecoderCounters();
    }

    public void onInputFormatChanged(FormatHolder formatHolder0) {
        boolean z = true;
        this.waitingForFirstSampleInFormat = true;
        Format format0 = (Format)Assertions.checkNotNull(formatHolder0.format);
        if(formatHolder0.includesDrmSession) {
            this.setSourceDrmSession(formatHolder0.drmSession);
        }
        else {
            this.sourceDrmSession = this.getUpdatedSourceDrmSession(this.inputFormat, format0, this.drmSessionManager, this.sourceDrmSession);
        }
        this.inputFormat = format0;
        if(this.codec == null) {
            this.maybeInitCodec();
            return;
        }
        if(this.sourceDrmSession == null && this.codecDrmSession != null || this.sourceDrmSession != null && this.codecDrmSession == null || this.sourceDrmSession != this.codecDrmSession && !this.codecInfo.secure && MediaCodecRenderer.maybeRequiresSecureDecoder(this.sourceDrmSession, format0) || Util.SDK_INT < 23 && this.sourceDrmSession != this.codecDrmSession) {
            this.drainAndReinitializeCodec();
            return;
        }
        switch(this.canKeepCodec(this.codec, this.codecInfo, this.codecFormat, format0)) {
            case 0: {
                this.drainAndReinitializeCodec();
                return;
            }
            case 1: {
                this.codecFormat = format0;
                this.updateCodecOperatingRate();
                if(this.sourceDrmSession != this.codecDrmSession) {
                    this.drainAndUpdateCodecDrmSession();
                    return;
                }
                this.drainAndFlushCodec();
                return;
            }
            case 2: {
                if(this.codecNeedsReconfigureWorkaround) {
                    this.drainAndReinitializeCodec();
                    return;
                }
                this.codecReconfigured = true;
                this.codecReconfigurationState = 1;
                if(this.codecAdaptationWorkaroundMode != 2 && (this.codecAdaptationWorkaroundMode != 1 || (format0.width != this.codecFormat.width || format0.height != this.codecFormat.height))) {
                    z = false;
                }
                this.codecNeedsAdaptationWorkaroundBuffer = z;
                this.codecFormat = format0;
                this.updateCodecOperatingRate();
                if(this.sourceDrmSession != this.codecDrmSession) {
                    this.drainAndUpdateCodecDrmSession();
                    return;
                }
                break;
            }
            case 3: {
                this.codecFormat = format0;
                this.updateCodecOperatingRate();
                if(this.sourceDrmSession != this.codecDrmSession) {
                    this.drainAndUpdateCodecDrmSession();
                    return;
                }
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec0, MediaFormat mediaFormat0) {
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        this.flushOrReinitializeCodec();
        this.formatQueue.clear();
    }

    public void onProcessedOutputBuffer(long v) {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer0) {
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            this.releaseCodec();
        }
        finally {
            this.setSourceDrmSession(null);
        }
        DrmSessionManager drmSessionManager0 = this.drmSessionManager;
        if(drmSessionManager0 != null && this.drmResourcesAcquired) {
            this.drmResourcesAcquired = false;
            drmSessionManager0.release();
        }
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    private void processEndOfStream() {
        switch(this.codecDrainAction) {
            case 1: {
                this.flushOrReinitializeCodec();
                return;
            }
            case 2: {
                this.updateDrmSessionOrReinitializeCodecV23();
                return;
            }
            case 3: {
                this.reinitializeCodec();
                return;
            }
            default: {
                this.outputStreamEnded = true;
                this.renderToEndOfStream();
            }
        }
    }

    public abstract boolean processOutputBuffer(long arg1, long arg2, MediaCodec arg3, ByteBuffer arg4, int arg5, int arg6, long arg7, boolean arg8, boolean arg9, Format arg10);

    private void processOutputBuffersChanged() {
        if(Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processOutputFormat() {
        this.codecHasOutputMediaFormat = true;
        MediaFormat mediaFormat0 = this.codec.getOutputFormat();
        if(this.codecAdaptationWorkaroundMode != 0 && mediaFormat0.getInteger("width") == 0x20 && mediaFormat0.getInteger("height") == 0x20) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if(this.codecNeedsMonoChannelCountWorkaround) {
            mediaFormat0.setInteger("channel-count", 1);
        }
        this.onOutputFormatChanged(this.codec, mediaFormat0);
    }

    private boolean readToFlagsOnlyBuffer(boolean z) {
        FormatHolder formatHolder0 = this.getFormatHolder();
        this.flagsOnlyBuffer.clear();
        int v = this.readSource(formatHolder0, this.flagsOnlyBuffer, z);
        if(v == -5) {
            this.onInputFormatChanged(formatHolder0);
            return true;
        }
        if(v == -4 && this.flagsOnlyBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.processEndOfStream();
        }
        return false;
    }

    private void reinitializeCodec() {
        this.releaseCodec();
        this.maybeInitCodec();
    }

    public void releaseCodec() {
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecFormat = null;
        this.codecHasOutputMediaFormat = false;
        this.resetInputBuffer();
        this.resetOutputBuffer();
        this.resetCodecBuffers();
        this.waitingForKeys = false;
        this.codecHotswapDeadlineMs = 0x8000000000000001L;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = 0x8000000000000001L;
        this.lastBufferInStreamPresentationTimeUs = 0x8000000000000001L;
        try {
            MediaCodec mediaCodec0 = this.codec;
            if(mediaCodec0 != null) {
                ++this.decoderCounters.decoderReleaseCount;
                try {
                    if(!this.skipMediaCodecStopOnRelease) {
                        mediaCodec0.stop();
                    }
                }
                finally {
                    this.codec.release();
                }
            }
        }
        catch(Throwable throwable0) {
            try {
                this.codec = null;
                MediaCrypto mediaCrypto0 = this.mediaCrypto;
                if(mediaCrypto0 != null) {
                    mediaCrypto0.release();
                }
            }
            throw throwable0;
        }
        finally {
            this.mediaCrypto = null;
            this.mediaCryptoRequiresSecureDecoder = false;
            this.setCodecDrmSession(null);
        }
        this.codec = null;
        MediaCrypto mediaCrypto1 = this.mediaCrypto;
        if(mediaCrypto1 != null) {
            mediaCrypto1.release();
        }
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public void render(long v, long v1) {
        if(this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            this.processEndOfStream();
        }
        try {
            if(this.outputStreamEnded) {
                this.renderToEndOfStream();
                return;
            }
            if(this.inputFormat == null && !this.readToFlagsOnlyBuffer(true)) {
                return;
            }
            this.maybeInitCodec();
            if(this.codec == null) {
                DecoderCounters decoderCounters0 = this.decoderCounters;
                decoderCounters0.skippedInputBufferCount += this.skipSource(v);
                this.readToFlagsOnlyBuffer(false);
                return;
            }
            long v2 = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("drainAndFeed");
            while(true) {
                if(!this.drainOutputBuffer(v, v1)) {
                    while(true) {
                        if(!this.feedInputBuffer() || !this.shouldContinueFeeding(v2)) {
                            TraceUtil.endSection();
                            return;
                        }
                    }
                }
            }
        }
        catch(IllegalStateException illegalStateException0) {
        }
        if(!MediaCodecRenderer.isMediaCodecException(illegalStateException0)) {
            throw illegalStateException0;
        }
        throw this.createRendererException(illegalStateException0, this.inputFormat);
    }

    public void renderToEndOfStream() {
    }

    private void resetCodecBuffers() {
        if(Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setCodecDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.codecDrmSession, drmSession0);
        this.codecDrmSession = drmSession0;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void setOperatingRate(float f) {
        this.rendererOperatingRate = f;
        if(this.codec != null && this.codecDrainAction != 3 && this.getState() != 0) {
            this.updateCodecOperatingRate();
        }
    }

    public final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    private void setSourceDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession0);
        this.sourceDrmSession = drmSession0;
    }

    private boolean shouldContinueFeeding(long v) {
        return this.renderTimeLimitMs == 0x8000000000000001L || SystemClock.elapsedRealtime() - v < this.renderTimeLimitMs;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo0) {
        return true;
    }

    private boolean shouldWaitForKeys(boolean z) {
        if(this.codecDrmSession != null && (z || !this.playClearSamplesWithoutKeys && !this.codecDrmSession.playClearSamplesWithoutKeys())) {
            switch(this.codecDrmSession.getState()) {
                case 1: {
                    throw this.createRendererException(this.codecDrmSession.getError(), this.inputFormat);
                }
                case 4: {
                    return false;
                }
                default: {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format0) {
        try {
            return this.supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format0);
        }
        catch(DecoderQueryException mediaCodecUtil$DecoderQueryException0) {
            throw this.createRendererException(mediaCodecUtil$DecoderQueryException0, format0);
        }
    }

    public abstract int supportsFormat(MediaCodecSelector arg1, DrmSessionManager arg2, Format arg3);

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    private void updateCodecOperatingRate() {
        if(Util.SDK_INT >= 23) {
            float f = this.getCodecOperatingRateV23(this.rendererOperatingRate, this.codecFormat, this.getStreamFormats());
            float f1 = this.codecOperatingRate;
            if(f1 != f) {
                if(f == -1.0f) {
                    this.drainAndReinitializeCodec();
                    return;
                }
                if(f1 != -1.0f || f > this.assumedMinimumCodecOperatingRate) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putFloat("operating-rate", f);
                    this.codec.setParameters(bundle0);
                    this.codecOperatingRate = f;
                }
            }
        }
    }

    @TargetApi(23)
    private void updateDrmSessionOrReinitializeCodecV23() {
        FrameworkMediaCrypto frameworkMediaCrypto0 = (FrameworkMediaCrypto)this.sourceDrmSession.getMediaCrypto();
        if(frameworkMediaCrypto0 == null) {
            this.reinitializeCodec();
            return;
        }
        if(C.PLAYREADY_UUID.equals(frameworkMediaCrypto0.uuid)) {
            this.reinitializeCodec();
            return;
        }
        if(this.flushOrReinitializeCodec()) {
            return;
        }
        try {
            this.mediaCrypto.setMediaDrmSession(frameworkMediaCrypto0.sessionId);
        }
        catch(MediaCryptoException mediaCryptoException0) {
            throw this.createRendererException(mediaCryptoException0, this.inputFormat);
        }
        this.setCodecDrmSession(this.sourceDrmSession);
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
    }

    public final Format updateOutputFormatForTime(long v) {
        Format format0 = (Format)this.formatQueue.pollFloor(v);
        if(format0 != null) {
            this.outputFormat = format0;
        }
        return format0;
    }
}

