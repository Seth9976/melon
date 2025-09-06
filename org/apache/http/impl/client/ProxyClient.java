package org.apache.http.impl.client;

import java.net.Socket;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo.LayerType;
import org.apache.http.conn.routing.RouteInfo.TunnelType;
import org.apache.http.entity.BufferedHttpEntityHC4;
import org.apache.http.impl.DefaultConnectionReuseStrategyHC4;
import org.apache.http.impl.auth.BasicSchemeFactoryHC4;
import org.apache.http.impl.auth.DigestSchemeFactoryHC4;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.protocol.RequestUserAgentHC4;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final HttpAuthenticator authenticator;
    private final HttpConnectionFactory connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthStateHC4 proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient() {
        this(null, null, null);
    }

    public ProxyClient(RequestConfig requestConfig0) {
        this(null, null, requestConfig0);
    }

    public ProxyClient(HttpConnectionFactory httpConnectionFactory0, ConnectionConfig connectionConfig0, RequestConfig requestConfig0) {
        if(httpConnectionFactory0 == null) {
            httpConnectionFactory0 = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        this.connFactory = httpConnectionFactory0;
        if(connectionConfig0 == null) {
            connectionConfig0 = ConnectionConfig.DEFAULT;
        }
        this.connectionConfig = connectionConfig0;
        if(requestConfig0 == null) {
            requestConfig0 = RequestConfig.DEFAULT;
        }
        this.requestConfig = requestConfig0;
        this.httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestTargetHostHC4(), new RequestClientConnControl(), new RequestUserAgentHC4()});
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new HttpAuthenticator();
        this.proxyAuthState = new AuthStateHC4();
        AuthSchemeRegistry authSchemeRegistry0 = new AuthSchemeRegistry();
        this.authSchemeRegistry = authSchemeRegistry0;
        authSchemeRegistry0.register("Basic", new BasicSchemeFactoryHC4());
        authSchemeRegistry0.register("Digest", new DigestSchemeFactoryHC4());
        authSchemeRegistry0.register("NTLM", new NTLMSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategyHC4();
    }

    @Deprecated
    public ProxyClient(HttpParams httpParams0) {
        this(null, HttpParamConfig.getConnectionConfig(httpParams0), HttpClientParamConfig.getRequestConfig(httpParams0));
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    public Socket tunnel(HttpHost httpHost0, HttpHost httpHost1, Credentials credentials0) {
        HttpResponse httpResponse0;
        Args.notNull(httpHost0, "Proxy host");
        Args.notNull(httpHost1, "Target host");
        Args.notNull(credentials0, "Credentials");
        HttpHost httpHost2 = httpHost1.getPort() > 0 ? httpHost1 : new HttpHost(httpHost1.getHostName(), 80, httpHost1.getSchemeName());
        HttpRoute httpRoute0 = new HttpRoute(httpHost2, this.requestConfig.getLocalAddress(), httpHost0, false, TunnelType.TUNNELLED, LayerType.PLAIN);
        ManagedHttpClientConnection managedHttpClientConnection0 = (ManagedHttpClientConnection)this.connFactory.create(httpRoute0, this.connectionConfig);
        BasicHttpContextHC4 basicHttpContextHC40 = new BasicHttpContextHC4();
        BasicHttpRequest basicHttpRequest0 = new BasicHttpRequest("CONNECT", httpHost2.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProviderHC4 basicCredentialsProviderHC40 = new BasicCredentialsProviderHC4();
        basicCredentialsProviderHC40.setCredentials(new AuthScope(httpHost0.getHostName(), httpHost0.getPort()), credentials0);
        basicHttpContextHC40.setAttribute("http.target_host", httpHost1);
        basicHttpContextHC40.setAttribute("http.connection", managedHttpClientConnection0);
        basicHttpContextHC40.setAttribute("http.request", basicHttpRequest0);
        basicHttpContextHC40.setAttribute("http.route", httpRoute0);
        basicHttpContextHC40.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        basicHttpContextHC40.setAttribute("http.auth.credentials-provider", basicCredentialsProviderHC40);
        basicHttpContextHC40.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        basicHttpContextHC40.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(basicHttpRequest0, this.httpProcessor, basicHttpContextHC40);
        while(true) {
            if(!managedHttpClientConnection0.isOpen()) {
                managedHttpClientConnection0.bind(new Socket(httpHost0.getHostName(), httpHost0.getPort()));
            }
            this.authenticator.generateAuthResponse(basicHttpRequest0, this.proxyAuthState, basicHttpContextHC40);
            httpResponse0 = this.requestExec.execute(basicHttpRequest0, managedHttpClientConnection0, basicHttpContextHC40);
            if(httpResponse0.getStatusLine().getStatusCode() < 200) {
                break;
            }
            if(this.authenticator.isAuthenticationRequested(httpHost0, httpResponse0, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContextHC40) && this.authenticator.handleAuthChallenge(httpHost0, httpResponse0, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContextHC40)) {
                if(this.reuseStrategy.keepAlive(httpResponse0, basicHttpContextHC40)) {
                    EntityUtilsHC4.consume(httpResponse0.getEntity());
                }
                else {
                    managedHttpClientConnection0.close();
                }
                basicHttpRequest0.removeHeaders("Proxy-Authorization");
                continue;
            }
            if(httpResponse0.getStatusLine().getStatusCode() > 299) {
                HttpEntity httpEntity0 = httpResponse0.getEntity();
                if(httpEntity0 != null) {
                    httpResponse0.setEntity(new BufferedHttpEntityHC4(httpEntity0));
                }
                managedHttpClientConnection0.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse0.getStatusLine(), httpResponse0);
            }
            return managedHttpClientConnection0.getSocket();
        }
        throw new HttpException("Unexpected response to CONNECT request: " + httpResponse0.getStatusLine());
    }
}

