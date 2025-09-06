package com.facebook.bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/bolts/AndroidExecutors;", "", "()V", "uiThread", "Ljava/util/concurrent/Executor;", "Companion", "UIThreadExecutor", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AndroidExecutors {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000B\u001A\u00020\fH\u0007J\b\u0010\r\u001A\u00020\u000EH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/facebook/bolts/AndroidExecutors$Companion;", "", "()V", "CORE_POOL_SIZE", "", "CPU_COUNT", "INSTANCE", "Lcom/facebook/bolts/AndroidExecutors;", "KEEP_ALIVE_TIME", "", "MAX_POOL_SIZE", "newCachedThreadPool", "Ljava/util/concurrent/ExecutorService;", "uiThread", "Ljava/util/concurrent/Executor;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ExecutorService newCachedThreadPool() {
            ExecutorService executorService0 = new ThreadPoolExecutor(9, 17, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            ((ThreadPoolExecutor)executorService0).allowCoreThreadTimeOut(true);
            return executorService0;
        }

        @NotNull
        public final Executor uiThread() {
            return AndroidExecutors.INSTANCE.uiThread;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/bolts/AndroidExecutors$UIThreadExecutor;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "command", "Lie/H;", "execute", "(Ljava/lang/Runnable;)V", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class UIThreadExecutor implements Executor {
        @Override
        public void execute(@NotNull Runnable runnable0) {
            q.g(runnable0, "command");
            new Handler(Looper.getMainLooper()).post(runnable0);
        }
    }

    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final AndroidExecutors INSTANCE = null;
    private static final long KEEP_ALIVE_TIME = 1L;
    private static final int MAX_POOL_SIZE;
    @NotNull
    private final Executor uiThread;

    static {
        AndroidExecutors.Companion = new Companion(null);
        AndroidExecutors.INSTANCE = new AndroidExecutors();
        int v = Runtime.getRuntime().availableProcessors();
        AndroidExecutors.CPU_COUNT = v;
        AndroidExecutors.CORE_POOL_SIZE = v + 1;
        AndroidExecutors.MAX_POOL_SIZE = v * 2 + 1;
    }

    private AndroidExecutors() {
        this.uiThread = new UIThreadExecutor();
    }

    public static final int access$getCORE_POOL_SIZE$cp() [...] // 潜在的解密器

    public static final int access$getMAX_POOL_SIZE$cp() [...] // 潜在的解密器

    @NotNull
    public static final ExecutorService newCachedThreadPool() {
        return AndroidExecutors.Companion.newCachedThreadPool();
    }

    @NotNull
    public static final Executor uiThread() {
        return AndroidExecutors.Companion.uiThread();
    }
}

