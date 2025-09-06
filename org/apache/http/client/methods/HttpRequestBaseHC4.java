package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpProtocolParams;

@NotThreadSafe
public abstract class HttpRequestBaseHC4 extends AbstractExecutionAwareRequest implements Configurable, HttpUriRequest {
    private RequestConfig config;
    private URI uri;
    private ProtocolVersion version;

    @Override  // org.apache.http.client.methods.Configurable
    public RequestConfig getConfig() {
        return this.config;
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public abstract String getMethod();

    @Override  // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion0 = this.version;
        return protocolVersion0 == null ? HttpProtocolParams.getVersion(this.getParams()) : protocolVersion0;
    }

    @Override  // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        String s = this.getMethod();
        ProtocolVersion protocolVersion0 = this.getProtocolVersion();
        URI uRI0 = this.getURI();
        String s1 = uRI0 == null ? null : uRI0.toASCIIString();
        if(s1 == null || s1.length() == 0) {
            s1 = "/";
        }
        return new BasicRequestLine(s, s1, protocolVersion0);
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    public void releaseConnection() {
        this.reset();
    }

    public void setConfig(RequestConfig requestConfig0) {
        this.config = requestConfig0;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion0) {
        this.version = protocolVersion0;
    }

    public void setURI(URI uRI0) {
        this.uri = uRI0;
    }

    public void started() {
    }

    @Override
    public String toString() {
        return this.getMethod() + " " + this.getURI() + " " + this.getProtocolVersion();
    }
}

