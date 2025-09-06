package t5;

import androidx.lifecycle.t;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import oe.i;
import v5.a;
import we.n;

public final class v extends i implements n {
    public final w r;

    public v(w w0, Continuation continuation0) {
        this.r = w0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        w w0 = this.r;
        u u0 = w0.d;
        if(u0 != null) {
            t t0 = u0.d;
            DefaultImpls.cancel$default(u0.e, null, 1, null);
            a a0 = u0.c;
            if(a0 != null) {
                t0.c(a0);
            }
            t0.c(u0);
        }
        w0.d = null;
        return H.a;
    }
}

