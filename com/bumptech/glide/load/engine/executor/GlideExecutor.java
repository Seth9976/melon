package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class GlideExecutor implements ExecutorService {
    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        private ThreadFactory threadFactory;
        private long threadTimeoutMillis;
        private UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public Builder(boolean z) {
            this.threadFactory = new DefaultPriorityThreadFactory(null);
            this.uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;
            this.preventNetworkOperations = z;
        }

        public GlideExecutor build() {
            if(TextUtils.isEmpty(this.name)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
            }
            ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
            if(this.threadTimeoutMillis != 0L) {
                threadPoolExecutor0.allowCoreThreadTimeOut(true);
            }
            return new GlideExecutor(threadPoolExecutor0);
        }

        public Builder setName(String s) {
            this.name = s;
            return this;
        }

        public Builder setThreadCount(int v) {
            this.corePoolSize = v;
            this.maximumPoolSize = v;
            return this;
        }

        @Deprecated
        public Builder setThreadFactory(ThreadFactory threadFactory0) {
            this.threadFactory = threadFactory0;
            return this;
        }

        public Builder setThreadTimeoutMillis(long v) {
            this.threadTimeoutMillis = v;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
            this.uncaughtThrowableStrategy = glideExecutor$UncaughtThrowableStrategy0;
            return this;
        }
    }

    static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        private DefaultPriorityThreadFactory() {
        }

        public DefaultPriorityThreadFactory(com.bumptech.glide.load.engine.executor.GlideExecutor.1 glideExecutor$10) {
        }

        @Override
        public Thread newThread(Runnable runnable0) {
            return new Thread(runnable0) {
                @Override
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    static final class DefaultThreadFactory implements ThreadFactory {
        private final ThreadFactory delegate;
        private final String name;
        final boolean preventNetworkOperations;
        private final AtomicInteger threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public DefaultThreadFactory(ThreadFactory threadFactory0, String s, UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0, boolean z) {
            this.threadNum = new AtomicInteger();
            this.delegate = threadFactory0;
            this.name = s;
            this.uncaughtThrowableStrategy = glideExecutor$UncaughtThrowableStrategy0;
            this.preventNetworkOperations = z;
        }

        @Override
        public Thread newThread(Runnable runnable0) {
            com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1 glideExecutor$DefaultThreadFactory$10 = new Runnable() {
                @Override
                public void run() {
                    if(DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable0.run();
                    }
                    catch(Throwable throwable0) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(throwable0);
                    }
                }
            };
            Thread thread0 = this.delegate.newThread(glideExecutor$DefaultThreadFactory$10);
            thread0.setName("glide-" + this.name + "-thread-" + this.threadNum.getAndIncrement());
            return thread0;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE;
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW;

        static {
            UncaughtThrowableStrategy.IGNORE = new UncaughtThrowableStrategy() {
                @Override  // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
                public void handle(Throwable throwable0) {
                }
            };
            com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2 glideExecutor$UncaughtThrowableStrategy$20 = new UncaughtThrowableStrategy() {
                @Override  // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
                public void handle(Throwable throwable0) {
                    if(throwable0 != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", throwable0);
                    }
                }
            };
            UncaughtThrowableStrategy.LOG = glideExecutor$UncaughtThrowableStrategy$20;
            UncaughtThrowableStrategy.THROW = new UncaughtThrowableStrategy() {
                @Override  // com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
                public void handle(Throwable throwable0) {
                    if(throwable0 != null) {
                        throw new RuntimeException("Request threw uncaught throwable", throwable0);
                    }
                }
            };
            UncaughtThrowableStrategy.DEFAULT = glideExecutor$UncaughtThrowableStrategy$20;
        }

        void handle(Throwable arg1);
    }

    static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = 0L;
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    static {
        GlideExecutor.KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10L);
    }

    public GlideExecutor(ExecutorService executorService0) {
        this.delegate = executorService0;
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return this.delegate.awaitTermination(v, timeUnit0);
    }

    public static int calculateAnimationExecutorThreadCount() {
        return GlideExecutor.calculateBestThreadCount() < 4 ? 1 : 2;
    }

    public static int calculateBestThreadCount() {
        if(GlideExecutor.bestThreadCount == 0) {
            GlideExecutor.bestThreadCount = 4;
        }
        return GlideExecutor.bestThreadCount;
    }

    @Override
    public void execute(Runnable runnable0) {
        this.delegate.execute(runnable0);
    }

    @Override
    public List invokeAll(Collection collection0) {
        return this.delegate.invokeAll(collection0);
    }

    @Override
    public List invokeAll(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.delegate.invokeAll(collection0, v, timeUnit0);
    }

    @Override
    public Object invokeAny(Collection collection0) {
        return this.delegate.invokeAny(collection0);
    }

    @Override
    public Object invokeAny(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.delegate.invokeAny(collection0, v, timeUnit0);
    }

    @Override
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public static Builder newAnimationBuilder() {
        int v = GlideExecutor.calculateAnimationExecutorThreadCount();
        return new Builder(true).setThreadCount(v).setName("animation");
    }

    public static GlideExecutor newAnimationExecutor() {
        return GlideExecutor.newAnimationBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int v, UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
        return GlideExecutor.newAnimationBuilder().setThreadCount(v).setUncaughtThrowableStrategy(glideExecutor$UncaughtThrowableStrategy0).build();
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName("disk-cache");
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return GlideExecutor.newDiskCacheBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int v, String s, UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
        return GlideExecutor.newDiskCacheBuilder().setThreadCount(v).setName(s).setUncaughtThrowableStrategy(glideExecutor$UncaughtThrowableStrategy0).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
        return GlideExecutor.newDiskCacheBuilder().setUncaughtThrowableStrategy(glideExecutor$UncaughtThrowableStrategy0).build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(GlideExecutor.calculateBestThreadCount()).setName("source");
    }

    public static GlideExecutor newSourceExecutor() {
        return GlideExecutor.newSourceBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int v, String s, UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
        return GlideExecutor.newSourceBuilder().setThreadCount(v).setName(s).setUncaughtThrowableStrategy(glideExecutor$UncaughtThrowableStrategy0).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy0) {
        return GlideExecutor.newSourceBuilder().setUncaughtThrowableStrategy(glideExecutor$UncaughtThrowableStrategy0).build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        SynchronousQueue synchronousQueue0 = new SynchronousQueue();
        DefaultThreadFactory glideExecutor$DefaultThreadFactory0 = new DefaultThreadFactory(new DefaultPriorityThreadFactory(null), "source-unlimited", UncaughtThrowableStrategy.DEFAULT, false);
        return new GlideExecutor(new ThreadPoolExecutor(0, 0x7FFFFFFF, GlideExecutor.KEEP_ALIVE_TIME_MS, timeUnit0, synchronousQueue0, glideExecutor$DefaultThreadFactory0));
    }

    @Override
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override
    public List shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override
    public Future submit(Runnable runnable0) {
        return this.delegate.submit(runnable0);
    }

    @Override
    public Future submit(Runnable runnable0, Object object0) {
        return this.delegate.submit(runnable0, object0);
    }

    @Override
    public Future submit(Callable callable0) {
        return this.delegate.submit(callable0);
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    class com.bumptech.glide.load.engine.executor.GlideExecutor.1 {
    }

}

