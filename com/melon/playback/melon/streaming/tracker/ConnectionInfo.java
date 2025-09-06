package com.melon.playback.melon.streaming.tracker;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;", "", "address", "", "protocol", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getProtocol", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ConnectionInfo {
    public static final int $stable;
    @NotNull
    private final String address;
    @NotNull
    private final String protocol;

    public ConnectionInfo(@NotNull String s, @NotNull String s1) {
        q.g(s, "address");
        q.g(s1, "protocol");
        super();
        this.address = s;
        this.protocol = s1;
    }

    @NotNull
    public final String component1() {
        return this.address;
    }

    @NotNull
    public final String component2() {
        return this.protocol;
    }

    @NotNull
    public final ConnectionInfo copy(@NotNull String s, @NotNull String s1) {
        q.g(s, "address");
        q.g(s1, "protocol");
        return new ConnectionInfo(s, s1);
    }

    public static ConnectionInfo copy$default(ConnectionInfo connectionInfo0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = connectionInfo0.address;
        }
        if((v & 2) != 0) {
            s1 = connectionInfo0.protocol;
        }
        return connectionInfo0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ConnectionInfo)) {
            return false;
        }
        return q.b(this.address, ((ConnectionInfo)object0).address) ? q.b(this.protocol, ((ConnectionInfo)object0).protocol) : false;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    @Override
    public int hashCode() {
        return this.protocol.hashCode() + this.address.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ConnectionInfo(address=" + this.address + ", protocol=" + this.protocol + ")";
    }
}

