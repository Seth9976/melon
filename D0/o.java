package d0;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class o extends i implements n {
    public int r;
    public final p w;

    public o(p p0, Continuation continuation0) {
        this.w = p0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                p p0 = this.w;
                if(p0.c) {
                    this.r = 2;
                    if(p0.q0(this) == a0) {
                        return a0;
                    }
                }
                else {
                    this.r = 1;
                    if(p0.p0(this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

