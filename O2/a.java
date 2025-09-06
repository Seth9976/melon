package o2;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class a extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
        return true;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        return true;
    }
}

