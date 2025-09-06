package Le;

import Ac.W;
import De.w;
import Gf.i;
import Gf.m;
import Je.o;
import Je.p;
import Oe.c;
import P4.a;
import Pe.A;
import java.util.Collection;
import je.y;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.b;
import we.k;

public final class g implements c {
    public final A a;
    public final k b;
    public final i c;
    public static final e d;
    public static final w[] e;
    public static final qf.c f;
    public static final qf.e g;
    public static final b h;

    static {
        z z0 = new z(g.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0);
        g.e = new w[]{I.a.g(z0)};
        g.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.f = p.l;
        g.g = o.c.f();
        qf.c c0 = o.c.g();
        g.h = new b(c0.b(), c0.a.f());
    }

    public g(m m0, A a0) {
        this.a = a0;
        this.b = f.b;
        this.c = new i(m0, new W(19, this, m0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Oe.c
    public final Me.e a(b b0) {
        q.g(b0, "classId");
        return b0.equals(g.h) ? ((Pe.k)a.r(this.c, g.e[0])) : null;
    }

    @Override  // Oe.c
    public final boolean b(qf.c c0, qf.e e0) {
        q.g(c0, "packageFqName");
        q.g(e0, "name");
        return e0.equals(g.g) && c0.equals(g.f);
    }

    @Override  // Oe.c
    public final Collection c(qf.c c0) {
        q.g(c0, "packageFqName");
        return c0.equals(g.f) ? e1.m.E(((Pe.k)a.r(this.c, g.e[0]))) : y.a;
    }
}

