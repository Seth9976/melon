package qc;

import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m extends i implements n {
    public final boolean B;
    public int r;
    public final n0 w;

    public m(Continuation continuation0, n0 n00, boolean z) {
        this.w = n00;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(continuation0, this.w, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        n0 n00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l l0 = new l(n00, null);
                this.r = 1;
                object0 = n00.Q(l0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        D0 d00 = (D0)object0;
        if(this.B) {
            n00.b.i(w.a);
        }
        return object0;
    }
}

