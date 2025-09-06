package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.UUID;

public final class LocalAddress extends SocketAddress implements Comparable {
    public static final LocalAddress ANY = null;
    private final String id;
    private static final long serialVersionUID = 0x4073FAD21FB18253L;
    private final String strVal;

    static {
        LocalAddress.ANY = new LocalAddress("ANY");
    }

    public LocalAddress(Channel channel0) {
        StringBuilder stringBuilder0 = new StringBuilder(16);
        stringBuilder0.append("local:E");
        stringBuilder0.append(Long.toHexString(((long)channel0.hashCode()) & 0xFFFFFFFFL | 0x100000000L));
        stringBuilder0.setCharAt(7, ':');
        this.id = stringBuilder0.substring(6);
        this.strVal = stringBuilder0.toString();
    }

    public LocalAddress(Class class0) {
        this(class0.getSimpleName() + '/' + UUID.randomUUID());
    }

    public LocalAddress(String s) {
        String s1 = ObjectUtil.checkNonEmptyAfterTrim(s, "id").toLowerCase();
        this.id = s1;
        this.strVal = "local:" + s1;
    }

    public int compareTo(LocalAddress localAddress0) {
        return this.id.compareTo(localAddress0.id);
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((LocalAddress)object0));
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LocalAddress ? this.id.equals(((LocalAddress)object0).id) : false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public String id() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.strVal;
    }
}

