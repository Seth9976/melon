package w8;

import B2.n;
import Cc.E3;
import Cc.e0;
import Cc.k;
import O2.e;
import P4.a;
import U4.F;
import V4.u;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.playback.Actor;
import kc.s2;
import kotlinx.coroutines.flow.Flow;
import m0.c;
import ob.z;

public final class q extends w0 {
    public final String h;
    public final String i;
    public final Actor j;
    public final int k;
    public static final int l;

    public q() {
        this.h = "Widget22SkinType";
        this.i = "Widget22Skin";
        this.j = Actor.Widget_2x2;
        this.k = 0x9E;
    }

    @Override  // w8.T
    public final Actor d() {
        return this.j;
    }

    @Override  // w8.w0
    public final void m(Flow flow0, z z0, s2 s20, boolean z1, long v, l l0, int v1) {
        kotlin.jvm.internal.q.g(flow0, "playbackStateFlow");
        kotlin.jvm.internal.q.g(s20, "playlistManager");
        ((p)l0).c0(0x3FFB6A8D);
        int v2 = v1 | (((p)l0).i(z0) ? 0x20 : 16) | (((p)l0).g(s20) ? 0x100 : 0x80) | (((p)l0).h(z1) ? 0x800 : 0x400) | (((p)l0).f(v) ? 0x4000 : 0x2000) | (((p)l0).i(this) ? 0x20000 : 0x10000);
        if(((p)l0).Q(v2 & 1, (74897 & v2) != 0x12490)) {
            a.a(B.a.l(u.o(u.w(B2.l.a, 100.0f)), v), 0, 0, c.e(0xD4AF9557, ((p)l0), new Dc.a(this, s20, z0, z1, 9)), ((p)l0), 0xC00, 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new qd.a(this, flow0, z0, s20, z1, v, v1, 2);
        }
    }

    @Override  // w8.w0
    public final void n(Flow flow0, z z0, s2 s20, boolean z1, long v, boolean z2, int v1, l l0, int v2) {
        kotlin.jvm.internal.q.g(flow0, "playbackStateFlow");
        kotlin.jvm.internal.q.g(s20, "playlistManager");
        ((p)l0).c0(0xDA271F48);
        int v3 = v2 | (((p)l0).i(z0) ? 0x20 : 16) | (((p)l0).g(s20) ? 0x100 : 0x80) | (((p)l0).h(z1) ? 0x800 : 0x400) | (((p)l0).f(v) ? 0x4000 : 0x2000);
        if((v2 & 0x30000) == 0) {
            v3 |= (((p)l0).h(z2) ? 0x20000 : 0x10000);
        }
        int v4 = v3 | (((p)l0).e(v1) ? 0x100000 : 0x80000) | (((p)l0).i(this) ? 0x800000 : 0x400000);
        if(((p)l0).Q(v4 & 1, (0x492491 & v4) != 0x492490)) {
            a.a(B.a.l(u.o(u.w(B2.l.a, ((float)v1))), v), !z2, 0, c.e(1145123390, ((p)l0), new h(this, s20, z0, z2, z1, 2)), ((p)l0), 0xC00, 4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E3(this, flow0, z0, s20, z1, v, z2, v1, v2, 2);
        }
    }

    @Override  // w8.w0
    public final String q() {
        return this.i;
    }

    @Override  // w8.w0
    public final String r() {
        return this.h;
    }

    @Override  // w8.w0
    public final int u() {
        return this.k;
    }

    public final void w(n n0, String s, String s1, boolean z, boolean z1, l l0, int v) {
        ((p)l0).c0(0xF506D16E);
        int v1 = v | (((p)l0).g(n0) ? 4 : 2) | (((p)l0).g(s) ? 0x20 : 16) | (((p)l0).g(s1) ? 0x100 : 0x80) | (((p)l0).h(z) ? 0x800 : 0x400) | (((p)l0).i(this) ? 0x20000 : 0x10000);
        if(((p)l0).Q(v1 & 1, (74899 & v1) != 74898)) {
            a.a(e0.U(n0.b(new J2.q(Q1.c.X(20.0f), Q1.c.X(0.0f), Q1.c.X(20.0f), Q1.c.X(0.0f))), this.t(((Context)((p)l0).k(B2.h.b)))), 0, 0, c.e(1209236324, ((p)l0), new h(this, s, z, z1, s1)), ((p)l0), 0xC00, 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new k(this, n0, s, s1, z, z1, v);
        }
    }

    public final void x(z z0, s2 s20, boolean z1, boolean z2, boolean z3, l l0, int v) {
        ((p)l0).c0(0x6FD30734);
        int v1 = v | (((p)l0).i(z0) ? 4 : 2) | (((p)l0).g(s20) ? 0x20 : 16) | (((p)l0).h(z1) ? 0x100 : 0x80) | (((p)l0).h(z2) ? 0x800 : 0x400) | (((p)l0).i(this) ? 0x20000 : 0x10000);
        if(((p)l0).Q(v1 & 1, (74899 & v1) != 74898)) {
            n n0 = z3 ? u.o(B2.l.a) : new J2.u(e.a);
            F.f(n0, 0, 1, c.e(-833022824, ((p)l0), new i(z3, z1, this, z0, s20, z2, 1)), ((p)l0), 0xC00, 2);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new j(this, z0, s20, z1, z2, z3, v, 1);
        }
    }
}

