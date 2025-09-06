package G8;

import com.iloen.melon.utils.datastore.MigrationPreferenceKeys;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.b;
import we.n;

public final class c extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c)this.create(((b)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b b0 = (b)this.r;
        d5.n.D(object0);
        b0.g(MigrationPreferenceKeys.INSTANCE.getLOCAL_PLAYLIST_MIGRATION(), Boolean.TRUE);
        return H.a;
    }
}

