package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpPutHC4 extends HttpEntityEnclosingRequestBaseHC4 {
    public static final String METHOD_NAME = "PUT";

    public HttpPutHC4() {
    }

    public HttpPutHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpPutHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "PUT";
    }
}

