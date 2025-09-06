package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.List;

@Deprecated
public final class OpenSslNpnApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final List protocols;

    public OpenSslNpnApplicationProtocolNegotiator(Iterable iterable0) {
        this.protocols = (List)ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(iterable0), "protocols");
    }

    public OpenSslNpnApplicationProtocolNegotiator(String[] arr_s) {
        this.protocols = (List)ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(arr_s), "protocols");
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public Protocol protocol() {
        return Protocol.NPN;
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List protocols() {
        return this.protocols;
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return SelectedListenerFailureBehavior.ACCEPT;
    }

    @Override  // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public SelectorFailureBehavior selectorFailureBehavior() {
        return SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
    }
}

