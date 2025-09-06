package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;

public abstract class SimpleDecoderAudioRenderer extends BaseRenderer implements MediaClock {
    final class AudioSinkListener implements Listener {
        private AudioSinkListener() {
        }

        public AudioSinkListener(com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.1 simpleDecoderAudioRenderer$10) {
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onAudioSessionId(int v) {
            SimpleDecoderAudioRenderer.this.eventDispatcher.audioSessionId(v);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onPositionDiscontinuity() {
            SimpleDecoderAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override  // com.google.android.exoplayer2.audio.AudioSink$Listener
        public void onUnderrun(int v, long v1, long v2) {
            SimpleDecoderAudioRenderer.this.eventDispatcher.audioTrackUnderrun(v, v1, v2);
        }
    }

    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private SimpleDecoder decoder;
    private DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private boolean drmResourcesAcquired;
    private final DrmSessionManager drmSessionManager;
    private int encoderDelay;
    private int encoderPadding;
    private final EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private SimpleOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private final boolean playClearSamplesWithoutKeys;
    private DrmSession sourceDrmSession;
    private boolean waitingForKeys;

    public SimpleDecoderAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }

    public SimpleDecoderAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioCapabilities audioCapabilities0) {
        this(handler0, audioRendererEventListener0, audioCapabilities0, null, false, new AudioProcessor[0]);
    }

    public SimpleDecoderAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioCapabilities audioCapabilities0, DrmSessionManager drmSessionManager0, boolean z, AudioProcessor[] arr_audioProcessor) {
        this(handler0, audioRendererEventListener0, drmSessionManager0, z, new DefaultAudioSink(audioCapabilities0, arr_audioProcessor));
    }

