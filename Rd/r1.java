package rd;

import com.melon.ui.K4;
import d9.h;
import hd.z1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class r1 extends i implements n {
    public final H B;
    public Object r;
    public final K1 w;

    public r1(K1 k10, H h0, Continuation continuation0) {
        this.w = k10;
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r1(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((r1)this.create(((K4)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
        return ie.H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        K4 k40 = (K4)this.r;
        d5.n.D(object0);
        if(k40 instanceof D0) {
            K1 k10 = this.w;
            Boolean boolean0 = Boolean.valueOf(q.b(((h)k10.w.getValue()).m, ((D0)k40).f));
            k10.y.setValue(boolean0);
            k10.updateUiState(new z1(k40, 10));
            String s = ((D0)k40).f == null ? null : "";
            H h0 = this.B;
            if(!q.b(h0.a, s)) {
                k10.c();
            }
            h0.a = s;
        }
        return ie.H.a;
    }
}

