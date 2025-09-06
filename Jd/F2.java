package jd;

import Q.K;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f2 extends i implements n {
    public final K B;
    public final b0 D;
    public final CoroutineScope r;
    public final q2 w;

    public f2(CoroutineScope coroutineScope0, q2 q20, K k0, b0 b00, Continuation continuation0) {
        this.r = coroutineScope0;
        this.w = q20;
        this.B = k0;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f2(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((f2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        e2 e20 = new e2(this.w, this.B, this.D, null);
        BuildersKt__Builders_commonKt.launch$default(this.r, null, null, e20, 3, null);
        return H.a;
    }
}

