package sd;

import E9.g;
import X0.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import x1.d;
import x1.n;

public final class m implements k {
    public final int a;
    public static final m b;
    public static final m c;
    public static final m d;

    static {
        m.b = new m(0);
        m.c = new m(1);
        m.d = new m(2);
    }

    public m(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return H.a;
            }
            case 1: {
                q.g(((d)object0), "$this$constrainAs");
                d.b(((d)object0), ((d)object0).c.d, ((d)object0).c.f, 0.0f, 0.0f, 0.0f, 60);
                g.v(((d)object0).g, ((d)object0).c.g, 12.5f, 4);
                ((d)object0).d(new n(null, "spread"));
                return H.a;
            }
            default: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return H.a;
            }
        }
    }
}

