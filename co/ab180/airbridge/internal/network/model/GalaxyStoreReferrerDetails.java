package co.ab180.airbridge.internal.network.model;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.i;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(i.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001C\u0010\t\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001A\u0004\b\u0017\u0010\u0004R\u001C\u0010\n\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001A\u0004\b\u0019\u0010\u0007R\u001C\u0010\u000B\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0018\u001A\u0004\b\u001A\u0010\u0007¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "referrer", "referrerClickTimestampSeconds", "installBeginTimestampSeconds", "copy", "(Ljava/lang/String;JJ)Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReferrer", "J", "getReferrerClickTimestampSeconds", "getInstallBeginTimestampSeconds", "<init>", "(Ljava/lang/String;JJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class GalaxyStoreReferrerDetails {
    @d("installBeginTimestampSeconds")
    private final long installBeginTimestampSeconds;
    @d("installReferrer")
    @NotNull
    private final String referrer;
    @d("referrerClickTimestampSeconds")
    private final long referrerClickTimestampSeconds;

    public GalaxyStoreReferrerDetails(@NotNull String s, long v, long v1) {
        this.referrer = s;
        this.referrerClickTimestampSeconds = v;
        this.installBeginTimestampSeconds = v1;
    }

    @NotNull
    public final String component1() {
        return this.referrer;
    }

    public final long component2() {
        return this.referrerClickTimestampSeconds;
    }

    public final long component3() {
        return this.installBeginTimestampSeconds;
    }

    @NotNull
    public final GalaxyStoreReferrerDetails copy(@NotNull String s, long v, long v1) {
        return new GalaxyStoreReferrerDetails(s, v, v1);
    }

    public static GalaxyStoreReferrerDetails copy$default(GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0, String s, long v, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = galaxyStoreReferrerDetails0.referrer;
        }
        if((v2 & 2) != 0) {
            v = galaxyStoreReferrerDetails0.referrerClickTimestampSeconds;
        }
        if((v2 & 4) != 0) {
            v1 = galaxyStoreReferrerDetails0.installBeginTimestampSeconds;
        }
        return galaxyStoreReferrerDetails0.copy(s, v, v1);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof GalaxyStoreReferrerDetails && q.b(this.referrer, ((GalaxyStoreReferrerDetails)object0).referrer) && this.referrerClickTimestampSeconds == ((GalaxyStoreReferrerDetails)object0).referrerClickTimestampSeconds && this.installBeginTimestampSeconds == ((GalaxyStoreReferrerDetails)object0).installBeginTimestampSeconds;
    }

    public final long getInstallBeginTimestampSeconds() {
        return this.installBeginTimestampSeconds;
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
        return this.referrer == null ? Long.hashCode(this.installBeginTimestampSeconds) + A7.d.c(0, 0x1F, this.referrerClickTimestampSeconds) : Long.hashCode(this.installBeginTimestampSeconds) + A7.d.c(this.referrer.hashCode() * 0x1F, 0x1F, this.referrerClickTimestampSeconds);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GalaxyStoreReferrerDetails(referrer=");
        stringBuilder0.append(this.referrer);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.referrerClickTimestampSeconds);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        return x.h(this.installBeginTimestampSeconds, ")", stringBuilder0);
    }
}

