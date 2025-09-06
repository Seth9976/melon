package Le;

import Ac.W;
import De.w;
import Gf.m;
import Je.i;
import Je.l;
import Oe.b;
import Oe.d;
import P4.a;
import Pe.A;
import je.p;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class j extends i {
    public l f;
    public final Gf.i g;
    public static final w[] h;

    static {
        z z0 = new z(j.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0);
        j.h = new w[]{I.a.g(z0)};
    }

    public j(m m0) {
        super(m0);
        this.g = new Gf.i(m0, new W(20, this, m0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    public final o K() {
        return (o)a.r(this.g, j.h[0]);
    }

    @Override  // Je.i
    public final b d() {
        return this.K();
    }

    @Override  // Je.i
    public final Iterable m() {
        Iterable iterable0 = super.m();
        A a0 = this.l();
        q.f(a0, "getBuiltInsModule(...)");
        return p.y0(iterable0, new g(this.d, a0));
    }

    @Override  // Je.i
    public final d q() {
        return this.K();
    }
}

