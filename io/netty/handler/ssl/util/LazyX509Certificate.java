package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class LazyX509Certificate extends X509Certificate {
    static final CertificateFactory X509_CERT_FACTORY;
    private final byte[] bytes;
    private X509Certificate wrapped;

    static {
        try {
            LazyX509Certificate.X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        }
        catch(CertificateException certificateException0) {
            throw new ExceptionInInitializerError(certificateException0);
        }
    }

    public LazyX509Certificate(byte[] arr_b) {
        this.bytes = (byte[])ObjectUtil.checkNotNull(arr_b, "bytes");
    }

    @Override
    public void checkValidity() {
        this.unwrap().checkValidity();
    }

    @Override
    public void checkValidity(Date date0) {
        this.unwrap().checkValidity(date0);
    }

    @Override
    public int getBasicConstraints() {
        return this.unwrap().getBasicConstraints();
    }

    @Override
    public Set getCriticalExtensionOIDs() {
        return this.unwrap().getCriticalExtensionOIDs();
    }

    @Override
    public byte[] getEncoded() {
        return (byte[])this.bytes.clone();
    }

    @Override
    public List getExtendedKeyUsage() {
        return this.unwrap().getExtendedKeyUsage();
    }

    @Override
    public byte[] getExtensionValue(String s) {
        return this.unwrap().getExtensionValue(s);
    }

    @Override
    public Collection getIssuerAlternativeNames() {
        return this.unwrap().getSubjectAlternativeNames();
    }

    @Override
    public Principal getIssuerDN() {
        return this.unwrap().getIssuerDN();
    }

    @Override
    public boolean[] getIssuerUniqueID() {
        return this.unwrap().getIssuerUniqueID();
    }

    @Override
    public X500Principal getIssuerX500Principal() {
        return this.unwrap().getIssuerX500Principal();
    }

    @Override
    public boolean[] getKeyUsage() {
        return this.unwrap().getKeyUsage();
    }

    @Override
    public Set getNonCriticalExtensionOIDs() {
        return this.unwrap().getNonCriticalExtensionOIDs();
    }

    @Override
    public Date getNotAfter() {
        return this.unwrap().getNotAfter();
    }

    @Override
    public Date getNotBefore() {
        return this.unwrap().getNotBefore();
    }

    @Override
    public PublicKey getPublicKey() {
        return this.unwrap().getPublicKey();
    }

    @Override
    public BigInteger getSerialNumber() {
        return this.unwrap().getSerialNumber();
    }

    @Override
    public String getSigAlgName() {
        return this.unwrap().getSigAlgName();
    }

    @Override
    public String getSigAlgOID() {
        return this.unwrap().getSigAlgOID();
    }

    @Override
    public byte[] getSigAlgParams() {
        return this.unwrap().getSigAlgParams();
    }

    @Override
    public byte[] getSignature() {
        return this.unwrap().getSignature();
    }

    @Override
    public Collection getSubjectAlternativeNames() {
        return this.unwrap().getSubjectAlternativeNames();
    }

    @Override
    public Principal getSubjectDN() {
        return this.unwrap().getSubjectDN();
    }

    @Override
    public boolean[] getSubjectUniqueID() {
        return this.unwrap().getSubjectUniqueID();
    }

    @Override
    public X500Principal getSubjectX500Principal() {
        return this.unwrap().getSubjectX500Principal();
    }

    @Override
    public byte[] getTBSCertificate() {
        return this.unwrap().getTBSCertificate();
    }

    @Override
    public int getVersion() {
        return this.unwrap().getVersion();
    }

    @Override
    public boolean hasUnsupportedCriticalExtension() {
        return this.unwrap().hasUnsupportedCriticalExtension();
    }

    @Override
    public String toString() {
        return this.unwrap().toString();
    }

    private X509Certificate unwrap() {
        X509Certificate x509Certificate0 = this.wrapped;
        if(x509Certificate0 == null) {
            try {
                ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(this.bytes);
                X509Certificate x509Certificate1 = (X509Certificate)LazyX509Certificate.X509_CERT_FACTORY.generateCertificate(byteArrayInputStream0);
                this.wrapped = x509Certificate1;
                return x509Certificate1;
            }
            catch(CertificateException certificateException0) {
                throw new IllegalStateException(certificateException0);
            }
        }
        return x509Certificate0;
    }

    @Override
    public void verify(PublicKey publicKey0) {
        this.unwrap().verify(publicKey0);
    }

    @Override
    public void verify(PublicKey publicKey0, String s) {
        this.unwrap().verify(publicKey0, s);
    }

    @Override
    @SuppressJava6Requirement(reason = "Can only be called from Java8 as class is package-private")
    public void verify(PublicKey publicKey0, Provider provider0) {
        this.unwrap().verify(publicKey0, provider0);
    }
}

