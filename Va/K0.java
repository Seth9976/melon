package va;

import com.iloen.melon.LoginUser;
import com.iloen.melon.utils.datastore.LoginUserPreferencesSerializer;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class k0 extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k0(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k0)this.create(((LoginUser)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        return LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
    }
}

