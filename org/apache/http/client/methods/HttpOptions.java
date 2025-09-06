package org.apache.http.client.methods;

import java.net.URI;
import java.util.Set;
import org.apache.http.HttpResponse;

@Deprecated
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions() {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(URI uRI0) {
        throw new RuntimeException("Stub!");
    }

    public Set getAllowedMethods(HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpRequestBase
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}

