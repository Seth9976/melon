package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;

final class LocalChannelRegistry {
    private static final ConcurrentMap boundChannels;

    static {
        LocalChannelRegistry.boundChannels = PlatformDependent.newConcurrentHashMap();
    }

    public static Channel get(SocketAddress socketAddress0) {
        return (Channel)LocalChannelRegistry.boundChannels.get(socketAddress0);
    }

    public static LocalAddress register(Channel channel0, LocalAddress localAddress0, SocketAddress socketAddress0) {
        if(localAddress0 != null) {
            throw new ChannelException("already bound");
        }
        if(!(socketAddress0 instanceof LocalAddress)) {
            throw new ChannelException("unsupported address type: " + StringUtil.simpleClassName(socketAddress0));
        }
        LocalAddress localAddress1 = (LocalAddress)socketAddress0;
        if(LocalAddress.ANY.equals(localAddress1)) {
            localAddress1 = new LocalAddress(channel0);
        }
        Channel channel1 = (Channel)LocalChannelRegistry.boundChannels.putIfAbsent(localAddress1, channel0);
        if(channel1 != null) {
            throw new ChannelException("address already in use by: " + channel1);
        }
        return localAddress1;
    }

    public static void unregister(LocalAddress localAddress0) {
        LocalChannelRegistry.boundChannels.remove(localAddress0);
    }
}

