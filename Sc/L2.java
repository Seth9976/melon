package sc;

import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.mcp.request.PlaylistsSmartHistoryReq;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class l2 extends i implements n {
    public final S2 r;
    public final l1 w;

    public l2(S2 s20, l1 l10, Continuation continuation0) {
        this.r = s20;
        this.w = l10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l2(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new PlaylistsSmartHistoryReq(S2.t(), this.w.a)).tag("SmartServerSyncManagerImpl").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.mcp.response.PlaylistsSmartRes");
        return (PlaylistsSmartRes)httpResponse0;
    }
}

