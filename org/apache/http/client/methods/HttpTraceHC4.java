package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpTraceHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "TRACE";

    public HttpTraceHC4() {
    }

    public HttpTraceHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpTraceHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "TRACE";
    }
}

