package io.netty.handler.ssl;

import io.netty.handler.ssl.util.KeyManagerFactoryWrapper;
import io.netty.handler.ssl.util.TrustManagerFactoryWrapper;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class SslContextBuilder {
    private static final Map.Entry[] EMPTY_ENTRIES;
    private ApplicationProtocolConfig apn;
    private CipherSuiteFilter cipherFilter;
    private Iterable ciphers;
    private ClientAuth clientAuth;
    private boolean enableOcsp;
    private final boolean forServer;
    private PrivateKey key;
    private X509Certificate[] keyCertChain;
    private KeyManagerFactory keyManagerFactory;
    private String keyPassword;
    private String keyStoreType;
    private final Map options;
    private String[] protocols;
    private SslProvider provider;
    private long sessionCacheSize;
    private long sessionTimeout;
    private Provider sslContextProvider;
    private boolean startTls;
    private X509Certificate[] trustCertCollection;
    private TrustManagerFactory trustManagerFactory;

    static {
        SslContextBuilder.EMPTY_ENTRIES = new Map.Entry[0];
    }

    private SslContextBuilder(boolean z) {
        this.cipherFilter = IdentityCipherSuiteFilter.INSTANCE;
        this.clientAuth = ClientAuth.NONE;
        this.keyStoreType = "pkcs12";
        this.options = new HashMap();
        this.forServer = z;
    }

    public SslContextBuilder applicationProtocolConfig(ApplicationProtocolConfig applicationProtocolConfig0) {
        this.apn = applicationProtocolConfig0;
        return this;
    }

    // 去混淆评级： 低(20)
    public SslContext build() {
        return this.forServer ? SslContext.newServerContextInternal(this.provider, this.sslContextProvider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.sessionCacheSize, this.sessionTimeout, this.clientAuth, this.protocols, this.startTls, this.enableOcsp, this.keyStoreType, ((Map.Entry[])SslContextBuilder.toArray(this.options.entrySet(), SslContextBuilder.EMPTY_ENTRIES))) : SslContext.newClientContextInternal(this.provider, this.sslContextProvider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.protocols, this.sessionCacheSize, this.sessionTimeout, this.enableOcsp, this.keyStoreType, ((Map.Entry[])SslContextBuilder.toArray(this.options.entrySet(), SslContextBuilder.EMPTY_ENTRIES)));
    }

    public SslContextBuilder ciphers(Iterable iterable0) {
        return this.ciphers(iterable0, IdentityCipherSuiteFilter.INSTANCE);
    }

    public SslContextBuilder ciphers(Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0) {
        this.cipherFilter = (CipherSuiteFilter)ObjectUtil.checkNotNull(cipherSuiteFilter0, "cipherFilter");
        this.ciphers = iterable0;
        return this;
    }

    public SslContextBuilder clientAuth(ClientAuth clientAuth0) {
        this.clientAuth = (ClientAuth)ObjectUtil.checkNotNull(clientAuth0, "clientAuth");
        return this;
    }

    public SslContextBuilder enableOcsp(boolean z) {
        this.enableOcsp = z;
        return this;
    }

    public static SslContextBuilder forClient() {
        return new SslContextBuilder(false);
    }

    public static SslContextBuilder forServer(File file0, File file1) {
        return new SslContextBuilder(true).keyManager(file0, file1);
    }

    public static SslContextBuilder forServer(File file0, File file1, String s) {
        return new SslContextBuilder(true).keyManager(file0, file1, s);
    }

    public static SslContextBuilder forServer(InputStream inputStream0, InputStream inputStream1) {
        return new SslContextBuilder(true).keyManager(inputStream0, inputStream1);
    }

    public static SslContextBuilder forServer(InputStream inputStream0, InputStream inputStream1, String s) {
        return new SslContextBuilder(true).keyManager(inputStream0, inputStream1, s);
    }

    public static SslContextBuilder forServer(PrivateKey privateKey0, Iterable iterable0) {
        return SslContextBuilder.forServer(privateKey0, ((X509Certificate[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_X509_CERTIFICATES)));
    }

    public static SslContextBuilder forServer(PrivateKey privateKey0, String s, Iterable iterable0) {
        return SslContextBuilder.forServer(privateKey0, s, ((X509Certificate[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_X509_CERTIFICATES)));
    }

    public static SslContextBuilder forServer(PrivateKey privateKey0, String s, X509Certificate[] arr_x509Certificate) {
        return new SslContextBuilder(true).keyManager(privateKey0, s, arr_x509Certificate);
    }

    public static SslContextBuilder forServer(PrivateKey privateKey0, X509Certificate[] arr_x509Certificate) {
        return new SslContextBuilder(true).keyManager(privateKey0, arr_x509Certificate);
    }

    public static SslContextBuilder forServer(KeyManager keyManager0) {
        return new SslContextBuilder(true).keyManager(keyManager0);
    }

    public static SslContextBuilder forServer(KeyManagerFactory keyManagerFactory0) {
        return new SslContextBuilder(true).keyManager(keyManagerFactory0);
    }

    public SslContextBuilder keyManager(File file0, File file1) {
        return this.keyManager(file0, file1, null);
    }

    public SslContextBuilder keyManager(File file0, File file1, String s) {
        X509Certificate[] arr_x509Certificate;
        try {
            arr_x509Certificate = SslContext.toX509Certificates(file0);
        }
        catch(Exception exception0) {
            throw new IllegalArgumentException("File does not contain valid certificates: " + file0, exception0);
        }
        try {
            return this.keyManager(SslContext.toPrivateKey(file1, s), s, arr_x509Certificate);
        }
        catch(Exception exception1) {
            throw new IllegalArgumentException("File does not contain valid private key: " + file1, exception1);
        }
    }

    public SslContextBuilder keyManager(InputStream inputStream0, InputStream inputStream1) {
        return this.keyManager(inputStream0, inputStream1, null);
    }

    public SslContextBuilder keyManager(InputStream inputStream0, InputStream inputStream1, String s) {
        X509Certificate[] arr_x509Certificate;
        try {
            arr_x509Certificate = SslContext.toX509Certificates(inputStream0);
        }
        catch(Exception exception0) {
            throw new IllegalArgumentException("Input stream not contain valid certificates.", exception0);
        }
        try {
            return this.keyManager(SslContext.toPrivateKey(inputStream1, s), s, arr_x509Certificate);
        }
        catch(Exception exception1) {
            throw new IllegalArgumentException("Input stream does not contain valid private key.", exception1);
        }
    }

    public SslContextBuilder keyManager(PrivateKey privateKey0, Iterable iterable0) {
        return this.keyManager(privateKey0, ((X509Certificate[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_X509_CERTIFICATES)));
    }

    public SslContextBuilder keyManager(PrivateKey privateKey0, String s, Iterable iterable0) {
        return this.keyManager(privateKey0, s, ((X509Certificate[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_X509_CERTIFICATES)));
    }

    public SslContextBuilder keyManager(PrivateKey privateKey0, String s, X509Certificate[] arr_x509Certificate) {
        if(this.forServer) {
            ObjectUtil.checkNonEmpty(arr_x509Certificate, "keyCertChain");
            ObjectUtil.checkNotNull(privateKey0, "key required for servers");
        }
        if(arr_x509Certificate == null || arr_x509Certificate.length == 0) {
            this.keyCertChain = null;
        }
        else {
            for(int v = 0; v < arr_x509Certificate.length; ++v) {
                ObjectUtil.checkNotNullWithIAE(arr_x509Certificate[v], "cert");
            }
            this.keyCertChain = (X509Certificate[])arr_x509Certificate.clone();
        }
        this.key = privateKey0;
        this.keyPassword = s;
        this.keyManagerFactory = null;
        return this;
    }

    public SslContextBuilder keyManager(PrivateKey privateKey0, X509Certificate[] arr_x509Certificate) {
        return this.keyManager(privateKey0, null, arr_x509Certificate);
    }

    public SslContextBuilder keyManager(KeyManager keyManager0) {
        if(this.forServer) {
            ObjectUtil.checkNotNull(keyManager0, "keyManager required for servers");
        }
        this.keyManagerFactory = keyManager0 == null ? null : new KeyManagerFactoryWrapper(keyManager0);
        this.keyCertChain = null;
        this.key = null;
        this.keyPassword = null;
        return this;
    }

    public SslContextBuilder keyManager(KeyManagerFactory keyManagerFactory0) {
        if(this.forServer) {
            ObjectUtil.checkNotNull(keyManagerFactory0, "keyManagerFactory required for servers");
        }
        this.keyCertChain = null;
        this.key = null;
        this.keyPassword = null;
        this.keyManagerFactory = keyManagerFactory0;
        return this;
    }

    public SslContextBuilder keyStoreType(String s) {
        this.keyStoreType = s;
        return this;
    }

    public SslContextBuilder option(SslContextOption sslContextOption0, Object object0) {
        if(object0 == null) {
            this.options.remove(sslContextOption0);
            return this;
        }
        this.options.put(sslContextOption0, object0);
        return this;
    }

    public SslContextBuilder protocols(Iterable iterable0) {
        return this.protocols(((String[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_STRINGS)));
    }

    public SslContextBuilder protocols(String[] arr_s) {
        this.protocols = arr_s == null ? null : ((String[])arr_s.clone());
        return this;
    }

    public SslContextBuilder sessionCacheSize(long v) {
        this.sessionCacheSize = v;
        return this;
    }

    public SslContextBuilder sessionTimeout(long v) {
        this.sessionTimeout = v;
        return this;
    }

    public SslContextBuilder sslContextProvider(Provider provider0) {
        this.sslContextProvider = provider0;
        return this;
    }

    public SslContextBuilder sslProvider(SslProvider sslProvider0) {
        this.provider = sslProvider0;
        return this;
    }

    public SslContextBuilder startTls(boolean z) {
        this.startTls = z;
        return this;
    }

    private static Object[] toArray(Iterable iterable0, Object[] arr_object) {
        if(iterable0 == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            arrayList0.add(object0);
        }
        return arrayList0.toArray(arr_object);
    }

    public SslContextBuilder trustManager(File file0) {
        try {
            return this.trustManager(SslContext.toX509Certificates(file0));
        }
        catch(Exception exception0) {
            throw new IllegalArgumentException("File does not contain valid certificates: " + file0, exception0);
        }
    }

    public SslContextBuilder trustManager(InputStream inputStream0) {
        try {
            return this.trustManager(SslContext.toX509Certificates(inputStream0));
        }
        catch(Exception exception0) {
            throw new IllegalArgumentException("Input stream does not contain valid certificates.", exception0);
        }
    }

    public SslContextBuilder trustManager(Iterable iterable0) {
        return this.trustManager(((X509Certificate[])SslContextBuilder.toArray(iterable0, EmptyArrays.EMPTY_X509_CERTIFICATES)));
    }

    public SslContextBuilder trustManager(TrustManager trustManager0) {
        this.trustManagerFactory = trustManager0 == null ? null : new TrustManagerFactoryWrapper(trustManager0);
        this.trustCertCollection = null;
        return this;
    }

    public SslContextBuilder trustManager(TrustManagerFactory trustManagerFactory0) {
        this.trustCertCollection = null;
        this.trustManagerFactory = trustManagerFactory0;
        return this;
    }

    public SslContextBuilder trustManager(X509Certificate[] arr_x509Certificate) {
        this.trustCertCollection = arr_x509Certificate == null ? null : ((X509Certificate[])arr_x509Certificate.clone());
        this.trustManagerFactory = null;
        return this;
    }
}

