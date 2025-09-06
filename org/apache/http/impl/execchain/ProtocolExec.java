package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import jeb.synthetic.TWR;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.BasicCredentialsProviderHC4;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.util.Args;

@Immutable
public class ProtocolExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final HttpProcessor httpProcessor;
    private final ClientExecChain requestExecutor;

    public ProtocolExec(ClientExecChain clientExecChain0, HttpProcessor httpProcessor0) {
        Args.notNull(clientExecChain0, "HTTP client request executor");
        Args.notNull(httpProcessor0, "HTTP protocol processor");
        this.requestExecutor = clientExecChain0;
        this.httpProcessor = httpProcessor0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        URI uRI0;
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        HttpRequest httpRequest0 = httpRequestWrapper0.getOriginal();
        HttpHost httpHost0 = null;
        if(httpRequest0 instanceof HttpUriRequest) {
            uRI0 = ((HttpUriRequest)httpRequest0).getURI();
        }
        else {
            String s = httpRequest0.getRequestLine().getUri();
            try {
                uRI0 = URI.create(s);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Unable to parse \'" + s + "\' as a valid URI; request URI and Host header may be inconsistent", illegalArgumentException0);
                }
                uRI0 = null;
            }
        }
        httpRequestWrapper0.setURI(uRI0);
        this.rewriteRequestURI(httpRequestWrapper0, httpRoute0);
        HttpHost httpHost1 = (HttpHost)httpRequestWrapper0.getParams().getParameter("http.virtual-host");
        if(httpHost1 != null && httpHost1.getPort() == -1) {
            int v = httpRoute0.getTargetHost().getPort();
            if(v != -1) {
                httpHost1 = new HttpHost(httpHost1.getHostName(), v, httpHost1.getSchemeName());
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Using virtual host" + httpHost1);
            }
        }
        if(httpHost1 != null) {
            httpHost0 = httpHost1;
        }
        else if(uRI0 != null && uRI0.isAbsolute() && uRI0.getHost() != null) {
            httpHost0 = new HttpHost(uRI0.getHost(), uRI0.getPort(), uRI0.getScheme());
        }
        if(httpHost0 == null) {
            httpHost0 = httpRoute0.getTargetHost();
        }
        if(uRI0 != null) {
            String s1 = uRI0.getUserInfo();
            if(s1 != null) {
                CredentialsProvider credentialsProvider0 = httpClientContext0.getCredentialsProvider();
                if(credentialsProvider0 == null) {
                    credentialsProvider0 = new BasicCredentialsProviderHC4();
                    httpClientContext0.setCredentialsProvider(credentialsProvider0);
                }
                credentialsProvider0.setCredentials(new AuthScope(httpHost0.getHostName(), httpHost0.getPort()), new UsernamePasswordCredentials(s1));
            }
        }
        httpClientContext0.setAttribute("http.target_host", httpHost0);
        httpClientContext0.setAttribute("http.route", httpRoute0);
        httpClientContext0.setAttribute("http.request", httpRequestWrapper0);
        this.httpProcessor.process(httpRequestWrapper0, httpClientContext0);
        CloseableHttpResponse closeableHttpResponse0 = this.requestExecutor.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
        try {
            httpClientContext0.setAttribute("http.response", closeableHttpResponse0);
            this.httpProcessor.process(closeableHttpResponse0, httpClientContext0);
            return closeableHttpResponse0;
        }
        catch(RuntimeException runtimeException0) {
            TWR.safeClose$NT(closeableHttpResponse0, runtimeException0);
            throw runtimeException0;
        }
        catch(IOException iOException0) {
            TWR.safeClose$NT(closeableHttpResponse0, iOException0);
            throw iOException0;
        }
        catch(HttpException httpException0) {
            TWR.safeClose$NT(closeableHttpResponse0, httpException0);
            throw httpException0;
        }
    }

    public void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper0, HttpRoute httpRoute0) {
        URI uRI1;
        try {
            URI uRI0 = httpRequestWrapper0.getURI();
            if(uRI0 != null) {
                if(httpRoute0.getProxyHost() == null || httpRoute0.isTunnelled()) {
                    uRI1 = uRI0.isAbsolute() ? URIUtilsHC4.rewriteURI(uRI0, null, true) : URIUtilsHC4.rewriteURI(uRI0);
                }
                else if(!uRI0.isAbsolute()) {
                    uRI1 = URIUtilsHC4.rewriteURI(uRI0, httpRoute0.getTargetHost(), true);
                }
                else {
                    uRI1 = URIUtilsHC4.rewriteURI(uRI0);
                }
                httpRequestWrapper0.setURI(uRI1);
            }
            return;
        }
        catch(URISyntaxException uRISyntaxException0) {
        }
        throw new ProtocolException("Invalid URI: " + httpRequestWrapper0.getRequestLine().getUri(), uRISyntaxException0);
    }
}

