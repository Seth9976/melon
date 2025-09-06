package io.netty.resolver;

import java.net.InetAddress;

public interface HostsFileEntriesResolver {
    public static final HostsFileEntriesResolver DEFAULT;

    static {
        HostsFileEntriesResolver.DEFAULT = new DefaultHostsFileEntriesResolver();
    }

    InetAddress address(String arg1, ResolvedAddressTypes arg2);
}

