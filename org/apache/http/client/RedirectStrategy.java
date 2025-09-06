package org.apache.http.client;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public interface RedirectStrategy {
    HttpUriRequest getRedirect(HttpRequest arg1, HttpResponse arg2, HttpContext arg3);

    boolean isRedirected(HttpRequest arg1, HttpResponse arg2, HttpContext arg3);
}

