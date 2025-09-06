package io.netty.channel;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;

public class DefaultChannelPromise extends DefaultPromise implements FlushCheckpoint, ChannelPromise {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelPromise(Channel channel0) {
        this.channel = (Channel)ObjectUtil.checkNotNull(channel0, "channel");
    }

    public DefaultChannelPromise(Channel channel0, EventExecutor eventExecutor0) {
        super(eventExecutor0);
        this.channel = (Channel)ObjectUtil.checkNotNull(channel0, "channel");
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListener(GenericFutureListener genericFutureListener0) {
        super.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise await() {
        super.await();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public Channel channel() {
        return this.channel;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public void checkDeadLock() {
        if(this.channel().isRegistered()) {
            super.checkDeadLock();
        }
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        EventExecutor eventExecutor0 = super.executor();
        return eventExecutor0 == null ? this.channel().eventLoop() : eventExecutor0;
    }

    @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
    public long flushCheckpoint() {
        return this.checkpoint;
    }

    @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
    public void flushCheckpoint(long v) {
        this.checkpoint = v;
    }

    @Override  // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }

    @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
    public ChannelPromise promise() {
        return this;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListener(GenericFutureListener genericFutureListener0) {
        super.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable throwable0) {
        super.setFailure(throwable0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        return this.setSuccess(null);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void void0) {
        super.setSuccess(void0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise sync() {
        super.sync();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return this.trySuccess(null);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return this;
    }
}

