package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DigestSchemeFactoryHC4 implements AuthSchemeFactory, AuthSchemeProvider {
    private final Charset charset;

    public DigestSchemeFactoryHC4() {
        this(null);
    }

    public DigestSchemeFactoryHC4(Charset charset0) {
        this.charset = charset0;
    }

    @Override  // org.apache.http.auth.AuthSchemeProvider
    public AuthScheme create(HttpContext httpContext0) {
        return new DigestSchemeHC4(this.charset);
    }

    @Override  // org.apache.http.auth.AuthSchemeFactory
    public AuthScheme newInstance(HttpParams httpParams0) {
        return new DigestSchemeHC4();
    }
}

