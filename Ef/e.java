package ef;

import Hf.G;
import Hf.P;
import Hf.Y;
import Hf.b0;
import Hf.x;
import Me.S;
import ea.c;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.jvm.internal.q;
import xf.d;

public final class e {
    public static P a(S s0, a a0, c c0, x x0) {
        q.g(a0, "typeAttr");
        q.g(c0, "typeParameterUpperBoundEraser");
        if(!a0.d) {
            a0 = a.a(a0, b.a, false, null, null, 61);
        }
        switch(a0.c.ordinal()) {
            case 0: 
            case 1: {
                if(!s0.y().b) {
                    return new G(d.e(s0).o(), b0.c);
                }
                List list0 = x0.w().getParameters();
                q.f(list0, "getParameters(...)");
                return !list0.isEmpty() ? new G(x0, b0.e) : Y.k(s0, a0);
            }
            case 2: {
                return new G(x0, b0.c);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

