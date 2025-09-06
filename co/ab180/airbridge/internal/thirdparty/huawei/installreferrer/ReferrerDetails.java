package co.ab180.airbridge.internal.thirdparty.huawei.installreferrer;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(n.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001B\u0010\u001CJ\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001E\u0010\u000B\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007R\u001E\u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001A\u0004\b\u0018\u0010\u0007R\u001E\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001A\u0004\b\u001A\u0010\u0004¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", "installReferrer", "referrerClickTimestampMillis", "installBeginTimestampMillis", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getInstallBeginTimestampMillis", "getReferrerClickTimestampMillis", "Ljava/lang/String;", "getInstallReferrer", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class ReferrerDetails {
    @d("installTimestamp")
    @Nullable
    private final Long installBeginTimestampMillis;
    @d("channelInfo")
    @Nullable
    private final String installReferrer;
    @d("clickTimestamp")
    @Nullable
    private final Long referrerClickTimestampMillis;

    public ReferrerDetails(@Nullable String s, @Nullable Long long0, @Nullable Long long1) {
        this.installReferrer = s;
        this.referrerClickTimestampMillis = long0;
        this.installBeginTimestampMillis = long1;
    }

    @Nullable
    public final String component1() {
        return this.installReferrer;
    }

    @Nullable
    public final Long component2() {
        return this.referrerClickTimestampMillis;
    }

    @Nullable
    public final Long component3() {
        return this.installBeginTimestampMillis;
    }

    @NotNull
    public final ReferrerDetails copy(@Nullable String s, @Nullable Long long0, @Nullable Long long1) {
        return new ReferrerDetails(s, long0, long1);
    }

    public static ReferrerDetails copy$default(ReferrerDetails referrerDetails0, String s, Long long0, Long long1, int v, Object object0) {
        if((v & 1) != 0) {
            s = referrerDetails0.installReferrer;
        }
        if((v & 2) != 0) {
            long0 = referrerDetails0.referrerClickTimestampMillis;
        }
        if((v & 4) != 0) {
            long1 = referrerDetails0.installBeginTimestampMillis;
        }
        return referrerDetails0.copy(s, long0, long1);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof ReferrerDetails && q.b(this.installReferrer, ((ReferrerDetails)object0).installReferrer) && q.b(this.referrerClickTimestampMillis, ((ReferrerDetails)object0).referrerClickTimestampMillis) && q.b(this.installBeginTimestampMillis, ((ReferrerDetails)object0).installBeginTimestampMillis);
    }

    @Nullable
    public final Long getInstallBeginTimestampMillis() {
        return this.installBeginTimestampMillis;
    }

    @Nullable
    public final String getInstallReferrer() {
        return this.installReferrer;
    }

    @Nullable
    public final Long getReferrerClickTimestampMillis() {
        return this.referrerClickTimestampMillis;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.installReferrer == null ? 0 : this.installReferrer.hashCode();
        int v2 = this.referrerClickTimestampMillis == null ? 0 : this.referrerClickTimestampMillis.hashCode();
        Long long0 = this.installBeginTimestampMillis;
        if(long0 != null) {
            v = long0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "ReferrerDetails(installReferrer=" + this.installReferrer + ", referrerClickTimestampMillis=" + this.referrerClickTimestampMillis + ", installBeginTimestampMillis=" + this.installBeginTimestampMillis + ")";
    }
}

