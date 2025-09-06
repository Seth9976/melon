package io.netty.bootstrap;

import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;

public final class BootstrapConfig extends AbstractBootstrapConfig {
    public BootstrapConfig(Bootstrap bootstrap0) {
        super(bootstrap0);
    }

    public SocketAddress remoteAddress() {
        return ((Bootstrap)this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup resolver() {
        return ((Bootstrap)this.bootstrap).resolver();
    }

    @Override  // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(super.toString());
        stringBuilder0.setLength(stringBuilder0.length() - 1);
        AddressResolverGroup addressResolverGroup0 = this.resolver();
        if(addressResolverGroup0 != null) {
            stringBuilder0.append(", resolver: ");
            stringBuilder0.append(addressResolverGroup0);
        }
        SocketAddress socketAddress0 = this.remoteAddress();
        if(socketAddress0 != null) {
            stringBuilder0.append(", remoteAddress: ");
            stringBuilder0.append(socketAddress0);
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

