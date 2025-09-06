package com.google.android.exoplayer2.video;

public interface VideoListener {
    default void onRenderedFirstFrame() {
    }

    default void onSurfaceSizeChanged(int v, int v1) {
    }

    default void onVideoSizeChanged(int v, int v1, int v2, float f) {
    }
}

