package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.util.Date;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

public final class LazyJavaxX509Certificate extends X509Certificate {
    private final byte[] bytes;
    private X509Certificate wrapped;

    public LazyJavaxX509Certificate(byte[] arr_b) {
        this.bytes = (byte[])ObjectUtil.checkNotNull(arr_b, "bytes");
    }

    @Override  // javax.security.cert.X509Certificate
    public void checkValidity() {
        this.unwrap().checkValidity();
    }

    @Override  // javax.security.cert.X509Certificate
    public void checkValidity(Date date0) {
        this.unwrap().checkValidity(date0);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    @Override  // javax.security.cert.Certificate
    public byte[] getEncoded() {
        return (byte[])this.bytes.clone();
    }

    @Override  // javax.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.unwrap().getIssuerDN();
    }

    @Override  // javax.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.unwrap().getNotAfter();
    }

    @Override  // javax.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.unwrap().getNotBefore();
    }

    @Override  // javax.security.cert.Certificate
    public PublicKey getPublicKey() {
        return this.unwrap().getPublicKey();
    }

    @Override  // javax.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.unwrap().getSerialNumber();
    }

    @Override  // javax.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.unwrap().getSigAlgName();
    }

    @Override  // javax.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.unwrap().getSigAlgOID();
    }

    @Override  // javax.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.unwrap().getSigAlgParams();
    }

    @Override  // javax.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.unwrap().getSubjectDN();
    }

    @Override  // javax.security.cert.X509Certificate
    public int getVersion() {
        return this.unwrap().getVersion();
    }

    @Override  // javax.security.cert.Certificate
    public String toString() {
        return this.unwrap().toString();
    }

    private X509Certificate unwrap() {
        X509Certificate x509Certificate0 = this.wrapped;
        if(x509Certificate0 == null) {
            try {
                X509Certificate x509Certificate1 = X509Certificate.getInstance(this.bytes);
                this.wrapped = x509Certificate1;
                return x509Certificate1;
            }
            catch(CertificateException certificateException0) {
                throw new IllegalStateException(certificateException0);
            }
        }
        return x509Certificate0;
    }

    @Override  // javax.security.cert.Certificate
    public void verify(PublicKey publicKey0) {
        this.unwrap().verify(publicKey0);
    }

    @Override  // javax.security.cert.Certificate
    public void verify(PublicKey publicKey0, String s) {
        this.unwrap().verify(publicKey0, s);
    }
}

