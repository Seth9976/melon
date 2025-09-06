package okhttp3.internal.cache;

import Tf.v;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers.Builder;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001A\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\bH\u0002J\u0010\u0010\f\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000EH\u0016R\u0016\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CacheInterceptor implements Interceptor {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\u0010\u0010\u000B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\u0014\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002¨\u0006\u000F"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final Headers combine(Headers headers0, Headers headers1) {
            Builder headers$Builder0 = new Builder();
            int v = headers0.size();
            for(int v2 = 0; v2 < v; ++v2) {
                String s = headers0.name(v2);
                String s1 = headers0.value(v2);
                if((!"Warning".equalsIgnoreCase(s) || !v.r0(s1, "1", false)) && (this.isContentSpecificHeader(s) || !this.isEndToEnd(s) || headers1.get(s) == null)) {
                    headers$Builder0.addLenient$okhttp(s, s1);
                }
            }
            int v3 = headers1.size();
            for(int v1 = 0; v1 < v3; ++v1) {
                String s2 = headers1.name(v1);
                if(!this.isContentSpecificHeader(s2) && this.isEndToEnd(s2)) {
                    headers$Builder0.addLenient$okhttp(s2, headers1.value(v1));
                }
            }
            return headers$Builder0.build();
        }

        // 去混淆评级： 低(30)
        private final boolean isContentSpecificHeader(String s) {
            return "Content-Length".equalsIgnoreCase(s) || "Content-Encoding".equalsIgnoreCase(s) || "Content-Type".equalsIgnoreCase(s);
        }

        // 去混淆评级： 中等(80)
        private final boolean isEndToEnd(String s) {
            return !"Connection".equalsIgnoreCase(s) && !"Keep-Alive".equalsIgnoreCase(s) && !"Proxy-Authenticate".equalsIgnoreCase(s) && !"Proxy-Authorization".equalsIgnoreCase(s) && !"TE".equalsIgnoreCase(s) && !"Trailers".equalsIgnoreCase(s) && !"Transfer-Encoding".equalsIgnoreCase(s) && !"Upgrade".equalsIgnoreCase(s);
        }

        private final Response stripBody(Response response0) {
            return (response0 == null ? null : response0.body()) == null ? response0 : response0.newBuilder().body(null).build();
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Cache cache;

    static {
        CacheInterceptor.Companion = new Companion(null);
    }

    public CacheInterceptor(@Nullable Cache cache0) {
        this.cache = cache0;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest0, Response response0) {
        if(cacheRequest0 == null) {
            return response0;
        }
        Sink sink0 = cacheRequest0.body();
        ResponseBody responseBody0 = response0.body();
        q.d(responseBody0);
        okhttp3.internal.cache.CacheInterceptor.cacheWritingResponse.cacheWritingSource.1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$10 = new Source() {
            private boolean cacheRequestClosed;

            @Override  // okio.Source
            public void close() {
                if(!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    Okio.buffer(sink0).abort();
                }
                cacheRequest0.close();
            }

            @Override  // okio.Source
            public long read(@NotNull Buffer buffer0, long v) {
                long v1;
                q.g(buffer0, "sink");
                try {
                    v1 = cacheRequest0.read(buffer0, v);
                }
                catch(IOException iOException0) {
                    if(!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        Okio.buffer(sink0).abort();
                    }
                    throw iOException0;
                }
                if(v1 == -1L) {
                    if(!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        this.$cacheBody.close();
                    }
                    return -1L;
                }
                buffer0.copyTo(this.$cacheBody.getBuffer(), buffer0.size() - v1, v1);
                this.$cacheBody.emitCompleteSegments();
                return v1;
            }

            @Override  // okio.Source
            @NotNull
            public Timeout timeout() {
                return cacheRequest0.timeout();
            }
        };
        String s = Response.header$default(response0, "Content-Type", null, 2, null);
        long v = response0.body().contentLength();
        return response0.newBuilder().body(new RealResponseBody(s, v, Okio.buffer(cacheInterceptor$cacheWritingResponse$cacheWritingSource$10))).build();
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        Response response4;
        EventListener eventListener0;
        q.g(interceptor$Chain0, "chain");
        Call call0 = interceptor$Chain0.call();
        RealCall realCall0 = null;
        Response response0 = this.cache == null ? null : this.cache.get$okhttp(interceptor$Chain0.request());
        CacheStrategy cacheStrategy0 = new Factory(System.currentTimeMillis(), interceptor$Chain0.request(), response0).compute();
        Request request0 = cacheStrategy0.getNetworkRequest();
        Response response1 = cacheStrategy0.getCacheResponse();
        Cache cache0 = this.cache;
        if(cache0 != null) {
            cache0.trackResponse$okhttp(cacheStrategy0);
        }
        if(call0 instanceof RealCall) {
            realCall0 = (RealCall)call0;
        }
        if(realCall0 == null) {
            eventListener0 = EventListener.NONE;
        }
        else {
            eventListener0 = realCall0.getEventListener$okhttp();
            if(eventListener0 == null) {
                eventListener0 = EventListener.NONE;
            }
        }
        if(response0 != null && response1 == null) {
            ResponseBody responseBody0 = response0.body();
            if(responseBody0 != null) {
                Util.closeQuietly(responseBody0);
            }
        }
        if(request0 == null && response1 == null) {
            Response response2 = new okhttp3.Response.Builder().request(interceptor$Chain0.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener0.satisfactionFailure(call0, response2);
            return response2;
        }
        if(request0 == null) {
            q.d(response1);
            Response response3 = response1.newBuilder().cacheResponse(CacheInterceptor.Companion.stripBody(response1)).build();
            eventListener0.cacheHit(call0, response3);
            return response3;
        }
        if(response1 != null) {
            eventListener0.cacheConditionalHit(call0, response1);
        }
        else if(this.cache != null) {
            eventListener0.cacheMiss(call0);
        }
        try {
            response4 = interceptor$Chain0.proceed(request0);
        }
        catch(Throwable throwable0) {
            if(response0 != null) {
                ResponseBody responseBody1 = response0.body();
                if(responseBody1 != null) {
                    Util.closeQuietly(responseBody1);
                }
            }
            throw throwable0;
        }
        if(response4 == null && response0 != null) {
            ResponseBody responseBody2 = response0.body();
            if(responseBody2 != null) {
                Util.closeQuietly(responseBody2);
            }
        }
        if(response1 != null) {
            if(response4 != null && response4.code() == 304) {
                Response response5 = response1.newBuilder().headers(CacheInterceptor.Companion.combine(response1.headers(), response4.headers())).sentRequestAtMillis(response4.sentRequestAtMillis()).receivedResponseAtMillis(response4.receivedResponseAtMillis()).cacheResponse(CacheInterceptor.Companion.stripBody(response1)).networkResponse(CacheInterceptor.Companion.stripBody(response4)).build();
                ResponseBody responseBody3 = response4.body();
                q.d(responseBody3);
                responseBody3.close();
                q.d(this.cache);
                this.cache.trackConditionalCacheHit$okhttp();
                this.cache.update$okhttp(response1, response5);
                eventListener0.cacheHit(call0, response5);
                return response5;
            }
            ResponseBody responseBody4 = response1.body();
            if(responseBody4 != null) {
                Util.closeQuietly(responseBody4);
            }
        }
        q.d(response4);
        Response response6 = response4.newBuilder().cacheResponse(CacheInterceptor.Companion.stripBody(response1)).networkResponse(CacheInterceptor.Companion.stripBody(response4)).build();
        if(this.cache != null) {
            if(HttpHeaders.promisesBody(response6) && CacheStrategy.Companion.isCacheable(response6, request0)) {
                Response response7 = this.cacheWritingResponse(this.cache.put$okhttp(response6), response6);
                if(response1 != null) {
                    eventListener0.cacheMiss(call0);
                }
                return response7;
            }
            if(HttpMethod.INSTANCE.invalidatesCache(request0.method())) {
                try {
                    this.cache.remove$okhttp(request0);
                }
                catch(IOException unused_ex) {
                }
            }
        }
        return response6;
    }
}

