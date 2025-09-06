package Ec;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final boolean r;
    public final b0 w;

    public h(b0 b00, Continuation continuation0, boolean z) {
        this.r = z;
        this.w = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.w, continuation0, this.r);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.w.setValue(Boolean.valueOf(this.r));
        return H.a;
    }
}

