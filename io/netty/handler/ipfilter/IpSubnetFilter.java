package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Sharable
public class IpSubnetFilter extends AbstractRemoteAddressFilter {
    private final boolean acceptIfNotFound;
    private final IpFilterRuleType ipFilterRuleTypeIPv4;
    private final IpFilterRuleType ipFilterRuleTypeIPv6;
    private final List ipv4Rules;
    private final List ipv6Rules;

    public IpSubnetFilter(List list0) {
        this(true, list0);
    }

    public IpSubnetFilter(boolean z, List list0) {
        ObjectUtil.checkNotNull(list0, "rules");
        this.acceptIfNotFound = z;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        for(Object object0: list0) {
            IpSubnetFilterRule ipSubnetFilterRule0 = (IpSubnetFilterRule)object0;
            ObjectUtil.checkNotNull(ipSubnetFilterRule0, "rule");
            if(ipSubnetFilterRule0.getFilterRule() instanceof Ip4SubnetFilterRule) {
                arrayList0.add(ipSubnetFilterRule0);
                if(ipSubnetFilterRule0.ruleType() == IpFilterRuleType.ACCEPT) {
                    ++v;
                }
                else {
                    ++v1;
                }
            }
            else {
                arrayList1.add(ipSubnetFilterRule0);
                if(ipSubnetFilterRule0.ruleType() == IpFilterRuleType.ACCEPT) {
                    ++v3;
                }
                else {
                    ++v2;
                }
            }
        }
        if(v == 0 && v1 > 0) {
            this.ipFilterRuleTypeIPv4 = IpFilterRuleType.REJECT;
        }
        else if(v <= 0 || v1 != 0) {
            this.ipFilterRuleTypeIPv4 = null;
        }
        else {
            this.ipFilterRuleTypeIPv4 = IpFilterRuleType.ACCEPT;
        }
        if(v3 == 0 && v2 > 0) {
            this.ipFilterRuleTypeIPv6 = IpFilterRuleType.REJECT;
        }
        else if(v3 <= 0 || v2 != 0) {
            this.ipFilterRuleTypeIPv6 = null;
        }
        else {
            this.ipFilterRuleTypeIPv6 = IpFilterRuleType.ACCEPT;
        }
        this.ipv4Rules = IpSubnetFilter.sortAndFilter(arrayList0);
        this.ipv6Rules = IpSubnetFilter.sortAndFilter(arrayList1);
    }

    public IpSubnetFilter(boolean z, IpSubnetFilterRule[] arr_ipSubnetFilterRule) {
        this(z, Arrays.asList(((Object[])ObjectUtil.checkNotNull(arr_ipSubnetFilterRule, "rules"))));
    }

    public IpSubnetFilter(IpSubnetFilterRule[] arr_ipSubnetFilterRule) {
        this(true, Arrays.asList(((Object[])ObjectUtil.checkNotNull(arr_ipSubnetFilterRule, "rules"))));
    }

    public boolean accept(ChannelHandlerContext channelHandlerContext0, InetSocketAddress inetSocketAddress0) {
        if(inetSocketAddress0.getAddress() instanceof Inet4Address) {
            int v = Collections.binarySearch(this.ipv4Rules, inetSocketAddress0, IpSubnetFilterRuleComparator.INSTANCE);
            if(v >= 0) {
                return this.ipFilterRuleTypeIPv4 == null ? ((IpSubnetFilterRule)this.ipv4Rules.get(v)).ruleType() == IpFilterRuleType.ACCEPT : this.ipFilterRuleTypeIPv4 == IpFilterRuleType.ACCEPT;
            }
        }
        else {
            int v1 = Collections.binarySearch(this.ipv6Rules, inetSocketAddress0, IpSubnetFilterRuleComparator.INSTANCE);
            if(v1 >= 0) {
                return this.ipFilterRuleTypeIPv6 == null ? ((IpSubnetFilterRule)this.ipv6Rules.get(v1)).ruleType() == IpFilterRuleType.ACCEPT : this.ipFilterRuleTypeIPv6 == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }

    @Override  // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0) {
        return this.accept(channelHandlerContext0, ((InetSocketAddress)socketAddress0));
    }

    private static List sortAndFilter(List list0) {
        IpSubnetFilterRule ipSubnetFilterRule0;
        Collections.sort(list0);
        Iterator iterator0 = list0.iterator();
        List list1 = new ArrayList();
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            ipSubnetFilterRule0 = (IpSubnetFilterRule)object0;
        }
        else {
            ipSubnetFilterRule0 = null;
        }
        if(ipSubnetFilterRule0 != null) {
            ((ArrayList)list1).add(ipSubnetFilterRule0);
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            IpSubnetFilterRule ipSubnetFilterRule1 = (IpSubnetFilterRule)object1;
            if(!ipSubnetFilterRule0.matches(new InetSocketAddress(ipSubnetFilterRule1.getIpAddress(), 1))) {
                ((ArrayList)list1).add(ipSubnetFilterRule1);
                ipSubnetFilterRule0 = ipSubnetFilterRule1;
            }
        }
        return list1;
    }
}

