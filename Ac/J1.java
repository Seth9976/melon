package Ac;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Dd.Q;
import Dd.S;
import Dd.T;
import N0.M;
import P0.h;
import P0.i;
import a1.U;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.StringUtils;
import ie.H;
import java.util.Arrays;
import kotlin.jvm.internal.r;
import r0.d;
import r0.q;
import we.a;
import we.n;
import x1.e;
import x1.f;
import x1.g;
import x1.j;
import y0.P;

public final class j1 extends r implements n {
    public final int f;
    public final b0 g;
    public final j h;
    public final a i;
    public final String j;
    public final String k;

    public j1(b0 b00, j j0, a a0, String s, String s1, int v) {
        this.f = v;
        this.g = b00;
        this.h = j0;
        this.i = a0;
        this.j = s;
        this.k = s1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        j j1;
        if(this.f != 0) {
            H h0 = H.a;
            if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
                ((p)(((l)object0))).T();
                return h0;
            }
            this.g.setValue(h0);
            j j0 = this.h;
            int v = j0.b;
            j0.h();
            p p0 = (p)(((l)object0));
            p0.a0(51700930);
            e e0 = j0.e();
            e e1 = j0.e();
            e e2 = j0.e();
            g g0 = j0.c(0.078f);
            g g1 = j0.c(0.922f);
            f f0 = j0.d(0.021f);
            g g2 = j0.c(0.039f);
            g g3 = j0.c(0.961f);
            f f1 = j0.d(0.043f);
            r0.n n0 = r0.n.a;
            q q0 = e0.I(n0, 0, 3);
            boolean z = p0.g(g0);
            boolean z1 = p0.g(g1);
            Q q1 = p0.N();
            V v1 = k.a;
            if(z || z1 || q1 == v1) {
                j1 = j0;
                q1 = new Q(g0, g1, 1);
                p0.l0(q1);
            }
            else {
                j1 = j0;
            }
            M.p.a(j.b(q0, e0, q1), p0, 0);
            q q2 = e0.I(n0, 0x7F060154, 2);  // color:gray200s_support_high_contrast
            boolean z2 = p0.g(f0);
            boolean z3 = p0.g(g2);
            boolean z4 = p0.g(g3);
            S s0 = p0.N();
            if((z2 | z3 | z4) != 0 || s0 == v1) {
                s0 = new S(f0, g2, g3, 1);
                p0.l0(s0);
            }
            M.p.a(j.b(q2, e1, s0), p0, 0);
            boolean z5 = p0.g(f1);
            T t0 = p0.N();
            if(z5 || t0 == v1) {
                t0 = new T(f1, 1);
                p0.l0(t0);
            }
            q q3 = j.b(n0, e2, t0);
            M m0 = M.p.d(d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
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
            h h1 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            w.x(p0, q4, P0.j.d);
            T.d d0 = T.e.b(4.0f);
            c1.n(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), e0.T(p0, 0x7F060145), y0.M.a), this.j, null, N0.j.b, false, 0x7F080788, null, null, null, 0.0f, null, 0, 0, false, false, p0, 200064, 0, 0x7FD0);  // color:gray050s
            q q5 = androidx.compose.foundation.layout.a.n(n0, 8.0f, 6.0f, 0.0f, 0.0f, 12);
            q q6 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.a);
            N1.b(String.format(H0.e.Y(p0, 0x7F130921), Arrays.copyOf(new Object[]{StringUtils.getCountString(this.k, -1)}, 1)), q6, e0.T(p0, 0x7F0604A1), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, new U(0L, 0L, null, null, 0L, new P(e0.T(p0, 0x7F060157), 0L, 2.0f), 0, 0L, 0xFFDFFF), p0, 0xC00, 0xC30, 0xD7F0);  // string:series_playlist_count "%s개"
            p0.p(true);
            p0.p(false);
            if(j1.b != v) {
                J.h(this.i, p0);
            }
            return h0;
        }
        H h2 = H.a;
        if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
            ((p)(((l)object0))).T();
            return h2;
        }
        this.g.setValue(h2);
        j j2 = this.h;
        int v3 = j2.b;
        j2.h();
        ((p)(((l)object0))).a0(351101740);
        wa.a a0 = j2.f();
        e e3 = ((j)a0.a).e();
        e e4 = ((j)a0.a).e();
        e e5 = ((j)a0.a).e();
        r0.n n1 = r0.n.a;
        q q7 = androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 16.0f, 0.0f, 10);
        d1 d10 = ((p)(((l)object0))).N();
        V v4 = k.a;
        if(d10 == v4) {
            d10 = d1.a;
            ((p)(((l)object0))).l0(d10);
        }
        c1.n(j.b(q7, e5, d10), 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object0))), 0x1B0, 0, 0x7FF8);  // drawable:arrow_common_menu
        long v5 = e0.T(((p)(((l)object0))), 0x7F060165);  // color:gray800s
        boolean z6 = ((p)(((l)object0))).g(e5);
        e1 e10 = ((p)(((l)object0))).N();
        if(z6 || e10 == v4) {
            e10 = new e1(e5, 0);
            ((p)(((l)object0))).l0(e10);
        }
        q q8 = j.b(n1, e4, e10);
        N1.b(this.j, q8, v5, 15.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, ((p)(((l)object0))), 0xC00, 0xC00, 0x1DFF0);
        long v6 = e0.T(((p)(((l)object0))), 0x7F06017B);  // color:green500s
        boolean z7 = ((p)(((l)object0))).g(e4);
        e1 e11 = ((p)(((l)object0))).N();
        if(z7 || e11 == v4) {
            e11 = new e1(e4, 1);
            ((p)(((l)object0))).l0(e11);
        }
        q q9 = j.b(n1, e3, e11);
        N1.b(this.k, q9, v6, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((p)(((l)object0))), 0xC00, 0xC30, 0x1D7F0);
        ((p)(((l)object0))).p(false);
        if(j2.b != v3) {
            J.h(this.i, ((p)(((l)object0))));
        }
        return h2;
    }
}

