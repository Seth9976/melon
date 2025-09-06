package md;

import Cc.I0;
import Cc.e0;
import Cc.f0;
import I.u0;
import M.c;
import N0.M;
import O.F;
import O.I;
import P0.j;
import android.content.Context;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.q;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.lifecycle.y;
import cd.V2;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.HashMap;
import k8.Y;
import nd.a;
import nd.b;
import r0.g;
import r0.i;
import r0.n;
import wc.u;

public final class h {
    public final y a;
    public final b0 b;
    public f c;
    public boolean d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final float j;
    public float k;
    public int l;
    public float m;
    public float n;
    public float o;
    public final b0 p;
    public float q;
    public final HashMap r;
    public final a0 s;
    public boolean t;
    public final Z u;
    public a v;
    public V2 w;

    public h(y y0) {
        this.b = w.s(b.a);
        this.c = f.c;
        this.j = 118.0f;
        this.p = w.s(Boolean.FALSE);
        this.r = new HashMap();
        this.s = w.p(0);
        this.u = w.o(0.0f);
        this.a = y0;
    }

    public final void a(l l0, int v) {
        ((p)l0).c0(1008253527);
        int v1 = (((p)l0).i(this) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            m0.b b0 = null;
            m0.b b1 = this.v == null ? null : this.v.k;
            if(b1 == null) {
                ((p)l0).a0(0x819DF7C2);
            }
            else {
                ((p)l0).a0(-1730966497);
                b1.invoke(((p)l0), 0);
            }
            ((p)l0).p(false);
            a a0 = this.v;
            if(a0 != null) {
                b0 = a0.l;
            }
            if(b0 == null) {
                ((p)l0).a0(-2120307230);
            }
            else {
                ((p)l0).a0(0x98D391FF);
                b0.invoke(((p)l0), 0);
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new md.a(this, v, 1);
        }
    }

    public final void b(l l0, int v) {
        V v8;
        V v4;
        p p0 = (p)l0;
        p0.c0(0x7BBDFDFD);
        int v1 = (p0.i(this) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            a a0 = this.v;
            if(a0 == null) {
                n0 n00 = p0.t();
                if(n00 != null) {
                    n00.d = new md.a(this, v, 2);
                }
            }
            else {
                Q0 q00 = q.t(p0);
                F f0 = I.a(0, 0, 3, p0);
                Integer integer0 = ((K0)this.s).m();
                boolean z = p0.i(this);
                boolean z1 = p0.g(f0);
                md.b b0 = p0.N();
                V v2 = k.a;
                if(z || z1 || b0 == v2) {
                    b0 = new md.b(this, f0, null);
                    p0.l0(b0);
                }
                J.d(p0, integer0, b0);
                float f1 = this.e - (this.d ? this.h : 0.0f) - this.n;
                e e0 = p0.N();
                if(e0 == v2) {
                    e0 = new e(f0, this, f1);
                    p0.l0(e0);
                }
                n n0 = n.a;
                r0.q q0 = r0.a.e(d.h(d.f(n0, 1.0f), f0.a + (this.d ? this.g : 0.0f)), 5.0f);
                i i0 = r0.d.a;
                M m0 = M.p.d(i0, false);
                int v3 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                P0.i i1 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                P0.h h0 = j.f;
                w.x(p0, m0, h0);
                P0.h h1 = j.e;
                w.x(p0, i00, h1);
                P0.h h2 = j.g;
                if(p0.O) {
                    v4 = v2;
                    A7.d.q(v3, p0, v3, h2);
                }
                else {
                    v4 = v2;
                    if(!kotlin.jvm.internal.q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h2);
                    }
                }
                P0.h h3 = j.d;
                w.x(p0, q1, h3);
                long v5 = e0.T(p0, (((Boolean)((O0)this.p).getValue()).booleanValue() ? 0x7F0604AA : 0x7F06048A));  // color:white000s_support_high_contrast
                u u0 = y0.M.a;
                r0.q q2 = q.f(n0, v5, u0);
                M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v6 = p0.P;
                M.d d0 = M.j.c;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                p0.e0();
                g g0 = r0.d.m;
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
                w.x(p0, q3, h3);
                if(this.d) {
                    p0.a0(0xA8946B1D);
                    c.d(p0, d.h(d.f(n0, 1.0f), this.g));
                }
                else {
                    p0.a0(-1481708095);
                }
                p0.p(false);
                m0.b b1 = a0.f;
                if(b1 == null) {
                    p0.a0(-1466466760);
                }
                else {
                    p0.a0(0x15F45EE9);
                    b1.invoke(p0, 0);
                }
                p0.p(false);
                p0.p(true);
                p0.p(true);
                r0.q q4 = androidx.compose.ui.input.nestedscroll.a.a(q.f(n0, e0.T(p0, 0x7F0604AA), u0), e0, null);  // color:white000s_support_high_contrast
                M m1 = M.p.d(i0, false);
                int v7 = p0.P;
                i0 i02 = p0.m();
                r0.q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q5, h3);
                m0.b b2 = a0.i;
                if(b2 == null) {
                    p0.a0(902640479);
                }
                else {
                    p0.a0(0xD02FE8E2);
                    b2.invoke(androidx.compose.foundation.layout.a.c(0.0f, a0.d + a0.e, 0.0f, this.j, 5), f0, p0, 0);
                }
                p0.p(false);
                r0.q q6 = d.k(d.f(n0, 1.0f), ((float)(a0.d + a0.e)));
                boolean z2 = p0.i(this);
                hd.i i2 = p0.N();
                if(z2) {
                    v8 = v4;
                    i2 = new hd.i(this, 19);
                    p0.l0(i2);
                }
                else {
                    v8 = v4;
                    if(i2 == v8) {
                        i2 = new hd.i(this, 19);
                        p0.l0(i2);
                    }
                }
                r0.q q7 = androidx.compose.foundation.layout.a.f(q6, i2);
                boolean z3 = p0.i(this);
                boolean z4 = p0.d(f1);
                I0 i03 = p0.N();
                if(z3 || z4 || i03 == v8) {
                    i03 = new I0(f1, 6, this);
                    p0.l0(i03);
                }
                r0.q q8 = androidx.compose.foundation.gestures.a.b(androidx.compose.ui.graphics.a.a(q7, i03), q00, u0.a, false, false, 60);
                M.y y1 = M.w.a(d0, g0, p0, 0);
                int v9 = p0.P;
                i0 i04 = p0.m();
                r0.q q9 = r0.a.d(p0, q8);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y1, h0);
                w.x(p0, i04, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h2);
                }
                w.x(p0, q9, h3);
                r0.q q10 = d.h(d.f(n0, 1.0f), ((float)a0.d));
                M m2 = M.p.d(i0, false);
                int v10 = p0.P;
                i0 i05 = p0.m();
                r0.q q11 = r0.a.d(p0, q10);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m2, h0);
                w.x(p0, i05, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                    A7.d.q(v10, p0, v10, h2);
                }
                w.x(p0, q11, h3);
                m0.b b3 = a0.g;
                if(b3 == null) {
                    p0.a0(0x92FA2A35);
                }
                else {
                    p0.a0(0x4BDBF4C);
                    b3.invoke(p0, 0);
                }
                p0.p(false);
                p0.p(true);
                r0.q q12 = d.h(d.f(n0, 1.0f), ((float)a0.e));
                M m3 = M.p.d(i0, false);
                int v11 = p0.P;
                i0 i06 = p0.m();
                r0.q q13 = r0.a.d(p0, q12);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m3, h0);
                w.x(p0, i06, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
                w.x(p0, q13, h3);
                m0.b b4 = a0.h;
                if(b4 == null) {
                    p0.a0(1121687180);
                }
                else {
                    p0.a0(0xE961EC15);
                    b4.invoke(p0, 0);
                }
                p0.p(false);
                A7.d.s(p0, true, true, true);
                m0.b b5 = a0.l;
                if(b5 == null) {
                    p0.a0(51832092);
                }
                else {
                    p0.a0(-2076537979);
                    b5.invoke(p0, 0);
                }
                p0.p(false);
                m0.b b6 = a0.j;
                if(b6 == null) {
                    p0.a0(0x317B27C);
                }
                else {
                    p0.a0(-2076536283);
                    b6.invoke(p0, 0);
                }
                p0.p(false);
                goto label_207;
            }
        }
        else {
            p0.T();
        label_207:
            n0 n01 = p0.t();
            if(n01 != null) {
                n01.d = new md.a(this, v, 3);
            }
        }
    }

    public final float c() {
        return ((androidx.compose.runtime.I0)this.u).m();
    }

    public final void d(a a0) {
        this.d = a0.a;
        int v = ((K0)this.s).m();
        ((K0)this.s).n(v + 1);
        this.e(0.0f);
        this.q = 0.0f;
        ((O0)this.p).setValue(Boolean.FALSE);
        this.o = 0.0f;
        this.r.clear();
        Context context0 = Y.a(MelonAppBase.Companion);
        float f = (float)ScreenUtils.getStatusBarHeight(context0);
        this.h = f;
        this.g = (float)ScreenUtils.pixelToDip(context0, ((int)f));
        this.e = (float)ScreenUtils.dipToPixel(context0, ((float)a0.d));
        this.f = (float)ScreenUtils.dipToPixel(context0, ((float)(a0.d + a0.e)));
        ScreenUtils.dipToPixel(context0, this.g + 0.0f);
        this.n = (float)ScreenUtils.dipToPixel(context0, ((float)a0.c));
        this.i = (float)ScreenUtils.getRealScreenSize(context0).y;
        this.k = (float)ScreenUtils.dipToPixel(context0, this.j);
        this.l = ScreenUtils.isPortrait(context0) ? ScreenUtils.INSTANCE.getNavigationBarHeight(context0) : 0;
        float f1 = this.f;
        float f2 = this.i;
        this.m = f1 > f2 ? (f1 - f2) / 2.0f : 0.0f;
        V2 v20 = this.w;
        if(v20 != null) {
            v20.invoke(0.0f, Boolean.FALSE);
            return;
        }
        kotlin.jvm.internal.q.m("onCollapsed");
        throw null;
    }

    public final void e(float f) {
        ((androidx.compose.runtime.I0)this.u).n(f);
    }
}

