package io.netty.handler.ssl;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;

final class JdkDefaultApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    private static final SslEngineWrapperFactory DEFAULT_SSL_ENGINE_WRAPPER_FACTORY;
    public static final JdkDefaultApplicationProtocolNegotiator INSTANCE;

    static {
        JdkDefaultApplicationProtocolNegotiator.INSTANCE = new JdkDefaultApplicationProtocolNegotiator();
        JdkDefaultApplicationProtocolNegotiator.DEFAULT_SSL_ENGINE_WRAPPER_FACTORY = new SslEngineWrapperFactory() {
            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$SslEngineWrapperFactory
            public SSLEngine wrapSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
                return sSLEngine0;
            }
        };
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public ProtocolSelectionListenerFactory protocolListenerFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public ProtocolSelectorFactory protocolSelectorFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List protocols() {
        return Collections.EMPTY_LIST;
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public SslEngineWrapperFactory wrapperFactory() {
        return JdkDefaultApplicationProtocolNegotiator.DEFAULT_SSL_ENGINE_WRAPPER_FACTORY;
    }
}

