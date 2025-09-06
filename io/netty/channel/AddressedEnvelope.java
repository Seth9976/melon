package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.net.SocketAddress;

public interface AddressedEnvelope extends ReferenceCounted {
    Object content();

    SocketAddress recipient();

    AddressedEnvelope retain();

    AddressedEnvelope retain(int arg1);

    SocketAddress sender();

    AddressedEnvelope touch();

    AddressedEnvelope touch(Object arg1);
}

