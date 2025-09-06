package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;

public class Bootstrap extends AbstractBootstrap {
    static final class ExternalAddressResolver {
        final AddressResolverGroup resolverGroup;

        public ExternalAddressResolver(AddressResolverGroup addressResolverGroup0) {
            this.resolverGroup = addressResolverGroup0;
        }

        public static AddressResolverGroup getOrDefault(ExternalAddressResolver bootstrap$ExternalAddressResolver0) {
            return bootstrap$ExternalAddressResolver0 == null ? DefaultAddressResolverGroup.INSTANCE : bootstrap$ExternalAddressResolver0.resolverGroup;
        }
    }

    private final BootstrapConfig config;
    private volatile boolean disableResolver;
    private ExternalAddressResolver externalResolver;
    private static final InternalLogger logger;
    private volatile SocketAddress remoteAddress;

    static {
        Bootstrap.logger = InternalLoggerFactory.getInstance(Bootstrap.class);
    }

    public Bootstrap() {
        this.config = new BootstrapConfig(this);
    }

    private Bootstrap(Bootstrap bootstrap0) {
        super(bootstrap0);
        this.config = new BootstrapConfig(this);
        this.externalResolver = bootstrap0.externalResolver;
        this.disableResolver = bootstrap0.disableResolver;
        this.remoteAddress = bootstrap0.remoteAddress;
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrap clone() {
        return this.clone();
    }

    public Bootstrap clone() {
        return new Bootstrap(this);
    }

    public Bootstrap clone(EventLoopGroup eventLoopGroup0) {
        Bootstrap bootstrap0 = new Bootstrap(this);
        bootstrap0.group = eventLoopGroup0;
        return bootstrap0;
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public Object clone() {
        return this.clone();
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrapConfig config() {
        return this.config();
    }

    public final BootstrapConfig config() {
        return this.config;
    }

    public ChannelFuture connect() {
        this.validate();
        SocketAddress socketAddress0 = this.remoteAddress;
        if(socketAddress0 == null) {
            throw new IllegalStateException("remoteAddress not set");
        }
        return this.doResolveAndConnect(socketAddress0, this.config.localAddress());
    }

    public ChannelFuture connect(String s, int v) {
        return this.connect(InetSocketAddress.createUnresolved(s, v));
    }

    public ChannelFuture connect(InetAddress inetAddress0, int v) {
        return this.connect(new InetSocketAddress(inetAddress0, v));
    }

    public ChannelFuture connect(SocketAddress socketAddress0) {
        ObjectUtil.checkNotNull(socketAddress0, "remoteAddress");
        this.validate();
        return this.doResolveAndConnect(socketAddress0, this.config.localAddress());
    }

    public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        ObjectUtil.checkNotNull(socketAddress0, "remoteAddress");
        this.validate();
        return this.doResolveAndConnect(socketAddress0, socketAddress1);
    }

    public Bootstrap disableResolver() {
        this.externalResolver = null;
        this.disableResolver = true;
        return this;
    }

    private static void doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        Channel channel0 = channelPromise0.channel();
        channel0.eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                SocketAddress socketAddress0 = socketAddress1;
                if(socketAddress0 == null) {
                    channel0.connect(socketAddress0, channelPromise0);
                }
                else {
                    channel0.connect(socketAddress0, socketAddress0, channelPromise0);
                }
                channelPromise0.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        });
    }

    private ChannelFuture doResolveAndConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        ChannelFuture channelFuture0 = this.initAndRegister();
        Channel channel0 = channelFuture0.channel();
        if(channelFuture0.isDone()) {
            return channelFuture0.isSuccess() ? this.doResolveAndConnect0(channel0, socketAddress0, socketAddress1, channel0.newPromise()) : channelFuture0;
        }
        ChannelFuture channelFuture1 = new PendingRegistrationPromise(channel0);
        channelFuture0.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                Throwable throwable0 = channelFuture0.cause();
                if(throwable0 != null) {
                    ((PendingRegistrationPromise)channelFuture1).setFailure(throwable0);
                    return;
                }
                ((PendingRegistrationPromise)channelFuture1).registered();
                Bootstrap.this.doResolveAndConnect0(channel0, socketAddress0, socketAddress1, ((PendingRegistrationPromise)channelFuture1));
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
        return channelFuture1;
    }

    private ChannelFuture doResolveAndConnect0(Channel channel0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        AddressResolver addressResolver0;
        EventLoop eventLoop0;
        try {
            if(this.disableResolver) {
                Bootstrap.doConnect(socketAddress0, socketAddress1, channelPromise0);
                return channelPromise0;
            }
            eventLoop0 = channel0.eventLoop();
        }
        catch(Throwable throwable0) {
            channelPromise0.tryFailure(throwable0);
            return channelPromise0;
        }
        try {
            addressResolver0 = ExternalAddressResolver.getOrDefault(this.externalResolver).getResolver(eventLoop0);
            goto label_9;
        }
        catch(Throwable throwable1) {
            try {
                channel0.close();
                return channelPromise0.setFailure(throwable1);
            label_9:
                if(addressResolver0.isSupported(socketAddress0) && !addressResolver0.isResolved(socketAddress0)) {
                    Future future0 = addressResolver0.resolve(socketAddress0);
                    if(future0.isDone()) {
                        Throwable throwable2 = future0.cause();
                        if(throwable2 != null) {
                            channel0.close();
                            channelPromise0.setFailure(throwable2);
                            return channelPromise0;
                        }
                        Bootstrap.doConnect(((SocketAddress)future0.getNow()), socketAddress1, channelPromise0);
                        return channelPromise0;
                    }
                    future0.addListener(new FutureListener() {
                        @Override  // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future future0) {
                            if(future0.cause() != null) {
                                channel0.close();
                                Throwable throwable0 = future0.cause();
                                channelPromise0.setFailure(throwable0);
                                return;
                            }
                            Bootstrap.doConnect(((SocketAddress)future0.getNow()), socketAddress1, channelPromise0);
                        }
                    });
                    return channelPromise0;
                }
                Bootstrap.doConnect(socketAddress0, socketAddress1, channelPromise0);
                return channelPromise0;
            }
            catch(Throwable throwable0) {
            }
        }
        channelPromise0.tryFailure(throwable0);
        return channelPromise0;
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public void init(Channel channel0) {
        channel0.pipeline().addLast(new ChannelHandler[]{this.config.handler()});
        AbstractBootstrap.setChannelOptions(channel0, this.newOptionsArray(), Bootstrap.logger);
        AbstractBootstrap.setAttributes(channel0, this.newAttributesArray());
        Collection collection0 = this.getInitializerExtensions();
        if(!collection0.isEmpty()) {
            for(Object object0: collection0) {
                ChannelInitializerExtension channelInitializerExtension0 = (ChannelInitializerExtension)object0;
            }
        }
    }

    public Bootstrap remoteAddress(String s, int v) {
        this.remoteAddress = InetSocketAddress.createUnresolved(s, v);
        return this;
    }

    public Bootstrap remoteAddress(InetAddress inetAddress0, int v) {
        this.remoteAddress = new InetSocketAddress(inetAddress0, v);
        return this;
    }

    public Bootstrap remoteAddress(SocketAddress socketAddress0) {
        this.remoteAddress = socketAddress0;
        return this;
    }

    public final SocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    public Bootstrap resolver(AddressResolverGroup addressResolverGroup0) {
        this.externalResolver = addressResolverGroup0 == null ? null : new ExternalAddressResolver(addressResolverGroup0);
        this.disableResolver = false;
        return this;
    }

    // 去混淆评级： 低(20)
    public final AddressResolverGroup resolver() {
        return this.disableResolver ? null : ExternalAddressResolver.getOrDefault(this.externalResolver);
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrap validate() {
        return this.validate();
    }

    public Bootstrap validate() {
        super.validate();
        if(this.config.handler() == null) {
            throw new IllegalStateException("handler not set");
        }
        return this;
    }
}

