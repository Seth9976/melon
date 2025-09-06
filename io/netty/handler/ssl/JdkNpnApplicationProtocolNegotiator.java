package io.netty.handler.ssl;

import java.util.List;
import javax.net.ssl.SSLEngine;

@Deprecated
public final class JdkNpnApplicationProtocolNegotiator extends JdkBaseApplicationProtocolNegotiator {
    private static final SslEngineWrapperFactory NPN_WRAPPER;

    static {
        JdkNpnApplicationProtocolNegotiator.NPN_WRAPPER = new SslEngineWrapperFactory() {
            {
                if(!JettyNpnSslEngine.isAvailable()) {
                    throw new RuntimeException("NPN unsupported. Is your classpath configured correctly? See https://wiki.eclipse.org/Jetty/Feature/NPN");
                }
            }

            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$SslEngineWrapperFactory
            public SSLEngine wrapSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
                return new JettyNpnSslEngine(sSLEngine0, jdkApplicationProtocolNegotiator0, z);
            }
        };
    }

    public JdkNpnApplicationProtocolNegotiator(ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, Iterable iterable0) {
        super(JdkNpnApplicationProtocolNegotiator.NPN_WRAPPER, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, iterable0);
    }

    public JdkNpnApplicationProtocolNegotiator(ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, String[] arr_s) {
        super(JdkNpnApplicationProtocolNegotiator.NPN_WRAPPER, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, arr_s);
    }

    public JdkNpnApplicationProtocolNegotiator(Iterable iterable0) {
        this(false, iterable0);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean z, Iterable iterable0) {
        this(z, z, iterable0);
    }

    // 去混淆评级： 低(20)
    public JdkNpnApplicationProtocolNegotiator(boolean z, boolean z1, Iterable iterable0) {
        this((z ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTOR_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTOR_FACTORY), (z1 ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTION_LISTENER_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTION_LISTENER_FACTORY), iterable0);
    }

    // 去混淆评级： 低(20)
    public JdkNpnApplicationProtocolNegotiator(boolean z, boolean z1, String[] arr_s) {
        this((z ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTOR_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTOR_FACTORY), (z1 ? JdkBaseApplicationProtocolNegotiator.FAIL_SELECTION_LISTENER_FACTORY : JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTION_LISTENER_FACTORY), arr_s);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean z, String[] arr_s) {
        this(z, z, arr_s);
    }

    public JdkNpnApplicationProtocolNegotiator(String[] arr_s) {
        this(false, arr_s);
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
}

