package ef;

import Hf.B;
import Hf.I;
import Hf.P;
import Hf.a0;
import Hf.p;
import Hf.x;
import If.d;
import Me.e;
import Tf.o;
import U4.F;
import e.k;
import ie.m;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import sf.g;

public final class h extends p {
    public h(B b0, B b1) {
        q.g(b0, "lowerBound");
        q.g(b1, "upperBound");
        super(b0, b1);
        d.a.b(b0, b1);
    }

    @Override  // Hf.p
    public final Af.p E() {
        Me.h h0 = this.w().e();
        e e0 = h0 instanceof e ? ((e)h0) : null;
        if(e0 == null) {
            throw new IllegalStateException(("Incorrect classifier: " + this.w().e()).toString());
        }
        Af.p p0 = e0.q0(new f());
        q.f(p0, "getMemberScope(...)");
        return p0;
    }

    @Override  // Hf.x
    public final x H(If.f f0) {
        q.g(f0, "kotlinTypeRefiner");
        q.g(this.b, "type");
        q.g(this.c, "type");
        return new h(this.b, this.c);  // 初始化器: LHf/p;-><init>(LHf/B;LHf/B;)V
    }

    @Override  // Hf.a0
    public final a0 J(boolean z) {
        return new h(this.b.V(z), this.c.V(z));
    }

    @Override  // Hf.a0
    public final a0 M(If.f f0) {
        q.g(f0, "kotlinTypeRefiner");
        q.g(this.b, "type");
        q.g(this.c, "type");
        return new h(this.b, this.c);  // 初始化器: LHf/p;-><init>(LHf/B;LHf/B;)V
    }

    @Override  // Hf.a0
    public final a0 S(I i0) {
        q.g(i0, "newAttributes");
        return new h(this.b.W(i0), this.c.W(i0));
    }

    @Override  // Hf.p
    public final B V() {
        return this.b;
    }

    @Override  // Hf.p
    public final String W(g g0, g g1) {
        B b0 = this.b;
        String s = g0.X(b0);
        B b1 = this.c;
        String s1 = g0.X(b1);
        if(g1.a.n()) {
            return "raw (" + s + ".." + s1 + ')';
        }
        if(b1.r().isEmpty()) {
            return g0.F(s, s1, F.u(this));
        }
        ArrayList arrayList0 = h.Y(g0, b0);
        ArrayList arrayList1 = h.Y(g0, b1);
        String s2 = je.p.q0(arrayList0, ", ", null, null, ef.g.a, 30);
        ArrayList arrayList2 = je.p.W0(arrayList0, arrayList1);
        if(!arrayList2.isEmpty()) {
            for(Object object0: arrayList2) {
                String s3 = o.N0(((String)((m)object0).b), "out ");
                if(!q.b(((String)((m)object0).a), s3) && !((String)((m)object0).b).equals("*")) {
                    goto label_20;
                }
            }
        }
        s1 = h.b0(s1, s2);
    label_20:
        String s4 = h.b0(s, s2);
        return q.b(s4, s1) ? s4 : g0.F(s4, s1, F.u(this));
    }

    public static final ArrayList Y(g g0, x x0) {
        Iterable iterable0 = x0.r();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            q.g(((P)object0), "typeProjection");
            StringBuilder stringBuilder0 = new StringBuilder();
            je.p.p0(k.z(((P)object0)), stringBuilder0, ", ", null, null, new sf.f(g0, 0), 60);
            arrayList0.add(stringBuilder0.toString());
        }
        return arrayList0;
    }

    public static final String b0(String s, String s1) {
        return o.w0(s, '<') ? o.a1(s, '<') + '<' + s1 + '>' + o.Y0('>', s, s) : s;
    }
}

