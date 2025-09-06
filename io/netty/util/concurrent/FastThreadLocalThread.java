package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class FastThreadLocalThread extends Thread {
    private final boolean cleanupFastThreadLocals;
    private static final InternalLogger logger;
    private InternalThreadLocalMap threadLocalMap;

    static {
        FastThreadLocalThread.logger = InternalLoggerFactory.getInstance(FastThreadLocalThread.class);
    }

    public FastThreadLocalThread() {
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(Runnable runnable0) {
        super(FastThreadLocalRunnable.wrap(runnable0));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(Runnable runnable0, String s) {
        super(FastThreadLocalRunnable.wrap(runnable0), s);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(String s) {
        super(s);
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup0, Runnable runnable0) {
        super(threadGroup0, FastThreadLocalRunnable.wrap(runnable0));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup0, Runnable runnable0, String s) {
        super(threadGroup0, FastThreadLocalRunnable.wrap(runnable0), s);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup0, Runnable runnable0, String s, long v) {
        super(threadGroup0, FastThreadLocalRunnable.wrap(runnable0), s, v);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup0, String s) {
        super(threadGroup0, s);
        this.cleanupFastThreadLocals = false;
    }

    public boolean permitBlockingCalls() [...] // 潜在的解密器

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap0) {
        if(this != Thread.currentThread()) {
            InternalLogger internalLogger0 = FastThreadLocalThread.logger;
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn(new RuntimeException("It\'s not thread-safe to set \'threadLocalMap\' which doesn\'t belong to the caller thread"));
            }
        }
        this.threadLocalMap = internalThreadLocalMap0;
    }

    public final InternalThreadLocalMap threadLocalMap() {
        if(this != Thread.currentThread()) {
            InternalLogger internalLogger0 = FastThreadLocalThread.logger;
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn(new RuntimeException("It\'s not thread-safe to get \'threadLocalMap\' which doesn\'t belong to the caller thread"));
            }
        }
        return this.threadLocalMap;
    }

    // 去混淆评级： 低(20)
    public static boolean willCleanupFastThreadLocals(Thread thread0) {
        return thread0 instanceof FastThreadLocalThread && ((FastThreadLocalThread)thread0).willCleanupFastThreadLocals();
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }
}

