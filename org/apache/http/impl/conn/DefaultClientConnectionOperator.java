package org.apache.http.impl.conn;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionOperator
    public OperatedClientConnection createConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionOperator
    public void openConnection(OperatedClientConnection operatedClientConnection0, HttpHost httpHost0, InetAddress inetAddress0, HttpContext httpContext0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void prepareSocket(Socket socket0, HttpContext httpContext0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection operatedClientConnection0, HttpHost httpHost0, HttpContext httpContext0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }
}

