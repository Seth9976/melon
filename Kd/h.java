package kd;

import G.C;
import G.f;
import G.j;
import G.x0;
import M.v;
import N0.M;
import Q0.k0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import hd.h0;
import ie.H;
import java.util.List;
import jd.x2;
import kotlin.jvm.internal.q;
import r0.a;
import r0.i;
import r0.n;
import r1.c;
import we.k;
import we.o;

public final class h implements o {
    public final boolean a;
    public final int b;
    public final x2 c;
    public final k d;
    public final k e;
    public final long f;
    public final List g;
    public final k h;

    public h(boolean z, int v, x2 x20, k k0, k k1, long v1, List list0, k k2) {
        this.a = z;
        this.b = v;
        this.c = x20;
        this.d = k0;
        this.e = k1;
        this.f = v1;
        this.g = list0;
        this.h = k2;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        q.g(((v)object0), "$this$BoxWithConstraints");
        if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
            c c0 = (c)((p)(((l)object1))).k(k0.h);
            float f = c0.Y(38.0f);
            boolean z = this.a;
            float f1 = z ? f : ((float)this.b) * 0.7f;
            x0 x00 = f.r(150, 0, C.d, 2);
            h0 h00 = ((p)(((l)object1))).N();
            if(h00 == androidx.compose.runtime.k.a) {
                h00 = new h0(23);
                ((p)(((l)object1))).l0(h00);
            }
            b1 b10 = j.b(f1, x00, "heightAnimation", h00, ((p)(((l)object1))), 0x6C00, 4);
            p p0 = (p)(((l)object1));
            float f2 = c0.S(((Number)b10.getValue()).floatValue());
            boolean z1 = z && ((Number)b10.getValue()).floatValue() <= f;
            r0.q q0 = d.h(n.a, f2);
            i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            k k0 = this.d;
            long v2 = this.f;
            if(z1) {
                p0.a0(0x6B241E22);
                G.a(this.c, k0, this.e, v2, p0, 0);
            }
            else {
                p0.a0(0x6B297260);
                M m1 = M.p.d(i0, false);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q2 = a.d(p0, d.c);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i01, h1);
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
                w.x(p0, q2, h3);
                G.b(this.g, k0, v2, this.h, p0, 0);
                p0.p(true);
            }
            p0.p(false);
            p0.p(true);
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

