package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpGetHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "GET";

    public HttpGetHC4() {
    }

    public HttpGetHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpGetHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "GET";
    }
}

