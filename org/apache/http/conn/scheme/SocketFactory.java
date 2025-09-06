package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

public interface SocketFactory {
    Socket connectSocket(Socket arg1, String arg2, int arg3, InetAddress arg4, int arg5, HttpParams arg6);

    Socket createSocket();

    boolean isSecure(Socket arg1);
}

