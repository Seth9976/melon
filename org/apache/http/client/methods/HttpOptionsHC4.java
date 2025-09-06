package org.apache.http.client.methods;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class HttpOptionsHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptionsHC4() {
    }

    public HttpOptionsHC4(String s) {
        this.setURI(URI.create(s));
    }

    public HttpOptionsHC4(URI uRI0) {
        this.setURI(uRI0);
    }

    public Set getAllowedMethods(HttpResponse httpResponse0) {
        Args.notNull(httpResponse0, "HTTP response");
        HeaderIterator headerIterator0 = httpResponse0.headerIterator("Allow");
        Set set0 = new HashSet();
        while(headerIterator0.hasNext()) {
            HeaderElement[] arr_headerElement = headerIterator0.nextHeader().getElements();
            for(int v = 0; v < arr_headerElement.length; ++v) {
                ((HashSet)set0).add(arr_headerElement[v].getName());
            }
        }
        return set0;
    }

    @Override  // org.apache.http.client.methods.HttpRequestBaseHC4
    public String getMethod() {
        return "OPTIONS";
    }
}

