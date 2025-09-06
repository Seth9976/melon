package io.netty.util;

import U4.x;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import jeb.synthetic.FIN;
import k8.Y;

public class HashedWheelTimer implements Timer {
    static final class HashedWheelBucket {
        static final boolean $assertionsDisabled;
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;

        private HashedWheelBucket() {
        }

        public HashedWheelBucket(io.netty.util.HashedWheelTimer.1 hashedWheelTimer$10) {
        }

        public void addTimeout(HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0) {
            hashedWheelTimer$HashedWheelTimeout0.bucket = this;
            if(this.head == null) {
                this.tail = hashedWheelTimer$HashedWheelTimeout0;
                this.head = hashedWheelTimer$HashedWheelTimeout0;
                return;
            }
            this.tail.next = hashedWheelTimer$HashedWheelTimeout0;
            hashedWheelTimer$HashedWheelTimeout0.prev = this.tail;
            this.tail = hashedWheelTimer$HashedWheelTimeout0;
        }

        public void clearTimeouts(Set set0) {
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0;
            while((hashedWheelTimer$HashedWheelTimeout0 = this.pollTimeout()) != null) {
                if(!hashedWheelTimer$HashedWheelTimeout0.isExpired() && !hashedWheelTimer$HashedWheelTimeout0.isCancelled()) {
                    set0.add(hashedWheelTimer$HashedWheelTimeout0);
                }
            }
        }

        public void expireTimeouts(long v) {
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0 = this.head;
            while(hashedWheelTimer$HashedWheelTimeout0 != null) {
                HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout1 = hashedWheelTimer$HashedWheelTimeout0.next;
                if(hashedWheelTimer$HashedWheelTimeout0.remainingRounds <= 0L) {
                    hashedWheelTimer$HashedWheelTimeout1 = this.remove(hashedWheelTimer$HashedWheelTimeout0);
                    if(HashedWheelTimeout.access$800(hashedWheelTimer$HashedWheelTimeout0) > v) {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", HashedWheelTimeout.access$800(hashedWheelTimer$HashedWheelTimeout0), v));
                    }
                    hashedWheelTimer$HashedWheelTimeout0.expire();
                }
                else if(hashedWheelTimer$HashedWheelTimeout0.isCancelled()) {
                    hashedWheelTimer$HashedWheelTimeout0 = this.remove(hashedWheelTimer$HashedWheelTimeout0);
                    continue;
                }
                else {
                    --hashedWheelTimer$HashedWheelTimeout0.remainingRounds;
                }
                hashedWheelTimer$HashedWheelTimeout0 = hashedWheelTimer$HashedWheelTimeout1;
            }
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0 = this.head;
            if(hashedWheelTimer$HashedWheelTimeout0 == null) {
                return null;
            }
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout1 = hashedWheelTimer$HashedWheelTimeout0.next;
            if(hashedWheelTimer$HashedWheelTimeout1 == null) {
                this.head = null;
                this.tail = null;
            }
            else {
                this.head = hashedWheelTimer$HashedWheelTimeout1;
                hashedWheelTimer$HashedWheelTimeout1.prev = null;
            }
            hashedWheelTimer$HashedWheelTimeout0.next = null;
            hashedWheelTimer$HashedWheelTimeout0.prev = null;
            hashedWheelTimer$HashedWheelTimeout0.bucket = null;
            return hashedWheelTimer$HashedWheelTimeout0;
        }

        public HashedWheelTimeout remove(HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0) {
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout1 = hashedWheelTimer$HashedWheelTimeout0.next;
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout2 = hashedWheelTimer$HashedWheelTimeout0.prev;
            if(hashedWheelTimer$HashedWheelTimeout2 != null) {
                hashedWheelTimer$HashedWheelTimeout2.next = hashedWheelTimer$HashedWheelTimeout1;
            }
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout3 = hashedWheelTimer$HashedWheelTimeout0.next;
            if(hashedWheelTimer$HashedWheelTimeout3 != null) {
                hashedWheelTimer$HashedWheelTimeout3.prev = hashedWheelTimer$HashedWheelTimeout2;
            }
            if(hashedWheelTimer$HashedWheelTimeout0 != this.head) {
                if(hashedWheelTimer$HashedWheelTimeout0 == this.tail) {
                    this.tail = hashedWheelTimer$HashedWheelTimeout0.prev;
                }
            }
            else if(hashedWheelTimer$HashedWheelTimeout0 == this.tail) {
                this.tail = null;
                this.head = null;
            }
            else {
                this.head = hashedWheelTimer$HashedWheelTimeout1;
            }
            hashedWheelTimer$HashedWheelTimeout0.prev = null;
            hashedWheelTimer$HashedWheelTimeout0.next = null;
            hashedWheelTimer$HashedWheelTimeout0.bucket = null;
            HashedWheelTimeout.access$1300(hashedWheelTimer$HashedWheelTimeout0).pendingTimeouts.decrementAndGet();
            return hashedWheelTimer$HashedWheelTimeout1;
        }
    }

