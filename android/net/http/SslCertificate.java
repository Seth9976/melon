package android.net.http;

import android.os.Bundle;
import java.security.cert.X509Certificate;
import java.util.Date;

public class SslCertificate {
    public class DName {
        public DName(String s) {
            throw new RuntimeException("Stub!");
        }

        public String getCName() {
            throw new RuntimeException("Stub!");
        }

        public String getDName() {
            throw new RuntimeException("Stub!");
        }

        public String getOName() {
            throw new RuntimeException("Stub!");
        }

        public String getUName() {
            throw new RuntimeException("Stub!");
        }
    }

    @Deprecated
    public SslCertificate(String s, String s1, String s2, String s3) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public SslCertificate(String s, String s1, Date date0, Date date1) {
        throw new RuntimeException("Stub!");
    }

    public SslCertificate(X509Certificate x509Certificate0) {
        throw new RuntimeException("Stub!");
    }

    public DName getIssuedBy() {
        throw new RuntimeException("Stub!");
    }

    public DName getIssuedTo() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getValidNotAfter() {
        throw new RuntimeException("Stub!");
    }

    public Date getValidNotAfterDate() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getValidNotBefore() {
        throw new RuntimeException("Stub!");
    }

    public Date getValidNotBeforeDate() {
        throw new RuntimeException("Stub!");
    }

    public static SslCertificate restoreState(Bundle bundle0) {
        throw new RuntimeException("Stub!");
    }

    public static Bundle saveState(SslCertificate sslCertificate0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

