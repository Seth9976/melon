package org.apache.http;

import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse arg1, HttpContext arg2);
}

