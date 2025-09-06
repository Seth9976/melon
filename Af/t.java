package Af;

import De.w;
import Ff.k;
import Gf.i;
import Gf.m;
import Me.L;
import Me.h;
import Qf.f;
import Ue.c;
import com.iloen.melon.utils.a;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import qf.e;

public final class t extends q {
    public final k b;
    public final boolean c;
    public final i d;
    public final i e;
    public static final w[] f;

    static {
        z z0 = new z(t.class, "functions", "getFunctions()Ljava/util/List;", 0);
        De.t t0 = a.e(t.class, "properties", "getProperties()Ljava/util/List;", 0, I.a);
        t.f = new w[]{I.a.g(z0), t0};
    }

    public t(m m0, k k0, boolean z) {
        kotlin.jvm.internal.q.g(m0, "storageManager");
        super();
        this.b = k0;
        this.c = z;
        this.d = new i(m0, new s(this, 0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.e = new i(m0, new s(this, 1));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Af.q
    public final Collection b(e e0, c c0) {
        kotlin.jvm.internal.q.g(e0, "name");
        Iterable iterable0 = (List)P4.a.r(this.e, t.f[1]);
        Collection collection0 = new f();
        for(Object object0: iterable0) {
            if(kotlin.jvm.internal.q.b(((L)object0).getName(), e0)) {
                ((f)collection0).add(object0);
            }
        }
        return collection0;
    }

    @Override  // Af.q
    public final h c(e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        return null;
    }

    @Override  // Af.q
    public final Collection e(Af.f f0, we.k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        return p.A0(((List)P4.a.r(this.d, t.f[0])), ((List)P4.a.r(this.e, t.f[1])));
    }

    @Override  // Af.q
    public final Collection f(e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        Iterable iterable0 = (List)P4.a.r(this.d, t.f[0]);
        Collection collection0 = new f();
        for(Object object0: iterable0) {
            if(kotlin.jvm.internal.q.b(((Pe.L)object0).getName(), e0)) {
                ((f)collection0).add(object0);
            }
        }
        return collection0;
    }
}

