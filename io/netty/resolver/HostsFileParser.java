package io.netty.resolver;

import java.io.File;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public final class HostsFileParser {
    private static HostsFileEntries hostsFileEntries(HostsFileEntriesProvider hostsFileEntriesProvider0) {
        return hostsFileEntriesProvider0 == HostsFileEntriesProvider.EMPTY ? HostsFileEntries.EMPTY : new HostsFileEntries(HostsFileParser.toMapWithSingleValue(hostsFileEntriesProvider0.ipv4Entries()), HostsFileParser.toMapWithSingleValue(hostsFileEntriesProvider0.ipv6Entries()));
    }

    public static HostsFileEntries parse() {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parse());
    }

    public static HostsFileEntries parse(File file0) {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parse(file0, new Charset[0]));
    }

    public static HostsFileEntries parse(File file0, Charset[] arr_charset) {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parse(file0, arr_charset));
    }

    public static HostsFileEntries parse(Reader reader0) {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parse(reader0));
    }

    public static HostsFileEntries parseSilently() {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently());
    }

    public static HostsFileEntries parseSilently(Charset[] arr_charset) {
        return HostsFileParser.hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently(arr_charset));
    }

    private static Map toMapWithSingleValue(Map map0) {
        Map map1 = new HashMap(map0.size());
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            List list0 = (List)map$Entry0.getValue();
            if(!list0.isEmpty()) {
                ((HashMap)map1).put(map$Entry0.getKey(), list0.get(0));
            }
        }
        return map1;
    }
}

