package io.netty.channel.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoop;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Deque;
import java.util.concurrent.Callable;

public class SimpleChannelPool implements ChannelPool {
    static final class ChannelPoolFullException extends IllegalStateException {
        private ChannelPoolFullException() {
            super("ChannelPool full");
        }

        public ChannelPoolFullException(io.netty.channel.pool.SimpleChannelPool.1 simpleChannelPool$10) {
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static final boolean $assertionsDisabled;
    private static final AttributeKey POOL_KEY;
    private final Bootstrap bootstrap;
    private final Deque deque;
    private final ChannelPoolHandler handler;
    private final ChannelHealthChecker healthCheck;
    private final boolean lastRecentUsed;
    private final boolean releaseHealthCheck;

    static {
        SimpleChannelPool.POOL_KEY = AttributeKey.newInstance("io.netty.channel.pool.SimpleChannelPool");
    }

    public SimpleChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0) {
        this(bootstrap0, channelPoolHandler0, ChannelHealthChecker.ACTIVE);
    }

    public SimpleChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0) {
        this(bootstrap0, channelPoolHandler0, channelHealthChecker0, true);
    }

    public SimpleChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0, boolean z) {
        this(bootstrap0, channelPoolHandler0, channelHealthChecker0, z, true);
    }

    public SimpleChannelPool(Bootstrap bootstrap0, ChannelPoolHandler channelPoolHandler0, ChannelHealthChecker channelHealthChecker0, boolean z, boolean z1) {
        this.deque = PlatformDependent.newConcurrentDeque();
        this.handler = (ChannelPoolHandler)ObjectUtil.checkNotNull(channelPoolHandler0, "handler");
        this.healthCheck = (ChannelHealthChecker)ObjectUtil.checkNotNull(channelHealthChecker0, "healthCheck");
        this.releaseHealthCheck = z;
        Bootstrap bootstrap1 = ((Bootstrap)ObjectUtil.checkNotNull(bootstrap0, "bootstrap")).clone();
        this.bootstrap = bootstrap1;
        bootstrap1.handler(new ChannelInitializer() {
            static final boolean $assertionsDisabled;

            @Override  // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel0) {
                channelPoolHandler0.channelCreated(channel0);
            }
        });
        this.lastRecentUsed = z1;
    }

    @Override  // io.netty.channel.pool.ChannelPool
    public final Future acquire() {
        return this.acquire(this.bootstrap.config().group().next().newPromise());
    }

    @Override  // io.netty.channel.pool.ChannelPool
    public Future acquire(Promise promise0) {
        return this.acquireHealthyFromPoolOrNew(((Promise)ObjectUtil.checkNotNull(promise0, "promise")));
    }

    private Future acquireHealthyFromPoolOrNew(Promise promise0) {
        try {
            Channel channel0 = this.pollChannel();
            if(channel0 == null) {
                Bootstrap bootstrap0 = this.bootstrap.clone();
                bootstrap0.attr(SimpleChannelPool.POOL_KEY, this);
                ChannelFuture channelFuture0 = this.connectChannel(bootstrap0);
                if(channelFuture0.isDone()) {
                    this.notifyConnect(channelFuture0, promise0);
                    return promise0;
                }
                channelFuture0.addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture0) {
                        SimpleChannelPool.this.notifyConnect(channelFuture0, promise0);
                    }

                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        this.operationComplete(((ChannelFuture)future0));
                    }
                });
                return promise0;
            }
            EventLoop eventLoop0 = channel0.eventLoop();
            if(eventLoop0.inEventLoop()) {
                this.doHealthCheck(channel0, promise0);
                return promise0;
            }
            eventLoop0.execute(() -> {
                try {
                    Future future0 = SimpleChannelPool.this.healthCheck.isHealthy(this.val$ch);
                    if(future0.isDone()) {
                        SimpleChannelPool.this.notifyHealthCheck(future0, this.val$ch, this.val$promise);
                        return;
                    }
                    future0.addListener((Future future0) -> {
                        try {
                            if(future0.isSuccess() && ((Boolean)future0.getNow()).booleanValue()) {
                                this.val$channel.attr(SimpleChannelPool.POOL_KEY).set(SimpleChannelPool.this);
                                SimpleChannelPool.this.handler.channelAcquired(this.val$channel);
                                this.val$promise.setSuccess(this.val$channel);
                                return;
                            }
                            SimpleChannelPool.this.closeChannel(this.val$channel);
                            SimpleChannelPool.this.acquireHealthyFromPoolOrNew(this.val$promise);
                            return;
                        }
                        catch(Throwable throwable0) {
                        }
                        SimpleChannelPool.this.closeAndFail(this.val$channel, throwable0, this.val$promise);
                    });
                    return;
                }
                catch(Throwable throwable0) {
                }
                SimpleChannelPool.this.closeAndFail(this.val$ch, throwable0, this.val$promise);

                class io.netty.channel.pool.SimpleChannelPool.4 implements FutureListener {
                    public io.netty.channel.pool.SimpleChannelPool.4(Channel channel0, Promise promise0) {
                    }

                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        SimpleChannelPool.this.notifyHealthCheck(future0, this.val$channel, this.val$promise);
                    }
                }

            });
            return promise0;
        }
        catch(Throwable throwable0) {
        }
        promise0.tryFailure(throwable0);
        return promise0;

        class io.netty.channel.pool.SimpleChannelPool.3 implements Runnable {
            public io.netty.channel.pool.SimpleChannelPool.3(Channel channel0, Promise promise0) {
            }

            @Override
            public void run() {
                SimpleChannelPool.this.doHealthCheck(this.val$ch, this.val$promise);
            }
        }

    }

    public Bootstrap bootstrap() {
        return this.bootstrap;
    }

    @Override  // io.netty.channel.pool.ChannelPool
    public void close() {
        Channel channel0;
        while((channel0 = this.pollChannel()) != null) {
            channel0.close().awaitUninterruptibly();
        }
    }

    private void closeAndFail(Channel channel0, Throwable throwable0, Promise promise0) {
        if(channel0 != null) {
            try {
                this.closeChannel(channel0);
            }
            catch(Throwable throwable1) {
                promise0.tryFailure(throwable1);
            }
        }
        promise0.tryFailure(throwable0);
    }

    public Future closeAsync() {
        io.netty.channel.pool.SimpleChannelPool.7 simpleChannelPool$70 = new Callable() {
            @Override
            public Object call() {
                return this.call();
            }

            public Void call() {
                SimpleChannelPool.this.close();
                return null;
            }
        };
        return GlobalEventExecutor.INSTANCE.submit(simpleChannelPool$70);
    }

    private void closeChannel(Channel channel0) {
        channel0.attr(SimpleChannelPool.POOL_KEY).getAndSet(null);
        channel0.close();
    }

    public ChannelFuture connectChannel(Bootstrap bootstrap0) {
        return bootstrap0.connect();
    }

    // 检测为 Lambda 实现
    private void doHealthCheck(Channel channel0, Promise promise0) [...]

    private void doHealthCheckOnRelease(Channel channel0, Promise promise0) {
        Future future0 = this.healthCheck.isHealthy(channel0);
        if(future0.isDone()) {
            this.releaseAndOfferIfHealthy(channel0, promise0, future0);
            return;
        }
        future0.addListener((/* 缺少LAMBDA参数 */) -> {
            try {
                if(((Boolean)this.val$f.getNow()).booleanValue()) {
                    SimpleChannelPool.this.releaseAndOffer(this.val$channel, this.val$promise);
                    return;
                }
                SimpleChannelPool.this.handler.channelReleased(this.val$channel);
                this.val$promise.setSuccess(null);
                return;
            }
            catch(Throwable throwable0) {
            }
            SimpleChannelPool.this.closeAndFail(this.val$channel, throwable0, this.val$promise);
        });

        class io.netty.channel.pool.SimpleChannelPool.6 implements FutureListener {
            public io.netty.channel.pool.SimpleChannelPool.6(Channel channel0, Promise promise0, Future future0) {
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                SimpleChannelPool.this.releaseAndOfferIfHealthy(this.val$channel, this.val$promise, this.val$f);
            }
        }

    }

    // 检测为 Lambda 实现
    private void doReleaseChannel(Channel channel0, Promise promise0) [...]

    public ChannelPoolHandler handler() {
        return this.handler;
    }

    public ChannelHealthChecker healthChecker() {
        return this.healthCheck;
    }

    private void notifyConnect(ChannelFuture channelFuture0, Promise promise0) {
        Channel channel0 = null;
        try {
            if(channelFuture0.isSuccess()) {
                channel0 = channelFuture0.channel();
                this.handler.channelAcquired(channel0);
                if(!promise0.trySuccess(channel0)) {
                    this.release(channel0);
                    return;
                }
                return;
            }
            promise0.tryFailure(channelFuture0.cause());
            return;
        }
        catch(Throwable throwable0) {
        }
        this.closeAndFail(channel0, throwable0, promise0);
    }

    // 检测为 Lambda 实现
    private void notifyHealthCheck(Future future0, Channel channel0, Promise promise0) [...]

    public boolean offerChannel(Channel channel0) {
        return this.deque.offer(channel0);
    }

    // 去混淆评级： 低(20)
    public Channel pollChannel() {
        return this.lastRecentUsed ? ((Channel)this.deque.pollLast()) : ((Channel)this.deque.pollFirst());
    }

    @Override  // io.netty.channel.pool.ChannelPool
    public final Future release(Channel channel0) {
        return this.release(channel0, channel0.eventLoop().newPromise());
    }

    @Override  // io.netty.channel.pool.ChannelPool
    public Future release(Channel channel0, Promise promise0) {
        try {
            ObjectUtil.checkNotNull(channel0, "channel");
            ObjectUtil.checkNotNull(promise0, "promise");
            EventLoop eventLoop0 = channel0.eventLoop();
            if(eventLoop0.inEventLoop()) {
                this.doReleaseChannel(channel0, promise0);
                return promise0;
            }
            eventLoop0.execute(() -> {
                try {
                    if(this.val$channel.attr(SimpleChannelPool.POOL_KEY).getAndSet(null) != SimpleChannelPool.this) {
                        SimpleChannelPool.this.closeAndFail(this.val$channel, new IllegalArgumentException("Channel " + this.val$channel + " was not acquired from this ChannelPool"), this.val$promise);
                        return;
                    }
                    if(SimpleChannelPool.this.releaseHealthCheck) {
                        SimpleChannelPool.this.doHealthCheckOnRelease(this.val$channel, this.val$promise);
                        return;
                    }
                    SimpleChannelPool.this.releaseAndOffer(this.val$channel, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                SimpleChannelPool.this.closeAndFail(this.val$channel, throwable0, this.val$promise);
            });
            return promise0;
        }
        catch(Throwable throwable0) {
        }
        this.closeAndFail(channel0, throwable0, promise0);
        return promise0;

        class io.netty.channel.pool.SimpleChannelPool.5 implements Runnable {
            public io.netty.channel.pool.SimpleChannelPool.5(Channel channel0, Promise promise0) {
            }

            @Override
            public void run() {
                SimpleChannelPool.this.doReleaseChannel(this.val$channel, this.val$promise);
            }
        }

    }

    private void releaseAndOffer(Channel channel0, Promise promise0) {
        if(this.offerChannel(channel0)) {
            this.handler.channelReleased(channel0);
            promise0.setSuccess(null);
            return;
        }
        this.closeAndFail(channel0, new ChannelPoolFullException(null), promise0);
    }

    // 检测为 Lambda 实现
    private void releaseAndOfferIfHealthy(Channel channel0, Promise promise0, Future future0) [...]

    public boolean releaseHealthCheck() {
        return this.releaseHealthCheck;
    }
}

