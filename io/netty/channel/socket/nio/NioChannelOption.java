package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Set;

@SuppressJava6Requirement(reason = "Usage explicit by the user")
public final class NioChannelOption extends ChannelOption {
    private final SocketOption option;

    private NioChannelOption(SocketOption socketOption0) {
        super(socketOption0.name());
        this.option = socketOption0;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Object getOption(Channel channel0, NioChannelOption nioChannelOption0) {
        NetworkChannel networkChannel0 = (NetworkChannel)channel0;
        if(!networkChannel0.supportedOptions().contains(nioChannelOption0.option)) {
            return null;
        }
        if(networkChannel0 instanceof ServerSocketChannel && nioChannelOption0.option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return networkChannel0.getOption(nioChannelOption0.option);
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ChannelOption[] getOptions(Channel channel0) {
        Set set0 = ((NetworkChannel)channel0).supportedOptions();
        int v = 0;
        if(((NetworkChannel)channel0) instanceof ServerSocketChannel) {
            ArrayList arrayList0 = new ArrayList(set0.size());
            for(Object object0: set0) {
                SocketOption socketOption0 = (SocketOption)object0;
                if(socketOption0 != StandardSocketOptions.IP_TOS) {
                    arrayList0.add(new NioChannelOption(socketOption0));
                }
            }
            return (ChannelOption[])arrayList0.toArray(new ChannelOption[0]);
        }
        ChannelOption[] arr_channelOption = new ChannelOption[set0.size()];
        for(Object object1: set0) {
            arr_channelOption[v] = new NioChannelOption(((SocketOption)object1));
            ++v;
        }
        return arr_channelOption;
    }

    public static ChannelOption of(SocketOption socketOption0) {
        return new NioChannelOption(socketOption0);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static boolean setOption(Channel channel0, NioChannelOption nioChannelOption0, Object object0) {
        NetworkChannel networkChannel0 = (NetworkChannel)channel0;
        if(!networkChannel0.supportedOptions().contains(nioChannelOption0.option)) {
            return false;
        }
        if(networkChannel0 instanceof ServerSocketChannel && nioChannelOption0.option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            networkChannel0.setOption(nioChannelOption0.option, object0);
            return true;
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }
}

