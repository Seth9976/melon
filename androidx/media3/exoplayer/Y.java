package androidx.media3.exoplayer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;

public final class y implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public final B a;

    public y(B b0) {
        this.a = b0;
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture0, int v, int v1) {
        Surface surface0 = new Surface(surfaceTexture0);
        this.a.B0(surface0);
        this.a.Q = surface0;
        this.a.w0(v, v1);
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture0) {
        this.a.B0(null);
        this.a.w0(0, 0);
        return true;
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture0, int v, int v1) {
        this.a.w0(v, v1);
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture0) {
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder0, int v, int v1, int v2) {
        this.a.w0(v1, v2);
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder0) {
        this.a.getClass();
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder0) {
        this.a.getClass();
        this.a.w0(0, 0);
    }
}

