package jd;

import Q.K;
import androidx.compose.runtime.K0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class h2 extends i implements n {
    public final CoroutineScope B;
    public final K r;
    public final K0 w;

    public h2(K k0, K0 k00, CoroutineScope coroutineScope0, Continuation continuation0) {
        this.r = k0;
        this.w = k00;
        this.B = coroutineScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h2(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((h2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        K k0 = this.r;
        int v = k0.j();
        K0 k00 = this.w;
        if(v != k00.m()) {
            g2 g20 = new g2(k0, k00, null);
            BuildersKt__Builders_commonKt.launch$default(this.B, null, null, g20, 3, null);
        }
        return H.a;
    }
}

