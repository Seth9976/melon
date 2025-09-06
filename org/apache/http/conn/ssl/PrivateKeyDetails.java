package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.http.util.Args;

public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public PrivateKeyDetails(String s, X509Certificate[] arr_x509Certificate) {
        this.type = (String)Args.notNull(s, "Private key type");
        this.certChain = arr_x509Certificate;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}

