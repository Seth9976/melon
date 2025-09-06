package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;

public final class DefaultAddressResolverGroup extends AddressResolverGroup {
    public static final DefaultAddressResolverGroup INSTANCE;

    static {
        DefaultAddressResolverGroup.INSTANCE = new DefaultAddressResolverGroup();
    }

    @Override  // io.netty.resolver.AddressResolverGroup
    public AddressResolver newResolver(EventExecutor eventExecutor0) {
        return new DefaultNameResolver(eventExecutor0).asAddressResolver();
    }
}

