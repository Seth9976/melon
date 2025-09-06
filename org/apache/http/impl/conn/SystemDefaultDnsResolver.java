package org.apache.http.impl.conn;

import java.net.InetAddress;
import org.apache.http.conn.DnsResolver;

public class SystemDefaultDnsResolver implements DnsResolver {
    public static final SystemDefaultDnsResolver INSTANCE;

    static {
        SystemDefaultDnsResolver.INSTANCE = new SystemDefaultDnsResolver();
    }

    // 检测为 Lambda 实现
    @Override  // org.apache.http.conn.DnsResolver
    public InetAddress[] resolve(String s) [...]
}

