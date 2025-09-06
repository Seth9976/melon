package android.net.http;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;

public class AndroidHttpClientConnection implements HttpConnection, HttpInetConnection {
    public AndroidHttpClientConnection() {
        throw new RuntimeException("Stub!");
    }

    public void bind(Socket socket0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public void doFlush() {
        throw new RuntimeException("Stub!");
    }

    public void flush() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    public StatusLine parseResponseHeader(Headers headers0) {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity receiveResponseEntity(Headers headers0) {
        throw new RuntimeException("Stub!");
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        throw new RuntimeException("Stub!");
    }

    public void sendRequestHeader(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void setSocketTimeout(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

