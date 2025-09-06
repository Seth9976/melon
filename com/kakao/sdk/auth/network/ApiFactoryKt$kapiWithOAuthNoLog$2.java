package com.kakao.sdk.auth.network;

import com.kakao.sdk.network.ApiFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import okhttp3.OkHttpClient.Builder;
import org.jetbrains.annotations.NotNull;
import tg.U;
import we.a;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltg/U;", "invoke", "()Ltg/U;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class ApiFactoryKt.kapiWithOAuthNoLog.2 extends r implements a {
    public static final ApiFactoryKt.kapiWithOAuthNoLog.2 INSTANCE;

    static {
        ApiFactoryKt.kapiWithOAuthNoLog.2.INSTANCE = new ApiFactoryKt.kapiWithOAuthNoLog.2();
    }

    public ApiFactoryKt.kapiWithOAuthNoLog.2() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final U invoke() {
        Builder okHttpClient$Builder0 = new Builder().addInterceptor(ApiFactory.INSTANCE.getKakaoAgentInterceptor()).addInterceptor(ApiFactoryKt.getAccessTokenInterceptor(ApiFactory.INSTANCE)).addInterceptor(ApiFactoryKt.getRequiredScopesInterceptor(ApiFactory.INSTANCE));
        return ApiFactory.withClientAndAdapter$default(ApiFactory.INSTANCE, "https://kapi.kakao.com", okHttpClient$Builder0, null, 4, null);
    }
}

