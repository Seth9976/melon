package com.kakao.sdk.auth.network;

import com.kakao.sdk.network.ApiFactory;
import d3.g;
import ie.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tg.U;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001F\u0010\u0006\u001A\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005\"\u001F\u0010\t\u001A\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001A\u0004\b\b\u0010\u0005\"\u001F\u0010\f\u001A\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\u0005\"\u001F\u0010\u0011\u001A\u00020\r*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\u0010\"\u001F\u0010\u0016\u001A\u00020\u0012*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/kakao/sdk/network/ApiFactory;", "Ltg/U;", "kapiWithOAuth$delegate", "Lie/j;", "getKapiWithOAuth", "(Lcom/kakao/sdk/network/ApiFactory;)Ltg/U;", "kapiWithOAuth", "kauth$delegate", "getKauth", "kauth", "kapiWithOAuthNoLog$delegate", "getKapiWithOAuthNoLog", "kapiWithOAuthNoLog", "Lcom/kakao/sdk/auth/network/AccessTokenInterceptor;", "accessTokenInterceptor$delegate", "getAccessTokenInterceptor", "(Lcom/kakao/sdk/network/ApiFactory;)Lcom/kakao/sdk/auth/network/AccessTokenInterceptor;", "accessTokenInterceptor", "Lcom/kakao/sdk/auth/network/RequiredScopesInterceptor;", "requiredScopesInterceptor$delegate", "getRequiredScopesInterceptor", "(Lcom/kakao/sdk/network/ApiFactory;)Lcom/kakao/sdk/auth/network/RequiredScopesInterceptor;", "requiredScopesInterceptor", "auth_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class ApiFactoryKt {
    @NotNull
    private static final j accessTokenInterceptor$delegate;
    @NotNull
    private static final j kapiWithOAuth$delegate;
    @NotNull
    private static final j kapiWithOAuthNoLog$delegate;
    @NotNull
    private static final j kauth$delegate;
    @NotNull
    private static final j requiredScopesInterceptor$delegate;

    static {
        ApiFactoryKt.kapiWithOAuth$delegate = g.Q(ApiFactoryKt.kapiWithOAuth.2.INSTANCE);
        ApiFactoryKt.kauth$delegate = g.Q(ApiFactoryKt.kauth.2.INSTANCE);
        ApiFactoryKt.kapiWithOAuthNoLog$delegate = g.Q(ApiFactoryKt.kapiWithOAuthNoLog.2.INSTANCE);
        ApiFactoryKt.accessTokenInterceptor$delegate = g.Q(ApiFactoryKt.accessTokenInterceptor.2.INSTANCE);
        ApiFactoryKt.requiredScopesInterceptor$delegate = g.Q(ApiFactoryKt.requiredScopesInterceptor.2.INSTANCE);
    }

    @NotNull
    public static final AccessTokenInterceptor getAccessTokenInterceptor(@NotNull ApiFactory apiFactory0) {
        q.g(apiFactory0, "<this>");
        return (AccessTokenInterceptor)ApiFactoryKt.accessTokenInterceptor$delegate.getValue();
    }

    @NotNull
    public static final U getKapiWithOAuth(@NotNull ApiFactory apiFactory0) {
        q.g(apiFactory0, "<this>");
        return (U)ApiFactoryKt.kapiWithOAuth$delegate.getValue();
    }

    @NotNull
    public static final U getKapiWithOAuthNoLog(@NotNull ApiFactory apiFactory0) {
        q.g(apiFactory0, "<this>");
        return (U)ApiFactoryKt.kapiWithOAuthNoLog$delegate.getValue();
    }

    @NotNull
    public static final U getKauth(@NotNull ApiFactory apiFactory0) {
        q.g(apiFactory0, "<this>");
        return (U)ApiFactoryKt.kauth$delegate.getValue();
    }

    @NotNull
    public static final RequiredScopesInterceptor getRequiredScopesInterceptor(@NotNull ApiFactory apiFactory0) {
        q.g(apiFactory0, "<this>");
        return (RequiredScopesInterceptor)ApiFactoryKt.requiredScopesInterceptor$delegate.getValue();
    }
}

