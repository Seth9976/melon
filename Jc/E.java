package jc;

import d5.n;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import oe.i;
import we.k;

public final class e extends i implements k {
    public final ArrayList r;

    public e(ArrayList arrayList0, Continuation continuation0) {
        this.r = arrayList0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new e(this.r, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((e)this.create(((Continuation)object0))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        n.D(object0);
        j.b(this.r);
        return H.a;
    }
}

