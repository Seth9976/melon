package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, OpenSslKeyMaterialProvider openSslKeyMaterialProvider0) {
        super(referenceCountedOpenSslContext0, openSslKeyMaterialProvider0, SSL.SSL_SESS_CACHE_SERVER, new OpenSslSessionCache(referenceCountedOpenSslContext0.engineMap));
    }

    public boolean setSessionIdContext(byte[] arr_b) {
        Lock lock0 = this.context.ctxLock.writeLock();
        lock0.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, arr_b);
        }
        finally {
            lock0.unlock();
        }
    }
}

