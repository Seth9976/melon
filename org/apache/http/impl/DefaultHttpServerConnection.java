package org.apache.http.impl;

import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public class DefaultHttpServerConnection extends SocketHttpServerConnection {
    public DefaultHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpServerConnection
    public void bind(Socket socket0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

