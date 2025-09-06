package io.netty.channel;

import java.io.Serializable;

public interface ChannelId extends Serializable, Comparable {
    String asLongText();

    String asShortText();
}

