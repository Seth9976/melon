package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.net.SocketAddress;

public interface AddressResolver extends Closeable {
    @Override
    void close();

    boolean isResolved(SocketAddress arg1);

    boolean isSupported(SocketAddress arg1);

    Future resolve(SocketAddress arg1);

    Future resolve(SocketAddress arg1, Promise arg2);

    Future resolveAll(SocketAddress arg1);

    Future resolveAll(SocketAddress arg1, Promise arg2);
}

