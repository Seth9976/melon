package io.netty.channel.local;

import io.netty.channel.DefaultEventLoopGroup;
import java.util.concurrent.ThreadFactory;

@Deprecated
public class LocalEventLoopGroup extends DefaultEventLoopGroup {
    public LocalEventLoopGroup() {
    }

    public LocalEventLoopGroup(int v) {
        super(v);
    }

    public LocalEventLoopGroup(int v, ThreadFactory threadFactory0) {
        super(v, threadFactory0);
    }

    public LocalEventLoopGroup(ThreadFactory threadFactory0) {
        super(0, threadFactory0);
    }
}

