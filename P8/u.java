package p8;

import com.iloen.melon.MelonTiaraUserInfo;
import ie.H;
import k8.J;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class u extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((MelonTiaraUserInfo)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MelonTiaraUserInfo melonTiaraUserInfo0 = (MelonTiaraUserInfo)this.r;
        d5.n.D(object0);
        J j0 = (J)melonTiaraUserInfo0.toBuilder();
        j0.c();
        return j0.a();
    }
}

