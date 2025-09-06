package io.netty.handler.ipfilter;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class IpSubnetFilterRule implements IpFilterRule, Comparable {
    static final class Ip4SubnetFilterRule implements IpFilterRule {
        private final int networkAddress;
        private final IpFilterRuleType ruleType;
        private final int subnetMask;

        private Ip4SubnetFilterRule(Inet4Address inet4Address0, int v, IpFilterRuleType ipFilterRuleType0) {
            if(v < 0 || v > 0x20) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", v));
            }
            int v1 = (int)(-1L << 0x20 - v);
            this.subnetMask = v1;
            this.networkAddress = NetUtil.ipv4AddressToInt(inet4Address0) & v1;
            this.ruleType = ipFilterRuleType0;
        }

        public Ip4SubnetFilterRule(Inet4Address inet4Address0, int v, IpFilterRuleType ipFilterRuleType0, io.netty.handler.ipfilter.IpSubnetFilterRule.1 ipSubnetFilterRule$10) {
            this(inet4Address0, v, ipFilterRuleType0);
        }

        public static int access$200(Ip4SubnetFilterRule ipSubnetFilterRule$Ip4SubnetFilterRule0) {
            return ipSubnetFilterRule$Ip4SubnetFilterRule0.networkAddress;
        }

        public static int access$400(Ip4SubnetFilterRule ipSubnetFilterRule$Ip4SubnetFilterRule0) {
            return ipSubnetFilterRule$Ip4SubnetFilterRule0.subnetMask;
        }

        @Override  // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress0) {
            InetAddress inetAddress0 = inetSocketAddress0.getAddress();
            return inetAddress0 instanceof Inet4Address && (NetUtil.ipv4AddressToInt(((Inet4Address)inetAddress0)) & this.subnetMask) == this.networkAddress;
        }

        private static int prefixToSubnetMask(int v) [...] // Inlined contents

        @Override  // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }
    }

    static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final boolean $assertionsDisabled;
        private static final BigInteger MINUS_ONE;
        private final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        static {
            Ip6SubnetFilterRule.MINUS_ONE = BigInteger.valueOf(-1L);
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address0, int v, IpFilterRuleType ipFilterRuleType0) {
            if(v < 0 || v > 0x80) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", v));
            }
            BigInteger bigInteger0 = Ip6SubnetFilterRule.prefixToSubnetMask(v);
            this.subnetMask = bigInteger0;
            this.networkAddress = Ip6SubnetFilterRule.ipToInt(inet6Address0).and(bigInteger0);
            this.ruleType = ipFilterRuleType0;
        }

        public Ip6SubnetFilterRule(Inet6Address inet6Address0, int v, IpFilterRuleType ipFilterRuleType0, io.netty.handler.ipfilter.IpSubnetFilterRule.1 ipSubnetFilterRule$10) {
            this(inet6Address0, v, ipFilterRuleType0);
        }

        public static BigInteger access$300(Ip6SubnetFilterRule ipSubnetFilterRule$Ip6SubnetFilterRule0) {
            return ipSubnetFilterRule$Ip6SubnetFilterRule0.networkAddress;
        }

        public static BigInteger access$500(Inet6Address inet6Address0) {
            return Ip6SubnetFilterRule.ipToInt(inet6Address0);
        }

        private static BigInteger ipToInt(Inet6Address inet6Address0) {
            return new BigInteger(inet6Address0.getAddress());
        }

        @Override  // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress0) {
            InetAddress inetAddress0 = inetSocketAddress0.getAddress();
            if(inetAddress0 instanceof Inet6Address) {
                BigInteger bigInteger0 = Ip6SubnetFilterRule.ipToInt(((Inet6Address)inetAddress0));
                return bigInteger0.and(this.subnetMask).equals(this.subnetMask) || bigInteger0.and(this.subnetMask).equals(this.networkAddress);
            }
            return false;
        }

        private static BigInteger prefixToSubnetMask(int v) {
            return Ip6SubnetFilterRule.MINUS_ONE.shiftLeft(0x80 - v);
        }

        @Override  // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }
    }

    private final IpFilterRule filterRule;
    private final String ipAddress;

    public IpSubnetFilterRule(String s, int v, IpFilterRuleType ipFilterRuleType0) {
        try {
            this.ipAddress = s;
            this.filterRule = IpSubnetFilterRule.selectFilterRule(SocketUtils.addressByName(s), v, ipFilterRuleType0);
        }
        catch(UnknownHostException unknownHostException0) {
            throw new IllegalArgumentException("ipAddress", unknownHostException0);
        }
    }

    public IpSubnetFilterRule(InetAddress inetAddress0, int v, IpFilterRuleType ipFilterRuleType0) {
        this.ipAddress = inetAddress0.getHostAddress();
        this.filterRule = IpSubnetFilterRule.selectFilterRule(inetAddress0, v, ipFilterRuleType0);
    }

    private static int compareInt(int v, int v1) {
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    // 去混淆评级： 低(20)
    public int compareTo(IpSubnetFilterRule ipSubnetFilterRule0) {
        return this.filterRule instanceof Ip4SubnetFilterRule ? IpSubnetFilterRule.compareInt(Ip4SubnetFilterRule.access$200(((Ip4SubnetFilterRule)this.filterRule)), Ip4SubnetFilterRule.access$200(((Ip4SubnetFilterRule)ipSubnetFilterRule0.filterRule))) : Ip6SubnetFilterRule.access$300(((Ip6SubnetFilterRule)this.filterRule)).compareTo(Ip6SubnetFilterRule.access$300(((Ip6SubnetFilterRule)ipSubnetFilterRule0.filterRule)));
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((IpSubnetFilterRule)object0));
    }

    // 去混淆评级： 低(20)
    public int compareTo(InetSocketAddress inetSocketAddress0) {
        return this.filterRule instanceof Ip4SubnetFilterRule ? IpSubnetFilterRule.compareInt(Ip4SubnetFilterRule.access$200(((Ip4SubnetFilterRule)this.filterRule)), NetUtil.ipv4AddressToInt(((Inet4Address)inetSocketAddress0.getAddress())) & Ip4SubnetFilterRule.access$400(((Ip4SubnetFilterRule)this.filterRule))) : Ip6SubnetFilterRule.access$300(((Ip6SubnetFilterRule)this.filterRule)).compareTo(Ip6SubnetFilterRule.access$500(((Inet6Address)inetSocketAddress0.getAddress())).and(Ip6SubnetFilterRule.access$300(((Ip6SubnetFilterRule)this.filterRule))));
    }

    public IpFilterRule getFilterRule() {
        return this.filterRule;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override  // io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress inetSocketAddress0) {
        return this.filterRule.matches(inetSocketAddress0);
    }

    @Override  // io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress0, int v, IpFilterRuleType ipFilterRuleType0) {
        ObjectUtil.checkNotNull(inetAddress0, "ipAddress");
        ObjectUtil.checkNotNull(ipFilterRuleType0, "ruleType");
        if(inetAddress0 instanceof Inet4Address) {
            return new Ip4SubnetFilterRule(((Inet4Address)inetAddress0), v, ipFilterRuleType0, null);
        }
        if(!(inetAddress0 instanceof Inet6Address)) {
            throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
        }
        return new Ip6SubnetFilterRule(((Inet6Address)inetAddress0), v, ipFilterRuleType0, null);
    }

    class io.netty.handler.ipfilter.IpSubnetFilterRule.1 {
    }

}

