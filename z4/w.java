package z4;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final CompletableDeferred B;
    public final i D;
    public int r;
    public Object w;

    public w(CompletableDeferred completableDeferred0, n n0, Continuation continuation0) {
        this.B = completableDeferred0;
        this.D = (i)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new w(this.B, ((n)this.D), continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CompletableDeferred completableDeferred1;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                CompletableDeferred completableDeferred0 = this.B;
                try {
                    this.w = completableDeferred0;
                    this.r = 1;
                    object0 = ((n)this.D).invoke(coroutineScope0, this);
                }
                catch(Throwable throwable0) {
                    completableDeferred1 = completableDeferred0;
                    object0 = d5.n.t(throwable0);
                    break;
                }
                if(object0 == a0) {
                    return a0;
                }
                completableDeferred1 = completableDeferred0;
                break;
            }
            case 1: {
                completableDeferred1 = (CompletableDeferred)this.w;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                object0 = d5.n.t(throwable0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        CompletableDeferredKt.completeWith(completableDeferred1, object0);
        return H.a;
    }
}

