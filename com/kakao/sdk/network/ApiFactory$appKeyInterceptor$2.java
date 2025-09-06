package com.kakao.sdk.network;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/kakao/sdk/network/AppKeyInterceptor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
final class ApiFactory.appKeyInterceptor.2 extends r implements a {
    public static final ApiFactory.appKeyInterceptor.2 INSTANCE;

    static {
        ApiFactory.appKeyInterceptor.2.INSTANCE = new ApiFactory.appKeyInterceptor.2();
    }

    public ApiFactory.appKeyInterceptor.2() {
        super(0);
    }

    @NotNull
    public final AppKeyInterceptor invoke() {
        return new AppKeyInterceptor(null, 1, null);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }
}

