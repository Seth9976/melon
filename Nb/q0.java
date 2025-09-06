package Nb;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class q0 extends i implements n {
    public final t0 B;
    public int r;
    public boolean w;

    public q0(t0 t00, Continuation continuation0) {
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q0(this.B, continuation0);
        continuation1.w = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        return ((q0)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.w;
        a a0 = a.a;
        if(this.r != 0 && this.r != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        d5.n.D(object0);
        while(z) {
            this.B.a(this.B.a);
            this.w = true;
            this.r = 1;
            if(DelayKt.delay(200L, this) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }
}

