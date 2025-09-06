package jd;

import Nc.g;
import Q.K;
import android.content.Context;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class j2 extends i implements n {
    public final a0 B;
    public final k D;
    public final Context E;
    public final q2 G;
    public int r;
    public final K w;

    public j2(K k0, a0 a00, k k1, Context context0, q2 q20, Continuation continuation0) {
        this.w = k0;
        this.B = a00;
        this.D = k1;
        this.E = context0;
        this.G = q20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j2(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.distinctUntilChanged(w.y(new g(this.w, 2)));
                i2 i20 = new i2(this.B, this.D, this.E, this.G);
                this.r = 1;
                return flow0.collect(i20, this) == a0 ? a0 : H.a;
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

