package org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;

@Immutable
public class AllowAllHostnameVerifierHC4 extends AbstractVerifierHC4 {
    @Override
    public final String toString() {
        return "ALLOW_ALL";
    }

    @Override  // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String s, String[] arr_s, String[] arr_s1) {
    }
}

