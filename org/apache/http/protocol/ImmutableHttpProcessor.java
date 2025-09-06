package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(List list0, List list1) {
        this.requestInterceptors = list0 == null ? new HttpRequestInterceptor[0] : ((HttpRequestInterceptor[])list0.toArray(new HttpRequestInterceptor[list0.size()]));
        if(list1 != null) {
            this.responseInterceptors = (HttpResponseInterceptor[])list1.toArray(new HttpResponseInterceptor[list1.size()]);
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList httpRequestInterceptorList0, HttpResponseInterceptorList httpResponseInterceptorList0) {
        if(httpRequestInterceptorList0 == null) {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        else {
            int v1 = httpRequestInterceptorList0.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[v1];
            for(int v2 = 0; v2 < v1; ++v2) {
                this.requestInterceptors[v2] = httpRequestInterceptorList0.getRequestInterceptor(v2);
            }
        }
        if(httpResponseInterceptorList0 != null) {
            int v3 = httpResponseInterceptorList0.getResponseInterceptorCount();
            this.responseInterceptors = new HttpResponseInterceptor[v3];
            for(int v = 0; v < v3; ++v) {
                this.responseInterceptors[v] = httpResponseInterceptorList0.getResponseInterceptor(v);
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] arr_httpRequestInterceptor) {
        this(arr_httpRequestInterceptor, null);
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] arr_httpRequestInterceptor, HttpResponseInterceptor[] arr_httpResponseInterceptor) {
        if(arr_httpRequestInterceptor == null) {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        else {
            HttpRequestInterceptor[] arr_httpRequestInterceptor1 = new HttpRequestInterceptor[arr_httpRequestInterceptor.length];
            this.requestInterceptors = arr_httpRequestInterceptor1;
            System.arraycopy(arr_httpRequestInterceptor, 0, arr_httpRequestInterceptor1, 0, arr_httpRequestInterceptor.length);
        }
        if(arr_httpResponseInterceptor != null) {
            HttpResponseInterceptor[] arr_httpResponseInterceptor1 = new HttpResponseInterceptor[arr_httpResponseInterceptor.length];
            this.responseInterceptors = arr_httpResponseInterceptor1;
            System.arraycopy(arr_httpResponseInterceptor, 0, arr_httpResponseInterceptor1, 0, arr_httpResponseInterceptor.length);
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor[] arr_httpResponseInterceptor) {
        this(null, arr_httpResponseInterceptor);
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        HttpRequestInterceptor[] arr_httpRequestInterceptor = this.requestInterceptors;
        for(int v = 0; v < arr_httpRequestInterceptor.length; ++v) {
            arr_httpRequestInterceptor[v].process(httpRequest0, httpContext0);
        }
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        HttpResponseInterceptor[] arr_httpResponseInterceptor = this.responseInterceptors;
        for(int v = 0; v < arr_httpResponseInterceptor.length; ++v) {
            arr_httpResponseInterceptor[v].process(httpResponse0, httpContext0);
        }
    }
}

