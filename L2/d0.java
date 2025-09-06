package l2;

import ie.H;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public final e0 B;
    public J r;
    public int w;

    public d0(e0 e00, Continuation continuation0) {
        this.B = e00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d0(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        J j0;
        a a0 = a.a;
        e0 e00 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                if(((AtomicInteger)e00.d.b).get() <= 0) {
                    throw new IllegalStateException("Check failed.");
                }
                goto label_13;
            }
            case 1: {
                j0 = this.r;
                d5.n.D(object0);
                goto label_19;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            if(((AtomicInteger)e00.d.b).decrementAndGet() == 0) {
                return H.a;
            }
        label_13:
            CoroutineScopeKt.ensureActive(e00.a);
            j0 = e00.b;
            this.r = j0;
            this.w = 1;
            object0 = e00.c.receive(this);
            if(object0 == a0) {
                break;
            }
        label_19:
            this.r = null;
            this.w = 2;
        }
        while(j0.invoke(object0, this) != a0);
        return a0;
    }
}

