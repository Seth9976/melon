package kd;

import ie.H;
import jd.H2;
import jd.P;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class d0 extends i implements n {
    public final k B;
    public int r;
    public final H2 w;

    public d0(H2 h20, k k0, Continuation continuation0) {
        this.w = h20;
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(DelayKt.delay(3000L, this) == a0) {
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
        if(this.w == H2.b || this.w == H2.a) {
            P p0 = new P(false);
            this.B.invoke(p0);
        }
        return H.a;
    }
}

