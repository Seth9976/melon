package kd;

import O.F;
import androidx.compose.runtime.w;
import gd.M0;
import ie.H;
import jd.m3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class r extends i implements n {
    public final m3 B;
    public final CoroutineScope D;
    public final k E;
    public int r;
    public final F w;

    public r(F f0, m3 m30, Continuation continuation0, CoroutineScope coroutineScope0, k k0) {
        this.w = f0;
        this.B = m30;
        this.D = coroutineScope0;
        this.E = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, continuation0, this.D, this.E);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.distinctUntilChanged(w.y(new M0(this.w, 26)));
                q q0 = new q(this.w, this.B, null, this.D, this.E);
                this.r = 1;
                return FlowKt.collectLatest(flow0, q0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

