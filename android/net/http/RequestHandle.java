package android.net.http;

import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;

public class RequestHandle {
    public static final int MAX_REDIRECT_COUNT = 16;

    public RequestHandle(RequestQueue requestQueue0, String s, WebAddress webAddress0, String s1, Map map0, InputStream inputStream0, int v, Request request0) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle(RequestQueue requestQueue0, String s, WebAddress webAddress0, String s1, Map map0, InputStream inputStream0, int v, Request request0, Connection connection0) {
        throw new RuntimeException("Stub!");
    }

    public static String authorizationHeader(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    public static String computeBasicAuthResponse(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public int getRedirectCount() {
        throw new RuntimeException("Stub!");
    }

    public void handleSslErrorResponse(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public boolean isRedirectMax() {
        throw new RuntimeException("Stub!");
    }

    public void pauseRequest(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void processRequest() {
        throw new RuntimeException("Stub!");
    }

    public void setRedirectCount(int v) {
        throw new RuntimeException("Stub!");
    }

    public void setupBasicAuthResponse(boolean z, String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public void setupDigestAuthResponse(boolean z, String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        throw new RuntimeException("Stub!");
    }

    public boolean setupRedirect(String s, int v, Map map0) {
        throw new RuntimeException("Stub!");
    }

    public void waitUntilComplete() {
        throw new RuntimeException("Stub!");
    }
}

