package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpPatch extends HttpEntityEnclosingRequestBaseHC4 {
    public static final String METHOD_NAME = "PATCH";

    public HttpPatch() {
    }

    public HttpPatch(String s) {
        this.setURI(URI.create(s));
    }

    public HttpPatch(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "PATCH";
    }
}

