package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.List;
import javax.net.ssl.SSLEngine;

@Deprecated
public final class JdkAlpnApplicationProtocolNegotiator extends JdkBaseApplicationProtocolNegotiator {
    static final class AlpnWrapper extends AllocatorAwareSslEngineWrapperFactory {
        private AlpnWrapper() {
        }

        public AlpnWrapper(io.netty.handler.ssl.JdkAlpnApplicationProtocolNegotiator.1 jdkAlpnApplicationProtocolNegotiator$10) {
        }

        // 去混淆评级： 低(24)
        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$AllocatorAwareSslEngineWrapperFactory
        public SSLEngine wrapSslEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
            if(Conscrypt.isEngineSupported(sSLEngine0)) {
                return z ? ConscryptAlpnSslEngine.newServerEngine(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0) : ConscryptAlpnSslEngine.newClientEngine(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0);
            }
            if(!BouncyCastle.isInUse(sSLEngine0)) {
                throw new UnsupportedOperationException("ALPN not supported. Unable to wrap SSLEngine of type \'" + sSLEngine0.getClass().getName() + "\')");
            }
            return new BouncyCastleAlpnSslEngine(sSLEngine0, jdkApplicationProtocolNegotiator0, z);
        }
    }

    static final class FailureWrapper extends AllocatorAwareSslEngineWrapperFactory {
        private FailureWrapper() {
        }

        public FailureWrapper(io.netty.handler.ssl.JdkAlpnApplicationProtocolNegotiator.1 jdkAlpnApplicationProtocolNegotiator$10) {
        }

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$AllocatorAwareSslEngineWrapperFactory
        public SSLEngine wrapSslEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
            throw new RuntimeException("ALPN unsupported. Is your classpath configured correctly? For Conscrypt, add the appropriate Conscrypt JAR to classpath and set the security provider. For Jetty-ALPN, see https://www.eclipse.org/jetty/documentation/current/alpn-chapter.html#alpn-starting");
        }
    }

    private static final SslEngineWrapperFactory ALPN_WRAPPER;
    private static final boolean AVAILABLE;

    // 去混淆评级： 低(43)
    static {
        JdkAlpnApplicationProtocolNegotiator.AVAILABLE = false;
        JdkAlpnApplicationProtocolNegotiator.ALPN_WRAPPER = new FailureWrapper(null);
    }

    public JdkAlpnApplicationProtocolNegotiator(ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, Iterable iterable0) {
        super(JdkAlpnApplicationProtocolNegotiator.ALPN_WRAPPER, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, iterable0);
    }

    public JdkAlpnApplicationProtocolNegotiator(ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, String[] arr_s) {
        super(JdkAlpnApplicationProtocolNegotiator.ALPN_WRAPPER, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, arr_s);
    }

    public JdkAlpnApplicationProtocolNegotiator(Iterable iterable0) {
        this(false, iterable0);
    }

    public JdkAlpnApplicationProtocolNegotiator(boolean z, Iterable iterable0) {
        this(z, z, iterable0);
    }

    // 去混淆评级： 低(20)
    public JdkAlpnApplicationProtocolNegotiator(boolean z, boolean z1, Iterable iterable0) {
        this((z1 ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTOR_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTOR_FACTORY), (z ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTION_LISTENER_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTION_LISTENER_FACTORY), iterable0);
    }

    // 去混淆评级： 低(20)
    public JdkAlpnApplicationProtocolNegotiator(boolean z, boolean z1, String[] arr_s) {
        this((z1 ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTOR_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTOR_FACTORY), (z ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTION_LISTENER_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTION_LISTENER_FACTORY), arr_s);
    }

    public JdkAlpnApplicationProtocolNegotiator(boolean z, String[] arr_s) {
        this(z, z, arr_s);
    }

    public JdkAlpnApplicationProtocolNegotiator(String[] arr_s) {
        this(false, arr_s);
    }

    public static boolean isAlpnSupported() {
        return JdkAlpnApplicationProtocolNegotiator.AVAILABLE;
    }

    @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator
    public ProtocolSelectionListenerFactory protocolListenerFactory() {
        return super.protocolListenerFactory();
    }

    @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator
    public ProtocolSelectorFactory protocolSelectorFactory() {
        return super.protocolSelectorFactory();
    }

    @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator
    public List protocols() {
        return super.protocols();
    }

    @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator
    public SslEngineWrapperFactory wrapperFactory() {
        return super.wrapperFactory();
    }

    class io.netty.handler.ssl.JdkAlpnApplicationProtocolNegotiator.1 {
    }

}