    static final class HashedWheelTimeout implements Timeout, Runnable {
        private static final AtomicIntegerFieldUpdater STATE_UPDATER = null;
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final int ST_INIT;
        HashedWheelBucket bucket;
        private final long deadline;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        long remainingRounds;
        private volatile int state;
        private final TimerTask task;
        private final HashedWheelTimer timer;

        static {
            HashedWheelTimeout.STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
        }

        public HashedWheelTimeout(HashedWheelTimer hashedWheelTimer0, TimerTask timerTask0, long v) {
            this.state = 0;
            this.timer = hashedWheelTimer0;
            this.task = timerTask0;
            this.deadline = v;
        }

        public static HashedWheelTimer access$1300(HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0) {
            return hashedWheelTimer$HashedWheelTimeout0.timer;
        }

        @Override  // io.netty.util.Timeout
        public boolean cancel() {
            if(!this.compareAndSetState(0, 1)) {
                return false;
            }
            this.timer.cancelledTimeouts.add(this);
            return true;
        }

        public boolean compareAndSetState(int v, int v1) {
            return HashedWheelTimeout.STATE_UPDATER.compareAndSet(this, v, v1);
        }

        public void expire() {
            if(this.compareAndSetState(0, 2)) {
                try {
                    this.timer.taskExecutor.execute(this);
                }
                catch(Throwable throwable0) {
                    InternalLogger internalLogger0 = HashedWheelTimer.logger;
                    if(internalLogger0.isWarnEnabled()) {
                        internalLogger0.warn("An exception was thrown while submit TimerTask for execution.", throwable0);
                    }
                }
            }
        }

        @Override  // io.netty.util.Timeout
        public boolean isCancelled() {
            return this.state() == 1;
        }

        @Override  // io.netty.util.Timeout
        public boolean isExpired() {
            return this.state() == 2;
        }

        public void remove() {
            HashedWheelBucket hashedWheelTimer$HashedWheelBucket0 = this.bucket;
            if(hashedWheelTimer$HashedWheelBucket0 != null) {
                hashedWheelTimer$HashedWheelBucket0.remove(this);
                return;
            }
            this.timer.pendingTimeouts.decrementAndGet();
        }

        @Override
        public void run() {
            try {
                this.task.run(this);
            }
            catch(Throwable throwable0) {
                InternalLogger internalLogger0 = HashedWheelTimer.logger;
                if(internalLogger0.isWarnEnabled()) {
                    internalLogger0.warn("An exception was thrown by TimerTask.", throwable0);
                }
            }
        }

        public int state() {
            return this.state;
        }

        @Override  // io.netty.util.Timeout
        public TimerTask task() {
            return this.task;
        }

        @Override  // io.netty.util.Timeout
        public Timer timer() {
            return this.timer;
        }

        @Override
        public String toString() {
            long v = this.timer.startTime + (this.deadline - System.nanoTime());
            StringBuilder stringBuilder0 = new StringBuilder(0xC0);
            stringBuilder0.append(StringUtil.simpleClassName(this));
            stringBuilder0.append("(deadline: ");
            int v1 = Long.compare(v, 0L);
            if(v1 > 0) {
                stringBuilder0.append(v);
                stringBuilder0.append(" ns later");
            }
            else if(v1 < 0) {
                stringBuilder0.append(-v);
                stringBuilder0.append(" ns ago");
            }
            else {
                stringBuilder0.append("now");
            }
            if(this.isCancelled()) {
                stringBuilder0.append(", cancelled");
            }
            stringBuilder0.append(", task: ");
            stringBuilder0.append(this.task());
            stringBuilder0.append(')');
            return stringBuilder0.toString();
        }
    }

