package nc;

import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class p0 extends i implements n {
    public Object B;
    public final u0 D;
    public C0 r;
    public int w;

    public p0(u0 u00, Continuation continuation0) {
        this.D = u00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p0)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = null;
                this.r = c00;
                this.w = 1;
                object0 = v.k(this.D.j, this.D.q, this);
                return object0 == a0 ? a0 : C0.f(c00, ((List)object0), 0, null, null, false, false, null, false, null, 510);
            }
            case 1: {
                c00 = this.r;
                d5.n.D(object0);
                return C0.f(c00, ((List)object0), 0, null, null, false, false, null, false, null, 510);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

