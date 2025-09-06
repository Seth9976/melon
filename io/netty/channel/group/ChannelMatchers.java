package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ServerChannel;

public final class ChannelMatchers {
    static final class ClassMatcher implements ChannelMatcher {
        private final Class clazz;

        public ClassMatcher(Class class0) {
            this.clazz = class0;
        }

        @Override  // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel0) {
            return this.clazz.isInstance(channel0);
        }
    }

    static final class CompositeMatcher implements ChannelMatcher {
        private final ChannelMatcher[] matchers;

        public CompositeMatcher(ChannelMatcher[] arr_channelMatcher) {
            this.matchers = arr_channelMatcher;
        }

        @Override  // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel0) {
            ChannelMatcher[] arr_channelMatcher = this.matchers;
            for(int v = 0; v < arr_channelMatcher.length; ++v) {
                if(!arr_channelMatcher[v].matches(channel0)) {
                    return false;
                }
            }
            return true;
        }
    }

    static final class InstanceMatcher implements ChannelMatcher {
        private final Channel channel;

        public InstanceMatcher(Channel channel0) {
            this.channel = channel0;
        }

        @Override  // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel0) {
            return this.channel == channel0;
        }
    }

    static final class InvertMatcher implements ChannelMatcher {
        private final ChannelMatcher matcher;

        public InvertMatcher(ChannelMatcher channelMatcher0) {
            this.matcher = channelMatcher0;
        }

        @Override  // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel0) {
            return !this.matcher.matches(channel0);
        }
    }

    private static final ChannelMatcher ALL_MATCHER;
    private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER;
    private static final ChannelMatcher SERVER_CHANNEL_MATCHER;

    static {
        ChannelMatchers.ALL_MATCHER = new ChannelMatcher() {
            @Override  // io.netty.channel.group.ChannelMatcher
            public boolean matches(Channel channel0) {
                return true;
            }
        };
        ChannelMatchers.SERVER_CHANNEL_MATCHER = ChannelMatchers.isInstanceOf(ServerChannel.class);
        ChannelMatchers.NON_SERVER_CHANNEL_MATCHER = ChannelMatchers.isNotInstanceOf(ServerChannel.class);
    }

    public static ChannelMatcher all() {
        return ChannelMatchers.ALL_MATCHER;
    }

    public static ChannelMatcher compose(ChannelMatcher[] arr_channelMatcher) {
        if(arr_channelMatcher.length < 1) {
            throw new IllegalArgumentException("matchers must at least contain one element");
        }
        return arr_channelMatcher.length == 1 ? arr_channelMatcher[0] : new CompositeMatcher(arr_channelMatcher);
    }

    public static ChannelMatcher invert(ChannelMatcher channelMatcher0) {
        return new InvertMatcher(channelMatcher0);
    }

    public static ChannelMatcher is(Channel channel0) {
        return new InstanceMatcher(channel0);
    }

    public static ChannelMatcher isInstanceOf(Class class0) {
        return new ClassMatcher(class0);
    }

    public static ChannelMatcher isNonServerChannel() {
        return ChannelMatchers.NON_SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher isNot(Channel channel0) {
        return ChannelMatchers.invert(ChannelMatchers.is(channel0));
    }

    public static ChannelMatcher isNotInstanceOf(Class class0) {
        return ChannelMatchers.invert(ChannelMatchers.isInstanceOf(class0));
    }

    public static ChannelMatcher isServerChannel() {
        return ChannelMatchers.SERVER_CHANNEL_MATCHER;
    }
}

