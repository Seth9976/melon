package io.netty.channel.embedded;

import io.netty.channel.ChannelId;

final class EmbeddedChannelId implements ChannelId {
    static final ChannelId INSTANCE = null;
    private static final long serialVersionUID = -251711922203466130L;

    static {
        EmbeddedChannelId.INSTANCE = new EmbeddedChannelId();
    }

    @Override  // io.netty.channel.ChannelId
    public String asLongText() [...] // 潜在的解密器

    @Override  // io.netty.channel.ChannelId
    public String asShortText() {
        return "embedded";
    }

    // 去混淆评级： 低(40)
    public int compareTo(ChannelId channelId0) {
        return channelId0 instanceof EmbeddedChannelId ? 0 : "embedded".compareTo(channelId0.asLongText());
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((ChannelId)object0));
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof EmbeddedChannelId;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() [...] // Inlined contents
}