    public SimpleDecoderAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, DrmSessionManager drmSessionManager0, boolean z, AudioSink audioSink0) {
        super(1);
        this.drmSessionManager = drmSessionManager0;
        this.playClearSamplesWithoutKeys = z;
        this.eventDispatcher = new EventDispatcher(handler0, audioRendererEventListener0);
        this.audioSink = audioSink0;
        audioSink0.setListener(new AudioSinkListener(this, null));
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
    }

    public SimpleDecoderAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioProcessor[] arr_audioProcessor) {
        this(handler0, audioRendererEventListener0, null, null, false, arr_audioProcessor);
    }

    public boolean canKeepCodec(Format format0, Format format1) [...] // Inlined contents

    public abstract SimpleDecoder createDecoder(Format arg1, ExoMediaCrypto arg2);

    private boolean drainOutputBuffer() {
        if(this.outputBuffer == null) {
            SimpleOutputBuffer simpleOutputBuffer0 = (SimpleOutputBuffer)this.decoder.dequeueOutputBuffer();
            this.outputBuffer = simpleOutputBuffer0;
            if(simpleOutputBuffer0 == null) {
                return false;
            }
            int v = simpleOutputBuffer0.skippedOutputBufferCount;
            if(v > 0) {
                this.decoderCounters.skippedOutputBufferCount += v;
                this.audioSink.handleDiscontinuity();
            }
        }
        if(this.outputBuffer.isEndOfStream()) {
            if(this.decoderReinitializationState == 2) {
                this.releaseDecoder();
                this.maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
                return false;
            }
            this.outputBuffer.release();
            this.outputBuffer = null;
            this.processEndOfStream();
            return false;
        }
        if(this.audioTrackNeedsConfigure) {
            Format format0 = this.getOutputFormat();
            this.audioSink.configure(format0.pcmEncoding, format0.channelCount, format0.sampleRate, 0, null, this.encoderDelay, this.encoderPadding);
            this.audioTrackNeedsConfigure = false;
        }
        if(this.audioSink.handleBuffer(this.outputBuffer.data, this.outputBuffer.timeUs)) {
            ++this.decoderCounters.renderedOutputBufferCount;
            this.outputBuffer.release();
            this.outputBuffer = null;
            return true;
        }
        return false;
    }

    private boolean feedInputBuffer() {
        SimpleDecoder simpleDecoder0 = this.decoder;
        if(simpleDecoder0 != null && this.decoderReinitializationState != 2 && !this.inputStreamEnded) {
            if(this.inputBuffer == null) {
                DecoderInputBuffer decoderInputBuffer0 = simpleDecoder0.dequeueInputBuffer();
                this.inputBuffer = decoderInputBuffer0;
                if(decoderInputBuffer0 == null) {
                    return false;
                }
            }
            if(this.decoderReinitializationState == 1) {
                this.inputBuffer.setFlags(4);
                this.decoder.queueInputBuffer(this.inputBuffer);
                this.inputBuffer = null;
                this.decoderReinitializationState = 2;
                return false;
            }
            FormatHolder formatHolder0 = this.getFormatHolder();
            switch((this.waitingForKeys ? -4 : this.readSource(formatHolder0, this.inputBuffer, false))) {
                case -5: {
                    this.onInputFormatChanged(formatHolder0);
                    return true;
                }
                case -3: {
                    return false;
                }
                default: {
                    if(this.inputBuffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                        this.decoder.queueInputBuffer(this.inputBuffer);
                        this.inputBuffer = null;
                        return false;
                    }
                    boolean z = this.shouldWaitForKeys(this.inputBuffer.isEncrypted());
                    this.waitingForKeys = z;
                    if(z) {
                        return false;
                    }
                    this.inputBuffer.flip();
                    this.onQueueInputBuffer(this.inputBuffer);
                    this.decoder.queueInputBuffer(this.inputBuffer);
                    this.decoderReceivedBuffers = true;
                    ++this.decoderCounters.inputBufferCount;
                    this.inputBuffer = null;
                    return true;
                }
            }
        }
        return false;
    }

    private void flushDecoder() {
        this.waitingForKeys = false;
        if(this.decoderReinitializationState != 0) {
            this.releaseDecoder();
            this.maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        SimpleOutputBuffer simpleOutputBuffer0 = this.outputBuffer;
        if(simpleOutputBuffer0 != null) {
            simpleOutputBuffer0.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public MediaClock getMediaClock() {
        return this;
    }

    public abstract Format getOutputFormat();

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
    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded && this.audioSink.isEnded();
    }

    // 去混淆评级： 低(30)
    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || this.inputFormat != null && !this.waitingForKeys && (this.isSourceReady() || this.outputBuffer != null);
    }

    private void maybeInitDecoder() {
        ExoMediaCrypto exoMediaCrypto0;
        if(this.decoder == null) {
            this.setDecoderDrmSession(this.sourceDrmSession);
            DrmSession drmSession0 = this.decoderDrmSession;
            if(drmSession0 == null) {
                exoMediaCrypto0 = null;
            }
            else {
                exoMediaCrypto0 = drmSession0.getMediaCrypto();
                if(exoMediaCrypto0 == null && this.decoderDrmSession.getError() == null) {
                    return;
                }
            }
            try {
                long v = SystemClock.elapsedRealtime();
                TraceUtil.beginSection("createAudioDecoder");
                this.decoder = this.createDecoder(this.inputFormat, exoMediaCrypto0);
                TraceUtil.endSection();
                long v1 = SystemClock.elapsedRealtime();
                String s = this.decoder.getName();
                this.eventDispatcher.decoderInitialized(s, v1, v1 - v);
                ++this.decoderCounters.decoderInitCount;
            }
            catch(AudioDecoderException audioDecoderException0) {
                throw this.createRendererException(audioDecoderException0, this.inputFormat);
            }
        }
    }

    public void onAudioSessionId(int v) {
    }

    public void onAudioTrackPositionDiscontinuity() {
    }

    public void onAudioTrackUnderrun(int v, long v1, long v2) {
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        try {
            this.inputFormat = null;
            this.audioTrackNeedsConfigure = true;
            this.waitingForKeys = false;
            this.setSourceDrmSession(null);
            this.releaseDecoder();
            this.audioSink.reset();
        }
        finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) {
        DrmSessionManager drmSessionManager0 = this.drmSessionManager;
        if(drmSessionManager0 != null && !this.drmResourcesAcquired) {
            this.drmResourcesAcquired = true;
            drmSessionManager0.prepare();
        }
        DecoderCounters decoderCounters0 = new DecoderCounters();
        this.decoderCounters = decoderCounters0;
        this.eventDispatcher.enabled(decoderCounters0);
        int v = this.getConfiguration().tunnelingAudioSessionId;
        if(v != 0) {
            this.audioSink.enableTunnelingV21(v);
            return;
        }
        this.audioSink.disableTunneling();
    }

    private void onInputFormatChanged(FormatHolder formatHolder0) {
        Format format0 = (Format)Assertions.checkNotNull(formatHolder0.format);
        if(formatHolder0.includesDrmSession) {
            this.setSourceDrmSession(formatHolder0.drmSession);
        }
        else {
            this.sourceDrmSession = this.getUpdatedSourceDrmSession(this.inputFormat, format0, this.drmSessionManager, this.sourceDrmSession);
        }
        this.inputFormat = format0;
        if(this.decoderReceivedBuffers) {
            this.decoderReinitializationState = 1;
        }
        else {
            this.releaseDecoder();
            this.maybeInitDecoder();
            this.audioTrackNeedsConfigure = true;
        }
        this.encoderDelay = this.inputFormat.encoderDelay;
        this.encoderPadding = this.inputFormat.encoderPadding;
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.audioSink.flush();
        this.currentPositionUs = v;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if(this.decoder != null) {
            this.flushDecoder();
        }
    }

    private void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer0) {
        if(this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer0.isDecodeOnly()) {
            if(Math.abs(decoderInputBuffer0.timeUs - this.currentPositionUs) > 500000L) {
                this.currentPositionUs = decoderInputBuffer0.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        DrmSessionManager drmSessionManager0 = this.drmSessionManager;
        if(drmSessionManager0 != null && this.drmResourcesAcquired) {
            this.drmResourcesAcquired = false;
            drmSessionManager0.release();
        }
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.audioSink.play();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.updateCurrentPosition();
        this.audioSink.pause();
    }

    private void processEndOfStream() {
        try {
            this.outputStreamEnded = true;
            this.audioSink.playToEndOfStream();
        }
        catch(WriteException audioSink$WriteException0) {
            throw this.createRendererException(audioSink$WriteException0, this.inputFormat);
        }
    }

    private void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        SimpleDecoder simpleDecoder0 = this.decoder;
        if(simpleDecoder0 != null) {
            simpleDecoder0.release();
            this.decoder = null;
            ++this.decoderCounters.decoderReleaseCount;
        }
        this.setDecoderDrmSession(null);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public void render(long v, long v1) {
        if(this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
                return;
            }
            catch(WriteException audioSink$WriteException0) {
                throw this.createRendererException(audioSink$WriteException0, this.inputFormat);
            }
        }
        if(this.inputFormat == null) {
            FormatHolder formatHolder0 = this.getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int v2 = this.readSource(formatHolder0, this.flagsOnlyBuffer, true);
            if(v2 == -5) {
                this.onInputFormatChanged(formatHolder0);
                goto label_17;
            }
            else if(v2 == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                this.processEndOfStream();
            }
        }
        else {
        label_17:
            this.maybeInitDecoder();
            if(this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while(true) {
                        if(!this.drainOutputBuffer()) {
                            while(true) {
                                if(!this.feedInputBuffer()) {
                                    TraceUtil.endSection();
                                    return;
                                }
                            }
                        }
                    }
                }
                catch(AudioDecoderException | ConfigurationException | InitializationException | WriteException audioDecoderException0) {
                    throw this.createRendererException(audioDecoderException0, this.inputFormat);
                }
            }
        }
    }

    private void setDecoderDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.decoderDrmSession, drmSession0);
        this.decoderDrmSession = drmSession0;
    }

    @Override  // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        this.audioSink.setPlaybackParameters(playbackParameters0);
    }

    private void setSourceDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession0);
        this.sourceDrmSession = drmSession0;
    }

    private boolean shouldWaitForKeys(boolean z) {
        if(this.decoderDrmSession != null && (z || !this.playClearSamplesWithoutKeys && !this.decoderDrmSession.playClearSamplesWithoutKeys())) {
            switch(this.decoderDrmSession.getState()) {
                case 1: {
                    throw this.createRendererException(this.decoderDrmSession.getError(), this.inputFormat);
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
        int v = 0;
        if(!MimeTypes.isAudio(format0.sampleMimeType)) {
            return 0;
        }
        int v1 = this.supportsFormatInternal(this.drmSessionManager, format0);
        if(v1 <= 2) {
            return RendererCapabilities.create(v1);
        }
        if(Util.SDK_INT >= 21) {
            v = 0x20;
        }
        return v1 | 8 | v;
    }

    public abstract int supportsFormatInternal(DrmSessionManager arg1, Format arg2);

    public final boolean supportsOutput(int v, int v1) {
        return this.audioSink.supportsOutput(v, v1);
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

    class com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.1 {
    }

}

