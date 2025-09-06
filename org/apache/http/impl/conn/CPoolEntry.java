package org.apache.http.impl.conn;

import android.util.Log;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
class CPoolEntry extends PoolEntry {
    private static final String TAG = "HttpClient";
    private volatile boolean routeComplete;

    public CPoolEntry(String s, HttpRoute httpRoute0, ManagedHttpClientConnection managedHttpClientConnection0, long v, TimeUnit timeUnit0) {
        super(s, httpRoute0, managedHttpClientConnection0, v, timeUnit0);
    }

    @Override  // org.apache.http.pool.PoolEntry
    public void close() {
        try {
            this.closeConnection();
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "I/O error closing connection", iOException0);
            }
        }
    }

    public void closeConnection() {
        ((HttpClientConnection)this.getConnection()).close();
    }

    @Override  // org.apache.http.pool.PoolEntry
    public boolean isClosed() {
        return !((HttpClientConnection)this.getConnection()).isOpen();
    }

    @Override  // org.apache.http.pool.PoolEntry
    public boolean isExpired(long v) {
        boolean z = super.isExpired(v);
        if(z && Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Connection " + this + " expired @ " + new Date(this.getExpiry()));
        }
        return z;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public void shutdownConnection() {
        ((HttpClientConnection)this.getConnection()).shutdown();
    }
}

