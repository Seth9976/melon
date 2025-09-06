package org.apache.http.conn.scheme;

import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public interface SchemeSocketFactory {
    Socket connectSocket(Socket arg1, InetSocketAddress arg2, InetSocketAddress arg3, HttpParams arg4);

    Socket createSocket(HttpParams arg1);

    boolean isSecure(Socket arg1);
}

