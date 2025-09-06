package nc;

import A3.g;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public final u0 B;
    public Object r;
    public final boolean w;

    public m0(Continuation continuation0, u0 u00, boolean z) {
        this.w = z;
        this.B = u00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m0(continuation0, this.B, this.w);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.r;
        d5.n.D(object0);
        u0 u00 = this.B;
        if(this.w) {
            u00.n = new g(b.B(c00).size(), c00.b);
            return C0.f(c00, null, 0, null, null, this.w, false, null, false, null, 0x1EF);
        }
        u00.n = null;
        return C0.f(c00, null, 0, null, null, this.w, false, null, false, null, 0x1EF);
    }
}

