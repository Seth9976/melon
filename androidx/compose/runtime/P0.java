package androidx.compose.runtime;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class p0 extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p0(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p0)this.create(((o0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        return ((o0)this.r) == o0.a;
    }
}

