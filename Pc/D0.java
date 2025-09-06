package pc;

import com.iloen.melon.MixUpPreference;
import com.iloen.melon.a;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d0(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((MixUpPreference)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MixUpPreference mixUpPreference0 = (MixUpPreference)this.r;
        d5.n.D(object0);
        a a0 = (a)mixUpPreference0.toBuilder();
        a0.c();
        return a0.a();
    }
}

