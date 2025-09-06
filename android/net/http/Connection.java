package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;

abstract class Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    public Connection(Context context0, HttpHost httpHost0, RequestFeeder requestFeeder0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }
}

