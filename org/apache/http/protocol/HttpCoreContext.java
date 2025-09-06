package org.apache.http.protocol;

import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class HttpCoreContext implements HttpContext {
    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public HttpCoreContext() {
        this.context = new BasicHttpContextHC4();
    }

    public HttpCoreContext(HttpContext httpContext0) {
        this.context = httpContext0;
    }

    public static HttpCoreContext adapt(HttpContext httpContext0) {
        Args.notNull(httpContext0, "HTTP context");
        return httpContext0 instanceof HttpCoreContext ? ((HttpCoreContext)httpContext0) : new HttpCoreContext(httpContext0);
    }

    public static HttpCoreContext create() {
        return new HttpCoreContext(new BasicHttpContextHC4());
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object getAttribute(String s) {
        return this.context.getAttribute(s);
    }

    public Object getAttribute(String s, Class class0) {
        Args.notNull(class0, "Attribute class");
        Object object0 = this.getAttribute(s);
        return object0 == null ? null : class0.cast(object0);
    }

    public HttpConnection getConnection() {
        return (HttpConnection)this.getAttribute("http.connection", HttpConnection.class);
    }

    public HttpConnection getConnection(Class class0) {
        return (HttpConnection)this.getAttribute("http.connection", class0);
    }

    public HttpRequest getRequest() {
        return (HttpRequest)this.getAttribute("http.request", HttpRequest.class);
    }

    public HttpResponse getResponse() {
        return (HttpResponse)this.getAttribute("http.response", HttpResponse.class);
    }

    public HttpHost getTargetHost() {
        return (HttpHost)this.getAttribute("http.target_host", HttpHost.class);
    }

    public boolean isRequestSent() {
        Boolean boolean0 = (Boolean)this.getAttribute("http.request_sent", Boolean.class);
        return boolean0 != null && boolean0.booleanValue();
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String s) {
        return this.context.removeAttribute(s);
    }

    @Override  // org.apache.http.protocol.HttpContext
    public void setAttribute(String s, Object object0) {
        this.context.setAttribute(s, object0);
    }

    public void setTargetHost(HttpHost httpHost0) {
        this.setAttribute("http.target_host", httpHost0);
    }
}

