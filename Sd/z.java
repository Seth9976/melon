package sd;

import fc.a;
import ie.H;
import ie.s;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class z extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((a)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = (a)this.r;
        d5.n.D(object0);
        return new s(a0.f, a0.g, Boolean.valueOf(a0.b));
    }
}

