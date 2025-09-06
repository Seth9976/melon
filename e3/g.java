package e3;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

public final class g implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public final Handler a;
    public final int[] b;
    public EGLDisplay c;
    public EGLContext d;
    public EGLSurface e;
    public SurfaceTexture f;
    public static final int[] g;

    static {
        g.g = new int[]{0x3040, 4, 0x3024, 8, 0x3023, 8, 0x3022, 8, 0x3021, 8, 0x3025, 0, 0x3027, 0x3038, 0x3033, 4, 0x3038};
    }

    public g(Handler handler0) {
        this.a = handler0;
        this.b = new int[1];
    }

    @Override  // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture0) {
        this.a.post(this);
    }

    @Override
    public final void run() {
        SurfaceTexture surfaceTexture0 = this.f;
        if(surfaceTexture0 != null) {
            try {
                surfaceTexture0.updateTexImage();
            }
            catch(RuntimeException unused_ex) {
            }
        }
    }
}

