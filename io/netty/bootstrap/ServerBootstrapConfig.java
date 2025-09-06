package io.netty.bootstrap;

import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.util.internal.StringUtil;
import java.util.Map;

public final class ServerBootstrapConfig extends AbstractBootstrapConfig {
    public ServerBootstrapConfig(ServerBootstrap serverBootstrap0) {
        super(serverBootstrap0);
    }

    public Map childAttrs() {
        return ((ServerBootstrap)this.bootstrap).childAttrs();
    }

    public EventLoopGroup childGroup() {
        return ((ServerBootstrap)this.bootstrap).childGroup();
    }

    public ChannelHandler childHandler() {
        return ((ServerBootstrap)this.bootstrap).childHandler();
    }

    public Map childOptions() {
        return ((ServerBootstrap)this.bootstrap).childOptions();
    }

    @Override  // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(super.toString());
        stringBuilder0.setLength(stringBuilder0.length() - 1);
        stringBuilder0.append(", ");
        EventLoopGroup eventLoopGroup0 = this.childGroup();
        if(eventLoopGroup0 != null) {
            stringBuilder0.append("childGroup: ");
            stringBuilder0.append(StringUtil.simpleClassName(eventLoopGroup0));
            stringBuilder0.append(", ");
        }
        Map map0 = this.childOptions();
        if(!map0.isEmpty()) {
            stringBuilder0.append("childOptions: ");
            stringBuilder0.append(map0);
            stringBuilder0.append(", ");
        }
        Map map1 = this.childAttrs();
        if(!map1.isEmpty()) {
            stringBuilder0.append("childAttrs: ");
            stringBuilder0.append(map1);
            stringBuilder0.append(", ");
        }
        ChannelHandler channelHandler0 = this.childHandler();
        if(channelHandler0 != null) {
            stringBuilder0.append("childHandler: ");
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

