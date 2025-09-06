package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultHttpRequestRetryHandlerHC4 implements HttpRequestRetryHandler {
    public static final DefaultHttpRequestRetryHandlerHC4 INSTANCE;
    private final Set nonRetriableClasses;
    private final boolean requestSentRetryEnabled;
    private final int retryCount;

    static {
        DefaultHttpRequestRetryHandlerHC4.INSTANCE = new DefaultHttpRequestRetryHandlerHC4();
    }

    public DefaultHttpRequestRetryHandlerHC4() {
        this(3, false);
    }

    public DefaultHttpRequestRetryHandlerHC4(int v, boolean z) {
        this(v, z, Arrays.asList(new Class[]{InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class}));
    }

    public DefaultHttpRequestRetryHandlerHC4(int v, boolean z, Collection collection0) {
        this.retryCount = v;
        this.requestSentRetryEnabled = z;
        this.nonRetriableClasses = new HashSet();
        for(Object object0: collection0) {
            this.nonRetriableClasses.add(((Class)object0));
        }
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public boolean handleAsIdempotent(HttpRequest httpRequest0) {
        return !(httpRequest0 instanceof HttpEntityEnclosingRequest);
    }

    public boolean isRequestSentRetryEnabled() {
        return this.requestSentRetryEnabled;
    }

    @Deprecated
    public boolean requestIsAborted(HttpRequest httpRequest0) {
        if(httpRequest0 instanceof RequestWrapper) {
            httpRequest0 = ((RequestWrapper)httpRequest0).getOriginal();
        }
        return httpRequest0 instanceof HttpUriRequest && ((HttpUriRequest)httpRequest0).isAborted();
    }

    @Override  // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException0, int v, HttpContext httpContext0) {
        Args.notNull(iOException0, "Exception parameter");
        Args.notNull(httpContext0, "HTTP context");
        if(v > this.retryCount) {
            return false;
        }
        Class class0 = iOException0.getClass();
        if(this.nonRetriableClasses.contains(class0)) {
            return false;
        }
        for(Object object0: this.nonRetriableClasses) {
            if(((Class)object0).isInstance(iOException0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        HttpRequest httpRequest0 = httpClientContext0.getRequest();
        if(this.requestIsAborted(httpRequest0)) {
            return false;
        }
        return this.handleAsIdempotent(httpRequest0) ? true : !httpClientContext0.isRequestSent() || this.requestSentRetryEnabled;
    }
}

