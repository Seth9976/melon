package com.iloen.melon.net;

import A8.b;
import android.net.Uri;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpStack;
import com.iloen.melon.utils.FlipperManager;
import com.iloen.melon.utils.log.TestLog;
import com.iloen.melon.utils.network.CookieHelper;
import java.net.CookieHandler;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class OkHttpStack implements HttpStack {
    static final class RequestInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        public Response intercept(Chain interceptor$Chain0) {
            Builder request$Builder0 = interceptor$Chain0.request().newBuilder();
            request$Builder0.removeHeader("Cookie");
            request$Builder0.addHeader("Cookie", CookieHelper.getInstance().getCookie());
            return interceptor$Chain0.proceed(request$Builder0.build());
        }
    }

    private static final String HEADER_COOKIE = "Cookie";
    private final CacheControl mCache;
    private OkHttpClient mClient;
    private final CacheControl mNoCache;

    public OkHttpStack() {
        this.mCache = new okhttp3.CacheControl.Builder().maxAge(0, TimeUnit.MILLISECONDS).build();
        this.mNoCache = new okhttp3.CacheControl.Builder().noCache().build();
        this.mClient = this.createOkHttpClient(new okhttp3.OkHttpClient.Builder());
    }

    private OkHttpClient createOkHttpClient(okhttp3.OkHttpClient.Builder okHttpClient$Builder0) {
        okhttp3.OkHttpClient.Builder okHttpClient$Builder1 = okHttpClient$Builder0.cache(OkHttpCache.INSTANCE.getCache()).followRedirects(true).followSslRedirects(true);
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        okHttpClient$Builder1.connectTimeout(10000L, timeUnit0).writeTimeout(10000L, timeUnit0).readTimeout(10000L, timeUnit0).addNetworkInterceptor(new RequestInterceptor()).cookieJar(new JavaNetCookieJar(new CookieHandler() {
            @Override
            public Map get(URI uRI0, Map map0) {
                return map0;
            }

            @Override
            public void put(URI uRI0, Map map0) {
            }
        }));
        if(b.f()) {
            FlipperManager.INSTANCE.addFlipperOkhttpInterceptor(okHttpClient$Builder0);
        }
        return okHttpClient$Builder0.build();
    }

    private static RequestBody createRequestBody(Request request0) {
        byte[] arr_b = request0.getBody();
        return arr_b == null ? null : RequestBody.create(MediaType.parse(request0.getBodyContentType()), arr_b);
    }

    private static HttpEntity getEntity(Response response0) {
        HttpEntity httpEntity0 = new BasicHttpEntity();
        ResponseBody responseBody0 = response0.body();
        ((BasicHttpEntity)httpEntity0).setContent(responseBody0.byteStream());
        ((BasicHttpEntity)httpEntity0).setContentLength(responseBody0.contentLength());
        ((AbstractHttpEntity)httpEntity0).setContentEncoding(response0.header("Content-Encoding"));
        if(responseBody0.contentType() != null) {
            ((AbstractHttpEntity)httpEntity0).setContentType(responseBody0.contentType().type());
        }
        return httpEntity0;
    }

    private static ProtocolVersion parseProtocol(Protocol protocol0) {
        switch(com.iloen.melon.net.OkHttpStack.2.$SwitchMap$okhttp3$Protocol[protocol0.ordinal()]) {
            case 1: {
                return new ProtocolVersion("HTTP", 1, 0);
            }
            case 2: {
                return new ProtocolVersion("HTTP", 1, 1);
            }
            case 3: {
                return new ProtocolVersion("SPDY", 3, 1);
            }
            case 4: {
                return new ProtocolVersion("HTTP", 2, 0);
            }
            default: {
                throw new IllegalAccessError("Unknown protocol: " + protocol0);
            }
        }
    }

    @Override  // com.android.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request request0, Map map0) {
        Cache cache0 = OkHttpCache.INSTANCE.getCache();
        if(this.mClient.cache() != cache0) {
            this.mClient = this.mClient.newBuilder().cache(cache0).build();
        }
        Builder request$Builder0 = new Builder().cacheControl((request0.shouldCache() ? this.mCache : this.mNoCache)).url(request0.getUrl());
        OkHttpStack.setHeaders(request$Builder0, request0, map0);
        OkHttpStack.setConnectionParameters(request$Builder0, request0);
        okhttp3.Request request1 = request$Builder0.build();
        TestLog testLog0 = TestLog.INSTANCE;
        if(testLog0.isTestOn()) {
            testLog0.logVolley("RequestUrl", request0.getUrl());
            Headers headers0 = request1.headers();
            for(int v1 = 0; v1 < headers0.size(); ++v1) {
                if(headers0.name(v1).equals("Cache-Control")) {
                    String s = headers0.value(v1);
                    TestLog.INSTANCE.logVolley("Req-Cache-Control", s);
                }
                else {
                    String s1 = headers0.name(v1);
                    String s2 = headers0.value(v1);
                    TestLog.INSTANCE.logVolley(s1, s2);
                }
            }
            String s3 = Uri.parse(request0.getUrl()).getQuery();
            TestLog.INSTANCE.logVolley("REQ_URL_PARAM", s3);
        }
        Response response0 = this.mClient.newCall(request1).execute();
        HttpResponse httpResponse0 = new BasicHttpResponse(new BasicStatusLine(OkHttpStack.parseProtocol(response0.protocol()), response0.code(), response0.message()));
        ((BasicHttpResponse)httpResponse0).setEntity(OkHttpStack.getEntity(response0));
        Headers headers1 = response0.headers();
        int v2 = headers1.size();
        for(int v = 0; v < v2; ++v) {
            String s4 = headers1.name(v);
            String s5 = headers1.value(v);
            TestLog testLog1 = TestLog.INSTANCE;
            if(testLog1.isTestOn()) {
                if(s4.equals("Cache-Control")) {
                    testLog1.logVolley("Res-Cache-Control", s5);
                }
                else {
                    testLog1.logVolley(s4, s5);
                }
            }
            ((AbstractHttpMessage)httpResponse0).addHeader(new BasicHeader(s4, s5));
        }
        return httpResponse0;
    }

    private static void setConnectionParameters(Builder request$Builder0, Request request0) {
        switch(request0.getMethod()) {
            case -1: {
                byte[] arr_b = request0.getPostBody();
                if(arr_b == null) {
                    request$Builder0.get();
                    return;
                }
                request$Builder0.post(RequestBody.create(MediaType.parse(request0.getPostBodyContentType()), arr_b));
                return;
            }
            case 0: {
                request$Builder0.get();
                return;
            }
            case 1: {
                request$Builder0.post(OkHttpStack.createRequestBody(request0));
                return;
            }
            case 2: {
                request$Builder0.put(OkHttpStack.createRequestBody(request0));
                return;
            }
            case 3: {
                request$Builder0.delete();
                return;
            }
            case 4: {
                request$Builder0.head();
                return;
            }
            case 5: {
                request$Builder0.method("OPTIONS", null);
                return;
            }
            case 6: {
                request$Builder0.method("TRACE", null);
                return;
            }
            case 7: {
                request$Builder0.patch(OkHttpStack.createRequestBody(request0));
                return;
            }
            default: {
                throw new IllegalStateException("Unknown method type.");
            }
        }
    }

    private static void setHeaders(Builder request$Builder0, Request request0, Map map0) {
        for(Object object0: request0.getHeaders().entrySet()) {
            request$Builder0.addHeader(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        for(Object object1: map0.entrySet()) {
            request$Builder0.addHeader(((String)((Map.Entry)object1).getKey()), ((String)((Map.Entry)object1).getValue()));
        }
    }

    private X509TrustManager systemDefaultTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory0 = TrustManagerFactory.getInstance("PKIX");
            trustManagerFactory0.init(null);
            TrustManager[] arr_trustManager = trustManagerFactory0.getTrustManagers();
            if(arr_trustManager.length == 1) {
                TrustManager trustManager0 = arr_trustManager[0];
                if(trustManager0 instanceof X509TrustManager) {
                    return (X509TrustManager)trustManager0;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:[sun.security.ssl.X509TrustManagerImpl@1740fb75]");
        }
        catch(GeneralSecurityException unused_ex) {
            throw new AssertionError();
        }
    }

    class com.iloen.melon.net.OkHttpStack.2 {
        static final int[] $SwitchMap$okhttp3$Protocol;

        static {
            int[] arr_v = new int[Protocol.values().length];
            com.iloen.melon.net.OkHttpStack.2.$SwitchMap$okhttp3$Protocol = arr_v;
            try {
                arr_v[Protocol.HTTP_1_0.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.iloen.melon.net.OkHttpStack.2.$SwitchMap$okhttp3$Protocol[Protocol.HTTP_1_1.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.iloen.melon.net.OkHttpStack.2.$SwitchMap$okhttp3$Protocol[Protocol.SPDY_3.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.iloen.melon.net.OkHttpStack.2.$SwitchMap$okhttp3$Protocol[Protocol.HTTP_2.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

