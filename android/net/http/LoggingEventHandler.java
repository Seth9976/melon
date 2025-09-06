package android.net.http;

public class LoggingEventHandler implements EventHandler {
    public LoggingEventHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void certificate(SslCertificate sslCertificate0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void data(byte[] arr_b, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void endData() {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void error(int v, String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public boolean handleSslErrorRequest(SslError sslError0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void headers(Headers headers0) {
        throw new RuntimeException("Stub!");
    }

    public void locationChanged(String s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void requestSent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.EventHandler
    public void status(int v, int v1, int v2, String s) {
        throw new RuntimeException("Stub!");
    }
}

