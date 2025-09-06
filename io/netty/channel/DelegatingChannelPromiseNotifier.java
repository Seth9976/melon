package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

public final class DelegatingChannelPromiseNotifier implements ChannelFutureListener, ChannelPromise {
    private final ChannelPromise delegate;
    private final boolean logNotifyFailure;
    private static final InternalLogger logger;

    static {
        DelegatingChannelPromiseNotifier.logger = InternalLoggerFactory.getInstance(DelegatingChannelPromiseNotifier.class);
    }

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise0) {
        this(channelPromise0, !(channelPromise0 instanceof VoidChannelPromise));
    }

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise0, boolean z) {
        this.delegate = (ChannelPromise)ObjectUtil.checkNotNull(channelPromise0, "delegate");
        this.logNotifyFailure = z;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListener(GenericFutureListener genericFutureListener0) {
        this.delegate.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        this.delegate.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise await() {
        this.delegate.await();
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v) {
        return this.delegate.await(v);
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v, TimeUnit timeUnit0) {
        return this.delegate.await(v, timeUnit0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise awaitUninterruptibly() {
        this.delegate.awaitUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v) {
        return this.delegate.awaitUninterruptibly(v);
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v, TimeUnit timeUnit0) {
        return this.delegate.awaitUninterruptibly(v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.delegate.cancel(z);
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.delegate.cause();
    }

    @Override  // io.netty.channel.ChannelPromise
    public Channel channel() {
        return this.delegate.channel();
    }

    @Override
    public Object get() {
        return this.get();
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        return this.get(v, timeUnit0);
    }

    public Void get() {
        return (Void)this.delegate.get();
    }

    public Void get(long v, TimeUnit timeUnit0) {
        return (Void)this.delegate.get(v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return this.getNow();
    }

    public Void getNow() {
        return (Void)this.delegate.getNow();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.delegate.isCancellable();
    }

    @Override
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.delegate.isDone();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return this.delegate.isSuccess();
    }

    @Override  // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return this.delegate.isVoid();
    }

    public void operationComplete(ChannelFuture channelFuture0) {
        InternalLogger internalLogger0 = this.logNotifyFailure ? DelegatingChannelPromiseNotifier.logger : null;
        if(channelFuture0.isSuccess()) {
            Void void0 = (Void)channelFuture0.get();
            PromiseNotificationUtil.trySuccess(this.delegate, void0, internalLogger0);
            return;
        }
        if(channelFuture0.isCancelled()) {
            PromiseNotificationUtil.tryCancel(this.delegate, internalLogger0);
            return;
        }
        Throwable throwable0 = channelFuture0.cause();
        PromiseNotificationUtil.tryFailure(this.delegate, throwable0, internalLogger0);
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future future0) {
        this.operationComplete(((ChannelFuture)future0));
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListener(GenericFutureListener genericFutureListener0) {
        this.delegate.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        this.delegate.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable throwable0) {
        this.delegate.setFailure(throwable0);
        return this;
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        this.delegate.setSuccess();
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void void0) {
        this.delegate.setSuccess(void0);
        return this;
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return this.delegate.setUncancellable();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise sync() {
        this.delegate.sync();
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise syncUninterruptibly() {
        this.delegate.syncUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable throwable0) {
        return this.delegate.tryFailure(throwable0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return this.delegate.trySuccess();
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean trySuccess(Object object0) {
        return this.trySuccess(((Void)object0));
    }

    public boolean trySuccess(Void void0) {
        return this.delegate.trySuccess(void0);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return this.isVoid() ? new DelegatingChannelPromiseNotifier(this.delegate.unvoid()) : this;
    }
}

