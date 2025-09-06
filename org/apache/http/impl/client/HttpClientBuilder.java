package org.apache.http.impl.client;

import android.net.SSLCertificateSocketFactory;
import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.RequestAddCookiesHC4;
import org.apache.http.client.protocol.RequestAuthCache;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.protocol.RequestDefaultHeadersHC4;
import org.apache.http.client.protocol.RequestExpectContinue;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.protocol.ResponseProcessCookiesHC4;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.DefaultConnectionReuseStrategyHC4;
import org.apache.http.impl.auth.BasicSchemeFactoryHC4;
import org.apache.http.impl.auth.DigestSchemeFactoryHC4;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.impl.cookie.BestMatchSpecFactoryHC4;
import org.apache.http.impl.cookie.BrowserCompatSpecFactoryHC4;
import org.apache.http.impl.cookie.IgnoreSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactoryHC4;
import org.apache.http.impl.cookie.RFC2109SpecFactoryHC4;
import org.apache.http.impl.cookie.RFC2965SpecFactoryHC4;
import org.apache.http.impl.execchain.BackoffStrategyExec;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.impl.execchain.ProtocolExec;
import org.apache.http.impl.execchain.RedirectExec;
import org.apache.http.impl.execchain.RetryExec;
import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestContentHC4;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.protocol.RequestUserAgentHC4;
import org.apache.http.util.TextUtils;
import org.apache.http.util.VersionInfoHC4;

@NotThreadSafe
public class HttpClientBuilder {
    static final String DEFAULT_USER_AGENT;
    private boolean authCachingDisabled;
    private Lookup authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List closeables;
    private HttpClientConnectionManager connManager;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private boolean cookieManagementDisabled;
    private Lookup cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private X509HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private int maxConnPerRoute;
    private int maxConnTotal;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList requestFirst;
    private LinkedList requestLast;
    private LinkedList responseFirst;
    private LinkedList responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private SSLContext sslcontext;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;

    // 去混淆评级： 低(20)
    static {
        boolean z = VersionInfoHC4.loadVersionInfo("org.apache.http.client", HttpClientBuilder.class.getClassLoader()) == null;
        HttpClientBuilder.DEFAULT_USER_AGENT = "Apache-HttpClient/UNAVAILABLE (java 1.5)";
    }

    public HttpClientBuilder() {
        this.maxConnTotal = 0;
        this.maxConnPerRoute = 0;
    }

    public void addCloseable(Closeable closeable0) {
        if(closeable0 == null) {
            return;
        }
        if(this.closeables == null) {
            this.closeables = new ArrayList();
        }
        this.closeables.add(closeable0);
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor0) {
        if(httpRequestInterceptor0 == null) {
            return this;
        }
        if(this.requestFirst == null) {
            this.requestFirst = new LinkedList();
        }
        this.requestFirst.addFirst(httpRequestInterceptor0);
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor0) {
        if(httpResponseInterceptor0 == null) {
            return this;
        }
        if(this.responseFirst == null) {
            this.responseFirst = new LinkedList();
        }
        this.responseFirst.addFirst(httpResponseInterceptor0);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor0) {
        if(httpRequestInterceptor0 == null) {
            return this;
        }
        if(this.requestLast == null) {
            this.requestLast = new LinkedList();
        }
        this.requestLast.addLast(httpRequestInterceptor0);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor0) {
        if(httpResponseInterceptor0 == null) {
            return this;
        }
        if(this.responseLast == null) {
            this.responseLast = new LinkedList();
        }
        this.responseLast.addLast(httpResponseInterceptor0);
        return this;
    }

