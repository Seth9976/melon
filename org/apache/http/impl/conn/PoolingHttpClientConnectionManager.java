package org.apache.http.impl.conn;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import jeb.synthetic.FIN;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
public class PoolingHttpClientConnectionManager implements Closeable, HttpClientConnectionManager, ConnPoolControl {
    static class ConfigData {
        private final Map connectionConfigMap;
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map socketConfigMap;

        public ConfigData() {
            this.socketConfigMap = new ConcurrentHashMap();
            this.connectionConfigMap = new ConcurrentHashMap();
        }

        public ConnectionConfig getConnectionConfig(HttpHost httpHost0) {
            return (ConnectionConfig)this.connectionConfigMap.get(httpHost0);
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httpHost0) {
            return (SocketConfig)this.socketConfigMap.get(httpHost0);
        }

        public void setConnectionConfig(HttpHost httpHost0, ConnectionConfig connectionConfig0) {
            this.connectionConfigMap.put(httpHost0, connectionConfig0);
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionConfig0) {
            this.defaultConnectionConfig = connectionConfig0;
        }

        public void setDefaultSocketConfig(SocketConfig socketConfig0) {
            this.defaultSocketConfig = socketConfig0;
        }

        public void setSocketConfig(HttpHost httpHost0, SocketConfig socketConfig0) {
            this.socketConfigMap.put(httpHost0, socketConfig0);
        }
    }

    static class InternalConnectionFactory implements ConnFactory {
        private final ConfigData configData;
        private final HttpConnectionFactory connFactory;

        public InternalConnectionFactory(ConfigData poolingHttpClientConnectionManager$ConfigData0, HttpConnectionFactory httpConnectionFactory0) {
            if(poolingHttpClientConnectionManager$ConfigData0 == null) {
                poolingHttpClientConnectionManager$ConfigData0 = new ConfigData();
            }
            this.configData = poolingHttpClientConnectionManager$ConfigData0;
            if(httpConnectionFactory0 == null) {
                httpConnectionFactory0 = ManagedHttpClientConnectionFactory.INSTANCE;
            }
            this.connFactory = httpConnectionFactory0;
        }

        @Override  // org.apache.http.pool.ConnFactory
        public Object create(Object object0) {
            return this.create(((HttpRoute)object0));
        }

        public ManagedHttpClientConnection create(HttpRoute httpRoute0) {
            ConnectionConfig connectionConfig0;
            if(httpRoute0.getProxyHost() == null) {
                connectionConfig0 = null;
            }
            else {
                HttpHost httpHost0 = httpRoute0.getProxyHost();
                connectionConfig0 = this.configData.getConnectionConfig(httpHost0);
            }
            if(connectionConfig0 == null) {
                HttpHost httpHost1 = httpRoute0.getTargetHost();
                connectionConfig0 = this.configData.getConnectionConfig(httpHost1);
            }
            if(connectionConfig0 == null) {
                connectionConfig0 = this.configData.getDefaultConnectionConfig();
            }
            if(connectionConfig0 == null) {
                connectionConfig0 = ConnectionConfig.DEFAULT;
            }
            return (ManagedHttpClientConnection)this.connFactory.create(httpRoute0, connectionConfig0);
        }
    }

    private static final String TAG = "HttpClient";
    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    private final CPool pool;

