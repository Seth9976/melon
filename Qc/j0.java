package qc;

import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public Object B;
    public final n0 D;
    public D0 r;
    public int w;

    public j0(n0 n00, Continuation continuation0) {
        this.D = n00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = null;
                this.r = d00;
                this.w = 1;
                object0 = v.k(this.D.i, this.D.r, this);
                return object0 == a0 ? a0 : D0.f(d00, ((List)object0), 0, null, false, null, null, false, 0x7E);
            }
            case 1: {
                d00 = this.r;
                d5.n.D(object0);
                return D0.f(d00, ((List)object0), 0, null, false, null, null, false, 0x7E);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

