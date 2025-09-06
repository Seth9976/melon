package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline0, int v, long v1) {
        this.timeline = timeline0;
        this.windowIndex = v;
        this.positionMs = v1;
    }
}

