package android.net.http;

import java.io.File;

public class HttpsConnection extends Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    public HttpsConnection() {
        super(null, null, null);
        throw new RuntimeException("Stub!");
    }

    public static void initializeEngine(File file0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.Connection
    public String toString() {
        return super.toString();
    }
}

