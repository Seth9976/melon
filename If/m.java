package If;

import Hf.B;
import Hf.G;
import Hf.L;
import Hf.M;
import Hf.P;
import Hf.a0;
import Hf.b0;
import Hf.p;
import Hf.x;
import Jf.k;
import Jf.l;
import Kf.a;
import Kf.c;
import Kf.d;
import Kf.e;
import Kf.h;
import Me.S;
import d5.f;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;

public final class m implements b {
    public static final m a;

    static {
        m.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // If.b
    public final B A(x x0) {
        return g.h(x0);
    }

    @Override  // If.b
    public final boolean B(d d0) {
        q.g(d0, "<this>");
        B b0 = g.h(d0);
        return (b0 == null ? null : g.f(b0)) != null;
    }

    @Override  // If.b
    public final boolean C(e e0) {
        q.g(e0, "<this>");
        return g.y(g.V(e0));
    }

    @Override  // If.b
    public final c D(B b0) {
        return g.e(this, b0);
    }

    @Override  // If.b
    public final boolean E(c c0) {
        return g.J(c0);
    }

    @Override  // If.b
    public final M F(d d0) {
        q.g(d0, "<this>");
        B b0 = g.h(d0);
        if(b0 == null) {
            b0 = this.k0(d0);
        }
        return g.V(b0);
    }

    @Override  // If.b
    public final P G(d d0, int v) {
        return g.p(d0, v);
    }

    @Override  // If.b
    public final boolean H(a0 a00) {
        q.g(a00, "<this>");
        return g.F(this.k0(a00)) != g.F(this.g(a00));
    }

    @Override  // If.b
    public final boolean I(e e0) {
        q.g(e0, "<this>");
        return g.G(this.F(e0)) && !g.H(e0);
    }

    @Override  // If.b
    public final G J(d d0) {
        return g.i(d0);
    }

    @Override  // If.b
    public final boolean K(h h0) {
        return g.A(h0);
    }

    @Override  // If.b
    public final B L(p p0) {
        return g.N(p0);
    }

    @Override  // If.b
    public final boolean M(e e0) {
        q.g(e0, "<this>");
        return g.f(e0) != null;
    }

    @Override  // If.b
    public final boolean N(h h0) {
        return g.x(h0);
    }

    @Override  // If.b
    public final int O(Kf.g g0) {
        q.g(g0, "<this>");
        if(g0 instanceof e) {
            return g.c(((d)g0));
        }
        if(g0 instanceof a) {
            return ((a)g0).size();
        }
        Class class0 = g0.getClass();
        throw new IllegalStateException(("unknown type argument list type: " + g0 + ", " + I.a.b(class0)).toString());
    }

    @Override  // If.b
    public final B P(p p0) {
        return g.X(p0);
    }

    @Override  // If.b
    public final a0 Q(P p0) {
        return g.r(this, p0);
    }

    @Override  // If.b
    public final boolean R(S s0, h h0) {
        return g.v(s0, h0);
    }

    @Override  // If.b
    public final boolean S(d d0) {
        return g.F(d0);
    }

    @Override  // If.b
    public final d T(d d0) {
        return g.Z(this, d0);
    }

    @Override  // If.b
    public final If.a U(e e0) {
        return g.T(this, e0);
    }

    @Override  // If.b
    public final B V(p p0) {
        return g.N(p0);
    }

    @Override  // If.b
    public final void W(e e0) {
        g.L(e0);
    }

    @Override  // If.b
    public final int X(d d0) {
        return g.c(d0);
    }

    @Override  // If.b
    public final Kf.b Y(c c0) {
        return g.k(c0);
    }

    @Override  // If.b
    public final i Z(c c0) {
        return g.W(c0);
    }

    @Override  // If.b
    public final boolean a(e e0) {
        return g.B(e0);
    }

    @Override  // If.b
    public final void a0(e e0) {
        g.M(e0);
    }

    @Override  // If.b
    public final boolean b(e e0, e e1) {
        return g.w(e0, e1);
    }

    @Override  // If.b
    public final B b0(e e0) {
        return g.Y(e0, false);
    }

    @Override  // If.b
    public final Collection c(e e0) {
        return g.R(this, e0);
    }

    @Override  // If.b
    public final B c0(d d0) {
        return g.h(d0);
    }

    @Override  // If.b
    public final Kf.i d(S s0) {
        q.g(s0, "$receiver");
        b0 b00 = s0.y();
        q.f(b00, "getVariance(...)");
        return f.m(b00);
    }

    @Override  // If.b
    public final P d0(e e0, int v) {
        q.g(e0, "<this>");
        return v < 0 || v >= g.c(e0) ? null : g.p(e0, v);
    }

    @Override  // If.b
    public final boolean e(h h0, h h1) {
        return g.b(h0, h1);
    }

    @Override  // If.b
    public final Kf.g e0(e e0) {
        return g.d(e0);
    }

    @Override  // If.b
    public final boolean f(d d0) {
        q.g(d0, "$receiver");
        return d0 instanceof hf.f;
    }

    @Override  // If.b
    public final P f0(uf.b b0) {
        return g.S(b0);
    }

    @Override  // If.b
    public final B g(d d0) {
        q.g(d0, "<this>");
        p p0 = g.g(d0);
        if(p0 != null) {
            B b0 = g.X(p0);
            if(b0 != null) {
                return b0;
            }
        }
        B b1 = g.h(d0);
        q.d(b1);
        return b1;
    }

    @Override  // If.b
    public final boolean g0(h h0) {
        return g.z(h0);
    }

    @Override  // If.b
    public final boolean h(h h0) {
        return g.D(h0);
    }

    @Override  // If.b
    public final boolean h0(h h0) {
        return g.E(h0);
    }

    @Override  // If.b
    public final void i(e e0, h h0) {
    }

    @Override  // If.b
    public final Collection i0(h h0) {
        return g.U(h0);
    }

    @Override  // If.b
    public final Kf.i j(P p0) {
        return g.t(p0);
    }

    @Override  // If.b
    public final boolean j0(P p0) {
        return g.K(p0);
    }

    @Override  // If.b
    public final M k(e e0) {
        return g.V(e0);
    }

    @Override  // If.b
    public final B k0(d d0) {
        q.g(d0, "<this>");
        p p0 = g.g(d0);
        if(p0 != null) {
            B b0 = g.N(p0);
            if(b0 != null) {
                return b0;
            }
        }
        B b1 = g.h(d0);
        q.d(b1);
        return b1;
    }

    @Override  // If.b
    public final boolean l(e e0) {
        return g.D(g.V(e0));
    }

    @Override  // If.b
    public final B l0(e e0) {
        return g.j(e0);
    }

    @Override  // If.b
    public final boolean m(h h0) {
        return g.y(h0);
    }

    @Override  // If.b
    public final boolean m0(c c0) {
        q.g(c0, "$receiver");
        return c0 instanceof uf.a;
    }

    @Override  // If.b
    public final a0 n(d d0) {
        return g.P(d0);
    }

    @Override  // If.b
    public final boolean n0(h h0) {
        return g.G(h0);
    }

    @Override  // If.b
    public final B o(p p0) {
        return g.X(p0);
    }

    @Override  // If.b
    public final int o0(h h0) {
        return g.Q(h0);
    }

    @Override  // If.b
    public final a0 p(c c0) {
        return g.O(c0);
    }

    public final d p0(d d0) {
        q.g(d0, "<this>");
        B b0 = g.h(d0);
        if(b0 != null) {
            d d1 = g.Y(b0, true);
            return d1 == null ? d0 : d1;
        }
        return d0;
    }

    @Override  // If.b
    public final boolean q(d d0) {
        q.g(d0, "<this>");
        return !q.b(g.V(this.k0(d0)), g.V(this.g(d0)));
    }

    public final L q0() {
        return g.l(false, this, null, 24);
    }

    @Override  // If.b
    public final S r(h h0, int v) {
        return g.q(h0, v);
    }

    @Override  // If.b
    public final void s(d d0) {
        q.g(d0, "<this>");
        g.g(d0);
    }

    @Override  // If.b
    public final a0 t(ArrayList arrayList0) {
        B b0;
        switch(arrayList0.size()) {
            case 0: {
                throw new IllegalStateException("Expected some types");
            }
            case 1: {
                return (a0)je.p.D0(arrayList0);
            }
            default: {
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                boolean z = false;
                boolean z1 = false;
                for(Object object0: arrayList0) {
                    a0 a00 = (a0)object0;
                    z = z || Hf.c.k(a00);
                    if(a00 instanceof B) {
                        b0 = (B)a00;
                    }
                    else {
                        if(!(a00 instanceof p)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        q.g(a00, "<this>");
                        b0 = ((p)a00).b;
                        z1 = true;
                    }
                    arrayList1.add(b0);
                }
                if(z) {
                    return l.c(k.N, new String[]{arrayList0.toString()});
                }
                t t0 = t.a;
                if(!z1) {
                    return t0.b(arrayList1);
                }
                ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    arrayList2.add(Hf.c.E(((a0)object1)));
                }
                return Hf.c.f(t0.b(arrayList1), t0.b(arrayList2));
            }
        }
    }

    @Override  // If.b
    public final a0 u(Kf.f f0, Kf.f f1) {
        return g.m(this, f0, f1);
    }

    @Override  // If.b
    public final B v(e e0) {
        return g.Y(e0, true);
    }

    @Override  // If.b
    public final boolean w(e e0) {
        q.g(e0, "<this>");
        B b0 = g.h(e0);
        return (b0 == null ? null : this.y(b0)) != null;
    }

    @Override  // If.b
    public final p x(d d0) {
        return g.g(d0);
    }

    @Override  // If.b
    public final c y(e e0) {
        q.g(e0, "<this>");
        q.g(e0, "<this>");
        Hf.l l0 = g.f(e0);
        if(l0 != null) {
            return l0.b == null ? g.e(this, ((Kf.f)e0)) : g.e(this, l0.b);
        }
        return g.e(this, ((Kf.f)e0));
    }

    @Override  // If.b
    public final P z(Kf.g g0, int v) {
        q.g(g0, "<this>");
        if(g0 instanceof Kf.f) {
            return g.p(((d)g0), v);
        }
        if(g0 instanceof a) {
            Object object0 = ((a)g0).get(v);
            q.f(object0, "get(...)");
            return (P)object0;
        }
        Class class0 = g0.getClass();
        throw new IllegalStateException(("unknown type argument list type: " + g0 + ", " + I.a.b(class0)).toString());
    }
}

