package okhttp3;

import ie.d;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import je.p;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform.Companion;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.k;

@Metadata(d1 = {"\u0000\u00F0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0091\u0001\u0090\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016\u00A2\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0018\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u001C\u001A\u00020\u0019H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010!\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0007\u00A2\u0006\u0004\b\u001F\u0010 J\u0015\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0007\u00A2\u0006\u0004\b\"\u0010 J\u000F\u0010\'\u001A\u00020$H\u0007\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010+\u001A\u00020(H\u0007\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010/\u001A\u00020,H\u0007\u00A2\u0006\u0004\b-\u0010.J\u000F\u00101\u001A\u00020(H\u0007\u00A2\u0006\u0004\b0\u0010*J\u000F\u00103\u001A\u00020(H\u0007\u00A2\u0006\u0004\b2\u0010*J\u000F\u00107\u001A\u000204H\u0007\u00A2\u0006\u0004\b5\u00106J\u0011\u0010;\u001A\u0004\u0018\u000108H\u0007\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010?\u001A\u00020<H\u0007\u00A2\u0006\u0004\b=\u0010>J\u0011\u0010C\u001A\u0004\u0018\u00010@H\u0007\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010G\u001A\u00020DH\u0007\u00A2\u0006\u0004\bE\u0010FJ\u000F\u0010I\u001A\u00020,H\u0007\u00A2\u0006\u0004\bH\u0010.J\u000F\u0010M\u001A\u00020JH\u0007\u00A2\u0006\u0004\bK\u0010LJ\u000F\u0010Q\u001A\u00020NH\u0007\u00A2\u0006\u0004\bO\u0010PJ\u0015\u0010T\u001A\b\u0012\u0004\u0012\u00020R0\u001DH\u0007\u00A2\u0006\u0004\bS\u0010 J\u0015\u0010W\u001A\b\u0012\u0004\u0012\u00020U0\u001DH\u0007\u00A2\u0006\u0004\bV\u0010 J\u000F\u0010[\u001A\u00020XH\u0007\u00A2\u0006\u0004\bY\u0010ZJ\u000F\u0010_\u001A\u00020\\H\u0007\u00A2\u0006\u0004\b]\u0010^J\u000F\u0010c\u001A\u00020`H\u0007\u00A2\u0006\u0004\ba\u0010bJ\u000F\u0010e\u001A\u00020`H\u0007\u00A2\u0006\u0004\bd\u0010bJ\u000F\u0010g\u001A\u00020`H\u0007\u00A2\u0006\u0004\bf\u0010bJ\u000F\u0010i\u001A\u00020`H\u0007\u00A2\u0006\u0004\bh\u0010bJ\u000F\u0010k\u001A\u00020`H\u0007\u00A2\u0006\u0004\bj\u0010bJ\u000F\u0010m\u001A\u00020lH\u0002\u00A2\u0006\u0004\bm\u0010\bR\u0017\u0010\u0018\u001A\u00020\u00158G\u00A2\u0006\f\n\u0004\b\u0018\u0010n\u001A\u0004\b\u0018\u0010\u0017R\u0017\u0010\u001C\u001A\u00020\u00198G\u00A2\u0006\f\n\u0004\b\u001C\u0010o\u001A\u0004\b\u001C\u0010\u001BR\u001D\u0010!\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D8G\u00A2\u0006\f\n\u0004\b!\u0010p\u001A\u0004\b!\u0010 R\u001D\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D8G\u00A2\u0006\f\n\u0004\b#\u0010p\u001A\u0004\b#\u0010 R\u0017\u0010\'\u001A\u00020$8G\u00A2\u0006\f\n\u0004\b\'\u0010q\u001A\u0004\b\'\u0010&R\u0017\u0010+\u001A\u00020(8G\u00A2\u0006\f\n\u0004\b+\u0010r\u001A\u0004\b+\u0010*R\u0017\u0010/\u001A\u00020,8G\u00A2\u0006\f\n\u0004\b/\u0010s\u001A\u0004\b/\u0010.R\u0017\u00101\u001A\u00020(8G\u00A2\u0006\f\n\u0004\b1\u0010r\u001A\u0004\b1\u0010*R\u0017\u00103\u001A\u00020(8G\u00A2\u0006\f\n\u0004\b3\u0010r\u001A\u0004\b3\u0010*R\u0017\u00107\u001A\u0002048G\u00A2\u0006\f\n\u0004\b7\u0010t\u001A\u0004\b7\u00106R\u0019\u0010;\u001A\u0004\u0018\u0001088G\u00A2\u0006\f\n\u0004\b;\u0010u\u001A\u0004\b;\u0010:R\u0017\u0010?\u001A\u00020<8G\u00A2\u0006\f\n\u0004\b?\u0010v\u001A\u0004\b?\u0010>R\u0019\u0010C\u001A\u0004\u0018\u00010@8G\u00A2\u0006\f\n\u0004\bC\u0010w\u001A\u0004\bC\u0010BR\u0017\u0010G\u001A\u00020D8G\u00A2\u0006\f\n\u0004\bG\u0010x\u001A\u0004\bG\u0010FR\u0017\u0010I\u001A\u00020,8G\u00A2\u0006\f\n\u0004\bI\u0010s\u001A\u0004\bI\u0010.R\u0017\u0010M\u001A\u00020J8G\u00A2\u0006\f\n\u0004\bM\u0010y\u001A\u0004\bM\u0010LR\u0016\u0010z\u001A\u0004\u0018\u00010N8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bz\u0010{R\u0019\u0010}\u001A\u0004\u0018\u00010|8G\u00A2\u0006\f\n\u0004\b}\u0010~\u001A\u0004\b}\u0010\u007FR\u001D\u0010T\u001A\b\u0012\u0004\u0012\u00020R0\u001D8G\u00A2\u0006\f\n\u0004\bT\u0010p\u001A\u0004\bT\u0010 R\u001D\u0010W\u001A\b\u0012\u0004\u0012\u00020U0\u001D8G\u00A2\u0006\f\n\u0004\bW\u0010p\u001A\u0004\bW\u0010 R\u0018\u0010[\u001A\u00020X8G\u00A2\u0006\r\n\u0005\b[\u0010\u0080\u0001\u001A\u0004\b[\u0010ZR\u0018\u0010_\u001A\u00020\\8G\u00A2\u0006\r\n\u0005\b_\u0010\u0081\u0001\u001A\u0004\b_\u0010^R\u001F\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0082\u00018G\u00A2\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001A\u0006\b\u0083\u0001\u0010\u0085\u0001R\u0018\u0010c\u001A\u00020`8G\u00A2\u0006\r\n\u0005\bc\u0010\u0086\u0001\u001A\u0004\bc\u0010bR\u0018\u0010e\u001A\u00020`8G\u00A2\u0006\r\n\u0005\be\u0010\u0086\u0001\u001A\u0004\be\u0010bR\u0018\u0010g\u001A\u00020`8G\u00A2\u0006\r\n\u0005\bg\u0010\u0086\u0001\u001A\u0004\bg\u0010bR\u0018\u0010i\u001A\u00020`8G\u00A2\u0006\r\n\u0005\bi\u0010\u0086\u0001\u001A\u0004\bi\u0010bR\u0018\u0010k\u001A\u00020`8G\u00A2\u0006\r\n\u0005\bk\u0010\u0086\u0001\u001A\u0004\bk\u0010bR\u001D\u0010\u0088\u0001\u001A\u00030\u0087\u00018G\u00A2\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001A\u0006\b\u0088\u0001\u0010\u008A\u0001R\u001D\u0010\u008C\u0001\u001A\u00030\u008B\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u008C\u0001\u0010\u008D\u0001\u001A\u0006\b\u008E\u0001\u0010\u008F\u0001R\u0011\u0010Q\u001A\u00020N8G\u00A2\u0006\u0006\u001A\u0004\bQ\u0010P\u00A8\u0006\u0092\u0001"}, d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lokhttp3/OkHttpClient$Builder;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "", "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "Lie/H;", "verifyClientState", "Lokhttp3/Dispatcher;", "Lokhttp3/ConnectionPool;", "Ljava/util/List;", "Lokhttp3/EventListener$Factory;", "Z", "Lokhttp3/Authenticator;", "Lokhttp3/CookieJar;", "Lokhttp3/Cache;", "Lokhttp3/Dns;", "Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "Ljavax/net/SocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "I", "", "minWebSocketMessageToCompress", "J", "()J", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class OkHttpClient implements Cloneable, Factory, okhttp3.WebSocket.Factory {
    @Metadata(d1 = {"\u0000\u00F0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bg\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0012\u001A\u00020\u00002\u0014\b\u0004\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0087\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\r\u00A2\u0006\u0004\b\u001A\u0010\u0010J\u0015\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u000E\u00A2\u0006\u0004\b\u001B\u0010\u0013J)\u0010\u001B\u001A\u00020\u00002\u0014\b\u0004\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0087\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001C\u0010\u0019J\u0015\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0015\u0010!\u001A\u00020\u00002\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001A\u00020\u00002\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b$\u0010%J\u0015\u0010\'\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020&\u00A2\u0006\u0004\b\'\u0010(J\u0015\u0010)\u001A\u00020\u00002\u0006\u0010)\u001A\u00020#\u00A2\u0006\u0004\b)\u0010%J\u0015\u0010+\u001A\u00020\u00002\u0006\u0010*\u001A\u00020#\u00A2\u0006\u0004\b+\u0010%J\u0015\u0010-\u001A\u00020\u00002\u0006\u0010-\u001A\u00020,\u00A2\u0006\u0004\b-\u0010.J\u0017\u00100\u001A\u00020\u00002\b\u00100\u001A\u0004\u0018\u00010/\u00A2\u0006\u0004\b0\u00101J\u0015\u00103\u001A\u00020\u00002\u0006\u00103\u001A\u000202\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u00020\u00002\b\u00106\u001A\u0004\u0018\u000105\u00A2\u0006\u0004\b6\u00107J\u0015\u00109\u001A\u00020\u00002\u0006\u00109\u001A\u000208\u00A2\u0006\u0004\b9\u0010:J\u0015\u0010;\u001A\u00020\u00002\u0006\u0010;\u001A\u00020&\u00A2\u0006\u0004\b;\u0010(J\u0015\u0010=\u001A\u00020\u00002\u0006\u0010=\u001A\u00020<\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010@\u001A\u00020\u00002\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0004\b@\u0010AJ\u001D\u0010@\u001A\u00020\u00002\u0006\u0010@\u001A\u00020?2\u0006\u0010C\u001A\u00020B\u00A2\u0006\u0004\b@\u0010DJ\u001B\u0010G\u001A\u00020\u00002\f\u0010G\u001A\b\u0012\u0004\u0012\u00020F0E\u00A2\u0006\u0004\bG\u0010HJ\u001B\u0010J\u001A\u00020\u00002\f\u0010J\u001A\b\u0012\u0004\u0012\u00020I0E\u00A2\u0006\u0004\bJ\u0010HJ\u0015\u0010L\u001A\u00020\u00002\u0006\u0010L\u001A\u00020K\u00A2\u0006\u0004\bL\u0010MJ\u0015\u0010O\u001A\u00020\u00002\u0006\u0010O\u001A\u00020N\u00A2\u0006\u0004\bO\u0010PJ\u001D\u0010U\u001A\u00020\u00002\u0006\u0010R\u001A\u00020Q2\u0006\u0010T\u001A\u00020S\u00A2\u0006\u0004\bU\u0010VJ\u0017\u0010U\u001A\u00020\u00002\u0006\u0010X\u001A\u00020WH\u0007\u00A2\u0006\u0004\bU\u0010YJ\u001D\u0010Z\u001A\u00020\u00002\u0006\u0010R\u001A\u00020Q2\u0006\u0010T\u001A\u00020S\u00A2\u0006\u0004\bZ\u0010VJ\u0017\u0010Z\u001A\u00020\u00002\u0006\u0010X\u001A\u00020WH\u0007\u00A2\u0006\u0004\bZ\u0010YJ\u001D\u0010[\u001A\u00020\u00002\u0006\u0010R\u001A\u00020Q2\u0006\u0010T\u001A\u00020S\u00A2\u0006\u0004\b[\u0010VJ\u0017\u0010[\u001A\u00020\u00002\u0006\u0010X\u001A\u00020WH\u0007\u00A2\u0006\u0004\b[\u0010YJ\u001D\u0010\\\u001A\u00020\u00002\u0006\u0010R\u001A\u00020Q2\u0006\u0010T\u001A\u00020S\u00A2\u0006\u0004\b\\\u0010VJ\u0017\u0010\\\u001A\u00020\u00002\u0006\u0010X\u001A\u00020WH\u0007\u00A2\u0006\u0004\b\\\u0010YJ\u001D\u0010^\u001A\u00020\u00002\u0006\u0010]\u001A\u00020Q2\u0006\u0010T\u001A\u00020S\u00A2\u0006\u0004\b^\u0010VJ\u0017\u0010^\u001A\u00020\u00002\u0006\u0010X\u001A\u00020WH\u0007\u00A2\u0006\u0004\b^\u0010YJ\u0015\u0010`\u001A\u00020\u00002\u0006\u0010_\u001A\u00020Q\u00A2\u0006\u0004\b`\u0010aJ\r\u0010b\u001A\u00020\u0004\u00A2\u0006\u0004\bb\u0010cR\"\u0010\b\u001A\u00020\u00078\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\b\u0010d\u001A\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010\u000B\u001A\u00020\n8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR \u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u000F\u0010n\u001A\u0004\bo\u0010\u0010R \u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u001A\u0010n\u001A\u0004\bp\u0010\u0010R\"\u0010!\u001A\u00020 8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010q\u001A\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010$\u001A\u00020#8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b$\u0010v\u001A\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010\'\u001A\u00020&8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\'\u0010{\u001A\u0004\b|\u0010}\"\u0004\b~\u0010\u007FR$\u0010)\u001A\u00020#8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0014\n\u0004\b)\u0010v\u001A\u0005\b\u0080\u0001\u0010x\"\u0005\b\u0081\u0001\u0010zR$\u0010+\u001A\u00020#8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0014\n\u0004\b+\u0010v\u001A\u0005\b\u0082\u0001\u0010x\"\u0005\b\u0083\u0001\u0010zR\'\u0010-\u001A\u00020,8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b-\u0010\u0084\u0001\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u00100\u001A\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b0\u0010\u0089\u0001\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001\"\u0006\b\u008C\u0001\u0010\u008D\u0001R\'\u00103\u001A\u0002028\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b3\u0010\u008E\u0001\u001A\u0006\b\u008F\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R)\u00106\u001A\u0004\u0018\u0001058\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b6\u0010\u0093\u0001\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u00109\u001A\u0004\u0018\u0001088\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b9\u0010\u0098\u0001\u001A\u0006\b\u0099\u0001\u0010\u009A\u0001\"\u0006\b\u009B\u0001\u0010\u009C\u0001R$\u0010;\u001A\u00020&8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0014\n\u0004\b;\u0010{\u001A\u0005\b\u009D\u0001\u0010}\"\u0005\b\u009E\u0001\u0010\u007FR\'\u0010=\u001A\u00020<8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b=\u0010\u009F\u0001\u001A\u0006\b\u00A0\u0001\u0010\u00A1\u0001\"\u0006\b\u00A2\u0001\u0010\u00A3\u0001R+\u0010\u00A4\u0001\u001A\u0004\u0018\u00010?8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0018\n\u0006\b\u00A4\u0001\u0010\u00A5\u0001\u001A\u0006\b\u00A6\u0001\u0010\u00A7\u0001\"\u0006\b\u00A8\u0001\u0010\u00A9\u0001R+\u0010\u00AA\u0001\u001A\u0004\u0018\u00010B8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0018\n\u0006\b\u00AA\u0001\u0010\u00AB\u0001\u001A\u0006\b\u00AC\u0001\u0010\u00AD\u0001\"\u0006\b\u00AE\u0001\u0010\u00AF\u0001R+\u0010G\u001A\b\u0012\u0004\u0012\u00020F0E8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0015\n\u0004\bG\u0010n\u001A\u0005\b\u00B0\u0001\u0010\u0010\"\u0006\b\u00B1\u0001\u0010\u00B2\u0001R+\u0010J\u001A\b\u0012\u0004\u0012\u00020I0E8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0015\n\u0004\bJ\u0010n\u001A\u0005\b\u00B3\u0001\u0010\u0010\"\u0006\b\u00B4\u0001\u0010\u00B2\u0001R\'\u0010L\u001A\u00020K8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\bL\u0010\u00B5\u0001\u001A\u0006\b\u00B6\u0001\u0010\u00B7\u0001\"\u0006\b\u00B8\u0001\u0010\u00B9\u0001R\'\u0010O\u001A\u00020N8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\bO\u0010\u00BA\u0001\u001A\u0006\b\u00BB\u0001\u0010\u00BC\u0001\"\u0006\b\u00BD\u0001\u0010\u00BE\u0001R,\u0010\u00C0\u0001\u001A\u0005\u0018\u00010\u00BF\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0018\n\u0006\b\u00C0\u0001\u0010\u00C1\u0001\u001A\u0006\b\u00C2\u0001\u0010\u00C3\u0001\"\u0006\b\u00C4\u0001\u0010\u00C5\u0001R(\u0010U\u001A\u00030\u00C6\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\bU\u0010\u00C7\u0001\u001A\u0006\b\u00C8\u0001\u0010\u00C9\u0001\"\u0006\b\u00CA\u0001\u0010\u00CB\u0001R(\u0010Z\u001A\u00030\u00C6\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\bZ\u0010\u00C7\u0001\u001A\u0006\b\u00CC\u0001\u0010\u00C9\u0001\"\u0006\b\u00CD\u0001\u0010\u00CB\u0001R(\u0010[\u001A\u00030\u00C6\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b[\u0010\u00C7\u0001\u001A\u0006\b\u00CE\u0001\u0010\u00C9\u0001\"\u0006\b\u00CF\u0001\u0010\u00CB\u0001R(\u0010\\\u001A\u00030\u00C6\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b\\\u0010\u00C7\u0001\u001A\u0006\b\u00D0\u0001\u0010\u00C9\u0001\"\u0006\b\u00D1\u0001\u0010\u00CB\u0001R(\u0010^\u001A\u00030\u00C6\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b^\u0010\u00C7\u0001\u001A\u0006\b\u00D2\u0001\u0010\u00C9\u0001\"\u0006\b\u00D3\u0001\u0010\u00CB\u0001R\'\u0010`\u001A\u00020Q8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0005\b`\u0010\u00D4\u0001\u001A\u0006\b\u00D5\u0001\u0010\u00D6\u0001\"\u0006\b\u00D7\u0001\u0010\u00D8\u0001R,\u0010\u00DA\u0001\u001A\u0005\u0018\u00010\u00D9\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0018\n\u0006\b\u00DA\u0001\u0010\u00DB\u0001\u001A\u0006\b\u00DC\u0001\u0010\u00DD\u0001\"\u0006\b\u00DE\u0001\u0010\u00DF\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006\u00E0\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Dispatcher;", "dispatcher", "(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/ConnectionPool;", "connectionPool", "(Lokhttp3/ConnectionPool;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Interceptor;", "interceptors", "()Ljava/util/List;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "block", "-addInterceptor", "(Lwe/k;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "(Lokhttp3/EventListener$Factory;)Lokhttp3/OkHttpClient$Builder;", "", "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Authenticator;", "authenticator", "(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Cache;", "cache", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dns;", "dns", "(Lokhttp3/Dns;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/Proxy;", "proxy", "(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/ProxySelector;", "proxySelector", "(Ljava/net/ProxySelector;)Lokhttp3/OkHttpClient$Builder;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "(Ljavax/net/SocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/CertificatePinner;", "certificatePinner", "(Lokhttp3/CertificatePinner;)Lokhttp3/OkHttpClient$Builder;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "Ljava/time/Duration;", "duration", "(Ljava/time/Duration;)Lokhttp3/OkHttpClient$Builder;", "connectTimeout", "readTimeout", "writeTimeout", "interval", "pingInterval", "bytes", "minWebSocketMessageToCompress", "(J)Lokhttp3/OkHttpClient$Builder;", "build", "()Lokhttp3/OkHttpClient;", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "Ljava/util/List;", "getInterceptors$okhttp", "getNetworkInterceptors$okhttp", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "Z", "getRetryOnConnectionFailure$okhttp", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "getProtocols$okhttp", "setProtocols$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "", "I", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "getPingInterval$okhttp", "setPingInterval$okhttp", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private Authenticator authenticator;
        @Nullable
        private Cache cache;
        private int callTimeout;
        @Nullable
        private CertificateChainCleaner certificateChainCleaner;
        @NotNull
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        @NotNull
        private ConnectionPool connectionPool;
        @NotNull
        private List connectionSpecs;
        @NotNull
        private CookieJar cookieJar;
        @NotNull
        private Dispatcher dispatcher;
        @NotNull
        private Dns dns;
        @NotNull
        private okhttp3.EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        @NotNull
        private HostnameVerifier hostnameVerifier;
        @NotNull
        private final List interceptors;
        private long minWebSocketMessageToCompress;
        @NotNull
        private final List networkInterceptors;
        private int pingInterval;
        @NotNull
        private List protocols;
        @Nullable
        private Proxy proxy;
        @NotNull
        private Authenticator proxyAuthenticator;
        @Nullable
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        @Nullable
        private RouteDatabase routeDatabase;
        @NotNull
        private SocketFactory socketFactory;
        @Nullable
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        @Nullable
        private X509TrustManager x509TrustManagerOrNull;

        @NotNull
        public final Builder -addInterceptor(@NotNull k k0) {
            q.g(k0, "block");
            return this.addInterceptor(new Interceptor() {
                @Override  // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Chain interceptor$Chain0) {
                    q.g(interceptor$Chain0, "chain");
                    return (Response)this.$block.invoke(interceptor$Chain0);
                }
            });
        }

        @NotNull
        public final Builder -addNetworkInterceptor(@NotNull k k0) {
            q.g(k0, "block");
            return this.addNetworkInterceptor(new Interceptor() {
                @Override  // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Chain interceptor$Chain0) {
                    q.g(interceptor$Chain0, "chain");
                    return (Response)this.$block.invoke(interceptor$Chain0);
                }
            });
        }

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.authenticator = Authenticator.NONE;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = Authenticator.NONE;
            SocketFactory socketFactory0 = SocketFactory.getDefault();
            q.f(socketFactory0, "getDefault()");
            this.socketFactory = socketFactory0;
            this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 0x400L;
        }

        public Builder(@NotNull OkHttpClient okHttpClient0) {
            q.g(okHttpClient0, "okHttpClient");
            this();
            this.dispatcher = okHttpClient0.dispatcher();
            this.connectionPool = okHttpClient0.connectionPool();
            u.U(this.interceptors, okHttpClient0.interceptors());
            u.U(this.networkInterceptors, okHttpClient0.networkInterceptors());
            this.eventListenerFactory = okHttpClient0.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient0.retryOnConnectionFailure();
            this.authenticator = okHttpClient0.authenticator();
            this.followRedirects = okHttpClient0.followRedirects();
            this.followSslRedirects = okHttpClient0.followSslRedirects();
            this.cookieJar = okHttpClient0.cookieJar();
            this.cache = okHttpClient0.cache();
            this.dns = okHttpClient0.dns();
            this.proxy = okHttpClient0.proxy();
            this.proxySelector = okHttpClient0.proxySelector();
            this.proxyAuthenticator = okHttpClient0.proxyAuthenticator();
            this.socketFactory = okHttpClient0.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient0.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient0.x509TrustManager();
            this.connectionSpecs = okHttpClient0.connectionSpecs();
            this.protocols = okHttpClient0.protocols();
            this.hostnameVerifier = okHttpClient0.hostnameVerifier();
            this.certificatePinner = okHttpClient0.certificatePinner();
            this.certificateChainCleaner = okHttpClient0.certificateChainCleaner();
            this.callTimeout = okHttpClient0.callTimeoutMillis();
            this.connectTimeout = okHttpClient0.connectTimeoutMillis();
            this.readTimeout = okHttpClient0.readTimeoutMillis();
            this.writeTimeout = okHttpClient0.writeTimeoutMillis();
            this.pingInterval = okHttpClient0.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient0.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient0.getRouteDatabase();
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor interceptor0) {
            q.g(interceptor0, "interceptor");
            this.interceptors.add(interceptor0);
            return this;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor interceptor0) {
            q.g(interceptor0, "interceptor");
            this.networkInterceptors.add(interceptor0);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator authenticator0) {
            q.g(authenticator0, "authenticator");
            this.authenticator = authenticator0;
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @NotNull
        public final Builder cache(@Nullable Cache cache0) {
            this.cache = cache0;
            return this;
        }

        @NotNull
        public final Builder callTimeout(long v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "unit");
            this.callTimeout = Util.checkDuration("timeout", v, timeUnit0);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration duration0) {
            q.g(duration0, "duration");
            this.callTimeout(duration0.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner certificatePinner0) {
            q.g(certificatePinner0, "certificatePinner");
            if(!certificatePinner0.equals(this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner0;
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "unit");
            this.connectTimeout = Util.checkDuration("timeout", v, timeUnit0);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration duration0) {
            q.g(duration0, "duration");
            this.connectTimeout(duration0.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool connectionPool0) {
            q.g(connectionPool0, "connectionPool");
            this.connectionPool = connectionPool0;
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List list0) {
            q.g(list0, "connectionSpecs");
            if(!list0.equals(this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(list0);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar cookieJar0) {
            q.g(cookieJar0, "cookieJar");
            this.cookieJar = cookieJar0;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher dispatcher0) {
            q.g(dispatcher0, "dispatcher");
            this.dispatcher = dispatcher0;
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns dns0) {
            q.g(dns0, "dns");
            if(!dns0.equals(this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns0;
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener0) {
            q.g(eventListener0, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener0);
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull okhttp3.EventListener.Factory eventListener$Factory0) {
            q.g(eventListener$Factory0, "eventListenerFactory");
            this.eventListenerFactory = eventListener$Factory0;
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        @NotNull
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @Nullable
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @Nullable
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @NotNull
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @NotNull
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @NotNull
        public final List getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @NotNull
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @NotNull
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @NotNull
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @NotNull
        public final okhttp3.EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @NotNull
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @NotNull
        public final List getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @NotNull
        public final List getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @NotNull
        public final List getProtocols$okhttp() {
            return this.protocols;
        }

        @Nullable
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @NotNull
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @Nullable
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @Nullable
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @NotNull
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @Nullable
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @Nullable
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier hostnameVerifier0) {
            q.g(hostnameVerifier0, "hostnameVerifier");
            if(!hostnameVerifier0.equals(this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier0;
            return this;
        }

        @NotNull
        public final List interceptors() {
            return this.interceptors;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long v) {
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "minWebSocketMessageToCompress must be positive: ").toString());
            }
            this.minWebSocketMessageToCompress = v;
            return this;
        }

        @NotNull
        public final List networkInterceptors() {
            return this.networkInterceptors;
        }

        @NotNull
        public final Builder pingInterval(long v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "unit");
            this.pingInterval = Util.checkDuration("interval", v, timeUnit0);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration duration0) {
            q.g(duration0, "duration");
            this.pingInterval(duration0.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List list0) {
            q.g(list0, "protocols");
            ArrayList arrayList0 = p.Q0(list0);
            Protocol protocol0 = Protocol.H2_PRIOR_KNOWLEDGE;
            if(!arrayList0.contains(protocol0) && !arrayList0.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList0).toString());
            }
            if(arrayList0.contains(protocol0) && arrayList0.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList0).toString());
            }
            if(arrayList0.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayList0).toString());
            }
            if(arrayList0.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList0.remove(Protocol.SPDY_3);
            if(!arrayList0.equals(this.protocols)) {
                this.routeDatabase = null;
            }
            List list1 = Collections.unmodifiableList(arrayList0);
            q.f(list1, "unmodifiableList(protocolsCopy)");
            this.protocols = list1;
            return this;
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy proxy0) {
            if(!q.b(proxy0, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy0;
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator authenticator0) {
            q.g(authenticator0, "proxyAuthenticator");
            if(!authenticator0.equals(this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = authenticator0;
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector proxySelector0) {
            q.g(proxySelector0, "proxySelector");
            if(!proxySelector0.equals(this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector0;
            return this;
        }

        @NotNull
        public final Builder readTimeout(long v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "unit");
            this.readTimeout = Util.checkDuration("timeout", v, timeUnit0);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration duration0) {
            q.g(duration0, "duration");
            this.readTimeout(duration0.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator authenticator0) {
            q.g(authenticator0, "<set-?>");
            this.authenticator = authenticator0;
        }

        public final void setCache$okhttp(@Nullable Cache cache0) {
            this.cache = cache0;
        }

        public final void setCallTimeout$okhttp(int v) {
            this.callTimeout = v;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner certificateChainCleaner0) {
            this.certificateChainCleaner = certificateChainCleaner0;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner certificatePinner0) {
            q.g(certificatePinner0, "<set-?>");
            this.certificatePinner = certificatePinner0;
        }

        public final void setConnectTimeout$okhttp(int v) {
            this.connectTimeout = v;
        }

        public final void setConnectionPool$okhttp(@NotNull ConnectionPool connectionPool0) {
            q.g(connectionPool0, "<set-?>");
            this.connectionPool = connectionPool0;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.connectionSpecs = list0;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar cookieJar0) {
            q.g(cookieJar0, "<set-?>");
            this.cookieJar = cookieJar0;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher dispatcher0) {
            q.g(dispatcher0, "<set-?>");
            this.dispatcher = dispatcher0;
        }

        public final void setDns$okhttp(@NotNull Dns dns0) {
            q.g(dns0, "<set-?>");
            this.dns = dns0;
        }

        public final void setEventListenerFactory$okhttp(@NotNull okhttp3.EventListener.Factory eventListener$Factory0) {
            q.g(eventListener$Factory0, "<set-?>");
            this.eventListenerFactory = eventListener$Factory0;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier hostnameVerifier0) {
            q.g(hostnameVerifier0, "<set-?>");
            this.hostnameVerifier = hostnameVerifier0;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long v) {
            this.minWebSocketMessageToCompress = v;
        }

        public final void setPingInterval$okhttp(int v) {
            this.pingInterval = v;
        }

        public final void setProtocols$okhttp(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.protocols = list0;
        }

        public final void setProxy$okhttp(@Nullable Proxy proxy0) {
            this.proxy = proxy0;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator authenticator0) {
            q.g(authenticator0, "<set-?>");
            this.proxyAuthenticator = authenticator0;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector proxySelector0) {
            this.proxySelector = proxySelector0;
        }

        public final void setReadTimeout$okhttp(int v) {
            this.readTimeout = v;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase routeDatabase0) {
            this.routeDatabase = routeDatabase0;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory socketFactory0) {
            q.g(socketFactory0, "<set-?>");
            this.socketFactory = socketFactory0;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory sSLSocketFactory0) {
            this.sslSocketFactoryOrNull = sSLSocketFactory0;
        }

        public final void setWriteTimeout$okhttp(int v) {
            this.writeTimeout = v;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager x509TrustManager0) {
            this.x509TrustManagerOrNull = x509TrustManager0;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory socketFactory0) {
            q.g(socketFactory0, "socketFactory");
            if(socketFactory0 instanceof SSLSocketFactory) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
            }
            if(!socketFactory0.equals(this.socketFactory)) {
                this.routeDatabase = null;
            }
            this.socketFactory = socketFactory0;
            return this;
        }

        @d
        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory0) {
            q.g(sSLSocketFactory0, "sslSocketFactory");
            if(!sSLSocketFactory0.equals(this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory0;
            Companion platform$Companion0 = Platform.Companion;
            X509TrustManager x509TrustManager0 = platform$Companion0.get().trustManager(sSLSocketFactory0);
            if(x509TrustManager0 == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + platform$Companion0.get() + ", sslSocketFactory is " + sSLSocketFactory0.getClass());
            }
            this.x509TrustManagerOrNull = x509TrustManager0;
            Platform platform0 = platform$Companion0.get();
            X509TrustManager x509TrustManager1 = this.x509TrustManagerOrNull;
            q.d(x509TrustManager1);
            this.certificateChainCleaner = platform0.buildCertificateChainCleaner(x509TrustManager1);
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory0, @NotNull X509TrustManager x509TrustManager0) {
            q.g(sSLSocketFactory0, "sslSocketFactory");
            q.g(x509TrustManager0, "trustManager");
            if(!sSLSocketFactory0.equals(this.sslSocketFactoryOrNull) || !x509TrustManager0.equals(this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory0;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(x509TrustManager0);
            this.x509TrustManagerOrNull = x509TrustManager0;
            return this;
        }

        @NotNull
        public final Builder writeTimeout(long v, @NotNull TimeUnit timeUnit0) {
            q.g(timeUnit0, "unit");
            this.writeTimeout = Util.checkDuration("timeout", v, timeUnit0);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration duration0) {
            q.g(duration0, "duration");
            this.writeTimeout(duration0.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "()V", "DEFAULT_CONNECTION_SPECS", "", "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class okhttp3.OkHttpClient.Companion {
        private okhttp3.OkHttpClient.Companion() {
        }

        public okhttp3.OkHttpClient.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final List getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        @NotNull
        public final List getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }
    }

    @NotNull
    public static final okhttp3.OkHttpClient.Companion Companion;
    @NotNull
    private static final List DEFAULT_CONNECTION_SPECS;
    @NotNull
    private static final List DEFAULT_PROTOCOLS;
    @NotNull
    private final Authenticator authenticator;
    @Nullable
    private final Cache cache;
    private final int callTimeoutMillis;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @NotNull
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    @NotNull
    private final ConnectionPool connectionPool;
    @NotNull
    private final List connectionSpecs;
    @NotNull
    private final CookieJar cookieJar;
    @NotNull
    private final Dispatcher dispatcher;
    @NotNull
    private final Dns dns;
    @NotNull
    private final okhttp3.EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    @NotNull
    private final HostnameVerifier hostnameVerifier;
    @NotNull
    private final List interceptors;
    private final long minWebSocketMessageToCompress;
    @NotNull
    private final List networkInterceptors;
    private final int pingIntervalMillis;
    @NotNull
    private final List protocols;
    @Nullable
    private final Proxy proxy;
    @NotNull
    private final Authenticator proxyAuthenticator;
    @NotNull
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    @NotNull
    private final RouteDatabase routeDatabase;
    @NotNull
    private final SocketFactory socketFactory;
    @Nullable
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    @Nullable
    private final X509TrustManager x509TrustManager;

    @d
    @NotNull
    public final Authenticator -deprecated_authenticator() {
        return this.authenticator;
    }

    @d
    @Nullable
    public final Cache -deprecated_cache() {
        return this.cache;
    }

    @d
    public final int -deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @d
    @NotNull
    public final CertificatePinner -deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @d
    public final int -deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @d
    @NotNull
    public final ConnectionPool -deprecated_connectionPool() {
        return this.connectionPool;
    }

    @d
    @NotNull
    public final List -deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @d
    @NotNull
    public final CookieJar -deprecated_cookieJar() {
        return this.cookieJar;
    }

    @d
    @NotNull
    public final Dispatcher -deprecated_dispatcher() {
        return this.dispatcher;
    }

    @d
    @NotNull
    public final Dns -deprecated_dns() {
        return this.dns;
    }

    @d
    @NotNull
    public final okhttp3.EventListener.Factory -deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @d
    public final boolean -deprecated_followRedirects() {
        return this.followRedirects;
    }

    @d
    public final boolean -deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @d
    @NotNull
    public final HostnameVerifier -deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @d
    @NotNull
    public final List -deprecated_interceptors() {
        return this.interceptors;
    }

    @d
    @NotNull
    public final List -deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @d
    public final int -deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @d
    @NotNull
    public final List -deprecated_protocols() {
        return this.protocols;
    }

    @d
    @Nullable
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @d
    @NotNull
    public final Authenticator -deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @d
    @NotNull
    public final ProxySelector -deprecated_proxySelector() {
        return this.proxySelector;
    }

    @d
    public final int -deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @d
    public final boolean -deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @d
    @NotNull
    public final SocketFactory -deprecated_socketFactory() {
        return this.socketFactory;
    }

    @d
    @NotNull
    public final SSLSocketFactory -deprecated_sslSocketFactory() {
        return this.sslSocketFactory();
    }

    @d
    public final int -deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    static {
        OkHttpClient.Companion = new okhttp3.OkHttpClient.Companion(null);
        OkHttpClient.DEFAULT_PROTOCOLS = Util.immutableListOf(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        OkHttpClient.DEFAULT_CONNECTION_SPECS = Util.immutableListOf(new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public OkHttpClient(@NotNull Builder okHttpClient$Builder0) {
        q.g(okHttpClient$Builder0, "builder");
        ProxySelector proxySelector0;
        super();
        this.dispatcher = okHttpClient$Builder0.getDispatcher$okhttp();
        this.connectionPool = okHttpClient$Builder0.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(okHttpClient$Builder0.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(okHttpClient$Builder0.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = okHttpClient$Builder0.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = okHttpClient$Builder0.getRetryOnConnectionFailure$okhttp();
        this.authenticator = okHttpClient$Builder0.getAuthenticator$okhttp();
        this.followRedirects = okHttpClient$Builder0.getFollowRedirects$okhttp();
        this.followSslRedirects = okHttpClient$Builder0.getFollowSslRedirects$okhttp();
        this.cookieJar = okHttpClient$Builder0.getCookieJar$okhttp();
        this.cache = okHttpClient$Builder0.getCache$okhttp();
        this.dns = okHttpClient$Builder0.getDns$okhttp();
        this.proxy = okHttpClient$Builder0.getProxy$okhttp();
        if(okHttpClient$Builder0.getProxy$okhttp() == null) {
            proxySelector0 = okHttpClient$Builder0.getProxySelector$okhttp() == null ? ProxySelector.getDefault() : okHttpClient$Builder0.getProxySelector$okhttp();
            if(proxySelector0 == null) {
                proxySelector0 = NullProxySelector.INSTANCE;
            }
        }
        else {
            proxySelector0 = NullProxySelector.INSTANCE;
        }
        this.proxySelector = proxySelector0;
        this.proxyAuthenticator = okHttpClient$Builder0.getProxyAuthenticator$okhttp();
        this.socketFactory = okHttpClient$Builder0.getSocketFactory$okhttp();
        List list0 = okHttpClient$Builder0.getConnectionSpecs$okhttp();
        this.connectionSpecs = list0;
        this.protocols = okHttpClient$Builder0.getProtocols$okhttp();
        this.hostnameVerifier = okHttpClient$Builder0.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = okHttpClient$Builder0.getCallTimeout$okhttp();
        this.connectTimeoutMillis = okHttpClient$Builder0.getConnectTimeout$okhttp();
        this.readTimeoutMillis = okHttpClient$Builder0.getReadTimeout$okhttp();
        this.writeTimeoutMillis = okHttpClient$Builder0.getWriteTimeout$okhttp();
        this.pingIntervalMillis = okHttpClient$Builder0.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = okHttpClient$Builder0.getMinWebSocketMessageToCompress$okhttp();
        this.routeDatabase = okHttpClient$Builder0.getRouteDatabase$okhttp() == null ? new RouteDatabase() : okHttpClient$Builder0.getRouteDatabase$okhttp();
        if(list0 instanceof Collection && list0.isEmpty()) {
        label_61:
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        }
        else {
            Iterator iterator0 = list0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    goto label_61;
                }
                Object object0 = iterator0.next();
                if(((ConnectionSpec)object0).isTls()) {
                    if(okHttpClient$Builder0.getSslSocketFactoryOrNull$okhttp() == null) {
                        X509TrustManager x509TrustManager1 = Platform.Companion.get().platformTrustManager();
                        this.x509TrustManager = x509TrustManager1;
                        Platform platform0 = Platform.Companion.get();
                        q.d(x509TrustManager1);
                        this.sslSocketFactoryOrNull = platform0.newSslSocketFactory(x509TrustManager1);
                        q.d(x509TrustManager1);
                        CertificateChainCleaner certificateChainCleaner1 = CertificateChainCleaner.Companion.get(x509TrustManager1);
                        this.certificateChainCleaner = certificateChainCleaner1;
                        q.d(certificateChainCleaner1);
                        this.certificatePinner = okHttpClient$Builder0.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner1);
                    }
                    else {
                        this.sslSocketFactoryOrNull = okHttpClient$Builder0.getSslSocketFactoryOrNull$okhttp();
                        CertificateChainCleaner certificateChainCleaner0 = okHttpClient$Builder0.getCertificateChainCleaner$okhttp();
                        q.d(certificateChainCleaner0);
                        this.certificateChainCleaner = certificateChainCleaner0;
                        X509TrustManager x509TrustManager0 = okHttpClient$Builder0.getX509TrustManagerOrNull$okhttp();
                        q.d(x509TrustManager0);
                        this.x509TrustManager = x509TrustManager0;
                        this.certificatePinner = okHttpClient$Builder0.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner0);
                    }
                    break;
                }
            }
        }
        this.verifyClientState();
    }

    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Nullable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @Override
    @NotNull
    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @NotNull
    public final List connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @NotNull
    public final okhttp3.EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List interceptors() {
        return this.interceptors;
    }

    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @NotNull
    public final List networkInterceptors() {
        return this.networkInterceptors;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override  // okhttp3.Call$Factory
    @NotNull
    public Call newCall(@NotNull Request request0) {
        q.g(request0, "request");
        return new RealCall(this, request0, false);
    }

    @Override  // okhttp3.WebSocket$Factory
    @NotNull
    public WebSocket newWebSocket(@NotNull Request request0, @NotNull WebSocketListener webSocketListener0) {
        q.g(request0, "request");
        q.g(webSocketListener0, "listener");
        Random random0 = new Random();
        WebSocket webSocket0 = new RealWebSocket(TaskRunner.INSTANCE, request0, webSocketListener0, random0, ((long)this.pingIntervalMillis), null, this.minWebSocketMessageToCompress);
        ((RealWebSocket)webSocket0).connect(this);
        return webSocket0;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @NotNull
    public final List protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory0 = this.sslSocketFactoryOrNull;
        if(sSLSocketFactory0 == null) {
            throw new IllegalStateException("CLEARTEXT-only client");
        }
        return sSLSocketFactory0;
    }

    private final void verifyClientState() {
        q.e(this.interceptors, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if(this.interceptors.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        q.e(this.networkInterceptors, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if(this.networkInterceptors.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        Iterable iterable0 = this.connectionSpecs;
        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
            for(Object object0: iterable0) {
                if(!((ConnectionSpec)object0).isTls()) {
                    continue;
                }
                if(this.sslSocketFactoryOrNull == null) {
                    throw new IllegalStateException("sslSocketFactory == null");
                }
                if(this.certificateChainCleaner == null) {
                    throw new IllegalStateException("certificateChainCleaner == null");
                }
                if(this.x509TrustManager == null) {
                    throw new IllegalStateException("x509TrustManager == null");
                }
                return;
            }
        }
        if(this.sslSocketFactoryOrNull != null || this.certificateChainCleaner != null || this.x509TrustManager != null || !q.b(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Nullable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }
}

