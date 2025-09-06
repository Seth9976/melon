package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import java.util.Map.Entry;
import javax.net.ssl.SSLEngine;

public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    public OpenSslContext(Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, int v, Certificate[] arr_certificate, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, arr_certificate, clientAuth0, arr_s, z, z1, false, arr_map$Entry);
    }

    public OpenSslContext(Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, int v, Certificate[] arr_certificate, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, openSslApplicationProtocolNegotiator0, v, arr_certificate, clientAuth0, arr_s, z, z1, false, arr_map$Entry);
    }

    @Override
    public final void finalize() {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        return new OpenSslEngine(this, byteBufAllocator0, s, v, z);
    }
}

