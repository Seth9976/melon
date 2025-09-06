package com.iloen.melon.utils.log;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/log/MelonRetrofitLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "message", "Lie/H;", "log", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonRetrofitLogger implements Logger {
    public static final int $stable;
    @NotNull
    public static final MelonRetrofitLogger INSTANCE;

    static {
        MelonRetrofitLogger.INSTANCE = new MelonRetrofitLogger();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // okhttp3.logging.HttpLoggingInterceptor$Logger
    public void log(@NotNull String s) {
        q.g(s, "message");
        LogU.debug$default(new LogU("Retrofit"), s, null, false, 6, null);
    }
}

