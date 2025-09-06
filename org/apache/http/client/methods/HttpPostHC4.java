package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpPostHC4 extends HttpEntityEnclosingRequestBaseHC4 {
    public static final String METHOD_NAME = "POST";

    public HttpPostHC4() {
    }

    public HttpPostHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpPostHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "POST";
    }
}

