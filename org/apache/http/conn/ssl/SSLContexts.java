package org.apache.http.conn.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.annotation.Immutable;

@Immutable
public class SSLContexts {
    public static SSLContext createDefault() {
        try {
            SSLContext sSLContext0 = SSLContext.getInstance("TLS");
            sSLContext0.init(null, null, null);
            return sSLContext0;
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new SSLInitializationException(noSuchAlgorithmException0.getMessage(), noSuchAlgorithmException0);
        }
        catch(KeyManagementException keyManagementException0) {
            throw new SSLInitializationException(keyManagementException0.getMessage(), keyManagementException0);
        }
    }

    public static SSLContext createSystemDefault() {
        try {
            return SSLContext.getInstance("Default");
        }
        catch(NoSuchAlgorithmException unused_ex) {
            return SSLContexts.createDefault();
        }
    }

    public static SSLContextBuilder custom() {
        return new SSLContextBuilder();
    }
}

