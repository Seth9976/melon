package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import jeb.synthetic.TWR;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

@ThreadSafe
public class RedirectExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain0, HttpRoutePlanner httpRoutePlanner0, RedirectStrategy redirectStrategy0) {
        Args.notNull(clientExecChain0, "HTTP client request executor");
        Args.notNull(httpRoutePlanner0, "HTTP route planner");
        Args.notNull(redirectStrategy0, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain0;
        this.routePlanner = httpRoutePlanner0;
        this.redirectStrategy = redirectStrategy0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        CloseableHttpResponse closeableHttpResponse0;
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        List list0 = httpClientContext0.getRedirectLocations();
        if(list0 != null) {
            list0.clear();
        }
        RequestConfig requestConfig0 = httpClientContext0.getRequestConfig();
        int v = requestConfig0.getMaxRedirects() <= 0 ? 50 : requestConfig0.getMaxRedirects();
        int v1 = 0;
        HttpRequestWrapper httpRequestWrapper1 = httpRequestWrapper0;
        while(true) {
            closeableHttpResponse0 = this.requestExecutor.execute(httpRoute0, httpRequestWrapper1, httpClientContext0, httpExecutionAware0);
            try {
                if(!requestConfig0.isRedirectsEnabled() || !this.redirectStrategy.isRedirected(httpRequestWrapper1, closeableHttpResponse0, httpClientContext0)) {
                    return closeableHttpResponse0;
                }
                if(v1 >= v) {
                    throw new RedirectException("Maximum redirects (" + v + ") exceeded");
                }
                ++v1;
                HttpUriRequest httpUriRequest0 = this.redirectStrategy.getRedirect(httpRequestWrapper1, closeableHttpResponse0, httpClientContext0);
                if(!httpUriRequest0.headerIterator().hasNext()) {
                    httpUriRequest0.setHeaders(httpRequestWrapper0.getOriginal().getAllHeaders());
                }
                httpRequestWrapper1 = HttpRequestWrapper.wrap(httpUriRequest0);
                if(httpRequestWrapper1 instanceof HttpEntityEnclosingRequest) {
                    RequestEntityProxy.enhance(((HttpEntityEnclosingRequest)httpRequestWrapper1));
                }
                URI uRI0 = httpRequestWrapper1.getURI();
                HttpHost httpHost0 = URIUtilsHC4.extractHost(uRI0);
                if(httpHost0 == null) {
                    throw new ProtocolException("Redirect URI does not specify a valid host name: " + uRI0);
                }
                if(!httpRoute0.getTargetHost().equals(httpHost0)) {
                    AuthStateHC4 authStateHC40 = httpClientContext0.getTargetAuthState();
                    if(authStateHC40 != null) {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Resetting target auth state");
                        }
                        authStateHC40.reset();
                    }
                    AuthStateHC4 authStateHC41 = httpClientContext0.getProxyAuthState();
                    if(authStateHC41 != null) {
                        AuthScheme authScheme0 = authStateHC41.getAuthScheme();
                        if(authScheme0 != null && authScheme0.isConnectionBased()) {
                            if(Log.isLoggable("HttpClient", 3)) {
                                Log.d("HttpClient", "Resetting proxy auth state");
                            }
                            authStateHC41.reset();
                        }
                    }
                }
                httpRoute0 = this.routePlanner.determineRoute(httpHost0, httpRequestWrapper1, httpClientContext0);
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Redirecting to \'" + uRI0 + "\' via " + httpRoute0);
                }
                EntityUtilsHC4.consume(closeableHttpResponse0.getEntity());
                closeableHttpResponse0.close();
                continue;
            label_46:
                goto label_53;
            }
            catch(RuntimeException runtimeException0) {
                break;
            }
            catch(IOException iOException0) {
                goto label_51;
            }
            catch(HttpException httpException0) {
                goto label_46;
            }
        }
        TWR.safeClose$NT(closeableHttpResponse0, runtimeException0);
        throw runtimeException0;
    label_51:
        TWR.safeClose$NT(closeableHttpResponse0, iOException0);
        throw iOException0;
        try {
            try {
            label_53:
                EntityUtilsHC4.consume(closeableHttpResponse0.getEntity());
            }
            catch(IOException iOException1) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "I/O error while releasing connection", iOException1);
                }
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(closeableHttpResponse0, throwable0);
            throw throwable0;
        }
        closeableHttpResponse0.close();
        throw httpException0;
    }
}

