package org.apache.http.client.protocol;

import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Lookup;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
public class RequestAddCookiesHC4 implements HttpRequestInterceptor {
    private static final String TAG = "HttpClient";

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        URI uRI0;
        Args.notNull(httpRequest0, "HTTP request");
        Args.notNull(httpContext0, "HTTP context");
        if(!httpRequest0.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
            CookieStore cookieStore0 = httpClientContext0.getCookieStore();
            if(cookieStore0 != null) {
                Lookup lookup0 = httpClientContext0.getCookieSpecRegistry();
                if(lookup0 != null) {
                    HttpHost httpHost0 = httpClientContext0.getTargetHost();
                    if(httpHost0 != null) {
                        RouteInfo routeInfo0 = httpClientContext0.getHttpRoute();
                        if(routeInfo0 != null) {
                            String s = httpClientContext0.getRequestConfig().getCookieSpec();
                            if(s == null) {
                                s = "best-match";
                            }
                            if(Log.isLoggable("HttpClient", 3)) {
                                Log.d("HttpClient", "CookieSpec selected: " + s);
                            }
                            String s1 = null;
                            if(httpRequest0 instanceof HttpUriRequest) {
                                uRI0 = ((HttpUriRequest)httpRequest0).getURI();
                            }
                            else {
                                try {
                                    uRI0 = null;
                                    uRI0 = new URI(httpRequest0.getRequestLine().getUri());
                                }
                                catch(URISyntaxException unused_ex) {
                                }
                            }
                            if(uRI0 != null) {
                                s1 = uRI0.getPath();
                            }
                            String s2 = httpHost0.getHostName();
                            int v = httpHost0.getPort();
                            if(v < 0) {
                                v = routeInfo0.getTargetHost().getPort();
                            }
                            boolean z = false;
                            if(v < 0) {
                                v = 0;
                            }
                            if(TextUtils.isEmpty(s1)) {
                                s1 = "/";
                            }
                            CookieOrigin cookieOrigin0 = new CookieOrigin(s2, v, s1, routeInfo0.isSecure());
                            CookieSpecProvider cookieSpecProvider0 = (CookieSpecProvider)lookup0.lookup(s);
                            if(cookieSpecProvider0 == null) {
                                throw new HttpException("Unsupported cookie policy: " + s);
                            }
                            CookieSpec cookieSpec0 = cookieSpecProvider0.create(httpClientContext0);
                            ArrayList arrayList0 = new ArrayList(cookieStore0.getCookies());
                            ArrayList arrayList1 = new ArrayList();
                            Date date0 = new Date();
                            for(Object object0: arrayList0) {
                                Cookie cookie0 = (Cookie)object0;
                                if(!cookie0.isExpired(date0)) {
                                    if(!cookieSpec0.match(cookie0, cookieOrigin0)) {
                                        continue;
                                    }
                                    if(Log.isLoggable("HttpClient", 3)) {
                                        Log.d("HttpClient", "Cookie " + cookie0 + " match " + cookieOrigin0);
                                    }
                                    arrayList1.add(cookie0);
                                }
                                else if(Log.isLoggable("HttpClient", 3)) {
                                    Log.d("HttpClient", "Cookie " + cookie0 + " expired");
                                }
                            }
                            if(!arrayList1.isEmpty()) {
                                for(Object object1: cookieSpec0.formatCookies(arrayList1)) {
                                    httpRequest0.addHeader(((Header)object1));
                                }
                            }
                            int v1 = cookieSpec0.getVersion();
                            if(v1 > 0) {
                                for(Object object2: arrayList1) {
                                    if(v1 != ((Cookie)object2).getVersion() || !(((Cookie)object2) instanceof SetCookie2)) {
                                        z = true;
                                    }
                                }
                                if(z) {
                                    Header header0 = cookieSpec0.getVersionHeader();
                                    if(header0 != null) {
                                        httpRequest0.addHeader(header0);
                                    }
                                }
                            }
                            httpContext0.setAttribute("http.cookie-spec", cookieSpec0);
                            httpContext0.setAttribute("http.cookie-origin", cookieOrigin0);
                        }
                        else if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Connection route not set in the context");
                        }
                    }
                    else if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Target host not set in the context");
                    }
                }
                else if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "CookieSpec registry not specified in HTTP context");
                }
            }
            else if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Cookie store not specified in HTTP context");
            }
        }
    }
}

