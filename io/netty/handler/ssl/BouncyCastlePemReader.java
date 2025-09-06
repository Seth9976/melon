package io.netty.handler.ssl;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;

final class BouncyCastlePemReader {
    private static final String BC_PEMPARSER = "org.bouncycastle.openssl.PEMParser";
    private static final String BC_PROVIDER = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    private static volatile boolean attemptedLoading;
    private static volatile Provider bcProvider;
    private static final InternalLogger logger;
    private static volatile Throwable unavailabilityCause;

    static {
        BouncyCastlePemReader.logger = InternalLoggerFactory.getInstance(BouncyCastlePemReader.class);
    }

    public static PrivateKey getPrivateKey(File file0, String s) {
        if(!BouncyCastlePemReader.isAvailable()) {
            InternalLogger internalLogger0 = BouncyCastlePemReader.logger;
            if(internalLogger0.isDebugEnabled()) {
                internalLogger0.debug("Bouncy castle provider is unavailable.", BouncyCastlePemReader.unavailabilityCause());
            }
            return null;
        }
        try {
            return BouncyCastlePemReader.getPrivateKey(BouncyCastlePemReader.newParser(file0), s);
        }
        catch(Exception exception0) {
            BouncyCastlePemReader.logger.debug("Unable to extract private key", exception0);
            return null;
        }
    }

    public static PrivateKey getPrivateKey(InputStream inputStream0, String s) {
        if(!BouncyCastlePemReader.isAvailable()) {
            InternalLogger internalLogger0 = BouncyCastlePemReader.logger;
            if(internalLogger0.isDebugEnabled()) {
                internalLogger0.debug("Bouncy castle provider is unavailable.", BouncyCastlePemReader.unavailabilityCause());
            }
            return null;
        }
        try {
            return BouncyCastlePemReader.getPrivateKey(BouncyCastlePemReader.newParser(inputStream0), s);
        }
        catch(Exception exception0) {
            BouncyCastlePemReader.logger.debug("Unable to extract private key", exception0);
            return null;
        }
    }

    private static PrivateKey getPrivateKey(PEMParser pEMParser0, String s) {
        PrivateKey privateKey0;
        try {
            JcaPEMKeyConverter jcaPEMKeyConverter0 = BouncyCastlePemReader.newConverter();
            Object object0 = pEMParser0.readObject();
            privateKey0 = null;
            while(object0 != null && privateKey0 == null) {
                InternalLogger internalLogger0 = BouncyCastlePemReader.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Parsed PEM object of type {} and assume key is {}encrypted", object0.getClass().getName(), (s == null ? "not " : ""));
                }
                if(s == null) {
                    if(object0 instanceof PrivateKeyInfo) {
                        privateKey0 = jcaPEMKeyConverter0.getPrivateKey(((PrivateKeyInfo)object0));
                    }
                    else if(object0 instanceof PEMKeyPair) {
                        privateKey0 = jcaPEMKeyConverter0.getKeyPair(((PEMKeyPair)object0)).getPrivate();
                    }
                    else {
                        internalLogger0.debug("Unable to handle PEM object of type {} as a non encrypted key", object0.getClass());
                    }
                }
                else if(object0 instanceof PEMEncryptedKeyPair) {
                    privateKey0 = jcaPEMKeyConverter0.getKeyPair(((PEMEncryptedKeyPair)object0).decryptKeyPair(new JcePEMDecryptorProviderBuilder().setProvider(BouncyCastlePemReader.bcProvider).build(s.toCharArray()))).getPrivate();
                }
                else if(object0 instanceof PKCS8EncryptedPrivateKeyInfo) {
                    privateKey0 = jcaPEMKeyConverter0.getPrivateKey(((PKCS8EncryptedPrivateKeyInfo)object0).decryptPrivateKeyInfo(new JceOpenSSLPKCS8DecryptorProviderBuilder().setProvider(BouncyCastlePemReader.bcProvider).build(s.toCharArray())));
                }
                else {
                    internalLogger0.debug("Unable to handle PEM object of type {} as a encrypted key", object0.getClass());
                }
                if(privateKey0 == null) {
                    object0 = pEMParser0.readObject();
                }
            }
            if(privateKey0 == null) {
                InternalLogger internalLogger1 = BouncyCastlePemReader.logger;
                if(internalLogger1.isDebugEnabled()) {
                    internalLogger1.debug("No key found");
                    goto label_38;
                label_32:
                    if(pEMParser0 == null) {
                        throw throwable0;
                    }
                    goto label_33;
                }
            }
            goto label_38;
        }
        catch(Throwable throwable0) {
            goto label_32;
        }
        try {
        label_33:
            pEMParser0.close();
        }
        catch(Exception exception0) {
            BouncyCastlePemReader.logger.debug("Failed closing pem parser", exception0);
        }
        throw throwable0;
        try {
        label_38:
            pEMParser0.close();
        }
        catch(Exception exception1) {
            BouncyCastlePemReader.logger.debug("Failed closing pem parser", exception1);
        }
        return privateKey0;
    }

    public static boolean hasAttemptedLoading() [...] // 潜在的解密器

    public static boolean isAvailable() {
        BouncyCastlePemReader.tryLoading();
        return BouncyCastlePemReader.unavailabilityCause == null;
    }

    private static JcaPEMKeyConverter newConverter() {
        return new JcaPEMKeyConverter().setProvider(BouncyCastlePemReader.bcProvider);
    }

    private static PEMParser newParser(File file0) {
        return new PEMParser(new FileReader(file0));
    }

    private static PEMParser newParser(InputStream inputStream0) {
        return new PEMParser(new InputStreamReader(inputStream0, CharsetUtil.US_ASCII));
    }

    private static void tryLoading() {
        AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public Void run() {
                try {
                    ClassLoader classLoader0 = io.netty.handler.ssl.BouncyCastlePemReader.1.class.getClassLoader();
                    Class class0 = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider", true, classLoader0);
                    Class.forName("org.bouncycastle.openssl.PEMParser", true, classLoader0);
                    BouncyCastlePemReader.bcProvider = (Provider)class0.getConstructor(null).newInstance(null);
                    BouncyCastlePemReader.logger.debug("Bouncy Castle provider available");
                }
                catch(Throwable throwable0) {
                    BouncyCastlePemReader.logger.debug("Cannot load Bouncy Castle provider", throwable0);
                    BouncyCastlePemReader.unavailabilityCause = throwable0;
                }
                BouncyCastlePemReader.attemptedLoading = true;
                return null;
            }
        });
    }

    public static Throwable unavailabilityCause() {
        return BouncyCastlePemReader.unavailabilityCause;
    }
}

