package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;

public abstract class SimpleDecoderVideoRenderer extends BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private SimpleDecoder decoder;
    protected DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private boolean drmResourcesAcquired;
    private final DrmSessionManager drmSessionManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue formatQueue;
    private long initialPositionUs;
    private VideoDecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private VideoDecoderOutputBuffer outputBuffer;
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private DrmSession sourceDrmSession;
    private Surface surface;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForKeys;

    public SimpleDecoderVideoRenderer(long v, Handler handler0, VideoRendererEventListener videoRendererEventListener0, int v1, DrmSessionManager drmSessionManager0, boolean z) {
        super(2);
        this.allowedJoiningTimeMs = v;
        this.maxDroppedFramesToNotify = v1;
        this.drmSessionManager = drmSessionManager0;
        this.playClearSamplesWithoutKeys = z;
        this.joiningDeadlineMs = 0x8000000000000001L;
        this.clearReportedVideoSize();
        this.formatQueue = new TimedValueQueue();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new EventDispatcher(handler0, videoRendererEventListener0);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
    }

    public abstract SimpleDecoder createDecoder(Format arg1, ExoMediaCrypto arg2);

    private boolean drainOutputBuffer(long v, long v1) {
        if(this.outputBuffer == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer0 = (VideoDecoderOutputBuffer)this.decoder.dequeueOutputBuffer();
            this.outputBuffer = videoDecoderOutputBuffer0;
            if(videoDecoderOutputBuffer0 == null) {
                return false;
            }
            int v2 = videoDecoderOutputBuffer0.skippedOutputBufferCount;
            this.decoderCounters.skippedOutputBufferCount += v2;
            this.buffersInCodecCount -= v2;
        }
        if(this.outputBuffer.isEndOfStream()) {
            if(this.decoderReinitializationState == 2) {
                this.releaseDecoder();
                this.maybeInitDecoder();
                return false;
            }
            this.outputBuffer.release();
            this.outputBuffer = null;
            this.outputStreamEnded = true;
            return false;
        }
        boolean z = this.processOutputBuffer(v, v1);
        if(z) {
            this.onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return z;
    }

    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer0) {
        this.updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer0.release();
    }

    private boolean feedInputBuffer() {
        SimpleDecoder simpleDecoder0 = this.decoder;
        if(simpleDecoder0 != null && this.decoderReinitializationState != 2 && !this.inputStreamEnded) {
            if(this.inputBuffer == null) {
                VideoDecoderInputBuffer videoDecoderInputBuffer0 = (VideoDecoderInputBuffer)simpleDecoder0.dequeueInputBuffer();
                this.inputBuffer = videoDecoderInputBuffer0;
                if(videoDecoderInputBuffer0 == null) {
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
                    if(this.waitingForFirstSampleInFormat) {
                        this.formatQueue.add(this.inputBuffer.timeUs, this.inputFormat);
                        this.waitingForFirstSampleInFormat = false;
                    }
                    this.inputBuffer.flip();
                    this.inputBuffer.colorInfo = this.inputFormat.colorInfo;
                    this.decoder.queueInputBuffer(this.inputBuffer);
                    ++this.buffersInCodecCount;
                    this.decoderReceivedBuffers = true;
                    ++this.decoderCounters.inputBufferCount;
                    this.inputBuffer = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void flushDecoder() {
        this.waitingForKeys = false;
        this.buffersInCodecCount = 0;
        if(this.decoderReinitializationState != 0) {
            this.releaseDecoder();
            this.maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer0 = this.outputBuffer;
        if(videoDecoderOutputBuffer0 != null) {
            videoDecoderOutputBuffer0.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private static boolean isBufferLate(long v) {
        return v < -30000L;
    }

    private static boolean isBufferVeryLate(long v) {
        return v < -500000L;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if(this.waitingForKeys) {
            return false;
        }
        if(this.inputFormat != null && (this.isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || !this.hasOutput())) {
            this.joiningDeadlineMs = 0x8000000000000001L;
            return true;
        }
        if(this.joiningDeadlineMs == 0x8000000000000001L) {
            return false;
        }
        if(SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = 0x8000000000000001L;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long v) {
        int v1 = this.skipSource(v);
        if(v1 == 0) {
            return false;
        }
        ++this.decoderCounters.droppedToKeyframeCount;
        this.updateDroppedBufferCounters(this.buffersInCodecCount + v1);
        this.flushDecoder();
        return true;
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
                this.decoder = this.createDecoder(this.inputFormat, exoMediaCrypto0);
                this.setDecoderOutputMode(this.outputMode);
                long v1 = SystemClock.elapsedRealtime();
                this.onDecoderInitialized(this.decoder.getName(), v1, v1 - v);
                ++this.decoderCounters.decoderInitCount;
            }
            catch(VideoDecoderException videoDecoderException0) {
                throw this.createRendererException(videoDecoderException0, this.inputFormat);
            }
        }
    }

    private void maybeNotifyDroppedFrames() {
        if(this.droppedFrames > 0) {
            long v = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, v - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = v;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if(!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeNotifyVideoSizeChanged(int v, int v1) {
        if(this.reportedWidth == v && this.reportedHeight == v1) {
            return;
        }
        this.reportedWidth = v;
        this.reportedHeight = v1;
        this.eventDispatcher.videoSizeChanged(v, v1, 0, 1.0f);
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
        this.eventDispatcher.videoSizeChanged(v, this.reportedHeight, 0, 1.0f);
    }

    public void onDecoderInitialized(String s, long v, long v1) {
        this.eventDispatcher.decoderInitialized(s, v, v1);
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.inputFormat = null;
        this.waitingForKeys = false;
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
        try {
            this.setSourceDrmSession(null);
            this.releaseDecoder();
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
    }

    public void onInputFormatChanged(FormatHolder formatHolder0) {
        this.waitingForFirstSampleInFormat = true;
        Format format0 = (Format)Assertions.checkNotNull(formatHolder0.format);
        if(formatHolder0.includesDrmSession) {
            this.setSourceDrmSession(formatHolder0.drmSession);
        }
        else {
            this.sourceDrmSession = this.getUpdatedSourceDrmSession(this.inputFormat, format0, this.drmSessionManager, this.sourceDrmSession);
        }
        this.inputFormat = format0;
        if(this.sourceDrmSession != this.decoderDrmSession) {
            if(this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            }
            else {
                this.releaseDecoder();
                this.maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    private void onOutputChanged() {
        this.maybeRenotifyVideoSizeChanged();
        this.clearRenderedFirstFrame();
        if(this.getState() == 2) {
            this.setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
    }

    private void onOutputReset() {
        this.maybeRenotifyVideoSizeChanged();
        this.maybeRenotifyRenderedFirstFrame();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.clearRenderedFirstFrame();
        this.initialPositionUs = 0x8000000000000001L;
        this.consecutiveDroppedFrameCount = 0;
        if(this.decoder != null) {
            this.flushDecoder();
        }
        if(z) {
            this.setJoiningDeadlineMs();
        }
        else {
            this.joiningDeadlineMs = 0x8000000000000001L;
        }
        this.formatQueue.clear();
    }

    public void onProcessedOutputBuffer(long v) {
        --this.buffersInCodecCount;
    }

    public void onQueueInputBuffer(VideoDecoderInputBuffer videoDecoderInputBuffer0) {
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
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000L;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.joiningDeadlineMs = 0x8000000000000001L;
        this.maybeNotifyDroppedFrames();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        this.outputStreamOffsetUs = v;
        super.onStreamChanged(arr_format, v);
    }

    private boolean processOutputBuffer(long v, long v1) {
        if(this.initialPositionUs == 0x8000000000000001L) {
            this.initialPositionUs = v;
        }
        long v2 = this.outputBuffer.timeUs - v;
        if(!this.hasOutput()) {
            if(SimpleDecoderVideoRenderer.isBufferLate(v2)) {
                this.skipOutputBuffer(this.outputBuffer);
                return true;
            }
            return false;
        }
        long v3 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
        Format format0 = (Format)this.formatQueue.pollFloor(v3);
        if(format0 != null) {
            this.outputFormat = format0;
        }
        long v4 = SystemClock.elapsedRealtime();
        boolean z = this.getState() == 2;
        if(this.renderedFirstFrame && (!z || !this.shouldForceRenderOutputBuffer(v2, v4 * 1000L - this.lastRenderTimeUs))) {
            if(!z || v == this.initialPositionUs || this.shouldDropBuffersToKeyframe(v2, v1) && this.maybeDropBuffersToKeyframe(v)) {
                return false;
            }
            if(this.shouldDropOutputBuffer(v2, v1)) {
                this.dropOutputBuffer(this.outputBuffer);
                return true;
            }
            if(v2 < 30000L) {
                this.renderOutputBuffer(this.outputBuffer, v3, this.outputFormat);
                return true;
            }
            return false;
        }
        this.renderOutputBuffer(this.outputBuffer, v3, this.outputFormat);
        return true;
    }

    public void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
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
        if(!this.outputStreamEnded) {
            if(this.inputFormat == null) {
                FormatHolder formatHolder0 = this.getFormatHolder();
                this.flagsOnlyBuffer.clear();
                int v2 = this.readSource(formatHolder0, this.flagsOnlyBuffer, true);
                if(v2 == -5) {
                    this.onInputFormatChanged(formatHolder0);
                    goto label_13;
                }
                else if(v2 == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                }
            }
            else {
            label_13:
                this.maybeInitDecoder();
                if(this.decoder != null) {
                    try {
                        TraceUtil.beginSection("drainAndFeed");
                        while(true) {
                            if(!this.drainOutputBuffer(v, v1)) {
                                while(true) {
                                    if(!this.feedInputBuffer()) {
                                        TraceUtil.endSection();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    catch(VideoDecoderException videoDecoderException0) {
                        throw this.createRendererException(videoDecoderException0, this.inputFormat);
                    }
                }
            }
        }
    }

    public void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer0, long v, Format format0) {
        this.lastRenderTimeUs = C.msToUs(SystemClock.elapsedRealtime() * 1000L);
        boolean z = videoDecoderOutputBuffer0.mode == 0 && this.outputBufferRenderer != null;
        if(!z && (videoDecoderOutputBuffer0.mode != 1 || this.surface == null)) {
            this.dropOutputBuffer(videoDecoderOutputBuffer0);
            return;
        }
        this.maybeNotifyVideoSizeChanged(videoDecoderOutputBuffer0.width, videoDecoderOutputBuffer0.height);
        if(z) {
            this.outputBufferRenderer.setOutputBuffer(videoDecoderOutputBuffer0);
        }
        else {
            this.renderOutputBufferToSurface(videoDecoderOutputBuffer0, this.surface);
        }
        this.consecutiveDroppedFrameCount = 0;
        ++this.decoderCounters.renderedOutputBufferCount;
        this.maybeNotifyRenderedFirstFrame();
    }

    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer arg1, Surface arg2);

    private void setDecoderDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.decoderDrmSession, drmSession0);
        this.decoderDrmSession = drmSession0;
    }

    public abstract void setDecoderOutputMode(int arg1);

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs <= 0L ? 0x8000000000000001L : SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
    }

    public final void setOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer0) {
        if(this.outputBufferRenderer != videoDecoderOutputBufferRenderer0) {
            this.outputBufferRenderer = videoDecoderOutputBufferRenderer0;
            if(videoDecoderOutputBufferRenderer0 != null) {
                this.surface = null;
                this.outputMode = 0;
                if(this.decoder != null) {
                    this.setDecoderOutputMode(0);
                }
                this.onOutputChanged();
                return;
            }
            this.outputMode = -1;
            this.onOutputRemoved();
            return;
        }
        if(videoDecoderOutputBufferRenderer0 != null) {
            this.onOutputReset();
        }
    }

    public final void setOutputSurface(Surface surface0) {
        if(this.surface != surface0) {
            this.surface = surface0;
            if(surface0 != null) {
                this.outputBufferRenderer = null;
                this.outputMode = 1;
                if(this.decoder != null) {
                    this.setDecoderOutputMode(1);
                }
                this.onOutputChanged();
                return;
            }
            this.outputMode = -1;
            this.onOutputRemoved();
            return;
        }
        if(surface0 != null) {
            this.onOutputReset();
        }
    }

    private void setSourceDrmSession(DrmSession drmSession0) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession0);
        this.sourceDrmSession = drmSession0;
    }

    public boolean shouldDropBuffersToKeyframe(long v, long v1) {
        return SimpleDecoderVideoRenderer.isBufferVeryLate(v);
    }

    public boolean shouldDropOutputBuffer(long v, long v1) {
        return SimpleDecoderVideoRenderer.isBufferLate(v);
    }

    public boolean shouldForceRenderOutputBuffer(long v, long v1) {
        return SimpleDecoderVideoRenderer.isBufferLate(v) && v1 > 100000L;
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

    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer0) {
        ++this.decoderCounters.skippedOutputBufferCount;
        videoDecoderOutputBuffer0.release();
    }

    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format0) {
        return this.supportsFormatInternal(this.drmSessionManager, format0);
    }

    public abstract int supportsFormatInternal(DrmSessionManager arg1, Format arg2);

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

