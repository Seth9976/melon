package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequestInterceptor;

@Deprecated
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor arg1);

    void addRequestInterceptor(HttpRequestInterceptor arg1, int arg2);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int arg1);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class arg1);

    void setInterceptors(List arg1);
}

