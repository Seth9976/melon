package com.iloen.melon.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient.Builder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u000B¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/FlipperManager;", "", "Landroid/content/Context;", "context", "Lie/H;", "initFlipper", "(Landroid/content/Context;)V", "Lokhttp3/OkHttpClient$Builder;", "builder", "addFlipperOkhttpInterceptor", "(Lokhttp3/OkHttpClient$Builder;)V", "", "isLeakCanaryActive", "()Z", "isEnable", "configureLeakCanary", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FlipperManager {
    public static final int $stable;
    @NotNull
    public static final FlipperManager INSTANCE;

    static {
        FlipperManager.INSTANCE = new FlipperManager();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void addFlipperOkhttpInterceptor(@NotNull Builder okHttpClient$Builder0) {
        q.g(okHttpClient$Builder0, "builder");
    }

    public final void configureLeakCanary(boolean z) {
    }

    public final void initFlipper(@NotNull Context context0) {
        q.g(context0, "context");
    }

    public final boolean isLeakCanaryActive() {
        return false;
    }
}

