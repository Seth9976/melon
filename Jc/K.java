package jc;

import com.iloen.melon.LoginUser;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class k extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k)this.create(((LoginUser)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        LoginUser loginUser0 = (LoginUser)this.r;
        d5.n.D(object0);
        q.f("", "getMemberKey(...)");
        jc.n.a(1, "", null);
        return H.a;
    }
}

