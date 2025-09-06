package io.netty.channel;

import io.netty.util.concurrent.AbstractFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public final class VoidChannelPromise extends AbstractFuture implements ChannelPromise {
    private final Channel channel;
    private final ChannelFutureListener fireExceptionListener;

    public VoidChannelPromise(Channel channel0, boolean z) {
        ObjectUtil.checkNotNull(channel0, "channel");
        this.channel = channel0;
        if(z) {
            this.fireExceptionListener = new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture0) {
                    Throwable throwable0 = channelFuture0.cause();
                    if(throwable0 != null) {
                        VoidChannelPromise.this.fireException0(throwable0);
                    }
                }

                @Override  // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future future0) {
                    this.operationComplete(((ChannelFuture)future0));
                }
            };
            return;
        }
        this.fireExceptionListener = null;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    public VoidChannelPromise addListener(GenericFutureListener genericFutureListener0) {
        VoidChannelPromise.fail();
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
        return this.addListeners(arr_genericFutureListener);
    }

    public VoidChannelPromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        VoidChannelPromise.fail();
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
        return this.await();
    }

    public VoidChannelPromise await() {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
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
        VoidChannelPromise.fail();
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v, TimeUnit timeUnit0) {
        VoidChannelPromise.fail();
        return false;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    public VoidChannelPromise awaitUninterruptibly() {
        VoidChannelPromise.fail();
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
        VoidChannelPromise.fail();
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v, TimeUnit timeUnit0) {
        VoidChannelPromise.fail();
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override  // io.netty.channel.ChannelPromise
    public Channel channel() {
        return this.channel;
    }

    private static void fail() {
        throw new IllegalStateException("void future");
    }

    private void fireException0(Throwable throwable0) {
        if(this.fireExceptionListener != null && this.channel.isRegistered()) {
            this.channel.pipeline().fireExceptionCaught(throwable0);
        }
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return null;
    }

    public Void getNow() [...] // Inlined contents

    @Override  // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override  // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return true;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListener(GenericFutureListener genericFutureListener0) {
        return this;
    }

    public VoidChannelPromise removeListener(GenericFutureListener genericFutureListener0) [...] // Inlined contents

    @Override  // io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this;
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this;
    }

    public VoidChannelPromise removeListeners(GenericFutureListener[] arr_genericFutureListener) [...] // Inlined contents

    @Override  // io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    public VoidChannelPromise setFailure(Throwable throwable0) {
        this.fireException0(throwable0);
        return this;
    }

    @Override  // io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        return this;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void void0) {
        return this;
    }

    public VoidChannelPromise setSuccess() [...] // Inlined contents

    public VoidChannelPromise setSuccess(Void void0) [...] // Inlined contents

    @Override  // io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return true;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise sync() {
        return this.sync();
    }

    public VoidChannelPromise sync() {
        VoidChannelPromise.fail();
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
        return this.syncUninterruptibly();
    }

    public VoidChannelPromise syncUninterruptibly() {
        VoidChannelPromise.fail();
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
        this.fireException0(throwable0);
        return false;
    }

    @Override  // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return false;
    }

    @Override  // io.netty.util.concurrent.Promise
    public boolean trySuccess(Object object0) {
        return this.trySuccess(((Void)object0));
    }

    public boolean trySuccess(Void void0) {
        return false;
    }

    @Override  // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        ChannelPromise channelPromise0 = new DefaultChannelPromise(this.channel);
        ChannelFutureListener channelFutureListener0 = this.fireExceptionListener;
        if(channelFutureListener0 != null) {
            channelPromise0.addListener(channelFutureListener0);
        }
        return channelPromise0;
    }
}

