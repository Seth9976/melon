package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObjectCleaner {
    static final class AutomaticCleanerReference extends WeakReference {
        private final Runnable cleanupTask;

        public AutomaticCleanerReference(Object object0, Runnable runnable0) {
            super(object0, ObjectCleaner.REFERENCE_QUEUE);
            this.cleanupTask = runnable0;
        }

        public void cleanup() {
            this.cleanupTask.run();
        }

        @Override
        public void clear() {
            ObjectCleaner.LIVE_SET.remove(this);
            super.clear();
        }

        @Override
        public Object get() {
            return null;
        }

        public Thread get() [...] // Inlined contents
    }

    private static final AtomicBoolean CLEANER_RUNNING;
    private static final Runnable CLEANER_TASK;
    static final String CLEANER_THREAD_NAME;
    private static final Set LIVE_SET;
    private static final ReferenceQueue REFERENCE_QUEUE;
    private static final int REFERENCE_QUEUE_POLL_TIMEOUT_MS;

    static {
        ObjectCleaner.REFERENCE_QUEUE_POLL_TIMEOUT_MS = Math.max(500, SystemPropertyUtil.getInt("io.netty.util.internal.ObjectCleaner.refQueuePollTimeout", 10000));
        ObjectCleaner.CLEANER_THREAD_NAME = "ObjectCleanerThread";
        ObjectCleaner.LIVE_SET = new ConcurrentSet();
        ObjectCleaner.REFERENCE_QUEUE = new ReferenceQueue();
        ObjectCleaner.CLEANER_RUNNING = new AtomicBoolean(false);
        ObjectCleaner.CLEANER_TASK = new Runnable() {
            @Override
            public void run() {
                AutomaticCleanerReference objectCleaner$AutomaticCleanerReference0;
                boolean z = false;
                while(true) {
                    if(ObjectCleaner.LIVE_SET.isEmpty()) {
                        ObjectCleaner.CLEANER_RUNNING.set(false);
                        if(ObjectCleaner.LIVE_SET.isEmpty() || !ObjectCleaner.CLEANER_RUNNING.compareAndSet(false, true)) {
                            break;
                        }
                    }
                    else {
                        try {
                            objectCleaner$AutomaticCleanerReference0 = (AutomaticCleanerReference)ObjectCleaner.REFERENCE_QUEUE.remove(0L);
                            if(objectCleaner$AutomaticCleanerReference0 == null) {
                                continue;
                            }
                        }
                        catch(InterruptedException unused_ex) {
                            z = true;
                            continue;
                        }
                        try {
                            objectCleaner$AutomaticCleanerReference0.cleanup();
                        }
                        catch(Throwable unused_ex) {
                        }
                        ObjectCleaner.LIVE_SET.remove(objectCleaner$AutomaticCleanerReference0);
                    }
                }
                if(z) {
                    Thread.currentThread().interrupt();
                }
            }
        };
    }

    public static int access$100() [...] // 潜在的解密器

    public static int getLiveSetCount() {
        return ObjectCleaner.LIVE_SET.size();
    }

    public static void register(Object object0, Runnable runnable0) {
        AutomaticCleanerReference objectCleaner$AutomaticCleanerReference0 = new AutomaticCleanerReference(object0, ((Runnable)ObjectUtil.checkNotNull(runnable0, "cleanupTask")));
        ObjectCleaner.LIVE_SET.add(objectCleaner$AutomaticCleanerReference0);
        if(ObjectCleaner.CLEANER_RUNNING.compareAndSet(false, true)) {
            FastThreadLocalThread fastThreadLocalThread0 = new FastThreadLocalThread(ObjectCleaner.CLEANER_TASK);
            fastThreadLocalThread0.setPriority(1);
            AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    fastThreadLocalThread0.setContextClassLoader(null);
                    return null;
                }
            });
            fastThreadLocalThread0.setName(ObjectCleaner.CLEANER_THREAD_NAME);
            fastThreadLocalThread0.setDaemon(true);
            fastThreadLocalThread0.start();
        }
    }
}

