package io.netty.channel.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;

public interface DatagramChannel extends Channel {
    ChannelFuture block(InetAddress arg1, InetAddress arg2);

    ChannelFuture block(InetAddress arg1, InetAddress arg2, ChannelPromise arg3);

    ChannelFuture block(InetAddress arg1, NetworkInterface arg2, InetAddress arg3);

    ChannelFuture block(InetAddress arg1, NetworkInterface arg2, InetAddress arg3, ChannelPromise arg4);

    DatagramChannelConfig config();

    boolean isConnected();

    ChannelFuture joinGroup(InetAddress arg1);

    ChannelFuture joinGroup(InetAddress arg1, ChannelPromise arg2);

    ChannelFuture joinGroup(InetAddress arg1, NetworkInterface arg2, InetAddress arg3);

    ChannelFuture joinGroup(InetAddress arg1, NetworkInterface arg2, InetAddress arg3, ChannelPromise arg4);

    ChannelFuture joinGroup(InetSocketAddress arg1, NetworkInterface arg2);

    ChannelFuture joinGroup(InetSocketAddress arg1, NetworkInterface arg2, ChannelPromise arg3);

    ChannelFuture leaveGroup(InetAddress arg1);

    ChannelFuture leaveGroup(InetAddress arg1, ChannelPromise arg2);

    ChannelFuture leaveGroup(InetAddress arg1, NetworkInterface arg2, InetAddress arg3);

    ChannelFuture leaveGroup(InetAddress arg1, NetworkInterface arg2, InetAddress arg3, ChannelPromise arg4);

    ChannelFuture leaveGroup(InetSocketAddress arg1, NetworkInterface arg2);

    ChannelFuture leaveGroup(InetSocketAddress arg1, NetworkInterface arg2, ChannelPromise arg3);

    InetSocketAddress localAddress();

    InetSocketAddress remoteAddress();
}

