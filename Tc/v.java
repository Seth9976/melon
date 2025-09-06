package tc;

import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class v extends i implements n {
    public Object B;
    public final List D;
    public final x E;
    public F r;
    public int w;

    public v(List list0, x x0, Continuation continuation0) {
        this.D = list0;
        this.E = x0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new v(this.D, this.E, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((F)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        F f0 = (F)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = null;
                this.r = f0;
                this.w = 1;
                object0 = df.v.k(this.D, this.E.g, this);
                return object0 == a0 ? a0 : F.f(f0, ((List)object0), 0, null, 6);
            }
            case 1: {
                f0 = this.r;
                d5.n.D(object0);
                return F.f(f0, ((List)object0), 0, null, 6);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

