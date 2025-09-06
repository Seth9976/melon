package org.apache.http.impl.pool;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
public class BasicPoolEntry extends PoolEntry {
    public BasicPoolEntry(String s, HttpHost httpHost0, HttpClientConnection httpClientConnection0) {
        super(s, httpHost0, httpClientConnection0);
    }

    @Override  // org.apache.http.pool.PoolEntry
    public void close() {
        try {
            ((HttpClientConnection)this.getConnection()).close();
        }
        catch(IOException unused_ex) {
        }
    }

    @Override  // org.apache.http.pool.PoolEntry
    public boolean isClosed() {
        return !((HttpClientConnection)this.getConnection()).isOpen();
    }
}

