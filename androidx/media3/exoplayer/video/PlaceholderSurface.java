package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import i.n.i.b.a.s.e.Fd;

public final class PlaceholderSurface extends Surface {
    public final boolean a;
    public final Fd b;
    public boolean c;
    public static int d;
    public static boolean e;

    public PlaceholderSurface(Fd fd0, SurfaceTexture surfaceTexture0, boolean z) {
        super(surfaceTexture0);
        this.b = fd0;
        this.a = z;
    }

    public static boolean a(Context context0) {
        int v1;
        boolean z = false;
        synchronized(PlaceholderSurface.class) {
            if(!PlaceholderSurface.e) {
                String s = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
                if(s == null || !s.contains("EGL_EXT_protected_content")) {
                    v1 = 0;
                }
                else {
                    String s1 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
                    v1 = s1 == null || !s1.contains("EGL_KHR_surfaceless_context") ? 2 : 1;
                }
                PlaceholderSurface.d = v1;
                PlaceholderSurface.e = true;
            }
            if(PlaceholderSurface.d != 0) {
                z = true;
            }
            return z;
        }
    }

    @Override  // android.view.Surface
    public final void release() {
        super.release();
        synchronized(this.b) {
            if(!this.c) {
                this.b.b.getClass();
                this.b.b.sendEmptyMessage(2);
                this.c = true;
            }
        }
    }
}

