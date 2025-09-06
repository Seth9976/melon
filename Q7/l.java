package Q7;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.b;
import q2.f;
import we.n;

public final class l extends i implements n {
    public final f B;
    public final m D;
    public Object r;
    public final Object w;

    public l(Object object0, f f0, m m0, Continuation continuation0) {
        this.w = object0;
        this.B = f0;
        this.D = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((l)this.create(((b)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        b b0 = (b)this.r;
        f f0 = this.B;
        Object object1 = this.w;
        if(object1 == null) {
            b0.f(f0);
        }
        else {
            b0.g(f0, object1);
        }
        m.a(this.D, b0);
        return H.a;
    }
}

