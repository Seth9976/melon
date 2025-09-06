package Pa;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowKt;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final String B;
    public final String D;
    public Object r;
    public final d5.i w;

    public c(d5.i i0, String s, String s1, Continuation continuation0) {
        this.w = i0;
        this.B = s;
        this.D = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((h)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        h h0 = (h)this.r;
        d5.n.D(object0);
        return h0 instanceof d ? this.w.c(((d)h0).a, "M20001", this.B, this.D, ((d)h0).b) : FlowKt.flowOf(h0);
    }
}

