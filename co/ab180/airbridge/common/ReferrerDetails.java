package co.ab180.airbridge.common;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u0007R\u0019\u0010\u000B\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001A\u001A\u0004\b\u001D\u0010\u0007¨\u0006 "}, d2 = {"Lco/ab180/airbridge/common/ReferrerDetails;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "installReferrer", "referrerClickTimestampSeconds", "installBeginTimestampSeconds", "copy", "(Ljava/lang/String;JJ)Lco/ab180/airbridge/common/ReferrerDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getInstallReferrer", "b", "J", "getReferrerClickTimestampSeconds", "c", "getInstallBeginTimestampSeconds", "<init>", "(Ljava/lang/String;JJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class ReferrerDetails {
    @NotNull
    private final String a;
    private final long b;
    private final long c;

    public ReferrerDetails(@NotNull String s, long v, long v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final ReferrerDetails copy(@NotNull String s, long v, long v1) {
        return new ReferrerDetails(s, v, v1);
    }

    public static ReferrerDetails copy$default(ReferrerDetails referrerDetails0, String s, long v, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = referrerDetails0.a;
        }
        if((v2 & 2) != 0) {
            v = referrerDetails0.b;
        }
        if((v2 & 4) != 0) {
            v1 = referrerDetails0.c;
        }
        return referrerDetails0.copy(s, v, v1);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof ReferrerDetails && q.b(this.a, ((ReferrerDetails)object0).a) && this.b == ((ReferrerDetails)object0).b && this.c == ((ReferrerDetails)object0).c;
    }

    public final long getInstallBeginTimestampSeconds() {
        return this.c;
    }

    @NotNull
    public final String getInstallReferrer() {
        return this.a;
    }

    public final long getReferrerClickTimestampSeconds() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.a == null ? Long.hashCode(this.c) + d.c(0, 0x1F, this.b) : Long.hashCode(this.c) + d.c(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ReferrerDetails(installReferrer=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        return x.h(this.c, ")", stringBuilder0);
    }
}

