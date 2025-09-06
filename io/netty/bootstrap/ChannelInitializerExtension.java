package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ServerChannel;

public abstract class ChannelInitializerExtension {
    public static final String EXTENSIONS_SYSTEM_PROPERTY = "io.netty.bootstrap.extensions";

    public void postInitializeClientChannel(Channel channel0) {
    }

    public void postInitializeServerChildChannel(Channel channel0) {
    }

    public void postInitializeServerListenerChannel(ServerChannel serverChannel0) {
    }

    public double priority() [...] // Inlined contents
}

