package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

public final class OpenSslSessionStats {
    private final ReferenceCountedOpenSslContext context;

    public OpenSslSessionStats(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0) {
        this.context = referenceCountedOpenSslContext0;
    }

    public long accept() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionAccept(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long acceptGood() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionAcceptGood(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long acceptRenegotiate() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionAcceptRenegotiate(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long cacheFull() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionCacheFull(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long cbHits() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionCbHits(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long connect() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionConnect(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long connectGood() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionConnectGood(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long connectRenegotiate() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionConnectRenegotiate(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long hits() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionHits(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long misses() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionMisses(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long number() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionNumber(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long ticketKeyFail() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionTicketKeyFail(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long ticketKeyNew() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionTicketKeyNew(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long ticketKeyRenew() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionTicketKeyRenew(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long ticketKeyResume() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionTicketKeyResume(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }

    public long timeouts() {
        Lock lock0 = this.context.ctxLock.readLock();
        lock0.lock();
        try {
            return SSLContext.sessionTimeouts(this.context.ctx);
        }
        finally {
            lock0.unlock();
        }
    }
}

