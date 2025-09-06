package io.netty.handler.ssl;

import U4.x;
import androidx.appcompat.app.o;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncTask;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;
import jeb.synthetic.FIN;

public class ReferenceCountedOpenSslEngine extends SSLEngine implements ApplicationProtocolAccessor, ReferenceCounted {
    final class AsyncTaskDecorator extends TaskDecorator implements AsyncRunnable {
        public AsyncTaskDecorator(AsyncTask asyncTask0) {
            super(((Runnable)asyncTask0));
        }

        @Override  // io.netty.handler.ssl.AsyncRunnable
        public void run(Runnable runnable0) {
            if(ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                return;
            }
            TaskDecorator referenceCountedOpenSslEngine$TaskDecorator0 = new TaskDecorator(ReferenceCountedOpenSslEngine.this, runnable0);
            ((AsyncTask)this.task).runAsync(referenceCountedOpenSslEngine$TaskDecorator0);
        }
    }

    final class DefaultOpenSslSession implements OpenSslSession {
        private volatile int applicationBufferSize;
        private String cipher;
        private volatile long creationTime;
        private OpenSslSessionId id;
        private volatile Certificate[] localCertificateChain;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private boolean valid;
        private Map values;
        private X509Certificate[] x509PeerCerts;

        public DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext0) {
            this.valid = true;
            this.id = OpenSslSessionId.NULL_ID;
            this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
            this.sessionContext = openSslSessionContext0;
        }

