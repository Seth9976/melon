package io.netty.channel;

import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

abstract class CompleteChannelFuture extends CompleteFuture implements ChannelFuture {
    private final Channel channel;

    public CompleteChannelFuture(Channel channel0, EventExecutor eventExecutor0) {
        super(eventExecutor0);
        this.channel = (Channel)ObjectUtil.checkNotNull(channel0, "channel");
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListener(GenericFutureListener genericFutureListener0) {
        super.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture await() [...] // Inlined contents

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future await() {
        return this;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() [...] // Inlined contents

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this;
    }

    @Override  // io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture
    public EventExecutor executor() {
        EventExecutor eventExecutor0 = super.executor();
        return eventExecutor0 == null ? this.channel().eventLoop() : eventExecutor0;
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return null;
    }

    public Void getNow() [...] // Inlined contents

    @Override  // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListener(GenericFutureListener genericFutureListener0) {
        super.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.ChannelFuture
    public ChannelFuture syncUninterruptibly() {
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }
}

