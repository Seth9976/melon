package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.protocol.HttpContext;

@Immutable
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    public SystemDefaultRoutePlanner(ProxySelector proxySelector0) {
        this(null, proxySelector0);
    }

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver0, ProxySelector proxySelector0) {
        super(schemePortResolver0);
        if(proxySelector0 == null) {
            proxySelector0 = ProxySelector.getDefault();
        }
        this.proxySelector = proxySelector0;
    }

    private Proxy chooseProxy(List list0) {
        Proxy proxy0 = null;
        for(int v = 0; proxy0 == null && v < list0.size(); ++v) {
            Proxy proxy1 = (Proxy)list0.get(v);
            switch(org.apache.http.impl.conn.SystemDefaultRoutePlanner.1.$SwitchMap$java$net$Proxy$Type[proxy1.type().ordinal()]) {
                case 1: 
                case 2: {
                    proxy0 = proxy1;
                }
            }
        }
        return proxy0 == null ? Proxy.NO_PROXY : proxy0;
    }

    @Override  // org.apache.http.impl.conn.DefaultRoutePlanner
    public HttpHost determineProxy(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        URI uRI0;
        try {
            uRI0 = new URI(httpHost0.toURI());
        }
        catch(URISyntaxException uRISyntaxException0) {
            throw new HttpException("Cannot convert host to URI: " + httpHost0, uRISyntaxException0);
        }
        Proxy proxy0 = this.chooseProxy(this.proxySelector.select(uRI0));
        if(proxy0.type() == Proxy.Type.HTTP) {
            if(!(proxy0.address() instanceof InetSocketAddress)) {
                throw new HttpException("Unable to handle non-Inet proxy address: " + proxy0.address());
            }
            InetSocketAddress inetSocketAddress0 = (InetSocketAddress)proxy0.address();
            return new HttpHost(this.getHost(inetSocketAddress0), inetSocketAddress0.getPort());
        }
        return null;
    }

    // 去混淆评级： 低(20)
    private String getHost(InetSocketAddress inetSocketAddress0) {
        return inetSocketAddress0.isUnresolved() ? inetSocketAddress0.getHostName() : inetSocketAddress0.getAddress().getHostAddress();
    }

    class org.apache.http.impl.conn.SystemDefaultRoutePlanner.1 {
        static final int[] $SwitchMap$java$net$Proxy$Type;

        static {
            int[] arr_v = new int[Proxy.Type.values().length];
            org.apache.http.impl.conn.SystemDefaultRoutePlanner.1.$SwitchMap$java$net$Proxy$Type = arr_v;
            try {
                arr_v[Proxy.Type.DIRECT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.apache.http.impl.conn.SystemDefaultRoutePlanner.1.$SwitchMap$java$net$Proxy$Type[Proxy.Type.HTTP.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.apache.http.impl.conn.SystemDefaultRoutePlanner.1.$SwitchMap$java$net$Proxy$Type[Proxy.Type.SOCKS.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

