package org.apache.http.impl.conn;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import jeb.synthetic.FIN;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

@ThreadSafe
public class BasicHttpClientConnectionManager implements Closeable, HttpClientConnectionManager {
    private static final String TAG = "HttpClient";
    @GuardedBy("this")
    private ManagedHttpClientConnection conn;
    @GuardedBy("this")
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    @GuardedBy("this")
    private long expiry;
    private final AtomicBoolean isShutdown;
    @GuardedBy("this")
    private boolean leased;
    @GuardedBy("this")
    private HttpRoute route;
    @GuardedBy("this")
    private SocketConfig socketConfig;
    @GuardedBy("this")
    private Object state;
    @GuardedBy("this")
    private long updated;

    public BasicHttpClientConnectionManager() {
        this(BasicHttpClientConnectionManager.getDefaultRegistry(), null, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup0) {
        this(lookup0, null, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup0, HttpConnectionFactory httpConnectionFactory0) {
        this(lookup0, httpConnectionFactory0, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup0, HttpConnectionFactory httpConnectionFactory0, SchemePortResolver schemePortResolver0, DnsResolver dnsResolver0) {
        this.connectionOperator = new HttpClientConnectionOperator(lookup0, schemePortResolver0, dnsResolver0);
        if(httpConnectionFactory0 == null) {
            httpConnectionFactory0 = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        this.connFactory = httpConnectionFactory0;
        this.expiry = 0x7FFFFFFFFFFFFFFFL;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }

    private void checkExpiry() {
        if(this.conn != null && System.currentTimeMillis() >= this.expiry) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connection expired @ " + new Date(this.expiry));
            }
            this.closeConnection();
        }
    }

    @Override
    public void close() {
        this.shutdown();
    }

    private void closeConnection() {
        if(this.conn != null) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Closing connection");
            }
            try {
                this.conn.close();
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "I/O exception closing connection", iOException0);
                }
            }
            this.conn = null;
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void closeExpiredConnections() {
        synchronized(this) {
            if(this.isShutdown.get()) {
                return;
            }
            if(!this.leased) {
                this.checkExpiry();
            }
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void closeIdleConnections(long v, TimeUnit timeUnit0) {
        synchronized(this) {
            Args.notNull(timeUnit0, "Time unit");
            if(this.isShutdown.get()) {
                return;
            }
            if(!this.leased) {
                long v2 = timeUnit0.toMillis(v);
                if(v2 < 0L) {
                    v2 = 0L;
                }
                if(this.updated <= System.currentTimeMillis() - v2) {
                    this.closeConnection();
                }
            }
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, int v, HttpContext httpContext0) {
        Args.notNull(httpClientConnection0, "Connection");
        Args.notNull(httpRoute0, "HTTP route");
        Asserts.check(httpClientConnection0 == this.conn, "Connection not obtained from this manager");
        HttpHost httpHost0 = httpRoute0.getProxyHost() == null ? httpRoute0.getTargetHost() : httpRoute0.getProxyHost();
        InetSocketAddress inetSocketAddress0 = httpRoute0.getLocalAddress() == null ? null : new InetSocketAddress(httpRoute0.getLocalAddress(), 0);
        this.connectionOperator.connect(this.conn, httpHost0, inetSocketAddress0, v, this.socketConfig, httpContext0);
    }

    @Override
    public void finalize() {
        try {
            this.shutdown();
        }
        finally {
            super.finalize();
        }
    }

    public HttpClientConnection getConnection(HttpRoute httpRoute0, Object object0) {
        synchronized(this) {
            Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Get connection for route " + httpRoute0);
            }
            Asserts.check(!this.leased, "Connection is still allocated");
            if(!LangUtils.equals(this.route, httpRoute0) || !LangUtils.equals(this.state, object0)) {
                this.closeConnection();
            }
            this.route = httpRoute0;
            this.state = object0;
            this.checkExpiry();
            if(this.conn == null) {
                this.conn = (ManagedHttpClientConnection)this.connFactory.create(httpRoute0, this.connConfig);
            }
            this.leased = true;
            return this.conn;
        }
    }

    public ConnectionConfig getConnectionConfig() {
        synchronized(this) {
        }
        return this.connConfig;
    }

    private static Registry getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public HttpRoute getRoute() {
        return this.route;
    }

    public SocketConfig getSocketConfig() {
        synchronized(this) {
        }
        return this.socketConfig;
    }

    public Object getState() {
        return this.state;
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void releaseConnection(HttpClientConnection httpClientConnection0, Object object0, long v, TimeUnit timeUnit0) {
        int v2;
        synchronized(this) {
            Args.notNull(httpClientConnection0, "Connection");
            Asserts.check(httpClientConnection0 == this.conn, "Connection not obtained from this manager");
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Releasing connection " + httpClientConnection0);
            }
            if(this.isShutdown.get()) {
                return;
            }
            v2 = FIN.finallyOpen$NT();
            this.updated = System.currentTimeMillis();
            if(this.conn.isOpen()) {
                this.state = object0;
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Connection can be kept alive " + (v <= 0L ? "indefinitely" : "for " + v + " " + timeUnit0));
                }
                this.expiry = v > 0L ? this.updated + timeUnit0.toMillis(v) : 0x7FFFFFFFFFFFFFFFL;
            }
            else {
                this.route = null;
                this.conn = null;
                this.expiry = 0x7FFFFFFFFFFFFFFFL;
            }
            FIN.finallyCodeBegin$NT(v2);
            this.leased = false;
        }
        FIN.finallyCodeEnd$NT(v2);
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public final ConnectionRequest requestConnection(HttpRoute httpRoute0, Object object0) {
        Args.notNull(httpRoute0, "Route");
        return new ConnectionRequest() {
            @Override  // org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                return false;
            }

            @Override  // org.apache.http.conn.ConnectionRequest
            public HttpClientConnection get(long v, TimeUnit timeUnit0) {
                return BasicHttpClientConnectionManager.this.getConnection(httpRoute0, object0);
            }
        };
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpContext httpContext0) {
    }

    public void setConnectionConfig(ConnectionConfig connectionConfig0) {
        synchronized(this) {
            if(connectionConfig0 == null) {
                connectionConfig0 = ConnectionConfig.DEFAULT;
            }
            this.connConfig = connectionConfig0;
        }
    }

    public void setSocketConfig(SocketConfig socketConfig0) {
        synchronized(this) {
            if(socketConfig0 == null) {
                socketConfig0 = SocketConfig.DEFAULT;
            }
            this.socketConfig = socketConfig0;
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void shutdown() {
        synchronized(this) {
            if(this.isShutdown.compareAndSet(false, true)) {
                this.shutdownConnection();
            }
        }
    }

    private void shutdownConnection() {
        if(this.conn != null) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Shutting down connection");
            }
            try {
                this.conn.shutdown();
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "I/O exception shutting down connection", iOException0);
                }
            }
            this.conn = null;
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpContext httpContext0) {
        Args.notNull(httpClientConnection0, "Connection");
        Args.notNull(httpRoute0, "HTTP route");
        Asserts.check(httpClientConnection0 == this.conn, "Connection not obtained from this manager");
        ManagedHttpClientConnection managedHttpClientConnection0 = this.conn;
        HttpHost httpHost0 = httpRoute0.getTargetHost();
        this.connectionOperator.upgrade(managedHttpClientConnection0, httpHost0, httpContext0);
    }
}

