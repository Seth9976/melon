package io.netty.handler.ipfilter;

import java.net.InetSocketAddress;
import java.util.Comparator;

final class IpSubnetFilterRuleComparator implements Comparator {
    static final IpSubnetFilterRuleComparator INSTANCE;

    static {
        IpSubnetFilterRuleComparator.INSTANCE = new IpSubnetFilterRuleComparator();
    }

    @Override
    public int compare(Object object0, Object object1) {
        return ((IpSubnetFilterRule)object0).compareTo(((InetSocketAddress)object1));
    }
}

