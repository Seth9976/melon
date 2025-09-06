package Vb;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class c0 extends i implements n {
    public Object r;
    public final o0 w;

    public c0(o0 o00, Continuation continuation0) {
        this.w = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        this.w.Z = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new b0(this.w, null), 3, null);
        return H.a;
    }
}

