package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslX509KeyManagerFactory extends KeyManagerFactory {
    static final class OpenSslKeyManagerFactorySpi extends KeyManagerFactorySpi {
        static final class ProviderFactory {
            static final class OpenSslPopulatedKeyMaterialProvider extends OpenSslKeyMaterialProvider {
                private final Map materialMap;

                public OpenSslPopulatedKeyMaterialProvider(X509KeyManager x509KeyManager0, String s, Iterable iterable0) {
                    super(x509KeyManager0, s);
                    this.materialMap = new HashMap();
                    try {
                        for(Object object0: iterable0) {
                            String s1 = (String)object0;
                            if(s1 != null && !this.materialMap.containsKey(s1)) {
                                try {
                                    OpenSslKeyMaterial openSslKeyMaterial0 = super.chooseKeyMaterial(UnpooledByteBufAllocator.DEFAULT, s1);
                                    this.materialMap.put(s1, openSslKeyMaterial0);
                                }
                                catch(Exception exception0) {
                                    this.materialMap.put(s1, exception0);
                                }
                            }
                        }
                    }
                    catch(Throwable throwable0) {
                        this.destroy();
                        throw throwable0;
                    }
                    ObjectUtil.checkNonEmpty(this.materialMap, "materialMap");
                }

                @Override  // io.netty.handler.ssl.OpenSslKeyMaterialProvider
                public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator0, String s) {
                    Object object0 = this.materialMap.get(s);
                    if(object0 == null) {
                        return null;
                    }
                    if(!(object0 instanceof OpenSslKeyMaterial)) {
                        throw (Exception)object0;
                    }
                    return ((OpenSslKeyMaterial)object0).retain();
                }

                @Override  // io.netty.handler.ssl.OpenSslKeyMaterialProvider
                public void destroy() {
                    for(Object object0: this.materialMap.values()) {
                        ReferenceCountUtil.release(object0);
                    }
                    this.materialMap.clear();
                }
            }

            private final Iterable aliases;
            private final X509KeyManager keyManager;
            private final String password;

            public ProviderFactory(X509KeyManager x509KeyManager0, String s, Iterable iterable0) {
                this.keyManager = x509KeyManager0;
                this.password = s;
                this.aliases = iterable0;
            }

            public static X509KeyManager access$000(ProviderFactory openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0) {
                return openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0.keyManager;
            }

            public OpenSslKeyMaterialProvider newProvider() {
                return new OpenSslPopulatedKeyMaterialProvider(this.keyManager, this.password, this.aliases);
            }
        }

        final KeyManagerFactory kmf;
        private volatile ProviderFactory providerFactory;

        public OpenSslKeyManagerFactorySpi(KeyManagerFactory keyManagerFactory0) {
            this.kmf = (KeyManagerFactory)ObjectUtil.checkNotNull(keyManagerFactory0, "kmf");
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
        public KeyManager[] engineGetKeyManagers() {
            ProviderFactory openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0 = this.providerFactory;
            if(openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0 == null) {
                throw new IllegalStateException("engineInit(...) not called yet");
            }
            return new KeyManager[]{ProviderFactory.access$000(openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0)};
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(KeyStore keyStore0, char[] arr_c) {
            synchronized(this) {
                if(this.providerFactory == null) {
                    if(!keyStore0.aliases().hasMoreElements()) {
                        throw new KeyStoreException("No aliases found");
                    }
                    this.kmf.init(keyStore0, arr_c);
                    this.providerFactory = new ProviderFactory(ReferenceCountedOpenSslContext.chooseX509KeyManager(this.kmf.getKeyManagers()), OpenSslKeyManagerFactorySpi.password(arr_c), Collections.list(keyStore0.aliases()));
                    return;
                }
            }
            throw new KeyStoreException("Already initialized");
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
            throw new InvalidAlgorithmParameterException("Not supported");
        }

        public OpenSslKeyMaterialProvider newProvider() {
            ProviderFactory openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0 = this.providerFactory;
            if(openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0 == null) {
                throw new IllegalStateException("engineInit(...) not called yet");
            }
            return openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory0.newProvider();
        }

        private static String password(char[] arr_c) {
            return arr_c == null || arr_c.length == 0 ? null : new String(arr_c);
        }
    }

    static final class OpenSslKeyStore extends KeyStore {
        private OpenSslKeyStore(X509Certificate[] arr_x509Certificate, boolean z) {
            super(new KeyStoreSpi() {
                private final Date creationDate;

                {
                    boolean z = arr_x509Certificate;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.creationDate = new Date();
                }

                @Override
                public Enumeration engineAliases() {
                    return Collections.enumeration(Collections.singleton("key"));
                }

                @Override
                public boolean engineContainsAlias(String s) {
                    return "key".equals(s);
                }

                @Override
                public void engineDeleteEntry(String s) {
                    throw new KeyStoreException("Not supported");
                }

                @Override
                public Certificate engineGetCertificate(String s) {
                    return this.engineContainsAlias(s) ? this.val$certificateChain[0] : null;
                }

                @Override
                public String engineGetCertificateAlias(Certificate certificate0) {
                    if(certificate0 instanceof X509Certificate) {
                        X509Certificate[] arr_x509Certificate = this.val$certificateChain;
                        for(int v = 0; v < arr_x509Certificate.length; ++v) {
                            if(arr_x509Certificate[v].equals(certificate0)) {
                                return "key";
                            }
                        }
                    }
                    return null;
                }

                @Override
                public Certificate[] engineGetCertificateChain(String s) {
                    return this.engineContainsAlias(s) ? ((X509Certificate[])this.val$certificateChain.clone()) : null;
                }

                // 去混淆评级： 低(20)
                @Override
                public Date engineGetCreationDate(String s) {
                    return this.engineContainsAlias(s) ? this.creationDate : null;
                }

                @Override
                public Key engineGetKey(String s, char[] arr_c) {
                    String s1 = null;
                    if(this.engineContainsAlias(s)) {
                        if(arr_x509Certificate) {
                            return new OpenSslPrivateKey(0L);
                        }
                        try {
                            if(arr_c != null) {
                                s1 = new String(arr_c);
                            }
                            return new OpenSslPrivateKey(SSL.loadPrivateKeyFromEngine(s, s1));
                        }
                        catch(Exception exception0) {
                            UnrecoverableKeyException unrecoverableKeyException0 = new UnrecoverableKeyException("Unable to load key from engine");
                            unrecoverableKeyException0.initCause(exception0);
                            throw unrecoverableKeyException0;
                        }
                    }
                    return null;
                }

                @Override
                public boolean engineIsCertificateEntry(String s) {
                    return this.engineContainsAlias(s);
                }

                @Override
                public boolean engineIsKeyEntry(String s) {
                    return this.engineContainsAlias(s);
                }

                @Override
                public void engineLoad(InputStream inputStream0, char[] arr_c) {
                    if(inputStream0 != null && arr_c != null) {
                        throw new UnsupportedOperationException();
                    }
                }

                @Override
                public void engineSetCertificateEntry(String s, Certificate certificate0) {
                    throw new KeyStoreException("Not supported");
                }

                @Override
                public void engineSetKeyEntry(String s, Key key0, char[] arr_c, Certificate[] arr_certificate) {
                    throw new KeyStoreException("Not supported");
                }

                @Override
                public void engineSetKeyEntry(String s, byte[] arr_b, Certificate[] arr_certificate) {
                    throw new KeyStoreException("Not supported");
                }

                @Override
                public int engineSize() {
                    return 1;
                }

                @Override
                public void engineStore(OutputStream outputStream0, char[] arr_c) {
                    throw new UnsupportedOperationException();
                }
            }, null, "native");
            OpenSsl.ensureAvailability();
        }

        public OpenSslKeyStore(X509Certificate[] arr_x509Certificate, boolean z, io.netty.handler.ssl.OpenSslX509KeyManagerFactory.1 openSslX509KeyManagerFactory$10) {
            this(arr_x509Certificate, z);
        }
    }

    private final OpenSslKeyManagerFactorySpi spi;

    public OpenSslX509KeyManagerFactory() {
        this(OpenSslX509KeyManagerFactory.newOpenSslKeyManagerFactorySpi(null));
    }

    private OpenSslX509KeyManagerFactory(OpenSslKeyManagerFactorySpi openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi0) {
        super(openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi0, openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi0.kmf.getProvider(), openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi0.kmf.getAlgorithm());
        this.spi = openSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi0;
    }

    public OpenSslX509KeyManagerFactory(String s, Provider provider0) {
        this(OpenSslX509KeyManagerFactory.newOpenSslKeyManagerFactorySpi(s, provider0));
    }

    public OpenSslX509KeyManagerFactory(Provider provider0) {
        this(OpenSslX509KeyManagerFactory.newOpenSslKeyManagerFactorySpi(provider0));
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(File file0, String s) {
        return OpenSslX509KeyManagerFactory.newEngineBased(SslContext.toX509Certificates(file0), s);
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(X509Certificate[] arr_x509Certificate, String s) {
        ObjectUtil.checkNotNull(arr_x509Certificate, "certificateChain");
        char[] arr_c = null;
        OpenSslKeyStore openSslX509KeyManagerFactory$OpenSslKeyStore0 = new OpenSslKeyStore(((X509Certificate[])arr_x509Certificate.clone()), false, null);
        openSslX509KeyManagerFactory$OpenSslKeyStore0.load(null, null);
        OpenSslX509KeyManagerFactory openSslX509KeyManagerFactory0 = new OpenSslX509KeyManagerFactory();
        if(s != null) {
            arr_c = s.toCharArray();
        }
        openSslX509KeyManagerFactory0.init(openSslX509KeyManagerFactory$OpenSslKeyStore0, arr_c);
        return openSslX509KeyManagerFactory0;
    }

    public static OpenSslX509KeyManagerFactory newKeyless(File file0) {
        return OpenSslX509KeyManagerFactory.newKeyless(SslContext.toX509Certificates(file0));
    }

    public static OpenSslX509KeyManagerFactory newKeyless(InputStream inputStream0) {
        return OpenSslX509KeyManagerFactory.newKeyless(SslContext.toX509Certificates(inputStream0));
    }

    public static OpenSslX509KeyManagerFactory newKeyless(X509Certificate[] arr_x509Certificate) {
        ObjectUtil.checkNotNull(arr_x509Certificate, "certificateChain");
        OpenSslKeyStore openSslX509KeyManagerFactory$OpenSslKeyStore0 = new OpenSslKeyStore(((X509Certificate[])arr_x509Certificate.clone()), true, null);
        openSslX509KeyManagerFactory$OpenSslKeyStore0.load(null, null);
        OpenSslX509KeyManagerFactory openSslX509KeyManagerFactory0 = new OpenSslX509KeyManagerFactory();
        openSslX509KeyManagerFactory0.init(openSslX509KeyManagerFactory$OpenSslKeyStore0, null);
        return openSslX509KeyManagerFactory0;
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(String s, Provider provider0) {
        if(s == null) {
            s = "SunX509";
        }
        return provider0 == null ? new OpenSslKeyManagerFactorySpi(KeyManagerFactory.getInstance(s)) : new OpenSslKeyManagerFactorySpi(KeyManagerFactory.getInstance(s, provider0));
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(Provider provider0) {
        try {
            return OpenSslX509KeyManagerFactory.newOpenSslKeyManagerFactorySpi(null, provider0);
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            throw new IllegalStateException(noSuchAlgorithmException0);
        }
    }

    public OpenSslKeyMaterialProvider newProvider() {
        return this.spi.newProvider();
    }

    class io.netty.handler.ssl.OpenSslX509KeyManagerFactory.1 {
    }

}

