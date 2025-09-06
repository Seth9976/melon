package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    @Override  // io.netty.util.ReferenceCounted
    boolean release();

    @Override  // io.netty.util.ReferenceCounted
    boolean release(int arg1);

    OpenSslKeyMaterial retain();

    OpenSslKeyMaterial retain(int arg1);

    OpenSslKeyMaterial touch();

    OpenSslKeyMaterial touch(Object arg1);
}

