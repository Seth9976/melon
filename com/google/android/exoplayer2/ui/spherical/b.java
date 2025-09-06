package com.google.android.exoplayer2.ui.spherical;

public final class b implements Runnable {
    public final SphericalGLSurfaceView a;

    public b(SphericalGLSurfaceView sphericalGLSurfaceView0) {
        this.a = sphericalGLSurfaceView0;
    }

    @Override
    public final void run() {
        this.a.lambda$onDetachedFromWindow$0();
    }
}

