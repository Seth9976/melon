package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

public final class ApplicationProtocolConfig {
    public static enum Protocol {
        NONE,
        NPN,
        ALPN,
        NPN_AND_ALPN;

    }

    public static enum SelectedListenerFailureBehavior {
        ACCEPT,
        FATAL_ALERT,
        CHOOSE_MY_LAST_PROTOCOL;

    }

    public static enum SelectorFailureBehavior {
        FATAL_ALERT,
        NO_ADVERTISE,
        CHOOSE_MY_LAST_PROTOCOL;

    }

    public static final ApplicationProtocolConfig DISABLED;
    private final Protocol protocol;
    private final SelectedListenerFailureBehavior selectedBehavior;
    private final SelectorFailureBehavior selectorBehavior;
    private final List supportedProtocols;

    static {
        ApplicationProtocolConfig.DISABLED = new ApplicationProtocolConfig();
    }

    private ApplicationProtocolConfig() {
        this.supportedProtocols = Collections.EMPTY_LIST;
        this.protocol = Protocol.NONE;
        this.selectorBehavior = SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        this.selectedBehavior = SelectedListenerFailureBehavior.ACCEPT;
    }

    public ApplicationProtocolConfig(Protocol applicationProtocolConfig$Protocol0, SelectorFailureBehavior applicationProtocolConfig$SelectorFailureBehavior0, SelectedListenerFailureBehavior applicationProtocolConfig$SelectedListenerFailureBehavior0, Iterable iterable0) {
        this(applicationProtocolConfig$Protocol0, applicationProtocolConfig$SelectorFailureBehavior0, applicationProtocolConfig$SelectedListenerFailureBehavior0, ApplicationProtocolUtil.toList(iterable0));
    }

    private ApplicationProtocolConfig(Protocol applicationProtocolConfig$Protocol0, SelectorFailureBehavior applicationProtocolConfig$SelectorFailureBehavior0, SelectedListenerFailureBehavior applicationProtocolConfig$SelectedListenerFailureBehavior0, List list0) {
        this.supportedProtocols = Collections.unmodifiableList(((List)ObjectUtil.checkNotNull(list0, "supportedProtocols")));
        this.protocol = (Protocol)ObjectUtil.checkNotNull(applicationProtocolConfig$Protocol0, "protocol");
        this.selectorBehavior = (SelectorFailureBehavior)ObjectUtil.checkNotNull(applicationProtocolConfig$SelectorFailureBehavior0, "selectorBehavior");
        this.selectedBehavior = (SelectedListenerFailureBehavior)ObjectUtil.checkNotNull(applicationProtocolConfig$SelectedListenerFailureBehavior0, "selectedBehavior");
        Protocol applicationProtocolConfig$Protocol1 = Protocol.NONE;
        if(applicationProtocolConfig$Protocol0 == applicationProtocolConfig$Protocol1) {
            throw new IllegalArgumentException("protocol (" + applicationProtocolConfig$Protocol1 + ") must not be " + applicationProtocolConfig$Protocol1 + '.');
        }
        ObjectUtil.checkNonEmpty(list0, "supportedProtocols");
    }

    public ApplicationProtocolConfig(Protocol applicationProtocolConfig$Protocol0, SelectorFailureBehavior applicationProtocolConfig$SelectorFailureBehavior0, SelectedListenerFailureBehavior applicationProtocolConfig$SelectedListenerFailureBehavior0, String[] arr_s) {
        this(applicationProtocolConfig$Protocol0, applicationProtocolConfig$SelectorFailureBehavior0, applicationProtocolConfig$SelectedListenerFailureBehavior0, ApplicationProtocolUtil.toList(arr_s));
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.selectedBehavior;
    }

    public SelectorFailureBehavior selectorFailureBehavior() {
        return this.selectorBehavior;
    }

    public List supportedProtocols() {
        return this.supportedProtocols;
    }
}