    public CloseableHttpClient build() {
        HttpClientConnectionManager httpClientConnectionManager1;
        HttpRequestExecutor httpRequestExecutor0 = this.requestExec == null ? new HttpRequestExecutor() : this.requestExec;
        HttpClientConnectionManager httpClientConnectionManager0 = this.connManager;
        ArrayList arrayList0 = null;
        if(httpClientConnectionManager0 == null) {
            LayeredConnectionSocketFactory layeredConnectionSocketFactory0 = this.sslSocketFactory;
            if(layeredConnectionSocketFactory0 == null) {
                String[] arr_s = this.systemProperties ? HttpClientBuilder.split(System.getProperty("https.protocols")) : null;
                String[] arr_s1 = this.systemProperties ? HttpClientBuilder.split(System.getProperty("https.cipherSuites")) : null;
                X509HostnameVerifier x509HostnameVerifier0 = this.hostnameVerifier == null ? SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER : this.hostnameVerifier;
                if(this.sslcontext != null) {
                    layeredConnectionSocketFactory0 = new SSLConnectionSocketFactory(this.sslcontext, arr_s, arr_s1, x509HostnameVerifier0);
                }
                else if(this.systemProperties) {
                    layeredConnectionSocketFactory0 = new SSLConnectionSocketFactory(((SSLSocketFactory)SSLCertificateSocketFactory.getDefault(0)), arr_s, arr_s1, x509HostnameVerifier0);
                }
            }
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager0 = new PoolingHttpClientConnectionManager(RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", layeredConnectionSocketFactory0).build());
            SocketConfig socketConfig0 = this.defaultSocketConfig;
            if(socketConfig0 != null) {
                poolingHttpClientConnectionManager0.setDefaultSocketConfig(socketConfig0);
            }
            ConnectionConfig connectionConfig0 = this.defaultConnectionConfig;
            if(connectionConfig0 != null) {
                poolingHttpClientConnectionManager0.setDefaultConnectionConfig(connectionConfig0);
            }
            if(this.systemProperties) {
                poolingHttpClientConnectionManager0.setDefaultMaxPerRoute(5);
                poolingHttpClientConnectionManager0.setMaxTotal(10);
            }
            int v = this.maxConnTotal;
            if(v > 0) {
                poolingHttpClientConnectionManager0.setMaxTotal(v);
            }
            int v1 = this.maxConnPerRoute;
            if(v1 > 0) {
                poolingHttpClientConnectionManager0.setDefaultMaxPerRoute(v1);
            }
            httpClientConnectionManager1 = poolingHttpClientConnectionManager0;
        }
        else {
            httpClientConnectionManager1 = httpClientConnectionManager0;
        }
        ConnectionReuseStrategy connectionReuseStrategy0 = this.reuseStrategy;
        if(connectionReuseStrategy0 == null) {
            connectionReuseStrategy0 = DefaultConnectionReuseStrategyHC4.INSTANCE;
        }
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy0 = this.keepAliveStrategy;
        if(connectionKeepAliveStrategy0 == null) {
            connectionKeepAliveStrategy0 = DefaultConnectionKeepAliveStrategyHC4.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy0 = this.targetAuthStrategy;
        if(authenticationStrategy0 == null) {
            authenticationStrategy0 = TargetAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy1 = this.proxyAuthStrategy;
        if(authenticationStrategy1 == null) {
            authenticationStrategy1 = ProxyAuthenticationStrategy.INSTANCE;
        }
        UserTokenHandler userTokenHandler0 = this.userTokenHandler;
        if(userTokenHandler0 == null) {
            userTokenHandler0 = this.connectionStateDisabled ? (HttpContext httpContext0) -> null : DefaultUserTokenHandlerHC4.INSTANCE;
        }
        ClientExecChain clientExecChain0 = this.decorateMainExec(new MainClientExec(httpRequestExecutor0, httpClientConnectionManager1, connectionReuseStrategy0, connectionKeepAliveStrategy0, authenticationStrategy0, authenticationStrategy1, userTokenHandler0));
        HttpProcessor httpProcessor0 = this.httpprocessor;
        if(httpProcessor0 == null) {
            String s = this.userAgent;
            if(s == null) {
                if(this.systemProperties) {
                    s = "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)";
                }
                if(s == null) {
                    s = "Apache-HttpClient/UNAVAILABLE (java 1.5)";
                }
            }
            HttpProcessorBuilder httpProcessorBuilder0 = HttpProcessorBuilder.create();
            LinkedList linkedList0 = this.requestFirst;
            if(linkedList0 != null) {
                for(Object object0: linkedList0) {
                    httpProcessorBuilder0.addFirst(((HttpRequestInterceptor)object0));
                }
            }
            LinkedList linkedList1 = this.responseFirst;
            if(linkedList1 != null) {
                for(Object object1: linkedList1) {
                    httpProcessorBuilder0.addFirst(((HttpResponseInterceptor)object1));
                }
            }
            httpProcessorBuilder0.addAll(new HttpRequestInterceptor[]{new RequestDefaultHeadersHC4(this.defaultHeaders), new RequestContentHC4(), new RequestTargetHostHC4(), new RequestClientConnControl(), new RequestUserAgentHC4(s), new RequestExpectContinue()});
            if(!this.cookieManagementDisabled) {
                httpProcessorBuilder0.add(new RequestAddCookiesHC4());
            }
            if(!this.contentCompressionDisabled) {
                httpProcessorBuilder0.add(new RequestAcceptEncoding());
            }
            if(!this.authCachingDisabled) {
                httpProcessorBuilder0.add(new RequestAuthCache());
            }
            if(!this.cookieManagementDisabled) {
                httpProcessorBuilder0.add(new ResponseProcessCookiesHC4());
            }
            if(!this.contentCompressionDisabled) {
                httpProcessorBuilder0.add(new ResponseContentEncoding());
            }
            LinkedList linkedList2 = this.requestLast;
            if(linkedList2 != null) {
                for(Object object2: linkedList2) {
                    httpProcessorBuilder0.addLast(((HttpRequestInterceptor)object2));
                }
            }
            LinkedList linkedList3 = this.responseLast;
            if(linkedList3 != null) {
                for(Object object3: linkedList3) {
                    httpProcessorBuilder0.addLast(((HttpResponseInterceptor)object3));
                }
            }
            httpProcessor0 = httpProcessorBuilder0.build();
        }
        ClientExecChain clientExecChain1 = this.decorateProtocolExec(new ProtocolExec(clientExecChain0, httpProcessor0));
        if(!this.automaticRetriesDisabled) {
            HttpRequestRetryHandler httpRequestRetryHandler0 = this.retryHandler;
            if(httpRequestRetryHandler0 == null) {
                httpRequestRetryHandler0 = DefaultHttpRequestRetryHandlerHC4.INSTANCE;
            }
            clientExecChain1 = new RetryExec(clientExecChain1, httpRequestRetryHandler0);
        }
        HttpRoutePlanner httpRoutePlanner0 = this.routePlanner;
        if(httpRoutePlanner0 == null) {
            SchemePortResolver schemePortResolver0 = this.schemePortResolver;
            if(schemePortResolver0 == null) {
                schemePortResolver0 = DefaultSchemePortResolver.INSTANCE;
            }
            HttpHost httpHost0 = this.proxy;
            if(httpHost0 == null) {
                DefaultRoutePlanner defaultRoutePlanner0 = this.systemProperties ? new SystemDefaultRoutePlanner(schemePortResolver0, ProxySelector.getDefault()) : new DefaultRoutePlanner(schemePortResolver0);
                httpRoutePlanner0 = defaultRoutePlanner0;
            }
            else {
                httpRoutePlanner0 = new DefaultProxyRoutePlanner(httpHost0, schemePortResolver0);
            }
        }
        if(!this.redirectHandlingDisabled) {
            RedirectStrategy redirectStrategy0 = this.redirectStrategy;
            if(redirectStrategy0 == null) {
                redirectStrategy0 = DefaultRedirectStrategy.INSTANCE;
            }
            clientExecChain1 = new RedirectExec(clientExecChain1, httpRoutePlanner0, redirectStrategy0);
        }
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy0 = this.serviceUnavailStrategy;
        if(serviceUnavailableRetryStrategy0 != null) {
            clientExecChain1 = new ServiceUnavailableRetryExec(clientExecChain1, serviceUnavailableRetryStrategy0);
        }
        BackoffManager backoffManager0 = this.backoffManager;
        ConnectionBackoffStrategy connectionBackoffStrategy0 = this.connectionBackoffStrategy;
        ClientExecChain clientExecChain2 = backoffManager0 == null || connectionBackoffStrategy0 == null ? clientExecChain1 : new BackoffStrategyExec(clientExecChain1, connectionBackoffStrategy0, backoffManager0);
        Lookup lookup0 = this.authSchemeRegistry;
        if(lookup0 == null) {
            lookup0 = RegistryBuilder.create().register("Basic", new BasicSchemeFactoryHC4()).register("Digest", new DigestSchemeFactoryHC4()).register("NTLM", new NTLMSchemeFactory()).build();
        }
        Lookup lookup1 = this.cookieSpecRegistry;
        if(lookup1 == null) {
            lookup1 = RegistryBuilder.create().register("best-match", new BestMatchSpecFactoryHC4()).register("standard", new RFC2965SpecFactoryHC4()).register("compatibility", new BrowserCompatSpecFactoryHC4()).register("netscape", new NetscapeDraftSpecFactoryHC4()).register("ignoreCookies", new IgnoreSpecFactory()).register("rfc2109", new RFC2109SpecFactoryHC4()).register("rfc2965", new RFC2965SpecFactoryHC4()).build();
        }
        CookieStore cookieStore0 = this.cookieStore;
        if(cookieStore0 == null) {
            cookieStore0 = new BasicCookieStoreHC4();
        }
        CredentialsProvider credentialsProvider0 = this.credentialsProvider;
        if(credentialsProvider0 == null) {
            credentialsProvider0 = this.systemProperties ? new SystemDefaultCredentialsProvider() : new BasicCredentialsProviderHC4();
        }
        RequestConfig requestConfig0 = this.defaultRequestConfig == null ? RequestConfig.DEFAULT : this.defaultRequestConfig;
        if(this.closeables != null) {
            arrayList0 = new ArrayList(this.closeables);
        }
        return new InternalHttpClient(clientExecChain2, httpClientConnectionManager1, httpRoutePlanner0, lookup1, lookup0, cookieStore0, credentialsProvider0, requestConfig0, arrayList0);
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    public ClientExecChain decorateMainExec(ClientExecChain clientExecChain0) {
        return clientExecChain0;
    }

    public ClientExecChain decorateProtocolExec(ClientExecChain clientExecChain0) {
        return clientExecChain0;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffManager0) {
        this.backoffManager = backoffManager0;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy0) {
        this.connectionBackoffStrategy = connectionBackoffStrategy0;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpClientConnectionManager0) {
        this.connManager = httpClientConnectionManager0;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy0) {
        this.reuseStrategy = connectionReuseStrategy0;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup lookup0) {
        this.authSchemeRegistry = lookup0;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionConfig0) {
        this.defaultConnectionConfig = connectionConfig0;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup lookup0) {
        this.cookieSpecRegistry = lookup0;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookieStore0) {
        this.cookieStore = cookieStore0;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsProvider0) {
        this.credentialsProvider = credentialsProvider0;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection collection0) {
        this.defaultHeaders = collection0;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestConfig0) {
        this.defaultRequestConfig = requestConfig0;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketConfig0) {
        this.defaultSocketConfig = socketConfig0;
        return this;
    }

    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier0) {
        this.hostnameVerifier = x509HostnameVerifier0;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpProcessor0) {
        this.httpprocessor = httpProcessor0;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy0) {
        this.keepAliveStrategy = connectionKeepAliveStrategy0;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int v) {
        this.maxConnPerRoute = v;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int v) {
        this.maxConnTotal = v;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httpHost0) {
        this.proxy = httpHost0;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy0) {
        this.proxyAuthStrategy = authenticationStrategy0;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectStrategy0) {
        this.redirectStrategy = redirectStrategy0;
        return this;
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httpRequestExecutor0) {
        this.requestExec = httpRequestExecutor0;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler0) {
        this.retryHandler = httpRequestRetryHandler0;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httpRoutePlanner0) {
        this.routePlanner = httpRoutePlanner0;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredConnectionSocketFactory0) {
        this.sslSocketFactory = layeredConnectionSocketFactory0;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemePortResolver0) {
        this.schemePortResolver = schemePortResolver0;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy0) {
        this.serviceUnavailStrategy = serviceUnavailableRetryStrategy0;
        return this;
    }

    public final HttpClientBuilder setSslcontext(SSLContext sSLContext0) {
        this.sslcontext = sSLContext0;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy0) {
        this.targetAuthStrategy = authenticationStrategy0;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String s) {
        this.userAgent = s;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler userTokenHandler0) {
        this.userTokenHandler = userTokenHandler0;
        return this;
    }

    // 去混淆评级： 低(20)
    private static String[] split(String s) {
        return TextUtils.isBlank(s) ? null : s.split(" *, *");
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }
}

