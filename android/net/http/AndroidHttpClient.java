package android.net.http;

import android.content.ContentResolver;
import android.content.Context;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public final class AndroidHttpClient implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES;

    public AndroidHttpClient() {
        throw new RuntimeException("Stub!");
    }

    public void close() {
        throw new RuntimeException("Stub!");
    }

    public void disableCurlLogging() {
        throw new RuntimeException("Stub!");
    }

    public void enableCurlLogging(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void finalize() {
        throw new RuntimeException("Stub!");
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] arr_b, ContentResolver contentResolver0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    public static long getMinGzipSize(ContentResolver contentResolver0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    public static InputStream getUngzippedContent(HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String s) {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String s, Context context0) {
        throw new RuntimeException("Stub!");
    }

    public static long parseDate(String s) {
        throw new RuntimeException("Stub!");
    }
}

