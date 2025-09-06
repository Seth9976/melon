package org.apache.http;

import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion arg1, int arg2, HttpContext arg3);

    HttpResponse newHttpResponse(StatusLine arg1, HttpContext arg2);
}

