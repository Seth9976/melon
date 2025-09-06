package com.kakaoent.trevi.ad.network;

import com.google.gson.o;
import com.kakaoent.trevi.ad.util.TreviLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import tg.T;
import ug.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000E\u001A\u00020\f*\u0004\u0018\u00010\u000B2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/kakaoent/trevi/ad/network/ApiModule;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient", "Ltg/T;", "getRetrofitBuilder", "(Lokhttp3/OkHttpClient;)Ltg/T;", "", "", "default", "safeToTimeout", "(Ljava/lang/String;J)J", "T", "Ljava/lang/Class;", "apiClass", "getApi", "(Ljava/lang/Class;)Ljava/lang/Object;", "TimeoutInterceptor", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ApiModule {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/trevi/ad/network/ApiModule$TimeoutInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class TimeoutInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        @NotNull
        public Response intercept(@NotNull Chain interceptor$Chain0) {
            q.g(interceptor$Chain0, "chain");
            Request request0 = interceptor$Chain0.request();
            String s = request0.header("CUSTOM_CONNECT_TIMEOUT");
            String s1 = request0.header("CUSTOM_READ_TIMEOUT");
            if(s != null && s.length() != 0 || s1 != null && s1.length() != 0) {
                int v = (int)ApiModule.INSTANCE.safeToTimeout(s, 20L);
                TimeUnit timeUnit0 = TimeUnit.SECONDS;
                Chain interceptor$Chain1 = interceptor$Chain0.withConnectTimeout(v, timeUnit0).withReadTimeout(((int)ApiModule.INSTANCE.safeToTimeout(s1, 25L)), timeUnit0);
                TreviLog.INSTANCE.d("ApiModule", "TimeoutInterceptor. connectTimeout: " + interceptor$Chain1.connectTimeoutMillis() + ", readTimeout: " + interceptor$Chain1.readTimeoutMillis());
                return interceptor$Chain0.proceed(interceptor$Chain1.request().newBuilder().removeHeader("CUSTOM_CONNECT_TIMEOUT").removeHeader("CUSTOM_READ_TIMEOUT").build());
            }
            return interceptor$Chain0.proceed(request0);
        }
    }

    @NotNull
    public static final ApiModule INSTANCE;

    static {
        ApiModule.INSTANCE = new ApiModule();
    }

    public final Object getApi(@NotNull Class class0) {
        q.g(class0, "apiClass");
        return ApiModuleKt.access$create(this.getRetrofitBuilder(this.getOkHttpClient()), class0);
    }

    private final OkHttpClient getOkHttpClient() {
        Builder okHttpClient$Builder0 = new Builder();
        TimeUnit timeUnit0 = TimeUnit.SECONDS;
        Builder okHttpClient$Builder1 = okHttpClient$Builder0.connectTimeout(20L, timeUnit0).readTimeout(25L, timeUnit0);
        okHttpClient$Builder1.addInterceptor(new TimeoutInterceptor());
        return okHttpClient$Builder1.build();
    }

    private final T getRetrofitBuilder(OkHttpClient okHttpClient0) {
        T t0 = new T();
        a a0 = new a(new o().a());
        t0.c.add(a0);
        t0.c(okHttpClient0);
        return t0;
    }

    private final long safeToTimeout(String s, long v) {
        if(s != null) {
            try {
                return Long.parseLong(s);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return v;
    }
}

