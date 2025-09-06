package org.apache.http.impl.client;

import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;

@Deprecated
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(ClientParamsStack clientParamsStack0) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack0, HttpParams httpParams0, HttpParams httpParams1, HttpParams httpParams2, HttpParams httpParams3) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(HttpParams httpParams0, HttpParams httpParams1, HttpParams httpParams2, HttpParams httpParams3) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public HttpParams copy() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getApplicationParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getClientParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getOverrideParams() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.params.HttpParams
    public Object getParameter(String s) {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getRequestParams() {
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
}

