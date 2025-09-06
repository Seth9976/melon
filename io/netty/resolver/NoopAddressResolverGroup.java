package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;

public final class NoopAddressResolverGroup extends AddressResolverGroup {
    public static final NoopAddressResolverGroup INSTANCE;

    static {
        NoopAddressResolverGroup.INSTANCE = new NoopAddressResolverGroup();
    }

    @Override  // io.netty.resolver.AddressResolverGroup
    public AddressResolver newResolver(EventExecutor eventExecutor0) {
        return new NoopAddressResolver(eventExecutor0);
    }
}

