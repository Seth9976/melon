package I;

import androidx.compose.foundation.x0;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import oe.i;
import we.n;

public final class k extends i implements n {
    public final l B;
    public final K1 D;
    public final d E;
    public int r;
    public Object w;

    public k(l l0, K1 k10, d d0, Continuation continuation0) {
        this.B = l0;
        this.D = k10;
        this.E = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        l l0 = this.B;
        a a0 = l0.e;
        ne.a a1 = ne.a.a;
        CancellationException cancellationException0 = null;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Job job0 = JobKt.getJob(((CoroutineScope)this.w).getCoroutineContext());
                try {
                    try {
                        l0.j = true;
                        j j0 = new j(this.D, l0, this.E, job0, null);
                        this.r = 1;
                        if(l0.b.e(x0.a, j0, this) == a1) {
                            return a1;
                        label_13:
                            d5.n.D(object0);
                        }
                        a0.b();
                        goto label_24;
                    }
                    catch(CancellationException cancellationException1) {
                        cancellationException0 = cancellationException1;
                        throw cancellationException0;
                    }
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_13;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l0.j = false;
        a0.a(cancellationException0);
        l0.g = false;
        throw throwable0;
    label_24:
        l0.j = false;
        a0.a(null);
        l0.g = false;
        return H.a;
    }
}

