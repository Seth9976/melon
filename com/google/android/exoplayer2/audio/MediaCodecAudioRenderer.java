package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    final class AudioSinkListener implements Listener {
        private AudioSinkListener() {
        }

        public AudioSinkListener(com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.1 mediaCodecAudioRenderer$10) {
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onAudioSessionId(int v) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(v);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onUnderrun(int v, long v1, long v2) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(v, v1, v2);
        }
    }

    private static final int MAX_PENDING_STREAM_CHANGE_COUNT = 10;
    private static final String TAG = "MediaCodecAudioRenderer";
    private static final String VIVO_BITS_PER_SAMPLE_KEY = "v-bits-per-sample";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private final Context context;
    private long currentPositionUs;
    private final EventDispatcher eventDispatcher;
    private Format inputFormat;
    private long lastInputTimeUs;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;
    private int pendingStreamChangeCount;
    private final long[] pendingStreamChangeTimesUs;

    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0) {
        this(context0, mediaCodecSelector0, null, false);
    }

    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, Handler handler0, AudioRendererEventListener audioRendererEventListener0) {
        this(context0, mediaCodecSelector0, null, false, handler0, audioRendererEventListener0);
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z) {
        this(context0, mediaCodecSelector0, drmSessionManager0, z, null, null);
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, Handler handler0, AudioRendererEventListener audioRendererEventListener0) {
        this(context0, mediaCodecSelector0, drmSessionManager0, z, handler0, audioRendererEventListener0, null, new AudioProcessor[0]);
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioCapabilities audioCapabilities0, AudioProcessor[] arr_audioProcessor) {
        this(context0, mediaCodecSelector0, drmSessionManager0, z, handler0, audioRendererEventListener0, new DefaultAudioSink(audioCapabilities0, arr_audioProcessor));
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioSink audioSink0) {
        this(context0, mediaCodecSelector0, drmSessionManager0, z, false, handler0, audioRendererEventListener0, audioSink0);
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, boolean z1, Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioSink audioSink0) {
        super(1, mediaCodecSelector0, drmSessionManager0, z, z1, 44100.0f);
        this.context = context0.getApplicationContext();
        this.audioSink = audioSink0;
        this.lastInputTimeUs = 0x8000000000000001L;
        this.pendingStreamChangeTimesUs = new long[10];
        this.eventDispatcher = new EventDispatcher(handler0, audioRendererEventListener0);
        audioSink0.setListener(new AudioSinkListener(this, null));
    }

    public MediaCodecAudioRenderer(Context context0, MediaCodecSelector mediaCodecSelector0, boolean z, Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioSink audioSink0) {
        this(context0, mediaCodecSelector0, null, false, z, handler0, audioRendererEventListener0, audioSink0);
    }

    public boolean allowPassthrough(int v, String s) {
        return this.getPassthroughEncoding(v, s) != 0;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(MediaCodec mediaCodec0, MediaCodecInfo mediaCodecInfo0, Format format0, Format format1) {
        if(this.getCodecMaxInputSize(mediaCodecInfo0, format1) <= this.codecMaxInputSize && format0.encoderDelay == 0 && format0.encoderPadding == 0 && format1.encoderDelay == 0 && format1.encoderPadding == 0) {
            if(mediaCodecInfo0.isSeamlessAdaptationSupported(format0, format1, true)) {
                return 3;
            }
            return this.canKeepCodecWithFlush(format0, format1) ? 1 : 0;
        }
        return 0;
    }

    // 去混淆评级： 低(30)
    public boolean canKeepCodecWithFlush(Format format0, Format format1) {
        return Util.areEqual(format0.sampleMimeType, format1.sampleMimeType) && format0.channelCount == format1.channelCount && format0.sampleRate == format1.sampleRate && format0.pcmEncoding == format1.pcmEncoding && format0.initializationDataEquals(format1) && !"audio/opus".equals(format0.sampleMimeType);
    }

    // 去混淆评级： 中等(50)
    private static boolean codecNeedsDiscardChannelsWorkaround(String s) {
        return Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(s) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("herolte") || Util.DEVICE.startsWith("heroqlte"));
    }

    // 去混淆评级： 中等(80)
    private static boolean codecNeedsEosBufferTimestampWorkaround(String s) {
        return Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(s) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("baffin") || Util.DEVICE.startsWith("grand") || Util.DEVICE.startsWith("fortuna") || Util.DEVICE.startsWith("gprimelte") || Util.DEVICE.startsWith("j2y18lte") || Util.DEVICE.startsWith("ms01"));
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo0, MediaCodec mediaCodec0, Format format0, MediaCrypto mediaCrypto0, float f) {
        this.codecMaxInputSize = this.getCodecMaxInputSize(mediaCodecInfo0, format0, this.getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = MediaCodecAudioRenderer.codecNeedsDiscardChannelsWorkaround(mediaCodecInfo0.name);
        this.codecNeedsEosBufferTimestampWorkaround = MediaCodecAudioRenderer.codecNeedsEosBufferTimestampWorkaround(mediaCodecInfo0.name);
        this.passthroughEnabled = mediaCodecInfo0.passthrough;
        MediaFormat mediaFormat0 = this.getMediaFormat(format0, (mediaCodecInfo0.passthrough ? "audio/raw" : mediaCodecInfo0.codecMimeType), this.codecMaxInputSize, f);
        mediaCodec0.configure(mediaFormat0, null, mediaCrypto0, 0);
        if(this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat0;
            mediaFormat0.setString("mime", format0.sampleMimeType);
            return;
        }
        this.passthroughMediaFormat = null;
    }

    // 去混淆评级： 低(20)
    private static boolean deviceDoesntSupportOperatingRate() {
        return Util.SDK_INT == 23 && ("ZTE B2017G".equals(Util.MODEL) || "AXON 7 mini".equals(Util.MODEL));
    }

    // 去混淆评级： 低(30)
    private int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo0, Format format0) {
        return !"OMX.google.raw.decoder".equals(mediaCodecInfo0.name) || (Util.SDK_INT >= 24 || Util.SDK_INT == 23 && Util.isTv(this.context)) ? format0.maxInputSize : -1;
    }

    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo0, Format format0, Format[] arr_format) {
        int v = this.getCodecMaxInputSize(mediaCodecInfo0, format0);
        if(arr_format.length == 1) {
            return v;
        }
        for(int v1 = 0; v1 < arr_format.length; ++v1) {
            Format format1 = arr_format[v1];
            if(mediaCodecInfo0.isSeamlessAdaptationSupported(format0, format1, false)) {
                v = Math.max(v, this.getCodecMaxInputSize(mediaCodecInfo0, format1));
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format0, Format[] arr_format) {
        int v1 = -1;
        for(int v = 0; v < arr_format.length; ++v) {
            int v2 = arr_format[v].sampleRate;
            if(v2 != -1) {
                v1 = Math.max(v1, v2);
            }
        }
        return v1 == -1 ? -1.0f : ((float)v1) * f;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List getDecoderInfos(MediaCodecSelector mediaCodecSelector0, Format format0, boolean z) {
        String s = format0.sampleMimeType;
        if(s == null) {
            return Collections.EMPTY_LIST;
        }
        if(this.allowPassthrough(format0.channelCount, s)) {
            MediaCodecInfo mediaCodecInfo0 = mediaCodecSelector0.getPassthroughDecoderInfo();
            if(mediaCodecInfo0 != null) {
                return Collections.singletonList(mediaCodecInfo0);
            }
        }
        List list0 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector0.getDecoderInfos(s, z, false), format0);
        if("audio/eac3-joc".equals(s)) {
            ArrayList arrayList0 = new ArrayList(list0);
            arrayList0.addAll(mediaCodecSelector0.getDecoderInfos("audio/eac3", z, false));
            list0 = arrayList0;
        }
        return Collections.unmodifiableList(list0);
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public MediaClock getMediaClock() {
        return this;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format0, String s, int v, float f) {
        MediaFormat mediaFormat0 = new MediaFormat();
        mediaFormat0.setString("mime", s);
        mediaFormat0.setInteger("channel-count", format0.channelCount);
        mediaFormat0.setInteger("sample-rate", format0.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat0, format0.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat0, "max-input-size", v);
        int v1 = Util.SDK_INT;
        if(v1 >= 23) {
            mediaFormat0.setInteger("priority", 0);
            if(f != -1.0f && !MediaCodecAudioRenderer.deviceDoesntSupportOperatingRate()) {
                mediaFormat0.setFloat("operating-rate", f);
            }
        }
        if(v1 <= 28 && "audio/ac4".equals(format0.sampleMimeType)) {
            mediaFormat0.setInteger("ac4-is-sync", 1);
        }
        return mediaFormat0;
    }

    public int getPassthroughEncoding(int v, String s) {
        if("audio/eac3-joc".equals(s)) {
            if(this.audioSink.supportsOutput(-1, 18)) {
                return MimeTypes.getEncoding("audio/eac3-joc");
            }
            s = "audio/eac3";
        }
        int v1 = MimeTypes.getEncoding(s);
        return this.audioSink.supportsOutput(v, v1) ? v1 : 0;
    }

    // 去混淆评级： 低(20)
    private static int getPcmEncoding(Format format0) {
        return "audio/raw".equals(format0.sampleMimeType) ? format0.pcmEncoding : 2;
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if(this.getState() == 2) {
            this.updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void handleMessage(int v, Object object0) {
        switch(v) {
            case 2: {
                this.audioSink.setVolume(((float)(((Float)object0))));
                return;
            }
            case 3: {
                this.audioSink.setAudioAttributes(((AudioAttributes)object0));
                return;
            }
            case 5: {
                this.audioSink.setAuxEffectInfo(((AuxEffectInfo)object0));
                return;
            }
            default: {
                super.handleMessage(v, object0);
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    public void onAudioSessionId(int v) {
    }

    public void onAudioTrackPositionDiscontinuity() {
    }

    public void onAudioTrackUnderrun(int v, long v1, long v2) {
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String s, long v, long v1) {
        this.eventDispatcher.decoderInitialized(s, v, v1);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onDisabled() {
        try {
            this.lastInputTimeUs = 0x8000000000000001L;
            this.pendingStreamChangeCount = 0;
            this.audioSink.flush();
        }
        catch(Throwable unused_ex) {
            try {
                super.onDisabled();
            }
            throw throwable0;
        }
        finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
        super.onDisabled();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onEnabled(boolean z) {
        super.onEnabled(z);
        this.eventDispatcher.enabled(this.decoderCounters);
        int v = this.getConfiguration().tunnelingAudioSessionId;
        if(v != 0) {
            this.audioSink.enableTunnelingV21(v);
            return;
        }
        this.audioSink.disableTunneling();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(FormatHolder formatHolder0) {
        super.onInputFormatChanged(formatHolder0);
        this.inputFormat = formatHolder0.format;
        this.eventDispatcher.inputFormatChanged(formatHolder0.format);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec0, MediaFormat mediaFormat0) {
        int[] arr_v;
        int v;
        MediaFormat mediaFormat1 = this.passthroughMediaFormat;
        if(mediaFormat1 == null) {
            v = mediaFormat0.containsKey("v-bits-per-sample") ? Util.getPcmEncoding(mediaFormat0.getInteger("v-bits-per-sample")) : MediaCodecAudioRenderer.getPcmEncoding(this.inputFormat);
        }
        else {
            v = this.getPassthroughEncoding(mediaFormat1.getInteger("channel-count"), mediaFormat1.getString("mime"));
            mediaFormat0 = mediaFormat1;
        }
        int v1 = mediaFormat0.getInteger("channel-count");
        int v2 = mediaFormat0.getInteger("sample-rate");
        if(!this.codecNeedsDiscardChannelsWorkaround || v1 != 6) {
            arr_v = null;
        }
        else {
            int v3 = this.inputFormat.channelCount;
            if(v3 < 6) {
                arr_v = new int[v3];
                for(int v4 = 0; v4 < this.inputFormat.channelCount; ++v4) {
                    arr_v[v4] = v4;
                }
            }
            else {
                arr_v = null;
            }
        }
        try {
            this.audioSink.configure(v, v1, v2, 0, arr_v, this.inputFormat.encoderDelay, this.inputFormat.encoderPadding);
        }
        catch(ConfigurationException audioSink$ConfigurationException0) {
            throw this.createRendererException(audioSink$ConfigurationException0, this.inputFormat);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onPositionReset(long v, boolean z) {
        super.onPositionReset(v, z);
        this.audioSink.flush();
        this.currentPositionUs = v;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.lastInputTimeUs = 0x8000000000000001L;
        this.pendingStreamChangeCount = 0;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedOutputBuffer(long v) {
        while(this.pendingStreamChangeCount != 0 && v >= this.pendingStreamChangeTimesUs[0]) {
            this.audioSink.handleDiscontinuity();
            int v1 = this.pendingStreamChangeCount - 1;
            this.pendingStreamChangeCount = v1;
            System.arraycopy(this.pendingStreamChangeTimesUs, 1, this.pendingStreamChangeTimesUs, 0, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer0) {
        if(this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer0.isDecodeOnly()) {
            if(Math.abs(decoderInputBuffer0.timeUs - this.currentPositionUs) > 500000L) {
                this.currentPositionUs = decoderInputBuffer0.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
        this.lastInputTimeUs = Math.max(decoderInputBuffer0.timeUs, this.lastInputTimeUs);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onReset() {
        try {
            super.onReset();
        }
        finally {
            this.audioSink.reset();
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onStopped() {
        this.updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        super.onStreamChanged(arr_format, v);
        if(this.lastInputTimeUs != 0x8000000000000001L) {
            int v1 = this.pendingStreamChangeCount;
            long[] arr_v = this.pendingStreamChangeTimesUs;
            if(v1 == arr_v.length) {
                Log.w("MediaCodecAudioRenderer", "Too many stream changes, so dropping change at " + arr_v[v1 - 1]);
            }
            else {
                this.pendingStreamChangeCount = v1 + 1;
            }
            this.pendingStreamChangeTimesUs[this.pendingStreamChangeCount - 1] = this.lastInputTimeUs;
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long v, long v1, MediaCodec mediaCodec0, ByteBuffer byteBuffer0, int v2, int v3, long v4, boolean z, boolean z1, Format format0) {
        if(this.codecNeedsEosBufferTimestampWorkaround && v4 == 0L && (v3 & 4) != 0) {
            long v5 = this.lastInputTimeUs;
            if(v5 != 0x8000000000000001L) {
                v4 = v5;
            }
        }
        if(this.passthroughEnabled && (v3 & 2) != 0) {
            mediaCodec0.releaseOutputBuffer(v2, false);
            return true;
        }
        if(z) {
            mediaCodec0.releaseOutputBuffer(v2, false);
            ++this.decoderCounters.skippedOutputBufferCount;
            this.audioSink.handleDiscontinuity();
            return true;
        }
        try {
            if(this.audioSink.handleBuffer(byteBuffer0, v4)) {
                mediaCodec0.releaseOutputBuffer(v2, false);
                ++this.decoderCounters.renderedOutputBufferCount;
                return true;
            }
            return false;
        }
        catch(InitializationException | WriteException audioSink$InitializationException0) {
            throw this.createRendererException(audioSink$InitializationException0, this.inputFormat);
        }
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() {
        try {
            this.audioSink.playToEndOfStream();
        }
        catch(WriteException audioSink$WriteException0) {
            throw this.createRendererException(audioSink$WriteException0, this.inputFormat);
        }
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        this.audioSink.setPlaybackParameters(playbackParameters0);
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, Format format0) {
        String s = format0.sampleMimeType;
        if(!MimeTypes.isAudio(s)) {
            return 0;
        }
        int v = Util.SDK_INT < 21 ? 0 : 0x20;
        boolean z = format0.drmInitData == null || FrameworkMediaCrypto.class.equals(format0.exoMediaCryptoType) || format0.exoMediaCryptoType == null && BaseRenderer.supportsFormatDrm(drmSessionManager0, format0.drmInitData);
        int v1 = 8;
        int v2 = 4;
        if(z && this.allowPassthrough(format0.channelCount, s) && mediaCodecSelector0.getPassthroughDecoderInfo() != null) {
            return 12 | v;
        }
        if("audio/raw".equals(s) && !this.audioSink.supportsOutput(format0.channelCount, format0.pcmEncoding) || !this.audioSink.supportsOutput(format0.channelCount, 2)) {
            return 1;
        }
        List list0 = this.getDecoderInfos(mediaCodecSelector0, format0, false);
        if(list0.isEmpty()) {
            return 1;
        }
        if(!z) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo0 = (MediaCodecInfo)list0.get(0);
        boolean z1 = mediaCodecInfo0.isFormatSupported(format0);
        if(z1 && mediaCodecInfo0.isSeamlessAdaptationSupported(format0)) {
            v1 = 16;
        }
        if(!z1) {
            v2 = 3;
        }
        return v2 | v1 | v;
    }

    private void updateCurrentPosition() {
        boolean z = this.isEnded();
        long v = this.audioSink.getCurrentPositionUs(z);
        if(v != 0x8000000000000000L) {
            if(!this.allowPositionDiscontinuity) {
                v = Math.max(this.currentPositionUs, v);
            }
            this.currentPositionUs = v;
            this.allowPositionDiscontinuity = false;
        }
    }

    class com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.1 {
    }

}

