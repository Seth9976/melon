package com.android.volley.toolbox;

import com.android.volley.Header;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack extends BaseHttpStack {
    static class UrlConnectionInputStream extends FilterInputStream {
        private final HttpURLConnection mConnection;

        public UrlConnectionInputStream(HttpURLConnection httpURLConnection0) {
            super(HurlStack.inputStreamFromConnection(httpURLConnection0));
            this.mConnection = httpURLConnection0;
        }

        @Override
        public void close() {
            super.close();
            this.mConnection.disconnect();
        }
    }

    public interface UrlRewriter {
        String rewriteUrl(String arg1);
    }

    private static final int HTTP_CONTINUE = 100;
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter hurlStack$UrlRewriter0) {
        this(hurlStack$UrlRewriter0, null);
    }

    public HurlStack(UrlRewriter hurlStack$UrlRewriter0, SSLSocketFactory sSLSocketFactory0) {
        this.mUrlRewriter = hurlStack$UrlRewriter0;
        this.mSslSocketFactory = sSLSocketFactory0;
    }

    private static void addBody(HttpURLConnection httpURLConnection0, Request request0, byte[] arr_b) {
        httpURLConnection0.setDoOutput(true);
        if(!httpURLConnection0.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection0.setRequestProperty("Content-Type", request0.getBodyContentType());
        }
        DataOutputStream dataOutputStream0 = new DataOutputStream(httpURLConnection0.getOutputStream());
        dataOutputStream0.write(arr_b);
        dataOutputStream0.close();
    }

    private static void addBodyIfExists(HttpURLConnection httpURLConnection0, Request request0) {
        byte[] arr_b = request0.getBody();
        if(arr_b != null) {
            HurlStack.addBody(httpURLConnection0, request0, arr_b);
        }
    }

    public static List convertHeaders(Map map0) {
        List list0 = new ArrayList(map0.size());
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(map$Entry0.getKey() != null) {
                for(Object object1: ((List)map$Entry0.getValue())) {
                    ((ArrayList)list0).add(new Header(((String)map$Entry0.getKey()), ((String)object1)));
                }
            }
        }
        return list0;
    }

    public HttpURLConnection createConnection(URL uRL0) {
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)uRL0.openConnection();
        httpURLConnection0.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection0;
    }

    @Override  // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request request0, Map map0) {
        HttpResponse httpResponse0;
        String s = request0.getUrl();
        HashMap hashMap0 = new HashMap();
        hashMap0.putAll(map0);
        hashMap0.putAll(request0.getHeaders());
        UrlRewriter hurlStack$UrlRewriter0 = this.mUrlRewriter;
        if(hurlStack$UrlRewriter0 != null) {
            String s1 = hurlStack$UrlRewriter0.rewriteUrl(s);
            if(s1 == null) {
                throw new IOException("URL blocked by rewriter: " + s);
            }
            s = s1;
        }
        HttpURLConnection httpURLConnection0 = this.openConnection(new URL(s), request0);
        boolean z = false;
        try {
            for(Object object0: hashMap0.keySet()) {
                httpURLConnection0.setRequestProperty(((String)object0), ((String)hashMap0.get(((String)object0))));
            }
            HurlStack.setConnectionParametersForRequest(httpURLConnection0, request0);
            int v = httpURLConnection0.getResponseCode();
            if(v == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if(HurlStack.hasResponseBody(request0.getMethod(), v)) {
                z = true;
                return new HttpResponse(v, HurlStack.convertHeaders(httpURLConnection0.getHeaderFields()), httpURLConnection0.getContentLength(), new UrlConnectionInputStream(httpURLConnection0));
            }
            httpResponse0 = new HttpResponse(v, HurlStack.convertHeaders(httpURLConnection0.getHeaderFields()));
            goto label_31;
        label_28:
            if(z) {
                throw throwable0;
            }
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
        httpURLConnection0.disconnect();
        throw throwable0;
    label_31:
        httpURLConnection0.disconnect();
        return httpResponse0;
    }

    private static boolean hasResponseBody(int v, int v1) {
        return v != 4 && (100 > v1 || v1 >= 200) && (v1 != 204 && v1 != 304);
    }

    private static InputStream inputStreamFromConnection(HttpURLConnection httpURLConnection0) {
        try {
            return httpURLConnection0.getInputStream();
        }
        catch(IOException unused_ex) {
            return httpURLConnection0.getErrorStream();
        }
    }

    private HttpURLConnection openConnection(URL uRL0, Request request0) {
        HttpURLConnection httpURLConnection0 = this.createConnection(uRL0);
        int v = request0.getTimeoutMs();
        httpURLConnection0.setConnectTimeout(v);
        httpURLConnection0.setReadTimeout(v);
        httpURLConnection0.setUseCaches(false);
        httpURLConnection0.setDoInput(true);
        if("https".equals(uRL0.getProtocol())) {
            SSLSocketFactory sSLSocketFactory0 = this.mSslSocketFactory;
            if(sSLSocketFactory0 != null) {
                ((HttpsURLConnection)httpURLConnection0).setSSLSocketFactory(sSLSocketFactory0);
            }
        }
        return httpURLConnection0;
    }

    public static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection0, Request request0) {
        switch(request0.getMethod()) {
            case -1: {
                byte[] arr_b = request0.getPostBody();
                if(arr_b != null) {
                    httpURLConnection0.setRequestMethod("POST");
                    HurlStack.addBody(httpURLConnection0, request0, arr_b);
                }
                return;
            }
            case 0: {
                httpURLConnection0.setRequestMethod("GET");
                return;
            }
            case 1: {
                httpURLConnection0.setRequestMethod("POST");
                HurlStack.addBodyIfExists(httpURLConnection0, request0);
                return;
            }
            case 2: {
                httpURLConnection0.setRequestMethod("PUT");
                HurlStack.addBodyIfExists(httpURLConnection0, request0);
                return;
            }
            case 3: {
                httpURLConnection0.setRequestMethod("DELETE");
                return;
            }
            case 4: {
                httpURLConnection0.setRequestMethod("HEAD");
                return;
            }
            case 5: {
                httpURLConnection0.setRequestMethod("OPTIONS");
                return;
            }
            case 6: {
                httpURLConnection0.setRequestMethod("TRACE");
                return;
            }
            case 7: {
                httpURLConnection0.setRequestMethod("PATCH");
                HurlStack.addBodyIfExists(httpURLConnection0, request0);
                return;
            }
            default: {
                throw new IllegalStateException("Unknown method type.");
            }
        }
    }
}

