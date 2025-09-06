package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import javax.net.ssl.SSLEngine;

public interface OpenSslPrivateKeyMethod {
    public static final int SSL_SIGN_ECDSA_SECP256R1_SHA256;
    public static final int SSL_SIGN_ECDSA_SECP384R1_SHA384;
    public static final int SSL_SIGN_ECDSA_SECP521R1_SHA512;
    public static final int SSL_SIGN_ECDSA_SHA1;
    public static final int SSL_SIGN_ED25519;
    public static final int SSL_SIGN_RSA_PKCS1_MD5_SHA1;
    public static final int SSL_SIGN_RSA_PKCS1_SHA1;
    public static final int SSL_SIGN_RSA_PKCS1_SHA256;
    public static final int SSL_SIGN_RSA_PKCS1_SHA384;
    public static final int SSL_SIGN_RSA_PKCS1_SHA512;
    public static final int SSL_SIGN_RSA_PSS_RSAE_SHA256;
    public static final int SSL_SIGN_RSA_PSS_RSAE_SHA384;
    public static final int SSL_SIGN_RSA_PSS_RSAE_SHA512;

    static {
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA1;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA256;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA384;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA512;
        OpenSslPrivateKeyMethod.SSL_SIGN_ECDSA_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SHA1;
        OpenSslPrivateKeyMethod.SSL_SIGN_ECDSA_SECP256R1_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP256R1_SHA256;
        OpenSslPrivateKeyMethod.SSL_SIGN_ECDSA_SECP384R1_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP384R1_SHA384;
        OpenSslPrivateKeyMethod.SSL_SIGN_ECDSA_SECP521R1_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP521R1_SHA512;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA256;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA384;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA512;
        OpenSslPrivateKeyMethod.SSL_SIGN_ED25519 = SSLPrivateKeyMethod.SSL_SIGN_ED25519;
        OpenSslPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_MD5_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_MD5_SHA1;
    }

    byte[] decrypt(SSLEngine arg1, byte[] arg2);

    byte[] sign(SSLEngine arg1, int arg2, byte[] arg3);
}

