package org.apache.http.client.methods;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntityHC4;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderGroup;
import org.apache.http.util.Args;

@NotThreadSafe
public class RequestBuilder {
    static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBaseHC4 {
        private final String method;

        public InternalEntityEclosingRequest(String s) {
            this.method = s;
        }

        @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
        public String getMethod() {
            return this.method;
        }
    }

    static class InternalRequest extends HttpRequestBaseHC4 {
        private final String method;

        public InternalRequest(String s) {
            this.method = s;
        }

        @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
        public String getMethod() {
            return this.method;
        }
    }

    private RequestConfig config;
    private HttpEntity entity;
    private HeaderGroup headergroup;
    private String method;
    private LinkedList parameters;
    private URI uri;
    private ProtocolVersion version;

    public RequestBuilder() {
        this(null);
    }

    public RequestBuilder(String s) {
        this.method = s;
    }

    public RequestBuilder addHeader(String s, String s1) {
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(new BasicHeader(s, s1));
        return this;
    }

    public RequestBuilder addHeader(Header header0) {
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(header0);
        return this;
    }

    public RequestBuilder addParameter(String s, String s1) {
        return this.addParameter(new BasicNameValuePair(s, s1));
    }

    public RequestBuilder addParameter(NameValuePair nameValuePair0) {
        Args.notNull(nameValuePair0, "Name value pair");
        if(this.parameters == null) {
            this.parameters = new LinkedList();
        }
        this.parameters.add(nameValuePair0);
        return this;
    }

    public RequestBuilder addParameters(NameValuePair[] arr_nameValuePair) {
        for(int v = 0; v < arr_nameValuePair.length; ++v) {
            this.addParameter(arr_nameValuePair[v]);
        }
        return this;
    }

    public HttpUriRequest build() {
        HttpUriRequest httpUriRequest0;
        URI uRI0 = this.uri == null ? URI.create("/") : this.uri;
        HttpEntity httpEntity0 = this.entity;
        if(this.parameters != null && !this.parameters.isEmpty()) {
            if(httpEntity0 != null || !"POST".equalsIgnoreCase(this.method) && !"PUT".equalsIgnoreCase(this.method)) {
                try {
                    uRI0 = new URIBuilder(uRI0).addParameters(this.parameters).build();
                }
                catch(URISyntaxException unused_ex) {
                }
            }
            else {
                httpEntity0 = new UrlEncodedFormEntityHC4(this.parameters, Charset.forName("ISO-8859-1"));
            }
        }
        if(httpEntity0 == null) {
            httpUriRequest0 = new InternalRequest(this.method);
        }
        else {
            InternalEntityEclosingRequest requestBuilder$InternalEntityEclosingRequest0 = new InternalEntityEclosingRequest(this.method);
            requestBuilder$InternalEntityEclosingRequest0.setEntity(httpEntity0);
            httpUriRequest0 = requestBuilder$InternalEntityEclosingRequest0;
        }
        ((HttpRequestBaseHC4)httpUriRequest0).setProtocolVersion(this.version);
        ((HttpRequestBaseHC4)httpUriRequest0).setURI(uRI0);
        HeaderGroup headerGroup0 = this.headergroup;
        if(headerGroup0 != null) {
            ((AbstractHttpMessage)httpUriRequest0).setHeaders(headerGroup0.getAllHeaders());
        }
        ((HttpRequestBaseHC4)httpUriRequest0).setConfig(this.config);
        return httpUriRequest0;
    }

    public static RequestBuilder copy(HttpRequest httpRequest0) {
        Args.notNull(httpRequest0, "HTTP request");
        return new RequestBuilder().doCopy(httpRequest0);
    }

    public static RequestBuilder create(String s) {
        Args.notBlank(s, "HTTP method");
        return new RequestBuilder(s);
    }

    public static RequestBuilder delete() {
        return new RequestBuilder("DELETE");
    }

    private RequestBuilder doCopy(HttpRequest httpRequest0) {
        if(httpRequest0 == null) {
            return this;
        }
        this.method = httpRequest0.getRequestLine().getMethod();
        this.version = httpRequest0.getRequestLine().getProtocolVersion();
        this.uri = httpRequest0 instanceof HttpUriRequest ? ((HttpUriRequest)httpRequest0).getURI() : URI.create(httpRequest0.getRequestLine().getUri());
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.clear();
        this.headergroup.setHeaders(httpRequest0.getAllHeaders());
        this.entity = httpRequest0 instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest)httpRequest0).getEntity() : null;
        this.config = httpRequest0 instanceof Configurable ? ((Configurable)httpRequest0).getConfig() : null;
        this.parameters = null;
        return this;
    }

    public static RequestBuilder get() {
        return new RequestBuilder("GET");
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public Header getFirstHeader(String s) {
        return this.headergroup == null ? null : this.headergroup.getFirstHeader(s);
    }

    public Header[] getHeaders(String s) {
        return this.headergroup == null ? null : this.headergroup.getHeaders(s);
    }

    public Header getLastHeader(String s) {
        return this.headergroup == null ? null : this.headergroup.getLastHeader(s);
    }

    public String getMethod() {
        return this.method;
    }

    public List getParameters() {
        return this.parameters == null ? new ArrayList() : new ArrayList(this.parameters);
    }

    public URI getUri() {
        return this.uri;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public static RequestBuilder head() {
        return new RequestBuilder("HEAD");
    }

    public static RequestBuilder options() {
        return new RequestBuilder("OPTIONS");
    }

    public static RequestBuilder post() {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder put() {
        return new RequestBuilder("PUT");
    }

    public RequestBuilder removeHeader(Header header0) {
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.removeHeader(header0);
        return this;
    }

    public RequestBuilder removeHeaders(String s) {
        if(s != null) {
            HeaderGroup headerGroup0 = this.headergroup;
            if(headerGroup0 != null) {
                HeaderIterator headerIterator0 = headerGroup0.iterator();
                while(headerIterator0.hasNext()) {
                    if(s.equalsIgnoreCase(headerIterator0.nextHeader().getName())) {
                        headerIterator0.remove();
                    }
                }
            }
        }
        return this;
    }

    public RequestBuilder setConfig(RequestConfig requestConfig0) {
        this.config = requestConfig0;
        return this;
    }

    public RequestBuilder setEntity(HttpEntity httpEntity0) {
        this.entity = httpEntity0;
        return this;
    }

    public RequestBuilder setHeader(String s, String s1) {
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(new BasicHeader(s, s1));
        return this;
    }

    public RequestBuilder setHeader(Header header0) {
        if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(header0);
        return this;
    }

    public RequestBuilder setUri(String s) {
        this.uri = s == null ? null : URI.create(s);
        return this;
    }

    public RequestBuilder setUri(URI uRI0) {
        this.uri = uRI0;
        return this;
    }

    public RequestBuilder setVersion(ProtocolVersion protocolVersion0) {
        this.version = protocolVersion0;
        return this;
    }

    public static RequestBuilder trace() {
        return new RequestBuilder("TRACE");
    }
}

