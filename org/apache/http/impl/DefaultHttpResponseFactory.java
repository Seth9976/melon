package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory() {
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog0) {
        throw new RuntimeException("Stub!");
    }

    public Locale determineLocale(HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion0, int v, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine statusLine0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

