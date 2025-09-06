package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    public OpenSslEngine(OpenSslContext openSslContext0, ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        super(openSslContext0, byteBufAllocator0, s, v, z, false);
    }

    @Override
    public void finalize() {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}

