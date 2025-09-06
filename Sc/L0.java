package sc;

import ie.H;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import oe.i;
import we.n;

public final class l0 extends i implements n {
    public final List B;
    public final C D;
    public Object r;
    public final P0 w;

    public l0(P0 p00, List list0, C c0, Continuation continuation0) {
        this.w = p00;
        this.B = list0;
        this.D = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l0(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        List list0 = p.I0(this.B);
        int v = ((Number)p.k0(list0)).intValue();
        boolean z = g10.b != v;
        this.D.a = z;
        if(z) {
            this.w.m = -1L;
        }
        return g1.f(g10, null, v, null, false, null, list0, false, 93);
    }
}

