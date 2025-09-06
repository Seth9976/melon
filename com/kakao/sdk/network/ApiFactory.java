package com.kakao.sdk.network;

import A0.c;
import H9.a;
import com.kakao.sdk.common.util.KakaoJson;
import d3.g;
import ie.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import okhttp3.MediaType;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.T;
import tg.U;
import tg.e;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fR\u001B\u0010\u0012\u001A\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u001B\u0010\u0017\u001A\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000F\u001A\u0004\b\u0015\u0010\u0016R\u001B\u0010\u001C\u001A\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000F\u001A\u0004\b\u001A\u0010\u001BR\u001B\u0010 \u001A\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001D\u0010\u000F\u001A\u0004\b\u001E\u0010\u001FR\u001B\u0010#\u001A\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000F\u001A\u0004\b\"\u0010\u001F¨\u0006$"}, d2 = {"Lcom/kakao/sdk/network/ApiFactory;", "", "<init>", "()V", "", "url", "Lokhttp3/OkHttpClient$Builder;", "clientBuilder", "Ltg/e;", "factory", "Ltg/U;", "withClientAndAdapter", "(Ljava/lang/String;Lokhttp3/OkHttpClient$Builder;Ltg/e;)Ltg/U;", "Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "kakaoAgentInterceptor$delegate", "Lie/j;", "getKakaoAgentInterceptor", "()Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "kakaoAgentInterceptor", "Lcom/kakao/sdk/network/AppKeyInterceptor;", "appKeyInterceptor$delegate", "getAppKeyInterceptor", "()Lcom/kakao/sdk/network/AppKeyInterceptor;", "appKeyInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "loggingInterceptor$delegate", "getLoggingInterceptor", "()Lokhttp3/logging/HttpLoggingInterceptor;", "loggingInterceptor", "kapi$delegate", "getKapi", "()Ltg/U;", "kapi", "kapiNoLog$delegate", "getKapiNoLog", "kapiNoLog", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ApiFactory {
    @NotNull
    public static final ApiFactory INSTANCE;
    @NotNull
    private static final j appKeyInterceptor$delegate;
    @NotNull
    private static final j kakaoAgentInterceptor$delegate;
    @NotNull
    private static final j kapi$delegate;
    @NotNull
    private static final j kapiNoLog$delegate;
    @NotNull
    private static final j loggingInterceptor$delegate;

    static {
        ApiFactory.INSTANCE = new ApiFactory();
        ApiFactory.kakaoAgentInterceptor$delegate = g.Q(ApiFactory.kakaoAgentInterceptor.2.INSTANCE);
        ApiFactory.appKeyInterceptor$delegate = g.Q(ApiFactory.appKeyInterceptor.2.INSTANCE);
        ApiFactory.loggingInterceptor$delegate = g.Q(ApiFactory.loggingInterceptor.2.INSTANCE);
        ApiFactory.kapi$delegate = g.Q(ApiFactory.kapi.2.INSTANCE);
        ApiFactory.kapiNoLog$delegate = g.Q(ApiFactory.kapiNoLog.2.INSTANCE);
    }

    @NotNull
    public final AppKeyInterceptor getAppKeyInterceptor() {
        return (AppKeyInterceptor)ApiFactory.appKeyInterceptor$delegate.getValue();
    }

    @NotNull
    public final KakaoAgentInterceptor getKakaoAgentInterceptor() {
        return (KakaoAgentInterceptor)ApiFactory.kakaoAgentInterceptor$delegate.getValue();
    }

    @NotNull
    public final U getKapi() {
        return (U)ApiFactory.kapi$delegate.getValue();
    }

    @NotNull
    public final U getKapiNoLog() {
        return (U)ApiFactory.kapiNoLog$delegate.getValue();
    }

    @NotNull
    public final HttpLoggingInterceptor getLoggingInterceptor() {
        return (HttpLoggingInterceptor)ApiFactory.loggingInterceptor$delegate.getValue();
    }

    @NotNull
    public final U withClientAndAdapter(@NotNull String s, @NotNull Builder okHttpClient$Builder0, @Nullable e e0) {
        q.g(s, "url");
        q.g(okHttpClient$Builder0, "clientBuilder");
        T t0 = new T();
        t0.a(s);
        Json json0 = KakaoJson.INSTANCE.getJson();
        MediaType mediaType0 = MediaType.Companion.get("application/json; charset=UTF8");
        q.g(json0, "$this$asConverterFactory");
        q.g(mediaType0, "contentType");
        a a0 = new a(mediaType0, new c(json0, 24));
        t0.c.add(a0);
        t0.c(okHttpClient$Builder0.build());
        if(e0 != null) {
            t0.d.add(e0);
        }
        return t0.b();
    }

    public static U withClientAndAdapter$default(ApiFactory apiFactory0, String s, Builder okHttpClient$Builder0, e e0, int v, Object object0) {
        if((v & 4) != 0) {
            e0 = null;
        }
        return apiFactory0.withClientAndAdapter(s, okHttpClient$Builder0, e0);
    }
}

