package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class HostsFileEntriesProvider {
    public interface Parser {
        HostsFileEntriesProvider parse();

        HostsFileEntriesProvider parse(File arg1, Charset[] arg2);

        HostsFileEntriesProvider parse(Reader arg1);

        HostsFileEntriesProvider parse(Charset[] arg1);

        HostsFileEntriesProvider parseSilently();

        HostsFileEntriesProvider parseSilently(File arg1, Charset[] arg2);

        HostsFileEntriesProvider parseSilently(Charset[] arg1);
    }

    static final class ParserImpl implements Parser {
        static final ParserImpl INSTANCE = null;
        private static final Pattern WHITESPACES = null;
        private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
        private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
        private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
        private static final InternalLogger logger;

        static {
            ParserImpl.WHITESPACES = Pattern.compile("[ \t]+");
            ParserImpl.logger = InternalLoggerFactory.getInstance(Parser.class);
            ParserImpl.INSTANCE = new ParserImpl();
        }

        // 去混淆评级： 低(40)
        private static File locateHostsFile() {
            return new File("/etc/hosts");
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parse() {
            return this.parse(ParserImpl.locateHostsFile(), new Charset[]{Charset.defaultCharset()});
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parse(File file0, Charset[] arr_charset) {
            HostsFileEntriesProvider hostsFileEntriesProvider0;
            ObjectUtil.checkNotNull(file0, "file");
            ObjectUtil.checkNotNull(arr_charset, "charsets");
            if(arr_charset.length == 0) {
                arr_charset = new Charset[]{Charset.defaultCharset()};
            }
            if(file0.exists() && file0.isFile()) {
                for(int v = 0; v < arr_charset.length; ++v) {
                    Charset charset0 = arr_charset[v];
                    try(BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(file0), charset0))) {
                        hostsFileEntriesProvider0 = this.parse(bufferedReader0);
                    }
                    if(hostsFileEntriesProvider0 != HostsFileEntriesProvider.EMPTY) {
                        return hostsFileEntriesProvider0;
                    }
                }
            }
            return HostsFileEntriesProvider.EMPTY;
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parse(Reader reader0) {
            List list1;
            int v3;
            byte[] arr_b;
            ArrayList arrayList0;
            ObjectUtil.checkNotNull(reader0, "reader");
            BufferedReader bufferedReader0 = new BufferedReader(reader0);
            try {
                HashMap hashMap0 = new HashMap();
                HashMap hashMap1 = new HashMap();
            alab1:
                while(true) {
                    do {
                        do {
                            do {
                                String s = bufferedReader0.readLine();
                                if(s == null) {
                                    break alab1;
                                }
                                int v1 = s.indexOf(35);
                                if(v1 != -1) {
                                    s = s.substring(0, v1);
                                }
                                String s1 = s.trim();
                                if(s1.isEmpty()) {
                                    continue alab1;
                                }
                                arrayList0 = new ArrayList();
                                String[] arr_s = ParserImpl.WHITESPACES.split(s1);
                                for(int v2 = 0; v2 < arr_s.length; ++v2) {
                                    String s2 = arr_s[v2];
                                    if(!s2.isEmpty()) {
                                        arrayList0.add(s2);
                                    }
                                }
                            }
                            while(arrayList0.size() < 2);
                            arr_b = NetUtil.createByteArrayFromIpAddressString(((String)arrayList0.get(0)));
                        }
                        while(arr_b == null);
                        v3 = 1;
                    label_25:
                    }
                    while(v3 >= arrayList0.size());
                    String s3 = (String)arrayList0.get(v3);
                    String s4 = s3.toLowerCase(Locale.ENGLISH);
                    InetAddress inetAddress0 = InetAddress.getByAddress(s3, arr_b);
                    if(inetAddress0 instanceof Inet4Address) {
                        List list0 = (List)hashMap0.get(s4);
                        if(list0 == null) {
                            list1 = new ArrayList();
                            hashMap0.put(s4, list1);
                        }
                        else {
                            list1 = list0;
                        }
                    }
                    else {
                        List list2 = (List)hashMap1.get(s4);
                        if(list2 == null) {
                            list1 = new ArrayList();
                            hashMap1.put(s4, list1);
                        }
                        else {
                            list1 = list2;
                        }
                    }
                    list1.add(inetAddress0);
                    ++v3;
                    goto label_25;
                }
                return !hashMap0.isEmpty() || !hashMap1.isEmpty() ? new HostsFileEntriesProvider(hashMap0, hashMap1) : HostsFileEntriesProvider.EMPTY;
            }
            finally {
                try {
                    bufferedReader0.close();
                }
                catch(IOException iOException0) {
                    ParserImpl.logger.warn("Failed to close a reader", iOException0);
                }
            }
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parse(Charset[] arr_charset) {
            return this.parse(ParserImpl.locateHostsFile(), arr_charset);
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parseSilently() {
            return this.parseSilently(ParserImpl.locateHostsFile(), new Charset[]{Charset.defaultCharset()});
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parseSilently(File file0, Charset[] arr_charset) {
            try {
                return this.parse(file0, arr_charset);
            }
            catch(IOException iOException0) {
                if(ParserImpl.logger.isWarnEnabled()) {
                    ParserImpl.logger.warn("Failed to load and parse hosts file at " + file0.getPath(), iOException0);
                }
                return HostsFileEntriesProvider.EMPTY;
            }
        }

        @Override  // io.netty.resolver.HostsFileEntriesProvider$Parser
        public HostsFileEntriesProvider parseSilently(Charset[] arr_charset) {
            return this.parseSilently(ParserImpl.locateHostsFile(), arr_charset);
        }
    }

    static final HostsFileEntriesProvider EMPTY;
    private final Map ipv4Entries;
    private final Map ipv6Entries;

    static {
        HostsFileEntriesProvider.EMPTY = new HostsFileEntriesProvider(Collections.EMPTY_MAP, Collections.EMPTY_MAP);
    }

    public HostsFileEntriesProvider(Map map0, Map map1) {
        this.ipv4Entries = Collections.unmodifiableMap(new HashMap(map0));
        this.ipv6Entries = Collections.unmodifiableMap(new HashMap(map1));
    }

    public Map ipv4Entries() {
        return this.ipv4Entries;
    }

    public Map ipv6Entries() {
        return this.ipv6Entries;
    }

    public static Parser parser() {
        return ParserImpl.INSTANCE;
    }
}

