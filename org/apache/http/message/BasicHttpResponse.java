package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;

@Deprecated
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    public BasicHttpResponse(ProtocolVersion protocolVersion0, int v, String s) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpResponse(StatusLine statusLine0) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpResponse(StatusLine statusLine0, ReasonPhraseCatalog reasonPhraseCatalog0, Locale locale0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public Locale getLocale() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    public String getReason(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public StatusLine getStatusLine() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setEntity(HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setLocale(Locale locale0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setReasonPhrase(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusCode(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion0, int v, String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(StatusLine statusLine0) {
        throw new RuntimeException("Stub!");
    }
}

