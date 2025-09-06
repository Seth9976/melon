package nc;

import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final boolean B;
    public int r;
    public final u0 w;

    public q(Continuation continuation0, u0 u00, boolean z) {
        this.w = u00;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(continuation0, this.w, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        u0 u00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                p p0 = new p(u00, null);
                this.r = 1;
                object0 = u00.U("clearSelectRepeatInternal", p0, this);
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
        C0 c00 = (C0)object0;
        if(this.B) {
            u00.b.f(w.a);
        }
        return object0;
    }
}

