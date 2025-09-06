package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnRouteParamBean extends HttpAbstractParamBean {
    public ConnRouteParamBean(HttpParams httpParams0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public void setDefaultProxy(HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    public void setForcedRoute(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public void setLocalAddress(InetAddress inetAddress0) {
        throw new RuntimeException("Stub!");
    }
}

