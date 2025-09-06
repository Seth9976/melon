package org.apache.http.params;

@Deprecated
public abstract class AbstractHttpParams implements HttpParams {
    public AbstractHttpParams() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public boolean getBooleanParameter(String s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public double getDoubleParameter(String s, double f) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public int getIntParameter(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public long getLongParameter(String s, long v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public boolean isParameterFalse(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public boolean isParameterTrue(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams setBooleanParameter(String s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams setDoubleParameter(String s, double f) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams setIntParameter(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams setLongParameter(String s, long v) {
        throw new RuntimeException("Stub!");
    }
}

