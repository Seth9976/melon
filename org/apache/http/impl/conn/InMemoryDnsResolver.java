package org.apache.http.impl.conn;

import android.util.Log;
import com.iloen.melon.utils.a;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.conn.DnsResolver;
import org.apache.http.util.Args;

public class InMemoryDnsResolver implements DnsResolver {
    private static final String TAG = "HttpClient";
    private final Map dnsMap;

    public InMemoryDnsResolver() {
        this.dnsMap = new ConcurrentHashMap();
    }

    public void add(String s, InetAddress[] arr_inetAddress) {
        Args.notNull(s, "Host name");
        Args.notNull(arr_inetAddress, "Array of IP addresses");
        this.dnsMap.put(s, arr_inetAddress);
    }

    @Override  // org.apache.http.conn.DnsResolver
    public InetAddress[] resolve(String s) {
        InetAddress[] arr_inetAddress = (InetAddress[])this.dnsMap.get(s);
        if(Log.isLoggable("HttpClient", 4)) {
            StringBuilder stringBuilder0 = a.n("Resolving ", s, " to ");
            stringBuilder0.append(Arrays.deepToString(arr_inetAddress));
            Log.i("HttpClient", stringBuilder0.toString());
        }
        if(arr_inetAddress == null) {
            throw new UnknownHostException(s + " cannot be resolved");
        }
        return arr_inetAddress;
    }
}

