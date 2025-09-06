package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

@Deprecated
public interface HttpRequestHandler {
    void handle(HttpRequest arg1, HttpResponse arg2, HttpContext arg3);
}

