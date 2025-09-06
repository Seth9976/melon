package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import org.eclipse.jetty.npn.NextProtoNego.ClientProvider;
import org.eclipse.jetty.npn.NextProtoNego.Provider;
import org.eclipse.jetty.npn.NextProtoNego.ServerProvider;
import org.eclipse.jetty.npn.NextProtoNego;

final class JettyNpnSslEngine extends JdkSslEngine {
    private static boolean available;

    public JettyNpnSslEngine(SSLEngine sSLEngine0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, boolean z) {
        super(sSLEngine0);
        ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0, "applicationNegotiator");
        if(z) {
            NextProtoNego.put(sSLEngine0, ((NextProtoNego.Provider)new NextProtoNego.ServerProvider() {
                public void protocolSelected(String s) {
                    try {
                        ((ProtocolSelectionListener)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols()), "protocolListener")).selected(s);
                    }
                    catch(Throwable throwable0) {
                        PlatformDependent.throwException(throwable0);
                    }
                }

                public List protocols() {
                    return jdkApplicationProtocolNegotiator0.protocols();
                }

                public void unsupported() {
                    ((ProtocolSelectionListener)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols()), "protocolListener")).unsupported();
                }
            }));
            return;
        }
        NextProtoNego.put(sSLEngine0, ((NextProtoNego.Provider)new NextProtoNego.ClientProvider() {
            public String selectProtocol(List list0) {
                try {
                    return ((ProtocolSelector)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())), "protocolSelector")).select(list0);
                }
                catch(Throwable throwable0) {
                    PlatformDependent.throwException(throwable0);
                    return null;
                }
            }

            public boolean supports() {
                return true;
            }

            public void unsupported() {
                ((ProtocolSelector)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())), "protocolSelector")).unsupported();
            }
        }));
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public void closeInbound() {
        NextProtoNego.remove(this.getWrappedEngine());
        super.closeInbound();
    }

    @Override  // io.netty.handler.ssl.JdkSslEngine
    public void closeOutbound() {
        NextProtoNego.remove(this.getWrappedEngine());
        super.closeOutbound();
    }

    public static boolean isAvailable() {
        JettyNpnSslEngine.updateAvailability();
        return JettyNpnSslEngine.available;
    }

    private static void updateAvailability() {
        if(!JettyNpnSslEngine.available) {
            try {
                Class.forName("sun.security.ssl.NextProtoNegoExtension", true, null);
                JettyNpnSslEngine.available = true;
            }
            catch(Exception unused_ex) {
            }
        }
    }
}

