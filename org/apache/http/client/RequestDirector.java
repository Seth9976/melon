package org.apache.http.client;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface RequestDirector {
    HttpResponse execute(HttpHost arg1, HttpRequest arg2, HttpContext arg3);
}

