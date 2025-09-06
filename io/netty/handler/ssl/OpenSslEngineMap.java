package io.netty.handler.ssl;

interface OpenSslEngineMap {
    void add(ReferenceCountedOpenSslEngine arg1);

    ReferenceCountedOpenSslEngine get(long arg1);

    ReferenceCountedOpenSslEngine remove(long arg1);
}

