package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
public final class ThreadDeathWatcher {
    static final class Entry {
        final boolean isWatch;
        final Runnable task;
        final Thread thread;

        public Entry(Thread thread0, Runnable runnable0, boolean z) {
            this.thread = thread0;
            this.task = runnable0;
            this.isWatch = z;
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            return object0 instanceof Entry ? this.thread == ((Entry)object0).thread && this.task == ((Entry)object0).task : false;
        }

        @Override
        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }
    }

    static final class Watcher implements Runnable {
        static final boolean $assertionsDisabled;
        private final List watchees;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        public Watcher(io.netty.util.ThreadDeathWatcher.1 threadDeathWatcher$10) {
        }

        private void fetchWatchees() {
            Entry threadDeathWatcher$Entry0;
            while((threadDeathWatcher$Entry0 = (Entry)ThreadDeathWatcher.pendingEntries.poll()) != null) {
                if(threadDeathWatcher$Entry0.isWatch) {
                    this.watchees.add(threadDeathWatcher$Entry0);
                }
                else {
                    this.watchees.remove(threadDeathWatcher$Entry0);
                }
            }
        }

        private void notifyWatchees() {
            List list0 = this.watchees;
            int v = 0;
            while(v < list0.size()) {
                Entry threadDeathWatcher$Entry0 = (Entry)list0.get(v);
                if(threadDeathWatcher$Entry0.thread.isAlive()) {
                    ++v;
                }
                else {
                    list0.remove(v);
                    try {
                        threadDeathWatcher$Entry0.task.run();
                    }
                    catch(Throwable throwable0) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", throwable0);
                    }
                }
            }
        }

        @Override
        public void run() {
            do {
                do {
                    this.fetchWatchees();
                    this.notifyWatchees();
                    this.fetchWatchees();
                    this.notifyWatchees();
                    try {
                        Thread.sleep(1000L);
                    }
                    catch(InterruptedException unused_ex) {
                    }
                }
                while(!this.watchees.isEmpty() || !ThreadDeathWatcher.pendingEntries.isEmpty());
                ThreadDeathWatcher.started.compareAndSet(true, false);
            }
            while(!ThreadDeathWatcher.pendingEntries.isEmpty() && ThreadDeathWatcher.started.compareAndSet(false, true));
        }
    }

    private static final InternalLogger logger;
    private static final Queue pendingEntries;
    private static final AtomicBoolean started;
    static final ThreadFactory threadFactory;
    private static final Watcher watcher;
    private static volatile Thread watcherThread;

    static {
        ThreadDeathWatcher.logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
        ThreadDeathWatcher.pendingEntries = new ConcurrentLinkedQueue();
        ThreadDeathWatcher.watcher = new Watcher(null);
        ThreadDeathWatcher.started = new AtomicBoolean();
        StringUtil.isNullOrEmpty(SystemPropertyUtil.get("io.netty.serviceThreadPrefix"));
        ThreadDeathWatcher.threadFactory = new DefaultThreadFactory("threadDeathWatcher", true, 1, null);
    }

    public static boolean awaitInactivity(long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        Thread thread0 = ThreadDeathWatcher.watcherThread;
        if(thread0 != null) {
            thread0.join(timeUnit0.toMillis(v));
            return !thread0.isAlive();
        }
        return true;
    }

    private static void schedule(Thread thread0, Runnable runnable0, boolean z) {
        Entry threadDeathWatcher$Entry0 = new Entry(thread0, runnable0, z);
        ThreadDeathWatcher.pendingEntries.add(threadDeathWatcher$Entry0);
        if(ThreadDeathWatcher.started.compareAndSet(false, true)) {
            Thread thread1 = ThreadDeathWatcher.threadFactory.newThread(ThreadDeathWatcher.watcher);
            AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    thread1.setContextClassLoader(null);
                    return null;
                }
            });
            thread1.start();
            ThreadDeathWatcher.watcherThread = thread1;
        }
    }

    public static void unwatch(Thread thread0, Runnable runnable0) {
        ThreadDeathWatcher.schedule(((Thread)ObjectUtil.checkNotNull(thread0, "thread")), ((Runnable)ObjectUtil.checkNotNull(runnable0, "task")), false);
    }

    public static void watch(Thread thread0, Runnable runnable0) {
        ObjectUtil.checkNotNull(thread0, "thread");
        ObjectUtil.checkNotNull(runnable0, "task");
        if(!thread0.isAlive()) {
            throw new IllegalArgumentException("thread must be alive.");
        }
        ThreadDeathWatcher.schedule(thread0, runnable0, true);
    }
}

