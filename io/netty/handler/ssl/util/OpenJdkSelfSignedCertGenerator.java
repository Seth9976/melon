package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

final class OpenJdkSelfSignedCertGenerator {
    private static final Constructor CERT_IMPL_CONSTRUCTOR;
    private static final Method CERT_IMPL_GET_METHOD;
    private static final Method CERT_IMPL_SIGN_METHOD;
    private static final Method CERT_INFO_SET_METHOD;
    private static final Constructor ISSUER_NAME_CONSTRUCTOR;
    private static final InternalLogger logger;

    static {
        Constructor constructor0;
        Method method1;
        OpenJdkSelfSignedCertGenerator.logger = InternalLoggerFactory.getInstance(OpenJdkSelfSignedCertGenerator.class);
        Method method0 = null;
        try {
            Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return X509CertInfo.class.getMethod("set", String.class, Object.class);
                    }
                    catch(Throwable object0) {
                        return object0;
                    }
                }
            });
            if(!(object0 instanceof Method)) {
                throw (Throwable)object0;
            }
            method1 = (Method)object0;
        }
        catch(Throwable throwable0) {
            method1 = null;
            constructor0 = null;
            goto label_18;
        }
        try {
            Object object1 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return Class.forName("sun.security.x509.CertificateIssuerName", false, PlatformDependent.getClassLoader(OpenJdkSelfSignedCertGenerator.class)).getConstructor(X500Name.class);
                    }
                    catch(Throwable object0) {
                        return object0;
                    }
                }
            });
            if(!(object1 instanceof Constructor)) {
                throw (Throwable)object1;
            }
            constructor0 = (Constructor)object1;
            goto label_20;
        }
        catch(Throwable throwable0) {
            constructor0 = null;
        }
    label_18:
        Constructor constructor1 = null;
        goto label_27;
        try {
        label_20:
            Object object2 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return X509CertImpl.class.getConstructor(X509CertInfo.class);
                    }
                    catch(Throwable object0) {
                        return object0;
                    }
                }
            });
            if(!(object2 instanceof Constructor)) {
                throw (Throwable)object2;
            }
            constructor1 = (Constructor)object2;
            goto label_29;
        }
        catch(Throwable throwable0) {
            constructor1 = null;
        }
    label_27:
        Method method2 = null;
        goto label_43;
        try {
        label_29:
            Object object3 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return X509CertImpl.class.getMethod("get", String.class);
                    }
                    catch(Throwable object0) {
                        return object0;
                    }
                }
            });
            if(!(object3 instanceof Method)) {
                throw (Throwable)object3;
            }
            method2 = (Method)object3;
        }
        catch(Throwable throwable0) {
            method2 = null;
            goto label_43;
        }
        try {
            Object object4 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return X509CertImpl.class.getMethod("sign", PrivateKey.class, String.class);
                    }
                    catch(Throwable object0) {
                        return object0;
                    }
                }
            });
            if(!(object4 instanceof Method)) {
                throw (Throwable)object4;
            }
            method0 = (Method)object4;
            goto label_44;
        }
        catch(Throwable throwable0) {
        }
    label_43:
        OpenJdkSelfSignedCertGenerator.logger.debug("OpenJdkSelfSignedCertGenerator not supported", throwable0);
    label_44:
        OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD = method1;
        OpenJdkSelfSignedCertGenerator.ISSUER_NAME_CONSTRUCTOR = constructor0;
        OpenJdkSelfSignedCertGenerator.CERT_IMPL_CONSTRUCTOR = constructor1;
        OpenJdkSelfSignedCertGenerator.CERT_IMPL_GET_METHOD = method2;
        OpenJdkSelfSignedCertGenerator.CERT_IMPL_SIGN_METHOD = method0;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by dependency check")
    public static String[] generate(String s, KeyPair keyPair0, SecureRandom secureRandom0, Date date0, Date date1, String s1) {
        Method method0 = OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD;
        if(method0 == null || OpenJdkSelfSignedCertGenerator.ISSUER_NAME_CONSTRUCTOR == null || OpenJdkSelfSignedCertGenerator.CERT_IMPL_CONSTRUCTOR == null || OpenJdkSelfSignedCertGenerator.CERT_IMPL_GET_METHOD == null || OpenJdkSelfSignedCertGenerator.CERT_IMPL_SIGN_METHOD == null) {
            throw new UnsupportedOperationException("OpenJdkSelfSignedCertGenerator not supported on the used JDK version");
        }
        PrivateKey privateKey0 = keyPair0.getPrivate();
        X509CertInfo x509CertInfo0 = new X509CertInfo();
        X500Name x500Name0 = new X500Name("CN=" + s);
        method0.invoke(x509CertInfo0, "version", new CertificateVersion(2));
        method0.invoke(x509CertInfo0, "serialNumber", new CertificateSerialNumber(new BigInteger(0x40, secureRandom0)));
        try {
            method0.invoke(x509CertInfo0, "subject", new CertificateSubjectName(x500Name0));
        }
        catch(InvocationTargetException invocationTargetException0) {
            if(!(invocationTargetException0.getCause() instanceof CertificateException)) {
                throw invocationTargetException0;
            }
            OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "subject", x500Name0);
        }
        try {
            Object[] arr_object = {"issuer", OpenJdkSelfSignedCertGenerator.ISSUER_NAME_CONSTRUCTOR.newInstance(x500Name0)};
            OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, arr_object);
        }
        catch(InvocationTargetException invocationTargetException1) {
            if(!(invocationTargetException1.getCause() instanceof CertificateException)) {
                throw invocationTargetException1;
            }
            OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "issuer", x500Name0);
        }
        OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "validity", new CertificateValidity(date0, date1));
        OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "key", new CertificateX509Key(keyPair0.getPublic()));
        OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "algorithmID", new CertificateAlgorithmId(AlgorithmId.get("1.2.840.113549.1.1.11")));
        X509CertImpl x509CertImpl0 = (X509CertImpl)OpenJdkSelfSignedCertGenerator.CERT_IMPL_CONSTRUCTOR.newInstance(x509CertInfo0);
        Method method1 = OpenJdkSelfSignedCertGenerator.CERT_IMPL_SIGN_METHOD;
        String s2 = "SHA256withRSA";
        method1.invoke(x509CertImpl0, privateKey0, (s1.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256withRSA"));
        OpenJdkSelfSignedCertGenerator.CERT_INFO_SET_METHOD.invoke(x509CertInfo0, "algorithmID.algorithm", OpenJdkSelfSignedCertGenerator.CERT_IMPL_GET_METHOD.invoke(x509CertImpl0, "x509.algorithm"));
        X509CertImpl x509CertImpl1 = (X509CertImpl)OpenJdkSelfSignedCertGenerator.CERT_IMPL_CONSTRUCTOR.newInstance(x509CertInfo0);
        if(s1.equalsIgnoreCase("EC")) {
            s2 = "SHA256withECDSA";
        }
        method1.invoke(x509CertImpl1, privateKey0, s2);
        x509CertImpl1.verify(keyPair0.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(s, privateKey0, ((X509Certificate)x509CertImpl1));
    }
}

