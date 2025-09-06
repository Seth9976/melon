package io.netty.util.concurrent;

import U4.x;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k8.Y;
import org.jetbrains.annotations.Async.Schedule;

public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final class DefaultThreadProperties implements ThreadProperties {
        private final Thread t;

        public DefaultThreadProperties(Thread thread0) {
            this.t = thread0;
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public long id() {
            return this.t.getId();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.t.isAlive();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.t.isDaemon();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.t.isInterrupted();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.t.getName();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.t.getPriority();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.t.getStackTrace();
        }

        @Override  // io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.t.getState();
        }
    }

    @Deprecated
    public interface NonWakeupRunnable extends LazyRunnable {
    }

    static final boolean $assertionsDisabled = false;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = 0;
    private static final Runnable NOOP_TASK = null;
    private static final AtomicReferenceFieldUpdater PROPERTIES_UPDATER = null;
    private static final long SCHEDULE_PURGE_INTERVAL = 0L;
    private static final AtomicIntegerFieldUpdater STATE_UPDATER = null;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private static final InternalLogger logger;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private final Set shutdownHooks;
    private volatile int state;
    private final Queue taskQueue;
    private final Promise terminationFuture;
    private volatile Thread thread;
    private final CountDownLatch threadLock;
    private volatile ThreadProperties threadProperties;

    static {
        SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", 0x7FFFFFFF));
        SingleThreadEventExecutor.logger = InternalLoggerFactory.getInstance(SingleThreadEventExecutor.class);
        SingleThreadEventExecutor.NOOP_TASK = new Runnable() {
            @Override
            public void run() {
            }
        };
        SingleThreadEventExecutor.STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
        SingleThreadEventExecutor.PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
        SingleThreadEventExecutor.SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup0, Executor executor0, boolean z) {
        this(eventExecutorGroup0, executor0, z, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup0, Executor executor0, boolean z, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventExecutorGroup0);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        int v1 = Math.max(16, v);
        this.maxPendingTasks = v1;
        this.executor = ThreadExecutorMap.apply(executor0, this);
        this.taskQueue = this.newTaskQueue(v1);
        this.rejectedExecutionHandler = (RejectedExecutionHandler)ObjectUtil.checkNotNull(rejectedExecutionHandler0, "rejectedHandler");
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup0, Executor executor0, boolean z, Queue queue0, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventExecutorGroup0);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        this.maxPendingTasks = SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor0, this);
        this.taskQueue = (Queue)ObjectUtil.checkNotNull(queue0, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler)ObjectUtil.checkNotNull(rejectedExecutionHandler0, "rejectedHandler");
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup0, ThreadFactory threadFactory0, boolean z) {
        this(eventExecutorGroup0, new ThreadPerTaskExecutor(threadFactory0), z);
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup0, ThreadFactory threadFactory0, boolean z, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        this(eventExecutorGroup0, new ThreadPerTaskExecutor(threadFactory0), z, v, rejectedExecutionHandler0);
    }

    public void addShutdownHook(Runnable runnable0) {
        if(this.inEventLoop()) {
            this.shutdownHooks.add(runnable0);
            return;
        }
        this.execute(new Runnable() {
            @Override
            public void run() {
                SingleThreadEventExecutor.this.shutdownHooks.add(runnable0);
            }
        });
    }

    public void addTask(Runnable runnable0) {
        ObjectUtil.checkNotNull(runnable0, "task");
        if(!this.offerTask(runnable0)) {
            this.reject(runnable0);
        }
    }

    public void afterRunningAllTasks() {
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(this.inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        this.threadLock.await(v, timeUnit0);
        return this.isTerminated();
    }

    public void cleanup() {
    }

    public boolean confirmShutdown() {
        if(!this.isShuttingDown()) {
            return false;
        }
        if(!this.inEventLoop()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        this.cancelScheduledTasks();
        if(this.gracefulShutdownStartTime == 0L) {
            this.gracefulShutdownStartTime = this.getCurrentTimeNanos();
        }
        if(!this.runAllTasks() && !this.runShutdownHooks()) {
            long v = this.getCurrentTimeNanos();
            if(!this.isShutdown() && v - this.gracefulShutdownStartTime <= this.gracefulShutdownTimeout && v - this.lastExecutionTime <= this.gracefulShutdownQuietPeriod) {
                this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                try {
                    Thread.sleep(100L);
                }
                catch(InterruptedException unused_ex) {
                }
                return false;
            }
            return true;
        }
        if(this.isShutdown()) {
            return true;
        }
        if(this.gracefulShutdownQuietPeriod == 0L) {
            return true;
        }
        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
        return false;
    }

    public long deadlineNanos() {
        ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
        return scheduledFutureTask0 == null ? this.getCurrentTimeNanos() + SingleThreadEventExecutor.SCHEDULE_PURGE_INTERVAL : scheduledFutureTask0.deadlineNanos();
    }

    public long delayNanos(long v) {
        ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
        return scheduledFutureTask0 == null ? SingleThreadEventExecutor.SCHEDULE_PURGE_INTERVAL : scheduledFutureTask0.delayNanos(v - 0xDC362DB29F4L);
    }

    private void doStartThread() {
        io.netty.util.concurrent.SingleThreadEventExecutor.4 singleThreadEventExecutor$40 = new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder0;
                InternalLogger internalLogger0;
                int v10;
                SingleThreadEventExecutor.this.thread = Thread.currentThread();
                if(SingleThreadEventExecutor.this.interrupted) {
                    SingleThreadEventExecutor.this.thread.interrupt();
                }
                SingleThreadEventExecutor.this.updateLastExecutionTime();
                try {
                    SingleThreadEventExecutor.this.run();
                }
                catch(Throwable throwable0) {
                    try {
                        SingleThreadEventExecutor.logger.warn("Unexpected exception from an event executor: ", throwable0);
                    }
                    catch(Throwable throwable1) {
                        do {
                            int v = SingleThreadEventExecutor.this.state;
                        }
                        while(v < 3 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v, 3));
                        try {
                            while(!SingleThreadEventExecutor.this.confirmShutdown()) {
                            }
                            do {
                                int v2 = SingleThreadEventExecutor.this.state;
                            }
                            while(v2 < 4 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v2, 4));
                            SingleThreadEventExecutor.this.confirmShutdown();
                        }
                        finally {
                            try {
                                SingleThreadEventExecutor.this.cleanup();
                            }
                            finally {
                                FastThreadLocal.removeAll();
                                SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                SingleThreadEventExecutor.this.threadLock.countDown();
                                int v4 = SingleThreadEventExecutor.this.drainTasks();
                                if(v4 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                    SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + v4 + ')');
                                }
                                SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                            }
                        }
                        throw throwable1;
                    }
                    do {
                        int v5 = SingleThreadEventExecutor.this.state;
                    }
                    while(v5 < 3 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v5, 3));
                    try {
                        while(!SingleThreadEventExecutor.this.confirmShutdown()) {
                        }
                        do {
                            int v6 = SingleThreadEventExecutor.this.state;
                        }
                        while(v6 < 4 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v6, 4));
                        SingleThreadEventExecutor.this.confirmShutdown();
                        goto label_53;
                    }
                    catch(Throwable throwable2) {
                    }
                    try {
                        SingleThreadEventExecutor.this.cleanup();
                    }
                    finally {
                        FastThreadLocal.removeAll();
                        SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                        SingleThreadEventExecutor.this.threadLock.countDown();
                        int v8 = SingleThreadEventExecutor.this.drainTasks();
                        if(v8 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                            SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + v8 + ')');
                        }
                        SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                    }
                    throw throwable2;
                    try {
                    label_53:
                        SingleThreadEventExecutor.this.cleanup();
                    }
                    catch(Throwable throwable3) {
                        FastThreadLocal.removeAll();
                        SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                        SingleThreadEventExecutor.this.threadLock.countDown();
                        int v9 = SingleThreadEventExecutor.this.drainTasks();
                        if(v9 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                            SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + v9 + ')');
                        }
                        SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                        throw throwable3;
                    }
                    FastThreadLocal.removeAll();
                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                    SingleThreadEventExecutor.this.threadLock.countDown();
                    v10 = SingleThreadEventExecutor.this.drainTasks();
                    if(v10 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                        internalLogger0 = SingleThreadEventExecutor.logger;
                        stringBuilder0 = new StringBuilder("An event executor terminated with non-empty task queue (");
                        goto label_113;
                    }
                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                    return;
                }
                do {
                    int v11 = SingleThreadEventExecutor.this.state;
                }
                while(v11 < 3 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v11, 3));
                if(SingleThreadEventExecutor.this.gracefulShutdownStartTime == 0L && SingleThreadEventExecutor.logger.isErrorEnabled()) {
                    SingleThreadEventExecutor.logger.error("Buggy EventExecutor implementation; SingleThreadEventExecutor.confirmShutdown() must be called before run() implementation terminates.");
                }
                try {
                    while(!SingleThreadEventExecutor.this.confirmShutdown()) {
                    }
                    do {
                        int v12 = SingleThreadEventExecutor.this.state;
                    }
                    while(v12 < 4 && !SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, v12, 4));
                    SingleThreadEventExecutor.this.confirmShutdown();
                    goto label_95;
                }
                catch(Throwable throwable4) {
                }
                try {
                    SingleThreadEventExecutor.this.cleanup();
                }
                finally {
                    FastThreadLocal.removeAll();
                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                    SingleThreadEventExecutor.this.threadLock.countDown();
                    int v14 = SingleThreadEventExecutor.this.drainTasks();
                    if(v14 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + v14 + ')');
                    }
                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                }
                throw throwable4;
                try {
                label_95:
                    SingleThreadEventExecutor.this.cleanup();
                }
                catch(Throwable throwable5) {
                    FastThreadLocal.removeAll();
                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                    SingleThreadEventExecutor.this.threadLock.countDown();
                    int v15 = SingleThreadEventExecutor.this.drainTasks();
                    if(v15 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + v15 + ')');
                    }
                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                    throw throwable5;
                }
                FastThreadLocal.removeAll();
                SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                SingleThreadEventExecutor.this.threadLock.countDown();
                v10 = SingleThreadEventExecutor.this.drainTasks();
                if(v10 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                    internalLogger0 = SingleThreadEventExecutor.logger;
                    stringBuilder0 = new StringBuilder("An event executor terminated with non-empty task queue (");
                label_113:
                    stringBuilder0.append(v10);
                    stringBuilder0.append(')');
                    internalLogger0.warn(stringBuilder0.toString());
                }
                SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
            }
        };
        this.executor.execute(singleThreadEventExecutor$40);
    }

    public final int drainTasks() {
        int v = 0;
        Runnable runnable0;
        while((runnable0 = (Runnable)this.taskQueue.poll()) != null) {
            if(AbstractScheduledEventExecutor.WAKEUP_TASK != runnable0) {
                ++v;
            }
        }
        return v;
    }

    private boolean ensureThreadStarted(int v) {
        if(v == 1) {
            try {
                this.doStartThread();
                return false;
            }
            catch(Throwable throwable0) {
                SingleThreadEventExecutor.STATE_UPDATER.set(this, 5);
                this.terminationFuture.tryFailure(throwable0);
                if(!(throwable0 instanceof Exception)) {
                    PlatformDependent.throwException(throwable0);
                }
                return true;
            }
        }
        return false;
    }

    private void execute(Runnable runnable0, boolean z) {
        boolean z1 = this.inEventLoop();
        this.addTask(runnable0);
        if(!z1) {
            this.startThread();
            if(this.isShutdown()) {
                try {
                    boolean z2 = false;
                    z2 = this.removeTask(runnable0);
                }
                catch(UnsupportedOperationException unused_ex) {
                }
                if(z2) {
                    SingleThreadEventExecutor.reject();
                }
            }
        }
        if(!this.addTaskWakesUp && z) {
            this.wakeup(z1);
        }
    }

    @Override
    public void execute(Runnable runnable0) {
        this.execute0(runnable0);
    }

    private void execute0(@Schedule Runnable runnable0) {
        ObjectUtil.checkNotNull(runnable0, "task");
        this.execute(runnable0, true);
    }

    private boolean executeExpiredScheduledTasks() {
        if(this.scheduledTaskQueue != null && !this.scheduledTaskQueue.isEmpty()) {
            long v = this.getCurrentTimeNanos();
            Runnable runnable0 = this.pollScheduledTask(v);
            if(runnable0 == null) {
                return false;
            }
            do {
                AbstractEventExecutor.safeExecute(runnable0);
                runnable0 = this.pollScheduledTask(v);
            }
            while(runnable0 != null);
            return true;
        }
        return false;
    }

    private boolean fetchFromScheduledTaskQueue() {
        Runnable runnable0;
        if(this.scheduledTaskQueue != null && !this.scheduledTaskQueue.isEmpty()) {
            long v = this.getCurrentTimeNanos();
            do {
                runnable0 = this.pollScheduledTask(v);
                if(runnable0 == null) {
                    return true;
                }
            }
            while(this.taskQueue.offer(runnable0));
            this.scheduledTaskQueue.add(((ScheduledFutureTask)runnable0));
            return false;
        }
        return true;
    }

    public boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread0) {
        return thread0 == this.thread;
    }

    public void interruptThread() {
        Thread thread0 = this.thread;
        if(thread0 == null) {
            this.interrupted = true;
            return;
        }
        thread0.interrupt();
    }

    @Override
    public List invokeAll(Collection collection0) {
        this.throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection0);
    }

    @Override
    public List invokeAll(Collection collection0, long v, TimeUnit timeUnit0) {
        this.throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection0, v, timeUnit0);
    }

    @Override
    public Object invokeAny(Collection collection0) {
        this.throwIfInEventLoop("invokeAny");
        return super.invokeAny(collection0);
    }

    @Override
    public Object invokeAny(Collection collection0, long v, TimeUnit timeUnit0) {
        this.throwIfInEventLoop("invokeAny");
        return super.invokeAny(collection0, v, timeUnit0);
    }

    @Override
    public boolean isShutdown() {
        return this.state >= 4;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override
    public boolean isTerminated() {
        return this.state == 5;
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public void lazyExecute(Runnable runnable0) {
        this.lazyExecute0(runnable0);
    }

    private void lazyExecute0(@Schedule Runnable runnable0) {
        this.execute(((Runnable)ObjectUtil.checkNotNull(runnable0, "task")), false);
    }

    @Deprecated
    public Queue newTaskQueue() {
        return this.newTaskQueue(this.maxPendingTasks);
    }

    public Queue newTaskQueue(int v) {
        return new LinkedBlockingQueue(v);
    }

    public final boolean offerTask(Runnable runnable0) {
        if(this.isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        return this.taskQueue.offer(runnable0);
    }

    public Runnable peekTask() {
        return (Runnable)this.taskQueue.peek();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    public Runnable pollTask() {
        return SingleThreadEventExecutor.pollTaskFrom(this.taskQueue);
    }

    public static Runnable pollTaskFrom(Queue queue0) {
        Runnable runnable0;
        do {
            runnable0 = (Runnable)queue0.poll();
        }
        while(runnable0 == AbstractScheduledEventExecutor.WAKEUP_TASK);
        return runnable0;
    }

    public static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    public final void reject(Runnable runnable0) {
        this.rejectedExecutionHandler.rejected(runnable0, this);
    }

    public void removeShutdownHook(Runnable runnable0) {
        if(this.inEventLoop()) {
            this.shutdownHooks.remove(runnable0);
            return;
        }
        this.execute(new Runnable() {
            @Override
            public void run() {
                SingleThreadEventExecutor.this.shutdownHooks.remove(runnable0);
            }
        });
    }

    public boolean removeTask(Runnable runnable0) {
        Object object0 = ObjectUtil.checkNotNull(runnable0, "task");
        return this.taskQueue.remove(object0);
    }

    public abstract void run();

    public boolean runAllTasks() {
        boolean z = false;
        do {
            boolean z1 = this.fetchFromScheduledTaskQueue();
            if(this.runAllTasksFrom(this.taskQueue)) {
                z = true;
            }
        }
        while(!z1);
        if(z) {
            this.lastExecutionTime = this.getCurrentTimeNanos();
        }
        this.afterRunningAllTasks();
        return z;
    }

    public boolean runAllTasks(long v) {
        long v4;
        this.fetchFromScheduledTaskQueue();
        Runnable runnable0 = this.pollTask();
        if(runnable0 == null) {
            this.afterRunningAllTasks();
            return false;
        }
        long v1 = v <= 0L ? 0L : this.getCurrentTimeNanos() + v;
        long v2 = 0L;
        while(true) {
            AbstractEventExecutor.safeExecute(runnable0);
            ++v2;
            if((0x3FL & v2) == 0L) {
                long v3 = this.getCurrentTimeNanos();
                if(v3 >= v1) {
                    v4 = v3;
                    break;
                }
            }
            runnable0 = this.pollTask();
            if(runnable0 == null) {
                v4 = this.getCurrentTimeNanos();
                break;
            }
        }
        this.afterRunningAllTasks();
        this.lastExecutionTime = v4;
        return true;
    }

    public final boolean runAllTasksFrom(Queue queue0) {
        Runnable runnable0 = SingleThreadEventExecutor.pollTaskFrom(queue0);
        if(runnable0 == null) {
            return false;
        }
        do {
            AbstractEventExecutor.safeExecute(runnable0);
            runnable0 = SingleThreadEventExecutor.pollTaskFrom(queue0);
        }
        while(runnable0 != null);
        return true;
    }

    private boolean runExistingTasksFrom(Queue queue0) {
        Runnable runnable0 = SingleThreadEventExecutor.pollTaskFrom(queue0);
        if(runnable0 == null) {
            return false;
        }
        int v = Math.min(this.maxPendingTasks, queue0.size());
        AbstractEventExecutor.safeExecute(runnable0);
        while(v > 0) {
            Runnable runnable1 = (Runnable)queue0.poll();
            if(runnable1 == null) {
                break;
            }
            AbstractEventExecutor.safeExecute(runnable1);
            --v;
        }
        return true;
    }

    public final boolean runScheduledAndExecutorTasks(int v) {
        int v1 = 0;
        while((this.runExistingTasksFrom(this.taskQueue) | this.executeExpiredScheduledTasks()) != 0) {
            ++v1;
            if(v1 >= v) {
                break;
            }
        }
        if(v1 > 0) {
            this.lastExecutionTime = this.getCurrentTimeNanos();
        }
        this.afterRunningAllTasks();
        return v1 > 0;
    }

    private boolean runShutdownHooks() {
        boolean z = false;
        while(!this.shutdownHooks.isEmpty()) {
            ArrayList arrayList0 = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            for(Object object0: arrayList0) {
                Runnable runnable0 = (Runnable)object0;
                try {
                    AbstractEventExecutor.runTask(runnable0);
                }
                catch(Throwable throwable0) {
                    SingleThreadEventExecutor.logger.warn("Shutdown hook raised an exception.", throwable0);
                }
                z = true;
            }
        }
        if(z) {
            this.lastExecutionTime = this.getCurrentTimeNanos();
        }
        return z;
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        if(!this.isShutdown()) {
            boolean z = this.inEventLoop();
            while(!this.isShuttingDown()) {
                int v = this.state;
                int v1 = 4;
                boolean z1 = true;
                if(!z && (v != 1 && v != 2 && v != 3)) {
                    z1 = false;
                    v1 = v;
                }
                if(SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(this, v, v1)) {
                    if(this.ensureThreadStarted(v) || !z1) {
                        break;
                    }
                    this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                    if(this.addTaskWakesUp) {
                        break;
                    }
                    this.wakeup(z);
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        ObjectUtil.checkPositiveOrZero(v, "quietPeriod");
        if(v1 < v) {
            throw new IllegalArgumentException(x.h(v, "))", Y.o(v1, "timeout: ", " (expected >= quietPeriod (")));
        }
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(this.isShuttingDown()) {
            return this.terminationFuture();
        }
        boolean z = this.inEventLoop();
        do {
            if(this.isShuttingDown()) {
                return this.terminationFuture();
            }
            int v2 = this.state;
            int v3 = 3;
            boolean z1 = true;
            if(!z && v2 != 1 && v2 != 2) {
                z1 = false;
                v3 = v2;
            }
        }
        while(!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(this, v2, v3));
        this.gracefulShutdownQuietPeriod = timeUnit0.toNanos(v);
        this.gracefulShutdownTimeout = timeUnit0.toNanos(v1);
        if(this.ensureThreadStarted(v2)) {
            return this.terminationFuture;
        }
        if(z1) {
            this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
            if(!this.addTaskWakesUp) {
                this.wakeup(z);
            }
        }
        return this.terminationFuture();
    }

    private void startThread() {
        if(this.state == 1 && SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                this.doStartThread();
            }
            catch(Throwable throwable0) {
                SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(this, 2, 1);
                throw throwable0;
            }
        }
    }

    public Runnable takeTask() {
        Runnable runnable0;
        Queue queue0 = this.taskQueue;
        if(!(queue0 instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue0 = (BlockingQueue)queue0;
        do {
            ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
            runnable0 = null;
            if(scheduledFutureTask0 == null) {
                try {
                    Runnable runnable1 = (Runnable)blockingQueue0.take();
                    return runnable1 == AbstractScheduledEventExecutor.WAKEUP_TASK ? null : runnable1;
                }
                catch(InterruptedException unused_ex) {
                    return null;
                }
            }
            long v = scheduledFutureTask0.delayNanos();
            if(v > 0L) {
                try {
                    runnable0 = (Runnable)blockingQueue0.poll(v, TimeUnit.NANOSECONDS);
                }
                catch(InterruptedException unused_ex) {
                    return null;
                }
            }
            if(runnable0 == null) {
                this.fetchFromScheduledTaskQueue();
                runnable0 = (Runnable)blockingQueue0.poll();
            }
        }
        while(runnable0 == null);
        return runnable0;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties0 = this.threadProperties;
        if(threadProperties0 == null) {
            Thread thread0 = this.thread;
            if(thread0 == null) {
                this.submit(SingleThreadEventExecutor.NOOP_TASK).syncUninterruptibly();
                thread0 = this.thread;
            }
            ThreadProperties threadProperties1 = new DefaultThreadProperties(thread0);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SingleThreadEventExecutor.PROPERTIES_UPDATER;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, null, threadProperties1)) {
                    return threadProperties1;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == null);
            return this.threadProperties;
        }
        return threadProperties0;
    }

    private void throwIfInEventLoop(String s) {
        if(this.inEventLoop()) {
            throw new RejectedExecutionException("Calling " + s + " from within the EventLoop is not allowed");
        }
    }

    public void updateLastExecutionTime() {
        this.lastExecutionTime = this.getCurrentTimeNanos();
    }

    public boolean wakesUpForTask(Runnable runnable0) [...] // Inlined contents

    public void wakeup(boolean z) {
        if(!z) {
            this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
        }
    }
}

