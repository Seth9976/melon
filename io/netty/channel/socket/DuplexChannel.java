package io.netty.channel.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;

public interface DuplexChannel extends Channel {
    boolean isInputShutdown();

    boolean isOutputShutdown();

    boolean isShutdown();

    ChannelFuture shutdown();

    ChannelFuture shutdown(ChannelPromise arg1);

    ChannelFuture shutdownInput();

    ChannelFuture shutdownInput(ChannelPromise arg1);

    ChannelFuture shutdownOutput();

    ChannelFuture shutdownOutput(ChannelPromise arg1);
}

