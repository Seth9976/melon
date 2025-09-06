package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SessionTicketKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

public abstract class OpenSslSessionContext implements SSLSessionContext {
    final ReferenceCountedOpenSslContext context;
    private final long mask;
    private final OpenSslKeyMaterialProvider provider;
    private final OpenSslSessionCache sessionCache;
    private final OpenSslSessionStats stats;

    public OpenSslSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, OpenSslKeyMaterialProvider openSslKeyMaterialProvider0, long v, OpenSslSessionCache openSslSessionCache0) {
        this.context = referenceCountedOpenSslContext0;
        this.provider = openSslKeyMaterialProvider0;
        this.mask = v;
        this.stats = new OpenSslSessionStats(referenceCountedOpenSslContext0);
        this.sessionCache = openSslSessionCache0;
        SSLContext.setSSLSessionCache(referenceCountedOpenSslContext0.ctx, openSslSessionCache0);
    }

    public final void destroy() {
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider0 = this.provider;
        if(openSslKeyMaterialProvider0 != null) {
            openSslKeyMaterialProvider0.destroy();
        }
        this.sessionCache.clear();
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public Enumeration getIds() {
        return new Enumeration() {
            private final Iterator ids;

            {
                this.ids = openSslSessionContext0.sessionCache.getIds().iterator();
            }

            @Override
            public boolean hasMoreElements() {
                return this.ids.hasNext();
            }

            @Override
            public Object nextElement() {
                return this.nextElement();
            }

            public byte[] nextElement() {
                Object object0 = this.ids.next();
                return ((OpenSslSessionId)object0).cloneBytes();
            }
        };
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] arr_b) {
        OpenSslSessionId openSslSessionId0 = new OpenSslSessionId(arr_b);
        return this.sessionCache.getSession(openSslSessionId0);
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public int getSessionCacheSize() {
        return this.sessionCache.getSessionCacheSize();
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public int getSessionTimeout() {
        return this.sessionCache.getSessionTimeout();
    }

    public final boolean isInCache(OpenSslSessionId openSslSessionId0) {
        return this.sessionCache.containsSessionWithId(openSslSessionId0);
    }

    public boolean isSessionCacheEnabled() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return (SSLContext.getSessionCacheMode(this.context.ctx) & this.mask) != 0L;
        }
        finally {
            lock0.unlock();
        }
    }

    public final void removeFromCache(OpenSslSessionId openSslSessionId0) {
        this.sessionCache.removeSessionWithId(openSslSessionId0);
    }

    public void setSessionCacheEnabled(boolean z) {
        long v = z ? this.mask | SSL.SSL_SESS_CACHE_NO_INTERNAL_LOOKUP | SSL.SSL_SESS_CACHE_NO_INTERNAL_STORE : SSL.SSL_SESS_CACHE_OFF;
        Lock lock0 = this.context.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.setSessionCacheMode(this.context.ctx, v);
            if(!z) {
                this.sessionCache.clear();
            }
        }
        finally {
            lock0.unlock();
        }
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public void setSessionCacheSize(int v) {
        ObjectUtil.checkPositiveOrZero(v, "size");
        this.sessionCache.setSessionCacheSize(v);
    }

    public void setSessionFromCache(String s, int v, long v1) {
        this.sessionCache.setSession(v1, s, v);
    }

    @Override  // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int v) {
        ObjectUtil.checkPositiveOrZero(v, "seconds");
        Lock lock0 = this.context.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.setSessionCacheTimeout(this.context.ctx, v);
            this.sessionCache.setSessionTimeout(v);
        }
        finally {
            lock0.unlock();
        }
    }

    @Deprecated
    public void setTicketKeys(byte[] arr_b) {
        if(arr_b.length % 0x30 != 0) {
            throw new IllegalArgumentException("keys.length % 48 != 0");
        }
        int v = arr_b.length / 0x30;
        SessionTicketKey[] arr_sessionTicketKey = new SessionTicketKey[v];
        int v2 = 0;
        for(int v1 = 0; v1 < v; v1 += 17) {
            byte[] arr_b1 = Arrays.copyOfRange(arr_b, v2, 16);
            byte[] arr_b2 = Arrays.copyOfRange(arr_b, v2 + 16, 16);
            byte[] arr_b3 = Arrays.copyOfRange(arr_b, v2 + 16, 16);
            v2 += 0x20;
            arr_sessionTicketKey[v1 + 16] = new SessionTicketKey(arr_b1, arr_b2, arr_b3);
        }
        Lock lock0 = this.context.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            SSLContext.setSessionTicketKeys(this.context.ctx, arr_sessionTicketKey);
        }
        finally {
            lock0.unlock();
        }
    }

    public void setTicketKeys(OpenSslSessionTicketKey[] arr_openSslSessionTicketKey) {
        ObjectUtil.checkNotNull(arr_openSslSessionTicketKey, "keys");
        SessionTicketKey[] arr_sessionTicketKey = new SessionTicketKey[arr_openSslSessionTicketKey.length];
        for(int v = 0; v < arr_openSslSessionTicketKey.length; ++v) {
            arr_sessionTicketKey[v] = arr_openSslSessionTicketKey[v].key;
        }
        Lock lock0 = this.context.ctxLock.writeLock();
        lock0.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            if(arr_openSslSessionTicketKey.length > 0) {
                SSLContext.setSessionTicketKeys(this.context.ctx, arr_sessionTicketKey);
            }
        }
        finally {
            lock0.unlock();
        }
    }

    public OpenSslSessionStats stats() {
        return this.stats;
    }

    public final boolean useKeyManager() {
        return this.provider != null;
    }
}

