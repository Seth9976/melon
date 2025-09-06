package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z) {
        this(z, 16);
    }

    public ChannelMetadata(boolean z, int v) {
        ObjectUtil.checkPositive(v, "defaultMaxMessagesPerRead");
        this.hasDisconnect = z;
        this.defaultMaxMessagesPerRead = v;
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }
}

