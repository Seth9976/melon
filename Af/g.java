package af;

import De.w;
import Gf.i;
import Gf.m;
import Je.o;
import Se.d;
import cf.a;
import com.google.firebase.messaging.u;
import java.util.Map;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class g extends b {
    public final i f;
    public static final w[] g;

    static {
        z z0 = new z(g.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0);
        g.g = new w[]{I.a.g(z0)};
    }

    public g(d d0, u u0) {
        q.g(u0, "c");
        super(u0, d0, o.m);
        m m0 = (m)((a)u0.a).a;
        m0.getClass();
        this.f = new i(m0, f.a);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // af.b
    public final Map a() {
        return (Map)P4.a.r(this.f, g.g[0]);
    }
}

