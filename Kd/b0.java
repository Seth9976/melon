package kd;

import ie.H;
import jd.K;
import jd.m3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class b0 extends i implements n {
    public final k r;
    public final androidx.compose.runtime.b0 w;

    public b0(k k0, androidx.compose.runtime.b0 b00, Continuation continuation0) {
        this.r = k0;
        this.w = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        K k0 = new K(this.w.getValue() == m3.a);
        this.r.invoke(k0);
        return H.a;
    }
}

