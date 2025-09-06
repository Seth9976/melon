package org.apache.http.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.AbstractConnPool;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
public class BasicConnPool extends AbstractConnPool {
    private static final AtomicLong COUNTER;

    static {
        BasicConnPool.COUNTER = new AtomicLong();
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    public BasicConnPool(SocketConfig socketConfig0, ConnectionConfig connectionConfig0) {
        super(new BasicConnFactory(socketConfig0, connectionConfig0), 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams0) {
        super(new BasicConnFactory(httpParams0), 2, 20);
    }

    public BasicConnPool(ConnFactory connFactory0) {
        super(connFactory0, 2, 20);
    }

    // 去混淆评级： 低(20)
    public BasicPoolEntry createEntry(HttpHost httpHost0, HttpClientConnection httpClientConnection0) {
        return new BasicPoolEntry("0", httpHost0, httpClientConnection0);
    }

    @Override  // org.apache.http.pool.AbstractConnPool
    public PoolEntry createEntry(Object object0, Object object1) {
        return this.createEntry(((HttpHost)object0), ((HttpClientConnection)object1));
    }
}

