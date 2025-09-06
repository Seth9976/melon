package r0;

import ie.H;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class t extends i implements n {
    public final r B;
    public final AtomicReference D;
    public final n E;
    public int r;
    public Object w;

    public t(k k0, AtomicReference atomicReference0, n n0, Continuation continuation0) {
        this.B = (r)k0;
        this.D = atomicReference0;
        this.E = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(((k)this.B), this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        s s2;
        s s0;
        a a0 = a.a;
        AtomicReference atomicReference0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                s0 = new s(JobKt.getJob(coroutineScope0.getCoroutineContext()), ((k)this.B).invoke(coroutineScope0));
                s s1 = (s)atomicReference0.getAndSet(s0);
                if(s1 != null) {
                    Job job0 = s1.a;
                    if(job0 != null) {
                        this.w = s0;
                        this.r = 1;
                        if(JobKt.cancelAndJoin(job0, this) == a0) {
                            return a0;
                        }
                    }
                }
                goto label_17;
            }
            case 1: {
                s0 = (s)this.w;
                d5.n.D(object0);
                try {
                label_17:
                    this.w = s0;
                    this.r = 2;
                    object0 = this.E.invoke(s0.b, this);
                }
                catch(Throwable throwable0) {
                    s2 = s0;
                    goto label_32;
                }
                if(object0 == a0) {
                    return a0;
                }
                s2 = s0;
                break;
            }
            case 2: {
                s2 = (s)this.w;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_32:
                while(!atomicReference0.compareAndSet(s2, null) && atomicReference0.get() == s2) {
                }
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(!atomicReference0.compareAndSet(s2, null) && atomicReference0.get() == s2) {
        }
        return object0;
    }
}

