package org.apache.http.impl.client;

import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpHeadHC4;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.TextUtils;

@Immutable
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final DefaultRedirectStrategy INSTANCE = null;
    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String[] REDIRECT_METHODS = null;
    private static final String TAG = "HttpClient";

    static {
        DefaultRedirectStrategy.INSTANCE = new DefaultRedirectStrategy();
        DefaultRedirectStrategy.REDIRECT_METHODS = new String[]{"GET", "HEAD"};
    }

    public URI createLocationURI(String s) {
        try {
            URIBuilder uRIBuilder0 = new URIBuilder(new URI(s).normalize());
            String s1 = uRIBuilder0.getHost();
            if(s1 != null) {
                uRIBuilder0.setHost(s1.toLowerCase(Locale.ENGLISH));
            }
            if(TextUtils.isEmpty(uRIBuilder0.getPath())) {
                uRIBuilder0.setPath("/");
            }
            return uRIBuilder0.build();
        }
        catch(URISyntaxException uRISyntaxException0) {
        }
        throw new ProtocolException("Invalid redirect URI: " + s, uRISyntaxException0);
    }

    public URI getLocationURI(HttpRequest httpRequest0, HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        Args.notNull(httpResponse0, "HTTP response");
        Args.notNull(httpContext0, "HTTP context");
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        Header header0 = httpResponse0.getFirstHeader("location");
        if(header0 == null) {
            throw new ProtocolException("Received redirect response " + httpResponse0.getStatusLine() + " but no location header");
        }
        String s = header0.getValue();
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Redirect requested to location \'" + s + "\'");
        }
        RequestConfig requestConfig0 = httpClientContext0.getRequestConfig();
        URI uRI0 = this.createLocationURI(s);
        try {
            if(!uRI0.isAbsolute()) {
                if(!requestConfig0.isRelativeRedirectsAllowed()) {
                    throw new ProtocolException("Relative redirect location \'" + uRI0 + "\' not allowed");
                }
                HttpHost httpHost0 = httpClientContext0.getTargetHost();
                Asserts.notNull(httpHost0, "Target host");
                uRI0 = URIUtilsHC4.resolve(URIUtilsHC4.rewriteURI(new URI(httpRequest0.getRequestLine().getUri()), httpHost0, false), uRI0);
            }
        }
        catch(URISyntaxException uRISyntaxException0) {
            throw new ProtocolException(uRISyntaxException0.getMessage(), uRISyntaxException0);
        }
        RedirectLocationsHC4 redirectLocationsHC40 = (RedirectLocationsHC4)httpClientContext0.getAttribute("http.protocol.redirect-locations");
        if(redirectLocationsHC40 == null) {
            redirectLocationsHC40 = new RedirectLocationsHC4();
            httpContext0.setAttribute("http.protocol.redirect-locations", redirectLocationsHC40);
        }
        if(!requestConfig0.isCircularRedirectsAllowed() && redirectLocationsHC40.contains(uRI0)) {
            throw new CircularRedirectException("Circular redirect to \'" + uRI0 + "\'");
        }
        redirectLocationsHC40.add(uRI0);
        return uRI0;
    }

    @Override  // org.apache.http.client.RedirectStrategy
    public HttpUriRequest getRedirect(HttpRequest httpRequest0, HttpResponse httpResponse0, HttpContext httpContext0) {
        URI uRI0 = this.getLocationURI(httpRequest0, httpResponse0, httpContext0);
        String s = httpRequest0.getRequestLine().getMethod();
        if(s.equalsIgnoreCase("HEAD")) {
            return new HttpHeadHC4(uRI0);
        }
        if(s.equalsIgnoreCase("GET")) {
            return new HttpGetHC4(uRI0);
        }
        return httpResponse0.getStatusLine().getStatusCode() == 307 ? RequestBuilder.copy(httpRequest0).setUri(uRI0).build() : new HttpGetHC4(uRI0);
    }

    public boolean isRedirectable(String s) {
        String[] arr_s = DefaultRedirectStrategy.REDIRECT_METHODS;
        for(int v = 0; v < arr_s.length; ++v) {
            if(arr_s[v].equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    @Override  // org.apache.http.client.RedirectStrategy
    public boolean isRedirected(HttpRequest httpRequest0, HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        Args.notNull(httpResponse0, "HTTP response");
        int v = httpResponse0.getStatusLine().getStatusCode();
        String s = httpRequest0.getRequestLine().getMethod();
        Header header0 = httpResponse0.getFirstHeader("location");
        if(v != 307) {
            switch(v) {
                case 301: {
                    break;
                }
                case 302: {
                    return this.isRedirectable(s) && header0 != null;
                }
                case 303: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return this.isRedirectable(s);
    }
}

