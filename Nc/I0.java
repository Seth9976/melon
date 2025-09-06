package nc;

import ie.H;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public final List B;
    public final C D;
    public Object r;
    public final u0 w;

    public i0(u0 u00, List list0, C c0, Continuation continuation0) {
        this.w = u00;
        this.B = list0;
        this.D = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i0(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.r;
        d5.n.D(object0);
        List list0 = p.I0(this.B);
        int v = ((Number)p.k0(list0)).intValue();
        boolean z = c00.b != v;
        this.D.a = z;
        if(z) {
            this.w.i = -1L;
        }
        return C0.f(c00, null, v, null, list0, false, false, null, false, null, 501);
    }
}

