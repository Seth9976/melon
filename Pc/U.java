package pc;

import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public Object B;
    public final Z D;
    public final int E;
    public z0 r;
    public int w;

    public u(Z z0, int v, Continuation continuation0) {
        this.D = z0;
        this.E = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u(this.D, this.E, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((z0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        z0 z00 = (z0)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = z00;
                this.r = z00;
                this.w = 1;
                object0 = v.k(this.D.i, this.D.l, this);
                return object0 == a0 ? a0 : z0.f(z00, ((List)object0), 0, z00.d - this.E, 4);
            }
            case 1: {
                z0 z01 = this.r;
                d5.n.D(object0);
                return z0.f(z01, ((List)object0), 0, z00.d - this.E, 4);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

