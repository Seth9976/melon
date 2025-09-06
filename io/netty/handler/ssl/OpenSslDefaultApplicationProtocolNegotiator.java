package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.List;

@Deprecated
public final class OpenSslDefaultApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final ApplicationProtocolConfig config;

    public OpenSslDefaultApplicationProtocolNegotiator(ApplicationProtocolConfig applicationProtocolConfig0) {
        this.config = (ApplicationProtocolConfig)ObjectUtil.checkNotNull(applicationProtocolConfig0, "config");
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public Protocol protocol() {
        return this.config.protocol();
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List protocols() {
        return this.config.supportedProtocols();
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.config.selectedListenerFailureBehavior();
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public SelectorFailureBehavior selectorFailureBehavior() {
        return this.config.selectorFailureBehavior();
    }
}

