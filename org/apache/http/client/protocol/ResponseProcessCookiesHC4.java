package org.apache.http.client.protocol;

import android.util.Log;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class ResponseProcessCookiesHC4 implements HttpResponseInterceptor {
    private static final String TAG = "HttpClient";

    private static String formatCooke(Cookie cookie0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(cookie0.getName());
        stringBuilder0.append("=\"");
        String s = cookie0.getValue();
        if(s.length() > 100) {
            s = s.substring(0, 100) + "...";
        }
        stringBuilder0.append(s);
        stringBuilder0.append("\", version:");
        stringBuilder0.append(Integer.toString(cookie0.getVersion()));
        stringBuilder0.append(", domain:");
        stringBuilder0.append(cookie0.getDomain());
        stringBuilder0.append(", path:");
        stringBuilder0.append(cookie0.getPath());
        stringBuilder0.append(", expiry:");
        stringBuilder0.append(cookie0.getExpiryDate());
        return stringBuilder0.toString();
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpResponse0, "HTTP request");
        Args.notNull(httpContext0, "HTTP context");
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        CookieSpec cookieSpec0 = httpClientContext0.getCookieSpec();
        if(cookieSpec0 != null) {
            CookieStore cookieStore0 = httpClientContext0.getCookieStore();
            if(cookieStore0 != null) {
                CookieOrigin cookieOrigin0 = httpClientContext0.getCookieOrigin();
                if(cookieOrigin0 != null) {
                    this.processCookies(httpResponse0.headerIterator("Set-Cookie"), cookieSpec0, cookieOrigin0, cookieStore0);
                    if(cookieSpec0.getVersion() > 0) {
                        this.processCookies(httpResponse0.headerIterator("Set-Cookie2"), cookieSpec0, cookieOrigin0, cookieStore0);
                    }
                }
                else if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Cookie origin not specified in HTTP context");
                }
            }
            else if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Cookie store not specified in HTTP context");
            }
        }
        else if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Cookie spec not specified in HTTP context");
        }
    }

    private void processCookies(HeaderIterator headerIterator0, CookieSpec cookieSpec0, CookieOrigin cookieOrigin0, CookieStore cookieStore0) {
        while(headerIterator0.hasNext()) {
            Header header0 = headerIterator0.nextHeader();
            try {
                for(Object object0: cookieSpec0.parse(header0, cookieOrigin0)) {
                    Cookie cookie0 = (Cookie)object0;
                    try {
                        cookieSpec0.validate(cookie0, cookieOrigin0);
                        cookieStore0.addCookie(cookie0);
                        if(!Log.isLoggable("HttpClient", 3)) {
                            continue;
                        }
                        Log.d("HttpClient", "Cookie accepted [" + ResponseProcessCookiesHC4.formatCooke(cookie0) + "]");
                    }
                    catch(MalformedCookieException malformedCookieException1) {
                        if(!Log.isLoggable("HttpClient", 5)) {
                            continue;
                        }
                        Log.w("HttpClient", "Cookie rejected [" + ResponseProcessCookiesHC4.formatCooke(cookie0) + "] " + malformedCookieException1.getMessage());
                    }
                }
            }
            catch(MalformedCookieException malformedCookieException0) {
                if(!Log.isLoggable("HttpClient", 5)) {
                    continue;
                }
                Log.w("HttpClient", "Invalid cookie header: \"" + header0 + "\". " + malformedCookieException0.getMessage());
            }
        }
    }
}

