package io.netty.channel.socket;

import io.netty.util.NetUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public enum InternetProtocolFamily {
    IPv4(Inet4Address.class, 1),
    IPv6(Inet6Address.class, 2);

    private final int addressNumber;
    private final Class addressType;

    private InternetProtocolFamily(Class class0, int v1) {
        this.addressType = class0;
        this.addressNumber = v1;
    }

    public int addressNumber() {
        return this.addressNumber;
    }

    public Class addressType() {
        return this.addressType;
    }

    public InetAddress localhost() {
        switch(io.netty.channel.socket.InternetProtocolFamily.1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[this.ordinal()]) {
            case 1: {
                return NetUtil.LOCALHOST4;
            }
            case 2: {
                return NetUtil.LOCALHOST6;
            }
            default: {
                throw new IllegalStateException("Unsupported family " + this);
            }
        }
    }

    public static InternetProtocolFamily of(InetAddress inetAddress0) {
        if(inetAddress0 instanceof Inet4Address) {
            return InternetProtocolFamily.IPv4;
        }
        if(!(inetAddress0 instanceof Inet6Address)) {
            throw new IllegalArgumentException("address " + inetAddress0 + " not supported");
        }
        return InternetProtocolFamily.IPv6;
    }

    class io.netty.channel.socket.InternetProtocolFamily.1 {
        static final int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] arr_v = new int[InternetProtocolFamily.values().length];
            io.netty.channel.socket.InternetProtocolFamily.1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily = arr_v;
            try {
                arr_v[InternetProtocolFamily.IPv4.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.channel.socket.InternetProtocolFamily.1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

