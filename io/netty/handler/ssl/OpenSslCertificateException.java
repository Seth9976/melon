package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

public final class OpenSslCertificateException extends CertificateException {
    private final int errorCode;
    private static final long serialVersionUID = 0x4CEB89C6E7ED0E46L;

    public OpenSslCertificateException(int v) {
        this(null, v);
    }

    public OpenSslCertificateException(String s, int v) {
        super(s);
        this.errorCode = OpenSslCertificateException.checkErrorCode(v);
    }

    public OpenSslCertificateException(String s, Throwable throwable0, int v) {
        super(s, throwable0);
        this.errorCode = OpenSslCertificateException.checkErrorCode(v);
    }

    public OpenSslCertificateException(Throwable throwable0, int v) {
        this(null, throwable0, v);
    }

    private static int checkErrorCode(int v) {
        if(OpenSsl.isAvailable() && !CertificateVerifier.isValid(v)) {
            throw new IllegalArgumentException("errorCode \'" + v + "\' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html.");
        }
        return v;
    }

    public int errorCode() {
        return this.errorCode;
    }
}