    final class Worker implements Runnable {
        private long tick;
        private final Set unprocessedTimeouts;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        public Worker(io.netty.util.HashedWheelTimer.1 hashedWheelTimer$10) {
        }

        private void processCancelledTasks() {
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0;
            while((hashedWheelTimer$HashedWheelTimeout0 = (HashedWheelTimeout)HashedWheelTimer.this.cancelledTimeouts.poll()) != null) {
                try {
                    hashedWheelTimer$HashedWheelTimeout0.remove();
                }
                catch(Throwable throwable0) {
                    if(!HashedWheelTimer.logger.isWarnEnabled()) {
                        continue;
                    }
                    HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", throwable0);
                }
            }
        }

        @Override
        public void run() {
            HashedWheelTimer.this.startTime = System.nanoTime();
            if(Long.compare(HashedWheelTimer.this.startTime, 0L) == 0) {
                HashedWheelTimer.this.startTime = 1L;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long v = this.waitForNextTick();
                if(v > 0L) {
                    int v1 = (int)(this.tick & ((long)HashedWheelTimer.this.mask));
                    this.processCancelledTasks();
                    HashedWheelBucket hashedWheelTimer$HashedWheelBucket0 = HashedWheelTimer.this.wheel[v1];
                    this.transferTimeoutsToBuckets();
                    hashedWheelTimer$HashedWheelBucket0.expireTimeouts(v);
                    ++this.tick;
                }
            }
            while(HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            HashedWheelBucket[] arr_hashedWheelTimer$HashedWheelBucket = HashedWheelTimer.this.wheel;
            for(int v2 = 0; v2 < arr_hashedWheelTimer$HashedWheelBucket.length; ++v2) {
                arr_hashedWheelTimer$HashedWheelBucket[v2].clearTimeouts(this.unprocessedTimeouts);
            }
            HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0;
            while((hashedWheelTimer$HashedWheelTimeout0 = (HashedWheelTimeout)HashedWheelTimer.this.timeouts.poll()) != null) {
                if(!hashedWheelTimer$HashedWheelTimeout0.isCancelled()) {
                    this.unprocessedTimeouts.add(hashedWheelTimer$HashedWheelTimeout0);
                }
            }
            this.processCancelledTasks();
        }

        private void transferTimeoutsToBuckets() {
            for(int v = 0; v < 100000; ++v) {
                HashedWheelTimeout hashedWheelTimer$HashedWheelTimeout0 = (HashedWheelTimeout)HashedWheelTimer.this.timeouts.poll();
                if(hashedWheelTimer$HashedWheelTimeout0 == null) {
                    break;
                }
                if(hashedWheelTimer$HashedWheelTimeout0.state() != 1) {
                    long v1 = hashedWheelTimer$HashedWheelTimeout0.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimer$HashedWheelTimeout0.remainingRounds = (v1 - this.tick) / ((long)HashedWheelTimer.this.wheel.length);
                    HashedWheelTimer.this.wheel[((int)(Math.max(v1, this.tick) & ((long)HashedWheelTimer.this.mask)))].addTimeout(hashedWheelTimer$HashedWheelTimeout0);
                }
            }
        }

        public Set unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }

        private long waitForNextTick() {
            long v = (this.tick + 1L) * HashedWheelTimer.this.tickDuration;
            while(true) {
                long v1 = System.nanoTime() - HashedWheelTimer.this.startTime;
                long v2 = (v - v1 + 0xF423FL) / 1000000L;
                if(Long.compare(v2, 0L) <= 0) {
                    return v1 == 0x8000000000000000L ? 0x8000000000000001L : v1;
                }
                try {
                    Thread.sleep(v2);
                    continue;
                }
                catch(InterruptedException unused_ex) {
                }
                if(HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 2) {
                    break;
                }
            }
            return 0x8000000000000000L;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final AtomicInteger INSTANCE_COUNTER = null;
    private static final int INSTANCE_COUNT_LIMIT = 0x40;
    private static final long MILLISECOND_NANOS = 0L;
    private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES = null;
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    private static final AtomicIntegerFieldUpdater WORKER_STATE_UPDATER;
    private final Queue cancelledTimeouts;
    private final ResourceLeakTracker leak;
    private static final ResourceLeakDetector leakDetector;
    static final InternalLogger logger;
    private final int mask;
    private final long maxPendingTimeouts;
    private final AtomicLong pendingTimeouts;
    private volatile long startTime;
    private final CountDownLatch startTimeInitialized;
    private final Executor taskExecutor;
    private final long tickDuration;
    private final Queue timeouts;
    private final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;

    static {
        HashedWheelTimer.logger = InternalLoggerFactory.getInstance(HashedWheelTimer.class);
        HashedWheelTimer.INSTANCE_COUNTER = new AtomicInteger();
        HashedWheelTimer.WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
        HashedWheelTimer.MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
        HashedWheelTimer.leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1);
        HashedWheelTimer.WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    public HashedWheelTimer(long v, TimeUnit timeUnit0) {
        this(Executors.defaultThreadFactory(), v, timeUnit0);
    }

    public HashedWheelTimer(long v, TimeUnit timeUnit0, int v1) {
        this(Executors.defaultThreadFactory(), v, timeUnit0, v1);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0) {
        this(threadFactory0, 100L, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0, long v, TimeUnit timeUnit0) {
        this(threadFactory0, v, timeUnit0, 0x200);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0, long v, TimeUnit timeUnit0, int v1) {
        this(threadFactory0, v, timeUnit0, v1, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0, long v, TimeUnit timeUnit0, int v1, boolean z) {
        this(threadFactory0, v, timeUnit0, v1, z, -1L);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0, long v, TimeUnit timeUnit0, int v1, boolean z, long v2) {
        this(threadFactory0, v, timeUnit0, v1, z, v2, ImmediateExecutor.INSTANCE);
    }

    public HashedWheelTimer(ThreadFactory threadFactory0, long v, TimeUnit timeUnit0, int v1, boolean z, long v2, Executor executor0) {
        ResourceLeakTracker resourceLeakTracker0 = null;
        Worker hashedWheelTimer$Worker0 = new Worker(this, null);
        this.worker = hashedWheelTimer$Worker0;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        this.pendingTimeouts = new AtomicLong(0L);
        ObjectUtil.checkNotNull(threadFactory0, "threadFactory");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        ObjectUtil.checkPositive(v, "tickDuration");
        ObjectUtil.checkPositive(v1, "ticksPerWheel");
        this.taskExecutor = (Executor)ObjectUtil.checkNotNull(executor0, "taskExecutor");
        HashedWheelBucket[] arr_hashedWheelTimer$HashedWheelBucket = HashedWheelTimer.createWheel(v1);
        this.wheel = arr_hashedWheelTimer$HashedWheelBucket;
        this.mask = arr_hashedWheelTimer$HashedWheelBucket.length - 1;
        long v3 = timeUnit0.toNanos(v);
        if(v3 >= 0x7FFFFFFFFFFFFFFFL / ((long)arr_hashedWheelTimer$HashedWheelBucket.length)) {
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", v, ((long)(0x7FFFFFFFFFFFFFFFL / ((long)arr_hashedWheelTimer$HashedWheelBucket.length)))));
        }
        long v4 = HashedWheelTimer.MILLISECOND_NANOS;
        if(v3 < v4) {
            HashedWheelTimer.logger.warn("Configured tickDuration {} smaller than {}, using 1ms.", v, v4);
            this.tickDuration = v4;
        }
        else {
            this.tickDuration = v3;
        }
        Thread thread0 = threadFactory0.newThread(hashedWheelTimer$Worker0);
        this.workerThread = thread0;
        if(z || !thread0.isDaemon()) {
            resourceLeakTracker0 = HashedWheelTimer.leakDetector.track(this);
        }
        this.leak = resourceLeakTracker0;
        this.maxPendingTimeouts = v2;
        if(HashedWheelTimer.INSTANCE_COUNTER.incrementAndGet() > 0x40 && HashedWheelTimer.WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true)) {
            HashedWheelTimer.reportTooManyInstances();
        }
    }

    private static HashedWheelBucket[] createWheel(int v) {
        ObjectUtil.checkInRange(v, 1, 0x40000000, "ticksPerWheel");
        int v1 = HashedWheelTimer.normalizeTicksPerWheel(v);
        HashedWheelBucket[] arr_hashedWheelTimer$HashedWheelBucket = new HashedWheelBucket[v1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_hashedWheelTimer$HashedWheelBucket[v2] = new HashedWheelBucket(null);
        }
        return arr_hashedWheelTimer$HashedWheelBucket;
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
        }
        finally {
            if(HashedWheelTimer.WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                HashedWheelTimer.INSTANCE_COUNTER.decrementAndGet();
            }
        }
    }

    @Override  // io.netty.util.Timer
    public Timeout newTimeout(TimerTask timerTask0, long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timerTask0, "task");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        long v1 = this.pendingTimeouts.incrementAndGet();
        if(this.maxPendingTimeouts > 0L && v1 > this.maxPendingTimeouts) {
            this.pendingTimeouts.decrementAndGet();
            StringBuilder stringBuilder0 = Y.o(v1, "Number of pending timeouts (", ") is greater than or equal to maximum allowed pending timeouts (");
            throw new RejectedExecutionException(x.h(this.maxPendingTimeouts, ")", stringBuilder0));
        }
        this.start();
        long v2 = timeUnit0.toNanos(v) + System.nanoTime() - this.startTime;
        if(v > 0L && v2 < 0L) {
            v2 = 0x7FFFFFFFFFFFFFFFL;
        }
        Timeout timeout0 = new HashedWheelTimeout(this, timerTask0, v2);
        this.timeouts.add(timeout0);
        return timeout0;
    }

