package com.melon.net;

import A7.d;
import U4.x;
import com.iloen.melon.utils.a;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001B"}, d2 = {"Lcom/melon/net/Timeout;", "", "connectMs", "", "writeMs", "readMs", "callMs", "<init>", "(JJJJ)V", "getConnectMs", "()J", "getWriteMs", "getReadMs", "getCallMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class Timeout {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/melon/net/Timeout$Companion;", "", "<init>", "()V", "CONNECT_TIME_OUT", "", "WRITE_TIME_OUT", "READ_TIME_OUT", "CALL_TIME_OUT", "default", "Lcom/melon/net/Timeout;", "getDefault", "()Lcom/melon/net/Timeout;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Timeout getDefault() {
            return Timeout.default;
        }
    }

    public static final int $stable = 0;
    private static final long CALL_TIME_OUT = 10000L;
    private static final long CONNECT_TIME_OUT = 10000L;
    @NotNull
    public static final Companion Companion = null;
    private static final long READ_TIME_OUT = 10000L;
    private static final long WRITE_TIME_OUT = 10000L;
    private final long callMs;
    private final long connectMs;
    @NotNull
    private static final Timeout default;
    private final long readMs;
    private final long writeMs;

    static {
        Timeout.Companion = new Companion(null);
        Timeout.default = new Timeout(10000L, 10000L, 10000L, 10000L);
    }

    public Timeout(long v, long v1, long v2, long v3) {
        this.connectMs = v;
        this.writeMs = v1;
        this.readMs = v2;
        this.callMs = v3;
    }

    public final long component1() {
        return this.connectMs;
    }

    public final long component2() {
        return this.writeMs;
    }

    public final long component3() {
        return this.readMs;
    }

    public final long component4() {
        return this.callMs;
    }

    @NotNull
    public final Timeout copy(long v, long v1, long v2, long v3) {
        return new Timeout(v, v1, v2, v3);
    }

    public static Timeout copy$default(Timeout timeout0, long v, long v1, long v2, long v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = timeout0.connectMs;
        }
        if((v4 & 2) != 0) {
            v1 = timeout0.writeMs;
        }
        if((v4 & 4) != 0) {
            v2 = timeout0.readMs;
        }
        return (v4 & 8) == 0 ? timeout0.copy(v, v1, v2, v3) : timeout0.copy(v, v1, v2, timeout0.callMs);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Timeout)) {
            return false;
        }
        if(this.connectMs != ((Timeout)object0).connectMs) {
            return false;
        }
        if(this.writeMs != ((Timeout)object0).writeMs) {
            return false;
        }
        return this.readMs == ((Timeout)object0).readMs ? this.callMs == ((Timeout)object0).callMs : false;
    }

    public final long getCallMs() {
        return this.callMs;
    }

    public final long getConnectMs() {
        return this.connectMs;
    }

    public final long getReadMs() {
        return this.readMs;
    }

    public final long getWriteMs() {
        return this.writeMs;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.callMs) + d.c(d.c(Long.hashCode(this.connectMs) * 0x1F, 0x1F, this.writeMs), 0x1F, this.readMs);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = Y.o(this.connectMs, "Timeout(connectMs=", ", writeMs=");
        stringBuilder0.append(this.writeMs);
        a.s(this.readMs, ", readMs=", ", callMs=", stringBuilder0);
        return x.h(this.callMs, ")", stringBuilder0);
    }
}

