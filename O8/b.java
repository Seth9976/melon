package o8;

import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class b extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        for(Object object1: MusicAlarmPrefsHelper.INSTANCE.getAlarmList()) {
            c.f(e.d(((d)object1)), ((d)object1).a, false);
        }
        return H.a;
    }
}

