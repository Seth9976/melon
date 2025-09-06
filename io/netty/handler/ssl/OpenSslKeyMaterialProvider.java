package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager0, String s) {
        this.keyManager = x509KeyManager0;
        this.password = s;
    }

    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator0, String s) {
        OpenSslKeyMaterial openSslKeyMaterial0;
        long v4;
        long v3;
        long v2;
        long v1;
        X509Certificate[] arr_x509Certificate = this.keyManager.getCertificateChain(s);
        if(arr_x509Certificate != null && arr_x509Certificate.length != 0) {
            PrivateKey privateKey0 = this.keyManager.getPrivateKey(s);
            PemEncoded pemEncoded0 = PemX509Certificate.toPEM(byteBufAllocator0, true, arr_x509Certificate);
            long v = 0L;
            try {
                v1 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, pemEncoded0.retain());
            }
            catch(Throwable throwable0) {
                v2 = 0L;
                v3 = 0L;
                v1 = 0L;
                v4 = 0L;
                goto label_37;
            }
            try {
                v2 = SSL.parseX509Chain(v1);
            }
            catch(Throwable throwable0) {
                v2 = 0L;
                v3 = 0L;
                v4 = 0L;
                goto label_37;
            }
            try {
                if(privateKey0 instanceof OpenSslPrivateKey) {
                    openSslKeyMaterial0 = ((OpenSslPrivateKey)privateKey0).newKeyMaterial(v2, arr_x509Certificate);
                }
                else {
                    v4 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, privateKey0);
                    goto label_28;
                }
                goto label_45;
            }
            catch(Throwable throwable0) {
                v3 = 0L;
                v4 = 0L;
                goto label_37;
            }
        label_28:
            if(privateKey0 == null) {
                v3 = 0L;
            }
            else {
                try {
                    v3 = 0L;
                    v3 = SSL.parsePrivateKey(v4, this.password);
                    openSslKeyMaterial0 = new DefaultOpenSslKeyMaterial(v2, v3, arr_x509Certificate);
                    v = v4;
                    goto label_45;
                }
                catch(Throwable throwable0) {
                }
                goto label_37;
            }
            openSslKeyMaterial0 = new DefaultOpenSslKeyMaterial(v2, v3, arr_x509Certificate);
            v = v4;
            goto label_45;
        label_37:
            SSL.freeBIO(v1);
            SSL.freeBIO(v4);
            if(v2 != 0L) {
                SSL.freeX509Chain(v2);
            }
            if(v3 != 0L) {
                SSL.freePrivateKey(v3);
            }
            pemEncoded0.release();
            throw throwable0;
        label_45:
            SSL.freeBIO(v1);
            SSL.freeBIO(v);
            pemEncoded0.release();
            return openSslKeyMaterial0;
        }
        return null;
    }

    public void destroy() {
    }

    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    public static void validateKeyMaterialSupported(X509Certificate[] arr_x509Certificate, PrivateKey privateKey0, String s) {
        OpenSslKeyMaterialProvider.validateSupported(arr_x509Certificate);
        OpenSslKeyMaterialProvider.validateSupported(privateKey0, s);
    }

    private static void validateSupported(PrivateKey privateKey0, String s) {
        long v2;
        long v1;
        if(privateKey0 != null) {
            try {
                v1 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey0);
                v2 = SSL.parsePrivateKey(v1, s);
            }
            catch(Exception exception0) {
                throw new SSLException("PrivateKey type not supported " + privateKey0.getFormat(), exception0);
            }
            finally {
                SSL.freeBIO(v1);
            }
            if(v2 != 0L) {
                SSL.freePrivateKey(v2);
            }
        }
    }

    private static void validateSupported(X509Certificate[] arr_x509Certificate) {
        long v2;
        long v1;
        PemEncoded pemEncoded0;
        long v;
        if(arr_x509Certificate != null && arr_x509Certificate.length != 0) {
            try {
                v = 0L;
                pemEncoded0 = null;
                pemEncoded0 = PemX509Certificate.toPEM(UnpooledByteBufAllocator.DEFAULT, true, arr_x509Certificate);
                PemEncoded pemEncoded1 = pemEncoded0.retain();
                v1 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemEncoded1);
                v2 = SSL.parseX509Chain(v1);
                goto label_22;
            }
            catch(Exception exception0) {
                throw new SSLException("Certificate type not supported", exception0);
            }
            catch(Throwable throwable0) {
                goto label_18;
            }
            v = v1;
        label_18:
            SSL.freeBIO(v);
            if(pemEncoded0 != null) {
                pemEncoded0.release();
            }
            throw throwable0;
        label_22:
            SSL.freeBIO(v1);
            if(v2 != 0L) {
                SSL.freeX509Chain(v2);
            }
            pemEncoded0.release();
        }
    }
}

