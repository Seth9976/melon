package df;

import De.t;
import De.w;
import Gf.c;
import Gf.i;
import Gf.m;
import Gf.p;
import Me.N;
import Ne.g;
import Ne.h;
import Pe.C;
import Se.x;
import com.google.firebase.messaging.u;
import com.iloen.melon.utils.a;
import h7.u0;
import i.n.i.b.a.s.e.Ga;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;

public final class q extends C {
    public final x g;
    public final u h;
    public final i i;
    public final f j;
    public final c k;
    public final h l;
    public static final w[] m;

    static {
        z z0 = new z(q.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0);
        t t0 = a.e(q.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0, I.a);
        q.m = new w[]{I.a.g(z0), t0};
    }

    public q(u u0, x x0) {
        kotlin.jvm.internal.q.g(u0, "outerContext");
        cf.a a0 = (cf.a)u0.a;
        super(a0.o, x0.a);
        this.g = x0;
        u u1 = d5.f.k(u0, this, null, 6);
        this.h = u1;
        a0.d.c().c.getClass();
        cf.a a1 = (cf.a)u1.a;
        p p0 = a1.a;
        df.p p1 = new df.p(this, 0);
        ((m)p0).getClass();
        this.i = new i(((m)p0), p1);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.j = new f(u1, x0, this);
        df.p p2 = new df.p(this, 1);
        ((m)p0).getClass();
        this.k = new c(((m)p0), p2);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        Ne.f f0 = a1.v.b ? g.a : u0.Q(u1, x0);
        this.l = f0;
        ((m)p0).a(new df.p(this, 2));
    }

    @Override  // Me.E
    public final Af.p E() {
        return this.j;
    }

    @Override  // Bf.a, Ne.a
    public final h getAnnotations() {
        return this.l;
    }

    @Override  // Pe.C
    public final N getSource() {
        return new Ga(this, 20);
    }

    @Override  // Pe.C
    public final String toString() {
        return "Lazy Java package fragment: " + this.e + " of module " + ((cf.a)this.h.a).o;
    }
}

