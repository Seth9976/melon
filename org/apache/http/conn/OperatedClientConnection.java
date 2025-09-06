package org.apache.http.conn;

import java.net.Socket;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.params.HttpParams;

@Deprecated
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
    Socket getSocket();

    HttpHost getTargetHost();

    boolean isSecure();

    void openCompleted(boolean arg1, HttpParams arg2);

    void opening(Socket arg1, HttpHost arg2);

    void update(Socket arg1, HttpHost arg2, boolean arg3, HttpParams arg4);
}

