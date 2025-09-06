package org.apache.http.protocol;

import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class RequestTargetHostHC4 implements HttpRequestInterceptor {
    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        HttpCoreContext httpCoreContext0 = HttpCoreContext.adapt(httpContext0);
        ProtocolVersion protocolVersion0 = httpRequest0.getRequestLine().getProtocolVersion();
        if((!httpRequest0.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !protocolVersion0.lessEquals(HttpVersion.HTTP_1_0)) && !httpRequest0.containsHeader("Host")) {
            HttpHost httpHost0 = httpCoreContext0.getTargetHost();
            if(httpHost0 == null) {
                HttpConnection httpConnection0 = httpCoreContext0.getConnection();
                if(httpConnection0 instanceof HttpInetConnection) {
                    InetAddress inetAddress0 = ((HttpInetConnection)httpConnection0).getRemoteAddress();
                    int v = ((HttpInetConnection)httpConnection0).getRemotePort();
                    if(inetAddress0 != null) {
                        httpHost0 = new HttpHost(inetAddress0.getHostName(), v);
                    }
                }
                if(httpHost0 != null) {
                    httpRequest0.addHeader("Host", httpHost0.toHostString());
                }
                else if(!protocolVersion0.lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Target host missing");
                }
            }
            else {
                httpRequest0.addHeader("Host", httpHost0.toHostString());
            }
        }
    }
}

