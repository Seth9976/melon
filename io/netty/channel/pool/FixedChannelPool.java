package io.netty.channel.pool;

import H0.b;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedChannelPool extends SimpleChannelPool {
    class AcquireListener implements FutureListener {
        static final boolean $assertionsDisabled;
        protected boolean acquired;
        private final Promise originalPromise;

        public AcquireListener(Promise promise0) {
            this.originalPromise = promise0;
        }

        public void acquired() {
            if(this.acquired) {
                return;
            }
            FixedChannelPool.this.acquiredChannelCount.incrementAndGet();
            this.acquired = true;
        }

        @Override  // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future future0) {
            try {
                if(FixedChannelPool.this.closed) {
                    if(future0.isSuccess()) {
                        ((Channel)future0.getNow()).close();
                    }
                    IllegalStateException illegalStateException0 = new IllegalStateException("FixedChannelPool was closed");
                    this.originalPromise.setFailure(illegalStateException0);
                    return;
                }
                if(future0.isSuccess()) {
                    Object object0 = future0.getNow();
                    this.originalPromise.setSuccess(object0);
                    return;
                }
                if(this.acquired) {
                    FixedChannelPool.this.decrementAndRunTaskQueue();
                }
                else {
                    FixedChannelPool.this.runTaskQueue();
                }
                Throwable throwable1 = future0.cause();
                this.originalPromise.setFailure(throwable1);
                return;
            }
            catch(Throwable throwable0) {
            }
            this.originalPromise.tryFailure(throwable0);
        }
    }

    final class AcquireTask extends AcquireListener {
        final long expireNanoTime;
        final Promise promise;
        ScheduledFuture timeoutFuture;

        public AcquireTask(Promise promise0) {
            super(promise0);
            this.expireNanoTime = fixedChannelPool0.acquireTimeoutNanos + System.nanoTime();
            this.promise = fixedChannelPool0.executor.newPromise().addListener(this);
        }
    }

    public static enum AcquireTimeoutAction {
        NEW,
        FAIL;

    }

    static final class AcquireTimeoutException extends TimeoutException {
        private AcquireTimeoutException() {
            super("Acquire operation took longer then configured maximum time");
        }

        public AcquireTimeoutException(io.netty.channel.pool.FixedChannelPool.1 fixedChannelPool$10) {
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    abstract class TimeoutTask implements Runnable {
        static final boolean $assertionsDisabled;

        private TimeoutTask() {
        }

        public TimeoutTask(io.netty.channel.pool.FixedChannelPool.1 fixedChannelPool$10) {
        }

        public abstract void onTimeout(AcquireTask arg1);

        @Override
        public final void run() {
            long v = System.nanoTime();
            while(true) {
                AcquireTask fixedChannelPool$AcquireTask0 = (AcquireTask)FixedChannelPool.this.pendingAcquireQueue.peek();
                if(fixedChannelPool$AcquireTask0 == null || v - fixedChannelPool$AcquireTask0.expireNanoTime < 0L) {
                    break;
                }
                FixedChannelPool.this.pendingAcquireQueue.remove();
                FixedChannelPool.access$906(FixedChannelPool.this);
                this.onTimeout(fixedChannelPool$AcquireTask0);
            }
        }
    }

    static final boolean $assertionsDisabled;
    private final long acquireTimeoutNanos;
    private final AtomicInteger acquiredChannelCount;
    private boolean closed;
    private final EventExecutor executor;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private int pendingAcquireCount;
    private final Queue pendingAcquireQueue;
    private final Runnable timeoutTask;

    public FixedChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, int v) {
        this(bootstrap0, channelPoolHandler0, v, 0x7FFFFFFF);
    }

    public FixedChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, int v, int v1) {
        this(bootstrap0, channelPoolHandler0, ChannelHealthChecker.ACTIVE, null, -1L, v, v1);
    }

    public FixedChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0, AcquireTimeoutAction fixedChannelPool$AcquireTimeoutAction0, long v, int v1, int v2) {
        this(bootstrap0, channelPoolHandler0, channelHealthChecker0, fixedChannelPool$AcquireTimeoutAction0, v, v1, v2, true);
    }

    public FixedChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0, AcquireTimeoutAction fixedChannelPool$AcquireTimeoutAction0, long v, int v1, int v2, boolean z) {
        this(bootstrap0, channelPoolHandler0, channelHealthChecker0, fixedChannelPool$AcquireTimeoutAction0, v, v1, v2, z, true);
    }

    public FixedChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0, AcquireTimeoutAction fixedChannelPool$AcquireTimeoutAction0, long v, int v1, int v2, boolean z, boolean z1) {
        super(bootstrap0, channelPoolHandler0, channelHealthChecker0, z, z1);
        this.pendingAcquireQueue = new ArrayDeque();
        this.acquiredChannelCount = new AtomicInteger();
        ObjectUtil.checkPositive(v1, "maxConnections");
        ObjectUtil.checkPositive(v2, "maxPendingAcquires");
        if(fixedChannelPool$AcquireTimeoutAction0 != null || v != -1L) {
            if(fixedChannelPool$AcquireTimeoutAction0 == null && v != -1L) {
                throw new NullPointerException("action");
            }
            if(fixedChannelPool$AcquireTimeoutAction0 != null && v < 0L) {
                throw new IllegalArgumentException(b.g(v, "acquireTimeoutMillis: ", " (expected: >= 0)"));
            }
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(v);
            switch(io.netty.channel.pool.FixedChannelPool.7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[fixedChannelPool$AcquireTimeoutAction0.ordinal()]) {
                case 1: {
                    this.timeoutTask = new TimeoutTask() {
                        {
                            FixedChannelPool.this = fixedChannelPool0;
                            super(null);
                        }

                        @Override  // io.netty.channel.pool.FixedChannelPool$TimeoutTask
                        public void onTimeout(AcquireTask fixedChannelPool$AcquireTask0) {
                            AcquireTimeoutException fixedChannelPool$AcquireTimeoutException0 = new AcquireTimeoutException(null);
                            fixedChannelPool$AcquireTask0.promise.setFailure(fixedChannelPool$AcquireTimeoutException0);
                        }
                    };
                    break;
                }
                case 2: {
                    this.timeoutTask = new TimeoutTask() {
                        {
                            FixedChannelPool.this = fixedChannelPool0;
                            super(null);
                        }

                        @Override  // io.netty.channel.pool.FixedChannelPool$TimeoutTask
                        public void onTimeout(AcquireTask fixedChannelPool$AcquireTask0) {
                            fixedChannelPool$AcquireTask0.acquired();
                            FixedChannelPool.access$201(FixedChannelPool.this, fixedChannelPool$AcquireTask0.promise);
                        }
                    };
                    break;
                }
                default: {
                    throw new Error();
                }
            }
        }
        else {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1L;
        }
        this.executor = bootstrap0.config().group().next();
        this.maxConnections = v1;
        this.maxPendingAcquires = v2;
    }

    public static Future access$201(FixedChannelPool fixedChannelPool0, Promise promise0) {
        return fixedChannelPool0.super.acquire(promise0);
    }

    public static int access$906(FixedChannelPool fixedChannelPool0) {
        int v = fixedChannelPool0.pendingAcquireCount - 1;
        fixedChannelPool0.pendingAcquireCount = v;
        return v;
    }

    @Override  // io.netty.channel.pool.SimpleChannelPool
    public Future acquire(Promise promise0) {
        try {
            if(this.executor.inEventLoop()) {
                this.acquire0(promise0);
                return promise0;
            }
            io.netty.channel.pool.FixedChannelPool.3 fixedChannelPool$30 = () -> {
                try {
                    if(FixedChannelPool.this.closed) {
                        this.val$promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                        return;
                    }
                    if(FixedChannelPool.this.acquiredChannelCount.get() < FixedChannelPool.this.maxConnections) {
                        Promise promise1 = FixedChannelPool.this.executor.newPromise();
                        AcquireListener fixedChannelPool$AcquireListener0 = new AcquireListener(FixedChannelPool.this, this.val$promise);
                        fixedChannelPool$AcquireListener0.acquired();
                        promise1.addListener(fixedChannelPool$AcquireListener0);
                        super.acquire(promise1);
                        return;
                    }
                    if(FixedChannelPool.this.pendingAcquireCount >= FixedChannelPool.this.maxPendingAcquires) {
                        FixedChannelPool.this.tooManyOutstanding(this.val$promise);
                        return;
                    }
                    AcquireTask fixedChannelPool$AcquireTask0 = new AcquireTask(FixedChannelPool.this, this.val$promise);
                    if(FixedChannelPool.this.pendingAcquireQueue.offer(fixedChannelPool$AcquireTask0)) {
                        ++FixedChannelPool.this.pendingAcquireCount;
                        Runnable runnable0 = FixedChannelPool.this.timeoutTask;
                        if(runnable0 != null) {
                            fixedChannelPool$AcquireTask0.timeoutFuture = FixedChannelPool.this.executor.schedule(runnable0, FixedChannelPool.this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
                        }
                        return;
                    }
                    FixedChannelPool.this.tooManyOutstanding(this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$promise.tryFailure(throwable0);
            };
            this.executor.execute(fixedChannelPool$30);
            return promise0;
        }
        catch(Throwable throwable0) {
        }
        promise0.tryFailure(throwable0);
        return promise0;

        class io.netty.channel.pool.FixedChannelPool.3 implements Runnable {
            public io.netty.channel.pool.FixedChannelPool.3(Promise promise0) {
            }

            @Override
            public void run() {
                FixedChannelPool.this.acquire0(this.val$promise);
            }
        }

    }

    // 检测为 Lambda 实现
    private void acquire0(Promise promise0) [...]

    public int acquiredChannelCount() {
        return this.acquiredChannelCount.get();
    }

    @Override  // io.netty.channel.pool.SimpleChannelPool
    public void close() {
        try {
            this.closeAsync().await();
        }
        catch(InterruptedException interruptedException0) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(interruptedException0);
        }
    }

    private Future close0() {
        if(!this.closed) {
            this.closed = true;
            AcquireTask fixedChannelPool$AcquireTask0;
            while((fixedChannelPool$AcquireTask0 = (AcquireTask)this.pendingAcquireQueue.poll()) != null) {
                ScheduledFuture scheduledFuture0 = fixedChannelPool$AcquireTask0.timeoutFuture;
                if(scheduledFuture0 != null) {
                    scheduledFuture0.cancel(false);
                }
                ClosedChannelException closedChannelException0 = new ClosedChannelException();
                fixedChannelPool$AcquireTask0.promise.setFailure(closedChannelException0);
            }
            this.acquiredChannelCount.set(0);
            this.pendingAcquireCount = 0;
            io.netty.channel.pool.FixedChannelPool.6 fixedChannelPool$60 = new Callable() {
                @Override
                public Object call() {
                    return this.call();
                }

                public Void call() {
                    FixedChannelPool.this.super.close();
                    return null;
                }
            };
            return GlobalEventExecutor.INSTANCE.submit(fixedChannelPool$60);
        }
        return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
    }

    @Override  // io.netty.channel.pool.SimpleChannelPool
    public Future closeAsync() {
        if(this.executor.inEventLoop()) {
            return this.close0();
        }
        Future future0 = this.executor.newPromise();
        io.netty.channel.pool.FixedChannelPool.5 fixedChannelPool$50 = new Runnable() {
            @Override
            public void run() {
                FixedChannelPool.this.close0().addListener(new FutureListener() {
                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        if(future0.isSuccess()) {
                            io.netty.channel.pool.FixedChannelPool.5.this.val$closeComplete.setSuccess(null);
                            return;
                        }
                        Throwable throwable0 = future0.cause();
                        io.netty.channel.pool.FixedChannelPool.5.this.val$closeComplete.setFailure(throwable0);
                    }
                });
            }
        };
        this.executor.execute(fixedChannelPool$50);
        return future0;
    }

    private void decrementAndRunTaskQueue() {
        this.acquiredChannelCount.decrementAndGet();
        this.runTaskQueue();
    }

    @Override  // io.netty.channel.pool.SimpleChannelPool
    public Future release(Channel channel0, Promise promise0) {
        ObjectUtil.checkNotNull(promise0, "promise");
        super.release(channel0, this.executor.newPromise().addListener(new FutureListener() {
            static final boolean $assertionsDisabled;

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                try {
                    if(FixedChannelPool.this.closed) {
                        channel0.close();
                        IllegalStateException illegalStateException0 = new IllegalStateException("FixedChannelPool was closed");
                        promise0.setFailure(illegalStateException0);
                        return;
                    }
                    if(future0.isSuccess()) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                        promise0.setSuccess(null);
                        return;
                    }
                    if(!(future0.cause() instanceof IllegalArgumentException)) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                    }
                    Throwable throwable1 = future0.cause();
                    promise0.setFailure(throwable1);
                    return;
                }
                catch(Throwable throwable0) {
                }
                promise0.tryFailure(throwable0);
            }
        }));
        return promise0;
    }

    private void runTaskQueue() {
        while(this.acquiredChannelCount.get() < this.maxConnections) {
            AcquireTask fixedChannelPool$AcquireTask0 = (AcquireTask)this.pendingAcquireQueue.poll();
            if(fixedChannelPool$AcquireTask0 == null) {
                break;
            }
            ScheduledFuture scheduledFuture0 = fixedChannelPool$AcquireTask0.timeoutFuture;
            if(scheduledFuture0 != null) {
                scheduledFuture0.cancel(false);
            }
            --this.pendingAcquireCount;
            fixedChannelPool$AcquireTask0.acquired();
            super.acquire(fixedChannelPool$AcquireTask0.promise);
        }
    }

    private void tooManyOutstanding(Promise promise0) {
        promise0.setFailure(new IllegalStateException("Too many outstanding acquire operations"));
    }

    class io.netty.channel.pool.FixedChannelPool.7 {
        static final int[] $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction;

        static {
            int[] arr_v = new int[AcquireTimeoutAction.values().length];
            io.netty.channel.pool.FixedChannelPool.7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction = arr_v;
            try {
                arr_v[AcquireTimeoutAction.FAIL.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.channel.pool.FixedChannelPool.7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[AcquireTimeoutAction.NEW.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

