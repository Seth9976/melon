package Pe;

import Af.l;
import De.t;
import Gf.i;
import Me.I;
import Me.k;
import Ne.g;
import com.iloen.melon.utils.a;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.c;
import qf.d;
import qf.e;

public final class w extends m implements I {
    public final A c;
    public final c d;
    public final i e;
    public final i f;
    public final l g;
    public static final De.w[] h;

    static {
        z z0 = new z(w.class, "fragments", "getFragments()Ljava/util/List;", 0);
        t t0 = a.e(w.class, "empty", "getEmpty()Z", 0, kotlin.jvm.internal.I.a);
        w.h = new De.w[]{kotlin.jvm.internal.I.a.g(z0), t0};
    }

    public w(A a0, c c0, Gf.m m0) {
        q.g(c0, "fqName");
        q.g(m0, "storageManager");
        e e0 = c0.a.c() ? d.e : c0.a.f();
        super(g.a, e0);
        this.c = a0;
        this.d = c0;
        this.e = new i(m0, new v(this, 0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.f = new i(m0, new v(this, 1));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.g = new l(m0, new v(this, 2));
    }

    @Override  // Me.k
    public final Object R(Me.m m0, Object object0) {
        return m0.v(this, object0);
    }

    @Override  // Me.k
    public final k e() {
        c c0 = this.d;
        if(c0.a.c()) {
            return null;
        }
        c c1 = c0.b();
        return this.c.K0(c1);
    }

    // 去混淆评级： 低(25)
    @Override
    public final boolean equals(Object object0) {
        I i0 = object0 instanceof I ? ((I)object0) : null;
        return i0 == null ? false : q.b(this.d, ((w)i0).d) && q.b(this.c, ((w)i0).c);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + this.c.hashCode() * 0x1F;
    }
}

