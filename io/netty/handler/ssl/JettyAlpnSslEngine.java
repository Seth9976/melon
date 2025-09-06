package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import org.eclipse.jetty.alpn.ALPN.ClientProvider;
import org.eclipse.jetty.alpn.ALPN.Provider;
import org.eclipse.jetty.alpn.ALPN.ServerProvider;
import org.eclipse.jetty.alpn.ALPN;

abstract class JettyAlpnSslEngine extends JdkSslEngine {
    static final class ClientEngine extends JettyAlpnSslEngine {
        public ClientEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
            super(sSLEngine0, null);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0, "applicationNegotiator");
            ALPN.put(sSLEngine0, ((ALPN.Provider)new ALPN.ClientProvider() {
                public List protocols() {
                    return jdkApplicationProtocolNegotiator0.protocols();
                }

                public void selected(String s) {
                    try {
                        ((ProtocolSelectionListener)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols()), "protocolListener")).selected(s);
                    }
                    catch(Throwable throwable0) {
                        throw SslUtils.toSSLHandshakeException(throwable0);
                    }
                }

                public void unsupported() {
                    ((ProtocolSelectionListener)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols()), "protocolListener")).unsupported();
                }
            }));
        }

        @Override  // io.netty.handler.ssl.JdkSslEngine
        public void closeInbound() {
            try {
                ALPN.remove(this.getWrappedEngine());
            }
            finally {
                super.closeInbound();
            }
        }

        @Override  // io.netty.handler.ssl.JdkSslEngine
        public void closeOutbound() {
            try {
                ALPN.remove(this.getWrappedEngine());
            }
            finally {
                super.closeOutbound();
            }
        }
    }

    static final class ServerEngine extends JettyAlpnSslEngine {
        public ServerEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
            super(sSLEngine0, null);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0, "applicationNegotiator");
            ALPN.put(sSLEngine0, ((ALPN.Provider)new ALPN.ServerProvider() {
                public String select(List list0) {
                    try {
                        return ((ProtocolSelector)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())), "protocolSelector")).select(list0);
                    }
                    catch(Throwable throwable0) {
                        throw SslUtils.toSSLHandshakeException(throwable0);
                    }
                }

                public void unsupported() {
                    ((ProtocolSelector)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())), "protocolSelector")).unsupported();
                }
            }));
        }

        @Override  // io.netty.handler.ssl.JdkSslEngine
        public void closeInbound() {
            try {
                ALPN.remove(this.getWrappedEngine());
            }
            finally {
                super.closeInbound();
            }
        }

        @Override  // io.netty.handler.ssl.JdkSslEngine
        public void closeOutbound() {
            try {
                ALPN.remove(this.getWrappedEngine());
            }
            finally {
                super.closeOutbound();
            }
        }
    }

    private static final boolean available;

    static {
        JettyAlpnSslEngine.available = JettyAlpnSslEngine.initAvailable();
    }

    private JettyAlpnSslEngine(SSLEngine sSLEngine0) {
        super(sSLEngine0);
    }

    public JettyAlpnSslEngine(SSLEngine sSLEngine0, io.netty.handler.ssl.JettyAlpnSslEngine.1 jettyAlpnSslEngine$10) {
        this(sSLEngine0);
    }

    private static boolean initAvailable() {
        try {
            Class.forName("sun.security.ssl.ALPNExtension", true, null);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    public static boolean isAvailable() [...] // 潜在的解密器

    public static JettyAlpnSslEngine newClientEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
        return new ClientEngine(sSLEngine0, jdkApplicationProtocolNegotiator0);
    }

    public static JettyAlpnSslEngine newServerEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
        return new ServerEngine(sSLEngine0, jdkApplicationProtocolNegotiator0);
    }

    class io.netty.handler.ssl.JettyAlpnSslEngine.1 {
    }

}

