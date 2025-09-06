package I;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import oe.i;
import we.n;

public final class x1 extends i implements n {
    public final z0 r;

    public x1(z0 z00, Continuation continuation0) {
        this.r = z00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x1(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((x1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.c = true;
        Mutex mutex0 = this.r.d;
        if(mutex0.isLocked()) {
            DefaultImpls.unlock$default(mutex0, null, 1, null);
        }
        return H.a;
    }
}

