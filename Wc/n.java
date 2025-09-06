package wc;

import Jd.g;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final w B;
    public final ArrayList D;
    public int r;
    public final g w;

    public n(g g0, w w0, ArrayList arrayList0, Continuation continuation0) {
        this.w = g0;
        this.B = w0;
        this.D = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = this.B.getMenuId();
                this.w.b(s);
                this.w.b = this.B.getStatsElements();
                Jd.a a1 = (Jd.a)this.B.x.getValue();
                this.r = 1;
                Jd.a.b(a1, this.w, this.D);
                return h0 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

