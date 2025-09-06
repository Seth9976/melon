package I;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.G;
import ne.a;
import oe.i;
import r1.q;
import we.n;

public final class c1 extends i implements n {
    public long B;
    public int D;
    public Object E;
    public final g1 G;
    public final G I;
    public final long M;
    public g1 r;
    public G w;

    public c1(g1 g10, G g0, long v, Continuation continuation0) {
        this.G = g10;
        this.I = g0;
        this.M = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c1(this.G, this.I, this.M, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c1)this.create(((d1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g11;
        long v1;
        G g0;
        g1 g10;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                g10 = this.G;
                b1 b10 = new b1(g10, ((d1)this.E));
                Z z0 = g10.c;
                g0 = this.I;
                long v = g0.a;
                float f = g10.c((g10.d == u0.b ? q.b(this.M) : q.c(this.M)));
                this.E = g10;
                this.r = g10;
                this.w = g0;
                this.B = v;
                this.D = 1;
                object0 = z0.a(b10, f, this);
                if(object0 == a0) {
                    return a0;
                }
                v1 = v;
                g11 = g10;
                break;
            }
            case 1: {
                v1 = this.B;
                g0 = this.w;
                g10 = this.r;
                g11 = (g1)this.E;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        float f1 = g11.c(((Number)object0).floatValue());
        g0.a = g10.d == u0.b ? q.a(v1, f1, 0.0f, 2) : q.a(v1, 0.0f, f1, 1);
        return H.a;
    }
}

