package org.apache.http.impl.client;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;

@Deprecated
public class TunnelRefusedException extends HttpException {
    public TunnelRefusedException(String s, HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse getResponse() {
        throw new RuntimeException("Stub!");
    }
}

