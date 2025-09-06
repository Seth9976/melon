package af;

import Af.g;
import De.w;
import Gf.i;
import Gf.m;
import Gf.p;
import Je.o;
import Se.d;
import cf.a;
import com.google.firebase.messaging.u;
import java.util.Map;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class j extends b {
    public final i f;
    public static final w[] g;

    static {
        z z0 = new z(j.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0);
        j.g = new w[]{I.a.g(z0)};
    }

    public j(d d0, u u0) {
        q.g(d0, "annotation");
        q.g(u0, "c");
        super(u0, d0, o.t);
        p p0 = ((a)u0.a).a;
        g g0 = new g(this, 29);
        ((m)p0).getClass();
        this.f = new i(((m)p0), g0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // af.b
    public final Map a() {
        return (Map)P4.a.r(this.f, j.g[0]);
    }
}

