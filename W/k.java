package W;

import ie.H;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import oe.i;
import we.n;

public final class k extends i implements n {
    public Object r;
    public final l w;

    public k(l l0, Continuation continuation0) {
        this.w = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        Job job0 = (Job)this.w.b.getAndSet(null);
        AtomicReference atomicReference0 = this.w.b;
        Job job1 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new j(job0, this.w, null), 3, null);
        do {
            if(atomicReference0.compareAndSet(null, job1)) {
                return true;
            }
        }
        while(atomicReference0.get() == null);
        return false;
    }
}

