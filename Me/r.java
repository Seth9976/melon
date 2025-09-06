package Me;

import Pe.C;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import qf.b;
import we.k;

public final class r implements k {
    public final int a;
    public static final r b;
    public static final r c;
    public static final r d;
    public static final r e;

    static {
        r.b = new r(0);
        r.c = new r(1);
        r.d = new r(2);
        r.e = new r(3);
    }

    public r(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((b)object0), "it");
                return 0;
            }
            case 1: {
                q.g(((E)object0), "it");
                return ((C)(((E)object0))).e;
            }
            case 2: {
                q.g(((Me.k)object0), "it");
                return Boolean.valueOf(!(((Me.k)object0) instanceof j));
            }
            default: {
                q.g(((Me.k)object0), "it");
                List list0 = ((Me.b)(((Me.k)object0))).getTypeParameters();
                q.f(list0, "getTypeParameters(...)");
                return p.c0(list0);
            }
        }
    }
}

