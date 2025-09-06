package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList {
    protected List requestInterceptors;
    protected List responseInterceptors;

    public BasicHttpProcessor() {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor0) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor0, int v) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor0) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor0, int v) {
        throw new RuntimeException("Stub!");
    }

    public void clearInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpProcessor copy() {
        throw new RuntimeException("Stub!");
    }

    public void copyInterceptors(BasicHttpProcessor basicHttpProcessor0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class class0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class class0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestInterceptorList, org.apache.http.protocol.HttpResponseInterceptorList
    public void setInterceptors(List list0) {
        throw new RuntimeException("Stub!");
    }
}

