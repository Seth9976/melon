package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;

public class NoopAddressResolver extends AbstractAddressResolver {
    public NoopAddressResolver(EventExecutor eventExecutor0) {
        super(eventExecutor0);
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(SocketAddress socketAddress0) {
        return true;
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public void doResolve(SocketAddress socketAddress0, Promise promise0) {
        promise0.setSuccess(socketAddress0);
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public void doResolveAll(SocketAddress socketAddress0, Promise promise0) {
        promise0.setSuccess(Collections.singletonList(socketAddress0));
    }
}

