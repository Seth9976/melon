package hd;

import Cc.E;
import Cc.N1;
import Cc.e0;
import H0.e;
import M.j;
import M.n0;
import M.p0;
import M.v;
import M.w;
import M.y;
import P0.h;
import P0.i;
import U4.x;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;
import r1.f;

public final class o implements we.o {
    public final String a;
    public final float b;
    public final String c;

    public o(String s, String s1, float f) {
        this.a = s;
        this.b = f;
        this.c = s1;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            boolean z = p0.d(((c)(((v)object0))).c());
            String s = this.a;
            boolean z1 = p0.g(s);
            f f0 = p0.N();
            if(z || z1 || f0 == k.a) {
                f0 = new f(((c)(((v)object0))).c() - this.b - 20.0f - 20.0f);
                p0.l0(f0);
            }
            float f1 = f0.a;
            n n0 = n.a;
            r0.q q0 = d.t(d.f(n0, 1.0f), 3);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = d.t(x.s(n0, 15.0f, p0, n0, 1.0f), 3);
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            M.c.d(p0, d.q(n0, 20.0f));
            r0.q q4 = d.t(d.s(n0, 0.0f, f1, 1), 3);
            long v3 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(this.c, q4, v3, 30.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            N1.b(s, d.t(d.v(n0, null, 3), 3), e0.T(p0, 0x7F06016D), 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray900s
            x.z(n0, 20.0f, p0, true);
            r0.q q5 = androidx.compose.foundation.layout.a.h(androidx.compose.foundation.layout.a.n(d.t(d.f(n0, 1.0f), 3), 20.0f, 0.0f, 20.0f, 0.0f, 10), 0.0f, -3.0f, 1);
            String s1 = e.Y(p0, 0x7F13035C);  // string:dna_main_main_title_sub "뮤직 DNA 타입은?"
            String s2 = e.Y(p0, 0x7F13035D);  // string:dna_main_main_title_sub_replace_bold_text "뮤직 DNA"
            String s3 = e.Y(p0, 0x7F13035D);  // string:dna_main_main_title_sub_replace_bold_text "뮤직 DNA"
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            E.a(q5, s1, s2, s3, 0, 30.0f, e0.T(p0, 0x7F06016D), v4, e1.y.i, 1, 0, null, 0.0f, null, null, p0, 0x36030006, 0, 0xFC10);  // color:gray900s
            p0.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

