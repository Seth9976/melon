package io.netty.channel;

import io.netty.util.AbstractConstant;
import io.netty.util.Constant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;

public class ChannelOption extends AbstractConstant {
    public static final ChannelOption ALLOCATOR;
    public static final ChannelOption ALLOW_HALF_CLOSURE;
    public static final ChannelOption AUTO_CLOSE;
    public static final ChannelOption AUTO_READ;
    public static final ChannelOption CONNECT_TIMEOUT_MILLIS;
    @Deprecated
    public static final ChannelOption DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION;
    public static final ChannelOption IP_MULTICAST_ADDR;
    public static final ChannelOption IP_MULTICAST_IF;
    public static final ChannelOption IP_MULTICAST_LOOP_DISABLED;
    public static final ChannelOption IP_MULTICAST_TTL;
    public static final ChannelOption IP_TOS;
    @Deprecated
    public static final ChannelOption MAX_MESSAGES_PER_READ;
    public static final ChannelOption MAX_MESSAGES_PER_WRITE;
    public static final ChannelOption MESSAGE_SIZE_ESTIMATOR;
    public static final ChannelOption RCVBUF_ALLOCATOR;
    public static final ChannelOption SINGLE_EVENTEXECUTOR_PER_GROUP;
    public static final ChannelOption SO_BACKLOG;
    public static final ChannelOption SO_BROADCAST;
    public static final ChannelOption SO_KEEPALIVE;
    public static final ChannelOption SO_LINGER;
    public static final ChannelOption SO_RCVBUF;
    public static final ChannelOption SO_REUSEADDR;
    public static final ChannelOption SO_SNDBUF;
    public static final ChannelOption SO_TIMEOUT;
    public static final ChannelOption TCP_FASTOPEN;
    public static final ChannelOption TCP_FASTOPEN_CONNECT;
    public static final ChannelOption TCP_NODELAY;
    @Deprecated
    public static final ChannelOption WRITE_BUFFER_HIGH_WATER_MARK;
    @Deprecated
    public static final ChannelOption WRITE_BUFFER_LOW_WATER_MARK;
    public static final ChannelOption WRITE_BUFFER_WATER_MARK;
    public static final ChannelOption WRITE_SPIN_COUNT;
    private static final ConstantPool pool;

    static {
        ChannelOption.pool = new ConstantPool() {
            public ChannelOption newConstant(int v, String s) {
                return new ChannelOption(v, s, null);
            }

            @Override  // io.netty.util.ConstantPool
            public Constant newConstant(int v, String s) {
                return this.newConstant(v, s);
            }
        };
        ChannelOption.ALLOCATOR = ChannelOption.valueOf("ALLOCATOR");
        ChannelOption.RCVBUF_ALLOCATOR = ChannelOption.valueOf("RCVBUF_ALLOCATOR");
        ChannelOption.MESSAGE_SIZE_ESTIMATOR = ChannelOption.valueOf("MESSAGE_SIZE_ESTIMATOR");
        ChannelOption.CONNECT_TIMEOUT_MILLIS = ChannelOption.valueOf("CONNECT_TIMEOUT_MILLIS");
        ChannelOption.MAX_MESSAGES_PER_READ = ChannelOption.valueOf("MAX_MESSAGES_PER_READ");
        ChannelOption.MAX_MESSAGES_PER_WRITE = ChannelOption.valueOf("MAX_MESSAGES_PER_WRITE");
        ChannelOption.WRITE_SPIN_COUNT = ChannelOption.valueOf("WRITE_SPIN_COUNT");
        ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK = ChannelOption.valueOf("WRITE_BUFFER_HIGH_WATER_MARK");
        ChannelOption.WRITE_BUFFER_LOW_WATER_MARK = ChannelOption.valueOf("WRITE_BUFFER_LOW_WATER_MARK");
        ChannelOption.WRITE_BUFFER_WATER_MARK = ChannelOption.valueOf("WRITE_BUFFER_WATER_MARK");
        ChannelOption.ALLOW_HALF_CLOSURE = ChannelOption.valueOf("ALLOW_HALF_CLOSURE");
        ChannelOption.AUTO_READ = ChannelOption.valueOf("AUTO_READ");
        ChannelOption.AUTO_CLOSE = ChannelOption.valueOf("AUTO_CLOSE");
        ChannelOption.SO_BROADCAST = ChannelOption.valueOf("SO_BROADCAST");
        ChannelOption.SO_KEEPALIVE = ChannelOption.valueOf("SO_KEEPALIVE");
        ChannelOption.SO_SNDBUF = ChannelOption.valueOf("SO_SNDBUF");
        ChannelOption.SO_RCVBUF = ChannelOption.valueOf("SO_RCVBUF");
        ChannelOption.SO_REUSEADDR = ChannelOption.valueOf("SO_REUSEADDR");
        ChannelOption.SO_LINGER = ChannelOption.valueOf("SO_LINGER");
        ChannelOption.SO_BACKLOG = ChannelOption.valueOf("SO_BACKLOG");
        ChannelOption.SO_TIMEOUT = ChannelOption.valueOf("SO_TIMEOUT");
        ChannelOption.IP_TOS = ChannelOption.valueOf("IP_TOS");
        ChannelOption.IP_MULTICAST_ADDR = ChannelOption.valueOf("IP_MULTICAST_ADDR");
        ChannelOption.IP_MULTICAST_IF = ChannelOption.valueOf("IP_MULTICAST_IF");
        ChannelOption.IP_MULTICAST_TTL = ChannelOption.valueOf("IP_MULTICAST_TTL");
        ChannelOption.IP_MULTICAST_LOOP_DISABLED = ChannelOption.valueOf("IP_MULTICAST_LOOP_DISABLED");
        ChannelOption.TCP_NODELAY = ChannelOption.valueOf("TCP_NODELAY");
        ChannelOption.TCP_FASTOPEN_CONNECT = ChannelOption.valueOf("TCP_FASTOPEN_CONNECT");
        ChannelOption.TCP_FASTOPEN = ChannelOption.valueOf(ChannelOption.class, "TCP_FASTOPEN");
        ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION = ChannelOption.valueOf("DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION");
        ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP = ChannelOption.valueOf("SINGLE_EVENTEXECUTOR_PER_GROUP");
    }

    private ChannelOption(int v, String s) {
        super(v, s);
    }

    public ChannelOption(int v, String s, io.netty.channel.ChannelOption.1 channelOption$10) {
        this(v, s);
    }

    @Deprecated
    public ChannelOption(String s) {
        this(ChannelOption.pool.nextId(), s);
    }

    public static boolean exists(String s) {
        return ChannelOption.pool.exists(s);
    }

    @Deprecated
    public static ChannelOption newInstance(String s) {
        return (ChannelOption)ChannelOption.pool.newInstance(s);
    }

    public void validate(Object object0) {
        ObjectUtil.checkNotNull(object0, "value");
    }

    public static ChannelOption valueOf(Class class0, String s) {
        return (ChannelOption)ChannelOption.pool.valueOf(class0, s);
    }

    public static ChannelOption valueOf(String s) {
        return (ChannelOption)ChannelOption.pool.valueOf(s);
    }
}

