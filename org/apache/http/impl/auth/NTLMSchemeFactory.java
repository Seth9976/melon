package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class NTLMSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    @Override  // org.apache.http.auth.AuthSchemeProvider
    public AuthScheme create(HttpContext httpContext0) {
        return new NTLMSchemeHC4();
    }

    @Override  // org.apache.http.auth.AuthSchemeFactory
    public AuthScheme newInstance(HttpParams httpParams0) {
        return new NTLMSchemeHC4();
    }
}

