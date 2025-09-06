package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;

class JdkBaseApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    static final class FailProtocolSelectionListener extends NoFailProtocolSelectionListener {
        public FailProtocolSelectionListener(JdkSslEngine jdkSslEngine0, List list0) {
            super(jdkSslEngine0, list0);
        }

        @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator$NoFailProtocolSelectionListener
        public void noSelectedMatchFound(String s) {
            throw new SSLHandshakeException("No compatible protocols found");
        }
    }

    static final class FailProtocolSelector extends NoFailProtocolSelector {
        public FailProtocolSelector(JdkSslEngine jdkSslEngine0, Set set0) {
            super(jdkSslEngine0, set0);
        }

        @Override  // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator$NoFailProtocolSelector
        public String noSelectMatchFound() {
            throw new SSLHandshakeException("Selected protocol is not supported");
        }
    }

    static class NoFailProtocolSelectionListener implements ProtocolSelectionListener {
        private final JdkSslEngine engineWrapper;
        private final List supportedProtocols;

        public NoFailProtocolSelectionListener(JdkSslEngine jdkSslEngine0, List list0) {
            this.engineWrapper = jdkSslEngine0;
            this.supportedProtocols = list0;
        }

        public void noSelectedMatchFound(String s) {
        }

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListener
        public void selected(String s) {
            if(this.supportedProtocols.contains(s)) {
                this.engineWrapper.setNegotiatedApplicationProtocol(s);
                return;
            }
            this.noSelectedMatchFound(s);
        }

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListener
        public void unsupported() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
        }
    }

    static class NoFailProtocolSelector implements ProtocolSelector {
        private final JdkSslEngine engineWrapper;
        private final Set supportedProtocols;

        public NoFailProtocolSelector(JdkSslEngine jdkSslEngine0, Set set0) {
            this.engineWrapper = jdkSslEngine0;
            this.supportedProtocols = set0;
        }

        public String noSelectMatchFound() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
            return null;
        }

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelector
        public String select(List list0) {
            for(Object object0: this.supportedProtocols) {
                String s = (String)object0;
                if(list0.contains(s)) {
                    this.engineWrapper.setNegotiatedApplicationProtocol(s);
                    return s;
                }
                if(false) {
                    break;
                }
            }
            return this.noSelectMatchFound();
        }

        @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelector
        public void unsupported() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
        }
    }

    static final ProtocolSelectionListenerFactory FAIL_SELECTION_LISTENER_FACTORY;
    static final ProtocolSelectorFactory FAIL_SELECTOR_FACTORY;
    static final ProtocolSelectionListenerFactory NO_FAIL_SELECTION_LISTENER_FACTORY;
    static final ProtocolSelectorFactory NO_FAIL_SELECTOR_FACTORY;
    private final ProtocolSelectionListenerFactory listenerFactory;
    private final List protocols;
    private final ProtocolSelectorFactory selectorFactory;
    private final SslEngineWrapperFactory wrapperFactory;

    static {
        JdkBaseApplicationProtocolNegotiator.FAIL_SELECTOR_FACTORY = new ProtocolSelectorFactory() {
            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectorFactory
            public ProtocolSelector newSelector(SSLEngine sSLEngine0, Set set0) {
                return new FailProtocolSelector(((JdkSslEngine)sSLEngine0), set0);
            }
        };
        JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTOR_FACTORY = new ProtocolSelectorFactory() {
            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectorFactory
            public ProtocolSelector newSelector(SSLEngine sSLEngine0, Set set0) {
                return new NoFailProtocolSelector(((JdkSslEngine)sSLEngine0), set0);
            }
        };
        JdkBaseApplicationProtocolNegotiator.FAIL_SELECTION_LISTENER_FACTORY = new ProtocolSelectionListenerFactory() {
            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory
            public ProtocolSelectionListener newListener(SSLEngine sSLEngine0, List list0) {
                return new FailProtocolSelectionListener(((JdkSslEngine)sSLEngine0), list0);
            }
        };
        JdkBaseApplicationProtocolNegotiator.NO_FAIL_SELECTION_LISTENER_FACTORY = new ProtocolSelectionListenerFactory() {
            @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory
            public ProtocolSelectionListener newListener(SSLEngine sSLEngine0, List list0) {
                return new NoFailProtocolSelectionListener(((JdkSslEngine)sSLEngine0), list0);
            }
        };
    }

    public JdkBaseApplicationProtocolNegotiator(SslEngineWrapperFactory jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, Iterable iterable0) {
        this(jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, ApplicationProtocolUtil.toList(iterable0));
    }

    private JdkBaseApplicationProtocolNegotiator(SslEngineWrapperFactory jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, List list0) {
        this.wrapperFactory = (SslEngineWrapperFactory)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, "wrapperFactory");
        this.selectorFactory = (ProtocolSelectorFactory)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, "selectorFactory");
        this.listenerFactory = (ProtocolSelectionListenerFactory)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, "listenerFactory");
        this.protocols = Collections.unmodifiableList(((List)ObjectUtil.checkNotNull(list0, "protocols")));
    }

    public JdkBaseApplicationProtocolNegotiator(SslEngineWrapperFactory jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, ProtocolSelectorFactory jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, ProtocolSelectionListenerFactory jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, String[] arr_s) {
        this(jdkApplicationProtocolNegotiator$SslEngineWrapperFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectorFactory0, jdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory0, ApplicationProtocolUtil.toList(arr_s));
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public ProtocolSelectionListenerFactory protocolListenerFactory() {
        return this.listenerFactory;
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public ProtocolSelectorFactory protocolSelectorFactory() {
        return this.selectorFactory;
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List protocols() {
        return this.protocols;
    }

    @Override  // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public SslEngineWrapperFactory wrapperFactory() {
        return this.wrapperFactory;
    }
}

