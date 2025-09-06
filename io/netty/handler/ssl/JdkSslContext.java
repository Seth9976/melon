package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

public class JdkSslContext extends SslContext {
    static final class Defaults {
        List defaultCiphers;
        List defaultCiphersNonTLSv13;
        String[] defaultProtocols;
        Provider defaultProvider;
        Set supportedCiphers;
        Set supportedCiphersNonTLSv13;

        private Defaults() {
        }

        public Defaults(io.netty.handler.ssl.JdkSslContext.1 jdkSslContext$10) {
        }

        public void init() {
            SSLContext sSLContext0;
            try {
                sSLContext0 = SSLContext.getInstance("TLS");
                sSLContext0.init(null, null, null);
            }
            catch(Exception exception0) {
                throw new Error("failed to initialize the default SSL context", exception0);
            }
            this.defaultProvider = sSLContext0.getProvider();
            SSLEngine sSLEngine0 = sSLContext0.createSSLEngine();
            this.defaultProtocols = JdkSslContext.defaultProtocols(sSLContext0, sSLEngine0);
            Set set0 = Collections.unmodifiableSet(JdkSslContext.supportedCiphers(sSLEngine0));
            this.supportedCiphers = set0;
            this.defaultCiphers = Collections.unmodifiableList(JdkSslContext.defaultCiphers(sSLEngine0, set0));
            ArrayList arrayList0 = new ArrayList(this.defaultCiphers);
            arrayList0.removeAll(Arrays.asList(SslUtils.DEFAULT_TLSV13_CIPHER_SUITES));
            this.defaultCiphersNonTLSv13 = Collections.unmodifiableList(arrayList0);
            LinkedHashSet linkedHashSet0 = new LinkedHashSet(this.supportedCiphers);
            linkedHashSet0.removeAll(Arrays.asList(SslUtils.DEFAULT_TLSV13_CIPHER_SUITES));
            this.supportedCiphersNonTLSv13 = Collections.unmodifiableSet(linkedHashSet0);
        }
    }

