package org.apache.http.impl.execchain;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;

@Immutable
public class TunnelRefusedException extends HttpException {
    private final HttpResponse response;
    private static final long serialVersionUID = 0x8800AB6306E44455L;

    public TunnelRefusedException(String s, HttpResponse httpResponse0) {
        super(s);
        this.response = httpResponse0;
    }

    public HttpResponse getResponse() {
        return this.response;
    }
}

