package vd;

import Cc.N1;
import Cc.e0;
import P0.h;
import P0.i;
import P0.k;
import T.d;
import T.e;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.y;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import d3.g;
import f1.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;
import we.o;
import y0.M;

public final class j implements o {
    public final b0 a;
    public final String b;
    public final int c;

    public j(b0 b00, String s, int v) {
        this.a = b00;
        this.b = s;
        this.c = v;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        p p1;
        int v = (int)(((Integer)object2));
        q.g(((n)object0), "innerTextField");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).i(((n)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            d d0 = e.b(4.0f);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.q.f(d5.n.o(n0, d0), e0.T(p0, 0x7F0604AB), M.a);  // color:white001s
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060154), 0.5f);  // color:gray200s_support_high_contrast
            d d1 = e.b(4.0f);
            r0.q q1 = a.n(a.l(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d1), 12.0f, 0.0f, 2), 0.0f, 12.0f, 0.0f, 5.0f, 5);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            w.x(p0, q2, P0.j.d);
            b0 b00 = this.a;
            if(Tf.o.g1(((x)b00.getValue()).a.b).toString().length() == 0) {
                p0.a0(-30007700);
                N1.b((this.b == null ? "" : this.b), null, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray600s_support_high_contrast
                p1 = p0;
            }
            else {
                p1 = p0;
                p1.a0(-61767107);
            }
            p1.p(false);
            ((n)object0).invoke(p1, ((int)(v & 14)));
            int v2 = this.c;
            if(v2 > 0) {
                p1.a0(0xFE3C0248);
                g.j((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.i), Tf.o.g1(((x)b00.getValue()).a.b).toString(), String.valueOf(v2), p1, 0);
            }
            else {
                p1.a0(-61767107);
            }
            p1.p(false);
            p1.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

