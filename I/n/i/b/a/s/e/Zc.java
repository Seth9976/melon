package i.n.i.b.a.s.e;

import Nf.p;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;
import java.util.List;

public final class zc implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, R6, S3, W6, Y, d8 {
    public final Bc a;

    public zc(Bc bc0) {
        this.a = bc0;
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void A(p p0) {
        this.a.k.A(p0);
        this.a.f0.A(p0);
        this.a.getClass();
        this.a.getClass();
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void D(p p0) {
        this.a.getClass();
        this.a.k.D(p0);
        this.a.f0.D(p0);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void H() {
        this.a.f0.H();
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void I(p p0) {
        this.a.k.I(p0);
        this.a.g0.I(p0);
        this.a.getClass();
        this.a.getClass();
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void K(p p0) {
        this.a.getClass();
        this.a.k.K(p0);
        this.a.g0.K(p0);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void M(long v, String s, long v1) {
        this.a.k.M(v, s, v1);
        this.a.f0.M(v, s, v1);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void N(long v, String s, long v1) {
        this.a.k.N(v, s, v1);
        this.a.g0.N(v, s, v1);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void O(IllegalStateException illegalStateException0) {
        this.a.k.O(illegalStateException0);
        this.a.f0.O(illegalStateException0);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void Q(IllegalStateException illegalStateException0) {
        this.a.k.Q(illegalStateException0);
        this.a.g0.Q(illegalStateException0);
    }

    @Override  // i.n.i.b.a.s.e.R6
    public final void U(int v, boolean z) {
        Bc.G1(this.a);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void a(long v) {
        this.a.k.getClass();
        this.a.g0.a(v);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void a(String s) {
        this.a.k.a(s);
        this.a.f0.a(s);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void a(boolean z) {
        Bc bc0 = this.a;
        if(bc0.Y == z) {
            return;
        }
        bc0.Y = z;
        bc0.k.a(z);
        for(Object object0: bc0.g) {
            ((S5)object0).a(bc0.Y);
        }
        bc0.g0.a(bc0.Y);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void b(String s) {
        this.a.k.b(s);
        this.a.g0.b(s);
    }

    @Override  // i.n.i.b.a.s.e.d8
    public final void b(List list0) {
        this.a.Z = list0;
        for(Object object0: this.a.h) {
            ((d8)object0).b(list0);
        }
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void c(int v, long v1) {
        this.a.k.c(v, v1);
        this.a.f0.c(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void c(long v) {
        this.a.k.c(v);
        this.a.g0.c(v);
    }

    @Override  // i.n.i.b.a.s.e.R6
    public final void c(boolean z) {
        this.a.getClass();
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void d() {
        this.a.f0.d();
    }

    @Override  // i.n.i.b.a.s.e.Y
    public final void d(x8 x80) {
        Bc bc0 = this.a;
        bc0.k.d(x80);
        O8 o80 = bc0.d;
        L l0 = o80.N.a();
        for(int v = 0; true; ++v) {
            b[] arr_x8$b = x80.a;
            if(v >= arr_x8$b.length) {
                break;
            }
            arr_x8$b[v].V(l0);
        }
        M m0 = new M(l0);
        if(!m0.equals(o80.N)) {
            o80.N = m0;
            K1 k10 = new K1(o80, 6);
            o80.i.c(15, k10);
            o80.i.a();
        }
        for(Object object0: bc0.i) {
            ((Y)object0).d(x80);
        }
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void e() {
        this.a.f0.e();
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void f(n4 n40) {
        Bc bc0 = this.a;
        bc0.e0 = n40;
        bc0.k.f(n40);
        for(Object object0: bc0.f) {
            ((Z2)object0).f(n40);
        }
        bc0.f0.f(n40);
    }

    @Override  // i.n.i.b.a.s.e.R6
    public final void g(int v) {
        Bc.G1(this.a);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void h(Exception exception0) {
        this.a.k.h(exception0);
        this.a.g0.h(exception0);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void k(long v, int v1) {
        this.a.k.k(v, v1);
        this.a.f0.k(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void m(int v) {
        this.a.f0.m(v);
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture0, int v, int v1) {
        Surface surface0 = new Surface(surfaceTexture0);
        this.a.z1(surface0);
        this.a.E = surface0;
        this.a.D1(v, v1);
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture0) {
        this.a.z1(null);
        this.a.D1(0, 0);
        return true;
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture0, int v, int v1) {
        this.a.D1(v, v1);
    }

    @Override  // android.view.TextureView$SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture0) {
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder0, int v, int v1, int v2) {
        this.a.D1(v1, v2);
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder0) {
        Bc bc0 = this.a;
        if(bc0.I) {
            bc0.z1(surfaceHolder0.getSurface());
        }
    }

    @Override  // android.view.SurfaceHolder$Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder0) {
        Bc bc0 = this.a;
        if(bc0.I) {
            bc0.z1(null);
        }
        bc0.D1(0, 0);
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void t(int v, long v1, long v2) {
        this.a.k.t(v, v1, v2);
        this.a.g0.t(v, v1, v2);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void v(u u0, H9 h90) {
        this.a.getClass();
        this.a.k.v(u0, h90);
        this.a.f0.v(u0, h90);
    }

    @Override  // i.n.i.b.a.s.e.S3
    public final void w(long v, Object object0) {
        Bc bc0 = this.a;
        bc0.k.w(v, object0);
        if(bc0.D == object0) {
            for(Object object1: bc0.f) {
                ((Z2)object1).getClass();
            }
            bc0.f0.w(v, object0);
        }
    }

    @Override  // i.n.i.b.a.s.e.W6
    public final void x(u u0, H9 h90) {
        this.a.getClass();
        this.a.k.x(u0, h90);
        this.a.g0.x(u0, h90);
    }
}

