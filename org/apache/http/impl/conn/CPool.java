package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.AbstractConnPool;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
class CPool extends AbstractConnPool {
    private static final AtomicLong COUNTER;
    private final long timeToLive;
    private final TimeUnit tunit;

    static {
        CPool.COUNTER = new AtomicLong();
    }

    public CPool(ConnFactory connFactory0, int v, int v1, long v2, TimeUnit timeUnit0) {
        super(connFactory0, v, v1);
        this.timeToLive = v2;
        this.tunit = timeUnit0;
    }

    // 去混淆评级： 低(20)
    public CPoolEntry createEntry(HttpRoute httpRoute0, ManagedHttpClientConnection managedHttpClientConnection0) {
        return new CPoolEntry("0", httpRoute0, managedHttpClientConnection0, this.timeToLive, this.tunit);
    }

    @Override  // org.apache.http.pool.AbstractConnPool
    public PoolEntry createEntry(Object object0, Object object1) {
        return this.createEntry(((HttpRoute)object0), ((ManagedHttpClientConnection)object1));
    }
}

