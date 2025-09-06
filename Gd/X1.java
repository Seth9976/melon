package gd;

import Ac.P;
import Cc.c0;
import O.F;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import oe.i;
import we.a;
import we.n;

public final class x1 extends i implements n {
    public final a B;
    public int r;
    public final F w;

    public x1(F f0, a a0, Continuation continuation0) {
        this.w = f0;
        this.B = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = w.y(new M0(this.w, 3));
                c0 c00 = new c0(4, this.B);
                this.r = 1;
                H h1 = flow0.collect(new P(c00, this.w, 10), this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
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

