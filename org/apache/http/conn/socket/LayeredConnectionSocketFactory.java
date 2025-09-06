package org.apache.http.conn.socket;

import java.net.Socket;
import org.apache.http.protocol.HttpContext;

public interface LayeredConnectionSocketFactory extends ConnectionSocketFactory {
    Socket createLayeredSocket(Socket arg1, String arg2, int arg3, HttpContext arg4);
}

