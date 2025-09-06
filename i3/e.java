package i3;

import E9.u;
import I6.V;
import I6.Y;
import I6.p0;
import I6.u0;
import a3.f;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.media3.common.Metadata;
import androidx.media3.exoplayer.B;
import androidx.media3.exoplayer.w;
import androidx.media3.session.C;
import androidx.media3.session.H0;
import b3.E;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.O;
import b3.P;
import b3.Q;
import b3.S;
import b3.d;
import b3.k;
import b3.m0;
import b3.o0;
import b3.w0;
import b3.z0;
import e3.b;
import e3.j;
import e3.m;
import e3.r;
import e3.t;
import e3.x;
import h4.c;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import k3.l;
import s3.D;
import s3.q;
import s3.v;
import s3.z;

public final class e implements P, l, D {
    public final r a;
    public final m0 b;
    public final o0 c;
    public final u d;
    public final SparseArray e;
    public m f;
    public S g;
    public t h;
    public boolean i;

    public e(r r0) {
        r0.getClass();
        this.a = r0;
        this.f = new m(x.u(), r0, new c(10));
        m0 m00 = new m0();
        this.b = m00;
        this.c = new o0();
        u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        u0.a = m00;
        u0.b = p0.e;
        u0.c = u0.g;
        this.d = u0;
        this.e = new SparseArray();
    }

    @Override  // b3.P
    public final void A0(d d0) {
        this.v(this.u(), 20, new c(26));
    }

    @Override  // b3.P
    public final void B0(Metadata metadata0) {
        this.v(this.l(), 28, new i3.c(9));
    }

    @Override  // b3.P
    public final void D(b3.u0 u00) {
        this.v(this.l(), 19, new c(18));
    }

    @Override  // b3.P
    public final void G0(long v) {
        this.v(this.l(), 18, new c(17));
    }

    @Override  // b3.P
    public final void H(int v, boolean z) {
        this.v(this.l(), 30, new i3.c(0));
    }

    @Override  // b3.P
    public final void I(long v) {
        this.v(this.l(), 16, new c(16));
    }

    @Override  // b3.P
    public final void J(d3.c c0) {
        this.v(this.l(), 27, new c(14));
    }

    @Override  // b3.P
    public final void J0(G g0) {
        this.v(this.l(), 14, new c(15));
    }

    @Override  // b3.P
    public final void M(S s0, O o0) {
    }

    @Override  // b3.P
    public final void S(boolean z) {
        this.v(this.u(), 23, new c(5));
    }

    @Override  // b3.P
    public final void Y(w0 w00) {
        this.v(this.l(), 2, new c(12));
    }

    @Override  // k3.l
    public final void a(int v, z z0, int v1) {
        this.v(this.s(v, z0), 0x3FE, new i3.c(19));
    }

    @Override  // s3.D
    public final void b(int v, z z0, v v1) {
        this.v(this.s(v, z0), 1005, new i3.d(2));
    }

    @Override  // s3.D
    public final void c(int v, z z0, q q0, v v1, IOException iOException0, boolean z1) {
        a a0 = this.s(v, z0);
        this.v(a0, 1003, new com.iloen.melon.fragments.radio.a(a0, q0, v1, iOException0, z1));
    }

    @Override  // b3.P
    public final void c0(z0 z00) {
        a a0 = this.u();
        this.v(a0, 25, new w(a0, z00));
    }

    @Override  // k3.l
    public final void d(int v, z z0) {
        this.v(this.s(v, z0), 0x3FF, new c(8));
    }

    @Override  // k3.l
    public final void e(int v, z z0) {
        this.v(this.s(v, z0), 0x401, new c(7));
    }

    @Override  // s3.D
    public final void f(int v, z z0, v v1) {
        a a0 = this.s(v, z0);
        this.v(a0, 1004, new H0(22, a0, v1));
    }

    @Override  // k3.l
    public final void g(int v, z z0) {
        this.v(this.s(v, z0), 0x403, new c(4));
    }

    @Override  // s3.D
    public final void h(int v, z z0, q q0, v v1) {
        this.v(this.s(v, z0), 1000, new c(13));
    }

    @Override  // s3.D
    public final void i(int v, z z0, q q0, v v1) {
        this.v(this.s(v, z0), 1002, new i3.c(11));
    }

    @Override  // s3.D
    public final void j(int v, z z0, q q0, v v1) {
        this.v(this.s(v, z0), 1001, new i3.d(1));
    }

    @Override  // b3.P
    public final void j0(boolean z) {
        this.v(this.l(), 3, new c(20));
    }

    @Override  // k3.l
    public final void k(int v, z z0, Exception exception0) {
        this.v(this.s(v, z0), 0x400, new i3.d(0));
    }

    @Override  // b3.P
    public final void k0(K k0) {
        a a0;
        if(k0 instanceof androidx.media3.exoplayer.l) {
            z z0 = ((androidx.media3.exoplayer.l)k0).o;
            a0 = z0 == null ? this.l() : this.q(z0);
        }
        else {
            a0 = this.l();
        }
        this.v(a0, 10, new C(a0, k0));
    }

    public final a l() {
        return this.q(((z)this.d.d));
    }

