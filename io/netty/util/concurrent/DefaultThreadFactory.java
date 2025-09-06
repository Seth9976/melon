package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
    private final boolean daemon;
    private final AtomicInteger nextId;
    private static final AtomicInteger poolId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    static {
        DefaultThreadFactory.poolId = new AtomicInteger();
    }

    public DefaultThreadFactory(Class class0) {
        this(class0, false, 5);
    }

    public DefaultThreadFactory(Class class0, int v) {
        this(class0, false, v);
    }

    public DefaultThreadFactory(Class class0, boolean z) {
        this(class0, z, 5);
    }

    public DefaultThreadFactory(Class class0, boolean z, int v) {
        this(DefaultThreadFactory.toPoolName(class0), z, v);
    }

    public DefaultThreadFactory(String s) {
        this(s, false, 5);
    }

    public DefaultThreadFactory(String s, int v) {
        this(s, false, v);
    }

    public DefaultThreadFactory(String s, boolean z) {
        this(s, z, 5);
    }

    public DefaultThreadFactory(String s, boolean z, int v) {
        this(s, z, v, null);
    }

    public DefaultThreadFactory(String s, boolean z, int v, ThreadGroup threadGroup0) {
        this.nextId = new AtomicInteger();
        ObjectUtil.checkNotNull(s, "poolName");
        if(v < 1 || v > 10) {
            throw new IllegalArgumentException("priority: " + v + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.prefix = s + '-' + DefaultThreadFactory.poolId.incrementAndGet() + '-';
        this.daemon = z;
        this.priority = v;
        this.threadGroup = threadGroup0;
    }

    @Override
    public Thread newThread(Runnable runnable0) {
        Thread thread0 = this.newThread(FastThreadLocalRunnable.wrap(runnable0), this.prefix + this.nextId.incrementAndGet());
        try {
            boolean z = this.daemon;
            if(thread0.isDaemon() != z) {
                thread0.setDaemon(z);
            }
            int v = this.priority;
            if(thread0.getPriority() != v) {
                thread0.setPriority(v);
            }
        }
        catch(Exception unused_ex) {
        }
        return thread0;
    }

    public Thread newThread(Runnable runnable0, String s) {
        return new FastThreadLocalThread(this.threadGroup, runnable0, s);
    }

    public static String toPoolName(Class class0) [...] // 潜在的解密器
}