    public PoolingHttpClientConnectionManager() {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry());
    }

    public PoolingHttpClientConnectionManager(long v, TimeUnit timeUnit0) {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry(), null, null, null, v, timeUnit0);
    }

    public PoolingHttpClientConnectionManager(Registry registry0) {
        this(registry0, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry0, DnsResolver dnsResolver0) {
        this(registry0, null, dnsResolver0);
    }

    public PoolingHttpClientConnectionManager(Registry registry0, HttpConnectionFactory httpConnectionFactory0) {
        this(registry0, httpConnectionFactory0, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry0, HttpConnectionFactory httpConnectionFactory0, DnsResolver dnsResolver0) {
        this(registry0, httpConnectionFactory0, null, dnsResolver0, -1L, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry registry0, HttpConnectionFactory httpConnectionFactory0, SchemePortResolver schemePortResolver0, DnsResolver dnsResolver0, long v, TimeUnit timeUnit0) {
        ConfigData poolingHttpClientConnectionManager$ConfigData0 = new ConfigData();
        this.configData = poolingHttpClientConnectionManager$ConfigData0;
        this.pool = new CPool(new InternalConnectionFactory(poolingHttpClientConnectionManager$ConfigData0, httpConnectionFactory0), 2, 20, v, timeUnit0);
        this.connectionOperator = new HttpClientConnectionOperator(registry0, schemePortResolver0, dnsResolver0);
        this.isShutDown = new AtomicBoolean(false);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory httpConnectionFactory0) {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry(), httpConnectionFactory0, null);
    }

    public PoolingHttpClientConnectionManager(CPool cPool0, Lookup lookup0, SchemePortResolver schemePortResolver0, DnsResolver dnsResolver0) {
        this.configData = new ConfigData();
        this.pool = cPool0;
        this.connectionOperator = new HttpClientConnectionOperator(lookup0, schemePortResolver0, dnsResolver0);
        this.isShutDown = new AtomicBoolean(false);
    }

    @Override
    public void close() {
        this.shutdown();
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void closeExpiredConnections() {
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Closing expired connections");
        }
        this.pool.closeExpired();
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void closeIdleConnections(long v, TimeUnit timeUnit0) {
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Closing connections idle longer than " + v + " " + timeUnit0);
        }
        this.pool.closeIdle(v, timeUnit0);
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, int v, HttpContext httpContext0) {
        ManagedHttpClientConnection managedHttpClientConnection0;
        Args.notNull(httpClientConnection0, "Managed Connection");
        Args.notNull(httpRoute0, "HTTP route");
        synchronized(httpClientConnection0) {
            managedHttpClientConnection0 = (ManagedHttpClientConnection)CPoolProxy.getPoolEntry(httpClientConnection0).getConnection();
        }
        HttpHost httpHost0 = httpRoute0.getProxyHost() == null ? httpRoute0.getTargetHost() : httpRoute0.getProxyHost();
        InetSocketAddress inetSocketAddress0 = httpRoute0.getLocalAddress() == null ? null : new InetSocketAddress(httpRoute0.getLocalAddress(), 0);
        SocketConfig socketConfig0 = this.configData.getSocketConfig(httpHost0);
        if(socketConfig0 == null) {
            socketConfig0 = this.configData.getDefaultSocketConfig();
        }
        if(socketConfig0 == null) {
            socketConfig0 = SocketConfig.DEFAULT;
        }
        this.connectionOperator.connect(managedHttpClientConnection0, httpHost0, inetSocketAddress0, v, socketConfig0, httpContext0);
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

    private String format(HttpRoute httpRoute0, Object object0) {
        StringBuilder stringBuilder0 = new StringBuilder("[route: ");
        stringBuilder0.append(httpRoute0);
        stringBuilder0.append("]");
        if(object0 != null) {
            stringBuilder0.append("[state: ");
            stringBuilder0.append(object0);
            stringBuilder0.append("]");
        }
        return stringBuilder0.toString();
    }

    private String format(CPoolEntry cPoolEntry0) {
        StringBuilder stringBuilder0 = new StringBuilder("[id: ");
        stringBuilder0.append(cPoolEntry0.getId());
        stringBuilder0.append("][route: ");
        stringBuilder0.append(cPoolEntry0.getRoute());
        stringBuilder0.append("]");
        Object object0 = cPoolEntry0.getState();
        if(object0 != null) {
            stringBuilder0.append("[state: ");
            stringBuilder0.append(object0);
            stringBuilder0.append("]");
        }
        return stringBuilder0.toString();
    }

    private String formatStats(HttpRoute httpRoute0) {
        PoolStats poolStats0 = this.pool.getTotalStats();
        PoolStats poolStats1 = this.pool.getStats(httpRoute0);
        return "[total kept alive: " + poolStats0.getAvailable() + "; route allocated: " + (poolStats1.getAvailable() + poolStats1.getLeased()) + " of " + poolStats1.getMax() + "; total allocated: " + (poolStats0.getAvailable() + poolStats0.getLeased()) + " of " + poolStats0.getMax() + "]";
    }

    public ConnectionConfig getConnectionConfig(HttpHost httpHost0) {
        return this.configData.getConnectionConfig(httpHost0);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    private static Registry getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(Object object0) {
        return this.getMaxPerRoute(((HttpRoute)object0));
    }

    public int getMaxPerRoute(HttpRoute httpRoute0) {
        return this.pool.getMaxPerRoute(httpRoute0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    public SocketConfig getSocketConfig(HttpHost httpHost0) {
        return this.configData.getSocketConfig(httpHost0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(Object object0) {
        return this.getStats(((HttpRoute)object0));
    }

    public PoolStats getStats(HttpRoute httpRoute0) {
        return this.pool.getStats(httpRoute0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public HttpClientConnection leaseConnection(Future future0, long v, TimeUnit timeUnit0) {
        try {
            CPoolEntry cPoolEntry0 = (CPoolEntry)future0.get(v, timeUnit0);
            if(cPoolEntry0 == null || future0.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(cPoolEntry0.getConnection() != null, "Pool entry with no connection");
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connection leased: " + this.format(cPoolEntry0) + this.formatStats(((HttpRoute)cPoolEntry0.getRoute())));
            }
            return CPoolProxy.newProxy(cPoolEntry0);
        }
        catch(TimeoutException unused_ex) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void releaseConnection(HttpClientConnection httpClientConnection0, Object object0, long v, TimeUnit timeUnit0) {
        int v2;
        Args.notNull(httpClientConnection0, "Managed connection");
        synchronized(httpClientConnection0) {
            CPoolEntry cPoolEntry0 = CPoolProxy.detach(httpClientConnection0);
            if(cPoolEntry0 == null) {
                return;
            }
            ManagedHttpClientConnection managedHttpClientConnection0 = (ManagedHttpClientConnection)cPoolEntry0.getConnection();
            boolean z = false;
            v2 = FIN.finallyOpen$NT();
            if(managedHttpClientConnection0.isOpen()) {
                cPoolEntry0.setState(object0);
                cPoolEntry0.updateExpiry(v, (timeUnit0 == null ? TimeUnit.MILLISECONDS : timeUnit0));
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Connection " + this.format(cPoolEntry0) + " can be kept alive " + (v <= 0L ? "indefinitely" : "for " + ((double)v) / 1000.0 + " seconds"));
                }
            }
            FIN.finallyCodeBegin$NT(v2);
            CPool cPool0 = this.pool;
            if(managedHttpClientConnection0.isOpen() && cPoolEntry0.isRouteComplete()) {
                z = true;
            }
            cPool0.release(cPoolEntry0, z);
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connection released: " + this.format(cPoolEntry0) + this.formatStats(((HttpRoute)cPoolEntry0.getRoute())));
            }
        }
        FIN.finallyCodeEnd$NT(v2);
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public ConnectionRequest requestConnection(HttpRoute httpRoute0, Object object0) {
        Args.notNull(httpRoute0, "HTTP route");
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Connection request: " + this.format(httpRoute0, object0) + this.formatStats(httpRoute0));
        }
        return new ConnectionRequest() {
            @Override  // org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                return this.pool.lease(httpRoute0, object0, null).cancel(true);
            }

            @Override  // org.apache.http.conn.ConnectionRequest
            public HttpClientConnection get(long v, TimeUnit timeUnit0) {
                return PoolingHttpClientConnectionManager.this.leaseConnection(this.pool.lease(httpRoute0, object0, null), v, timeUnit0);
            }
        };
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpContext httpContext0) {
        Args.notNull(httpClientConnection0, "Managed Connection");
        Args.notNull(httpRoute0, "HTTP route");
        synchronized(httpClientConnection0) {
            CPoolProxy.getPoolEntry(httpClientConnection0).markRouteComplete();
        }
    }

    public void setConnectionConfig(HttpHost httpHost0, ConnectionConfig connectionConfig0) {
        this.configData.setConnectionConfig(httpHost0, connectionConfig0);
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionConfig0) {
        this.configData.setDefaultConnectionConfig(connectionConfig0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int v) {
        this.pool.setDefaultMaxPerRoute(v);
    }

    public void setDefaultSocketConfig(SocketConfig socketConfig0) {
        this.configData.setDefaultSocketConfig(socketConfig0);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(Object object0, int v) {
        this.setMaxPerRoute(((HttpRoute)object0), v);
    }

    public void setMaxPerRoute(HttpRoute httpRoute0, int v) {
        this.pool.setMaxPerRoute(httpRoute0, v);
    }

    @Override  // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int v) {
        this.pool.setMaxTotal(v);
    }

    public void setSocketConfig(HttpHost httpHost0, SocketConfig socketConfig0) {
        this.configData.setSocketConfig(httpHost0, socketConfig0);
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void shutdown() {
        if(this.isShutDown.compareAndSet(false, true)) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connection manager is shutting down");
            }
            try {
                this.pool.shutdown();
            }
            catch(IOException iOException0) {
                Log.d("HttpClient", "I/O exception shutting down connection manager", iOException0);
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connection manager shut down");
            }
        }
    }

    @Override  // org.apache.http.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpContext httpContext0) {
        ManagedHttpClientConnection managedHttpClientConnection0;
        Args.notNull(httpClientConnection0, "Managed Connection");
        Args.notNull(httpRoute0, "HTTP route");
        synchronized(httpClientConnection0) {
            managedHttpClientConnection0 = (ManagedHttpClientConnection)CPoolProxy.getPoolEntry(httpClientConnection0).getConnection();
        }
        HttpHost httpHost0 = httpRoute0.getTargetHost();
        this.connectionOperator.upgrade(managedHttpClientConnection0, httpHost0, httpContext0);
    }
}

