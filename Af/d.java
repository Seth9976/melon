package af;

import Hf.x;
import Je.o;
import Jf.l;
import Me.e;
import Me.z;
import Pe.S;
import V4.u;
import kotlin.jvm.internal.q;
import we.k;

public final class d implements k {
    public static final d a;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((z)object0), "module");
        e e0 = ((z)object0).d().j(o.t);
        S s0 = u.p(c.b, e0);
        if(s0 != null) {
            x x0 = s0.getType();
            if(x0 != null) {
                return x0;
            }
        }
        return l.c(Jf.k.X, new String[0]);
    }
}

