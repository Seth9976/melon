package io.netty.resolver;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private static final long DEFAULT_REFRESH_INTERVAL;
    private final Parser hostsFileParser;
    private volatile Map inet4Entries;
    private volatile Map inet6Entries;
    private final AtomicLong lastRefresh;
    private static final InternalLogger logger;
    private final long refreshInterval;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(DefaultHostsFileEntriesResolver.class);
        DefaultHostsFileEntriesResolver.logger = internalLogger0;
        long v = SystemPropertyUtil.getLong("io.netty.hostsFileRefreshInterval", 0L);
        DefaultHostsFileEntriesResolver.DEFAULT_REFRESH_INTERVAL = v;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-Dio.netty.hostsFileRefreshInterval: {}", v);
        }
    }

    public DefaultHostsFileEntriesResolver() {
        this(HostsFileEntriesProvider.parser(), DefaultHostsFileEntriesResolver.DEFAULT_REFRESH_INTERVAL);
    }

    public DefaultHostsFileEntriesResolver(Parser hostsFileEntriesProvider$Parser0, long v) {
        this.lastRefresh = new AtomicLong(System.nanoTime());
        this.hostsFileParser = hostsFileEntriesProvider$Parser0;
        this.refreshInterval = ObjectUtil.checkPositiveOrZero(v, "refreshInterval");
        HostsFileEntriesProvider hostsFileEntriesProvider0 = DefaultHostsFileEntriesResolver.parseEntries(hostsFileEntriesProvider$Parser0);
        this.inet4Entries = hostsFileEntriesProvider0.ipv4Entries();
        this.inet6Entries = hostsFileEntriesProvider0.ipv6Entries();
    }

    @Override  // io.netty.resolver.HostsFileEntriesResolver
    public InetAddress address(String s, ResolvedAddressTypes resolvedAddressTypes0) {
        return DefaultHostsFileEntriesResolver.firstAddress(this.addresses(s, resolvedAddressTypes0));
    }

    public List addresses(String s, ResolvedAddressTypes resolvedAddressTypes0) {
        String s1 = this.normalize(s);
        this.ensureHostsFileEntriesAreFresh();
        switch(io.netty.resolver.DefaultHostsFileEntriesResolver.1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes0.ordinal()]) {
            case 1: {
                return (List)this.inet4Entries.get(s1);
            }
            case 2: {
                return (List)this.inet6Entries.get(s1);
            }
            case 3: {
                List list0 = (List)this.inet4Entries.get(s1);
                return list0 == null ? ((List)this.inet6Entries.get(s1)) : DefaultHostsFileEntriesResolver.allAddresses(list0, ((List)this.inet6Entries.get(s1)));
            }
            case 4: {
                List list1 = (List)this.inet6Entries.get(s1);
                return list1 == null ? ((List)this.inet4Entries.get(s1)) : DefaultHostsFileEntriesResolver.allAddresses(list1, ((List)this.inet4Entries.get(s1)));
            }
            default: {
                throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes0);
            }
        }
    }

    private static List allAddresses(List list0, List list1) {
        List list2 = new ArrayList(list0.size() + (list1 == null ? 0 : list1.size()));
        ((ArrayList)list2).addAll(list0);
        if(list1 != null) {
            ((ArrayList)list2).addAll(list1);
        }
        return list2;
    }

    private void ensureHostsFileEntriesAreFresh() {
        long v = this.refreshInterval;
        if(v != 0L) {
            long v1 = this.lastRefresh.get();
            long v2 = System.nanoTime();
            if(v2 - v1 > v && this.lastRefresh.compareAndSet(v1, v2)) {
                HostsFileEntriesProvider hostsFileEntriesProvider0 = DefaultHostsFileEntriesResolver.parseEntries(this.hostsFileParser);
                this.inet4Entries = hostsFileEntriesProvider0.ipv4Entries();
                this.inet6Entries = hostsFileEntriesProvider0.ipv6Entries();
            }
        }
    }

    private static InetAddress firstAddress(List list0) {
        return list0 == null || list0.isEmpty() ? null : ((InetAddress)list0.get(0));
    }

    public String normalize(String s) {
        return s.toLowerCase(Locale.ENGLISH);
    }

    // 去混淆评级： 低(40)
    private static HostsFileEntriesProvider parseEntries(Parser hostsFileEntriesProvider$Parser0) {
        return hostsFileEntriesProvider$Parser0.parseSilently();
    }

    class io.netty.resolver.DefaultHostsFileEntriesResolver.1 {
        static final int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] arr_v = new int[ResolvedAddressTypes.values().length];
            io.netty.resolver.DefaultHostsFileEntriesResolver.1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes = arr_v;
            try {
                arr_v[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.resolver.DefaultHostsFileEntriesResolver.1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.resolver.DefaultHostsFileEntriesResolver.1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.resolver.DefaultHostsFileEntriesResolver.1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

