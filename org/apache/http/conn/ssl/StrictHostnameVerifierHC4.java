package org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;

@Immutable
public class StrictHostnameVerifierHC4 extends AbstractVerifierHC4 {
    @Override
    public final String toString() {
        return "STRICT";
    }

    @Override  // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String s, String[] arr_s, String[] arr_s1) {
        this.verify(s, arr_s, arr_s1, true);
    }
}

