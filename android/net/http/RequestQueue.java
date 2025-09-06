package android.net.http;

import android.content.Context;
import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpHost;

public class RequestQueue implements RequestFeeder {
    public RequestQueue(Context context0) {
        throw new RuntimeException("Stub!");
    }

    public RequestQueue(Context context0, int v) {
        throw new RuntimeException("Stub!");
    }

    public void disablePlatformNotifications() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void enablePlatformNotifications() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public HttpHost getProxyHost() {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.RequestFeeder
    public Request getRequest() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // android.net.http.RequestFeeder
    public Request getRequest(HttpHost httpHost0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // android.net.http.RequestFeeder
    public boolean haveRequest(HttpHost httpHost0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public RequestHandle queueRequest(String s, WebAddress webAddress0, String s1, Map map0, EventHandler eventHandler0, InputStream inputStream0, int v) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle queueRequest(String s, String s1, Map map0, EventHandler eventHandler0, InputStream inputStream0, int v) {
        throw new RuntimeException("Stub!");
    }

    public void queueRequest(Request request0, boolean z) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public RequestHandle queueSynchronousRequest(String s, WebAddress webAddress0, String s1, Map map0, EventHandler eventHandler0, InputStream inputStream0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // android.net.http.RequestFeeder
    public void requeueRequest(Request request0) {
        throw new RuntimeException("Stub!");
    }

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    public void startTiming() {
        throw new RuntimeException("Stub!");
    }

    public void stopTiming() {
        throw new RuntimeException("Stub!");
    }
}

