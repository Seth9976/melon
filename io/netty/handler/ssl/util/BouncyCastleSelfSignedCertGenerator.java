package io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

final class BouncyCastleSelfSignedCertGenerator {
    private static final Provider PROVIDER;

    static {
        BouncyCastleSelfSignedCertGenerator.PROVIDER = new BouncyCastleProvider();
    }

    public static String[] generate(String s, KeyPair keyPair0, SecureRandom secureRandom0, Date date0, Date date1, String s1) {
        PrivateKey privateKey0 = keyPair0.getPrivate();
        X500Name x500Name0 = new X500Name("CN=" + s);
        X509CertificateHolder x509CertificateHolder0 = ((X509v3CertificateBuilder)new JcaX509v3CertificateBuilder(x500Name0, new BigInteger(0x40, secureRandom0), date0, date1, x500Name0, keyPair0.getPublic())).build(new JcaContentSignerBuilder((s1.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256WithRSAEncryption")).build(privateKey0));
        X509Certificate x509Certificate0 = new JcaX509CertificateConverter().setProvider(BouncyCastleSelfSignedCertGenerator.PROVIDER).getCertificate(x509CertificateHolder0);
        x509Certificate0.verify(keyPair0.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(s, privateKey0, x509Certificate0);
    }
}

