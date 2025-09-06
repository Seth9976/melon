package io.netty.handler.ssl;

import U4.x;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class EnhancingX509ExtendedTrustManager extends X509ExtendedTrustManager {
    private final X509ExtendedTrustManager wrapped;

    public EnhancingX509ExtendedTrustManager(X509TrustManager x509TrustManager0) {
        this.wrapped = (X509ExtendedTrustManager)x509TrustManager0;
    }

    @Override  // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
        this.wrapped.checkClientTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s, Socket socket0) {
        this.wrapped.checkClientTrusted(arr_x509Certificate, s, socket0);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s, SSLEngine sSLEngine0) {
        this.wrapped.checkClientTrusted(arr_x509Certificate, s, sSLEngine0);
    }

    @Override  // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
        try {
            this.wrapped.checkServerTrusted(arr_x509Certificate, s);
        }
        catch(CertificateException certificateException0) {
            EnhancingX509ExtendedTrustManager.throwEnhancedCertificateException(arr_x509Certificate, certificateException0);
        }
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s, Socket socket0) {
        try {
            this.wrapped.checkServerTrusted(arr_x509Certificate, s, socket0);
        }
        catch(CertificateException certificateException0) {
            EnhancingX509ExtendedTrustManager.throwEnhancedCertificateException(arr_x509Certificate, certificateException0);
        }
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s, SSLEngine sSLEngine0) {
        try {
            this.wrapped.checkServerTrusted(arr_x509Certificate, s, sSLEngine0);
        }
        catch(CertificateException certificateException0) {
            EnhancingX509ExtendedTrustManager.throwEnhancedCertificateException(arr_x509Certificate, certificateException0);
        }
    }

    @Override  // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.wrapped.getAcceptedIssuers();
    }

    private static void throwEnhancedCertificateException(X509Certificate[] arr_x509Certificate, CertificateException certificateException0) {
        String s = certificateException0.getMessage();
        if(s != null && certificateException0.getMessage().startsWith("No subject alternative DNS name matching")) {
            StringBuilder stringBuilder0 = new StringBuilder(0x40);
            for(int v = 0; v < arr_x509Certificate.length; ++v) {
                Collection collection0 = arr_x509Certificate[v].getSubjectAlternativeNames();
                if(collection0 != null) {
                    for(Object object0: collection0) {
                        List list0 = (List)object0;
                        if(list0.size() >= 2 && ((int)(((Integer)list0.get(0)))) == 2) {
                            stringBuilder0.append(((String)list0.get(1)));
                            stringBuilder0.append(",");
                        }
                    }
                }
            }
            if(stringBuilder0.length() != 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
                StringBuilder stringBuilder1 = x.p(s, " Subject alternative DNS names in the certificate chain of ");
                stringBuilder1.append(arr_x509Certificate.length);
                stringBuilder1.append(" certificate(s): ");
                stringBuilder1.append(stringBuilder0);
                throw new CertificateException(stringBuilder1.toString(), certificateException0);
            }
        }
        throw certificateException0;
    }
}

