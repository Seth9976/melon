package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.SocketUtils;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DefaultNameResolver extends InetNameResolver {
    public DefaultNameResolver(EventExecutor eventExecutor0) {
        super(eventExecutor0);
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolve(String s, Promise promise0) {
        try {
            promise0.setSuccess(SocketUtils.addressByName(s));
        }
        catch(UnknownHostException unknownHostException0) {
            promise0.setFailure(unknownHostException0);
        }
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String s, Promise promise0) {
        try {
            promise0.setSuccess(Arrays.asList(SocketUtils.allAddressesByName(s)));
        }
        catch(UnknownHostException unknownHostException0) {
            promise0.setFailure(unknownHostException0);
        }
    }
}

