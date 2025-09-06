package io.netty.handler.ssl.util;

import U4.x;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class FingerprintTrustManagerFactory extends SimpleTrustManagerFactory {
    private static final Pattern FINGERPRINT_PATTERN;
    private static final Pattern FINGERPRINT_STRIP_PATTERN;
    private final byte[][] fingerprints;
    private final FastThreadLocal tlmd;
    private final TrustManager tm;

    static {
        FingerprintTrustManagerFactory.FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
        FingerprintTrustManagerFactory.FINGERPRINT_STRIP_PATTERN = Pattern.compile(":");
    }

    @Deprecated
    public FingerprintTrustManagerFactory(Iterable iterable0) {
        this("SHA1", FingerprintTrustManagerFactory.toFingerprintArray(iterable0));
    }

    public FingerprintTrustManagerFactory(String s, byte[][] arr2_b) {
        MessageDigest messageDigest0;
        this.tm = new X509TrustManager() {
            @Override  // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
                this.checkTrusted("client", arr_x509Certificate);
            }

            @Override  // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
                this.checkTrusted("server", arr_x509Certificate);
            }

            private void checkTrusted(String s, X509Certificate[] arr_x509Certificate) {
                X509Certificate x509Certificate0 = arr_x509Certificate[0];
                byte[] arr_b = this.fingerprint(x509Certificate0);
                byte[][] arr2_b = FingerprintTrustManagerFactory.this.fingerprints;
                for(int v = 0; v < arr2_b.length; ++v) {
                    if(Arrays.equals(arr_b, arr2_b[v])) {
                        return;
                    }
                }
                StringBuilder stringBuilder0 = x.p(s, " certificate with unknown fingerprint: ");
                stringBuilder0.append(x509Certificate0.getSubjectDN());
                throw new CertificateException(stringBuilder0.toString());
            }

            private byte[] fingerprint(X509Certificate x509Certificate0) {
                MessageDigest messageDigest0 = (MessageDigest)FingerprintTrustManagerFactory.this.tlmd.get();
                messageDigest0.reset();
                return messageDigest0.digest(x509Certificate0.getEncoded());
            }

            @Override  // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
        };
        ObjectUtil.checkNotNull(s, "algorithm");
        ObjectUtil.checkNotNull(arr2_b, "fingerprints");
        if(arr2_b.length == 0) {
            throw new IllegalArgumentException("No fingerprints provided");
        }
        try {
            messageDigest0 = MessageDigest.getInstance(s);
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new IllegalArgumentException("Unsupported hash algorithm: " + s, noSuchAlgorithmException0);
        }
        int v = messageDigest0.getDigestLength();
        ArrayList arrayList0 = new ArrayList(arr2_b.length);
        int v1 = 0;
        while(v1 < arr2_b.length) {
            byte[] arr_b = arr2_b[v1];
            if(arr_b == null) {
                break;
            }
            if(arr_b.length == v) {
                arrayList0.add(arr_b.clone());
                ++v1;
                continue;
            }
            String s1 = ByteBufUtil.hexDump(Unpooled.wrappedBuffer(arr_b));
            throw new IllegalArgumentException(String.format("malformed fingerprint (length is %d but expected %d): %s", ((int)arr_b.length), v, s1));
        }
        this.tlmd = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public MessageDigest initialValue() {
                try {
                    return MessageDigest.getInstance(s);
                }
                catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
                    throw new IllegalArgumentException("Unsupported hash algorithm: " + s, noSuchAlgorithmException0);
                }
            }
        };
        this.fingerprints = (byte[][])arrayList0.toArray(new byte[0][]);
    }

    @Deprecated
    public FingerprintTrustManagerFactory(String[] arr_s) {
        this("SHA1", FingerprintTrustManagerFactory.toFingerprintArray(Arrays.asList(arr_s)));
    }

    @Deprecated
    public FingerprintTrustManagerFactory(byte[][] arr2_b) {
        this("SHA1", arr2_b);
    }

    public static FingerprintTrustManagerFactoryBuilder builder(String s) {
        return new FingerprintTrustManagerFactoryBuilder(s);
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.tm};
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(KeyStore keyStore0) {
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
    }

    public static byte[][] toFingerprintArray(Iterable iterable0) {
        ObjectUtil.checkNotNull(iterable0, "fingerprints");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            String s = (String)object0;
            if(s == null) {
                break;
            }
            if(!FingerprintTrustManagerFactory.FINGERPRINT_PATTERN.matcher(s).matches()) {
                throw new IllegalArgumentException("malformed fingerprint: " + s);
            }
            arrayList0.add(StringUtil.decodeHexDump(FingerprintTrustManagerFactory.FINGERPRINT_STRIP_PATTERN.matcher(s).replaceAll("")));
        }
        return (byte[][])arrayList0.toArray(new byte[0][]);
    }
}

