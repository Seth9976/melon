package org.apache.http.conn.socket;

import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HttpContext;

public interface ConnectionSocketFactory {
    Socket connectSocket(int arg1, Socket arg2, HttpHost arg3, InetSocketAddress arg4, InetSocketAddress arg5, HttpContext arg6);

    Socket createSocket(HttpContext arg1);
}

