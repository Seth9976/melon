package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;

public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    @Override  // com.google.android.exoplayer2.Renderer
    public final void disable() {
        Assertions.checkState(this.state == 1);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration0, Format[] arr_format, SampleStream sampleStream0, long v, boolean z, long v1) {
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration0;
        this.state = 1;
        this.replaceStream(arr_format, sampleStream0, v1);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public long getReadingPositionUs() {
        return 0x8000000000000000L;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.state;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final SampleStream getStream() {
        return this.stream;
    }

    @Override  // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return 6;
    }

    @Override  // com.google.android.exoplayer2.PlayerMessage$Target
    public void handleMessage(int v, Object object0) {
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z) {
    }

    public void onPositionReset(long v, boolean z) {
    }

    public void onRendererOffsetChanged(long v) {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] arr_format, SampleStream sampleStream0, long v) {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream0;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void reset() {
        Assertions.checkState(this.state == 0);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long v) {
        this.streamIsFinal = false;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void setIndex(int v) {
        this.index = v;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void start() {
        Assertions.checkState(this.state == 1);
        this.state = 2;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public final void stop() {
        Assertions.checkState(this.state == 2);
        this.state = 1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format0) {
        return 0;
    }

    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}

