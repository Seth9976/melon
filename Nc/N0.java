package nc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class n0 extends i implements n {
    public final boolean B;
    public int r;
    public final u0 w;

    public n0(Continuation continuation0, u0 u00, boolean z) {
        this.w = u00;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(continuation0, this.w, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                m0 m00 = new m0(null, this.w, this.B);
                this.r = 1;
                Object object1 = this.w.U("setShuffleInternal", m00, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

