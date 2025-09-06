package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultHttpResponseFactoryHC4 implements HttpResponseFactory {
    public static final DefaultHttpResponseFactoryHC4 INSTANCE;
    protected final ReasonPhraseCatalog reasonCatalog;

    static {
        DefaultHttpResponseFactoryHC4.INSTANCE = new DefaultHttpResponseFactoryHC4();
    }

    public DefaultHttpResponseFactoryHC4() {
        this(EnglishReasonPhraseCatalogHC4.INSTANCE);
    }

    public DefaultHttpResponseFactoryHC4(ReasonPhraseCatalog reasonPhraseCatalog0) {
        this.reasonCatalog = (ReasonPhraseCatalog)Args.notNull(reasonPhraseCatalog0, "Reason phrase catalog");
    }

    public Locale determineLocale(HttpContext httpContext0) {
        return Locale.getDefault();
    }

    @Override  // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion0, int v, HttpContext httpContext0) {
        Args.notNull(protocolVersion0, "HTTP version");
        Locale locale0 = this.determineLocale(httpContext0);
        return new BasicHttpResponse(new BasicStatusLine(protocolVersion0, v, this.reasonCatalog.getReason(v, locale0)), this.reasonCatalog, locale0);
    }

    @Override  // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine statusLine0, HttpContext httpContext0) {
        Args.notNull(statusLine0, "Status line");
        Locale locale0 = this.determineLocale(httpContext0);
        return new BasicHttpResponse(statusLine0, this.reasonCatalog, locale0);
    }
}

