package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

final class VoidChannelGroupFuture implements ChannelGroupFuture {
    private static final Iterator EMPTY;
    private final ChannelGroup group;

    static {
        VoidChannelGroupFuture.EMPTY = Collections.EMPTY_LIST.iterator();
    }

    public VoidChannelGroupFuture(ChannelGroup channelGroup0) {
        this.group = channelGroup0;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture addListener(GenericFutureListener genericFutureListener0) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture await() {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v, TimeUnit timeUnit0) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture awaitUninterruptibly() {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v, TimeUnit timeUnit0) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupException cause() [...] // Inlined contents

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel0) {
        return null;
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
        throw VoidChannelGroupFuture.reject();
    }

    public Void get(long v, TimeUnit timeUnit0) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return null;
    }

    public Void getNow() [...] // Inlined contents

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

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

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialFailure() {
        return false;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialSuccess() {
        return false;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public boolean isSuccess() {
        return false;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public Iterator iterator() {
        return VoidChannelGroupFuture.EMPTY;
    }

    private static RuntimeException reject() {
        return new IllegalStateException("void future");
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture removeListener(GenericFutureListener genericFutureListener0) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture sync() {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture syncUninterruptibly() {
        throw VoidChannelGroupFuture.reject();
    }

    @Override  // io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }
}

