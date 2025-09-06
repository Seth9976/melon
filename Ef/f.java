package ef;

import Ac.q0;
import Af.p;
import Hf.B;
import Hf.G;
import Hf.I;
import Hf.M;
import Hf.P;
import Hf.T;
import Hf.W;
import Hf.b0;
import Hf.x;
import Je.i;
import Jf.l;
import Me.S;
import Me.h;
import df.v;
import e.k;
import ea.c;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class f extends T {
    public final c b;
    public static final a c;
    public static final a d;

    static {
        f.c = a.a(v.L(W.b, false, null, 5), b.c, false, null, null, 61);
        f.d = a.a(v.L(W.b, false, null, 5), b.b, false, null, null, 61);
    }

    public f() {
        this.b = new c(new e());  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // Hf.T
    public final P d(x x0) {
        return new G(this.h(x0, new a(W.b, false, false, null, 62)));
    }

    public final m g(B b0, Me.e e0, a a0) {
        if(b0.w().getParameters().isEmpty()) {
            return new m(b0, Boolean.FALSE);
        }
        if(i.z(b0)) {
            P p0 = (P)b0.r().get(0);
            b0 b00 = p0.a();
            x x0 = p0.b();
            q.f(x0, "getType(...)");
            List list0 = k.z(new G(this.h(x0, a0), b00));
            return new m(Hf.c.u(b0.t(), b0.w(), list0, b0.D()), Boolean.FALSE);
        }
        if(Hf.c.k(b0)) {
            String[] arr_s = {b0.w().toString()};
            return new m(l.c(Jf.k.n, arr_s), Boolean.FALSE);
        }
        p p1 = e0.q0(this);
        q.f(p1, "getMemberScope(...)");
        I i0 = b0.t();
        M m0 = e0.q();
        q.f(m0, "getTypeConstructor(...)");
        List list1 = e0.q().getParameters();
        q.f(list1, "getParameters(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list1));
        for(Object object0: list1) {
            q.d(((S)object0));
            x x1 = this.b.h(((S)object0), a0);
            arrayList0.add(e.a(((S)object0), a0, this.b, x1));
        }
        return new m(Hf.c.w(i0, m0, arrayList0, b0.D(), p1, new q0(e0, this, b0, a0)), Boolean.TRUE);
    }

    public final x h(x x0, a a0) {
        h h0 = x0.w().e();
        if(h0 instanceof S) {
            a0.getClass();
            a a1 = a.a(a0, null, true, null, null, 59);
            return this.h(this.b.h(((S)h0), a1), a0);
        }
        if(!(h0 instanceof Me.e)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + h0).toString());
        }
        h h1 = Hf.c.E(x0).w().e();
        if(!(h1 instanceof Me.e)) {
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + h1 + "\" while for lower it\'s \"" + h0 + '\"').toString());
        }
        m m0 = this.g(Hf.c.m(x0), ((Me.e)h0), f.c);
        B b0 = (B)m0.a;
        m m1 = this.g(Hf.c.E(x0), ((Me.e)h1), f.d);
        B b1 = (B)m1.a;
        return !((Boolean)m0.b).booleanValue() && !((Boolean)m1.b).booleanValue() ? Hf.c.f(b0, b1) : new ef.h(b0, b1);
    }
}

