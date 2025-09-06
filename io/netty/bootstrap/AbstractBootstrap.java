package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBootstrap implements Cloneable {
    static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        public PendingRegistrationPromise(Channel channel0) {
            super(channel0);
        }

        @Override  // io.netty.channel.DefaultChannelPromise
        public EventExecutor executor() {
            return this.registered ? super.executor() : GlobalEventExecutor.INSTANCE;
        }

        public void registered() {
            this.registered = true;
        }
    }

    private static final Map.Entry[] EMPTY_ATTRIBUTE_ARRAY;
    private static final Map.Entry[] EMPTY_OPTION_ARRAY;
    private final Map attrs;
    private volatile ChannelFactory channelFactory;
    private volatile ClassLoader extensionsClassLoader;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map options;

    static {
        AbstractBootstrap.EMPTY_OPTION_ARRAY = new Map.Entry[0];
        AbstractBootstrap.EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    }

    public AbstractBootstrap() {
        this.options = new LinkedHashMap();
        this.attrs = new ConcurrentHashMap();
    }

    public AbstractBootstrap(AbstractBootstrap abstractBootstrap0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        this.options = linkedHashMap0;
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        this.attrs = concurrentHashMap0;
        this.group = abstractBootstrap0.group;
        this.channelFactory = abstractBootstrap0.channelFactory;
        this.handler = abstractBootstrap0.handler;
        this.localAddress = abstractBootstrap0.localAddress;
        synchronized(abstractBootstrap0.options) {
            linkedHashMap0.putAll(abstractBootstrap0.options);
        }
        concurrentHashMap0.putAll(abstractBootstrap0.attrs);
        this.extensionsClassLoader = abstractBootstrap0.extensionsClassLoader;
    }

    public AbstractBootstrap attr(AttributeKey attributeKey0, Object object0) {
        ObjectUtil.checkNotNull(attributeKey0, "key");
        if(object0 == null) {
            this.attrs.remove(attributeKey0);
            return this;
        }
        this.attrs.put(attributeKey0, object0);
        return this;
    }

    public final Map attrs() {
        return AbstractBootstrap.copiedMap(this.attrs);
    }

    public final Map attrs0() {
        return this.attrs;
    }

    public ChannelFuture bind() {
        this.validate();
        SocketAddress socketAddress0 = this.localAddress;
        if(socketAddress0 == null) {
            throw new IllegalStateException("localAddress not set");
        }
        return this.doBind(socketAddress0);
    }

    public ChannelFuture bind(int v) {
        return this.bind(new InetSocketAddress(v));
    }

    public ChannelFuture bind(String s, int v) {
        return this.bind(SocketUtils.socketAddress(s, v));
    }

    public ChannelFuture bind(InetAddress inetAddress0, int v) {
        return this.bind(new InetSocketAddress(inetAddress0, v));
    }

    public ChannelFuture bind(SocketAddress socketAddress0) {
        this.validate();
        return this.doBind(((SocketAddress)ObjectUtil.checkNotNull(socketAddress0, "localAddress")));
    }

    public AbstractBootstrap channel(Class class0) {
        return this.channelFactory(new ReflectiveChannelFactory(((Class)ObjectUtil.checkNotNull(class0, "channelClass"))));
    }

    @Deprecated
    public AbstractBootstrap channelFactory(ChannelFactory channelFactory0) {
        ObjectUtil.checkNotNull(channelFactory0, "channelFactory");
        if(this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory0;
        return this;
    }

    public AbstractBootstrap channelFactory(io.netty.channel.ChannelFactory channelFactory0) {
        return this.channelFactory(channelFactory0);
    }

    public final ChannelFactory channelFactory() {
        return this.channelFactory;
    }

    public abstract AbstractBootstrap clone();

    @Override
    public Object clone() {
        return this.clone();
    }

    public abstract AbstractBootstrapConfig config();

    // 去混淆评级： 低(20)
    public static Map copiedMap(Map map0) {
        return map0.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(map0));
    }

    private ChannelFuture doBind(SocketAddress socketAddress0) {
        ChannelFuture channelFuture0 = this.initAndRegister();
        Channel channel0 = channelFuture0.channel();
        if(channelFuture0.cause() != null) {
            return channelFuture0;
        }
        if(channelFuture0.isDone()) {
            ChannelFuture channelFuture1 = channel0.newPromise();
            AbstractBootstrap.doBind0(channelFuture0, channel0, socketAddress0, ((ChannelPromise)channelFuture1));
            return channelFuture1;
        }
        ChannelFuture channelFuture2 = new PendingRegistrationPromise(channel0);
        channelFuture0.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                Throwable throwable0 = channelFuture0.cause();
                if(throwable0 != null) {
                    ((PendingRegistrationPromise)channelFuture2).setFailure(throwable0);
                    return;
                }
                ((PendingRegistrationPromise)channelFuture2).registered();
                AbstractBootstrap.doBind0(channelFuture0, channel0, socketAddress0, ((PendingRegistrationPromise)channelFuture2));
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
        return channelFuture2;
    }

    private static void doBind0(ChannelFuture channelFuture0, Channel channel0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        channel0.eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                if(channelFuture0.isSuccess()) {
                    channel0.bind(socketAddress0, channelPromise0).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                    return;
                }
                Throwable throwable0 = channelFuture0.cause();
                channelPromise0.setFailure(throwable0);
            }
        });
    }

    public AbstractBootstrap extensionsClassLoader(ClassLoader classLoader0) {
        this.extensionsClassLoader = classLoader0;
        return this;
    }

    public Collection getInitializerExtensions() {
        ClassLoader classLoader0 = this.extensionsClassLoader == null ? this.getClass().getClassLoader() : this.extensionsClassLoader;
        return ChannelInitializerExtensions.getExtensions().extensions(classLoader0);
    }

    public AbstractBootstrap group(EventLoopGroup eventLoopGroup0) {
        ObjectUtil.checkNotNull(eventLoopGroup0, "group");
        if(this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = eventLoopGroup0;
        return this;
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    public AbstractBootstrap handler(ChannelHandler channelHandler0) {
        this.handler = (ChannelHandler)ObjectUtil.checkNotNull(channelHandler0, "handler");
        return this;
    }

    public final ChannelHandler handler() {
        return this.handler;
    }

    public abstract void init(Channel arg1);

    public final ChannelFuture initAndRegister() {
        Channel channel0 = null;
        try {
            channel0 = this.channelFactory.newChannel();
            this.init(channel0);
        }
        catch(Throwable throwable0) {
            if(channel0 != null) {
                channel0.unsafe().closeForcibly();
                return new DefaultChannelPromise(channel0, GlobalEventExecutor.INSTANCE).setFailure(throwable0);
            }
            return new DefaultChannelPromise(new FailedChannel(), GlobalEventExecutor.INSTANCE).setFailure(throwable0);
        }
        ChannelFuture channelFuture0 = this.config().group().register(channel0);
        if(channelFuture0.cause() != null) {
            if(channel0.isRegistered()) {
                channel0.close();
                return channelFuture0;
            }
            channel0.unsafe().closeForcibly();
        }
        return channelFuture0;
    }

    public AbstractBootstrap localAddress(int v) {
        return this.localAddress(new InetSocketAddress(v));
    }

    public AbstractBootstrap localAddress(String s, int v) {
        return this.localAddress(SocketUtils.socketAddress(s, v));
    }

    public AbstractBootstrap localAddress(InetAddress inetAddress0, int v) {
        return this.localAddress(new InetSocketAddress(inetAddress0, v));
    }

    public AbstractBootstrap localAddress(SocketAddress socketAddress0) {
        this.localAddress = socketAddress0;
        return this;
    }

    public final SocketAddress localAddress() {
        return this.localAddress;
    }

    public static Map.Entry[] newAttributesArray(Map map0) {
        return (Map.Entry[])map0.entrySet().toArray(AbstractBootstrap.EMPTY_ATTRIBUTE_ARRAY);
    }

    public final Map.Entry[] newAttributesArray() {
        return AbstractBootstrap.newAttributesArray(this.attrs0());
    }

    public static Map.Entry[] newOptionsArray(Map map0) {
        synchronized(map0) {
        }
        return (Map.Entry[])new LinkedHashMap(map0).entrySet().toArray(AbstractBootstrap.EMPTY_OPTION_ARRAY);
    }

    public final Map.Entry[] newOptionsArray() {
        return AbstractBootstrap.newOptionsArray(this.options);
    }

    public AbstractBootstrap option(ChannelOption channelOption0, Object object0) {
        ObjectUtil.checkNotNull(channelOption0, "option");
        synchronized(this.options) {
            if(object0 == null) {
                this.options.remove(channelOption0);
            }
            else {
                this.options.put(channelOption0, object0);
            }
            return this;
        }
    }

    public final Map options() {
        synchronized(this.options) {
        }
        return AbstractBootstrap.copiedMap(this.options);
    }

    public final Map options0() {
        return this.options;
    }

    public ChannelFuture register() {
        this.validate();
        return this.initAndRegister();
    }

    private AbstractBootstrap self() [...] // Inlined contents

    public static void setAttributes(Channel channel0, Map.Entry[] arr_map$Entry) {
        for(int v = 0; v < arr_map$Entry.length; ++v) {
            Map.Entry map$Entry0 = arr_map$Entry[v];
            channel0.attr(((AttributeKey)map$Entry0.getKey())).set(map$Entry0.getValue());
        }
    }

    private static void setChannelOption(Channel channel0, ChannelOption channelOption0, Object object0, InternalLogger internalLogger0) {
        try {
            if(!channel0.config().setOption(channelOption0, object0)) {
                internalLogger0.warn("Unknown channel option \'{}\' for channel \'{}\'", channelOption0, channel0);
            }
        }
        catch(Throwable throwable0) {
            internalLogger0.warn("Failed to set channel option \'{}\' with value \'{}\' for channel \'{}\'", new Object[]{channelOption0, object0, channel0, throwable0});
        }
    }

    public static void setChannelOptions(Channel channel0, Map.Entry[] arr_map$Entry, InternalLogger internalLogger0) {
        for(int v = 0; v < arr_map$Entry.length; ++v) {
            Map.Entry map$Entry0 = arr_map$Entry[v];
            AbstractBootstrap.setChannelOption(channel0, ((ChannelOption)map$Entry0.getKey()), map$Entry0.getValue(), internalLogger0);
        }
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.config() + ')';
    }

    public AbstractBootstrap validate() {
        if(this.group == null) {
            throw new IllegalStateException("group not set");
        }
        if(this.channelFactory == null) {
            throw new IllegalStateException("channel or channelFactory not set");
        }
        return this;
    }
}

