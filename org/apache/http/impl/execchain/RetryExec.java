package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.NoHttpResponseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Immutable
public class RetryExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain0, HttpRequestRetryHandler httpRequestRetryHandler0) {
        Args.notNull(clientExecChain0, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler0, "HTTP request retry handler");
        this.requestExecutor = clientExecChain0;
        this.retryHandler = httpRequestRetryHandler0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        Header[] arr_header = httpRequestWrapper0.getAllHeaders();
        for(int v = 1; true; ++v) {
            try {
                return this.requestExecutor.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
            }
            catch(IOException iOException0) {
            }
            if(httpExecutionAware0 != null && httpExecutionAware0.isAborted()) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Request has been aborted");
                }
                throw iOException0;
            }
            if(!this.retryHandler.retryRequest(iOException0, v, httpClientContext0)) {
                break;
            }
            if(Log.isLoggable("HttpClient", 4)) {
                Log.i("HttpClient", "I/O exception (" + iOException0.getClass().getName() + ") caught when processing request to " + httpRoute0 + ": " + iOException0.getMessage());
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", iOException0.getMessage(), iOException0);
            }
            if(!RequestEntityProxy.isRepeatable(httpRequestWrapper0)) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Cannot retry non-repeatable request");
                }
                new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity").initCause(iOException0);
            }
            httpRequestWrapper0.setHeaders(arr_header);
            if(Log.isLoggable("HttpClient", 4)) {
                Log.i("HttpClient", "Retrying request to " + httpRoute0);
            }
        }
        if(!(iOException0 instanceof NoHttpResponseException)) {
            throw iOException0;
        }
        NoHttpResponseException noHttpResponseException0 = new NoHttpResponseException(httpRoute0.getTargetHost().toHostString() + " failed to respond");
        noHttpResponseException0.setStackTrace(iOException0.getStackTrace());
        throw noHttpResponseException0;
    }
}

