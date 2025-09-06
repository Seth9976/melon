package i.n.i.b.a.s.e;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.view.Surface;

public final class xm extends Surface {
    public final Fd a;
    public boolean b;
    public static int c;
    public static boolean d;

    public xm(Fd fd0, SurfaceTexture surfaceTexture0) {
        super(surfaceTexture0);
        this.a = fd0;
    }

    public static int a(Context context0) {
        int v = L7.a;
        if(v >= 24 && (v >= 26 || !"samsung".equals(L7.d) && !"XT1650".equals(L7.e)) && (v >= 26 || context0.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
            String s = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
            if(s != null && s.contains("EGL_EXT_protected_content")) {
                if(v >= 17) {
                    String s1 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
                    return s1 == null || !s1.contains("EGL_KHR_surfaceless_context") ? 2 : 1;
                }
                return 2;
            }
        }
        return 0;
    }

    public static xm b(Context context0, boolean z) {
        boolean z1 = false;
        M7.J(!z || xm.c(context0));
        Fd fd0 = new Fd("ExoPlayer:DummySurface", 0);
        int v = z ? xm.c : 0;
        fd0.start();
        Handler handler0 = new Handler(fd0.getLooper(), fd0);
        fd0.b = handler0;
        fd0.e = new N3(handler0);
        synchronized(fd0) {
            fd0.b.obtainMessage(1, v, 0).sendToTarget();
            while(((xm)fd0.f) == null && fd0.d == null && fd0.c == null) {
                try {
                    fd0.wait();
                }
                catch(InterruptedException unused_ex) {
                    z1 = true;
                }
            }
        }
        if(z1) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException0 = fd0.d;
        if(runtimeException0 != null) {
            throw runtimeException0;
        }
        Error error0 = fd0.c;
        if(error0 != null) {
            throw error0;
        }
        xm xm0 = (xm)fd0.f;
        xm0.getClass();
        return xm0;
    }

    public static boolean c(Context context0) {
        boolean z = true;
        synchronized(xm.class) {
            if(!xm.d) {
                xm.c = xm.a(context0);
                xm.d = true;
            }
            if(xm.c == 0) {
                z = false;
            }
            return z;
        }
    }

    @Override  // android.view.Surface
    public final void release() {
        super.release();
        synchronized(this.a) {
            if(!this.b) {
                this.a.b.getClass();
                this.a.b.sendEmptyMessage(2);
                this.b = true;
            }
        }
    }
}

