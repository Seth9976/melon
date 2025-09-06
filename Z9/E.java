package z9;

import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SettingGnrListExcGnrReq;
import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class e extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new SettingGnrListExcGnrReq(Y.a(MelonAppBase.Companion))).tag("ExcludedGenreSyncExecutor").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes");
        return (SettingGnrListExcGnrRes)httpResponse0;
    }
}

