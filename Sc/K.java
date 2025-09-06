package sc;

import com.iloen.melon.utils.MelonSettingInfo;
import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import oc.M;
import oc.t0;
import oe.i;
import we.n;

public final class k extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        boolean z = MelonSettingInfo.isOfflineModeSP();
        return new g1(w.a, -1, M.a, false, t0.b, w.a, z);
    }
}

