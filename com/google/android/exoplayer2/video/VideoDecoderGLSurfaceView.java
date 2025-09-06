package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class VideoDecoderGLSurfaceView extends GLSurfaceView {
    private final VideoDecoderRenderer renderer;

    public VideoDecoderGLSurfaceView(Context context0) {
        this(context0, null);
    }

    public VideoDecoderGLSurfaceView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        VideoDecoderRenderer videoDecoderRenderer0 = new VideoDecoderRenderer(this);
        this.renderer = videoDecoderRenderer0;
        this.setPreserveEGLContextOnPause(true);
        this.setEGLContextClientVersion(2);
        this.setRenderer(videoDecoderRenderer0);
        this.setRenderMode(0);
    }

    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this.renderer;
    }
}

