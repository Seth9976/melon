package io.netty.handler.ipfilter;

import java.net.InetSocketAddress;

public interface IpFilterRule {
    boolean matches(InetSocketAddress arg1);

    IpFilterRuleType ruleType();
}

