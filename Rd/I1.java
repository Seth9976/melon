package rd;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import oe.i;
import we.n;

public final class i1 extends i implements n {
    public final ProducerScope B;
    public Object r;
    public final K1 w;

    public i1(K1 k10, ProducerScope producerScope0, Continuation continuation0) {
        this.w = k10;
        this.B = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i1(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((i1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new f1(this.w, this.B, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new h1(this.w, this.B, null), 3, null);
        return H.a;
    }
}

