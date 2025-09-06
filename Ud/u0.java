package ud;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class u0 extends i implements n {
    public Object r;
    public final R0 w;

    public u0(R0 r00, Continuation continuation0) {
        this.w = r00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((u0)this.create(((h0)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        h0 h00 = (h0)this.r;
        d5.n.D(object0);
        if(h00 != null) {
            hd.i i0 = new hd.i(h00, 26);
            this.w.updateUiState(i0);
        }
        return H.a;
    }
}

