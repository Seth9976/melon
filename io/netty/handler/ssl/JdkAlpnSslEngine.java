package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
class JdkAlpnSslEngine extends JdkSslEngine {
    final class AlpnSelector implements BiFunction {
        static final boolean $assertionsDisabled;
        private boolean called;
        private final ProtocolSelector selector;

        public AlpnSelector(ProtocolSelector jdkApplicationProtocolNegotiator$ProtocolSelector0) {
            this.selector = jdkApplicationProtocolNegotiator$ProtocolSelector0;
        }

        @Override
        public Object apply(Object object0, Object object1) {
            return this.apply(((SSLEngine)object0), ((List)object1));
        }

        public String apply(SSLEngine sSLEngine0, List list0) {
            try {
                this.called = true;
                String s = this.selector.select(list0);
                return s == null ? "" : s;
            }
            catch(Exception unused_ex) {
                return null;
            }
        }

        public void checkUnsupported() {
            if(!this.called && JdkAlpnSslEngine.this.getApplicationProtocol().isEmpty()) {
                this.selector.unsupported();
            }
        }
    }

    static final boolean $assertionsDisabled;
    private final AlpnSelector alpnSelector;
    private final ProtocolSelectionListener selectionListener;

    public JdkAlpnSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
        this(sSLEngine0, jdkApplicationProtocolNegotiator0, z, new io.netty.handler.ssl.JdkAlpnSslEngine.1(), new io.netty.handler.ssl.JdkAlpnSslEngine.2());

        class io.netty.handler.ssl.JdkAlpnSslEngine.1 implements BiConsumer {
            @Override
            public void accept(Object object0, Object object1) {
                this.accept(((SSLEngine)object0), ((AlpnSelector)object1));
            }

            public void accept(SSLEngine sSLEngine0, AlpnSelector jdkAlpnSslEngine$AlpnSelector0) {
                JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine0, jdkAlpnSslEngine$AlpnSelector0);
            }
        }


        class io.netty.handler.ssl.JdkAlpnSslEngine.2 implements BiConsumer {
            @Override
            public void accept(Object object0, Object object1) {
                this.accept(((SSLEngine)object0), ((List)object1));
            }

            public void accept(SSLEngine sSLEngine0, List list0) {
                JdkAlpnSslUtils.setApplicationProtocols(sSLEngine0, list0);
            }
        }

    }

    public JdkAlpnSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z, BiConsumer biConsumer0, BiConsumer biConsumer1) {
        super(sSLEngine0);
        if(z) {
            this.selectionListener = null;
            AlpnSelector jdkAlpnSslEngine$AlpnSelector0 = new AlpnSelector(this, jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())));
            this.alpnSelector = jdkAlpnSslEngine$AlpnSelector0;
            biConsumer0.accept(sSLEngine0, jdkAlpnSslEngine$AlpnSelector0);
            return;
        }
        this.selectionListener = jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols());
        this.alpnSelector = null;
        biConsumer1.accept(sSLEngine0, jdkApplicationProtocolNegotiator0.protocols());
    }

    @Override  // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return JdkAlpnSslUtils.getApplicationProtocol(this.getWrappedEngine());
    }

    @Override  // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocol(this.getWrappedEngine());
    }

    @Override  // javax.net.ssl.SSLEngine
    public BiFunction getHandshakeApplicationProtocolSelector() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocolSelector(this.getWrappedEngine());
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public String getNegotiatedApplicationProtocol() {
        String s = this.getApplicationProtocol();
        return s != null && !s.isEmpty() ? s : null;
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction biFunction0) {
        JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(this.getWrappedEngine(), biFunction0);
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public void setNegotiatedApplicationProtocol(String s) {
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        return this.verifyProtocolSelection(super.unwrap(byteBuffer0, byteBuffer1));
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer) {
        return this.verifyProtocolSelection(super.unwrap(byteBuffer0, arr_byteBuffer));
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer, int v, int v1) {
        return this.verifyProtocolSelection(super.unwrap(byteBuffer0, arr_byteBuffer, v, v1));
    }

    private SSLEngineResult verifyProtocolSelection(SSLEngineResult sSLEngineResult0) {
        if(sSLEngineResult0.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            AlpnSelector jdkAlpnSslEngine$AlpnSelector0 = this.alpnSelector;
            if(jdkAlpnSslEngine$AlpnSelector0 == null) {
                try {
                    String s = this.getApplicationProtocol();
                    if(s.isEmpty()) {
                        this.selectionListener.unsupported();
                        return sSLEngineResult0;
                    }
                    this.selectionListener.selected(s);
                    return sSLEngineResult0;
                }
                catch(Throwable throwable0) {
                }
                throw SslUtils.toSSLHandshakeException(throwable0);
            }
            jdkAlpnSslEngine$AlpnSelector0.checkUnsupported();
        }
        return sSLEngineResult0;
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        return this.verifyProtocolSelection(super.wrap(byteBuffer0, byteBuffer1));
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult wrap(ByteBuffer[] arr_byteBuffer, int v, int v1, ByteBuffer byteBuffer0) {
        return this.verifyProtocolSelection(super.wrap(arr_byteBuffer, v, v1, byteBuffer0));
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public SSLEngineResult wrap(ByteBuffer[] arr_byteBuffer, ByteBuffer byteBuffer0) {
        return this.verifyProtocolSelection(super.wrap(arr_byteBuffer, byteBuffer0));
    }
}

