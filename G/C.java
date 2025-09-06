package G;

import androidx.compose.runtime.O0;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.k;

public final class c extends i implements k {
    public final e r;
    public final Object w;

    public c(e e0, Object object0, Continuation continuation0) {
        this.r = e0;
        this.w = object0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new c(this.r, this.w, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((c)this.create(((Continuation)object0))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        n.D(object0);
        e.b(this.r);
        Object object1 = e.a(this.r, this.w);
        ((O0)this.r.c.b).setValue(object1);
        ((O0)this.r.e).setValue(object1);
        return H.a;
    }
}

