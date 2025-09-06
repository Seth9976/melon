package io.netty.channel.embedded;

import java.net.SocketAddress;

final class EmbeddedSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 0x137099FF01041A8BL;

    @Override
    public String toString() {
        return "embedded";
    }
}

