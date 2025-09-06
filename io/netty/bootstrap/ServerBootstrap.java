package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ServerBootstrap extends AbstractBootstrap {
    static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final Map.Entry[] childAttrs;
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry[] childOptions;
        private final Runnable enableAutoReadTask;
        private final Collection extensions;

        public ServerBootstrapAcceptor(Channel channel0, EventLoopGroup eventLoopGroup0, ChannelHandler channelHandler0, Map.Entry[] arr_map$Entry, Map.Entry[] arr_map$Entry1, Collection collection0) {
            this.childGroup = eventLoopGroup0;
            this.childHandler = channelHandler0;
            this.childOptions = arr_map$Entry;
            this.childAttrs = arr_map$Entry1;
            this.extensions = collection0;
            this.enableAutoReadTask = new Runnable() {
                @Override
                public void run() {
                    channel0.config().setAutoRead(true);
                }
            };
        }

        @Override  // io.netty.channel.ChannelInboundHandlerAdapter
        public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
            Channel channel0 = (Channel)object0;
            channel0.pipeline().addLast(new ChannelHandler[]{this.childHandler});
            AbstractBootstrap.setChannelOptions(channel0, this.childOptions, ServerBootstrap.logger);
            AbstractBootstrap.setAttributes(channel0, this.childAttrs);
            if(!this.extensions.isEmpty()) {
                for(Object object1: this.extensions) {
                    ChannelInitializerExtension channelInitializerExtension0 = (ChannelInitializerExtension)object1;
                }
            }
            try {
                this.childGroup.register(channel0).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture0) {
                        if(!channelFuture0.isSuccess()) {
                            Throwable throwable0 = channelFuture0.cause();
                            ServerBootstrapAcceptor.forceClose(channel0, throwable0);
                        }
                    }

                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        this.operationComplete(((ChannelFuture)future0));
                    }
                });
            }
            catch(Throwable throwable0) {
                ServerBootstrapAcceptor.forceClose(channel0, throwable0);
            }
        }

        @Override  // io.netty.channel.ChannelInboundHandlerAdapter
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
            ChannelConfig channelConfig0 = channelHandlerContext0.channel().config();
            if(channelConfig0.isAutoRead()) {
                channelConfig0.setAutoRead(false);
                channelHandlerContext0.channel().eventLoop().schedule(this.enableAutoReadTask, 1L, TimeUnit.SECONDS);
            }
            channelHandlerContext0.fireExceptionCaught(throwable0);
        }

        private static void forceClose(Channel channel0, Throwable throwable0) {
            channel0.unsafe().closeForcibly();
            ServerBootstrap.logger.warn("Failed to register an accepted channel: {}", channel0, throwable0);
        }
    }

    private final Map childAttrs;
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;
    private final Map childOptions;
    private final ServerBootstrapConfig config;
    private static final InternalLogger logger;

    static {
        ServerBootstrap.logger = InternalLoggerFactory.getInstance(ServerBootstrap.class);
    }

    public ServerBootstrap() {
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new ConcurrentHashMap();
        this.config = new ServerBootstrapConfig(this);
    }

    private ServerBootstrap(ServerBootstrap serverBootstrap0) {
        super(serverBootstrap0);
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        this.childOptions = linkedHashMap0;
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        this.childAttrs = concurrentHashMap0;
        this.config = new ServerBootstrapConfig(this);
        this.childGroup = serverBootstrap0.childGroup;
        this.childHandler = serverBootstrap0.childHandler;
        synchronized(serverBootstrap0.childOptions) {
            linkedHashMap0.putAll(serverBootstrap0.childOptions);
        }
        concurrentHashMap0.putAll(serverBootstrap0.childAttrs);
    }

    public ServerBootstrap childAttr(AttributeKey attributeKey0, Object object0) {
        ObjectUtil.checkNotNull(attributeKey0, "childKey");
        if(object0 == null) {
            this.childAttrs.remove(attributeKey0);
            return this;
        }
        this.childAttrs.put(attributeKey0, object0);
        return this;
    }

    public final Map childAttrs() {
        return AbstractBootstrap.copiedMap(this.childAttrs);
    }

    @Deprecated
    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    public ServerBootstrap childHandler(ChannelHandler channelHandler0) {
        this.childHandler = (ChannelHandler)ObjectUtil.checkNotNull(channelHandler0, "childHandler");
        return this;
    }

    public final ChannelHandler childHandler() {
        return this.childHandler;
    }

    public ServerBootstrap childOption(ChannelOption channelOption0, Object object0) {
        ObjectUtil.checkNotNull(channelOption0, "childOption");
        synchronized(this.childOptions) {
            if(object0 == null) {
                this.childOptions.remove(channelOption0);
            }
            else {
                this.childOptions.put(channelOption0, object0);
            }
            return this;
        }
    }

    public final Map childOptions() {
        synchronized(this.childOptions) {
        }
        return AbstractBootstrap.copiedMap(this.childOptions);
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrap clone() {
        return this.clone();
    }

    public ServerBootstrap clone() {
        return new ServerBootstrap(this);
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public Object clone() {
        return this.clone();
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrapConfig config() {
        return this.config();
    }

    public final ServerBootstrapConfig config() {
        return this.config;
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrap group(EventLoopGroup eventLoopGroup0) {
        return this.group(eventLoopGroup0);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup0) {
        return this.group(eventLoopGroup0, eventLoopGroup0);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup0, EventLoopGroup eventLoopGroup1) {
        super.group(eventLoopGroup0);
        if(this.childGroup != null) {
            throw new IllegalStateException("childGroup set already");
        }
        this.childGroup = (EventLoopGroup)ObjectUtil.checkNotNull(eventLoopGroup1, "childGroup");
        return this;
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public void init(Channel channel0) {
        AbstractBootstrap.setChannelOptions(channel0, this.newOptionsArray(), ServerBootstrap.logger);
        AbstractBootstrap.setAttributes(channel0, this.newAttributesArray());
        ChannelPipeline channelPipeline0 = channel0.pipeline();
        EventLoopGroup eventLoopGroup0 = this.childGroup;
        ChannelHandler channelHandler0 = this.childHandler;
        Map.Entry[] arr_map$Entry = AbstractBootstrap.newOptionsArray(this.childOptions);
        Map.Entry[] arr_map$Entry1 = AbstractBootstrap.newAttributesArray(this.childAttrs);
        Collection collection0 = this.getInitializerExtensions();
        channelPipeline0.addLast(new ChannelHandler[]{new ChannelInitializer() {
            @Override  // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel0) {
                ChannelPipeline channelPipeline0 = channel0.pipeline();
                ChannelHandler channelHandler0 = ServerBootstrap.this.config.handler();
                if(channelHandler0 != null) {
                    channelPipeline0.addLast(new ChannelHandler[]{channelHandler0});
                }
                channel0.eventLoop().execute(new Runnable() {
                    @Override
                    public void run() {
                        ChannelHandler[] arr_channelHandler = {new ServerBootstrapAcceptor(channel0, io.netty.bootstrap.ServerBootstrap.1.this.val$currentChildGroup, io.netty.bootstrap.ServerBootstrap.1.this.val$currentChildHandler, io.netty.bootstrap.ServerBootstrap.1.this.val$currentChildOptions, io.netty.bootstrap.ServerBootstrap.1.this.val$currentChildAttrs, io.netty.bootstrap.ServerBootstrap.1.this.val$extensions)};
                        channelPipeline0.addLast(arr_channelHandler);
                    }
                });
            }
        }});
        if(!collection0.isEmpty() && channel0 instanceof ServerChannel) {
            ServerChannel serverChannel0 = (ServerChannel)channel0;
            for(Object object0: collection0) {
                ChannelInitializerExtension channelInitializerExtension0 = (ChannelInitializerExtension)object0;
            }
        }
    }

    @Override  // io.netty.bootstrap.AbstractBootstrap
    public AbstractBootstrap validate() {
        return this.validate();
    }

    public ServerBootstrap validate() {
        super.validate();
        if(this.childHandler == null) {
            throw new IllegalStateException("childHandler not set");
        }
        if(this.childGroup == null) {
            ServerBootstrap.logger.warn("childGroup is not set. Using parentGroup instead.");
            this.childGroup = this.config.group();
        }
        return this;
    }
}

