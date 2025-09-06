package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;

public class TrustSelfSignedStrategy implements TrustStrategy {
    @Override  // org.apache.http.conn.ssl.TrustStrategy
    public boolean isTrusted(X509Certificate[] arr_x509Certificate, String s) {
        return arr_x509Certificate.length == 1;
    }
}

