package org.apache.http.conn.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams httpParams0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRouteBean0) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxTotalConnections(int v) {
        throw new RuntimeException("Stub!");
    }

    public void setTimeout(long v) {
        throw new RuntimeException("Stub!");
    }
}

