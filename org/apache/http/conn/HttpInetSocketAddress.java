package org.apache.http.conn;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.apache.http.util.Args;

@Deprecated
public class HttpInetSocketAddress extends InetSocketAddress {
    private final HttpHost httphost;
    private static final long serialVersionUID = 0xA3B3F5EC8D72910BL;

    public HttpInetSocketAddress(HttpHost httpHost0, InetAddress inetAddress0, int v) {
        super(inetAddress0, v);
        Args.notNull(httpHost0, "HTTP host");
        this.httphost = httpHost0;
    }

    public HttpHost getHttpHost() {
        return this.httphost;
    }

    @Override
    public String toString() {
        return this.httphost.getHostName() + ":" + this.getPort();
    }
}

