package org.apache.http.conn.ssl;

import java.net.Socket;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class SSLContextBuilder {
    static class KeyManagerDelegate implements X509KeyManager {
        private final PrivateKeyStrategy aliasStrategy;
        private final X509KeyManager keyManager;

        public KeyManagerDelegate(X509KeyManager x509KeyManager0, PrivateKeyStrategy privateKeyStrategy0) {
            this.keyManager = x509KeyManager0;
            this.aliasStrategy = privateKeyStrategy0;
        }

        @Override  // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] arr_s, Principal[] arr_principal, Socket socket0) {
            HashMap hashMap0 = new HashMap();
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                String[] arr_s1 = this.keyManager.getClientAliases(s, arr_principal);
                if(arr_s1 != null) {
                    int v1 = arr_s1.length;
                    for(int v2 = 0; v2 < v1; ++v2) {
                        String s1 = arr_s1[v2];
                        hashMap0.put(s1, new PrivateKeyDetails(s, this.keyManager.getCertificateChain(s1)));
                    }
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap0, socket0);
        }

        @Override  // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String s, Principal[] arr_principal, Socket socket0) {
            HashMap hashMap0 = new HashMap();
            String[] arr_s = this.keyManager.getServerAliases(s, arr_principal);
            if(arr_s != null) {
                for(int v = 0; v < arr_s.length; ++v) {
                    String s1 = arr_s[v];
                    hashMap0.put(s1, new PrivateKeyDetails(s, this.keyManager.getCertificateChain(s1)));
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap0, socket0);
        }

        @Override  // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String s) {
            return this.keyManager.getCertificateChain(s);
        }

        @Override  // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String s, Principal[] arr_principal) {
            return this.keyManager.getClientAliases(s, arr_principal);
        }

        @Override  // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String s) {
            return this.keyManager.getPrivateKey(s);
        }

        @Override  // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String s, Principal[] arr_principal) {
            return this.keyManager.getServerAliases(s, arr_principal);
        }
    }

    static class TrustManagerDelegate implements X509TrustManager {
        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        public TrustManagerDelegate(X509TrustManager x509TrustManager0, TrustStrategy trustStrategy0) {
            this.trustManager = x509TrustManager0;
            this.trustStrategy = trustStrategy0;
        }

        @Override  // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
            this.trustManager.checkClientTrusted(arr_x509Certificate, s);
        }

        @Override  // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
            if(!this.trustStrategy.isTrusted(arr_x509Certificate, s)) {
                this.trustManager.checkServerTrusted(arr_x509Certificate, s);
            }
        }

        @Override  // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }

    static final String SSL = "SSL";
    static final String TLS = "TLS";
    private Set keymanagers;
    private String protocol;
    private SecureRandom secureRandom;
    private Set trustmanagers;

    public SSLContextBuilder() {
        this.keymanagers = new HashSet();
        this.trustmanagers = new HashSet();
    }

    public SSLContext build() {
        SSLContext sSLContext0 = SSLContext.getInstance((this.protocol == null ? "TLS" : this.protocol));
        TrustManager[] arr_trustManager = null;
        KeyManager[] arr_keyManager = this.keymanagers.isEmpty() ? null : ((KeyManager[])this.keymanagers.toArray(new KeyManager[this.keymanagers.size()]));
        if(!this.trustmanagers.isEmpty()) {
            arr_trustManager = (TrustManager[])this.trustmanagers.toArray(new TrustManager[this.trustmanagers.size()]);
        }
        sSLContext0.init(arr_keyManager, arr_trustManager, this.secureRandom);
        return sSLContext0;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore0, char[] arr_c) {
        this.loadKeyMaterial(keyStore0, arr_c, null);
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore0, char[] arr_c, PrivateKeyStrategy privateKeyStrategy0) {
        KeyManagerFactory keyManagerFactory0 = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory0.init(keyStore0, arr_c);
        KeyManager[] arr_keyManager = keyManagerFactory0.getKeyManagers();
        if(arr_keyManager != null) {
            if(privateKeyStrategy0 != null) {
                for(int v1 = 0; v1 < arr_keyManager.length; ++v1) {
                    KeyManager keyManager0 = arr_keyManager[v1];
                    if(keyManager0 instanceof X509KeyManager) {
                        arr_keyManager[v1] = new KeyManagerDelegate(((X509KeyManager)keyManager0), privateKeyStrategy0);
                    }
                }
            }
            for(int v = 0; v < arr_keyManager.length; ++v) {
                this.keymanagers.add(arr_keyManager[v]);
            }
        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore0) {
        return this.loadTrustMaterial(keyStore0, null);
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore0, TrustStrategy trustStrategy0) {
        TrustManagerFactory trustManagerFactory0 = TrustManagerFactory.getInstance("PKIX");
        trustManagerFactory0.init(keyStore0);
        TrustManager[] arr_trustManager = trustManagerFactory0.getTrustManagers();
        if(arr_trustManager != null) {
            if(trustStrategy0 != null) {
                for(int v1 = 0; v1 < arr_trustManager.length; ++v1) {
                    TrustManager trustManager0 = arr_trustManager[v1];
                    if(trustManager0 instanceof X509TrustManager) {
                        arr_trustManager[v1] = new TrustManagerDelegate(((X509TrustManager)trustManager0), trustStrategy0);
                    }
                }
            }
            for(int v = 0; v < arr_trustManager.length; ++v) {
                this.trustmanagers.add(arr_trustManager[v]);
            }
        }
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom secureRandom0) {
        this.secureRandom = secureRandom0;
        return this;
    }

    public SSLContextBuilder useProtocol(String s) {
        this.protocol = s;
        return this;
    }

    public SSLContextBuilder useSSL() {
        this.protocol = "SSL";
        return this;
    }

    public SSLContextBuilder useTLS() {
        this.protocol = "TLS";
        return this;
    }
}

