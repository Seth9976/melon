package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor arg1);

    void addResponseInterceptor(HttpResponseInterceptor arg1, int arg2);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int arg1);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class arg1);

    void setInterceptors(List arg1);
}

