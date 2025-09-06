package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayInputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.cert.CertificateException;

public final class OpenSsl {
    static final boolean $assertionsDisabled = false;
    static final Set AVAILABLE_CIPHER_SUITES = null;
    private static final Set AVAILABLE_JAVA_CIPHER_SUITES = null;
    private static final Set AVAILABLE_OPENSSL_CIPHER_SUITES = null;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    private static final Set CLIENT_DEFAULT_PROTOCOLS = null;
    static final List DEFAULT_CIPHERS = null;
    private static final String[] DEFAULT_NAMED_GROUPS = null;
    static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS = null;
    static final String EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = null;
    private static final boolean IS_BORINGSSL = false;
    static final boolean JAVAX_CERTIFICATE_CREATION_SUPPORTED = false;
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final String[] NAMED_GROUPS;
    private static final Set SERVER_DEFAULT_PROTOCOLS;
    static final Set SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger;

    static {
        boolean z6;
        boolean z5;
        String s6;
        String s5;
        int v11;
        LinkedHashSet linkedHashSet3;
        LinkedHashSet linkedHashSet2;
        LinkedHashSet linkedHashSet1;
        boolean z4;
        long v10;
        long v9;
        long v8;
        long v7;
        PemPrivateKey pemPrivateKey0;
        long v5;
        int v4;
        boolean z2;
        int v3;
        boolean z1;
        long v2;
        Throwable throwable2;
        Throwable throwable0;
        Class class0 = OpenSsl.class;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(class0);
        OpenSsl.logger = internalLogger0;
        OpenSsl.DEFAULT_NAMED_GROUPS = new String[]{"x25519", "secp256r1", "secp384r1", "secp521r1"};
        if(SystemPropertyUtil.getBoolean("io.netty.handler.ssl.noOpenSsl", false)) {
            throwable0 = new UnsupportedOperationException("OpenSSL was explicit disabled with -Dio.netty.handler.ssl.noOpenSsl=true");
            internalLogger0.debug("netty-tcnative explicit disabled; OpenSslEngine will be unavailable.", throwable0);
        }
        else {
            try {
                Class.forName("io.netty.internal.tcnative.SSLContext", false, PlatformDependent.getClassLoader(class0));
                throwable0 = null;
            }
            catch(ClassNotFoundException throwable0) {
                OpenSsl.logger.debug("netty-tcnative not in the classpath; OpenSslEngine will be unavailable.");
            }
            if(throwable0 == null) {
                try {
                    OpenSsl.loadTcNative();
                }
                catch(Throwable throwable0) {
                    OpenSsl.logger.debug("Failed to load netty-tcnative; OpenSslEngine will be unavailable, unless the application has already loaded the symbols by some other means. See https://netty.io/wiki/forked-tomcat-native.html for more information.", throwable0);
                }
                try {
                    throwable2 = throwable0;
                    String s = SystemPropertyUtil.get("io.netty.handler.ssl.openssl.engine", null);
                    if(s == null) {
                        OpenSsl.logger.debug("Initialize netty-tcnative using engine: \'default\'");
                    }
                    else {
                        OpenSsl.logger.debug("Initialize netty-tcnative using engine: \'{}\'", s);
                    }
                    OpenSsl.initializeTcNative(s);
                    throwable0 = null;
                    goto label_32;
                label_28:
                    if(throwable2 == null) {
                        goto label_29;
                    }
                    goto label_30;
                }
                catch(Throwable throwable1) {
                    goto label_28;
                }
            label_29:
                throwable2 = throwable1;
            label_30:
                OpenSsl.logger.debug("Failed to initialize netty-tcnative; OpenSslEngine will be unavailable. See https://netty.io/wiki/forked-tomcat-native.html for more information.", throwable1);
                throwable0 = throwable2;
            }
        }
    label_32:
        OpenSsl.UNAVAILABILITY_CAUSE = throwable0;
        OpenSsl.CLIENT_DEFAULT_PROTOCOLS = OpenSsl.protocols("jdk.tls.client.protocols");
        OpenSsl.SERVER_DEFAULT_PROTOCOLS = OpenSsl.protocols("jdk.tls.server.protocols");
        if(throwable0 == null) {
            String s1 = SSL.versionString();
            OpenSsl.logger.debug("netty-tcnative using native library: {}", s1);
            ArrayList arrayList0 = new ArrayList();
            LinkedHashSet linkedHashSet0 = new LinkedHashSet(0x80);
            String[] arr_s = OpenSsl.DEFAULT_NAMED_GROUPS;
            String[] arr_s1 = new String[arr_s.length];
            for(int v = 0; v < arr_s.length; ++v) {
                arr_s1[v] = GroupsConverter.toOpenSsl(arr_s[v]);
            }
            boolean z = "BoringSSL".equals(OpenSsl.versionString());
            OpenSsl.IS_BORINGSSL = z;
            if(z) {
                String[] arr_s2 = {"TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256"};
                OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS = arr_s2;
                StringBuilder stringBuilder0 = new StringBuilder(0x80);
                for(int v1 = 0; v1 < 3; ++v1) {
                    stringBuilder0.append(arr_s2[v1]);
                    stringBuilder0.append(":");
                }
                stringBuilder0.setLength(stringBuilder0.length() - 1);
                OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "TLS_AES_128_GCM_SHA256:TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256";
            }
            else {
                OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
                OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
            }
            try {
                v2 = SSLContext.make(0x3F, 1);
            }
            catch(Exception exception0) {
                z1 = false;
                v3 = 0;
                z2 = false;
                goto label_272;
            }
            try {
                if(SslProvider.isTlsv13Supported(SslProvider.JDK)) {
                    goto label_78;
                }
                else {
                    goto label_101;
                }
                goto label_102;
            }
            catch(Throwable throwable3) {
                z1 = false;
                v3 = 0;
                z2 = false;
                goto label_264;
            }
            try {
            label_78:
                StringBuilder stringBuilder1 = new StringBuilder();
                for(Object object0: SslUtils.TLSV13_CIPHERS) {
                    String s2 = CipherSuiteConverter.toOpenSsl(((String)object0), false);
                    if(s2 != null) {
                        stringBuilder1.append(s2);
                        stringBuilder1.append(':');
                    }
                }
                if(stringBuilder1.length() == 0) {
                    v4 = 0;
                }
                else {
                    stringBuilder1.setLength(stringBuilder1.length() - 1);
                    SSLContext.setCipherSuite(v2, stringBuilder1.toString(), true);
                    v4 = 1;
                    v3 = v4;
                    goto label_102;
                }
            }
            catch(Exception unused_ex) {
                goto label_101;
            }
            catch(Throwable throwable3) {
                z1 = false;
                v3 = 0;
                z2 = false;
                goto label_264;
            }
            v3 = v4;
            goto label_102;
        label_101:
            v3 = 0;
            try {
            label_102:
                SSLContext.setCipherSuite(v2, "ALL", false);
                v5 = SSL.newSSL(v2, true);
            }
            catch(Throwable throwable3) {
                z1 = false;
                z2 = false;
                goto label_264;
            }
            try {
                String[] arr_s3 = SSL.getCiphers(v5);
                for(int v6 = 0; v6 < arr_s3.length; ++v6) {
                    String s3 = arr_s3[v6];
                    if(s3 != null && !s3.isEmpty() && !linkedHashSet0.contains(s3) && (v3 != 0 || !SslUtils.isTLSv13Cipher(s3))) {
                        linkedHashSet0.add(s3);
                    }
                }
                pemPrivateKey0 = PemPrivateKey.valueOf("-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----".getBytes(CharsetUtil.US_ASCII));
            }
            catch(Throwable throwable4) {
                v7 = 0L;
                v8 = 0L;
                v9 = 0L;
                v10 = 0L;
                z1 = false;
                z2 = false;
                goto label_201;
            }
            try {
                SSLContext.setCertificateCallback(v2, null);
                X509Certificate[] arr_x509Certificate = {OpenSsl.selfSignedCertificate()};
                v10 = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, arr_x509Certificate);
            }
            catch(Error unused_ex) {
                v7 = 0L;
                v8 = 0L;
                v9 = 0L;
                v10 = 0L;
                z1 = false;
                z2 = false;
                goto label_186;
            }
            catch(Throwable throwable5) {
                v7 = 0L;
                v8 = 0L;
                v9 = 0L;
                v10 = 0L;
                z1 = false;
                z2 = false;
                goto label_194;
            }
            try {
                v8 = SSL.parseX509Chain(v10);
            }
            catch(Error unused_ex) {
                v7 = 0L;
                v8 = 0L;
                v9 = 0L;
                z1 = false;
                z2 = false;
                goto label_186;
            }
            catch(Throwable throwable5) {
                v7 = 0L;
                v8 = 0L;
                v9 = 0L;
                z1 = false;
                z2 = false;
                goto label_194;
            }
            try {
                PemEncoded pemEncoded0 = pemPrivateKey0.retain();
                v7 = 0L;
                v7 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemEncoded0);
            }
            catch(Error unused_ex) {
                v7 = 0L;
                v9 = 0L;
                z1 = false;
                z2 = false;
                goto label_186;
            }
            catch(Throwable throwable5) {
                v9 = 0L;
                z1 = false;
                z2 = false;
                goto label_194;
            }
            try {
                v9 = 0L;
                v9 = SSL.parsePrivateKey(v7, null);
                SSL.setKeyMaterial(v5, v8, v9);
                goto label_174;
            }
            catch(Error unused_ex) {
                z1 = false;
                z2 = false;
                goto label_186;
            }
            catch(Throwable throwable5) {
            }
            z1 = false;
            z2 = false;
            goto label_194;
            try {
            label_174:
                boolean z3 = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                z4 = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useKeyManagerFactory", true);
            }
            catch(Throwable unused_ex) {
                z1 = false;
                goto label_183;
            }
            if(z3) {
                try {
                    OpenSsl.logger.info("System property \'io.netty.handler.ssl.openssl.useKeyManagerFactory\' is deprecated and so will be ignored in the future");
                    goto label_196;
                }
                catch(Throwable unused_ex) {
                    z1 = z4;
                }
                try {
                label_183:
                    OpenSsl.logger.debug("Failed to get useKeyManagerFactory system property.");
                    goto label_197;
                }
                catch(Error unused_ex) {
                }
                catch(Throwable throwable5) {
                    goto label_193;
                }
                z2 = true;
                try {
                label_186:
                    OpenSsl.logger.debug("KeyManagerFactory not supported.");
                }
                catch(Throwable throwable5) {
                    goto label_194;
                }
                try {
                    pemPrivateKey0.release();
                    goto label_211;
                label_193:
                    z2 = true;
                label_194:
                    pemPrivateKey0.release();
                    throw throwable5;
                label_196:
                    z1 = z4;
                label_197:
                    z2 = true;
                    pemPrivateKey0.release();
                    goto label_211;
                }
                catch(Throwable throwable4) {
                }
            }
            else {
                goto label_196;
            }
            try {
            label_201:
                SSL.freeSSL(v5);
                if(v10 != 0L) {
                    SSL.freeBIO(v10);
                }
                if(v7 != 0L) {
                    SSL.freeBIO(v7);
                }
                if(v8 != 0L) {
                    SSL.freeX509Chain(v8);
                }
                if(v9 != 0L) {
                    SSL.freePrivateKey(v9);
                }
                throw throwable4;
            label_211:
                SSL.freeSSL(v5);
                if(v10 != 0L) {
                    SSL.freeBIO(v10);
                }
                if(v7 != 0L) {
                    SSL.freeBIO(v7);
                }
                if(v8 != 0L) {
                    SSL.freeX509Chain(v8);
                }
                if(v9 != 0L) {
                    SSL.freePrivateKey(v9);
                }
                String s4 = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                if(s4 == null) {
                    z5 = z1;
                }
                else {
                    String[] arr_s4 = s4.split(",");
                    linkedHashSet1 = new LinkedHashSet(arr_s4.length);
                    linkedHashSet2 = new LinkedHashSet(arr_s4.length);
                    linkedHashSet3 = new LinkedHashSet();
                    v11 = false;
                    while(true) {
                    label_227:
                        if(v11 >= arr_s4.length) {
                            goto label_239;
                        }
                        s5 = arr_s4[v11];
                        s6 = GroupsConverter.toOpenSsl(s5);
                        z5 = z1;
                        goto label_231;
                    }
                }
                goto label_266;
            }
            catch(Throwable throwable3) {
                goto label_264;
            }
            try {
            label_231:
                if(SSLContext.setCurvesList(v2, new String[]{s6})) {
                    linkedHashSet2.add(s6);
                    linkedHashSet1.add(s5);
                }
                else {
                    linkedHashSet3.add(s5);
                }
                ++v11;
                z1 = z5;
                goto label_227;
            label_239:
                z5 = z1;
                if(!linkedHashSet1.isEmpty()) {
                    String[] arr_s5 = EmptyArrays.EMPTY_STRINGS;
                    String[] arr_s6 = (String[])linkedHashSet1.toArray(arr_s5);
                    if(linkedHashSet3.isEmpty()) {
                        String s7 = Arrays.toString(arr_s6);
                        OpenSsl.logger.info("Using configured namedGroups -D \'jdk.tls.namedGroup\': {} ", s7);
                    }
                    else {
                        String s8 = Arrays.toString(arr_s6);
                        String s9 = Arrays.toString(linkedHashSet3.toArray(arr_s5));
                        OpenSsl.logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", s8, s9);
                    }
                    arr_s1 = (String[])linkedHashSet2.toArray(arr_s5);
                    goto label_266;
                }
            }
            catch(Throwable throwable3) {
                goto label_260;
            }
            try {
                String s10 = Arrays.toString(linkedHashSet3.toArray(EmptyArrays.EMPTY_STRINGS));
                OpenSsl.logger.info("All configured namedGroups are not supported: {}. Use default: {}.", s10, "null");
                goto label_266;
            }
            catch(Throwable throwable3) {
                arr_s = arr_s1;
                try {
                    while(true) {
                        z1 = z5;
                        goto label_264;
                    label_260:
                    }
                }
                catch(Throwable throwable3) {
                    goto label_260;
                }
            }
            try {
                z5 = z1;
                goto label_266;
            }
            catch(Throwable throwable3) {
            }
            try {
            label_264:
                SSLContext.free(v2);
                throw throwable3;
            label_266:
                arr_s = arr_s1;
                z1 = z5;
                SSLContext.free(v2);
                z1 = z5;
                goto label_273;
            }
            catch(Exception exception0) {
            }
        label_272:
            OpenSsl.logger.warn("Failed to get the list of available OpenSSL cipher suites.", exception0);
        label_273:
            OpenSsl.NAMED_GROUPS = arr_s;
            Set set0 = Collections.unmodifiableSet(linkedHashSet0);
            OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES = set0;
            LinkedHashSet linkedHashSet4 = new LinkedHashSet(set0.size() * 2);
            for(Object object1: set0) {
                String s11 = (String)object1;
                if(SslUtils.isTLSv13Cipher(s11)) {
                    linkedHashSet4.add(s11);
                }
                else {
                    linkedHashSet4.add(CipherSuiteConverter.toJava(s11, "TLS"));
                    linkedHashSet4.add(CipherSuiteConverter.toJava(s11, "SSL"));
                }
            }
            SslUtils.addIfSupported(linkedHashSet4, arrayList0, SslUtils.DEFAULT_CIPHER_SUITES);
            SslUtils.addIfSupported(linkedHashSet4, arrayList0, SslUtils.TLSV13_CIPHER_SUITES);
            SslUtils.addIfSupported(linkedHashSet4, arrayList0, OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
            SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList0, linkedHashSet4);
            List list0 = Collections.unmodifiableList(arrayList0);
            OpenSsl.DEFAULT_CIPHERS = list0;
            Set set1 = Collections.unmodifiableSet(linkedHashSet4);
            OpenSsl.AVAILABLE_JAVA_CIPHER_SUITES = set1;
            LinkedHashSet linkedHashSet5 = new LinkedHashSet(set1.size() + OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES.size());
            linkedHashSet5.addAll(OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES);
            linkedHashSet5.addAll(set1);
            OpenSsl.AVAILABLE_CIPHER_SUITES = linkedHashSet5;
            OpenSsl.SUPPORTS_KEYMANAGER_FACTORY = z2;
            OpenSsl.USE_KEYMANAGER_FACTORY = z1;
            LinkedHashSet linkedHashSet6 = new LinkedHashSet(6);
            linkedHashSet6.add("SSLv2Hello");
            if(OpenSsl.doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                linkedHashSet6.add("SSLv2");
            }
            if(OpenSsl.doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                linkedHashSet6.add("SSLv3");
            }
            if(OpenSsl.doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                linkedHashSet6.add("TLSv1");
            }
            if(OpenSsl.doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                linkedHashSet6.add("TLSv1.1");
            }
            if(OpenSsl.doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                linkedHashSet6.add("TLSv1.2");
            }
            if(v3 == 0 || !OpenSsl.doesSupportProtocol(0x20, SSL.SSL_OP_NO_TLSv1_3)) {
                OpenSsl.TLSV13_SUPPORTED = false;
            }
            else {
                linkedHashSet6.add("TLSv1.3");
                OpenSsl.TLSV13_SUPPORTED = true;
            }
            Set set2 = Collections.unmodifiableSet(linkedHashSet6);
            OpenSsl.SUPPORTED_PROTOCOLS_SET = set2;
            OpenSsl.SUPPORTS_OCSP = OpenSsl.doesSupportOcsp();
            InternalLogger internalLogger1 = OpenSsl.logger;
            if(internalLogger1.isDebugEnabled()) {
                internalLogger1.debug("Supported protocols (OpenSSL): {} ", set2);
                internalLogger1.debug("Default cipher suites (OpenSSL): {}", list0);
            }
            try {
                z6 = false;
                javax.security.cert.X509Certificate.getInstance("-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----".getBytes(CharsetUtil.US_ASCII));
                z6 = true;
            }
            catch(CertificateException unused_ex) {
            }
            OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED = z6;
            return;
        }
        OpenSsl.DEFAULT_CIPHERS = Collections.EMPTY_LIST;
        OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES = Collections.EMPTY_SET;
        OpenSsl.AVAILABLE_JAVA_CIPHER_SUITES = Collections.EMPTY_SET;
        OpenSsl.AVAILABLE_CIPHER_SUITES = Collections.EMPTY_SET;
        OpenSsl.SUPPORTS_KEYMANAGER_FACTORY = false;
        OpenSsl.USE_KEYMANAGER_FACTORY = false;
        OpenSsl.SUPPORTED_PROTOCOLS_SET = Collections.EMPTY_SET;
        OpenSsl.SUPPORTS_OCSP = false;
        OpenSsl.TLSV13_SUPPORTED = false;
        OpenSsl.IS_BORINGSSL = false;
        OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
        OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
        OpenSsl.NAMED_GROUPS = OpenSsl.DEFAULT_NAMED_GROUPS;
        OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED = false;
    }

    @Deprecated
    public static Set availableCipherSuites() {
        return OpenSsl.availableOpenSslCipherSuites();
    }

    public static Set availableJavaCipherSuites() {
        return OpenSsl.AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set availableOpenSslCipherSuites() {
        return OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static String checkTls13Ciphers(InternalLogger internalLogger0, String s) {
        return s;
    }

    public static String[] defaultProtocols(boolean z) {
        Set set0 = z ? OpenSsl.CLIENT_DEFAULT_PROTOCOLS : OpenSsl.SERVER_DEFAULT_PROTOCOLS;
        if(set0 == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList(set0.size());
        for(Object object0: set0) {
            String s = (String)object0;
            if(OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(s)) {
                arrayList0.add(s);
            }
        }
        return (String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    private static boolean doesSupportOcsp() {
        long v;
        if(Long.compare(OpenSsl.version(), 0x10002000L) >= 0) {
            try {
                v = -1L;
                v = SSLContext.make(16, 1);
                SSLContext.enableOcsp(v, false);
            }
            catch(Exception unused_ex) {
                if(v != -1L) {
                    SSLContext.free(v);
                    return false;
                }
                return false;
            }
            catch(Throwable throwable0) {
                if(v != -1L) {
                    SSLContext.free(v);
                }
                throw throwable0;
            }
            if(v != -1L) {
                SSLContext.free(v);
            }
            return true;
        }
        return false;
    }

    private static boolean doesSupportProtocol(int v, int v1) {
        long v2;
        if(v1 == 0) {
            return false;
        }
        try {
            v2 = SSLContext.make(v, 2);
        }
        catch(Exception unused_ex) {
            return false;
        }
        if(Long.compare(v2, -1L) != 0) {
            SSLContext.free(v2);
        }
        return true;
    }

    public static void ensureAvailability() {
        Throwable throwable0 = OpenSsl.UNAVAILABILITY_CAUSE;
        if(throwable0 != null) {
            throw (Error)new UnsatisfiedLinkError("failed to load the required native library").initCause(throwable0);
        }
    }

    private static boolean initializeTcNative(String s) {
        return Library.initialize("provided", s);
    }

    @Deprecated
    public static boolean isAlpnSupported() {
        return ((long)OpenSsl.version()) >= 0x10002000L;
    }

    public static boolean isAvailable() [...] // 潜在的解密器

    public static boolean isBoringSSL() [...] // 潜在的解密器

    public static boolean isCipherSuiteAvailable(String s) {
        String s1 = CipherSuiteConverter.toOpenSsl(s, false);
        if(s1 != null) {
            s = s1;
        }
        return OpenSsl.AVAILABLE_OPENSSL_CIPHER_SUITES.contains(s);
    }

    public static boolean isOcspSupported() [...] // 潜在的解密器

    // 去混淆评级： 中等(60)
    public static boolean isOptionSupported(SslContextOption sslContextOption0) {
        return sslContextOption0 == OpenSslContextOption.USE_TASKS;
    }

    public static boolean isSessionCacheSupported() {
        return ((long)OpenSsl.version()) >= 0x10100000L;
    }

    public static boolean isTlsv13Supported() [...] // 潜在的解密器

    private static void loadTcNative() {
        String s = PlatformDependent.normalizedOs();
        String s1 = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet0 = new LinkedHashSet(5);
        if("linux".equals(s)) {
            for(Object object0: PlatformDependent.normalizedLinuxClassifiers()) {
                linkedHashSet0.add("netty_tcnative_" + s + '_' + s1 + "_" + ((String)object0));
            }
            linkedHashSet0.add("netty_tcnative_" + s + '_' + s1);
            linkedHashSet0.add("netty_tcnative_" + s + '_' + s1 + "_fedora");
        }
        else {
            linkedHashSet0.add("netty_tcnative_" + s + '_' + s1);
        }
        linkedHashSet0.add("netty_tcnative_" + s1);
        linkedHashSet0.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(PlatformDependent.getClassLoader(SSLContext.class), ((String[])linkedHashSet0.toArray(EmptyArrays.EMPTY_STRINGS)));
    }

    // 去混淆评级： 低(20)
    public static long memoryAddress(ByteBuf byteBuf0) {
        return byteBuf0.hasMemoryAddress() ? byteBuf0.memoryAddress() : Buffer.address(byteBuf0.internalNioBuffer(0, byteBuf0.readableBytes()));
    }

    private static Set protocols(String s) {
        Set set0 = null;
        String s1 = SystemPropertyUtil.get(s, null);
        if(s1 != null) {
            set0 = new HashSet();
            String[] arr_s = s1.split(",");
            for(int v = 0; v < arr_s.length; ++v) {
                ((HashSet)set0).add(arr_s[v].trim());
            }
        }
        return set0;
    }

    public static void releaseIfNeeded(ReferenceCounted referenceCounted0) {
        if(referenceCounted0.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted0);
        }
    }

    public static X509Certificate selfSignedCertificate() {
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----".getBytes(CharsetUtil.US_ASCII));
        return (X509Certificate)SslContext.X509_CERT_FACTORY.generateCertificate(byteArrayInputStream0);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean supportsHostnameValidation() {
        return true;
    }

    public static boolean supportsKeyManagerFactory() {
        return OpenSsl.SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return OpenSsl.UNAVAILABILITY_CAUSE;
    }

    public static boolean useKeyManagerFactory() [...] // 潜在的解密器

    // 去混淆评级： 低(40)
    public static int version() {
        return SSL.version();
    }

    // 去混淆评级： 低(40)
    public static String versionString() {
        return SSL.versionString();
    }
}

