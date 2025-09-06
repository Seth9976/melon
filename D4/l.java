package D4;

import A4.c;
import G4.a;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.k;
import we.n;

public final class l extends i implements n {
    public Object r;
    public final k w;

    public l(k k0, Continuation continuation0) {
        this.w = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((c)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        c c0 = (c)this.r;
        q.e(c0, "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor");
        a a0 = c0.c();
        return this.w.invoke(a0);
    }
}

