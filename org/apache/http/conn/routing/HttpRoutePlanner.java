package org.apache.http.conn.routing;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpRoutePlanner {
    HttpRoute determineRoute(HttpHost arg1, HttpRequest arg2, HttpContext arg3);
}

