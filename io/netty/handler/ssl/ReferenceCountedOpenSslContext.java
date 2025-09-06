package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod;
import io.netty.internal.tcnative.CertificateCompressionAlgo;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.ResultCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException.BasicReason;
import java.security.cert.CertPathValidatorException.Reason;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import jeb.synthetic.FIN;

public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        public AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap0) {
            this.engineMap = openSslEngineMap0;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static int translateToError(Throwable throwable0) {
            if(throwable0 instanceof CertificateRevokedException) {
                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
            }
            for(Throwable throwable1 = throwable0.getCause(); throwable1 != null; throwable1 = throwable1.getCause()) {
                if(throwable1 instanceof CertPathValidatorException) {
                    CertPathValidatorException.Reason certPathValidatorException$Reason0 = ((CertPathValidatorException)throwable1).getReason();
                    if(certPathValidatorException$Reason0 == CertPathValidatorException.BasicReason.EXPIRED) {
                        return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                    }
                    if(certPathValidatorException$Reason0 == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
                        return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                    }
                    if(certPathValidatorException$Reason0 == CertPathValidatorException.BasicReason.REVOKED) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                }
            }
            return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
        }

        public final int verify(long v, byte[][] arr2_b, String s) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = this.engineMap.get(v);
            if(referenceCountedOpenSslEngine0 == null) {
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
            X509Certificate[] arr_x509Certificate = ReferenceCountedOpenSslContext.certificates(arr2_b);
            try {
                this.verify(referenceCountedOpenSslEngine0, arr_x509Certificate, s);
                return CertificateVerifier.X509_V_OK;
            }
            catch(Throwable throwable0) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", throwable0);
                referenceCountedOpenSslEngine0.initHandshakeException(throwable0);
                if(throwable0 instanceof OpenSslCertificateException) {
                    return ((OpenSslCertificateException)throwable0).errorCode();
                }
                if(throwable0 instanceof CertificateExpiredException) {
                    return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                }
                return throwable0 instanceof CertificateNotYetValidException ? CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID : CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        public abstract void verify(ReferenceCountedOpenSslEngine arg1, X509Certificate[] arg2, String arg3);
    }

    static final class AsyncPrivateKeyMethod implements AsyncSSLPrivateKeyMethod {
        static final class ResultCallbackListener implements FutureListener {
            private final ReferenceCountedOpenSslEngine engine;
            private final ResultCallback resultCallback;
            private final long ssl;

            public ResultCallbackListener(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, long v, ResultCallback resultCallback0) {
                this.engine = referenceCountedOpenSslEngine0;
                this.ssl = v;
                this.resultCallback = resultCallback0;
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                Throwable throwable0 = future0.cause();
                if(throwable0 == null) {
                    try {
                        byte[] arr_b = ReferenceCountedOpenSslContext.verifyResult(((byte[])future0.getNow()));
                        this.resultCallback.onSuccess(this.ssl, arr_b);
                        return;
                    }
                    catch(SignatureException signatureException0) {
                        throwable0 = signatureException0;
                        this.engine.initHandshakeException(throwable0);
                    }
                }
                this.resultCallback.onError(this.ssl, throwable0);
            }
        }

        private final OpenSslEngineMap engineMap;
        private final OpenSslAsyncPrivateKeyMethod keyMethod;

        public AsyncPrivateKeyMethod(OpenSslEngineMap openSslEngineMap0, OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod0) {
            this.engineMap = openSslEngineMap0;
            this.keyMethod = openSslAsyncPrivateKeyMethod0;
        }

        public void decrypt(long v, byte[] arr_b, ResultCallback resultCallback0) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
                this.keyMethod.decrypt(referenceCountedOpenSslEngine0, arr_b).addListener(new ResultCallbackListener(referenceCountedOpenSslEngine0, v, resultCallback0));
            }
            catch(SSLException sSLException0) {
                resultCallback0.onError(v, sSLException0);
            }
        }

        public void sign(long v, int v1, byte[] arr_b, ResultCallback resultCallback0) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
                this.keyMethod.sign(referenceCountedOpenSslEngine0, v1, arr_b).addListener(new ResultCallbackListener(referenceCountedOpenSslEngine0, v, resultCallback0));
            }
            catch(SSLException sSLException0) {
                resultCallback0.onError(v, sSLException0);
            }
        }
    }

    static final class CompressionAlgorithm implements CertificateCompressionAlgo {
        private final OpenSslCertificateCompressionAlgorithm compressionAlgorithm;
        private final OpenSslEngineMap engineMap;

        public CompressionAlgorithm(OpenSslEngineMap openSslEngineMap0, OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm0) {
            this.engineMap = openSslEngineMap0;
            this.compressionAlgorithm = openSslCertificateCompressionAlgorithm0;
        }

        public int algorithmId() {
            return this.compressionAlgorithm.algorithmId();
        }

        public byte[] compress(long v, byte[] arr_b) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
            return this.compressionAlgorithm.compress(referenceCountedOpenSslEngine0, arr_b);
        }

        public byte[] decompress(long v, int v1, byte[] arr_b) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
            return this.compressionAlgorithm.decompress(referenceCountedOpenSslEngine0, v1, arr_b);
        }
    }

    static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        public DefaultOpenSslEngineMap(io.netty.handler.ssl.ReferenceCountedOpenSslContext.1 referenceCountedOpenSslContext$10) {
        }

        @Override  // io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0) {
            Long long0 = referenceCountedOpenSslEngine0.sslPointer();
            this.engines.put(long0, referenceCountedOpenSslEngine0);
        }

        @Override  // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long v) {
            return (ReferenceCountedOpenSslEngine)this.engines.get(v);
        }

        @Override  // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long v) {
            return (ReferenceCountedOpenSslEngine)this.engines.remove(v);
        }
    }

    static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        public PrivateKeyMethod(OpenSslEngineMap openSslEngineMap0, OpenSslPrivateKeyMethod openSslPrivateKeyMethod0) {
            this.engineMap = openSslEngineMap0;
            this.keyMethod = openSslPrivateKeyMethod0;
        }

        public byte[] decrypt(long v, byte[] arr_b) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.decrypt(referenceCountedOpenSslEngine0, arr_b));
            }
            catch(Exception exception0) {
                referenceCountedOpenSslEngine0.initHandshakeException(exception0);
                throw exception0;
            }
        }

        public byte[] sign(long v, int v1, byte[] arr_b) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, v);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.sign(referenceCountedOpenSslEngine0, v1, arr_b));
            }
            catch(Exception exception0) {
                referenceCountedOpenSslEngine0.initHandshakeException(exception0);
                throw exception0;
            }
        }
    }

    static final boolean CLIENT_ENABLE_SESSION_CACHE = false;
    static final boolean CLIENT_ENABLE_SESSION_TICKET = false;
    static final boolean CLIENT_ENABLE_SESSION_TICKET_TLSV13 = false;
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = 0;
    private static final Integer DH_KEY_LENGTH = null;
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = null;
    static final boolean SERVER_ENABLE_SESSION_CACHE = false;
    static final boolean SERVER_ENABLE_SESSION_TICKET = false;
    static final boolean SERVER_ENABLE_SESSION_TICKET_TLSV13 = false;
    static final boolean USE_TASKS = false;
    protected static final int VERIFY_DEPTH = 10;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile int bioNonApplicationBufferSize;
    final ClientAuth clientAuth;
    protected long ctx;
    final ReadWriteLock ctxLock;
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap;
    final Certificate[] keyCertChain;
    private final ResourceLeakTracker leak;
    private static final ResourceLeakDetector leakDetector;
    private static final InternalLogger logger;
    private final int mode;
    final String[] protocols;
    private final AbstractReferenceCounted refCnt;
    final boolean tlsFalseStart;
    private final List unmodifiableCiphers;

    static {
        ReferenceCountedOpenSslContext.logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslContext.class);
        ReferenceCountedOpenSslContext.DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 0x800));
        ReferenceCountedOpenSslContext.USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", true);
        ReferenceCountedOpenSslContext.leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
        ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
        ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", true);
        ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
        ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", true);
        ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheServer", true);
        ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheClient", true);
        ReferenceCountedOpenSslContext.NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() {
            @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public Protocol protocol() {
                return Protocol.NONE;
            }

            @Override  // io.netty.handler.ssl.ApplicationProtocolNegotiator
            public List protocols() {
                return Collections.EMPTY_LIST;
            }

            @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
                return SelectedListenerFailureBehavior.ACCEPT;
            }

            @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public SelectorFailureBehavior selectorFailureBehavior() {
                return SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
            }
        };
        Integer integer0 = null;
        try {
            String s = SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
            if(s != null) {
                try {
                    integer0 = Integer.valueOf(s);
                }
                catch(NumberFormatException unused_ex) {
                    ReferenceCountedOpenSslContext.logger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: " + s);
                }
            }
        }
        catch(Throwable unused_ex) {
        }
        ReferenceCountedOpenSslContext.DH_KEY_LENGTH = integer0;
    }

    public ReferenceCountedOpenSslContext(Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, int v, Certificate[] arr_certificate, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, boolean z2, Map.Entry[] arr_map$Entry) {
        super(z);
        boolean z4;
        Integer integer0;
        OpenSslCertificateCompressionConfig openSslCertificateCompressionConfig0;
        OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod0;
        OpenSslPrivateKeyMethod openSslPrivateKeyMethod0;
        this.refCnt = new AbstractReferenceCounted() {
            static final boolean $assertionsDisabled;

            @Override  // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslContext.this.destroy();
                if(ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.close(ReferenceCountedOpenSslContext.this);
                }
            }

            @Override  // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object object0) {
                if(ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.record(object0);
                }
                return ReferenceCountedOpenSslContext.this;
            }
        };
        this.engineMap = new DefaultOpenSslEngineMap(null);
        this.ctxLock = new ReentrantReadWriteLock();
        this.bioNonApplicationBufferSize = ReferenceCountedOpenSslContext.DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
        OpenSsl.ensureAvailability();
        if(z1) {
            throw new IllegalStateException("OCSP is not supported.");
        }
        if(v != 0 && v != 1) {
            throw new IllegalArgumentException("mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT");
        }
        boolean z3 = ReferenceCountedOpenSslContext.USE_TASKS;
        if(arr_map$Entry == null) {
            z4 = false;
            openSslPrivateKeyMethod0 = null;
            openSslAsyncPrivateKeyMethod0 = null;
            openSslCertificateCompressionConfig0 = null;
            integer0 = null;
        }
        else {
            openSslPrivateKeyMethod0 = null;
            openSslAsyncPrivateKeyMethod0 = null;
            openSslCertificateCompressionConfig0 = null;
            integer0 = null;
            z4 = false;
            for(int v1 = 0; v1 < arr_map$Entry.length; ++v1) {
                Map.Entry map$Entry0 = arr_map$Entry[v1];
                SslContextOption sslContextOption0 = (SslContextOption)map$Entry0.getKey();
                if(sslContextOption0 == OpenSslContextOption.TLS_FALSE_START) {
                    z4 = ((Boolean)map$Entry0.getValue()).booleanValue();
                }
                else if(sslContextOption0 == OpenSslContextOption.USE_TASKS) {
                    z3 = ((Boolean)map$Entry0.getValue()).booleanValue();
                }
                else if(sslContextOption0 == OpenSslContextOption.PRIVATE_KEY_METHOD) {
                    openSslPrivateKeyMethod0 = (OpenSslPrivateKeyMethod)map$Entry0.getValue();
                }
                else if(sslContextOption0 == OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD) {
                    openSslAsyncPrivateKeyMethod0 = (OpenSslAsyncPrivateKeyMethod)map$Entry0.getValue();
                }
                else if(sslContextOption0 == OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS) {
                    openSslCertificateCompressionConfig0 = (OpenSslCertificateCompressionConfig)map$Entry0.getValue();
                }
                else if(sslContextOption0 == OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES) {
                    integer0 = (Integer)map$Entry0.getValue();
                }
                else {
                    ReferenceCountedOpenSslContext.logger.debug("Skipping unsupported SslContextOption: " + map$Entry0.getKey());
                }
            }
        }
        if(openSslPrivateKeyMethod0 != null && openSslAsyncPrivateKeyMethod0 != null) {
            throw new IllegalArgumentException("You can either only use OpenSslAsyncPrivateKeyMethod or OpenSslPrivateKeyMethod");
        }
        this.tlsFalseStart = z4;
        this.leak = z2 ? ReferenceCountedOpenSslContext.leakDetector.track(this) : null;
        this.mode = v;
        this.clientAuth = this.isServer() ? ((ClientAuth)ObjectUtil.checkNotNull(clientAuth0, "clientAuth")) : ClientAuth.NONE;
        this.protocols = arr_s == null ? OpenSsl.defaultProtocols(v == 0) : arr_s;
        this.enableOcsp = false;
        this.keyCertChain = arr_certificate == null ? null : ((Certificate[])arr_certificate.clone());
        String[] arr_s1 = ((CipherSuiteFilter)ObjectUtil.checkNotNull(cipherSuiteFilter0, "cipherFilter")).filterCipherSuites(iterable0, OpenSsl.DEFAULT_CIPHERS, OpenSsl.availableJavaCipherSuites());
        LinkedHashSet linkedHashSet0 = new LinkedHashSet(arr_s1.length);
        Collections.addAll(linkedHashSet0, arr_s1);
        ArrayList arrayList0 = new ArrayList(linkedHashSet0);
        this.unmodifiableCiphers = arrayList0;
        this.apn = (OpenSslApplicationProtocolNegotiator)ObjectUtil.checkNotNull(openSslApplicationProtocolNegotiator0, "apn");
        try {
            try {
                this.ctx = SSLContext.make(30, v);
            }
            catch(Exception exception0) {
                throw new SSLException("failed to create an SSL_CTX", exception0);
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            StringBuilder stringBuilder1 = new StringBuilder();
            try {
                if(arrayList0.isEmpty()) {
                    SSLContext.setCipherSuite(this.ctx, "", false);
                }
                else {
                    CipherSuiteConverter.convertToCipherStrings(arrayList0, stringBuilder0, stringBuilder1, false);
                    SSLContext.setCipherSuite(this.ctx, stringBuilder0.toString(), false);
                }
            }
            catch(SSLException sSLException0) {
                throw sSLException0;
            }
            catch(Exception exception1) {
                throw new SSLException("failed to set cipher suite: " + this.unmodifiableCiphers, exception1);
            }
            int v2 = SSLContext.getOptions(this.ctx) | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_CIPHER_SERVER_PREFERENCE | SSL.SSL_OP_NO_COMPRESSION | SSL.SSL_OP_NO_TICKET;
            if(stringBuilder0.length() == 0) {
                v2 |= SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2;
            }
            SSLContext.setOptions(this.ctx, v2 | SSL.SSL_OP_NO_TLSv1_3);
            SSLContext.setMode(this.ctx, SSLContext.getMode(this.ctx) | SSL.SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER);
            Integer integer1 = ReferenceCountedOpenSslContext.DH_KEY_LENGTH;
            if(integer1 != null) {
                SSLContext.setTmpDHLength(this.ctx, ((int)integer1));
            }
            List list0 = openSslApplicationProtocolNegotiator0.protocols();
            if(!list0.isEmpty()) {
                String[] arr_s2 = (String[])list0.toArray(EmptyArrays.EMPTY_STRINGS);
                int v3 = ReferenceCountedOpenSslContext.opensslSelectorFailureBehavior(openSslApplicationProtocolNegotiator0.selectorFailureBehavior());
                switch(io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[openSslApplicationProtocolNegotiator0.protocol().ordinal()]) {
                    case 1: {
                        SSLContext.setNpnProtos(this.ctx, arr_s2, v3);
                        break;
                    }
                    case 2: {
                        SSLContext.setAlpnProtos(this.ctx, arr_s2, v3);
                        break;
                    }
                    case 3: {
                        SSLContext.setNpnProtos(this.ctx, arr_s2, v3);
                        SSLContext.setAlpnProtos(this.ctx, arr_s2, v3);
                        break;
                    }
                    default: {
                        throw new Error();
                    }
                }
            }
            SSLContext.setUseTasks(this.ctx, z3);
            if(openSslPrivateKeyMethod0 != null) {
                SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod0));
            }
            if(openSslAsyncPrivateKeyMethod0 != null) {
                SSLContext.setPrivateKeyMethod(this.ctx, new AsyncPrivateKeyMethod(this.engineMap, openSslAsyncPrivateKeyMethod0));
            }
            if(openSslCertificateCompressionConfig0 == null) {
                goto label_102;
            }
            Iterator iterator0 = openSslCertificateCompressionConfig0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                label_102:
                    if(integer0 != null) {
                        SSLContext.setMaxCertList(this.ctx, ((int)integer0));
                    }
                    SSLContext.setCurvesList(this.ctx, OpenSsl.NAMED_GROUPS);
                    return;
                }
                Object object0 = iterator0.next();
                OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm0 = ((AlgorithmConfig)object0).algorithm();
                CompressionAlgorithm referenceCountedOpenSslContext$CompressionAlgorithm0 = new CompressionAlgorithm(this.engineMap, openSslCertificateCompressionAlgorithm0);
                switch(io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode[((AlgorithmConfig)object0).mode().ordinal()]) {
                    case 1: {
                        SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_DECOMPRESS, referenceCountedOpenSslContext$CompressionAlgorithm0);
                        break;
                    }
                    case 2: {
                        SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_COMPRESS, referenceCountedOpenSslContext$CompressionAlgorithm0);
                        break;
                    }
                    case 3: {
                        SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_BOTH, referenceCountedOpenSslContext$CompressionAlgorithm0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
        }
        catch(Throwable throwable0) {
        }
        this.release();
        throw throwable0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    public static X509Certificate[] certificates(byte[][] arr2_b) {
        X509Certificate[] arr_x509Certificate = new X509Certificate[arr2_b.length];
        for(int v = 0; v < arr2_b.length; ++v) {
            arr_x509Certificate[v] = new LazyX509Certificate(arr2_b[v]);
        }
        return arr_x509Certificate;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] arr_trustManager) {
        for(int v = 0; v < arr_trustManager.length; ++v) {
            TrustManager trustManager0 = arr_trustManager[v];
            if(trustManager0 instanceof X509TrustManager) {
                if(PlatformDependent.javaVersion() >= 7) {
                    X509TrustManager x509TrustManager0 = OpenSslX509TrustManagerWrapper.wrapIfNeeded(((X509TrustManager)trustManager0));
                    return ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager0) ? new EnhancingX509ExtendedTrustManager(x509TrustManager0) : x509TrustManager0;
                }
                return (X509TrustManager)trustManager0;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    public static X509KeyManager chooseX509KeyManager(KeyManager[] arr_keyManager) {
        for(int v = 0; v < arr_keyManager.length; ++v) {
            KeyManager keyManager0 = arr_keyManager[v];
            if(keyManager0 instanceof X509KeyManager) {
                return (X509KeyManager)keyManager0;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final List cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Deprecated
    public final long context() {
        return this.sslCtxPointer();
    }

    private void destroy() {
        Lock lock0 = this.ctxLock.writeLock();
        lock0.lock();
        try {
            long v1 = this.ctx;
            if(v1 != 0L) {
                if(this.enableOcsp) {
                    SSLContext.disableOcsp(v1);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0L;
                OpenSslSessionContext openSslSessionContext0 = this.sessionContext();
                if(openSslSessionContext0 != null) {
                    openSslSessionContext0.destroy();
                }
            }
        }
        finally {
            lock0.unlock();
        }
    }

    public static void freeBio(long v) {
        if(v != 0L) {
            SSL.freeBIO(v);
        }
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    private static long newBIO(ByteBuf byteBuf0) {
        try {
            long v1 = SSL.newMemBIO();
            int v2 = byteBuf0.readableBytes();
            if(SSL.bioWrite(v1, OpenSsl.memoryAddress(byteBuf0) + ((long)byteBuf0.readerIndex()), v2) == v2) {
                return v1;
            }
            SSL.freeBIO(v1);
        }
        finally {
            byteBuf0.release();
        }
        throw new IllegalStateException("Could not write data to memory BIO");
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0) {
        return this.newEngine(byteBufAllocator0, null, -1);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0, String s, int v) {
        return this.newEngine0(byteBufAllocator0, s, v, true);
    }

    public SSLEngine newEngine0(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator0, s, v, z, true);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        return new SslHandler(this.newEngine0(byteBufAllocator0, s, v, false), z);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z, Executor executor0) {
        return new SslHandler(this.newEngine0(byteBufAllocator0, s, v, false), executor0);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z) {
        return new SslHandler(this.newEngine0(byteBufAllocator0, null, -1, false), z);
    }

    @Override  // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z, Executor executor0) {
        return new SslHandler(this.newEngine0(byteBufAllocator0, null, -1, false), z, executor0);
    }

    private static int opensslSelectorFailureBehavior(SelectorFailureBehavior applicationProtocolConfig$SelectorFailureBehavior0) {
        switch(io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig$SelectorFailureBehavior0.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            default: {
                throw new Error();
            }
        }
    }

    public static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory keyManagerFactory0, String s) {
        if(keyManagerFactory0 instanceof OpenSslX509KeyManagerFactory) {
            return ((OpenSslX509KeyManagerFactory)keyManagerFactory0).newProvider();
        }
        return keyManagerFactory0 instanceof OpenSslCachingX509KeyManagerFactory ? ((OpenSslCachingX509KeyManagerFactory)keyManagerFactory0).newProvider(s) : new OpenSslKeyMaterialProvider(ReferenceCountedOpenSslContext.chooseX509KeyManager(keyManagerFactory0.getKeyManagers()), s);
    }

    @Override  // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release(int v) {
        return this.refCnt.release(v);
    }

    @Override  // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int v) {
        this.refCnt.retain(v);
        return this;
    }

    private static ReferenceCountedOpenSslEngine retrieveEngine(OpenSslEngineMap openSslEngineMap0, long v) {
        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = openSslEngineMap0.get(v);
        if(referenceCountedOpenSslEngine0 == null) {
            throw new SSLException("Could not find a ReferenceCountedOpenSslEngine for sslPointer " + v);
        }
        return referenceCountedOpenSslEngine0;
    }

    public abstract OpenSslSessionContext sessionContext();

    @Override  // io.netty.handler.ssl.SslContext
    public SSLSessionContext sessionContext() {
        return this.sessionContext();
    }

    public void setBioNonApplicationBufferSize(int v) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(v, "bioNonApplicationBufferSize");
    }

    public static void setKeyMaterial(long v, X509Certificate[] arr_x509Certificate, PrivateKey privateKey0, String s) {
        long v4;
        long v3;
        long v2;
        ByteBufAllocator byteBufAllocator0;
        PemEncoded pemEncoded0;
        long v1 = 0L;
        try {
            pemEncoded0 = null;
            byteBufAllocator0 = ByteBufAllocator.DEFAULT;
            pemEncoded0 = PemX509Certificate.toPEM(byteBufAllocator0, true, arr_x509Certificate);
            v2 = 0L;
            v2 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, pemEncoded0.retain());
        }
        catch(SSLException sSLException0) {
            v2 = 0L;
            v3 = 0L;
            throw sSLException0;
        }
        catch(Exception exception0) {
            v2 = 0L;
            v3 = 0L;
            throw new SSLException("failed to set certificate and key", exception0);
        }
        catch(Throwable throwable0) {
            v3 = 0L;
            goto label_42;
        }
        try {
            v3 = 0L;
            v3 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, pemEncoded0.retain());
            if(privateKey0 != null) {
                v1 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, privateKey0);
            }
            v4 = v1;
            goto label_28;
        }
        catch(SSLException sSLException0) {
            throw sSLException0;
        }
        catch(Exception exception0) {
            throw new SSLException("failed to set certificate and key", exception0);
            try {
            label_28:
                SSLContext.setCertificateBio(v, v2, v4, (s == null ? "" : s));
                SSLContext.setCertificateChainBio(v, v3, true);
                goto label_48;
            }
            catch(SSLException sSLException0) {
                v1 = v4;
            }
            catch(Exception exception0) {
                v1 = v4;
                throw new SSLException("failed to set certificate and key", exception0);
            }
            catch(Throwable throwable0) {
                v1 = v4;
                goto label_42;
            }
            try {
                throw sSLException0;
            }
            catch(Throwable throwable0) {
            }
        }
        catch(Throwable throwable0) {
        }
    label_42:
        ReferenceCountedOpenSslContext.freeBio(v1);
        ReferenceCountedOpenSslContext.freeBio(v2);
        ReferenceCountedOpenSslContext.freeBio(v3);
        if(pemEncoded0 != null) {
            pemEncoded0.release();
        }
        throw throwable0;
    label_48:
        ReferenceCountedOpenSslContext.freeBio(v4);
        ReferenceCountedOpenSslContext.freeBio(v2);
        ReferenceCountedOpenSslContext.freeBio(v3);
        pemEncoded0.release();
    }

    @Deprecated
    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod openSslPrivateKeyMethod0) {
        ObjectUtil.checkNotNull(openSslPrivateKeyMethod0, "method");
        Lock lock0 = this.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod0));
        }
        finally {
            lock0.unlock();
        }
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean z) {
        if(!z) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public final void setTicketKeys(byte[] arr_b) {
        this.sessionContext().setTicketKeys(arr_b);
    }

    @Deprecated
    public final void setUseTasks(boolean z) {
        Lock lock0 = this.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.setUseTasks(this.ctx, z);
        }
        finally {
            lock0.unlock();
        }
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock lock0 = this.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.getSslCtx(this.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return this.sessionContext().stats();
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator0, PemEncoded pemEncoded0) {
        int v4;
        long v2;
        try {
            ByteBuf byteBuf0 = pemEncoded0.content();
            if(byteBuf0.isDirect()) {
                return ReferenceCountedOpenSslContext.newBIO(byteBuf0.retainedSlice());
            }
            ByteBuf byteBuf1 = byteBufAllocator0.directBuffer(byteBuf0.readableBytes());
            try {
                byteBuf1.writeBytes(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
                v2 = ReferenceCountedOpenSslContext.newBIO(byteBuf1.retainedSlice());
            }
            catch(Throwable unused_ex) {
                try {
                    if(pemEncoded0.isSensitive()) {
                        SslUtils.zeroout(byteBuf1);
                    }
                }
                finally {
                    byteBuf1.release();
                }
                throw throwable0;
            }
            v4 = FIN.finallyOpen$NT();
            if(pemEncoded0.isSensitive()) {
                SslUtils.zeroout(byteBuf1);
            }
            FIN.finallyCodeBegin$NT(v4);
            byteBuf1.release();
        }
        finally {
            pemEncoded0.release();
        }
        FIN.finallyCodeEnd$NT(v4);
        return v2;
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator0, PrivateKey privateKey0) {
        if(privateKey0 == null) {
            return 0L;
        }
        PemEncoded pemEncoded0 = PemPrivateKey.toPEM(byteBufAllocator0, true, privateKey0);
        try {
            return ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, pemEncoded0.retain());
        }
        finally {
            pemEncoded0.release();
        }
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator0, X509Certificate[] arr_x509Certificate) {
        if(arr_x509Certificate == null) {
            return 0L;
        }
        ObjectUtil.checkNonEmpty(arr_x509Certificate, "certChain");
        PemEncoded pemEncoded0 = PemX509Certificate.toPEM(byteBufAllocator0, true, arr_x509Certificate);
        try {
            return ReferenceCountedOpenSslContext.toBIO(byteBufAllocator0, pemEncoded0.retain());
        }
        finally {
            pemEncoded0.release();
        }
    }

    public static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig0) {
        if(applicationProtocolConfig0 == null) {
            return ReferenceCountedOpenSslContext.NONE_PROTOCOL_NEGOTIATOR;
        }
        int v = io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig0.protocol().ordinal()];
        if(v != 1 && v != 2) {
            switch(v) {
                case 3: {
                    break;
                }
                case 4: {
                    return ReferenceCountedOpenSslContext.NONE_PROTOCOL_NEGOTIATOR;
                }
                default: {
                    throw new Error();
                }
            }
        }
        switch(io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig0.selectedListenerFailureBehavior().ordinal()]) {
            case 1: 
            case 2: {
                switch(io.netty.handler.ssl.ReferenceCountedOpenSslContext.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig0.selectorFailureBehavior().ordinal()]) {
                    case 1: 
                    case 2: {
                        return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig0);
                    }
                    default: {
                        throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig0.selectorFailureBehavior() + " behavior");
                    }
                }
            }
            default: {
                throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig0.selectedListenerFailureBehavior() + " behavior");
            }
        }
    }

    @Override  // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object object0) {
        this.refCnt.touch(object0);
        return this;
    }

    // 去混淆评级： 低(30)
    @SuppressJava6Requirement(reason = "Guarded by java version check")
    public static boolean useExtendedTrustManager(X509TrustManager x509TrustManager0) {
        return false;
    }

    private static byte[] verifyResult(byte[] arr_b) {
        if(arr_b == null) {
            throw new SignatureException();
        }
        return arr_b;
    }
}

