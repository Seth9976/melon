package org.apache.http.conn;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ConnectionKeepAliveStrategy {
    long getKeepAliveDuration(HttpResponse arg1, HttpContext arg2);
}

