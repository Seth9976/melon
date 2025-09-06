package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLSession;
import io.netty.internal.tcnative.SSLSessionCache;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SystemPropertyUtil;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

class OpenSslSessionCache implements SSLSessionCache {
    static final class NativeSslSession implements OpenSslSession {
        static final boolean $assertionsDisabled;
        static final ResourceLeakDetector LEAK_DETECTOR;
        private final long creationTime;
        private boolean freed;
        private final OpenSslSessionId id;
        private volatile long lastAccessedTime;
        private final ResourceLeakTracker leakTracker;
        private final String peerHost;
        private final int peerPort;
        private final long session;
        private final long timeout;
        private volatile boolean valid;

        static {
            NativeSslSession.LEAK_DETECTOR = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(NativeSslSession.class);
        }

        public NativeSslSession(long v, String s, int v1, long v2) {
            long v3 = System.currentTimeMillis();
            this.creationTime = v3;
            this.lastAccessedTime = v3;
            this.valid = true;
            this.session = v;
            this.peerHost = s;
            this.peerPort = v1;
            this.timeout = v2;
            this.id = new OpenSslSessionId(SSLSession.getSessionId(v));
            this.leakTracker = NativeSslSession.LEAK_DETECTOR.track(this);
        }

        public void close() {
            this.freed = true;
            this.invalidate();
            ResourceLeakTracker resourceLeakTracker0 = this.leakTracker;
            if(resourceLeakTracker0 != null) {
                resourceLeakTracker0.close(this);
            }
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OpenSslSession)) {
                return false;
            }
            OpenSslSessionId openSslSessionId0 = ((OpenSslSession)object0).sessionId();
            return this.id.equals(openSslSessionId0);
        }

        public void free() {
            synchronized(this) {
                this.close();
                SSLSession.free(this.session);
            }
        }

        @Override  // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        }

        @Override  // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            return null;
        }

        @Override  // javax.net.ssl.SSLSession
        public long getCreationTime() {
            return this.creationTime;
        }

        @Override  // javax.net.ssl.SSLSession
        public byte[] getId() {
            return this.id.cloneBytes();
        }

        @Override  // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            return this.lastAccessedTime;
        }

        @Override  // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
        }

        @Override  // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return this.peerHost;
        }

        @Override  // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return this.peerPort;
        }

        @Override  // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public String getProtocol() {
            return null;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionContext getSessionContext() [...] // Inlined contents

        @Override  // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return null;
        }

        @Override  // javax.net.ssl.SSLSession
        public Object getValue(String s) {
            return null;
        }

        @Override  // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            return EmptyArrays.EMPTY_STRINGS;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] arr_b, String s, String s1, byte[] arr_b1, byte[][] arr2_b, long v, long v1) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override  // javax.net.ssl.SSLSession
        public void invalidate() {
            this.valid = false;
        }

        @Override  // javax.net.ssl.SSLSession
        public boolean isValid() {
            return this.isValid(System.currentTimeMillis());
        }

        public boolean isValid(long v) {
            return this.creationTime + this.timeout >= v && this.valid;
        }

        @Override  // javax.net.ssl.SSLSession
        public void putValue(String s, Object object0) {
            throw new UnsupportedOperationException();
        }

        @Override  // javax.net.ssl.SSLSession
        public void removeValue(String s) {
        }

        public long session() {
            return this.session;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            return this.id;
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] arr_certificate) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId openSslSessionId0) {
            throw new UnsupportedOperationException();
        }

        public boolean shouldBeSingleUse() {
            return SSLSession.shouldBeSingleUse(this.session);
        }

        @Override  // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int v) {
            throw new UnsupportedOperationException();
        }

        public boolean upRef() {
            return SSLSession.upRef(this.session);
        }

        public void updateLastAccessedTime() {
            this.lastAccessedTime = System.currentTimeMillis();
        }
    }

    private static final int DEFAULT_CACHE_SIZE;
    private static final OpenSslSession[] EMPTY_SESSIONS;
    private final OpenSslEngineMap engineMap;
    private final AtomicInteger maximumCacheSize;
    private int sessionCounter;
    private final AtomicInteger sessionTimeout;
    private final Map sessions;

    static {
        OpenSslSessionCache.EMPTY_SESSIONS = new OpenSslSession[0];
        int v = SystemPropertyUtil.getInt("javax.net.ssl.sessionCacheSize", 0x5000);
        if(v >= 0) {
            OpenSslSessionCache.DEFAULT_CACHE_SIZE = v;
            return;
        }
        OpenSslSessionCache.DEFAULT_CACHE_SIZE = 0x5000;
    }

    public OpenSslSessionCache(OpenSslEngineMap openSslEngineMap0) {
        this.sessions = new LinkedHashMap() {
            private static final long serialVersionUID = 0x941E47F53F931350L;

            @Override
            public boolean removeEldestEntry(Map.Entry map$Entry0) {
                int v = OpenSslSessionCache.this.maximumCacheSize.get();
                if(v >= 0 && this.size() > v) {
                    OpenSslSessionId openSslSessionId0 = (OpenSslSessionId)map$Entry0.getKey();
                    OpenSslSessionCache.this.removeSessionWithId(openSslSessionId0);
                }
                return false;
            }
        };
        this.maximumCacheSize = new AtomicInteger(OpenSslSessionCache.DEFAULT_CACHE_SIZE);
        this.sessionTimeout = new AtomicInteger(300);
        this.engineMap = openSslEngineMap0;
    }

    public void clear() {
        synchronized(this) {
            Iterator iterator0 = this.sessions.entrySet().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                NativeSslSession openSslSessionCache$NativeSslSession0 = (NativeSslSession)((Map.Entry)object0).getValue();
                iterator0.remove();
                this.notifyRemovalAndFree(openSslSessionCache$NativeSslSession0);
            }
        }
    }

    public final boolean containsSessionWithId(OpenSslSessionId openSslSessionId0) {
        synchronized(this) {
            return this.sessions.containsKey(openSslSessionId0);
        }
    }

    private void expungeInvalidSessions() {
        if(!this.sessions.isEmpty()) {
            long v = System.currentTimeMillis();
            Iterator iterator0 = this.sessions.entrySet().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                NativeSslSession openSslSessionCache$NativeSslSession0 = (NativeSslSession)((Map.Entry)object0).getValue();
                if(openSslSessionCache$NativeSslSession0.isValid(v)) {
                    break;
                }
                iterator0.remove();
                this.notifyRemovalAndFree(openSslSessionCache$NativeSslSession0);
            }
        }
    }

    public final List getIds() {
        OpenSslSession[] arr_openSslSession;
        synchronized(this) {
            arr_openSslSession = (OpenSslSession[])this.sessions.values().toArray(OpenSslSessionCache.EMPTY_SESSIONS);
        }
        List list0 = new ArrayList(arr_openSslSession.length);
        for(int v1 = 0; v1 < arr_openSslSession.length; ++v1) {
            OpenSslSession openSslSession0 = arr_openSslSession[v1];
            if(openSslSession0.isValid()) {
                ((ArrayList)list0).add(openSslSession0.sessionId());
            }
        }
        return list0;
    }

    public final long getSession(long v, byte[] arr_b) {
        OpenSslSessionId openSslSessionId0 = new OpenSslSessionId(arr_b);
        synchronized(this) {
            NativeSslSession openSslSessionCache$NativeSslSession0 = (NativeSslSession)this.sessions.get(openSslSessionId0);
            if(openSslSessionCache$NativeSslSession0 == null) {
                return -1L;
            }
            if(openSslSessionCache$NativeSslSession0.isValid() && openSslSessionCache$NativeSslSession0.upRef()) {
                if(openSslSessionCache$NativeSslSession0.shouldBeSingleUse()) {
                    this.removeSessionWithId(openSslSessionCache$NativeSslSession0.sessionId());
                }
                openSslSessionCache$NativeSslSession0.updateLastAccessedTime();
                return openSslSessionCache$NativeSslSession0.session();
            }
            this.removeSessionWithId(openSslSessionCache$NativeSslSession0.sessionId());
            return -1L;
        }
    }

    public final OpenSslSession getSession(OpenSslSessionId openSslSessionId0) {
        synchronized(this) {
            OpenSslSession openSslSession0 = (NativeSslSession)this.sessions.get(openSslSessionId0);
            if(openSslSession0 != null && !((NativeSslSession)openSslSession0).isValid()) {
                this.removeSessionWithId(((NativeSslSession)openSslSession0).sessionId());
                return null;
            }
            return openSslSession0;
        }
    }

    public final int getSessionCacheSize() {
        return this.maximumCacheSize.get();
    }

    public final int getSessionTimeout() {
        return this.sessionTimeout.get();
    }

    private void notifyRemovalAndFree(NativeSslSession openSslSessionCache$NativeSslSession0) {
        this.sessionRemoved(openSslSessionCache$NativeSslSession0);
        openSslSessionCache$NativeSslSession0.free();
    }

    public final void removeSessionWithId(OpenSslSessionId openSslSessionId0) {
        synchronized(this) {
            NativeSslSession openSslSessionCache$NativeSslSession0 = (NativeSslSession)this.sessions.remove(openSslSessionId0);
            if(openSslSessionCache$NativeSslSession0 != null) {
                this.notifyRemovalAndFree(openSslSessionCache$NativeSslSession0);
            }
        }
    }

    public final boolean sessionCreated(long v, long v1) {
        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = this.engineMap.get(v);
        if(referenceCountedOpenSslEngine0 == null) {
            return false;
        }
        NativeSslSession openSslSessionCache$NativeSslSession0 = new NativeSslSession(v1, referenceCountedOpenSslEngine0.getPeerHost(), referenceCountedOpenSslEngine0.getPeerPort(), 1000L * ((long)this.getSessionTimeout()));
        referenceCountedOpenSslEngine0.setSessionId(openSslSessionCache$NativeSslSession0.sessionId());
        synchronized(this) {
            int v2 = this.sessionCounter + 1;
            this.sessionCounter = v2;
            if(v2 == 0xFF) {
                this.sessionCounter = 0;
                this.expungeInvalidSessions();
            }
            if(!this.sessionCreated(openSslSessionCache$NativeSslSession0)) {
                openSslSessionCache$NativeSslSession0.close();
                return false;
            }
            goto label_15;
        }
        return false;
    label_15:
        NativeSslSession openSslSessionCache$NativeSslSession1 = (NativeSslSession)this.sessions.put(openSslSessionCache$NativeSslSession0.sessionId(), openSslSessionCache$NativeSslSession0);
        if(openSslSessionCache$NativeSslSession1 != null) {
            this.notifyRemovalAndFree(openSslSessionCache$NativeSslSession1);
        }
        return true;
    }

    public boolean sessionCreated(NativeSslSession openSslSessionCache$NativeSslSession0) {
        return true;
    }

    public void sessionRemoved(NativeSslSession openSslSessionCache$NativeSslSession0) {
    }

    public void setSession(long v, String s, int v1) {
    }

    public final void setSessionCacheSize(int v) {
        if(((long)this.maximumCacheSize.getAndSet(v)) <= ((long)v) && v != 0) {
            return;
        }
        this.clear();
    }

    public final void setSessionTimeout(int v) {
        if(this.sessionTimeout.getAndSet(v) > v) {
            this.clear();
        }
    }
}

