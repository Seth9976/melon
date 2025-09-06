package org.apache.http.client;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpClient {
    Object execute(HttpHost arg1, HttpRequest arg2, ResponseHandler arg3);

    Object execute(HttpHost arg1, HttpRequest arg2, ResponseHandler arg3, HttpContext arg4);

    Object execute(HttpUriRequest arg1, ResponseHandler arg2);

    Object execute(HttpUriRequest arg1, ResponseHandler arg2, HttpContext arg3);

    HttpResponse execute(HttpHost arg1, HttpRequest arg2);

    HttpResponse execute(HttpHost arg1, HttpRequest arg2, HttpContext arg3);

    HttpResponse execute(HttpUriRequest arg1);

    HttpResponse execute(HttpUriRequest arg1, HttpContext arg2);

    ClientConnectionManager getConnectionManager();

    HttpParams getParams();
}

