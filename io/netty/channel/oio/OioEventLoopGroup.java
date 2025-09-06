package io.netty.channel.oio;

import io.netty.channel.ThreadPerChannelEventLoopGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

@Deprecated
public class OioEventLoopGroup extends ThreadPerChannelEventLoopGroup {
    public OioEventLoopGroup() {
        this(0);
    }

    public OioEventLoopGroup(int v) {
        this(v, null);
    }

    public OioEventLoopGroup(int v, Executor executor0) {
        super(v, executor0, new Object[0]);
    }

    public OioEventLoopGroup(int v, ThreadFactory threadFactory0) {
        super(v, threadFactory0, new Object[0]);
    }
}

