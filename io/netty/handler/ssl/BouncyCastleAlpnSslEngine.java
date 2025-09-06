package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslEngine extends JdkAlpnSslEngine {
    public BouncyCastleAlpnSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
        super(sSLEngine0, jdkApplicationProtocolNegotiator0, z, new io.netty.handler.ssl.BouncyCastleAlpnSslEngine.1(), new io.netty.handler.ssl.BouncyCastleAlpnSslEngine.2());

        class io.netty.handler.ssl.BouncyCastleAlpnSslEngine.1 implements BiConsumer {
            @Override
            public void accept(Object object0, Object object1) {
                this.accept(((SSLEngine)object0), ((AlpnSelector)object1));
            }

            public void accept(SSLEngine sSLEngine0, AlpnSelector jdkAlpnSslEngine$AlpnSelector0) {
                BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine0, jdkAlpnSslEngine$AlpnSelector0);
            }
        }


        class io.netty.handler.ssl.BouncyCastleAlpnSslEngine.2 implements BiConsumer {
            @Override
            public void accept(Object object0, Object object1) {
                this.accept(((SSLEngine)object0), ((List)object1));
            }

            public void accept(SSLEngine sSLEngine0, List list0) {
                BouncyCastleAlpnSslUtils.setApplicationProtocols(sSLEngine0, list0);
            }
        }

    }

    @Override  // io.netty.handler.ssl.JdkAlpnSslEngine
    public String getApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getApplicationProtocol(this.getWrappedEngine());
    }

    @Override  // io.netty.handler.ssl.JdkAlpnSslEngine
    public String getHandshakeApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocol(this.getWrappedEngine());
    }

    @Override  // io.netty.handler.ssl.JdkAlpnSslEngine
    public BiFunction getHandshakeApplicationProtocolSelector() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocolSelector(this.getWrappedEngine());
    }

    @Override  // io.netty.handler.ssl.JdkAlpnSslEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction biFunction0) {
        BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(this.getWrappedEngine(), biFunction0);
    }
}

