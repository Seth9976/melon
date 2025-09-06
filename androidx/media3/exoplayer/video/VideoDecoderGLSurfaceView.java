package androidx.media3.exoplayer.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import h3.g;
import z3.h;
import z3.i;

public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements i {
    public final h a;

    public VideoDecoderGLSurfaceView(Context context0) {
        this(context0, null);
    }

    public VideoDecoderGLSurfaceView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        h h0 = new h(this);
        this.a = h0;
        this.setPreserveEGLContextOnPause(true);
        this.setEGLContextClientVersion(2);
        this.setRenderer(h0);
        this.setRenderMode(0);
    }

    @Deprecated
    public i getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(g g0) {
        h h0 = this.a;
        if(h0.f.getAndSet(g0) != null) {
            throw new ClassCastException();
        }
        h0.a.requestRender();
    }
}

