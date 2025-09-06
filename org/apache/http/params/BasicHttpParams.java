package org.apache.http.params;

import java.io.Serializable;

@Deprecated
public final class BasicHttpParams extends AbstractHttpParams implements Serializable {
    public BasicHttpParams() {
        throw new RuntimeException("Stub!");
    }

    public void clear() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams copy() {
        throw new RuntimeException("Stub!");
    }

    public void copyParams(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public Object getParameter(String s) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParameterSet(String s) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParameterSetLocally(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public boolean removeParameter(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams setParameter(String s, Object object0) {
        throw new RuntimeException("Stub!");
    }

    public void setParameters(String[] arr_s, Object object0) {
        throw new RuntimeException("Stub!");
    }
}

