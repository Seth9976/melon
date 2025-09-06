package org.apache.http.client.protocol;

import android.util.Log;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestClientConnControl implements HttpRequestInterceptor {
    private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
    private static final String TAG = "HttpClient";

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(httpRequest0.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            httpRequest0.setHeader("Proxy-Connection", "Keep-Alive");
            return;
        }
        RouteInfo routeInfo0 = HttpClientContext.adapt(httpContext0).getHttpRoute();
        if(routeInfo0 != null) {
            if((routeInfo0.getHopCount() == 1 || routeInfo0.isTunnelled()) && !httpRequest0.containsHeader("Connection")) {
                httpRequest0.addHeader("Connection", "Keep-Alive");
            }
            if(routeInfo0.getHopCount() == 2 && !routeInfo0.isTunnelled() && !httpRequest0.containsHeader("Proxy-Connection")) {
                httpRequest0.addHeader("Proxy-Connection", "Keep-Alive");
            }
        }
        else if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Connection route not set in the context");
        }
    }
}

