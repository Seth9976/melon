package com.bumptech.glide.integration.okhttp3;

import Rd.b;
import a7.c;
import com.iloen.melon.utils.image.ImageCacheManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import x8.f;

public class MelonImageClient {
    static final class RequestInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        public Response intercept(Chain interceptor$Chain0) {
            Builder request$Builder0 = interceptor$Chain0.request().newBuilder();
            request$Builder0.removeHeader("Accept-Encoding");
            return interceptor$Chain0.proceed(request$Builder0.build());
        }
    }

    private OkHttpClient mClient;

    public MelonImageClient() {
        Cache cache0 = ImageCacheManager.INSTANCE.getGlideDiskCache();
        try {
            this.mClient = this.buildClient(cache0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            c.a().c(illegalArgumentException0);
            ImageCacheManager.INSTANCE.reset();
            this.mClient = this.buildClient(cache0);
        }

        class com.bumptech.glide.integration.okhttp3.MelonImageClient.1 extends f {
            public com.bumptech.glide.integration.okhttp3.MelonImageClient.1(Cache cache0) {
            }

            @Override  // x8.f
            public Object backgroundWork(Object object0, Continuation continuation0) {
                return this.backgroundWork(((Void)object0), continuation0);
            }

            public Object backgroundWork(Void void0, Continuation continuation0) {
                MelonImageClient.a(MelonImageClient.this, this.val$cache);
                return null;
            }
        }

    }

    public static void a(MelonImageClient melonImageClient0, Cache cache0) {
        melonImageClient0.clearMalformedUrls(cache0);
    }

    private OkHttpClient buildClient(Cache cache0) {
        okhttp3.OkHttpClient.Builder okHttpClient$Builder0 = new okhttp3.OkHttpClient.Builder().cache(cache0).followRedirects(true).followSslRedirects(true).addInterceptor(new b());  // 初始化器: Ljava/lang/Object;-><init>()V
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        return okHttpClient$Builder0.connectTimeout(10000L, timeUnit0).writeTimeout(10000L, timeUnit0).readTimeout(10000L, timeUnit0).addNetworkInterceptor(new RequestInterceptor()).build();
    }

    private void clearMalformedUrls(Cache cache0) {
        try {
            Iterator iterator0 = cache0.urls();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(HttpUrl.parse(((String)object0)) == null) {
                    iterator0.remove();
                }
            }
        }
        catch(IOException unused_ex) {
        }
    }

    public OkHttpClient getClient() {
        return this.mClient;
    }
}

