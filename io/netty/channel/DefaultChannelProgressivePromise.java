package io.netty.channel;

import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressiveFuture;
import io.netty.util.concurrent.ProgressivePromise;
import io.netty.util.concurrent.Promise;

public class DefaultChannelProgressivePromise extends DefaultProgressivePromise implements FlushCheckpoint, ChannelProgressivePromise {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelProgressivePromise(Channel channel0) {
        this.channel = channel0;
    }

    public DefaultChannelProgressivePromise(Channel channel0, EventExecutor eventExecutor0) {
        super(eventExecutor0);
        this.channel = channel0;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise addListener(GenericFutureListener genericFutureListener0) {
        super.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise await() {
        super.await();
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise await() {
        return this.await();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise, io.netty.channel.ChannelFuture
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

    public ChannelProgressivePromise promise() [...] // Inlined contents

    @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
    public ChannelPromise promise() {
        return this;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise removeListener(GenericFutureListener genericFutureListener0) {
        super.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise setFailure(Throwable throwable0) {
        super.setFailure(throwable0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise setProgress(long v, long v1) {
        super.setProgress(v, v1);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setProgress(long v, long v1) {
        return this.setProgress(v, v1);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise setSuccess() {
        return this.setSuccess(null);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise setSuccess(Void void0) {
        super.setSuccess(void0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        return this.setSuccess();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void void0) {
        return this.setSuccess(void0);
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise sync() {
        super.sync();
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelProgressiveFuture
    public ChannelProgressiveFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultProgressivePromise, io.netty.util.concurrent.Promise
    public Promise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return this.trySuccess(null);
    }

    @Override  // io.netty.channel.ChannelProgressivePromise
    public ChannelProgressivePromise unvoid() [...] // Inlined contents

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return this;
    }
}

