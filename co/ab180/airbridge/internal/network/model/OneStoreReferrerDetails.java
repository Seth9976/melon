package co.ab180.airbridge.internal.network.model;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.e.v;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(v.class)
@d
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0006\u0012\u0006\u0010\r\u001A\u00020\u0006¢\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001C\u0010\u000B\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0018\u001A\u0004\b\u0019\u0010\u0004R\u001C\u0010\n\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001A\u0004\b\u001A\u0010\u0004R\u001C\u0010\r\u001A\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001B\u001A\u0004\b\u001C\u0010\bR\u001C\u0010\f\u001A\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001B\u001A\u0004\b\u001D\u0010\b¨\u0006 "}, d2 = {"Lco/ab180/airbridge/internal/network/model/OneStoreReferrerDetails;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "pid", "referrer", "referrerClickTimestampSeconds", "installBeginTimestampSeconds", "copy", "(Ljava/lang/String;Ljava/lang/String;JJ)Lco/ab180/airbridge/internal/network/model/OneStoreReferrerDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReferrer", "getPid", "J", "getInstallBeginTimestampSeconds", "getReferrerClickTimestampSeconds", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class OneStoreReferrerDetails {
    @co.ab180.airbridge.internal.parser.d("installBeginTimestampSeconds")
    private final long installBeginTimestampSeconds;
    @co.ab180.airbridge.internal.parser.d("oneStorePID")
    @NotNull
    private final String pid;
    @co.ab180.airbridge.internal.parser.d("installReferrer")
    @NotNull
    private final String referrer;
    @co.ab180.airbridge.internal.parser.d("referrerClickTimestampSeconds")
    private final long referrerClickTimestampSeconds;

    public OneStoreReferrerDetails(@NotNull String s, @NotNull String s1, long v, long v1) {
        this.pid = s;
        this.referrer = s1;
        this.referrerClickTimestampSeconds = v;
        this.installBeginTimestampSeconds = v1;
    }

    @NotNull
    public final String component1() {
        return this.pid;
    }

    @NotNull
    public final String component2() {
        return this.referrer;
    }

    public final long component3() {
        return this.referrerClickTimestampSeconds;
    }

    public final long component4() {
        return this.installBeginTimestampSeconds;
    }

    @NotNull
    public final OneStoreReferrerDetails copy(@NotNull String s, @NotNull String s1, long v, long v1) {
        return new OneStoreReferrerDetails(s, s1, v, v1);
    }

    public static OneStoreReferrerDetails copy$default(OneStoreReferrerDetails oneStoreReferrerDetails0, String s, String s1, long v, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = oneStoreReferrerDetails0.pid;
        }
        if((v2 & 2) != 0) {
            s1 = oneStoreReferrerDetails0.referrer;
        }
        if((v2 & 4) != 0) {
            v = oneStoreReferrerDetails0.referrerClickTimestampSeconds;
        }
        if((v2 & 8) != 0) {
            v1 = oneStoreReferrerDetails0.installBeginTimestampSeconds;
        }
        return oneStoreReferrerDetails0.copy(s, s1, v, v1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof OneStoreReferrerDetails && q.b(this.pid, ((OneStoreReferrerDetails)object0).pid) && q.b(this.referrer, ((OneStoreReferrerDetails)object0).referrer) && this.referrerClickTimestampSeconds == ((OneStoreReferrerDetails)object0).referrerClickTimestampSeconds && this.installBeginTimestampSeconds == ((OneStoreReferrerDetails)object0).installBeginTimestampSeconds;
    }

    public final long getInstallBeginTimestampSeconds() {
        return this.installBeginTimestampSeconds;
    }

    @NotNull
    public final String getPid() {
        return this.pid;
    }

    @NotNull
    public final String getReferrer() {
        return this.referrer;
    }

    public final long getReferrerClickTimestampSeconds() {
        return this.referrerClickTimestampSeconds;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.pid == null ? 0 : this.pid.hashCode();
        String s = this.referrer;
        if(s != null) {
            v = s.hashCode();
        }
        return Long.hashCode(this.installBeginTimestampSeconds) + A7.d.c((v1 * 0x1F + v) * 0x1F, 0x1F, this.referrerClickTimestampSeconds);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OneStoreReferrerDetails(pid=");
        stringBuilder0.append(this.pid);
        stringBuilder0.append(", referrer=");
        stringBuilder0.append(this.referrer);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.referrerClickTimestampSeconds);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        return x.h(this.installBeginTimestampSeconds, ")", stringBuilder0);
    }
}

