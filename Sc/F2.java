package sc;

import android.content.Context;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.mcp.request.PlaylistsSmartTracksDeleteReq;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class f2 extends i implements n {
    public String B;
    public int D;
    public final S2 E;
    public final l1 G;
    public final ArrayList I;
    public RequestFuture r;
    public Context w;

    public f2(S2 s20, l1 l10, ArrayList arrayList0, Continuation continuation0) {
        this.E = s20;
        this.G = l10;
        this.I = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f2(this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        Context context1;
        RequestFuture requestFuture1;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                this.E.getClass();
                Context context0 = S2.t();
                String s = this.G.a;
                this.r = requestFuture0;
                this.w = context0;
                this.B = s;
                this.D = 1;
                Object object1 = this.E.x(this);
                if(object1 == a0) {
                    return a0;
                }
                requestFuture1 = requestFuture0;
                object0 = object1;
                context1 = context0;
                s1 = s;
                break;
            }
            case 1: {
                String s2 = this.B;
                context1 = this.w;
                RequestFuture requestFuture2 = this.r;
                d5.n.D(object0);
                requestFuture1 = requestFuture2;
                s1 = s2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new PlaylistsSmartTracksDeleteReq(context1, s1, ((Number)object0).longValue(), this.I)).tag("SmartServerSyncManagerImpl").listener(requestFuture1).errorListener(requestFuture1).requestSync(requestFuture1);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes");
        return (PlaylistsSmartEditRes)httpResponse0;
    }
}