    public final a m(b3.p0 p00, int v, z z0) {
        z z1 = p00.p() ? null : z0;
        this.a.getClass();
        long v1 = SystemClock.elapsedRealtime();
        boolean z2 = p00.equals(this.g.getCurrentTimeline()) && v == this.g.L();
        long v2 = 0L;
        if(z1 == null || !z1.b()) {
            if(z2) {
                v2 = this.g.getContentPosition();
            }
            else if(!p00.p()) {
                v2 = x.Z(p00.m(v, this.c, 0L).l);
            }
        }
        else if(z2 && this.g.getCurrentAdGroupIndex() == z1.b && this.g.getCurrentAdIndexInAdGroup() == z1.c) {
            v2 = this.g.getCurrentPosition();
        }
        z z3 = (z)this.d.d;
        return new a(v1, p00, v, z1, v2, this.g.getCurrentTimeline(), this.g.L(), z3, this.g.getCurrentPosition(), this.g.getTotalBufferedDuration());
    }

    @Override  // b3.P
    public final void n(L l0) {
        this.v(this.l(), 12, new c(11));
    }

    @Override  // b3.P
    public final void n0(N n0) {
        this.v(this.l(), 13, new c(21));
    }

    @Override  // b3.P
    public final void o(k k0) {
        this.v(this.l(), 29, new i3.c(3));
    }

    @Override  // b3.P
    public final void onCues(List list0) {
        a a0 = this.l();
        this.v(a0, 27, new C5.a(a0, list0));
    }

    @Override  // b3.P
    public final void onIsPlayingChanged(boolean z) {
        this.v(this.l(), 7, new c(27));
    }

    @Override  // b3.P
    public final void onLoadingChanged(boolean z) {
    }

    @Override  // b3.P
    public final void onPlaybackSuppressionReasonChanged(int v) {
        this.v(this.l(), 6, new c(28));
    }

    @Override  // b3.P
    public final void onPlayerStateChanged(boolean z, int v) {
        this.v(this.l(), -1, new i3.c(8));
    }

    @Override  // b3.P
    public final void onPositionDiscontinuity(int v) {
    }

    @Override  // b3.P
    public final void onRenderedFirstFrame() {
    }

    @Override  // b3.P
    public final void onRepeatModeChanged(int v) {
        this.v(this.l(), 8, new i3.c(5));
    }

    @Override  // b3.P
    public final void onShuffleModeEnabledChanged(boolean z) {
        this.v(this.l(), 9, new i3.c(6));
    }

    @Override  // b3.P
    public final void onSurfaceSizeChanged(int v, int v1) {
        this.v(this.u(), 24, new i3.c(7));
    }

    @Override  // b3.P
    public final void onVolumeChanged(float f) {
        this.v(this.u(), 22, new c(25));
    }

    @Override  // b3.P
    public final void p(K k0) {
        a a0;
        if(k0 instanceof androidx.media3.exoplayer.l) {
            z z0 = ((androidx.media3.exoplayer.l)k0).o;
            a0 = z0 == null ? this.l() : this.q(z0);
        }
        else {
            a0 = this.l();
        }
        this.v(a0, 10, new c(29));
    }

    @Override  // b3.P
    public final void p0(int v, boolean z) {
        this.v(this.l(), 5, new i3.c(1));
    }

    public final a q(z z0) {
        this.g.getClass();
        b3.p0 p00 = z0 == null ? null : ((b3.p0)((Y)this.d.c).get(z0));
        if(z0 != null && p00 != null) {
            return this.m(p00, p00.g(z0.a, this.b).c, z0);
        }
        int v = this.g.L();
        b3.p0 p01 = this.g.getCurrentTimeline();
        if(v >= p01.o()) {
            p01 = b3.p0.a;
        }
        return this.m(p01, v, null);
    }

    @Override  // b3.P
    public final void r(Q q0, Q q1, int v) {
        if(v == 1) {
            this.i = false;
        }
        S s0 = this.g;
        s0.getClass();
        this.d.d = u.u(s0, ((V)this.d.b), ((z)this.d.e), ((m0)this.d.a));
        a a0 = this.l();
        this.v(a0, 11, new f(a0, v, q0, q1));
    }

    public final a s(int v, z z0) {
        this.g.getClass();
        if(z0 != null) {
            return ((b3.p0)((Y)this.d.c).get(z0)) == null ? this.m(b3.p0.a, v, z0) : this.q(z0);
        }
        b3.p0 p00 = this.g.getCurrentTimeline();
        if(v >= p00.o()) {
            p00 = b3.p0.a;
        }
        return this.m(p00, v, null);
    }

    @Override  // b3.P
    public final void s0(b3.p0 p00, int v) {
        S s0 = this.g;
        s0.getClass();
        this.d.d = u.u(s0, ((V)this.d.b), ((z)this.d.e), ((m0)this.d.a));
        b3.p0 p01 = s0.getCurrentTimeline();
        this.d.I(p01);
        this.v(this.l(), 0, new c(22));
    }

    @Override  // b3.P
    public final void t(int v, E e0) {
        this.v(this.l(), 1, new c(23));
    }

    public final a u() {
        return this.q(((z)this.d.f));
    }

    @Override  // b3.P
    public final void u0(G g0) {
        this.v(this.l(), 15, new i3.c(4));
    }

    public final void v(a a0, int v, j j0) {
        this.e.put(v, a0);
        this.f.g(v, j0);
    }

    @Override  // b3.P
    public final void w(int v) {
        this.v(this.l(), 4, new i3.c(2));
    }

    public final void x(B b0, Looper looper0) {
        b.j(this.g == null || ((V)this.d.b).isEmpty());
        b0.getClass();
        this.g = b0;
        this.h = this.a.a(looper0, null);
        m m0 = this.f;
        H0 h00 = new H0(23, this, b0);
        this.f = new m(((CopyOnWriteArraySet)m0.f), looper0, ((r)m0.c), h00, m0.b);
    }

    @Override  // b3.P
    public final void z0(long v) {
        this.v(this.l(), 17, new c(19));
    }
}

