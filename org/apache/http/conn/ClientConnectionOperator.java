package org.apache.http.conn;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ClientConnectionOperator {
    OperatedClientConnection createConnection();

    void openConnection(OperatedClientConnection arg1, HttpHost arg2, InetAddress arg3, HttpContext arg4, HttpParams arg5);

    void updateSecureConnection(OperatedClientConnection arg1, HttpHost arg2, HttpContext arg3, HttpParams arg4);
}

