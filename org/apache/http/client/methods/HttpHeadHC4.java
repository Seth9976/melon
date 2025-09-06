package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpHeadHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "HEAD";

    public HttpHeadHC4() {
    }

    public HttpHeadHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpHeadHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "HEAD";
    }
}

