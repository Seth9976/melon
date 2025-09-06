package I;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import ne.a;
import oe.i;
import r1.c;
import we.n;

public final class p0 extends i implements n {
    public final t0 B;
    public int r;
    public Object w;

    public p0(t0 t00, Continuation continuation0) {
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope1;
        CoroutineScope coroutineScope0;
        a a0 = a.a;
        t0 t00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                coroutineScope0 = (CoroutineScope)this.w;
                goto label_13;
            }
            case 1: {
                coroutineScope1 = (CoroutineScope)this.w;
                try {
                    d5.n.D(object0);
                    goto label_22;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                coroutineScope1 = (CoroutineScope)this.w;
                try {
                    d5.n.D(object0);
                    do {
                        coroutineScope0 = coroutineScope1;
                    label_13:
                        if(!JobKt.isActive(coroutineScope0.getCoroutineContext())) {
                            t00.g = null;
                            return H.a;
                        }
                        this.w = coroutineScope0;
                        this.r = 1;
                        Object object1 = ((Channel)t00.f).receive(this);
                        if(object1 == a0) {
                            break;
                        }
                        coroutineScope1 = coroutineScope0;
                        object0 = object1;
                    label_22:
                        float f = ((c)t00.e).Y(g0.a);
                        float f1 = ((c)t00.e).Y(g0.b);
                        this.w = coroutineScope1;
                        this.r = 2;
                    }
                    while(t0.b(t00, ((g1)t00.b), ((h0)object0), f, f1, this) != a0);
                    return a0;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        t00.g = null;
        throw throwable0;
    }
}

