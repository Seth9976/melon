package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

public abstract class DelegatingSslContext extends SslContext {
    private final SslContext ctx;

    public DelegatingSslContext(SslContext sslContext0) {
        this.ctx = (SslContext)ObjectUtil.checkNotNull(sslContext0, "ctx");
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.ctx.applicationProtocolNegotiator();
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final List cipherSuites() {
        return this.ctx.cipherSuites();
    }

    public abstract void initEngine(SSLEngine arg1);

    public void initHandler(SslHandler sslHandler0) {
        this.initEngine(sslHandler0.engine());
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.ctx.isClient();
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0) {
        SSLEngine sSLEngine0 = this.ctx.newEngine(byteBufAllocator0);
        this.initEngine(sSLEngine0);
        return sSLEngine0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator0, String s, int v) {
        SSLEngine sSLEngine0 = this.ctx.newEngine(byteBufAllocator0, s, v);
        this.initEngine(sSLEngine0);
        return sSLEngine0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        SslHandler sslHandler0 = this.ctx.newHandler(byteBufAllocator0, s, v, z);
        this.initHandler(sslHandler0);
        return sslHandler0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z, Executor executor0) {
        SslHandler sslHandler0 = this.ctx.newHandler(byteBufAllocator0, s, v, z, executor0);
        this.initHandler(sslHandler0);
        return sslHandler0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z) {
        SslHandler sslHandler0 = this.ctx.newHandler(byteBufAllocator0, z);
        this.initHandler(sslHandler0);
        return sslHandler0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z, Executor executor0) {
        SslHandler sslHandler0 = this.ctx.newHandler(byteBufAllocator0, z, executor0);
        this.initHandler(sslHandler0);
        return sslHandler0;
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.ctx.sessionCacheSize();
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return this.ctx.sessionContext();
    }

    @Override  // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.ctx.sessionTimeout();
    }
}

