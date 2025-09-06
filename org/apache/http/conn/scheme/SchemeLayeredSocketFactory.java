package org.apache.http.conn.scheme;

import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public interface SchemeLayeredSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket arg1, String arg2, int arg3, HttpParams arg4);
}

