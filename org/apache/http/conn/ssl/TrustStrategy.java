package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;

public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] arg1, String arg2);
}

