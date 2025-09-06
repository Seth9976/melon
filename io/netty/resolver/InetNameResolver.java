package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;

public abstract class InetNameResolver extends SimpleNameResolver {
    private volatile AddressResolver addressResolver;

    public InetNameResolver(EventExecutor eventExecutor0) {
        super(eventExecutor0);
    }

    public AddressResolver asAddressResolver() {
        AddressResolver addressResolver0 = this.addressResolver;
        if(addressResolver0 == null) {
            synchronized(this) {
                AddressResolver addressResolver1 = this.addressResolver;
                if(addressResolver1 == null) {
                    addressResolver1 = new InetSocketAddressResolver(this.executor(), this);
                    this.addressResolver = addressResolver1;
                }
                return addressResolver1;
            }
        }
        return addressResolver0;
    }
}

