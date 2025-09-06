package io.netty.bootstrap;

import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;

public abstract class AbstractBootstrapConfig {
    protected final AbstractBootstrap bootstrap;

    public AbstractBootstrapConfig(AbstractBootstrap abstractBootstrap0) {
        this.bootstrap = (AbstractBootstrap)ObjectUtil.checkNotNull(abstractBootstrap0, "bootstrap");
    }

    public final Map attrs() {
        return this.bootstrap.attrs();
    }

    public final ChannelFactory channelFactory() {
        return this.bootstrap.channelFactory();
    }

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }

    public final ChannelHandler handler() {
        return this.bootstrap.handler();
    }

    public final SocketAddress localAddress() {
        return this.bootstrap.localAddress();
    }

    public final Map options() {
        return this.bootstrap.options();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append('(');
        EventLoopGroup eventLoopGroup0 = this.group();
        if(eventLoopGroup0 != null) {
            stringBuilder0.append("group: ");
            stringBuilder0.append(StringUtil.simpleClassName(eventLoopGroup0));
            stringBuilder0.append(", ");
        }
        ChannelFactory channelFactory0 = this.channelFactory();
        if(channelFactory0 != null) {
            stringBuilder0.append("channelFactory: ");
            stringBuilder0.append(channelFactory0);
            stringBuilder0.append(", ");
        }
        SocketAddress socketAddress0 = this.localAddress();
        if(socketAddress0 != null) {
            stringBuilder0.append("localAddress: ");
            stringBuilder0.append(socketAddress0);
            stringBuilder0.append(", ");
        }
        Map map0 = this.options();
        if(!map0.isEmpty()) {
            stringBuilder0.append("options: ");
            stringBuilder0.append(map0);
            stringBuilder0.append(", ");
        }
        Map map1 = this.attrs();
        if(!map1.isEmpty()) {
            stringBuilder0.append("attrs: ");
            stringBuilder0.append(map1);
            stringBuilder0.append(", ");
        }
        ChannelHandler channelHandler0 = this.handler();
        if(channelHandler0 != null) {
            stringBuilder0.append("handler: ");
            stringBuilder0.append(channelHandler0);
            stringBuilder0.append(", ");
        }
        if(stringBuilder0.charAt(stringBuilder0.length() - 1) == 40) {
            stringBuilder0.append(')');
            return stringBuilder0.toString();
        }
        stringBuilder0.setCharAt(stringBuilder0.length() - 2, ')');
        stringBuilder0.setLength(stringBuilder0.length() - 1);
        return stringBuilder0.toString();
    }
}

