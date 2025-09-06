package com.facebook.bolts;

import Tf.o;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors;", "", "()V", "background", "Ljava/util/concurrent/ExecutorService;", "immediate", "Ljava/util/concurrent/Executor;", "scheduled", "Ljava/util/concurrent/ScheduledExecutorService;", "Companion", "ImmediateExecutor", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BoltsExecutors {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001A\u00020\tH\u0007J\r\u0010\n\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\fJ\r\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0002\b\u000FR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$Companion;", "", "()V", "INSTANCE", "Lcom/facebook/bolts/BoltsExecutors;", "isAndroidRuntime", "", "()Z", "background", "Ljava/util/concurrent/ExecutorService;", "immediate", "Ljava/util/concurrent/Executor;", "immediate$facebook_bolts_release", "scheduled", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduled$facebook_bolts_release", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final boolean access$isAndroidRuntime(Companion boltsExecutors$Companion0) {
            return boltsExecutors$Companion0.isAndroidRuntime();
        }

        @NotNull
        public final ExecutorService background() {
            return BoltsExecutors.INSTANCE.background;
        }

        @NotNull
        public final Executor immediate$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.immediate;
        }

        // 去混淆评级： 低(40)
        private final boolean isAndroidRuntime() {
            q.f(Locale.US, "US");
            q.f("android runtime", "this as java.lang.String).toLowerCase(locale)");
            return o.v0("android runtime", "android", false);
        }

        @NotNull
        public final ScheduledExecutorService scheduled$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.scheduled;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$ImmediateExecutor;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "", "incrementDepth", "()I", "decrementDepth", "Ljava/lang/Runnable;", "command", "Lie/H;", "execute", "(Ljava/lang/Runnable;)V", "Ljava/lang/ThreadLocal;", "executionDepth", "Ljava/lang/ThreadLocal;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class ImmediateExecutor implements Executor {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$ImmediateExecutor$Companion;", "", "()V", "MAX_DEPTH", "", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.bolts.BoltsExecutors.ImmediateExecutor.Companion {
            private com.facebook.bolts.BoltsExecutors.ImmediateExecutor.Companion() {
            }

            public com.facebook.bolts.BoltsExecutors.ImmediateExecutor.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.bolts.BoltsExecutors.ImmediateExecutor.Companion Companion = null;
        private static final int MAX_DEPTH = 15;
        @NotNull
        private final ThreadLocal executionDepth;

        static {
            ImmediateExecutor.Companion = new com.facebook.bolts.BoltsExecutors.ImmediateExecutor.Companion(null);
        }

        public ImmediateExecutor() {
            this.executionDepth = new ThreadLocal();
        }

        private final int decrementDepth() {
            Integer integer0 = (Integer)this.executionDepth.get();
            if(integer0 == null) {
                integer0 = 0;
            }
            int v = (int)integer0;
            if(v - 1 == 0) {
                this.executionDepth.remove();
                return 0;
            }
            this.executionDepth.set(((int)(v - 1)));
            return v - 1;
        }

        @Override
        public void execute(@NotNull Runnable runnable0) {
            q.g(runnable0, "command");
            boolean z = this.incrementDepth() > 15;
            try {
                if(z) {
                    BoltsExecutors.Companion.background().execute(runnable0);
                }
                else {
                    runnable0.run();
                }
            }
            finally {
                this.decrementDepth();
            }
        }

        private final int incrementDepth() {
            Integer integer0 = (Integer)this.executionDepth.get();
            if(integer0 == null) {
                integer0 = 0;
            }
            int v = (int)integer0;
            this.executionDepth.set(((int)(v + 1)));
            return v + 1;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final BoltsExecutors INSTANCE;
    @NotNull
    private final ExecutorService background;
    @NotNull
    private final Executor immediate;
    @NotNull
    private final ScheduledExecutorService scheduled;

    static {
        BoltsExecutors.Companion = new Companion(null);
        BoltsExecutors.INSTANCE = new BoltsExecutors();
    }

    private BoltsExecutors() {
        ExecutorService executorService0;
        if(Companion.access$isAndroidRuntime(BoltsExecutors.Companion)) {
            executorService0 = AndroidExecutors.Companion.newCachedThreadPool();
        }
        else {
            executorService0 = Executors.newCachedThreadPool();
            q.f(executorService0, "newCachedThreadPool()");
        }
        this.background = executorService0;
        ScheduledExecutorService scheduledExecutorService0 = Executors.newSingleThreadScheduledExecutor();
        q.f(scheduledExecutorService0, "newSingleThreadScheduledExecutor()");
        this.scheduled = scheduledExecutorService0;
        this.immediate = new ImmediateExecutor();
    }

    @NotNull
    public static final ExecutorService background() {
        return BoltsExecutors.Companion.background();
    }

    @NotNull
    public static final Executor immediate$facebook_bolts_release() {
        return BoltsExecutors.Companion.immediate$facebook_bolts_release();
    }

    @NotNull
    public static final ScheduledExecutorService scheduled$facebook_bolts_release() {
        return BoltsExecutors.Companion.scheduled$facebook_bolts_release();
    }
}

