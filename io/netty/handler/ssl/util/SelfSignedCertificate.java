package io.netty.handler.ssl.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

public final class SelfSignedCertificate {
    private static final int DEFAULT_KEY_LENGTH_BITS;
    private static final Date DEFAULT_NOT_AFTER;
    private static final Date DEFAULT_NOT_BEFORE;
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private static final InternalLogger logger;
    private final File privateKey;

    static {
        SelfSignedCertificate.logger = InternalLoggerFactory.getInstance(SelfSignedCertificate.class);
        SelfSignedCertificate.DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
        SelfSignedCertificate.DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
        SelfSignedCertificate.DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 0x800);
    }

    public SelfSignedCertificate() {
        this(SelfSignedCertificate.DEFAULT_NOT_BEFORE, SelfSignedCertificate.DEFAULT_NOT_AFTER, "RSA", SelfSignedCertificate.DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String s) {
        this(s, SelfSignedCertificate.DEFAULT_NOT_BEFORE, SelfSignedCertificate.DEFAULT_NOT_AFTER, "RSA", SelfSignedCertificate.DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String s, String s1, int v) {
        this(s, SelfSignedCertificate.DEFAULT_NOT_BEFORE, SelfSignedCertificate.DEFAULT_NOT_AFTER, s1, v);
    }

    public SelfSignedCertificate(String s, SecureRandom secureRandom0, int v) {
        this(s, secureRandom0, v, SelfSignedCertificate.DEFAULT_NOT_BEFORE, SelfSignedCertificate.DEFAULT_NOT_AFTER, "RSA");
    }

    public SelfSignedCertificate(String s, SecureRandom secureRandom0, int v, Date date0, Date date1) {
        this(s, secureRandom0, v, date0, date1, "RSA");
    }

    public SelfSignedCertificate(String s, SecureRandom secureRandom0, int v, Date date0, Date date1, String s1) {
        Throwable throwable3;
        Exception exception1;
        FileInputStream fileInputStream0;
        String[] arr_s;
        KeyPair keyPair0;
        if(!"EC".equalsIgnoreCase(s1) && !"RSA".equalsIgnoreCase(s1)) {
            throw new IllegalArgumentException("Algorithm not valid: " + s1);
        }
        try {
            KeyPairGenerator keyPairGenerator0 = KeyPairGenerator.getInstance(s1);
            keyPairGenerator0.initialize(v, secureRandom0);
            keyPair0 = keyPairGenerator0.generateKeyPair();
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new Error(noSuchAlgorithmException0);
        }
        try {
            arr_s = BouncyCastleSelfSignedCertGenerator.generate(s, keyPair0, secureRandom0, date0, date1, s1);
        }
        catch(Throwable throwable0) {
            if(SelfSignedCertificate.isBouncyCastleAvailable()) {
                SelfSignedCertificate.logger.debug("Failed to generate a self-signed X.509 certificate using Bouncy Castle:", throwable0);
            }
            else {
                SelfSignedCertificate.logger.debug("Failed to generate a self-signed X.509 certificate because BouncyCastle PKIX is not available in classpath");
            }
            try {
                arr_s = OpenJdkSelfSignedCertGenerator.generate(s, keyPair0, secureRandom0, date0, date1, s1);
            }
            catch(Throwable throwable1) {
                SelfSignedCertificate.logger.debug("Failed to generate a self-signed X.509 certificate using sun.security.x509:", throwable1);
                CertificateException certificateException0 = new CertificateException("No provider succeeded to generate a self-signed certificate. See debug log for the root cause.", throwable1);
                ThrowableUtil.addSuppressed(certificateException0, throwable0);
                throw certificateException0;
            }
        }
        File file0 = new File(arr_s[0]);
        this.certificate = file0;
        this.privateKey = new File(arr_s[1]);
        this.key = keyPair0.getPrivate();
        try {
            fileInputStream0 = null;
            fileInputStream0 = new FileInputStream(file0);
        }
        catch(Exception exception0) {
            exception1 = exception0;
            throw new CertificateEncodingException(exception1);
        }
        catch(Throwable throwable2) {
            throwable3 = throwable2;
            goto label_43;
        }
        try {
            try {
                this.cert = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(fileInputStream0);
                goto label_50;
            }
            catch(Exception exception2) {
                exception1 = exception2;
            }
            throw new CertificateEncodingException(exception1);
        }
        catch(Throwable throwable4) {
            throwable3 = throwable4;
        }
    label_43:
        if(fileInputStream0 != null) {
            try {
                fileInputStream0.close();
            }
            catch(IOException iOException0) {
                if(SelfSignedCertificate.logger.isWarnEnabled()) {
                    SelfSignedCertificate.logger.warn("Failed to close a file: " + this.certificate, iOException0);
                }
            }
        }
        throw throwable3;
        try {
        label_50:
            fileInputStream0.close();
        }
        catch(IOException iOException1) {
            if(SelfSignedCertificate.logger.isWarnEnabled()) {
                SelfSignedCertificate.logger.warn("Failed to close a file: " + this.certificate, iOException1);
            }
        }
    }

    public SelfSignedCertificate(String s, SecureRandom secureRandom0, String s1, int v) {
        this(s, secureRandom0, v, SelfSignedCertificate.DEFAULT_NOT_BEFORE, SelfSignedCertificate.DEFAULT_NOT_AFTER, s1);
    }

    public SelfSignedCertificate(String s, Date date0, Date date1) {
        this(s, ThreadLocalInsecureRandom.current(), SelfSignedCertificate.DEFAULT_KEY_LENGTH_BITS, date0, date1, "RSA");
    }

    public SelfSignedCertificate(String s, Date date0, Date date1, String s1, int v) {
        this(s, ThreadLocalInsecureRandom.current(), v, date0, date1, s1);
    }

    public SelfSignedCertificate(Date date0, Date date1) {
        this("localhost", date0, date1, "RSA", SelfSignedCertificate.DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date date0, Date date1, String s, int v) {
        this("localhost", date0, date1, s, v);
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public File certificate() {
        return this.certificate;
    }

    public void delete() {
        SelfSignedCertificate.safeDelete(this.certificate);
        SelfSignedCertificate.safeDelete(this.privateKey);
    }

    private static boolean isBouncyCastleAvailable() {
        try {
            Class.forName("org.bouncycastle.cert.X509v3CertificateBuilder");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    public PrivateKey key() {
        return this.key;
    }

    public static String[] newSelfSignedCertificate(String s, PrivateKey privateKey0, X509Certificate x509Certificate0) {
        String s3;
        String s1;
        Charset charset0;
        ByteBuf byteBuf0 = Unpooled.wrappedBuffer(privateKey0.getEncoded());
        try {
            ByteBuf byteBuf1 = Base64.encode(byteBuf0, true);
            try {
                charset0 = CharsetUtil.US_ASCII;
                s1 = "-----BEGIN PRIVATE KEY-----\n" + byteBuf1.toString(charset0) + "\n-----END PRIVATE KEY-----\n";
            }
            catch(Throwable throwable0) {
                byteBuf1.release();
                throw throwable0;
            }
            byteBuf1.release();
        }
        finally {
            byteBuf0.release();
        }
        String s2 = s.replaceAll("[^\\w.-]", "x");
        File file0 = PlatformDependent.createTempFile(("keyutil_" + s2 + '_'), ".key", null);
        file0.deleteOnExit();
        FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
        try {
            fileOutputStream0.write(s1.getBytes(charset0));
            fileOutputStream0.close();
        }
        catch(Throwable throwable1) {
            SelfSignedCertificate.safeClose(file0, fileOutputStream0);
            SelfSignedCertificate.safeDelete(file0);
            throw throwable1;
        }
        ByteBuf byteBuf2 = Unpooled.wrappedBuffer(x509Certificate0.getEncoded());
        try {
            ByteBuf byteBuf3 = Base64.encode(byteBuf2, true);
            try {
                s3 = "-----BEGIN CERTIFICATE-----\n" + byteBuf3.toString(charset0) + "\n-----END CERTIFICATE-----\n";
            }
            catch(Throwable throwable2) {
                byteBuf3.release();
                throw throwable2;
            }
            byteBuf3.release();
        }
        finally {
            byteBuf2.release();
        }
        File file1 = PlatformDependent.createTempFile(("keyutil_" + s2 + '_'), ".crt", null);
        file1.deleteOnExit();
        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        try {
            fileOutputStream1.write(s3.getBytes(charset0));
            fileOutputStream1.close();
            return new String[]{file1.getPath(), file0.getPath()};
        }
        catch(Throwable throwable3) {
            SelfSignedCertificate.safeClose(file1, fileOutputStream1);
            SelfSignedCertificate.safeDelete(file1);
            SelfSignedCertificate.safeDelete(file0);
            throw throwable3;
        }
    }

    public File privateKey() {
        return this.privateKey;
    }

    private static void safeClose(File file0, OutputStream outputStream0) {
        try {
            outputStream0.close();
        }
        catch(IOException iOException0) {
            if(SelfSignedCertificate.logger.isWarnEnabled()) {
                SelfSignedCertificate.logger.warn("Failed to close a file: " + file0, iOException0);
            }
        }
    }

    private static void safeDelete(File file0) {
        if(!file0.delete()) {
            InternalLogger internalLogger0 = SelfSignedCertificate.logger;
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn("Failed to delete a file: " + file0);
            }
        }
    }
}

