package dc;

import Db.i;
import Hb.h;
import Qb.b;
import Tf.o;
import Vc.B;
import com.iloen.melon.popup.H;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import ea.d;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import we.k;

public final class g extends EventListener {
    public static final g a;
    public static final i b;
    public static final d c;
    public static final MutableStateFlow d;
    public static final CoroutineScope e;
    public static final Channel f;

    static {
        g.a = new g();  // 初始化器: Lokhttp3/EventListener;-><init>()V
        i i0 = new i("StreamingApiTracker");
        i0.e(h.b);
        g.b = i0;
        g.c = new d(6);
        g.d = StateFlowKt.MutableStateFlow(new NetworkEvents(null, null, null, null, null, 0x1F, null));
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        g.e = coroutineScope0;
        g.f = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new e(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public static void a(Call call0, String s, k k0) {
        Iterable iterable0 = call0.request().url().pathSegments();
        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
            for(Object object0: iterable0) {
                if(o.v0(((String)object0), "streaming_path.json", false)) {
                    H h0 = new H(23);
                    b b0 = new b(s, 2);
                    i.c(g.b, h0, b0, 1);
                    f f0 = new f(k0, null);
                    BuildersKt__Builders_commonKt.launch$default(g.e, null, null, f0, 3, null);
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    @Override  // okhttp3.EventListener
    public final void cacheConditionalHit(Call call0, Response response0) {
        q.g(call0, "call");
        q.g(response0, "cachedResponse");
        g.a(call0, "cacheConditionalHit() " + response0, new c(2));
    }

    @Override  // okhttp3.EventListener
    public final void cacheHit(Call call0, Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        g.a(call0, "cacheHit() " + response0, new c(11));
    }

    @Override  // okhttp3.EventListener
    public final void cacheMiss(Call call0) {
        q.g(call0, "call");
        g.a(call0, "cacheMiss()", new c(12));
    }

    @Override  // okhttp3.EventListener
    public final void callEnd(Call call0) {
        q.g(call0, "call");
        g.a(call0, "callEnd()", new c(14));
    }

    @Override  // okhttp3.EventListener
    public final void callFailed(Call call0, IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        g.a(call0, "callFailed() " + iOException0, new dc.b(2, iOException0));
    }

    @Override  // okhttp3.EventListener
    public final void callStart(Call call0) {
        q.g(call0, "call");
        g.a(call0, "callStart()", new c(5));
    }

    @Override  // okhttp3.EventListener
    public final void canceled(Call call0) {
        q.g(call0, "call");
        g.a(call0, "canceled()", new c(16));
    }

    @Override  // okhttp3.EventListener
    public final void connectEnd(Call call0, InetSocketAddress inetSocketAddress0, Proxy proxy0, Protocol protocol0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        g.a(call0, "connectEnd() " + inetSocketAddress0 + ", proxy: " + proxy0 + ", protocol: " + protocol0, new c(13));
    }

    @Override  // okhttp3.EventListener
    public final void connectFailed(Call call0, InetSocketAddress inetSocketAddress0, Proxy proxy0, Protocol protocol0, IOException iOException0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        q.g(iOException0, "ioe");
        g.a(call0, "connectFailed() " + inetSocketAddress0 + ", proxy: " + proxy0 + ", protocol: " + protocol0 + ", ioe: " + iOException0, new dc.b(3, iOException0));
    }

    @Override  // okhttp3.EventListener
    public final void connectStart(Call call0, InetSocketAddress inetSocketAddress0, Proxy proxy0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        g.a(call0, "connectStart() " + inetSocketAddress0 + ", proxy: " + proxy0, new c(4));
    }

    @Override  // okhttp3.EventListener
    public final void connectionAcquired(Call call0, Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
        g.a(call0, "connectionAcquired() " + connection0, new dc.d(connection0, 1));
    }

    @Override  // okhttp3.EventListener
    public final void connectionReleased(Call call0, Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
        g.a(call0, "connectionReleased() " + connection0, new dc.d(connection0, 0));
    }

    @Override  // okhttp3.EventListener
    public final void dnsEnd(Call call0, String s, List list0) {
        q.g(call0, "call");
        q.g(s, "domainName");
        q.g(list0, "inetAddressList");
        g.a(call0, "dnsEnd() " + s + ", inetAddressList: " + list0, new com.iloen.melon.player.playlist.common.h(29));
    }

    @Override  // okhttp3.EventListener
    public final void dnsStart(Call call0, String s) {
        q.g(call0, "call");
        q.g(s, "domainName");
        g.a(call0, "dnsStart() " + s, new c(3));
    }

    @Override  // okhttp3.EventListener
    public final void proxySelectEnd(Call call0, HttpUrl httpUrl0, List list0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
        q.g(list0, "proxies");
        g.a(call0, "proxySelectEnd() " + httpUrl0 + ", proxies: " + list0, new c(1));
    }

    @Override  // okhttp3.EventListener
    public final void proxySelectStart(Call call0, HttpUrl httpUrl0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
        g.a(call0, "proxySelectStart() " + httpUrl0, new c(18));
    }

    @Override  // okhttp3.EventListener
    public final void requestBodyEnd(Call call0, long v) {
        q.g(call0, "call");
        g.a(call0, "requestBodyEnd() " + v, new c(17));
    }

    @Override  // okhttp3.EventListener
    public final void requestFailed(Call call0, IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        g.a(call0, "requestFailed() " + iOException0, new dc.b(1, iOException0));
    }

    @Override  // okhttp3.EventListener
    public final void requestHeadersEnd(Call call0, Request request0) {
        q.g(call0, "call");
        q.g(request0, "request");
        g.a(call0, "requestHeadersEnd() " + request0, new B(request0, 25));
    }

    @Override  // okhttp3.EventListener
    public final void requestHeadersStart(Call call0) {
        q.g(call0, "call");
        g.a(call0, "requestHeadersStart()", new c(10));
    }

    @Override  // okhttp3.EventListener
    public final void responseBodyEnd(Call call0, long v) {
        q.g(call0, "call");
        g.a(call0, "responseBodyEnd() " + v, new c(8));
    }

    @Override  // okhttp3.EventListener
    public final void responseBodyStart(Call call0) {
        q.g(call0, "call");
        g.a(call0, "responseBodyStart()", new c(7));
    }

    @Override  // okhttp3.EventListener
    public final void responseFailed(Call call0, IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        g.a(call0, "responseFailed() " + iOException0, new dc.b(0, iOException0));
    }

    @Override  // okhttp3.EventListener
    public final void responseHeadersEnd(Call call0, Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        g.a(call0, "responseHeadersEnd() " + response0, new B(response0, 26));
    }

    @Override  // okhttp3.EventListener
    public final void responseHeadersStart(Call call0) {
        q.g(call0, "call");
        g.a(call0, "responseHeadersStart()", new c(15));
    }

    @Override  // okhttp3.EventListener
    public final void satisfactionFailure(Call call0, Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        g.a(call0, "satisfactionFailure() " + response0, new c(9));
    }

    @Override  // okhttp3.EventListener
    public final void secureConnectEnd(Call call0, Handshake handshake0) {
        q.g(call0, "call");
        g.a(call0, "secureConnectEnd() " + handshake0, new c(6));
    }

    @Override  // okhttp3.EventListener
    public final void secureConnectStart(Call call0) {
        q.g(call0, "call");
        g.a(call0, "secureConnectStart()", new c(0));
    }
}

