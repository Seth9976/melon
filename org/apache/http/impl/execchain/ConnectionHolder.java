package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.HttpClientConnectionManager;

@ThreadSafe
class ConnectionHolder implements Closeable, Cancellable, ConnectionReleaseTrigger {
    private static final String TAG = "HttpClient";
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientConnectionManager httpClientConnectionManager0, HttpClientConnection httpClientConnection0) {
        this.manager = httpClientConnectionManager0;
        this.managedConn = httpClientConnection0;
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        synchronized(this.managedConn) {
            try {
                if(this.released) {
                    return;
                }
                goto label_8;
            }
            catch(Throwable throwable0) {
                this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                throw throwable0;
            }
        }
        return;
        try {
            try {
            label_8:
                this.released = true;
                this.managedConn.shutdown();
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Connection discarded");
                }
                goto label_22;
            }
            catch(IOException iOException0) {
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", iOException0.getMessage(), iOException0);
            }
        }
        catch(Throwable throwable0) {
            this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
            throw throwable0;
        }
        this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
        return;
    label_22:
        this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
    }

    @Override  // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        boolean z = this.released;
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Cancelling request execution");
        }
        this.abortConnection();
        return !z;
    }

    @Override
    public void close() {
        this.abortConnection();
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void markReusable() {
        this.reusable = true;
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        synchronized(this.managedConn) {
            if(this.released) {
                return;
            }
            this.released = true;
            if(this.reusable) {
                this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.tunit);
            }
            else {
                try {
                    try {
                        this.managedConn.close();
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Connection discarded");
                        }
                        goto label_25;
                    }
                    catch(IOException iOException0) {
                    }
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", iOException0.getMessage(), iOException0);
                    }
                }
                catch(Throwable throwable0) {
                    this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                    throw throwable0;
                }
                this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                return;
            label_25:
                this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void setState(Object object0) {
        this.state = object0;
    }

    public void setValidFor(long v, TimeUnit timeUnit0) {
        synchronized(this.managedConn) {
            this.validDuration = v;
            this.tunit = timeUnit0;
        }
    }
}

