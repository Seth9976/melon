package io.netty.handler.ssl;

@Deprecated
public interface OpenSslApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {
    Protocol protocol();

    SelectedListenerFailureBehavior selectedListenerFailureBehavior();

    SelectorFailureBehavior selectorFailureBehavior();
}