    private static int normalizeTicksPerWheel(int v) {
        int v1;
        for(v1 = 1; v1 < v; v1 <<= 1) {
        }
        return v1;
    }

    public long pendingTimeouts() {
        return this.pendingTimeouts.get();
    }

    // 去混淆评级： 低(37)
    private static void reportTooManyInstances() {
        InternalLogger internalLogger0 = HashedWheelTimer.logger;
        if(internalLogger0.isErrorEnabled()) {
            internalLogger0.error("You are creating too many HashedWheelTimer instances. HashedWheelTimer is a shared resource that must be reused across the JVM, so that only a few instances are created.");
        }
    }

    public void start() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = HashedWheelTimer.WORKER_STATE_UPDATER;
        switch(atomicIntegerFieldUpdater0.get(this)) {
            case 0: {
                if(atomicIntegerFieldUpdater0.compareAndSet(this, 0, 1)) {
                    this.workerThread.start();
                }
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                throw new IllegalStateException("cannot be started once stopped");
            }
            default: {
                throw new Error("Invalid WorkerState");
            }
        }
        while(this.startTime == 0L) {
            try {
                this.startTimeInitialized.await();
            }
            catch(InterruptedException unused_ex) {
            }
        }
    }

    @Override  // io.netty.util.Timer
    public Set stop() {
        int v;
        if(Thread.currentThread() == this.workerThread) {
            throw new IllegalStateException("HashedWheelTimer.stop() cannot be called from TimerTask");
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = HashedWheelTimer.WORKER_STATE_UPDATER;
        if(!atomicIntegerFieldUpdater0.compareAndSet(this, 1, 2)) {
            if(atomicIntegerFieldUpdater0.getAndSet(this, 2) != 2) {
                HashedWheelTimer.INSTANCE_COUNTER.decrementAndGet();
                ResourceLeakTracker resourceLeakTracker0 = this.leak;
                if(resourceLeakTracker0 != null) {
                    resourceLeakTracker0.close(this);
                }
            }
            return Collections.EMPTY_SET;
        }
        boolean z = false;
    alab1:
        while(true) {
            v = FIN.finallyOpen$NT();
            while(true) {
                if(!this.workerThread.isAlive()) {
                    break alab1;
                }
                this.workerThread.interrupt();
                try {
                    this.workerThread.join(100L);
                }
                catch(InterruptedException unused_ex) {
                    z = true;
                    break;
                }
            }
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
        FIN.finallyCodeBegin$NT(v);
        HashedWheelTimer.INSTANCE_COUNTER.decrementAndGet();
        ResourceLeakTracker resourceLeakTracker1 = this.leak;
        if(resourceLeakTracker1 != null) {
            resourceLeakTracker1.close(this);
        }
        FIN.finallyCodeEnd$NT(v);
        return this.worker.unprocessedTimeouts();
    }

    class io.netty.util.HashedWheelTimer.1 {
    }

}

