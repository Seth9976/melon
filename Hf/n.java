package hf;

import Hf.a0;
import Hf.x;
import Le.d;
import Me.c;
import Pe.u;
import ef.h;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class n implements k {
    public final int a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;

    static {
        n.b = new n(0);
        n.c = new n(1);
        n.d = new n(2);
        n.e = new n(3);
    }

    public n(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((c)object0), "it");
                u u0 = ((c)object0).Q();
                q.d(u0);
                return u0.getType();
            }
            case 1: {
                q.g(((c)object0), "it");
                x x0 = ((c)object0).getReturnType();
                q.d(x0);
                return x0;
            }
            case 2: {
                q.g(((a0)object0), "it");
                return Boolean.valueOf(((a0)object0) instanceof h);
            }
            case 3: {
                Me.h h0 = ((a0)object0).w().e();
                if(h0 == null) {
                    return false;
                }
                return !q.b(h0.getName(), d.f.a.f()) || !q.b(xf.d.c(h0), d.f) ? false : true;
            }
            default: {
                q.g(((o)object0), "$this$function");
                ((o)object0).b("java/util/Spliterator", new hf.d[]{l.b, l.b});
                return H.a;
            }
        }
    }
}

