package Nb;

import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public boolean r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m0(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((m0)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        LogU logU0 = new LogU("PlaybackLibraryService");
        logU0.setCategory(Category.Login);
        logU0.setUseThreadInfo(true);
        LogU.debug$default(logU0, "PlaybackLibraryService - isLogin: " + z, null, false, 6, null);
        if(!z) {
            EpPlayLogger.INSTANCE.logout();
        }
        return H.a;
    }
}

