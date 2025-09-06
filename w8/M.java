package w8;

import B.a;
import B2.h;
import B2.n;
import Cc.E3;
import Cc.e0;
import O2.e;
import U4.F;
import V4.u;
import android.content.Context;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.playback.Actor;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import m0.c;
import ob.z;

public final class m extends w0 {
    public final String h;
    public final String i;
    public final Actor j;
    public final int k;
    public static final int l;

    public m() {
        this.h = "Widget21SkinType";
        this.i = "Widget21Skin";
        this.j = Actor.Widget_2x1;
        this.k = 84;
    }

    @Override  // w8.T
    public final Actor d() {
        return this.j;
    }

    @Override  // w8.w0
    public final void m(Flow flow0, z z0, s2 s20, boolean z1, long v, l l0, int v1) {
        b0 b03;
        b0 b02;
        q.g(flow0, "playbackStateFlow");
        q.g(s20, "playlistManager");
        p p0 = (p)l0;
        p0.c0(0x39F72ACF);
        int v2 = v1 | (p0.i(z0) ? 0x20 : 16) | (p0.g(s20) ? 0x100 : 0x80) | (p0.h(z1) ? 0x800 : 0x400) | (p0.f(v) ? 0x4000 : 0x2000) | (p0.i(this) ? 0x20000 : 0x10000);
        boolean z2 = false;
        if(p0.Q(v2 & 1, (74897 & v2) != 0x12490)) {
            Context context0 = (Context)p0.k(h.b);
            b0 b00 = p0.N();
            V v3 = k.a;
            if(b00 == v3) {
                b00 = w.s("");
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(Boolean.TRUE);
                p0.l0(b01);
            }
            Object object0 = w.e(w0.p(s20, p0), "", null, p0, 0x30, 2).getValue();
            if((v2 & 0x380) == 0x100) {
                z2 = true;
            }
            boolean z3 = p0.i(context0);
            boolean z4 = p0.i(z0);
            w8.k k0 = p0.N();
            if((z2 | z3 | z4) != 0 || k0 == v3) {
                b02 = b00;
                b03 = b01;
                w8.k k1 = new w8.k(s20, context0, z0, b02, b03, null);
                p0.l0(k1);
                k0 = k1;
            }
            else {
                b02 = b00;
                b03 = b01;
            }
            J.d(p0, object0, k0);
            F.f(a.l(u.o(u.w(B2.l.a, 48.0f)), v), 0, 1, c.e(0x9F36B7EB, p0, new g(this, z1, z0, s20, b02, b03)), p0, 0xC00, 2);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.a(this, flow0, z0, s20, z1, v, v1, 1);
        }
    }

    @Override  // w8.w0
    public final void n(Flow flow0, z z0, s2 s20, boolean z1, long v, boolean z2, int v1, l l0, int v2) {
        q.g(flow0, "playbackStateFlow");
        q.g(s20, "playlistManager");
        ((p)l0).c0(0xD422DF8A);
        int v3 = v2 | (((p)l0).i(z0) ? 0x20 : 16) | (((p)l0).g(s20) ? 0x100 : 0x80) | (((p)l0).h(z1) ? 0x800 : 0x400) | (((p)l0).f(v) ? 0x4000 : 0x2000);
        if((v2 & 0x30000) == 0) {
            v3 |= (((p)l0).h(z2) ? 0x20000 : 0x10000);
        }
        int v4 = v3 | (((p)l0).e(v1) ? 0x100000 : 0x80000) | (((p)l0).i(this) ? 0x800000 : 0x400000);
        if(((p)l0).Q(v4 & 1, (0x492491 & v4) != 0x492490)) {
            P4.a.a(a.l(u.o(u.w(B2.l.a, ((float)v1))), v), !z2, 0, c.e(0x3E3CF280, ((p)l0), new w8.h(this, s20, z0, z2, z1, 0)), ((p)l0), 0xC00, 4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E3(this, flow0, z0, s20, z1, v, z2, v1, v2, 1);
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

    public final void w(n n0, String s, boolean z, l l0, int v) {
        ((p)l0).c0(0x86928F33);
        int v1 = (((p)l0).g(n0) ? 4 : 2) | v | (((p)l0).g(s) ? 0x20 : 16) | (((p)l0).h(z) ? 0x100 : 0x80) | (((p)l0).i(this) ? 0x800 : 0x400);
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            this.b(s, ((Context)((p)l0).k(h.b)).getColor((z ? 0x7F060171 : 0x7F0604A1)), 14.0f, e0.U(n0, this.t(((Context)((p)l0).k(h.b)))), ((p)l0), v1 >> 3 & 14 | 0x180 | v1 << 3 & 0xE000, 0);  // color:gray990e
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Rc.w(this, n0, s, z, v, 7);
        }
    }

    public final void x(z z0, s2 s20, boolean z1, boolean z2, boolean z3, l l0, int v) {
        ((p)l0).c0(0x69CEC776);
        int v1 = v | (((p)l0).i(z0) ? 4 : 2) | (((p)l0).g(s20) ? 0x20 : 16) | (((p)l0).h(z1) ? 0x100 : 0x80) | (((p)l0).h(z2) ? 0x800 : 0x400) | (((p)l0).i(this) ? 0x20000 : 0x10000);
        if(((p)l0).Q(v1 & 1, (74899 & v1) != 74898)) {
            n n0 = z3 ? u.o(B2.l.a) : new J2.u(e.a);
            F.f(n0, 0, 1, c.e(0xC854D4DA, ((p)l0), new i(z3, z1, this, z0, s20, z2, 0)), ((p)l0), 0xC00, 2);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new j(this, z0, s20, z1, z2, z3, v, 0);
        }
    }
}

