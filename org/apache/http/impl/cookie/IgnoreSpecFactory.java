package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class IgnoreSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    @Override  // org.apache.http.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext0) {
        return new IgnoreSpec();
    }

    @Override  // org.apache.http.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams0) {
        return new IgnoreSpec();
    }
}

