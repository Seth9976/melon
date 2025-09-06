package z4;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m extends i implements n {
    public final H B;
    public final z4.n D;
    public H r;
    public int w;

    public m(H h0, z4.n n0, Continuation continuation0) {
        this.B = h0;
        this.D = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                H h0 = this.B;
                this.r = h0;
                this.w = 1;
                Object object1 = this.D.a(this);
                if(object1 == a0) {
                    return a0;
                }
                h1 = h0;
                object0 = object1;
                break;
            }
            case 1: {
                h1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        h1.a = object0;
        return ie.H.a;
    }
}

