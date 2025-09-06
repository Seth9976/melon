package io.netty.resolver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HostsFileEntries {
    static final HostsFileEntries EMPTY;
    private final Map inet4Entries;
    private final Map inet6Entries;

    static {
        HostsFileEntries.EMPTY = new HostsFileEntries(Collections.EMPTY_MAP, Collections.EMPTY_MAP);
    }

    public HostsFileEntries(Map map0, Map map1) {
        this.inet4Entries = Collections.unmodifiableMap(new HashMap(map0));
        this.inet6Entries = Collections.unmodifiableMap(new HashMap(map1));
    }

    public Map inet4Entries() {
        return this.inet4Entries;
    }

    public Map inet6Entries() {
        return this.inet6Entries;
    }
}

