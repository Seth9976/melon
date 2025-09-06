package Nb;

import androidx.media3.session.y0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f0 extends i implements n {
    public final y0 B;
    public Object r;
    public final h0 w;

    public f0(h0 h00, y0 y00, Continuation continuation0) {
        this.w = h00;
        this.B = y00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((f0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new a0(this.w, this.B, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new c0(this.w, this.B, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new e0(this.w, this.B, null), 3, null);
        return H.a;
    }
}

