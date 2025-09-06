package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

@Sharable
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter {
    private final boolean acceptIfNotFound;
    private final List rules;

    public RuleBasedIpFilter(boolean z, IpFilterRule[] arr_ipFilterRule) {
        ObjectUtil.checkNotNull(arr_ipFilterRule, "rules");
        this.acceptIfNotFound = z;
        this.rules = new ArrayList(arr_ipFilterRule.length);
        for(int v = 0; v < arr_ipFilterRule.length; ++v) {
            IpFilterRule ipFilterRule0 = arr_ipFilterRule[v];
            if(ipFilterRule0 != null) {
                this.rules.add(ipFilterRule0);
            }
        }
    }

    public RuleBasedIpFilter(IpFilterRule[] arr_ipFilterRule) {
        this(true, arr_ipFilterRule);
    }

    public boolean accept(ChannelHandlerContext channelHandlerContext0, InetSocketAddress inetSocketAddress0) {
        for(Object object0: this.rules) {
            IpFilterRule ipFilterRule0 = (IpFilterRule)object0;
            if(ipFilterRule0.matches(inetSocketAddress0)) {
                return ipFilterRule0.ruleType() == IpFilterRuleType.ACCEPT;
            }
            if(false) {
                break;
            }
        }
        return this.acceptIfNotFound;
    }

    @Override  // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0) {
        return this.accept(channelHandlerContext0, ((InetSocketAddress)socketAddress0));
    }
}

