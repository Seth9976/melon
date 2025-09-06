package gd;

import androidx.compose.runtime.b1;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class q2 extends i implements n {
    public final b1 B;
    public final k r;
    public final b1 w;

    public q2(k k0, b1 b10, b1 b11, Continuation continuation0) {
        this.r = k0;
        this.w = b10;
        this.B = b11;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q2(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((q2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        k k0 = this.r;
        if(k0 != null) {
            k0.invoke(Boolean.valueOf(!((Boolean)this.w.getValue()).booleanValue() || !((Boolean)this.B.getValue()).booleanValue()));
        }
        return H.a;
    }
}

