package org.apache.http.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface RedirectHandler {
    URI getLocationURI(HttpResponse arg1, HttpContext arg2);

    boolean isRedirectRequested(HttpResponse arg1, HttpContext arg2);
}

