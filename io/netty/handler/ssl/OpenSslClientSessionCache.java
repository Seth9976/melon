package io.netty.handler.ssl;

import androidx.appcompat.app.o;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AsciiString;
import java.util.HashMap;
import java.util.Map;

final class OpenSslClientSessionCache extends OpenSslSessionCache {
    static final class HostPort {
        private final int hash;
        private final String host;
        private final int port;

        public HostPort(String s, int v) {
            this.host = s;
            this.port = v;
            this.hash = AsciiString.hashCode(s) * 0x1F + v;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof HostPort ? this.port == ((HostPort)object0).port && this.host.equalsIgnoreCase(((HostPort)object0).host) : false;
        }

        @Override
        public int hashCode() {
            return this.hash;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("HostPort{host=\'");
            stringBuilder0.append(this.host);
            stringBuilder0.append("\', port=");
            return o.q(stringBuilder0, this.port, '}');
        }
    }

    static final boolean $assertionsDisabled;
    private final Map sessions;

    static {
    }

    public OpenSslClientSessionCache(OpenSslEngineMap openSslEngineMap0) {
        super(openSslEngineMap0);
        this.sessions = new HashMap();
    }

    @Override  // io.netty.handler.ssl.OpenSslSessionCache
    public void clear() {
        synchronized(this) {
            super.clear();
            this.sessions.clear();
        }
    }

    private static HostPort keyFor(String s, int v) {
        return s != null || v >= 1 ? new HostPort(s, v) : null;
    }

    @Override  // io.netty.handler.ssl.OpenSslSessionCache
    public boolean sessionCreated(NativeSslSession openSslSessionCache$NativeSslSession0) {
        HostPort openSslClientSessionCache$HostPort0 = OpenSslClientSessionCache.keyFor(openSslSessionCache$NativeSslSession0.getPeerHost(), openSslSessionCache$NativeSslSession0.getPeerPort());
        if(openSslClientSessionCache$HostPort0 != null && !this.sessions.containsKey(openSslClientSessionCache$HostPort0)) {
            this.sessions.put(openSslClientSessionCache$HostPort0, openSslSessionCache$NativeSslSession0);
            return true;
        }
        return false;
    }

    @Override  // io.netty.handler.ssl.OpenSslSessionCache
    public void sessionRemoved(NativeSslSession openSslSessionCache$NativeSslSession0) {
        HostPort openSslClientSessionCache$HostPort0 = OpenSslClientSessionCache.keyFor(openSslSessionCache$NativeSslSession0.getPeerHost(), openSslSessionCache$NativeSslSession0.getPeerPort());
        if(openSslClientSessionCache$HostPort0 == null) {
            return;
        }
        this.sessions.remove(openSslClientSessionCache$HostPort0);
    }

    @Override  // io.netty.handler.ssl.OpenSslSessionCache
    public void setSession(long v, String s, int v1) {
        NativeSslSession openSslSessionCache$NativeSslSession0;
        HostPort openSslClientSessionCache$HostPort0 = OpenSslClientSessionCache.keyFor(s, v1);
        if(openSslClientSessionCache$HostPort0 != null) {
            synchronized(this) {
                openSslSessionCache$NativeSslSession0 = (NativeSslSession)this.sessions.get(openSslClientSessionCache$HostPort0);
                if(openSslSessionCache$NativeSslSession0 == null) {
                    return;
                }
                if(!openSslSessionCache$NativeSslSession0.isValid()) {
                    this.removeSessionWithId(openSslSessionCache$NativeSslSession0.sessionId());
                    return;
                }
                boolean z = SSL.setSession(v, openSslSessionCache$NativeSslSession0.session());
            }
            if(z) {
                if(openSslSessionCache$NativeSslSession0.shouldBeSingleUse()) {
                    openSslSessionCache$NativeSslSession0.invalidate();
                }
                openSslSessionCache$NativeSslSession0.updateLastAccessedTime();
            }
        }
    }
}

