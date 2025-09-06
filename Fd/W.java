package Fd;

import J8.N2;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class w extends i implements n {
    public boolean r;
    public final N2 w;

    public w(N2 n20, Continuation continuation0) {
        this.w = n20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new w(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((w)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        N2 n20 = this.w;
        n20.d.setVisibility((z ? 0 : 8));
        if(z) {
            n20.f.setVisibility(8);
        }
        return H.a;
    }
}

