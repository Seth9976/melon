package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ManagedClientConnection extends HttpClientConnection, HttpInetConnection, ConnectionReleaseTrigger {
    HttpRoute getRoute();

    SSLSession getSSLSession();

    Object getState();

    boolean isMarkedReusable();

    boolean isSecure();

    void layerProtocol(HttpContext arg1, HttpParams arg2);

    void markReusable();

    void open(HttpRoute arg1, HttpContext arg2, HttpParams arg3);

    void setIdleDuration(long arg1, TimeUnit arg2);

    void setState(Object arg1);

    void tunnelProxy(HttpHost arg1, boolean arg2, HttpParams arg3);

    void tunnelTarget(boolean arg1, HttpParams arg2);

    void unmarkReusable();
}