        @Override  // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override  // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            String s;
            synchronized(ReferenceCountedOpenSslEngine.this) {
                s = this.cipher;
                if(s == null) {
                    return "SSL_NULL_WITH_NULL_NULL";
                }
            }
            return s;
        }

        @Override  // javax.net.ssl.SSLSession
        public long getCreationTime() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
            }
            return this.creationTime;
        }

        @Override  // javax.net.ssl.SSLSession
        public byte[] getId() {
            return this.sessionId().cloneBytes();
        }

        @Override  // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long v = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return v == -1L ? this.getCreationTime() : v;
        }

        @Override  // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            return this.localCertificateChain == null ? null : ((Certificate[])this.localCertificateChain.clone());
        }

        @Override  // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] arr_certificate = this.localCertificateChain;
            return arr_certificate != null && arr_certificate.length != 0 ? ((java.security.cert.X509Certificate)arr_certificate[0]).getSubjectX500Principal() : null;
        }

        @Override  // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return SSL.SSL_MAX_ENCRYPTED_LENGTH;
        }

        @Override  // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                if(this.x509PeerCerts != ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED) {
                    if(ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    return (X509Certificate[])this.x509PeerCerts.clone();
                }
            }
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                if(!ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                    return (Certificate[])this.peerCerts.clone();
                }
            }
            throw new SSLPeerUnverifiedException("peer not verified");
        }

        @Override  // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override  // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override  // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() {
            return ((java.security.cert.X509Certificate)this.getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override  // javax.net.ssl.SSLSession
        public String getProtocol() {
            String s = this.protocol;
            if(s == null) {
                synchronized(ReferenceCountedOpenSslEngine.this) {
                    return ReferenceCountedOpenSslEngine.this.isDestroyed() ? "" : SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                }
            }
            return s;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override  // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return this.getSessionContext();
        }

        @Override  // javax.net.ssl.SSLSession
        public Object getValue(String s) {
            Map map0;
            ObjectUtil.checkNotNull(s, "name");
            synchronized(this) {
                map0 = this.values;
                if(map0 == null) {
                    return null;
                }
            }
            return map0.get(s);
        }

        @Override  // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized(this) {
                Map map0 = this.values;
                return map0 != null && !map0.isEmpty() ? ((String[])map0.keySet().toArray(EmptyArrays.EMPTY_STRINGS)) : EmptyArrays.EMPTY_STRINGS;
            }
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] arr_b, String s, String s1, byte[] arr_b1, byte[][] arr2_b, long v, long v1) {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                if(!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.creationTime = v;
                    OpenSslSessionId openSslSessionId0 = OpenSslSessionId.NULL_ID;
                    if(this.id == openSslSessionId0) {
                        if(arr_b != null) {
                            openSslSessionId0 = new OpenSslSessionId(arr_b);
                        }
                        this.id = openSslSessionId0;
                    }
                    this.cipher = ReferenceCountedOpenSslEngine.this.toJavaCipherSuite(s);
                    this.protocol = s1;
                    if(!ReferenceCountedOpenSslEngine.this.clientMode) {
                        if(ReferenceCountedOpenSslEngine.isEmpty(arr_b1)) {
                            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                            this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                        }
                        else if(ReferenceCountedOpenSslEngine.isEmpty(arr2_b)) {
                            this.peerCerts = new Certificate[]{new LazyX509Certificate(arr_b1)};
                            this.x509PeerCerts = OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED ? new X509Certificate[]{new LazyJavaxX509Certificate(arr_b1)} : ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                        }
                        else {
                            Certificate[] arr_certificate = new Certificate[arr2_b.length + 1];
                            this.peerCerts = arr_certificate;
                            arr_certificate[0] = new LazyX509Certificate(arr_b1);
                            if(OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED) {
                                X509Certificate[] arr_x509Certificate = new X509Certificate[arr2_b.length + 1];
                                this.x509PeerCerts = arr_x509Certificate;
                                arr_x509Certificate[0] = new LazyJavaxX509Certificate(arr_b1);
                            }
                            else {
                                this.x509PeerCerts = ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                            }
                            this.initCerts(arr2_b, 1);
                        }
                    }
                    else if(ReferenceCountedOpenSslEngine.isEmpty(arr2_b)) {
                        this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                        this.x509PeerCerts = OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED ? EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES : ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                    }
                    else {
                        this.peerCerts = new Certificate[arr2_b.length];
                        this.x509PeerCerts = OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED ? new X509Certificate[arr2_b.length] : ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                        this.initCerts(arr2_b, 0);
                    }
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                    return;
                }
            }
            throw new SSLException("Already closed");
        }

        private void initCerts(byte[][] arr2_b, int v) {
            for(int v1 = 0; v1 < arr2_b.length; ++v1) {
                int v2 = v + v1;
                Certificate[] arr_certificate = this.peerCerts;
                arr_certificate[v2] = new LazyX509Certificate(arr2_b[v1]);
                if(this.x509PeerCerts != ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED) {
                    X509Certificate[] arr_x509Certificate = this.x509PeerCerts;
                    arr_x509Certificate[v2] = new LazyJavaxX509Certificate(arr2_b[v1]);
                }
            }
        }

        @Override  // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                this.valid = false;
                this.sessionContext.removeFromCache(this.id);
            }
        }

        @Override  // javax.net.ssl.SSLSession
        public boolean isValid() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                return this.valid || this.sessionContext.isInCache(this.id);
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String s) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, s);
        }

        private void notifyUnbound(Object object0, String s) {
            if(object0 instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener)object0).valueUnbound(this.newSSLSessionBindingEvent(s));
            }
        }

        @Override  // javax.net.ssl.SSLSession
        public void putValue(String s, Object object0) {
            Object object1;
            ObjectUtil.checkNotNull(s, "name");
            ObjectUtil.checkNotNull(object0, "value");
            synchronized(this) {
                Map map0 = this.values;
                if(map0 == null) {
                    map0 = new HashMap(2);
                    this.values = map0;
                }
                object1 = map0.put(s, object0);
            }
            if(object0 instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener)object0).valueBound(this.newSSLSessionBindingEvent(s));
            }
            this.notifyUnbound(object1, s);
        }

        @Override  // javax.net.ssl.SSLSession
        public void removeValue(String s) {
            Object object0;
            ObjectUtil.checkNotNull(s, "name");
            synchronized(this) {
                Map map0 = this.values;
                if(map0 == null) {
                    return;
                }
                object0 = map0.remove(s);
            }
            this.notifyUnbound(object0, s);
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                if(this.id == OpenSslSessionId.NULL_ID && !ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    byte[] arr_b = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
                    if(arr_b != null) {
                        this.id = new OpenSslSessionId(arr_b);
                    }
                }
                return this.id;
            }
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] arr_certificate) {
            this.localCertificateChain = arr_certificate;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId openSslSessionId0) {
            synchronized(ReferenceCountedOpenSslEngine.this) {
                if(this.id == OpenSslSessionId.NULL_ID) {
                    this.id = openSslSessionId0;
                    this.creationTime = System.currentTimeMillis();
                }
            }
        }

        @Override
        public String toString() {
            return "DefaultOpenSslSession{sessionContext=" + this.sessionContext + ", id=" + this.id + '}';
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int v) {
            if(v > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH) {
                int v1 = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
                if(this.applicationBufferSize != v1) {
                    this.applicationBufferSize = v1;
                }
            }
        }
    }

    static enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED;

    }

    interface NativeSslException {
        int errorCode();
    }

    static final class OpenSslException extends SSLException implements NativeSslException {
        private final int errorCode;

        public OpenSslException(String s, int v) {
            super(s);
            this.errorCode = v;
        }

        @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslEngine$NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    static final class OpenSslHandshakeException extends SSLHandshakeException implements NativeSslException {
        private final int errorCode;

        public OpenSslHandshakeException(String s, int v) {
            super(s);
            this.errorCode = v;
        }

        @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslEngine$NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    class TaskDecorator implements Runnable {
        protected final Runnable task;

        public TaskDecorator(Runnable runnable0) {
            this.task = runnable0;
        }

        @Override
        public void run() {
            ReferenceCountedOpenSslEngine.this.runAndResetNeedTask(this.task);
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = null;
    private static final X509Certificate[] JAVAX_CERTS_NOT_SUPPORTED = null;
    static final int MAX_PLAINTEXT_LENGTH = 0;
    static final int MAX_RECORD_SIZE = 0;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = null;
    private static final SSLEngineResult NEED_UNWRAP_OK = null;
    private static final SSLEngineResult NEED_WRAP_CLOSED = null;
    private static final SSLEngineResult NEED_WRAP_OK = null;
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = null;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile boolean destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private String[] explicitlyEnabledProtocols;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private volatile long lastAccessed;
    private final ResourceLeakTracker leak;
    private static final ResourceLeakDetector leakDetector;
    private static final InternalLogger logger;
    private volatile Collection matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    private final ReferenceCountedOpenSslContext parentContext;
    private Throwable pendingException;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final OpenSslSession session;
    private boolean sessionSet;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List sniHostNames;
    private long ssl;

    static {
        ReferenceCountedOpenSslEngine.logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslEngine.class);
        ReferenceCountedOpenSslEngine.leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
        ReferenceCountedOpenSslEngine.OPENSSL_OP_NO_PROTOCOLS = new int[]{SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
        ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
        ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
        SSLEngineResult.Status sSLEngineResult$Status0 = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0 = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        ReferenceCountedOpenSslEngine.NEED_UNWRAP_OK = new SSLEngineResult(sSLEngineResult$Status0, sSLEngineResult$HandshakeStatus0, 0, 0);
        SSLEngineResult.Status sSLEngineResult$Status1 = SSLEngineResult.Status.CLOSED;
        ReferenceCountedOpenSslEngine.NEED_UNWRAP_CLOSED = new SSLEngineResult(sSLEngineResult$Status1, sSLEngineResult$HandshakeStatus0, 0, 0);
        SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus1 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        ReferenceCountedOpenSslEngine.NEED_WRAP_OK = new SSLEngineResult(sSLEngineResult$Status0, sSLEngineResult$HandshakeStatus1, 0, 0);
        ReferenceCountedOpenSslEngine.NEED_WRAP_CLOSED = new SSLEngineResult(sSLEngineResult$Status1, sSLEngineResult$HandshakeStatus1, 0, 0);
        ReferenceCountedOpenSslEngine.CLOSED_NOT_HANDSHAKING = new SSLEngineResult(sSLEngineResult$Status1, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED = new X509Certificate[0];
    }

    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, ByteBufAllocator byteBufAllocator0, String s, int v, boolean z, boolean z1) {
        super(s, v);
        long v2;
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() {
            static final boolean $assertionsDisabled;

            @Override  // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if(ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
                ReferenceCountedOpenSslEngine.this.parentContext.release();
            }

            @Override  // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object object0) {
                if(ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(object0);
                }
                return ReferenceCountedOpenSslEngine.this;
            }
        };
        ClientAuth clientAuth0 = ClientAuth.NONE;
        this.clientAuth = clientAuth0;
        this.lastAccessed = -1L;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.engineMap = referenceCountedOpenSslContext0.engineMap;
        boolean z2 = referenceCountedOpenSslContext0.enableOcsp;
        this.enableOcsp = z2;
        this.jdkCompatibilityMode = z;
        this.alloc = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator)referenceCountedOpenSslContext0.applicationProtocolNegotiator();
        boolean z3 = referenceCountedOpenSslContext0.isClient();
        this.clientMode = z3;
        this.session = new DefaultOpenSslSession(this, referenceCountedOpenSslContext0.sessionContext());
        if(!referenceCountedOpenSslContext0.sessionContext().useKeyManager()) {
            this.session.setLocalCertificate(referenceCountedOpenSslContext0.keyCertChain);
        }
        Lock lock0 = referenceCountedOpenSslContext0.ctxLock.readLock();
        lock0.lock();
        try {
            v2 = SSL.newSSL(referenceCountedOpenSslContext0.ctx, !referenceCountedOpenSslContext0.isClient());
        }
        finally {
            lock0.unlock();
        }
        synchronized(this) {
            try {
                this.ssl = v2;
                this.networkBIO = SSL.bioNewByteBuffer(v2, referenceCountedOpenSslContext0.getBioNonApplicationBufferSize());
                if(!z3) {
                    clientAuth0 = referenceCountedOpenSslContext0.clientAuth;
                }
                this.setClientAuth(clientAuth0);
                String[] arr_s = referenceCountedOpenSslContext0.protocols;
                if(arr_s == null) {
                    this.explicitlyEnabledProtocols = this.getEnabledProtocols();
                }
                else {
                    this.setEnabledProtocols0(arr_s, true);
                }
                if(z3 && SslUtils.isValidHostNameForSNI(s)) {
                    SSL.setTlsExtHostName(this.ssl, s);
                    this.sniHostNames = Collections.singletonList(s);
                }
                if(z2) {
                    SSL.enableOcsp(this.ssl);
                }
                if(!z) {
                    SSL.setMode(this.ssl, SSL.getMode(this.ssl) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3") && (z3 ? ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 : ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13)) {
                    SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_TICKET);
                }
                this.calculateMaxWrapOverhead();
            }
            catch(Throwable throwable0) {
                this.shutdown();
                PlatformDependent.throwException(throwable0);
            }
        }
        this.parentContext = referenceCountedOpenSslContext0;
        referenceCountedOpenSslContext0.retain();
        this.leak = z1 ? ReferenceCountedOpenSslEngine.leakDetector.track(this) : null;

        class io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2 extends ExtendedOpenSslSession {
            private String[] peerSupportedSignatureAlgorithms;
            private List requestedServerNames;

            public io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2(OpenSslSession openSslSession0) {
            }

            @Override  // io.netty.handler.ssl.ExtendedOpenSslSession
            public String[] getPeerSupportedSignatureAlgorithms() {
                synchronized(ReferenceCountedOpenSslEngine.this) {
                    if(this.peerSupportedSignatureAlgorithms == null) {
                        if(ReferenceCountedOpenSslEngine.access$400(ReferenceCountedOpenSslEngine.this)) {
                            this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                        }
                        else {
                            String[] arr_s = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.access$500(ReferenceCountedOpenSslEngine.this));
                            if(arr_s == null) {
                                this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                            }
                            else {
                                LinkedHashSet linkedHashSet0 = new LinkedHashSet(arr_s.length);
                                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                                    String s = SignatureAlgorithmConverter.toJavaName(arr_s[v1]);
                                    if(s != null) {
                                        linkedHashSet0.add(s);
                                    }
                                }
                                this.peerSupportedSignatureAlgorithms = (String[])linkedHashSet0.toArray(EmptyArrays.EMPTY_STRINGS);
                            }
                        }
                    }
                }
                return (String[])this.peerSupportedSignatureAlgorithms.clone();
            }

            @Override  // io.netty.handler.ssl.ExtendedOpenSslSession
            public List getRequestedServerNames() {
                if(ReferenceCountedOpenSslEngine.access$200(ReferenceCountedOpenSslEngine.this)) {
                    return Java8SslUtils.getSniHostNames(ReferenceCountedOpenSslEngine.access$300(ReferenceCountedOpenSslEngine.this));
                }
                synchronized(ReferenceCountedOpenSslEngine.this) {
                    if(this.requestedServerNames == null) {
                        if(ReferenceCountedOpenSslEngine.access$400(ReferenceCountedOpenSslEngine.this)) {
                            this.requestedServerNames = Collections.EMPTY_LIST;
                        }
                        else if(SSL.getSniHostname(ReferenceCountedOpenSslEngine.access$500(ReferenceCountedOpenSslEngine.this)) == null) {
                            this.requestedServerNames = Collections.EMPTY_LIST;
                        }
                        else {
                            this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.access$500(ReferenceCountedOpenSslEngine.this)).getBytes(CharsetUtil.UTF_8));
                        }
                    }
                    return this.requestedServerNames;
                }
            }

            @Override  // io.netty.handler.ssl.ExtendedOpenSslSession
            public List getStatusResponses() {
                byte[] arr_b = null;
                if(ReferenceCountedOpenSslEngine.access$600(ReferenceCountedOpenSslEngine.this) && ReferenceCountedOpenSslEngine.access$200(ReferenceCountedOpenSslEngine.this)) {
                    synchronized(ReferenceCountedOpenSslEngine.this) {
                        if(!ReferenceCountedOpenSslEngine.access$400(ReferenceCountedOpenSslEngine.this)) {
                            arr_b = SSL.getOcspResponse(ReferenceCountedOpenSslEngine.access$500(ReferenceCountedOpenSslEngine.this));
                        }
                    }
                }
                return arr_b == null ? Collections.EMPTY_LIST : Collections.singletonList(arr_b);
            }
        }

    }

    public static List access$300(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0) {
        return referenceCountedOpenSslEngine0.sniHostNames;
    }

    public static boolean access$600(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0) {
        return referenceCountedOpenSslEngine0.enableOcsp;
    }

    public final String[] authMethods() {
        synchronized(this) {
            return this.isDestroyed() ? EmptyArrays.EMPTY_STRINGS : SSL.authenticationMethods(this.ssl);
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void beginHandshake() {
        synchronized(this) {
            switch(io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()]) {
                case 1: {
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    if(this.handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        this.needTask = true;
                    }
                    this.calculateMaxWrapOverhead();
                    break;
                }
                case 2: {
                    throw new SSLException("renegotiation unsupported");
                }
                case 3: {
                    this.checkEngineClosed();
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    this.calculateMaxWrapOverhead();
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    throw new Error();
                }
            }
        }
    }

    public void bioSetFd(int v) {
        synchronized(this) {
            if(!this.isDestroyed()) {
                SSL.bioSetFd(this.ssl, v);
            }
        }
    }

    // 去混淆评级： 低(40)
    private static long bufferAddress(ByteBuffer byteBuffer0) {
        return PlatformDependent.directBufferAddress(byteBuffer0);
    }

    public final int calculateMaxLengthForWrap(int v, int v1) {
        return (int)Math.min(this.maxWrapBufferSize, ((long)this.maxWrapOverhead) * ((long)v1) + ((long)v));
    }

    private void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? this.maxEncryptedPacketLength0() : this.maxEncryptedPacketLength0() << 4;
    }

    public final int calculateOutNetBufSize(int v, int v1) {
        return (int)Math.min(0x7FFFFFFFL, ((long)this.maxWrapOverhead) * ((long)v1) + ((long)v));
    }

    private void checkEngineClosed() {
        if(this.isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    public final boolean checkSniHostnameMatch(byte[] arr_b) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, arr_b);
    }

    private void closeAll() {
        this.receivedShutdown = true;
        this.closeOutbound();
        this.closeInbound();
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void closeInbound() {
        synchronized(this) {
            if(this.isInboundDone) {
                return;
            }
            this.isInboundDone = true;
            if(this.isOutboundDone()) {
                this.shutdown();
            }
            if(this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
                throw new SSLException("Inbound closed before receiving peer\'s close_notify: possible truncation attack?");
            }
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void closeOutbound() {
        synchronized(this) {
            if(this.outboundClosed) {
                return;
            }
            this.outboundClosed = true;
            if(this.handshakeState == HandshakeState.NOT_STARTED || this.isDestroyed()) {
                this.shutdown();
            }
            else if((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                this.doSSLShutdown();
            }
        }
    }

    private boolean doSSLShutdown() {
        if(SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int v = SSL.shutdownSSL(this.ssl);
        if(v < 0) {
            int v1 = SSL.getError(this.ssl, v);
            if(v1 != SSL.SSL_ERROR_SYSCALL && v1 != SSL.SSL_ERROR_SSL) {
                SSL.clearError();
                return true;
            }
            InternalLogger internalLogger0 = ReferenceCountedOpenSslEngine.logger;
            if(internalLogger0.isDebugEnabled()) {
                int v2 = SSL.getLastErrorNumber();
                internalLogger0.debug("SSL_shutdown failed: OpenSSL error: {} {}", v2, SSL.getErrorString(v2));
            }
            this.shutdown();
            return false;
        }
        return true;
    }

    @Override  // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final Runnable getDelegatedTask() {
        synchronized(this) {
            if(this.isDestroyed()) {
                return null;
            }
            Runnable runnable0 = SSL.getTask(this.ssl);
            if(runnable0 == null) {
                return null;
            }
            return runnable0 instanceof AsyncTask ? new AsyncTaskDecorator(this, ((AsyncTask)runnable0)) : () -> {
                int v1;
                synchronized(ReferenceCountedOpenSslEngine.this) {
                    if(ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        ReferenceCountedOpenSslEngine.this.needTask = false;
                        return;
                    }
                    v1 = FIN.finallyOpen$NT();
                    runnable0.run();
                    FIN.finallyCodeBegin$NT(v1);
                    ReferenceCountedOpenSslEngine.this.needTask = false;
                }
                FIN.finallyCodeEnd$NT(v1);
            };
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        String[] arr_s1;
        String[] arr_s;
        synchronized(this) {
            if(!this.isDestroyed()) {
                arr_s = SSL.getCiphers(this.ssl);
                arr_s1 = ReferenceCountedOpenSslEngine.isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3") ? OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS : EmptyArrays.EMPTY_STRINGS;
                goto label_12;
            }
            return EmptyArrays.EMPTY_STRINGS;
        }
    label_12:
        if(arr_s == null) {
            return EmptyArrays.EMPTY_STRINGS;
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet(arr_s.length + arr_s1.length);
        synchronized(this) {
            for(int v = 0; v < arr_s.length; ++v) {
                String s = this.toJavaCipherSuite(arr_s[v]);
                if(s == null) {
                    s = arr_s[v];
                }
                if(!SslUtils.isTLSv13Cipher(s)) {
                    linkedHashSet0.add(s);
                }
            }
            Collections.addAll(linkedHashSet0, arr_s1);
        }
        return (String[])linkedHashSet0.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList0 = new ArrayList(6);
        arrayList0.add("SSLv2Hello");
        synchronized(this) {
            if(!this.isDestroyed()) {
                int v1 = SSL.getOptions(this.ssl);
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_TLSv1, "TLSv1")) {
                    arrayList0.add("TLSv1");
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_TLSv1_1, "TLSv1.1")) {
                    arrayList0.add("TLSv1.1");
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_TLSv1_2, "TLSv1.2")) {
                    arrayList0.add("TLSv1.2");
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3")) {
                    arrayList0.add("TLSv1.3");
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
                    arrayList0.add("SSLv2");
                }
                if(ReferenceCountedOpenSslEngine.isProtocolEnabled(v1, SSL.SSL_OP_NO_SSLv3, "SSLv3")) {
                    arrayList0.add("SSLv3");
                }
                return (String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS);
            }
        }
        return (String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override  // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLSession getHandshakeSession() {
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        switch(io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()]) {
            case 1: 
            case 2: {
                FIN.finallyExec$NT(v);
                return null;
            }
            default: {
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(this);
                FIN.finallyCodeEnd$NT(v);
                return this.session;
            }
        }
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int v) {
        if(this.needPendingStatus()) {
            return this.needTask ? SSLEngineResult.HandshakeStatus.NEED_TASK : ReferenceCountedOpenSslEngine.pendingStatus(v);
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        synchronized(this) {
            if(this.needPendingStatus()) {
                return this.needTask ? SSLEngineResult.HandshakeStatus.NEED_TASK : ReferenceCountedOpenSslEngine.pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
            }
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        if(!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if(!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        }
        synchronized(this) {
            if(this.isDestroyed()) {
                return EmptyArrays.EMPTY_BYTES;
            }
        }
        return SSL.getOcspResponse(this.ssl);
    }

    @Override  // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final SSLParameters getSSLParameters() {
        synchronized(this) {
            return super.getSSLParameters();
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[])OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[])OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    private SSLEngineResult handleUnwrapException(int v, int v1, SSLException sSLException0) {
        int v2 = SSL.getLastErrorNumber();
        if(v2 == 0) {
            throw sSLException0;
        }
        return this.sslReadErrorResult(SSL.SSL_ERROR_SSL, v2, v, v1);
    }

    private SSLEngineResult.HandshakeStatus handshake() {
        if(this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if(this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        this.checkEngineClosed();
        if(this.pendingException != null) {
            if(SSL.doHandshake(this.ssl) <= 0) {
                SSL.clearError();
            }
            return this.handshakeException();
        }
        this.engineMap.add(this);
        if(!this.sessionSet) {
            this.parentContext.sessionContext().setSessionFromCache(this.getPeerHost(), this.getPeerPort(), this.ssl);
            this.sessionSet = true;
        }
        if(this.lastAccessed == -1L) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int v = SSL.doHandshake(this.ssl);
        if(v <= 0) {
            int v1 = SSL.getError(this.ssl, v);
            if(v1 != SSL.SSL_ERROR_WANT_READ && v1 != SSL.SSL_ERROR_WANT_WRITE) {
                if(v1 != SSL.SSL_ERROR_WANT_X509_LOOKUP && v1 != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && v1 != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                    if(this.needWrapAgain(SSL.getLastErrorNumber())) {
                        return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                    }
                    if(this.pendingException == null) {
                        throw this.shutdownWithError("SSL_do_handshake", v1);
                    }
                    return this.handshakeException();
                }
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return ReferenceCountedOpenSslEngine.pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
        if(SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        byte[] arr_b = SSL.getSessionId(this.ssl);
        String s = SSL.getCipherForSSL(this.ssl);
        String s1 = SSL.getVersion(this.ssl);
        byte[] arr_b1 = SSL.getPeerCertificate(this.ssl);
        byte[][] arr2_b = SSL.getPeerCertChain(this.ssl);
        long v2 = SSL.getTime(this.ssl);
        long v3 = this.parentContext.sessionTimeout();
        this.session.handshakeFinished(arr_b, s, s1, arr_b1, arr2_b, v2 * 1000L, 1000L * v3);
        this.selectApplicationProtocol();
        return SSLEngineResult.HandshakeStatus.FINISHED;
    }

    private SSLEngineResult.HandshakeStatus handshakeException() {
        if(SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable throwable0 = this.pendingException;
        this.pendingException = null;
        this.shutdown();
        if(throwable0 instanceof SSLHandshakeException) {
            throw (SSLHandshakeException)throwable0;
        }
        SSLHandshakeException sSLHandshakeException0 = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException0.initCause(throwable0);
        throw sSLHandshakeException0;
    }

    public final void initHandshakeException(Throwable throwable0) {
        Throwable throwable1 = this.pendingException;
        if(throwable1 == null) {
            this.pendingException = throwable0;
            return;
        }
        ThrowableUtil.addSuppressed(throwable1, throwable0);
    }

    private boolean isBytesAvailableEnoughForWrap(int v, int v1, int v2) {
        return ((long)v) - ((long)this.maxWrapOverhead) * ((long)v2) >= ((long)v1);
    }

    private boolean isDestroyed() {
        return this.destroyed;
    }

    private static boolean isEmpty(byte[] arr_b) {
        return arr_b == null || arr_b.length == 0;
    }

    private static boolean isEmpty(Object[] arr_object) {
        return arr_object == null || arr_object.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String s) {
        return s != null && !s.isEmpty();
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean isInboundDone() {
        synchronized(this) {
        }
        return this.isInboundDone;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final boolean isOutboundDone() {
        synchronized(this) {
            return this.outboundClosed && (this.networkBIO == 0L || SSL.bioLengthNonApplication(this.networkBIO) == 0);
        }
    }

    private static boolean isProtocolEnabled(int v, int v1, String s) {
        return (v & v1) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(s);
    }

    public boolean isSessionReused() {
        synchronized(this) {
            return this.isDestroyed() ? false : SSL.isSessionReused(this.ssl);
        }
    }

    public final SecretKeySpec masterKey() {
        synchronized(this) {
            return this.isDestroyed() ? null : new SecretKeySpec(SSL.getMasterKey(this.ssl), "AES");
        }
    }

    public final int maxEncryptedPacketLength() {
        synchronized(this) {
        }
        return this.maxEncryptedPacketLength0();
    }

    public final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
    }

    public final int maxWrapOverhead() {
        synchronized(this) {
        }
        return this.maxWrapOverhead;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0) {
        if(sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            if(this.handshakeState != HandshakeState.FINISHED) {
                return this.handshake();
            }
            return this.isDestroyed() || SSL.bioLengthNonApplication(this.networkBIO) <= 0 ? sSLEngineResult$HandshakeStatus0 : SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        return sSLEngineResult$HandshakeStatus0;
    }

    // 去混淆评级： 低(20)
    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0, int v, int v1) {
        return (sSLEngineResult$HandshakeStatus0 != SSLEngineResult.HandshakeStatus.NEED_UNWRAP || v1 <= 0) && (sSLEngineResult$HandshakeStatus0 != SSLEngineResult.HandshakeStatus.NEED_WRAP || v <= 0) ? this.mayFinishHandshake((sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.FINISHED ? SSLEngineResult.HandshakeStatus.FINISHED : this.getHandshakeStatus())) : this.handshake();
    }

    // 去混淆评级： 低(30)
    private boolean needPendingStatus() {
        return this.handshakeState != HandshakeState.NOT_STARTED && !this.isDestroyed() && (this.handshakeState != HandshakeState.FINISHED || this.isInboundDone() || this.isOutboundDone());
    }

    private boolean needWrapAgain(int v) {
        if(SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            Throwable throwable0 = this.pendingException;
            if(throwable0 == null) {
                this.pendingException = this.newSSLExceptionForError(v);
            }
            else if(ReferenceCountedOpenSslEngine.shouldAddSuppressed(throwable0, v)) {
                ThrowableUtil.addSuppressed(this.pendingException, this.newSSLExceptionForError(v));
            }
            SSL.clearError();
            return true;
        }
        return false;
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0, int v, int v1) {
        return this.newResult(SSLEngineResult.Status.OK, sSLEngineResult$HandshakeStatus0, v, v1);
    }

    private SSLEngineResult newResult(SSLEngineResult.Status sSLEngineResult$Status0, SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0, int v, int v1) {
        if(this.isOutboundDone()) {
            if(this.isInboundDone()) {
                sSLEngineResult$HandshakeStatus0 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                this.shutdown();
            }
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, sSLEngineResult$HandshakeStatus0, v, v1);
        }
        if(sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.needTask = true;
        }
        return new SSLEngineResult(sSLEngineResult$Status0, sSLEngineResult$HandshakeStatus0, v, v1);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0, int v, int v1) {
        return this.newResult(this.mayFinishHandshake(sSLEngineResult$HandshakeStatus0, v, v1), v, v1);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status sSLEngineResult$Status0, SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0, int v, int v1) {
        return this.newResult(sSLEngineResult$Status0, this.mayFinishHandshake(sSLEngineResult$HandshakeStatus0, v, v1), v, v1);
    }

    private SSLException newSSLExceptionForError(int v) {
        String s = SSL.getErrorString(v);
        return this.handshakeState == HandshakeState.FINISHED ? new OpenSslException(s, v) : new OpenSslHandshakeException(s, v);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int v) {
        return v <= 0 ? SSLEngineResult.HandshakeStatus.NEED_UNWRAP : SSLEngineResult.HandshakeStatus.NEED_WRAP;
    }

    private int readPlaintextData(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        if(byteBuffer0.isDirect()) {
            int v1 = SSL.readFromSSL(this.ssl, ReferenceCountedOpenSslEngine.bufferAddress(byteBuffer0) + ((long)v), byteBuffer0.limit() - v);
            if(v1 > 0) {
                byteBuffer0.position(v + v1);
            }
            return v1;
        }
        int v2 = byteBuffer0.limit();
        int v3 = Math.min(this.maxEncryptedPacketLength0(), v2 - v);
        ByteBuf byteBuf0 = this.alloc.directBuffer(v3);
        try {
            int v5 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(byteBuf0), v3);
            if(v5 > 0) {
                byteBuffer0.limit(v + v5);
                byteBuf0.getBytes(byteBuf0.readerIndex(), byteBuffer0);
                byteBuffer0.limit(v2);
            }
            return v5;
        }
        finally {
            byteBuf0.release();
        }
    }

    @Override  // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    private void rejectRemoteInitiatedRenegotiation() {
        if(!this.isDestroyed() && (!this.clientMode && SSL.getHandshakeCount(this.ssl) > 1 || this.clientMode && SSL.getHandshakeCount(this.ssl) > 2) && !"TLSv1.3".equals(this.session.getProtocol()) && this.handshakeState == HandshakeState.FINISHED) {
            this.shutdown();
            throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
        }
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override  // io.netty.util.ReferenceCounted
    public final boolean release(int v) {
        return this.refCnt.release(v);
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
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

    // 检测为 Lambda 实现
    private void runAndResetNeedTask(Runnable runnable0) [...]

    private String selectApplicationProtocol(List list0, SelectedListenerFailureBehavior applicationProtocolConfig$SelectedListenerFailureBehavior0, String s) {
        if(applicationProtocolConfig$SelectedListenerFailureBehavior0 != SelectedListenerFailureBehavior.ACCEPT) {
            int v = list0.size();
            if(!list0.contains(s)) {
                if(applicationProtocolConfig$SelectedListenerFailureBehavior0 != SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                    throw new SSLException("unknown protocol " + s);
                }
                return (String)list0.get(v - 1);
            }
        }
        return s;
    }

    private void selectApplicationProtocol() {
        SelectedListenerFailureBehavior applicationProtocolConfig$SelectedListenerFailureBehavior0 = this.apn.selectedListenerFailureBehavior();
        List list0 = this.apn.protocols();
        switch(io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[this.apn.protocol().ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                String s = SSL.getAlpnSelected(this.ssl);
                if(s != null) {
                    this.applicationProtocol = this.selectApplicationProtocol(list0, applicationProtocolConfig$SelectedListenerFailureBehavior0, s);
                    return;
                }
                break;
            }
            case 3: {
                String s1 = SSL.getNextProtoNegotiated(this.ssl);
                if(s1 != null) {
                    this.applicationProtocol = this.selectApplicationProtocol(list0, applicationProtocolConfig$SelectedListenerFailureBehavior0, s1);
                    return;
                }
                break;
            }
            case 4: {
                String s2 = SSL.getAlpnSelected(this.ssl);
                if(s2 == null) {
                    s2 = SSL.getNextProtoNegotiated(this.ssl);
                }
                if(s2 != null) {
                    this.applicationProtocol = this.selectApplicationProtocol(list0, applicationProtocolConfig$SelectedListenerFailureBehavior0, s2);
                    return;
                }
                break;
            }
            default: {
                throw new Error();
            }
        }
    }

    private void setClientAuth(ClientAuth clientAuth0) {
        if(this.clientMode) {
            return;
        }
        synchronized(this) {
            if(this.clientAuth == clientAuth0) {
                return;
            }
            if(!this.isDestroyed()) {
                switch(io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth0.ordinal()]) {
                    case 1: {
                        SSL.setVerify(this.ssl, 0, 10);
                        break;
                    }
                    case 2: {
                        SSL.setVerify(this.ssl, 2, 10);
                        break;
                    }
                    case 3: {
                        SSL.setVerify(this.ssl, 1, 10);
                        break;
                    }
                    default: {
                        throw new Error(clientAuth0.toString());
                    }
                }
            }
            this.clientAuth = clientAuth0;
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z) {
        if(z) {
            throw new UnsupportedOperationException();
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] arr_s) {
        ObjectUtil.checkNotNull(arr_s, "cipherSuites");
        StringBuilder stringBuilder0 = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(arr_s), stringBuilder0, stringBuilder1, false);
        String s = stringBuilder0.toString();
        String s1 = stringBuilder1.toString();
        if(!s1.isEmpty()) {
            throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
        }
        synchronized(this) {
            if(!this.isDestroyed()) {
                try {
                    SSL.setCipherSuites(this.ssl, s, false);
                    HashSet hashSet0 = new HashSet(this.explicitlyEnabledProtocols.length);
                    Collections.addAll(hashSet0, this.explicitlyEnabledProtocols);
                    if(s.isEmpty()) {
                        hashSet0.remove("TLSv1");
                        hashSet0.remove("TLSv1.1");
                        hashSet0.remove("TLSv1.2");
                        hashSet0.remove("SSLv3");
                        hashSet0.remove("SSLv2");
                        hashSet0.remove("SSLv2Hello");
                    }
                    if(s1.isEmpty()) {
                        hashSet0.remove("TLSv1.3");
                    }
                    this.setEnabledProtocols0(((String[])hashSet0.toArray(EmptyArrays.EMPTY_STRINGS)), false);
                }
                catch(Exception exception0) {
                    throw new IllegalStateException("failed to enable cipher suites: " + s, exception0);
                }
                return;
            }
        }
        throw new IllegalStateException("failed to enable cipher suites: " + s);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] arr_s) {
        this.setEnabledProtocols0(arr_s, true);
    }

    private void setEnabledProtocols0(String[] arr_s, boolean z) {
        ObjectUtil.checkNotNullWithIAE(arr_s, "protocols");
        int v = ReferenceCountedOpenSslEngine.OPENSSL_OP_NO_PROTOCOLS.length;
        int v3 = 0;
        for(int v2 = 0; v2 < arr_s.length; ++v2) {
            String s = arr_s[v2];
            if(!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(s)) {
                throw new IllegalArgumentException("Protocol " + s + " is not supported.");
            }
            if(!s.equals("SSLv2")) {
                if(s.equals("SSLv3")) {
                    if(v > 1) {
                        v = 1;
                    }
                    if(v3 < 1) {
                        v3 = 1;
                    }
                }
                else if(s.equals("TLSv1")) {
                    if(v > 2) {
                        v = 2;
                    }
                    if(v3 < 2) {
                        v3 = 2;
                    }
                }
                else if(s.equals("TLSv1.1")) {
                    if(v > 3) {
                        v = 3;
                    }
                    if(v3 < 3) {
                        v3 = 2;
                    }
                }
                else if(s.equals("TLSv1.2")) {
                    if(v > 4) {
                        v = 4;
                    }
                    if(v3 < 4) {
                        v3 = 4;
                    }
                }
                else if(s.equals("TLSv1.3")) {
                    if(v > 5) {
                        v = 5;
                    }
                    v3 = 4;
                }
            }
            else if(v > 0) {
                v = 0;
            }
        }
        synchronized(this) {
            if(z) {
                this.explicitlyEnabledProtocols = arr_s;
            }
            if(!this.isDestroyed()) {
                SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                int v5 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    v5 |= ReferenceCountedOpenSslEngine.OPENSSL_OP_NO_PROTOCOLS[v1];
                }
                for(int v6 = v3 + 1; true; ++v6) {
                    int[] arr_v = ReferenceCountedOpenSslEngine.OPENSSL_OP_NO_PROTOCOLS;
                    if(v6 >= arr_v.length) {
                        break;
                    }
                    v5 |= arr_v[v6];
                }
                SSL.setOptions(this.ssl, v5);
                return;
            }
        }
        throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(arr_s));
    }

    public final boolean setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial0) {
        synchronized(this) {
            if(!this.isDestroyed()) {
                SSL.setKeyMaterial(this.ssl, openSslKeyMaterial0.certificateChainAddress(), openSslKeyMaterial0.privateKeyAddress());
                goto label_7;
            }
            return false;
        }
    label_7:
        java.security.cert.X509Certificate[] arr_x509Certificate = openSslKeyMaterial0.certificateChain();
        this.session.setLocalCertificate(arr_x509Certificate);
        return true;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z) {
        this.setClientAuth((z ? ClientAuth.REQUIRE : ClientAuth.NONE));
    }

    public void setOcspResponse(byte[] arr_b) {
        if(!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if(this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        }
        synchronized(this) {
            if(!this.isDestroyed()) {
                SSL.setOcspResponse(this.ssl, arr_b);
            }
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final void setSSLParameters(SSLParameters sSLParameters0) {
        synchronized(this) {
            super.setSSLParameters(sSLParameters0);
        }
    }

    public final void setSessionId(OpenSslSessionId openSslSessionId0) {
        this.session.setSessionId(openSslSessionId0);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z) {
        if(z != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setVerify(int v, int v1) {
        synchronized(this) {
            if(!this.isDestroyed()) {
                SSL.setVerify(this.ssl, v, v1);
            }
        }
    }

    @Override  // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z) {
        this.setClientAuth((z ? ClientAuth.OPTIONAL : ClientAuth.NONE));
    }

    private static boolean shouldAddSuppressed(Throwable throwable0, int v) {
        Throwable[] arr_throwable = ThrowableUtil.getSuppressed(throwable0);
        for(int v1 = 0; v1 < arr_throwable.length; ++v1) {
            Throwable throwable1 = arr_throwable[v1];
            if(throwable1 instanceof NativeSslException && ((NativeSslException)throwable1).errorCode() == v) {
                return false;
            }
        }
        return true;
    }

    public final void shutdown() {
        synchronized(this) {
            if(!this.destroyed) {
                this.destroyed = true;
                OpenSslEngineMap openSslEngineMap0 = this.engineMap;
                if(openSslEngineMap0 != null) {
                    openSslEngineMap0.remove(this.ssl);
                }
                SSL.freeSSL(this.ssl);
                this.networkBIO = 0L;
                this.ssl = 0L;
                this.outboundClosed = true;
                this.isInboundDone = true;
            }
            SSL.clearError();
        }
    }

    private SSLException shutdownWithError(String s, int v) {
        return this.shutdownWithError(s, v, SSL.getLastErrorNumber());
    }

    private SSLException shutdownWithError(String s, int v, int v1) {
        InternalLogger internalLogger0 = ReferenceCountedOpenSslEngine.logger;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("{} failed with {}: OpenSSL error: {} {}", new Object[]{s, v, v1, SSL.getErrorString(v1)});
        }
        this.shutdown();
        SSLException sSLException0 = this.newSSLExceptionForError(v1);
        Throwable throwable0 = this.pendingException;
        if(throwable0 != null) {
            sSLException0.initCause(throwable0);
            this.pendingException = null;
        }
        return sSLException0;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer0) {
        this.singleDstBuffer[0] = byteBuffer0;
        return this.singleDstBuffer;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer0) {
        this.singleSrcBuffer[0] = byteBuffer0;
        return this.singleSrcBuffer;
    }

    public final int sslPending() {
        synchronized(this) {
            return this.sslPending0();
        }
    }

    private int sslPending0() {
        return this.handshakeState == HandshakeState.FINISHED ? SSL.sslPending(this.ssl) : 0;
    }

    public final long sslPointer() {
        synchronized(this) {
        }
        return this.ssl;
    }

    private SSLEngineResult sslReadErrorResult(int v, int v1, int v2, int v3) {
        if(!this.needWrapAgain(v1)) {
            throw this.shutdownWithError("SSL_read", v, v1);
        }
        return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, v2, v3);
    }

    private String toJavaCipherSuite(String s) {
        return s == null ? null : CipherSuiteConverter.toJava(s, ReferenceCountedOpenSslEngine.toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String s) {
        switch((s == null || s.isEmpty() ? 0 : s.charAt(0))) {
            case 83: {
                return "SSL";
            }
            case 84: {
                return "TLS";
            }
            default: {
                return "UNKNOWN";
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

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        SSLEngineResult sSLEngineResult0;
        synchronized(this) {
            try {
                sSLEngineResult0 = this.unwrap(this.singleSrcBuffer(byteBuffer0), this.singleDstBuffer(byteBuffer1));
            }
            catch(Throwable throwable0) {
                this.resetSingleSrcBuffer();
                this.resetSingleDstBuffer();
                throw throwable0;
            }
        }
        this.resetSingleSrcBuffer();
        this.resetSingleDstBuffer();
        return sSLEngineResult0;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer) {
        SSLEngineResult sSLEngineResult0;
        synchronized(this) {
            try {
                sSLEngineResult0 = this.unwrap(this.singleSrcBuffer(byteBuffer0), arr_byteBuffer);
            }
            catch(Throwable throwable0) {
                this.resetSingleSrcBuffer();
                throw throwable0;
            }
        }
        this.resetSingleSrcBuffer();
        return sSLEngineResult0;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer, int v, int v1) {
        synchronized(this) {
            try {
                return this.unwrap(this.singleSrcBuffer(byteBuffer0), 0, 1, arr_byteBuffer, v, v1);
            }
            finally {
                this.resetSingleSrcBuffer();
            }
        }
    }

    public final SSLEngineResult unwrap(ByteBuffer[] arr_byteBuffer, int v, int v1, ByteBuffer[] arr_byteBuffer1, int v2, int v3) {
        int v24;
        SSLEngineResult sSLEngineResult4;
        int v23;
        SSLEngineResult sSLEngineResult3;
        int v21;
        ByteBuf byteBuf1;
        ByteBuffer byteBuffer2;
        ByteBuf byteBuf0;
        int v20;
        SSLEngineResult sSLEngineResult2;
        ByteBuffer byteBuffer1;
        int v15;
        int v14;
        int v4 = v;
        int v5 = v2;
        ObjectUtil.checkNotNullWithIAE(arr_byteBuffer, "srcs");
        if(v4 < arr_byteBuffer.length) {
            int v6 = v4 + v1;
            if(v6 <= arr_byteBuffer.length) {
                ObjectUtil.checkNotNullWithIAE(arr_byteBuffer1, "dsts");
                if(v5 < arr_byteBuffer1.length) {
                    int v7 = v5 + v3;
                    if(v7 <= arr_byteBuffer1.length) {
                        int v8 = v5;
                        long v9 = 0L;
                        while(v8 < v7) {
                            ByteBuffer byteBuffer0 = (ByteBuffer)ObjectUtil.checkNotNullArrayParam(arr_byteBuffer1[v8], v8, "dsts");
                            if(byteBuffer0.isReadOnly()) {
                                throw new ReadOnlyBufferException();
                            }
                            v9 += (long)byteBuffer0.remaining();
                            ++v8;
                        }
                        int v10 = v4;
                        long v11 = 0L;
                        while(v10 < v6) {
                            v11 += (long)((ByteBuffer)ObjectUtil.checkNotNullArrayParam(arr_byteBuffer[v10], v10, "srcs")).remaining();
                            ++v10;
                        }
                        synchronized(this) {
                            if(this.isInboundDone()) {
                                return this.isOutboundDone() || this.isDestroyed() ? ReferenceCountedOpenSslEngine.CLOSED_NOT_HANDSHAKING : ReferenceCountedOpenSslEngine.NEED_WRAP_CLOSED;
                            }
                            SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                            HandshakeState referenceCountedOpenSslEngine$HandshakeState0 = this.handshakeState;
                            HandshakeState referenceCountedOpenSslEngine$HandshakeState1 = HandshakeState.FINISHED;
                            if(referenceCountedOpenSslEngine$HandshakeState0 != referenceCountedOpenSslEngine$HandshakeState1) {
                                if(referenceCountedOpenSslEngine$HandshakeState0 != HandshakeState.STARTED_EXPLICITLY) {
                                    this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                                }
                                sSLEngineResult$HandshakeStatus0 = this.handshake();
                                if(sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                                    return this.newResult(sSLEngineResult$HandshakeStatus0, 0, 0);
                                }
                                if(sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                                    return ReferenceCountedOpenSslEngine.NEED_WRAP_OK;
                                }
                                if(this.isInboundDone) {
                                    return ReferenceCountedOpenSslEngine.NEED_WRAP_CLOSED;
                                }
                            }
                            int v13 = this.sslPending0();
                            if(!this.jdkCompatibilityMode && referenceCountedOpenSslEngine$HandshakeState0 == referenceCountedOpenSslEngine$HandshakeState1) {
                                if(v11 == 0L && v13 <= 0) {
                                    return this.newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngineResult$HandshakeStatus0, 0, 0);
                                }
                                if(v9 == 0L) {
                                    return this.newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, sSLEngineResult$HandshakeStatus0, 0, 0);
                                }
                                v14 = (int)Math.min(0x7FFFFFFFL, v11);
                                v15 = v13;
                                goto label_77;
                            }
                            if(v11 < 5L) {
                                return this.newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngineResult$HandshakeStatus0, 0, 0);
                            }
                            v14 = SslUtils.getEncryptedPacketLength(arr_byteBuffer, v);
                            if(v14 != -2) {
                                v15 = v13;
                                if(((long)(v14 - 5)) > v9) {
                                    if(v14 - 5 > ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE) {
                                        throw new SSLException("Illegal packet length: " + (v14 - 5) + " > " + this.session.getApplicationBufferSize());
                                    }
                                    this.session.tryExpandApplicationBufferSize(v14 - 5);
                                    return this.newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, sSLEngineResult$HandshakeStatus0, 0, 0);
                                }
                                if(v11 < ((long)v14)) {
                                    return this.newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngineResult$HandshakeStatus0, 0, 0);
                                }
                            label_77:
                                int v16 = 0;
                                int v17 = v15;
                                int v18 = 0;
                            alab1:
                                while(true) {
                                    try {
                                    label_80:
                                        byteBuffer1 = arr_byteBuffer[v4];
                                        int v19 = byteBuffer1.remaining();
                                        if(v19 != 0) {
                                            v20 = Math.min(v14, v19);
                                            try {
                                                byteBuf0 = this.writeEncryptedData(byteBuffer1, v20);
                                                goto label_99;
                                            }
                                            catch(SSLException sSLException0) {
                                            }
                                            sSLEngineResult2 = this.handleUnwrapException(v16, v18, sSLException0);
                                            goto label_95;
                                        }
                                        else if(v17 <= 0) {
                                            ++v4;
                                            if(v4 < v6) {
                                                goto label_80;
                                            }
                                        }
                                        else {
                                            v20 = SSL.bioLengthByteBuffer(this.networkBIO);
                                            byteBuf0 = null;
                                            goto label_99;
                                        }
                                        goto label_179;
                                    }
                                    catch(Throwable throwable0) {
                                        break;
                                    }
                                label_95:
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    this.rejectRemoteInitiatedRenegotiation();
                                    return sSLEngineResult2;
                                    while(true) {
                                        try {
                                        label_99:
                                            byteBuffer2 = arr_byteBuffer1[v5];
                                            if(!byteBuffer2.hasRemaining()) {
                                                goto label_101;
                                            }
                                            goto label_106;
                                        }
                                        catch(Throwable throwable1) {
                                            byteBuf1 = byteBuf0;
                                            goto label_166;
                                        }
                                    label_101:
                                        ++v5;
                                        if(v5 < v7) {
                                            goto label_99;
                                        }
                                        if(byteBuf0 == null) {
                                            goto label_179;
                                        }
                                        try {
                                            byteBuf0.release();
                                            goto label_179;
                                        }
                                        catch(Throwable throwable0) {
                                            break alab1;
                                        }
                                        try {
                                        label_106:
                                            byteBuf1 = byteBuf0;
                                            v21 = this.readPlaintextData(byteBuffer2);
                                            byteBuf1 = byteBuf0;
                                        }
                                        catch(SSLException sSLException1) {
                                            try {
                                                sSLEngineResult3 = this.handleUnwrapException(v16, v18, sSLException1);
                                                if(byteBuf1 != null) {
                                                    goto label_113;
                                                }
                                                goto label_114;
                                            }
                                            catch(Throwable throwable1) {
                                                goto label_166;
                                            }
                                            try {
                                            label_113:
                                                byteBuf1.release();
                                            }
                                            catch(Throwable throwable0) {
                                                break alab1;
                                            }
                                        label_114:
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            this.rejectRemoteInitiatedRenegotiation();
                                            return sSLEngineResult3;
                                        }
                                        catch(Throwable throwable1) {
                                            byteBuf1 = byteBuf0;
                                            goto label_166;
                                        }
                                        try {
                                            int v22 = v20 - SSL.bioLengthByteBuffer(this.networkBIO);
                                            v16 += v22;
                                            v14 -= v22;
                                            v23 = v20 - v22;
                                            byteBuffer1.position(byteBuffer1.position() + v22);
                                            if(v21 <= 0) {
                                                goto label_145;
                                            }
                                            v18 += v21;
                                            if(byteBuffer2.hasRemaining()) {
                                                goto label_138;
                                            }
                                            else {
                                                v17 = this.sslPending0();
                                                ++v5;
                                                if(v5 >= v7) {
                                                    sSLEngineResult4 = v17 <= 0 ? this.newResultMayFinishHandshake((this.isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK), sSLEngineResult$HandshakeStatus0, v16, v18) : this.newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, sSLEngineResult$HandshakeStatus0, v16, v18);
                                                    if(byteBuf1 != null) {
                                                        goto label_134;
                                                    }
                                                    goto label_135;
                                                }
                                            }
                                            goto label_139;
                                        }
                                        catch(Throwable throwable1) {
                                            goto label_166;
                                        }
                                        try {
                                        label_134:
                                            byteBuf1.release();
                                        }
                                        catch(Throwable throwable0) {
                                            break alab1;
                                        }
                                    label_135:
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        this.rejectRemoteInitiatedRenegotiation();
                                        return sSLEngineResult4;
                                        try {
                                        label_138:
                                            if(v14 == 0 || this.jdkCompatibilityMode) {
                                                break;
                                            }
                                        label_139:
                                            v20 = v23;
                                            byteBuf0 = byteBuf1;
                                        }
                                        catch(Throwable throwable1) {
                                            goto label_166;
                                        }
                                    }
                                    if(byteBuf1 != null) {
                                        try {
                                            byteBuf1.release();
                                            goto label_179;
                                        }
                                        catch(Throwable throwable0) {
                                            break;
                                        }
                                        try {
                                        label_145:
                                            v24 = SSL.getError(this.ssl, v21);
                                            if(v24 == SSL.SSL_ERROR_WANT_READ || v24 == SSL.SSL_ERROR_WANT_WRITE) {
                                                goto label_175;
                                            }
                                            else if(v24 == SSL.SSL_ERROR_ZERO_RETURN) {
                                                if(!this.receivedShutdown) {
                                                    this.closeAll();
                                                }
                                                sSLEngineResult4 = this.newResultMayFinishHandshake((this.isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK), sSLEngineResult$HandshakeStatus0, v16, v18);
                                                if(byteBuf1 != null) {
                                                    goto label_152;
                                                }
                                                goto label_153;
                                            }
                                            else {
                                                goto label_156;
                                            }
                                            return sSLEngineResult4;
                                        }
                                        catch(Throwable throwable1) {
                                            goto label_166;
                                        }
                                        try {
                                        label_152:
                                            byteBuf1.release();
                                        }
                                        catch(Throwable throwable0) {
                                            break;
                                        }
                                    label_153:
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        this.rejectRemoteInitiatedRenegotiation();
                                        return sSLEngineResult4;
                                        try {
                                        label_156:
                                            if(v24 == SSL.SSL_ERROR_WANT_X509_LOOKUP || v24 == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || v24 == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                                sSLEngineResult4 = this.newResult((this.isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK), SSLEngineResult.HandshakeStatus.NEED_TASK, v16, v18);
                                                goto label_169;
                                            }
                                            else {
                                                sSLEngineResult4 = this.sslReadErrorResult(v24, SSL.getLastErrorNumber(), v16, v18);
                                                if(byteBuf1 != null) {
                                                    goto label_159;
                                                }
                                                goto label_160;
                                            }
                                            return sSLEngineResult4;
                                        }
                                        catch(Throwable throwable1) {
                                            goto label_166;
                                        }
                                        try {
                                        label_159:
                                            byteBuf1.release();
                                        }
                                        catch(Throwable throwable0) {
                                            break;
                                        }
                                    label_160:
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        this.rejectRemoteInitiatedRenegotiation();
                                        return sSLEngineResult4;
                                        try {
                                            sSLEngineResult4 = this.newResult((this.isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK), SSLEngineResult.HandshakeStatus.NEED_TASK, v16, v18);
                                            goto label_169;
                                        }
                                        catch(Throwable throwable1) {
                                        }
                                        try {
                                        label_166:
                                            if(byteBuf1 != null) {
                                                byteBuf1.release();
                                            }
                                            throw throwable1;
                                        label_169:
                                            if(byteBuf1 != null) {
                                                byteBuf1.release();
                                            }
                                        }
                                        catch(Throwable throwable0) {
                                            break;
                                        }
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        this.rejectRemoteInitiatedRenegotiation();
                                        return sSLEngineResult4;
                                    label_175:
                                        ++v4;
                                        if(v4 < v6) {
                                            goto label_186;
                                        }
                                        else if(byteBuf1 != null) {
                                            try {
                                                byteBuf1.release();
                                            }
                                            catch(Throwable throwable0) {
                                                break;
                                            }
                                        }
                                    }
                                label_179:
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    this.rejectRemoteInitiatedRenegotiation();
                                    if(!this.receivedShutdown && (SSL.getShutdown(this.ssl) & SSL.SSL_RECEIVED_SHUTDOWN) == SSL.SSL_RECEIVED_SHUTDOWN) {
                                        this.closeAll();
                                    }
                                    return this.newResultMayFinishHandshake((this.isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK), sSLEngineResult$HandshakeStatus0, v16, v18);
                                label_186:
                                    if(byteBuf1 == null) {
                                        goto label_80;
                                    }
                                    try {
                                        byteBuf1.release();
                                        goto label_80;
                                    }
                                    catch(Throwable throwable0) {
                                    }
                                    break;
                                }
                                SSL.bioClearByteBuffer(this.networkBIO);
                                this.rejectRemoteInitiatedRenegotiation();
                                throw throwable0;
                            }
                        }
                        throw new NotSslRecordException("not an SSL/TLS record");
                    }
                }
                StringBuilder stringBuilder0 = o.t(v5, v3, "offset: ", ", length: ", " (expected: offset <= offset + length <= dsts.length (");
                throw new IndexOutOfBoundsException(x.g(arr_byteBuffer1.length, "))", stringBuilder0));
            }
        }
        StringBuilder stringBuilder1 = o.t(v4, v1, "offset: ", ", length: ", " (expected: offset <= offset + length <= srcs.length (");
        throw new IndexOutOfBoundsException(x.g(arr_byteBuffer.length, "))", stringBuilder1));
    }

    public final SSLEngineResult unwrap(ByteBuffer[] arr_byteBuffer, ByteBuffer[] arr_byteBuffer1) {
        return this.unwrap(arr_byteBuffer, 0, arr_byteBuffer.length, arr_byteBuffer1, 0, arr_byteBuffer1.length);
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult wrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        SSLEngineResult sSLEngineResult0;
        synchronized(this) {
            try {
                sSLEngineResult0 = this.wrap(this.singleSrcBuffer(byteBuffer0), byteBuffer1);
            }
            catch(Throwable throwable0) {
                this.resetSingleSrcBuffer();
                throw throwable0;
            }
        }
        this.resetSingleSrcBuffer();
        return sSLEngineResult0;
    }

    @Override  // javax.net.ssl.SSLEngine
    public final SSLEngineResult wrap(ByteBuffer[] arr_byteBuffer, int v, int v1, ByteBuffer byteBuffer0) {
        int v16;
        int v15;
        int v13;
        SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus1;
        int v7;
        SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0;
        int v6;
        SSLEngineResult sSLEngineResult2;
        int v5;
        SSLEngineResult sSLEngineResult1;
        int v4;
        Throwable throwable2;
        ByteBuf byteBuf1;
        int v3;
        ByteBuf byteBuf0;
        SSLEngineResult sSLEngineResult0;
        ObjectUtil.checkNotNullWithIAE(arr_byteBuffer, "srcs");
        ObjectUtil.checkNotNullWithIAE(byteBuffer0, "dst");
        if(v < arr_byteBuffer.length) {
            int v2 = v + v1;
            if(v2 <= arr_byteBuffer.length) {
                if(byteBuffer0.isReadOnly()) {
                    throw new ReadOnlyBufferException();
                }
                synchronized(this) {
                    if(this.isOutboundDone()) {
                        return this.isInboundDone() || this.isDestroyed() ? ReferenceCountedOpenSslEngine.CLOSED_NOT_HANDSHAKING : ReferenceCountedOpenSslEngine.NEED_UNWRAP_CLOSED;
                    }
                    goto label_11;
                }
                return sSLEngineResult0;
                try {
                label_11:
                    byteBuf0 = null;
                    v3 = 0;
                    if(byteBuffer0.isDirect()) {
                        SSL.bioSetByteBuffer(this.networkBIO, ReferenceCountedOpenSslEngine.bufferAddress(byteBuffer0) + ((long)byteBuffer0.position()), byteBuffer0.remaining(), true);
                        byteBuf1 = null;
                    }
                    else {
                        byteBuf1 = this.alloc.directBuffer(byteBuffer0.remaining());
                        goto label_22;
                    }
                    goto label_23;
                }
                catch(Throwable throwable1) {
                    throwable2 = throwable1;
                    goto label_288;
                }
                try {
                label_22:
                    SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBuf1), byteBuf1.writableBytes(), true);
                label_23:
                    v4 = SSL.bioLengthByteBuffer(this.networkBIO);
                    if(!this.outboundClosed) {
                        goto label_62;
                    }
                    else if(!this.isBytesAvailableEnoughForWrap(byteBuffer0.remaining(), 2, 1)) {
                        sSLEngineResult1 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, this.getHandshakeStatus(), 0, 0);
                        goto label_27;
                    }
                    else {
                        goto label_34;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable3) {
                    throwable2 = throwable3;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
            label_27:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position());
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), 0));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_34:
                    v5 = SSL.bioFlushByteBuffer(this.networkBIO);
                    if(v5 <= 0) {
                        goto label_36;
                    }
                    goto label_44;
                }
                catch(Throwable throwable3) {
                    throwable2 = throwable3;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                try {
                label_36:
                    sSLEngineResult2 = this.newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                }
                catch(Throwable throwable4) {
                    v3 = v5;
                    throwable2 = throwable4;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v5);
                    return sSLEngineResult2;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v5));
                byteBuf1.release();
                return sSLEngineResult2;
                try {
                label_44:
                    if(!this.doSSLShutdown()) {
                        sSLEngineResult2 = this.newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, v5);
                        goto label_46;
                    }
                    goto label_53;
                }
                catch(Throwable throwable4) {
                    v3 = v5;
                    throwable2 = throwable4;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
            label_46:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v5);
                    return sSLEngineResult2;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v5));
                byteBuf1.release();
                return sSLEngineResult2;
                try {
                label_53:
                    v6 = v4 - SSL.bioLengthByteBuffer(this.networkBIO);
                }
                catch(Throwable throwable4) {
                    v3 = v5;
                    throwable2 = throwable4;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                try {
                    sSLEngineResult1 = this.newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_62:
                    sSLEngineResult$HandshakeStatus0 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    HandshakeState referenceCountedOpenSslEngine$HandshakeState0 = this.handshakeState;
                    HandshakeState referenceCountedOpenSslEngine$HandshakeState1 = HandshakeState.FINISHED;
                    if(referenceCountedOpenSslEngine$HandshakeState0 == referenceCountedOpenSslEngine$HandshakeState1) {
                        goto label_129;
                    }
                    else {
                        if(referenceCountedOpenSslEngine$HandshakeState0 != HandshakeState.STARTED_EXPLICITLY) {
                            this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                        }
                        v7 = SSL.bioFlushByteBuffer(this.networkBIO);
                        goto label_69;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable3) {
                    throwable2 = throwable3;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                try {
                label_69:
                    if(this.pendingException == null) {
                        goto label_87;
                    }
                    else if(v7 > 0) {
                        sSLEngineResult1 = this.newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, v7);
                        goto label_72;
                    }
                    else {
                        goto label_79;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
            label_72:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_79:
                    sSLEngineResult1 = this.newResult(this.handshakeException(), 0, 0);
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_87:
                    sSLEngineResult$HandshakeStatus1 = this.handshake();
                    v7 = v4 - SSL.bioLengthByteBuffer(this.networkBIO);
                    if(sSLEngineResult$HandshakeStatus1 == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        goto label_121;
                    }
                    else if(v7 > 0) {
                        SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
                        if(sSLEngineResult$HandshakeStatus1 != sSLEngineResult$HandshakeStatus2) {
                            sSLEngineResult$HandshakeStatus2 = v7 == v4 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : this.getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                        }
                        sSLEngineResult1 = this.newResult(this.mayFinishHandshake(sSLEngineResult$HandshakeStatus2), 0, v7);
                        goto label_95;
                    }
                    else {
                        goto label_102;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
            label_95:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_102:
                    if(sSLEngineResult$HandshakeStatus1 == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                        goto label_113;
                    }
                    else {
                        if(!this.outboundClosed) {
                            goto label_136;
                        }
                        v5 = SSL.bioFlushByteBuffer(this.networkBIO);
                        goto label_105;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                try {
                label_105:
                    sSLEngineResult2 = this.newResultMayFinishHandshake(sSLEngineResult$HandshakeStatus1, 0, v5);
                }
                catch(Throwable throwable4) {
                    v3 = v5;
                    throwable2 = throwable4;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v5);
                    return sSLEngineResult2;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v5));
                byteBuf1.release();
                return sSLEngineResult2;
                try {
                label_113:
                    sSLEngineResult1 = this.isOutboundDone() ? ReferenceCountedOpenSslEngine.NEED_UNWRAP_CLOSED : ReferenceCountedOpenSslEngine.NEED_UNWRAP_OK;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_121:
                    sSLEngineResult1 = this.newResult(sSLEngineResult$HandshakeStatus1, 0, v7);
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_129:
                    sSLEngineResult$HandshakeStatus1 = sSLEngineResult$HandshakeStatus0;
                    v7 = 0;
                }
                catch(Throwable throwable3) {
                    throwable2 = throwable3;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                try {
                label_136:
                    if(!this.jdkCompatibilityMode && referenceCountedOpenSslEngine$HandshakeState0 == referenceCountedOpenSslEngine$HandshakeState1) {
                        goto label_158;
                    }
                    else {
                        int v8 = v;
                        int v9 = 0;
                        while(v8 < v2) {
                            ByteBuffer byteBuffer1 = arr_byteBuffer[v8];
                            if(byteBuffer1 == null) {
                                throw new IllegalArgumentException("srcs[" + v8 + "] is null");
                            }
                            int v10 = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
                            if(v9 != v10) {
                                int v11 = v9 + byteBuffer1.remaining();
                                v9 = v11 <= v10 && v11 >= 0 ? v11 : v10;
                            }
                            ++v8;
                        }
                        if(this.isBytesAvailableEnoughForWrap(byteBuffer0.remaining(), v9, 1)) {
                            goto label_158;
                        }
                        else {
                            sSLEngineResult1 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, this.getHandshakeStatus(), 0, 0);
                            goto label_151;
                        }
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
            label_151:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                label_158:
                    v7 = SSL.bioFlushByteBuffer(this.networkBIO);
                    if(v7 <= 0) {
                        Throwable throwable7 = this.pendingException;
                        if(throwable7 != null) {
                            this.pendingException = null;
                            this.shutdown();
                            throw new SSLException(throwable7);
                        }
                        while(true) {
                        label_165:
                            if(v >= v2) {
                                goto label_274;
                            }
                            ByteBuffer byteBuffer2 = arr_byteBuffer[v];
                            int v12 = byteBuffer2.remaining();
                            if(v12 != 0) {
                                if(this.jdkCompatibilityMode) {
                                    v13 = this.writePlaintextData(byteBuffer2, Math.min(v12, ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH - v3));
                                    goto label_175;
                                }
                                else {
                                    int v14 = byteBuffer0.remaining() - v7 - this.maxWrapOverhead;
                                    if(v14 > 0) {
                                        v13 = this.writePlaintextData(byteBuffer2, Math.min(v12, v14));
                                    label_175:
                                        v15 = SSL.bioLengthByteBuffer(this.networkBIO);
                                        v6 = v4 - v15 + v7;
                                        if(v13 > 0) {
                                            goto label_178;
                                        }
                                        goto label_191;
                                    }
                                    goto label_259;
                                }
                            }
                            ++v;
                        }
                    }
                    else {
                        sSLEngineResult1 = this.newResultMayFinishHandshake(sSLEngineResult$HandshakeStatus1, 0, v7);
                        goto label_295;
                    }
                    return sSLEngineResult1;
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                try {
                label_178:
                    v3 += v13;
                    if(!this.jdkCompatibilityMode && v6 != byteBuffer0.remaining()) {
                        v7 = v6;
                        v4 = v15;
                        ++v;
                        goto label_165;
                    }
                    sSLEngineResult1 = this.newResultMayFinishHandshake(sSLEngineResult$HandshakeStatus1, v3, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_191:
                    v16 = SSL.getError(this.ssl, v13);
                    if(v16 == SSL.SSL_ERROR_ZERO_RETURN) {
                        if(!this.receivedShutdown) {
                            this.closeAll();
                            v5 = v15 - SSL.bioLengthByteBuffer(this.networkBIO) + v6;
                            goto label_196;
                        }
                        goto label_214;
                    }
                    goto label_222;
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                try {
                label_196:
                    SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus3 = SSLEngineResult.HandshakeStatus.FINISHED;
                    if(sSLEngineResult$HandshakeStatus1 != sSLEngineResult$HandshakeStatus3) {
                        sSLEngineResult$HandshakeStatus3 = v5 == byteBuffer0.remaining() ? SSLEngineResult.HandshakeStatus.NEED_WRAP : this.getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                    }
                    sSLEngineResult2 = this.newResult(this.mayFinishHandshake(sSLEngineResult$HandshakeStatus3), v3, v5);
                }
                catch(Throwable throwable4) {
                    v3 = v5;
                    throwable2 = throwable4;
                    byteBuf0 = byteBuf1;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v5);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v5));
                    byteBuf1.release();
                }
                return sSLEngineResult2;
                try {
                label_214:
                    sSLEngineResult1 = this.newResult(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, v3, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_222:
                    if(v16 != SSL.SSL_ERROR_WANT_READ) {
                        if(v16 == SSL.SSL_ERROR_WANT_WRITE) {
                            if(v6 > 0) {
                                sSLEngineResult1 = this.newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, v3, v6);
                                goto label_226;
                            }
                            goto label_233;
                        }
                        goto label_241;
                    }
                    goto label_251;
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
            label_226:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_233:
                    sSLEngineResult1 = this.newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, sSLEngineResult$HandshakeStatus1, v3, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_241:
                    if(v16 != SSL.SSL_ERROR_WANT_X509_LOOKUP && v16 != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && v16 != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                        throw this.shutdownWithError("SSL_write", v16);
                    }
                    sSLEngineResult1 = this.newResult(SSLEngineResult.HandshakeStatus.NEED_TASK, v3, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_251:
                    sSLEngineResult1 = this.newResult(SSLEngineResult.HandshakeStatus.NEED_UNWRAP, v3, v6);
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v6);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v6));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                label_259:
                    sSLEngineResult1 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, this.getHandshakeStatus(), v3, v7);
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                    return sSLEngineResult1;
                }
                byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                byteBuf1.release();
                return sSLEngineResult1;
                try {
                    ++v;
                    goto label_165;
                }
                catch(Throwable throwable5) {
                    throwable2 = throwable5;
                    byteBuf0 = byteBuf1;
                    v3 = v6;
                    goto label_288;
                }
                try {
                label_274:
                    sSLEngineResult1 = this.newResultMayFinishHandshake(sSLEngineResult$HandshakeStatus1, v3, v7);
                }
                catch(Throwable throwable6) {
                    goto label_285;
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
                try {
                    sSLEngineResult1 = this.newResultMayFinishHandshake(sSLEngineResult$HandshakeStatus1, 0, v7);
                    goto label_295;
                }
                catch(Throwable throwable6) {
                label_285:
                    throwable2 = throwable6;
                    byteBuf0 = byteBuf1;
                    v3 = v7;
                }
            label_288:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf0 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v3);
                }
                else {
                    byteBuffer0.put(byteBuf0.internalNioBuffer(byteBuf0.readerIndex(), v3));
                    byteBuf0.release();
                }
                throw throwable2;
            label_295:
                SSL.bioClearByteBuffer(this.networkBIO);
                if(byteBuf1 == null) {
                    byteBuffer0.position(byteBuffer0.position() + v7);
                }
                else {
                    byteBuffer0.put(byteBuf1.internalNioBuffer(byteBuf1.readerIndex(), v7));
                    byteBuf1.release();
                }
                return sSLEngineResult1;
            }
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "offset: ", ", length: ", " (expected: offset <= offset + length <= srcs.length (");
        throw new IndexOutOfBoundsException(x.g(arr_byteBuffer.length, "))", stringBuilder0));
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer0, int v) {
        int v1 = byteBuffer0.position();
        if(byteBuffer0.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, ReferenceCountedOpenSslEngine.bufferAddress(byteBuffer0) + ((long)v1), v, false);
            return null;
        }
        ByteBuf byteBuf0 = this.alloc.directBuffer(v);
        try {
            byteBuffer0.limit(v1 + v);
            byteBuf0.writeBytes(byteBuffer0);
            byteBuffer0.position(v1);
            byteBuffer0.limit(byteBuffer0.limit());
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBuf0), v, false);
            return byteBuf0;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            PlatformDependent.throwException(throwable0);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer0, int v) {
        int v1 = byteBuffer0.position();
        int v2 = byteBuffer0.limit();
        if(byteBuffer0.isDirect()) {
            int v3 = SSL.writeToSSL(this.ssl, ReferenceCountedOpenSslEngine.bufferAddress(byteBuffer0) + ((long)v1), v);
            if(v3 > 0) {
                byteBuffer0.position(v1 + v3);
            }
            return v3;
        }
        ByteBuf byteBuf0 = this.alloc.directBuffer(v);
        try {
            byteBuffer0.limit(v1 + v);
            byteBuf0.setBytes(0, byteBuffer0);
            byteBuffer0.limit(v2);
            int v5 = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(byteBuf0), v);
            if(v5 > 0) {
                byteBuffer0.position(v1 + v5);
            }
            else {
                byteBuffer0.position(v1);
            }
            return v5;
        }
        finally {
            byteBuf0.release();
        }
    }
}

