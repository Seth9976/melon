package Dc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.n;

public final class z extends i implements n {
    public final v B;
    public final B r;
    public final a w;

    public z(B b0, a a0, v v0, Continuation continuation0) {
        this.r = b0;
        this.w = a0;
        this.B = v0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        B.a(this.r, this.w, this.B);
        return H.a;
    }
}

