package com.kakao.sdk.network;

import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/logging/HttpLoggingInterceptor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
final class ApiFactory.loggingInterceptor.2 extends r implements a {
    public static final ApiFactory.loggingInterceptor.2 INSTANCE;

    static {
        ApiFactory.loggingInterceptor.2.INSTANCE = new ApiFactory.loggingInterceptor.2();
    }

    public ApiFactory.loggingInterceptor.2() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    @NotNull
    public final HttpLoggingInterceptor invoke() {
        HttpLoggingInterceptor httpLoggingInterceptor0 = new HttpLoggingInterceptor(new com.kakao.sdk.network.a());  // 初始化器: Ljava/lang/Object;-><init>()V
        httpLoggingInterceptor0.level(Level.HEADERS);
        return httpLoggingInterceptor0;
    }

    private static final void invoke$lambda$0(String s) {
        q.g(s, "message");
        SdkLog.Companion.i(s);
    }
}

