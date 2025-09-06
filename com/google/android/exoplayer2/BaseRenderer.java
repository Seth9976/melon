package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private final FormatHolder formatHolder;
    private int index;
    private long readingPositionUs;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;

    public BaseRenderer(int v) {
        this.trackType = v;
        this.formatHolder = new FormatHolder();
        this.readingPositionUs = 0x8000000000000000L;
    }

    public final ExoPlaybackException createRendererException(Exception exception0, Format format0) {
        int v1;
        if(format0 != null && !this.throwRendererExceptionIsExecuting) {
            try {
                this.throwRendererExceptionIsExecuting = true;
                v1 = RendererCapabilities.getFormatSupport(this.supportsFormat(format0));
            }
            catch(ExoPlaybackException unused_ex) {
                this.throwRendererExceptionIsExecuting = false;
                return ExoPlaybackException.createForRenderer(exception0, this.getIndex(), format0, 4);
            }
            finally {
                this.throwRendererExceptionIsExecuting = false;
            }
            return ExoPlaybackException.createForRenderer(exception0, this.getIndex(), format0, v1);
        }
        return ExoPlaybackException.createForRenderer(exception0, this.getIndex(), format0, 4);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void disable() {
        Assertions.checkState(this.state == 1);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        this.onDisabled();
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration0, Format[] arr_format, SampleStream sampleStream0, long v, boolean z, long v1) {
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration0;
        this.state = 1;
        this.onEnabled(z);
        this.replaceStream(arr_format, sampleStream0, v1);
        this.onPositionReset(v, z);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    public final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.state;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final SampleStream getStream() {
        return this.stream;
    }

    public final Format[] getStreamFormats() {
        return this.streamFormats;
    }

    @Override  // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.trackType;
    }

    public final DrmSession getUpdatedSourceDrmSession(Format format0, Format format1, DrmSessionManager drmSessionManager0, DrmSession drmSession0) {
        DrmSession drmSession1 = null;
        if(Util.areEqual(format1.drmInitData, (format0 == null ? null : format0.drmInitData))) {
            return drmSession0;
        }
        if(format1.drmInitData != null) {
            if(drmSessionManager0 == null) {
                throw this.createRendererException(new IllegalStateException("Media requires a DrmSessionManager"), format1);
            }
            drmSession1 = drmSessionManager0.acquireSession(((Looper)Assertions.checkNotNull(Looper.myLooper())), format1.drmInitData);
        }
        if(drmSession0 != null) {
            drmSession0.release();
        }
        return drmSession1;
    }

    @Override  // com.google.android.exoplayer2.PlayerMessage$Target
    public void handleMessage(int v, Object object0) {
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == 0x8000000000000000L;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    // 去混淆评级： 低(20)
    public final boolean isSourceReady() {
        return this.hasReadStreamToEnd() ? this.streamIsFinal : this.stream.isReady();
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() {
        this.stream.maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z) {
    }

    public void onPositionReset(long v, boolean z) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] arr_format, long v) {
    }

    public final int readSource(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        int v = this.stream.readData(formatHolder0, decoderInputBuffer0, z);
        if(v == -4) {
            if(decoderInputBuffer0.isEndOfStream()) {
                this.readingPositionUs = 0x8000000000000000L;
                return this.streamIsFinal ? -4 : -3;
            }
            long v1 = decoderInputBuffer0.timeUs + this.streamOffsetUs;
            decoderInputBuffer0.timeUs = v1;
            this.readingPositionUs = Math.max(this.readingPositionUs, v1);
            return -4;
        }
        if(v == -5) {
            Format format0 = formatHolder0.format;
            long v2 = format0.subsampleOffsetUs;
            if(v2 != 0x7FFFFFFFFFFFFFFFL) {
                formatHolder0.format = format0.copyWithSubsampleOffsetUs(v2 + this.streamOffsetUs);
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] arr_format, SampleStream sampleStream0, long v) {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream0;
        this.readingPositionUs = v;
        this.streamFormats = arr_format;
        this.streamOffsetUs = v;
        this.onStreamChanged(arr_format, v);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void reset() {
        Assertions.checkState(this.state == 0);
        this.formatHolder.clear();
        this.onReset();
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long v) {
        this.streamIsFinal = false;
        this.readingPositionUs = v;
        this.onPositionReset(v, false);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void setIndex(int v) {
        this.index = v;
    }

    public int skipSource(long v) {
        return this.stream.skipData(v - this.streamOffsetUs);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void start() {
        Assertions.checkState(this.state == 1);
        this.state = 2;
        this.onStarted();
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void stop() {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        this.onStopped();
    }

    public static boolean supportsFormatDrm(DrmSessionManager drmSessionManager0, DrmInitData drmInitData0) {
        if(drmInitData0 == null) {
            return true;
        }
        return drmSessionManager0 == null ? false : drmSessionManager0.canAcquireSession(drmInitData0);
    }

    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}

