package k5;

import d5.n;
import jd.e3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import ne.a;
import oe.c;
import t5.o;

public final class e implements j {
    public final z a;
    public final o b;
    public final Semaphore c;
    public final m d;

    public e(z z0, o o0, Semaphore semaphore0, m m0) {
        this.a = z0;
        this.b = o0;
        this.c = semaphore0;
        this.d = m0;
    }

    @Override  // k5.j
    public final Object a(Continuation continuation0) {
        h h0;
        Throwable throwable1;
        Semaphore semaphore2;
        Object object1;
        e e0;
        Semaphore semaphore0;
        d d0;
        if(continuation0 instanceof d) {
            d0 = (d)continuation0;
            int v = d0.E;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, ((c)continuation0));
            }
            else {
                d0.E = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, ((c)continuation0));
        }
        Object object0 = d0.B;
        a a0 = a.a;
        switch(d0.E) {
            case 0: {
                n.D(object0);
                d0.r = this;
                semaphore0 = this.c;
                d0.w = semaphore0;
                d0.E = 1;
                if(semaphore0.acquire(d0) == a0) {
                    return a0;
                }
                e0 = this;
                goto label_25;
            }
            case 1: {
                Semaphore semaphore1 = d0.w;
                e0 = (e)d0.r;
                n.D(object0);
                semaphore0 = semaphore1;
                try {
                label_25:
                    e3 e30 = new e3(e0, 3);
                    d0.r = semaphore0;
                    d0.w = null;
                    d0.E = 2;
                    object1 = InterruptibleKt.runInterruptible$default(null, e30, d0, 1, null);
                }
                catch(Throwable throwable0) {
                    semaphore2 = semaphore0;
                    throwable1 = throwable0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                semaphore2 = semaphore0;
                object0 = object1;
                h0 = (h)object0;
                goto label_47;
            }
            case 2: {
                semaphore2 = (Semaphore)d0.r;
                try {
                    n.D(object0);
                    h0 = (h)object0;
                    goto label_47;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        semaphore2.release();
        throw throwable1;
    label_47:
        semaphore2.release();
        return h0;
    }
}

