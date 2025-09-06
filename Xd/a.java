package xd;

import Cc.c1;
import Cc.e0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import Q0.N;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import ie.H;
import r0.d;
import r0.q;
import vd.G;
import we.n;
import y0.M;
import zd.Q;

public final class a implements n {
    public final int a;
    public final c b;
    public final l c;

    public a(c c0, l l0, int v) {
        this.a = v;
        this.b = c0;
        this.c = l0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            p p0 = (p)(((androidx.compose.runtime.l)object0));
            if(p0.Q(v & 1, (v & 3) != 2)) {
                c c0 = this.b;
                Q q0 = ((r)c0.getViewModel()).d;
                if(q0 instanceof com.melon.ui.popup.context.more.a) {
                    p0.a0(0xFC7FE8C1);
                    q q1 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.l(r0.n.a, 20.0f, 0.0f, 2), e0.T(p0, 0x7F0604AB), M.a), N.u(p0), null);  // color:white001s
                    boolean z = p0.i(c0);
                    G g0 = p0.N();
                    V v1 = k.a;
                    if(z || g0 == v1) {
                        g0 = new G(c0, 8);
                        p0.l0(g0);
                    }
                    q q2 = androidx.compose.ui.layout.a.f(q1, g0);
                    y y0 = w.a(j.c, d.m, p0, 0);
                    int v2 = p0.P;
                    i0 i00 = p0.m();
                    q q3 = r0.a.d(p0, q2);
                    P0.k.y.getClass();
                    i i0 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, y0, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                    h h0 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h0);
                    }
                    androidx.compose.runtime.w.x(p0, q3, P0.j.d);
                    de.c.e(new HorizontalAlignElement(d.n), 0.0f, 0.0f, null, 0L, p0, 0);
                    sd.j j0 = p0.N();
                    if(j0 == v1) {
                        j0 = new sd.j(21);
                        p0.l0(j0);
                    }
                    de.c.d(q0, j0, null, p0, 0x30, 4);
                    c1.w(((xd.j)this.c).a, null, null, 30.0f, 120.0f, p0, 0x6C00, 6);
                    p0.p(true);
                }
                else {
                    p0.a0(-65852022);
                }
                p0.p(false);
                return H.a;
            }
            p0.T();
            return H.a;
        }
        int v3 = (int)(((Integer)object1));
        if(((p)(((androidx.compose.runtime.l)object0))).Q(v3 & 1, (v3 & 3) != 2)) {
            c c1 = this.b;
            Q q4 = ((r)c1.getViewModel()).d;
            if(q4 instanceof com.melon.ui.popup.context.more.a) {
                ((p)(((androidx.compose.runtime.l)object0))).a0(0x40DA50DB);
                xd.k k0 = (xd.k)this.c;
                boolean z1 = ((p)(((androidx.compose.runtime.l)object0))).i(c1);
                xc.j j1 = ((p)(((androidx.compose.runtime.l)object0))).N();
                V v4 = k.a;
                if(z1 || j1 == v4) {
                    xc.j j2 = new xc.j(1, c1, c.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 27);
                    ((p)(((androidx.compose.runtime.l)object0))).l0(j2);
                    j1 = j2;
                }
                int v5 = c1.d;
                boolean z2 = ((p)(((androidx.compose.runtime.l)object0))).i(c1);
                xc.j j3 = ((p)(((androidx.compose.runtime.l)object0))).N();
                if(z2 || j3 == v4) {
                    xc.j j4 = new xc.j(1, c1, c.class, "updateContentHeight", "updateContentHeight(I)V", 0, 28);
                    ((p)(((androidx.compose.runtime.l)object0))).l0(j4);
                    j3 = j4;
                }
                boolean z3 = ((p)(((androidx.compose.runtime.l)object0))).i(c1);
                b b0 = ((p)(((androidx.compose.runtime.l)object0))).N();
                if(z3 || b0 == v4) {
                    b0 = new b(c1, 0);
                    ((p)(((androidx.compose.runtime.l)object0))).l0(b0);
                }
                d8.d.b(k0, ((com.melon.ui.popup.context.more.a)q4), j1, v5, j3, b0, ((p)(((androidx.compose.runtime.l)object0))), 0);
                ((p)(((androidx.compose.runtime.l)object0))).p(false);
                return H.a;
            }
            ((p)(((androidx.compose.runtime.l)object0))).a0(0x40E15A20);
            ((p)(((androidx.compose.runtime.l)object0))).p(false);
            c1.dismissAllowingStateLoss();
            return H.a;
        }
        ((p)(((androidx.compose.runtime.l)object0))).T();
        return H.a;
    }
}

