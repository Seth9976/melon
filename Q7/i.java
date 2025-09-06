package Q7;

import ie.H;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;

public final class i {
    public final n a;
    public final n b;

    public i(n n0, n n1) {
        q.g(n0, "localOverrideSettings");
        q.g(n1, "remoteSettings");
        super();
        this.a = n0;
        this.b = n1;
    }

    public final double a() {
        Double double0 = this.a.c();
        if(double0 != null) {
            double f = double0.doubleValue();
            if(0.0 <= f && f <= 1.0) {
                return f;
            }
        }
        Double double1 = this.b.c();
        if(double1 != null) {
            double f1 = double1.doubleValue();
            return 0.0 > f1 || f1 > 1.0 ? 1.0 : f1;
        }
        return 1.0;
    }

    public final Object b(c c0) {
        i i0;
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.D;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.D = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Object object0 = h0.w;
        a a0 = a.a;
        switch(h0.D) {
            case 0: {
                d5.n.D(object0);
                h0.r = this;
                h0.D = 1;
                if(this.a.d(h0) == a0) {
                    return a0;
                }
                i0 = this;
                break;
            }
            case 1: {
                i0 = h0.r;
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        h0.r = null;
        h0.D = 2;
        return i0.b.d(h0) == a0 ? a0 : H.a;
    }
}

