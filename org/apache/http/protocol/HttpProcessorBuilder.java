package org.apache.http.protocol;

import java.util.LinkedList;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;

public class HttpProcessorBuilder {
    private ChainBuilder requestChainBuilder;
    private ChainBuilder responseChainBuilder;

    public HttpProcessorBuilder add(HttpRequestInterceptor httpRequestInterceptor0) {
        return this.addLast(httpRequestInterceptor0);
    }

    public HttpProcessorBuilder add(HttpResponseInterceptor httpResponseInterceptor0) {
        return this.addLast(httpResponseInterceptor0);
    }

    public HttpProcessorBuilder addAll(HttpRequestInterceptor[] arr_httpRequestInterceptor) {
        return this.addAllLast(arr_httpRequestInterceptor);
    }

    public HttpProcessorBuilder addAll(HttpResponseInterceptor[] arr_httpResponseInterceptor) {
        return this.addAllLast(arr_httpResponseInterceptor);
    }

    public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor[] arr_httpRequestInterceptor) {
        if(arr_httpRequestInterceptor == null) {
            return this;
        }
        this.getRequestChainBuilder().addAllFirst(arr_httpRequestInterceptor);
        return this;
    }

    public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor[] arr_httpResponseInterceptor) {
        if(arr_httpResponseInterceptor == null) {
            return this;
        }
        this.getResponseChainBuilder().addAllFirst(arr_httpResponseInterceptor);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpRequestInterceptor[] arr_httpRequestInterceptor) {
        if(arr_httpRequestInterceptor == null) {
            return this;
        }
        this.getRequestChainBuilder().addAllLast(arr_httpRequestInterceptor);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpResponseInterceptor[] arr_httpResponseInterceptor) {
        if(arr_httpResponseInterceptor == null) {
            return this;
        }
        this.getResponseChainBuilder().addAllLast(arr_httpResponseInterceptor);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpRequestInterceptor httpRequestInterceptor0) {
        if(httpRequestInterceptor0 == null) {
            return this;
        }
        this.getRequestChainBuilder().addFirst(httpRequestInterceptor0);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpResponseInterceptor httpResponseInterceptor0) {
        if(httpResponseInterceptor0 == null) {
            return this;
        }
        this.getResponseChainBuilder().addFirst(httpResponseInterceptor0);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpRequestInterceptor httpRequestInterceptor0) {
        if(httpRequestInterceptor0 == null) {
            return this;
        }
        this.getRequestChainBuilder().addLast(httpRequestInterceptor0);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpResponseInterceptor httpResponseInterceptor0) {
        if(httpResponseInterceptor0 == null) {
            return this;
        }
        this.getResponseChainBuilder().addLast(httpResponseInterceptor0);
        return this;
    }

    public HttpProcessor build() {
        LinkedList linkedList0 = null;
        LinkedList linkedList1 = this.requestChainBuilder == null ? null : this.requestChainBuilder.build();
        ChainBuilder chainBuilder0 = this.responseChainBuilder;
        if(chainBuilder0 != null) {
            linkedList0 = chainBuilder0.build();
        }
        return new ImmutableHttpProcessor(linkedList1, linkedList0);
    }

    public static HttpProcessorBuilder create() {
        return new HttpProcessorBuilder();
    }

    private ChainBuilder getRequestChainBuilder() {
        if(this.requestChainBuilder == null) {
            this.requestChainBuilder = new ChainBuilder();
        }
        return this.requestChainBuilder;
    }

    private ChainBuilder getResponseChainBuilder() {
        if(this.responseChainBuilder == null) {
            this.responseChainBuilder = new ChainBuilder();
        }
        return this.responseChainBuilder;
    }
}

