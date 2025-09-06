package org.apache.http.conn.scheme;

import java.net.Socket;

@Deprecated
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket arg1, String arg2, int arg3, boolean arg4);
}

