package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultPromise extends AbstractFuture implements Promise {
    static final class CauseHolder {
        final Throwable cause;

        public CauseHolder(Throwable throwable0) {
            this.cause = throwable0;
        }
    }

    static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 0x26C8AE144C0240DFL;

        private LeanCancellationException() {
        }

        public LeanCancellationException(io.netty.util.concurrent.DefaultPromise.1 defaultPromise$10) {
        }

        @Override
        public Throwable fillInStackTrace() {
            this.setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }

        // 去混淆评级： 低(20)
        @Override
        public String toString() {
            return "java.util.concurrent.CancellationException";
        }
    }

    static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = 0xD6B7021B92428B21L;

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }

        public static StacklessCancellationException newInstance(Class class0, String s) {
            return (StacklessCancellationException)ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), class0, s);
        }
    }

    static final boolean $assertionsDisabled;
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    private static final StackTraceElement[] CANCELLATION_STACK;
    private static final int MAX_LISTENER_STACK_DEPTH;
    private static final AtomicReferenceFieldUpdater RESULT_UPDATER;
    private static final Object SUCCESS;
    private static final Object UNCANCELLABLE;
    private final EventExecutor executor;
    private GenericFutureListener listener;
    private DefaultFutureListeners listeners;
    private static final InternalLogger logger;
    private boolean notifyingListeners;
    private static final InternalLogger rejectedExecutionLogger;
    private volatile Object result;
    private short waiters;

    static {
        DefaultPromise.logger = InternalLoggerFactory.getInstance(DefaultPromise.class);
        DefaultPromise.rejectedExecutionLogger = InternalLoggerFactory.getInstance("io.netty.util.concurrent.DefaultPromise.rejectedExecution");
        DefaultPromise.MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
        DefaultPromise.RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
        DefaultPromise.SUCCESS = new Object();
        DefaultPromise.UNCANCELLABLE = new Object();
        CauseHolder defaultPromise$CauseHolder0 = new CauseHolder(StacklessCancellationException.newInstance(DefaultPromise.class, "cancel(...)"));
        DefaultPromise.CANCELLATION_CAUSE_HOLDER = defaultPromise$CauseHolder0;
        DefaultPromise.CANCELLATION_STACK = defaultPromise$CauseHolder0.cause.getStackTrace();
    }

    public DefaultPromise() {
        this.executor = null;
    }

    public DefaultPromise(EventExecutor eventExecutor0) {
        this.executor = (EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "executor");
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        ObjectUtil.checkNotNull(genericFutureListener0, "listener");
        synchronized(this) {
            this.addListener0(genericFutureListener0);
        }
        if(this.isDone()) {
            this.notifyListeners();
        }
        return this;
    }

    private void addListener0(GenericFutureListener genericFutureListener0) {
        GenericFutureListener genericFutureListener1 = this.listener;
        if(genericFutureListener1 == null) {
            DefaultFutureListeners defaultFutureListeners0 = this.listeners;
            if(defaultFutureListeners0 == null) {
                this.listener = genericFutureListener0;
                return;
            }
            defaultFutureListeners0.add(genericFutureListener0);
            return;
        }
        this.listeners = new DefaultFutureListeners(genericFutureListener1, genericFutureListener0);
        this.listener = null;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        ObjectUtil.checkNotNull(arr_genericFutureListener, "listeners");
        synchronized(this) {
            for(int v1 = 0; v1 < arr_genericFutureListener.length; ++v1) {
                GenericFutureListener genericFutureListener0 = arr_genericFutureListener[v1];
                if(genericFutureListener0 == null) {
                    break;
                }
                this.addListener0(genericFutureListener0);
            }
        }
        if(this.isDone()) {
            this.notifyListeners();
        }
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise await() {
        if(this.isDone()) {
            return this;
        }
        if(!Thread.interrupted()) {
            this.checkDeadLock();
            synchronized(this) {
                while(!this.isDone()) {
                    this.incWaiters();
                    try {
                        this.wait();
                    }
                    catch(Throwable throwable0) {
                        this.decWaiters();
                        throw throwable0;
                    }
                    this.decWaiters();
                }
                return this;
            }
        }
        throw new InterruptedException(this.toString());
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v) {
        return this.await0(TimeUnit.MILLISECONDS.toNanos(v), true);
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v, TimeUnit timeUnit0) {
        return this.await0(timeUnit0.toNanos(v), true);
    }

    private boolean await0(long v, boolean z) {
        boolean z1;
        long v4;
        int v3;
        int v1 = 1;
        if(this.isDone()) {
            return true;
        }
        if(v <= 0L) {
            return this.isDone();
        }
        if(z && Thread.interrupted()) {
            throw new InterruptedException("DefaultPromise@7fb90f4d(success)");
        }
        this.checkDeadLock();
        long v2 = System.nanoTime();
        __monitor_enter(this);
        try {
            v3 = 0;
            v4 = v;
            while(true) {
            label_12:
                if(this.isDone() || v4 <= 0L) {
                    z1 = this.isDone();
                    goto label_43;
                }
                this.incWaiters();
                break;
            }
        }
        catch(Throwable throwable0) {
            goto label_36;
        }
        try {
            this.wait(v4 / 1000000L, ((int)(v4 % 1000000L)));
            goto label_27;
        }
        catch(InterruptedException interruptedException0) {
            if(!z) {
                try {
                    this.decWaiters();
                    v3 = 1;
                    goto label_28;
                }
                catch(Throwable throwable0) {
                    goto label_37;
                }
            }
            try {
                throw interruptedException0;
            }
            catch(Throwable throwable1) {
                goto label_25;
            }
        }
        catch(Throwable throwable1) {
            try {
            label_25:
                this.decWaiters();
                throw throwable1;
            label_27:
                this.decWaiters();
            label_28:
                if(this.isDone()) {
                    goto label_31;
                }
                v4 = v - (System.nanoTime() - v2);
                goto label_12;
            }
            catch(Throwable throwable0) {
                goto label_36;
            }
        }
    label_31:
        __monitor_exit(this);
        return true;
        try {
            z1 = this.isDone();
            goto label_43;
        }
        catch(Throwable throwable0) {
        label_36:
            v1 = v3;
        }
        try {
        label_37:
            if(v1 != 0) {
                Thread.currentThread().interrupt();
            }
            throw throwable0;
        }
        catch(Throwable throwable2) {
            __monitor_exit(this);
            throw throwable2;
        }
    label_43:
        __monitor_exit(this);
        return z1;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise awaitUninterruptibly() {
        if(!this.isDone()) {
            this.checkDeadLock();
            synchronized(this) {
                boolean z = false;
                while(!this.isDone()) {
                    this.incWaiters();
                    try {
                        this.wait();
                    }
                    catch(InterruptedException unused_ex) {
                        this.decWaiters();
                        z = true;
                        continue;
                    }
                    catch(Throwable throwable0) {
                        this.decWaiters();
                        throw throwable0;
                    }
                    this.decWaiters();
                }
            }
            if(z) {
                Thread.currentThread().interrupt();
            }
        }
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v) {
        try {
            return this.await0(TimeUnit.MILLISECONDS.toNanos(v), false);
        }
        catch(InterruptedException unused_ex) {
            throw new InternalError();
        }
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v, TimeUnit timeUnit0) {
        try {
            return this.await0(timeUnit0.toNanos(v), false);
        }
        catch(InterruptedException unused_ex) {
            throw new InternalError();
        }
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultPromise.RESULT_UPDATER;
        CauseHolder defaultPromise$CauseHolder0 = DefaultPromise.CANCELLATION_CAUSE_HOLDER;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, defaultPromise$CauseHolder0)) {
                if(this.checkNotifyWaiters()) {
                    this.notifyListeners();
                }
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause0(this.result);
    }

    private Throwable cause0(Object object0) {
        if(!(object0 instanceof CauseHolder)) {
            return null;
        }
        CauseHolder defaultPromise$CauseHolder0 = DefaultPromise.CANCELLATION_CAUSE_HOLDER;
        if(object0 == defaultPromise$CauseHolder0) {
            Throwable throwable0 = new LeanCancellationException(null);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultPromise.RESULT_UPDATER;
            CauseHolder defaultPromise$CauseHolder1 = new CauseHolder(throwable0);
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, defaultPromise$CauseHolder0, defaultPromise$CauseHolder1)) {
                    return throwable0;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == defaultPromise$CauseHolder0);
            object0 = this.result;
        }
        return ((CauseHolder)object0).cause;
    }

    public void checkDeadLock() {
        EventExecutor eventExecutor0 = this.executor();
        if(eventExecutor0 != null && eventExecutor0.inEventLoop()) {
            throw new BlockingOperationException(this.toString());
        }
    }

    private boolean checkNotifyWaiters() {
        synchronized(this) {
            if(this.waiters > 0) {
                this.notifyAll();
            }
            return this.listener != null || this.listeners != null;
        }
    }

    private void decWaiters() {
        this.waiters = (short)(this.waiters - 1);
    }

    public EventExecutor executor() {
        return this.executor;
    }

    @Override  // io.netty.util.concurrent.AbstractFuture
    public Object get() {
        Object object0 = this.result;
        if(!DefaultPromise.isDone0(object0)) {
            this.await();
            object0 = this.result;
        }
        if(object0 != DefaultPromise.SUCCESS && object0 != DefaultPromise.UNCANCELLABLE) {
            Throwable throwable0 = this.cause0(object0);
            if(throwable0 == null) {
                return object0;
            }
            if(throwable0 instanceof CancellationException) {
                throw (CancellationException)throwable0;
            }
            throw new ExecutionException(throwable0);
        }
        return null;
    }

    @Override  // io.netty.util.concurrent.AbstractFuture
    public Object get(long v, TimeUnit timeUnit0) {
        Object object0 = this.result;
        if(!DefaultPromise.isDone0(object0)) {
            if(!this.await(v, timeUnit0)) {
                throw new TimeoutException();
            }
            object0 = this.result;
        }
        if(object0 != DefaultPromise.SUCCESS && object0 != DefaultPromise.UNCANCELLABLE) {
            Throwable throwable0 = this.cause0(object0);
            if(throwable0 == null) {
                return object0;
            }
            if(throwable0 instanceof CancellationException) {
                throw (CancellationException)throwable0;
            }
            throw new ExecutionException(throwable0);
        }
        return null;
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return this.result instanceof CauseHolder || this.result == DefaultPromise.SUCCESS || this.result == DefaultPromise.UNCANCELLABLE ? null : this.result;
    }

    private void incWaiters() {
        int v = this.waiters;
        if(v == 0x7FFF) {
            throw new IllegalStateException("too many waiters: " + this);
        }
        this.waiters = (short)(v + 1);
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override
    public boolean isCancelled() {
        return DefaultPromise.isCancelled0(this.result);
    }

    // 去混淆评级： 低(20)
    private static boolean isCancelled0(Object object0) {
        return object0 instanceof CauseHolder && ((CauseHolder)object0).cause instanceof CancellationException;
    }

    @Override
    public boolean isDone() {
        return DefaultPromise.isDone0(this.result);
    }

    private static boolean isDone0(Object object0) {
        return object0 != null && object0 != DefaultPromise.UNCANCELLABLE;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return this.result != null && this.result != DefaultPromise.UNCANCELLABLE && !(this.result instanceof CauseHolder);
    }

    public static void notifyListener(EventExecutor eventExecutor0, Future future0, GenericFutureListener genericFutureListener0) {
        DefaultPromise.notifyListenerWithStackOverFlowProtection(((EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "eventExecutor")), ((Future)ObjectUtil.checkNotNull(future0, "future")), ((GenericFutureListener)ObjectUtil.checkNotNull(genericFutureListener0, "listener")));
    }

    // 检测为 Lambda 实现
    private static void notifyListener0(Future future0, GenericFutureListener genericFutureListener0) [...]

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor0, Future future0, GenericFutureListener genericFutureListener0) {
        if(eventExecutor0.inEventLoop()) {
            InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.get();
            int v = internalThreadLocalMap0.futureListenerStackDepth();
            if(v < DefaultPromise.MAX_LISTENER_STACK_DEPTH) {
                internalThreadLocalMap0.setFutureListenerStackDepth(v + 1);
                try {
                    DefaultPromise.notifyListener0(future0, genericFutureListener0);
                }
                finally {
                    internalThreadLocalMap0.setFutureListenerStackDepth(v);
                }
                return;
            }
        }
        DefaultPromise.safeExecute(eventExecutor0, () -> try {
            this.val$listener.operationComplete(this.val$future);
        }
        catch(Throwable throwable0) {
            if(DefaultPromise.logger.isWarnEnabled()) {
                DefaultPromise.logger.warn("An exception was thrown by " + this.val$listener.getClass().getName() + ".operationComplete()", throwable0);
            }
        });

        final class io.netty.util.concurrent.DefaultPromise.2 implements Runnable {
            public io.netty.util.concurrent.DefaultPromise.2(Future future0, GenericFutureListener genericFutureListener0) {
            }

            @Override
            public void run() {
                DefaultPromise.notifyListener0(this.val$future, this.val$listener);
            }
        }

    }

    private void notifyListeners() {
        EventExecutor eventExecutor0 = this.executor();
        if(eventExecutor0.inEventLoop()) {
            InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.get();
            int v = internalThreadLocalMap0.futureListenerStackDepth();
            if(v < DefaultPromise.MAX_LISTENER_STACK_DEPTH) {
                internalThreadLocalMap0.setFutureListenerStackDepth(v + 1);
                try {
                    this.notifyListenersNow();
                }
                finally {
                    internalThreadLocalMap0.setFutureListenerStackDepth(v);
                }
                return;
            }
        }
        DefaultPromise.safeExecute(eventExecutor0, () -> synchronized(DefaultPromise.this) {
            GenericFutureListener genericFutureListener0 = DefaultPromise.this.listener;
            DefaultFutureListeners defaultFutureListeners0 = DefaultPromise.this.listeners;
            if(!DefaultPromise.this.notifyingListeners && (genericFutureListener0 != null || defaultFutureListeners0 != null)) {
                DefaultPromise.this.notifyingListeners = true;
                if(genericFutureListener0 == null) {
                    DefaultPromise.this.listeners = null;
                }
                else {
                    DefaultPromise.this.listener = null;
                }
                while(true) {
                    if(genericFutureListener0 == null) {
                        DefaultPromise.this.notifyListeners0(defaultFutureListeners0);
                    }
                    else {
                        DefaultPromise.notifyListener0(DefaultPromise.this, genericFutureListener0);
                    }
                    __monitor_enter(DefaultPromise.this);
                    genericFutureListener0 = DefaultPromise.this.listener;
                    if(genericFutureListener0 == null && DefaultPromise.this.listeners == null) {
                        break;
                    }
                    defaultFutureListeners0 = DefaultPromise.this.listeners;
                    if(genericFutureListener0 == null) {
                        DefaultPromise.this.listeners = null;
                    }
                    else {
                        DefaultPromise.this.listener = null;
                    }
                }
                DefaultPromise.this.notifyingListeners = false;
            }
        });

        class io.netty.util.concurrent.DefaultPromise.1 implements Runnable {
            @Override
            public void run() {
                DefaultPromise.this.notifyListenersNow();
            }
        }

    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners0) {
        GenericFutureListener[] arr_genericFutureListener = defaultFutureListeners0.listeners();
        int v = defaultFutureListeners0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            DefaultPromise.notifyListener0(this, arr_genericFutureListener[v1]);
        }
    }

    // 检测为 Lambda 实现
    private void notifyListenersNow() [...]

    // 检测为 Lambda 实现
    private static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture0, GenericProgressiveFutureListener genericProgressiveFutureListener0, long v, long v1) [...]

    public void notifyProgressiveListeners(long v, long v1) {
        Object object0 = this.progressiveListeners();
        if(object0 == null) {
            return;
        }
        EventExecutor eventExecutor0 = this.executor();
        if(eventExecutor0.inEventLoop()) {
            if(object0 instanceof GenericProgressiveFutureListener[]) {
                DefaultPromise.notifyProgressiveListeners0(((ProgressiveFuture)this), ((GenericProgressiveFutureListener[])object0), v, v1);
                return;
            }
            DefaultPromise.notifyProgressiveListener0(((ProgressiveFuture)this), ((GenericProgressiveFutureListener)object0), v, v1);
            return;
        }
        if(object0 instanceof GenericProgressiveFutureListener[]) {
            DefaultPromise.safeExecute(eventExecutor0, () -> for(int v2 = 0; v2 < this.val$array.length; ++v2) {
                GenericProgressiveFutureListener genericProgressiveFutureListener0 = this.val$array[v2];
                if(genericProgressiveFutureListener0 == null) {
                    break;
                }
                DefaultPromise.notifyProgressiveListener0(this.val$self, genericProgressiveFutureListener0, this.val$progress, this.val$total);
            });
            return;
        }
        DefaultPromise.safeExecute(eventExecutor0, () -> try {
            this.val$l.operationProgressed(this.val$self, this.val$progress, this.val$total);
        }
        catch(Throwable throwable0) {
            if(DefaultPromise.logger.isWarnEnabled()) {
                DefaultPromise.logger.warn("An exception was thrown by " + this.val$l.getClass().getName() + ".operationProgressed()", throwable0);
            }
        });

        class io.netty.util.concurrent.DefaultPromise.3 implements Runnable {
            public io.netty.util.concurrent.DefaultPromise.3(ProgressiveFuture progressiveFuture0, GenericProgressiveFutureListener[] arr_genericProgressiveFutureListener, long v, long v1) {
            }

            @Override
            public void run() {
                DefaultPromise.notifyProgressiveListeners0(this.val$self, this.val$array, this.val$progress, this.val$total);
            }
        }


        class io.netty.util.concurrent.DefaultPromise.4 implements Runnable {
            public io.netty.util.concurrent.DefaultPromise.4(ProgressiveFuture progressiveFuture0, GenericProgressiveFutureListener genericProgressiveFutureListener0, long v, long v1) {
            }

            @Override
            public void run() {
                DefaultPromise.notifyProgressiveListener0(this.val$self, this.val$l, this.val$progress, this.val$total);
            }
        }

    }

    // 检测为 Lambda 实现
    private static void notifyProgressiveListeners0(ProgressiveFuture progressiveFuture0, GenericProgressiveFutureListener[] arr_genericProgressiveFutureListener, long v, long v1) [...]

    private Object progressiveListeners() {
        synchronized(this) {
            GenericFutureListener genericFutureListener0 = this.listener;
            DefaultFutureListeners defaultFutureListeners0 = this.listeners;
            if(genericFutureListener0 == null && defaultFutureListeners0 == null) {
                return null;
            }
            if(defaultFutureListeners0 != null) {
                int v1 = 0;
                int v2 = defaultFutureListeners0.progressiveSize();
                switch(v2) {
                    case 0: {
                        return null;
                    }
                    case 1: {
                        GenericFutureListener[] arr_genericFutureListener1 = defaultFutureListeners0.listeners();
                        while(v1 < arr_genericFutureListener1.length) {
                            GenericFutureListener genericFutureListener2 = arr_genericFutureListener1[v1];
                            if(genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                                return genericFutureListener2;
                            }
                            ++v1;
                        }
                        return null;
                    }
                    default: {
                        GenericFutureListener[] arr_genericFutureListener = defaultFutureListeners0.listeners();
                        GenericProgressiveFutureListener[] arr_genericProgressiveFutureListener = new GenericProgressiveFutureListener[v2];
                        for(int v3 = 0; v1 < v2; ++v3) {
                            GenericFutureListener genericFutureListener1 = arr_genericFutureListener[v3];
                            if(genericFutureListener1 instanceof GenericProgressiveFutureListener) {
                                arr_genericProgressiveFutureListener[v1] = (GenericProgressiveFutureListener)genericFutureListener1;
                                ++v1;
                            }
                        }
                        return arr_genericProgressiveFutureListener;
                    }
                }
            }
            return genericFutureListener0 instanceof GenericProgressiveFutureListener ? genericFutureListener0 : null;
        }
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        ObjectUtil.checkNotNull(genericFutureListener0, "listener");
        synchronized(this) {
            this.removeListener0(genericFutureListener0);
            return this;
        }
    }

    private void removeListener0(GenericFutureListener genericFutureListener0) {
        if(this.listener == genericFutureListener0) {
            this.listener = null;
            return;
        }
        DefaultFutureListeners defaultFutureListeners0 = this.listeners;
        if(defaultFutureListeners0 != null) {
            defaultFutureListeners0.remove(genericFutureListener0);
            if(this.listeners.size() == 0) {
                this.listeners = null;
            }
        }
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        ObjectUtil.checkNotNull(arr_genericFutureListener, "listeners");
        synchronized(this) {
            for(int v1 = 0; v1 < arr_genericFutureListener.length; ++v1) {
                GenericFutureListener genericFutureListener0 = arr_genericFutureListener[v1];
                if(genericFutureListener0 == null) {
                    break;
                }
                this.removeListener0(genericFutureListener0);
            }
            return this;
        }
    }

    private void rethrowIfFailed() {
        Throwable throwable0 = this.cause();
        if(throwable0 == null) {
            return;
        }
        PlatformDependent.throwException(throwable0);
    }

    private static void safeExecute(EventExecutor eventExecutor0, Runnable runnable0) {
        try {
            eventExecutor0.execute(runnable0);
        }
        catch(Throwable throwable0) {
            DefaultPromise.rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", throwable0);
        }
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        if(!this.setFailure0(throwable0)) {
            throw new IllegalStateException("complete already: " + this, throwable0);
        }
        return this;
    }

    private boolean setFailure0(Throwable throwable0) {
        return this.setValue0(new CauseHolder(((Throwable)ObjectUtil.checkNotNull(throwable0, "cause"))));
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        if(!this.setSuccess0(object0)) {
            throw new IllegalStateException("complete already: " + this);
        }
        return this;
    }

    private boolean setSuccess0(Object object0) {
        if(object0 == null) {
            object0 = DefaultPromise.SUCCESS;
        }
        return this.setValue0(object0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultPromise.RESULT_UPDATER;
        Object object0 = DefaultPromise.UNCANCELLABLE;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, object0)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        return !DefaultPromise.isDone0(this.result) || !DefaultPromise.isCancelled0(this.result);
    }

    private boolean setValue0(Object object0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultPromise.RESULT_UPDATER;
    alab1:
        while(!atomicReferenceFieldUpdater0.compareAndSet(this, null, object0)) {
            if(atomicReferenceFieldUpdater0.get(this) != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = DefaultPromise.RESULT_UPDATER;
                Object object1 = DefaultPromise.UNCANCELLABLE;
                while(true) {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, object1, object0)) {
                        break alab1;
                    }
                    if(atomicReferenceFieldUpdater1.get(this) == object1) {
                        continue;
                    }
                    return false;
                }
            }
            if(false) {
                break;
            }
        }
        if(this.checkNotifyWaiters()) {
            this.notifyListeners();
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise sync() {
        this.await();
        this.rethrowIfFailed();
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise syncUninterruptibly() {
        this.awaitUninterruptibly();
        this.rethrowIfFailed();
        return this;
    }

    @Override
    public String toString() [...] // 潜在的解密器

    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder0 = new StringBuilder(0x40);
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append('@');
        stringBuilder0.append(Integer.toHexString(this.hashCode()));
        Object object0 = this.result;
        if(object0 == DefaultPromise.SUCCESS) {
            stringBuilder0.append("(success)");
            return stringBuilder0;
        }
        if(object0 == DefaultPromise.UNCANCELLABLE) {
            stringBuilder0.append("(uncancellable)");
            return stringBuilder0;
        }
        if(object0 instanceof CauseHolder) {
            stringBuilder0.append("(failure: ");
            stringBuilder0.append(((CauseHolder)object0).cause);
            stringBuilder0.append(')');
            return stringBuilder0;
        }
        if(object0 != null) {
            stringBuilder0.append("(success: ");
            stringBuilder0.append(object0);
            stringBuilder0.append(')');
            return stringBuilder0;
        }
        stringBuilder0.append("(incomplete)");
        return stringBuilder0;
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable throwable0) {
        return this.setFailure0(throwable0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean trySuccess(Object object0) {
        return this.setSuccess0(object0);
    }
}

