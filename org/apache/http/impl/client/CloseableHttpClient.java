package org.apache.http.impl.client;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

@ThreadSafe
public abstract class CloseableHttpClient implements Closeable, HttpClient {
    private static final String TAG = "HttpClient";

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest0) {
        URI uRI0 = httpUriRequest0.getURI();
        if(uRI0.isAbsolute()) {
            HttpHost httpHost0 = URIUtilsHC4.extractHost(uRI0);
            if(httpHost0 == null) {
                throw new ClientProtocolException("URI does not specify a valid host name: " + uRI0);
            }
            return httpHost0;
        }
        return null;
    }

    public abstract CloseableHttpResponse doExecute(HttpHost arg1, HttpRequest arg2, HttpContext arg3);

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0) {
        return this.execute(httpHost0, httpRequest0, responseHandler0, null);
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        Object object0;
        Args.notNull(responseHandler0, "Response handler");
        CloseableHttpResponse closeableHttpResponse0 = this.execute(httpHost0, httpRequest0, httpContext0);
        try {
            object0 = responseHandler0.handleResponse(closeableHttpResponse0);
        }
        catch(Exception exception0) {
            HttpEntity httpEntity0 = closeableHttpResponse0.getEntity();
            try {
                EntityUtilsHC4.consume(httpEntity0);
            }
            catch(Exception exception1) {
                if(Log.isLoggable("HttpClient", 5)) {
                    Log.w("HttpClient", "Error consuming content after an exception.", exception1);
                }
            }
            if(exception0 instanceof RuntimeException) {
                throw (RuntimeException)exception0;
            }
            if(exception0 instanceof IOException) {
                throw (IOException)exception0;
            }
            throw new UndeclaredThrowableException(exception0);
        }
        EntityUtilsHC4.consume(closeableHttpResponse0.getEntity());
        return object0;
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0) {
        return this.execute(httpUriRequest0, responseHandler0, null);
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        return this.execute(CloseableHttpClient.determineTarget(httpUriRequest0), httpUriRequest0, responseHandler0, httpContext0);
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0) {
        return this.execute(httpHost0, httpRequest0);
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return this.execute(httpHost0, httpRequest0, httpContext0);
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest0) {
        return this.execute(httpUriRequest0);
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0) {
        return this.execute(httpUriRequest0, httpContext0);
    }

    public CloseableHttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0) {
        return this.doExecute(httpHost0, httpRequest0, null);
    }

    public CloseableHttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return this.doExecute(httpHost0, httpRequest0, httpContext0);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest0) {
        return this.execute(httpUriRequest0, null);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0) {
        Args.notNull(httpUriRequest0, "HTTP request");
        return this.doExecute(CloseableHttpClient.determineTarget(httpUriRequest0), httpUriRequest0, httpContext0);
    }
}