    private static final List DEFAULT_CIPHERS = null;
    private static final List DEFAULT_CIPHERS_NON_TLSV13 = null;
    private static final String[] DEFAULT_PROTOCOLS = null;
    private static final Provider DEFAULT_PROVIDER = null;
    static final String PROTOCOL = "TLS";
    private static final Set SUPPORTED_CIPHERS;
    private static final Set SUPPORTED_CIPHERS_NON_TLSV13;
    private final JdkApplicationProtocolNegotiator apn;
    private final String[] cipherSuites;
    private final ClientAuth clientAuth;
    private final boolean isClient;
    private static final InternalLogger logger;
    private final String[] protocols;
    private final SSLContext sslContext;
    private final List unmodifiableCipherSuites;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(JdkSslContext.class);
        JdkSslContext.logger = internalLogger0;
        Defaults jdkSslContext$Defaults0 = new Defaults(null);
        jdkSslContext$Defaults0.init();
        JdkSslContext.DEFAULT_PROVIDER = jdkSslContext$Defaults0.defaultProvider;
        String[] arr_s = jdkSslContext$Defaults0.defaultProtocols;
        JdkSslContext.DEFAULT_PROTOCOLS = arr_s;
        JdkSslContext.SUPPORTED_CIPHERS = jdkSslContext$Defaults0.supportedCiphers;
        List list0 = jdkSslContext$Defaults0.defaultCiphers;
        JdkSslContext.DEFAULT_CIPHERS = list0;
        JdkSslContext.DEFAULT_CIPHERS_NON_TLSV13 = jdkSslContext$Defaults0.defaultCiphersNonTLSv13;
        JdkSslContext.SUPPORTED_CIPHERS_NON_TLSV13 = jdkSslContext$Defaults0.supportedCiphersNonTLSv13;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("Default protocols (JDK): {} ", Arrays.asList(arr_s));
            internalLogger0.debug("Default cipher suites (JDK): {}", list0);
        }
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext0, boolean z, ClientAuth clientAuth0) {
        this(sSLContext0, z, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, clientAuth0, null, false);
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext0, boolean z, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, ClientAuth clientAuth0) {
        this(sSLContext0, z, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, clientAuth0, null, false);
    }

    public JdkSslContext(SSLContext sSLContext0, boolean z, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, ClientAuth clientAuth0, String[] arr_s, boolean z1) {
        this(sSLContext0, z, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, !z), clientAuth0, (arr_s == null ? null : ((String[])arr_s.clone())), z1);
    }

    public JdkSslContext(SSLContext sSLContext0, boolean z, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, ClientAuth clientAuth0, String[] arr_s, boolean z1) {
        super(z1);
        List list1;
        List list0;
        Set set0;
        this.apn = (JdkApplicationProtocolNegotiator)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0, "apn");
        this.clientAuth = (ClientAuth)ObjectUtil.checkNotNull(clientAuth0, "clientAuth");
        this.sslContext = (SSLContext)ObjectUtil.checkNotNull(sSLContext0, "sslContext");
        Provider provider0 = sSLContext0.getProvider();
        if(JdkSslContext.DEFAULT_PROVIDER.equals(provider0)) {
            if(arr_s == null) {
                arr_s = JdkSslContext.DEFAULT_PROTOCOLS;
            }
            this.protocols = arr_s;
            if(JdkSslContext.isTlsV13Supported(arr_s)) {
                set0 = JdkSslContext.SUPPORTED_CIPHERS;
                list0 = JdkSslContext.DEFAULT_CIPHERS;
            }
            else {
                set0 = JdkSslContext.SUPPORTED_CIPHERS_NON_TLSV13;
                list0 = JdkSslContext.DEFAULT_CIPHERS_NON_TLSV13;
            }
        }
        else {
            SSLEngine sSLEngine0 = sSLContext0.createSSLEngine();
            try {
                this.protocols = arr_s == null ? JdkSslContext.defaultProtocols(sSLContext0, sSLEngine0) : arr_s;
                set0 = JdkSslContext.supportedCiphers(sSLEngine0);
                list1 = JdkSslContext.defaultCiphers(sSLEngine0, set0);
                if(!JdkSslContext.isTlsV13Supported(this.protocols)) {
                    String[] arr_s1 = SslUtils.DEFAULT_TLSV13_CIPHER_SUITES;
                    for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                        String s = arr_s1[v1];
                        set0.remove(s);
                        list1.remove(s);
                    }
                }
            }
            finally {
                ReferenceCountUtil.release(sSLEngine0);
            }
            list0 = list1;
        }
        String[] arr_s2 = ((CipherSuiteFilter)ObjectUtil.checkNotNull(cipherSuiteFilter0, "cipherFilter")).filterCipherSuites(iterable0, list0, set0);
        this.cipherSuites = arr_s2;
        this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(arr_s2));
        this.isClient = z;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.applicationProtocolNegotiator();
    }

    public final JdkApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file0, File file1, String s, KeyManagerFactory keyManagerFactory0) {
        return JdkSslContext.buildKeyManagerFactory(file0, file1, s, keyManagerFactory0, "pkcs12");
    }

    // 去混淆评级： 中等(60)
    public static KeyManagerFactory buildKeyManagerFactory(File file0, File file1, String s, KeyManagerFactory keyManagerFactory0, String s1) {
        return JdkSslContext.buildKeyManagerFactory(file0, "SunX509", file1, s, keyManagerFactory0, s1);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file0, String s, File file1, String s1, KeyManagerFactory keyManagerFactory0) {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file0), s, SslContext.toPrivateKey(file1, s1), s1, keyManagerFactory0, "pkcs12");
    }

    public static KeyManagerFactory buildKeyManagerFactory(File file0, String s, File file1, String s1, KeyManagerFactory keyManagerFactory0, String s2) {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file0), s, SslContext.toPrivateKey(file1, s1), s1, keyManagerFactory0, s2);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final List cipherSuites() {
        return this.unmodifiableCipherSuites;
    }

    private SSLEngine configureAndWrapEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0) {
        sSLEngine0.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine0.setEnabledProtocols(this.protocols);
        sSLEngine0.setUseClientMode(this.isClient());
        if(this.isServer()) {
            switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ClientAuth[this.clientAuth.ordinal()]) {
                case 1: {
                    sSLEngine0.setWantClientAuth(true);
                    break;
                }
                case 2: {
                    sSLEngine0.setNeedClientAuth(true);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new Error("Unknown auth " + this.clientAuth);
                }
            }
        }
        SslEngineWrapperFactory jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0 = this.apn.wrapperFactory();
        if(jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0 instanceof AllocatorAwareSslEngineWrapperFactory) {
            boolean z = this.isServer();
            return ((AllocatorAwareSslEngineWrapperFactory)jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0).wrapSslEngine(sSLEngine0, byteBufAllocator0, this.apn, z);
        }
        boolean z1 = this.isServer();
        return jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0.wrapSslEngine(sSLEngine0, this.apn, z1);
    }

    public final SSLContext context() {
        return this.sslContext;
    }

    private static List defaultCiphers(SSLEngine sSLEngine0, Set set0) {
        List list0 = new ArrayList();
        SslUtils.addIfSupported(set0, list0, SslUtils.DEFAULT_CIPHER_SUITES);
        SslUtils.useFallbackCiphersIfDefaultIsEmpty(list0, sSLEngine0.getEnabledCipherSuites());
        return list0;
    }

    private static String[] defaultProtocols(SSLContext sSLContext0, SSLEngine sSLEngine0) {
        String[] arr_s = sSLContext0.getDefaultSSLParameters().getProtocols();
        HashSet hashSet0 = new HashSet(arr_s.length);
        Collections.addAll(hashSet0, arr_s);
        ArrayList arrayList0 = new ArrayList();
        SslUtils.addIfSupported(hashSet0, arrayList0, new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1"});
        return arrayList0.isEmpty() ? sSLEngine0.getEnabledProtocols() : ((String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS));
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.isClient;
    }

    private static boolean isTlsV13Supported(String[] arr_s) {
        for(int v = 0; v < arr_s.length; ++v) {
            if("TLSv1.3".equals(arr_s[v])) {
                return true;
            }
        }
        return false;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0) {
        return this.configureAndWrapEngine(this.context().createSSLEngine(), byteBufAllocator0);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0, String s, int v) {
        return this.configureAndWrapEngine(this.context().createSSLEngine(s, v), byteBufAllocator0);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return this.isServer() ? this.context().getServerSessionContext() : this.context().getClientSessionContext();
    }

    private static Set supportedCiphers(SSLEngine sSLEngine0) {
        String[] arr_s = sSLEngine0.getSupportedCipherSuites();
        Set set0 = new LinkedHashSet(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            set0.add(s);
            if(s.startsWith("SSL_")) {
                try {
                    String s1 = "TLS_" + s.substring(4);
                    sSLEngine0.setEnabledCipherSuites(new String[]{s1});
                    set0.add(s1);
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
        }
        return set0;
    }

    public static JdkApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig0, boolean z) {
        if(applicationProtocolConfig0 == null) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig0.protocol().ordinal()]) {
            case 1: {
                return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
            }
            case 2: {
                if(z) {
                    switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig0.selectorFailureBehavior().ordinal()]) {
                        case 1: {
                            return new JdkAlpnApplicationProtocolNegotiator(true, applicationProtocolConfig0.supportedProtocols());
                        }
                        case 2: {
                            return new JdkAlpnApplicationProtocolNegotiator(false, applicationProtocolConfig0.supportedProtocols());
                        }
                        default: {
                            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig0.selectorFailureBehavior() + " failure behavior");
                        }
                    }
                }
                switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig0.selectedListenerFailureBehavior().ordinal()]) {
                    case 1: {
                        return new JdkAlpnApplicationProtocolNegotiator(false, applicationProtocolConfig0.supportedProtocols());
                    }
                    case 2: {
                        return new JdkAlpnApplicationProtocolNegotiator(true, applicationProtocolConfig0.supportedProtocols());
                    }
                    default: {
                        throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig0.selectedListenerFailureBehavior() + " failure behavior");
                    }
                }
            }
            case 3: {
                if(z) {
                    switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig0.selectedListenerFailureBehavior().ordinal()]) {
                        case 1: {
                            return new JdkNpnApplicationProtocolNegotiator(false, applicationProtocolConfig0.supportedProtocols());
                        }
                        case 2: {
                            return new JdkNpnApplicationProtocolNegotiator(true, applicationProtocolConfig0.supportedProtocols());
                        }
                        default: {
                            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig0.selectedListenerFailureBehavior() + " failure behavior");
                        }
                    }
                }
                switch(io.netty.handler.ssl.JdkSslContext.1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig0.selectorFailureBehavior().ordinal()]) {
                    case 1: {
                        return new JdkNpnApplicationProtocolNegotiator(true, applicationProtocolConfig0.supportedProtocols());
                    }
                    case 2: {
                        return new JdkNpnApplicationProtocolNegotiator(false, applicationProtocolConfig0.supportedProtocols());
                    }
                    default: {
                        throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig0.selectorFailureBehavior() + " failure behavior");
                    }
                }
            }
            default: {
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig0.protocol() + " protocol");
            }
        }
    }
}

