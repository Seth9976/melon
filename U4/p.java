package U4;

import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import w1.j;
import we.n;

public final class p extends i implements n {
    public final i B;
    public final j D;
    public int r;
    public Object w;

    public p(n n0, j j0, Continuation continuation0) {
        this.B = (i)n0;
        this.D = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p(((n)this.B), this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        j j0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                try {
                    this.r = 1;
                    object0 = ((n)this.B).invoke(coroutineScope0, this);
                    if(object0 == a0) {
                        return a0;
                    label_10:
                        d5.n.D(object0);
                    }
                    j0.a(object0);
                    return H.a;
                }
                catch(CancellationException unused_ex) {
                    break;
                }
                catch(Throwable throwable0) {
                    j0.c(throwable0);
                    return H.a;
                }
            }
            case 1: {
                goto label_10;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j0.b();
        return H.a;
    }
}

