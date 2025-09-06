package d9;

import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class c extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        ToastManager.show(0x7F130603);  // string:melon_download_lyrics_nomelontrack "멜론에서 다운받은 음원이 아닙니다."
        return H.a;
    }
}

