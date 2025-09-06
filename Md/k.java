package Md;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class k extends i implements n {
    public final i B;
    public final we.k D;
    public int r;
    public Object w;

    public k(n n0, we.k k0, Continuation continuation0) {
        this.B = (i)n0;
        this.D = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(((n)this.B), this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    this.w = null;
                    this.r = 1;
                    Object object1 = ((n)this.B).invoke(coroutineScope0, this);
                    return object1 == a0 ? a0 : object1;
                label_11:
                    d5.n.D(object0);
                    return object0;
                }
                catch(Throwable throwable0) {
                    this.D.invoke(throwable0);
                    throw throwable0;
                }
            }
            case 1: {
                goto label_11;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

