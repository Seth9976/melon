package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;

@Deprecated
public interface JdkApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {
    public static abstract class AllocatorAwareSslEngineWrapperFactory implements SslEngineWrapperFactory {
        public abstract SSLEngine wrapSslEngine(SSLEngine arg1, ByteBufAllocator arg2, JdkApplicationProtocolNegotiator arg3, boolean arg4);

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$SslEngineWrapperFactory
        public final SSLEngine wrapSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
            return this.wrapSslEngine(sSLEngine0, ByteBufAllocator.DEFAULT, jdkApplicationProtocolNegotiator0, z);
        }
    }

    public interface ProtocolSelectionListener {
        void selected(String arg1);

        void unsupported();
    }

    public interface ProtocolSelectionListenerFactory {
        ProtocolSelectionListener newListener(SSLEngine arg1, List arg2);
    }

    public interface ProtocolSelector {
        String select(List arg1);

        void unsupported();
    }

    public interface ProtocolSelectorFactory {
        ProtocolSelector newSelector(SSLEngine arg1, Set arg2);
    }

    public interface SslEngineWrapperFactory {
        SSLEngine wrapSslEngine(SSLEngine arg1, JdkApplicationProtocolNegotiator arg2, boolean arg3);
    }

    ProtocolSelectionListenerFactory protocolListenerFactory();

    ProtocolSelectorFactory protocolSelectorFactory();

    SslEngineWrapperFactory wrapperFactory();
}

