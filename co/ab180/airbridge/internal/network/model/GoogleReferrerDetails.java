package co.ab180.airbridge.internal.network.model;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.m;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(m.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\b\u0081\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000F\u001A\u00020\u0002\u0012\u0006\u0010\u0010\u001A\u00020\u0005\u0012\u0006\u0010\u0011\u001A\u00020\u0005\u0012\u0006\u0010\u0012\u001A\u00020\u0005\u0012\u0006\u0010\u0013\u001A\u00020\u0005\u0012\u0006\u0010\u0014\u001A\u00020\u000B\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u0004JX\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\u00052\b\b\u0002\u0010\u0013\u001A\u00020\u00052\b\b\u0002\u0010\u0014\u001A\u00020\u000B2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001A\u001A\u00020\u0019H\u00D6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001D\u001A\u00020\u000B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001ER\u001C\u0010\u000F\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u000F\u0010\u001F\u001A\u0004\b \u0010\u0004R\u001C\u0010\u0013\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0013\u0010!\u001A\u0004\b\"\u0010\u0007R\u001C\u0010\u0012\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0012\u0010!\u001A\u0004\b#\u0010\u0007R\u001E\u0010\u0015\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0015\u0010\u001F\u001A\u0004\b$\u0010\u0004R\u001C\u0010\u0010\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0010\u0010!\u001A\u0004\b%\u0010\u0007R\u001C\u0010\u0014\u001A\u00020\u000B8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0014\u0010&\u001A\u0004\b\'\u0010\rR\u001C\u0010\u0011\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0011\u0010!\u001A\u0004\b(\u0010\u0007\u00A8\u0006+"}, d2 = {"Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "component5", "", "component6", "()Z", "component7", "referrer", "referrerClickTimestampSeconds", "referrerClickTimestampServerSeconds", "installBeginTimestampSeconds", "installBeginTimestampServerSeconds", "googlePlayInstant", "installVersion", "copy", "(Ljava/lang/String;JJJJZLjava/lang/String;)Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReferrer", "J", "getInstallBeginTimestampServerSeconds", "getInstallBeginTimestampSeconds", "getInstallVersion", "getReferrerClickTimestampSeconds", "Z", "getGooglePlayInstant", "getReferrerClickTimestampServerSeconds", "<init>", "(Ljava/lang/String;JJJJZLjava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class GoogleReferrerDetails {
    @d("googlePlayInstant")
    private final boolean googlePlayInstant;
    @d("installBeginTimestampSeconds")
    private final long installBeginTimestampSeconds;
    @d("installBeginTimestampServerSeconds")
    private final long installBeginTimestampServerSeconds;
    @d("installVersion")
    @Nullable
    private final String installVersion;
    @d("installReferrer")
    @NotNull
    private final String referrer;
    @d("referrerClickTimestampSeconds")
    private final long referrerClickTimestampSeconds;
    @d("referrerClickTimestampServerSeconds")
    private final long referrerClickTimestampServerSeconds;

    public GoogleReferrerDetails(@NotNull String s, long v, long v1, long v2, long v3, boolean z, @Nullable String s1) {
        this.referrer = s;
        this.referrerClickTimestampSeconds = v;
        this.referrerClickTimestampServerSeconds = v1;
        this.installBeginTimestampSeconds = v2;
        this.installBeginTimestampServerSeconds = v3;
        this.googlePlayInstant = z;
        this.installVersion = s1;
    }

    @NotNull
    public final String component1() {
        return this.referrer;
    }

    public final long component2() {
        return this.referrerClickTimestampSeconds;
    }

    public final long component3() {
        return this.referrerClickTimestampServerSeconds;
    }

    public final long component4() {
        return this.installBeginTimestampSeconds;
    }

    public final long component5() {
        return this.installBeginTimestampServerSeconds;
    }

    public final boolean component6() {
        return this.googlePlayInstant;
    }

    @Nullable
    public final String component7() {
        return this.installVersion;
    }

    @NotNull
    public final GoogleReferrerDetails copy(@NotNull String s, long v, long v1, long v2, long v3, boolean z, @Nullable String s1) {
        return new GoogleReferrerDetails(s, v, v1, v2, v3, z, s1);
    }

    public static GoogleReferrerDetails copy$default(GoogleReferrerDetails googleReferrerDetails0, String s, long v, long v1, long v2, long v3, boolean z, String s1, int v4, Object object0) {
        if((v4 & 1) != 0) {
            s = googleReferrerDetails0.referrer;
        }
        if((v4 & 2) != 0) {
            v = googleReferrerDetails0.referrerClickTimestampSeconds;
        }
        if((v4 & 4) != 0) {
            v1 = googleReferrerDetails0.referrerClickTimestampServerSeconds;
        }
        if((v4 & 8) != 0) {
            v2 = googleReferrerDetails0.installBeginTimestampSeconds;
        }
        if((v4 & 16) != 0) {
            v3 = googleReferrerDetails0.installBeginTimestampServerSeconds;
        }
        if((v4 & 0x20) != 0) {
            z = googleReferrerDetails0.googlePlayInstant;
        }
        if((v4 & 0x40) != 0) {
            s1 = googleReferrerDetails0.installVersion;
        }
        return googleReferrerDetails0.copy(s, v, v1, v2, v3, z, s1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof GoogleReferrerDetails && q.b(this.referrer, ((GoogleReferrerDetails)object0).referrer) && this.referrerClickTimestampSeconds == ((GoogleReferrerDetails)object0).referrerClickTimestampSeconds && this.referrerClickTimestampServerSeconds == ((GoogleReferrerDetails)object0).referrerClickTimestampServerSeconds && this.installBeginTimestampSeconds == ((GoogleReferrerDetails)object0).installBeginTimestampSeconds && this.installBeginTimestampServerSeconds == ((GoogleReferrerDetails)object0).installBeginTimestampServerSeconds && this.googlePlayInstant == ((GoogleReferrerDetails)object0).googlePlayInstant && q.b(this.installVersion, ((GoogleReferrerDetails)object0).installVersion);
    }

    public final boolean getGooglePlayInstant() {
        return this.googlePlayInstant;
    }

    public final long getInstallBeginTimestampSeconds() {
        return this.installBeginTimestampSeconds;
    }

    public final long getInstallBeginTimestampServerSeconds() {
        return this.installBeginTimestampServerSeconds;
    }

    @Nullable
    public final String getInstallVersion() {
        return this.installVersion;
    }

    @NotNull
    public final String getReferrer() {
        return this.referrer;
    }

    public final long getReferrerClickTimestampSeconds() {
        return this.referrerClickTimestampSeconds;
    }

    public final long getReferrerClickTimestampServerSeconds() {
        return this.referrerClickTimestampServerSeconds;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = A7.d.c(A7.d.c(A7.d.c(A7.d.c((this.referrer == null ? 0 : this.referrer.hashCode()) * 0x1F, 0x1F, this.referrerClickTimestampSeconds), 0x1F, this.referrerClickTimestampServerSeconds), 0x1F, this.installBeginTimestampSeconds), 0x1F, this.installBeginTimestampServerSeconds);
        int v2 = this.googlePlayInstant;
        if(v2) {
            v2 = 1;
        }
        String s = this.installVersion;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GoogleReferrerDetails(referrer=");
        stringBuilder0.append(this.referrer);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.referrerClickTimestampSeconds);
        stringBuilder0.append(", referrerClickTimestampServerSeconds=");
        stringBuilder0.append(this.referrerClickTimestampServerSeconds);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        stringBuilder0.append(this.installBeginTimestampSeconds);
        stringBuilder0.append(", installBeginTimestampServerSeconds=");
        stringBuilder0.append(this.installBeginTimestampServerSeconds);
        stringBuilder0.append(", googlePlayInstant=");
        stringBuilder0.append(this.googlePlayInstant);
        stringBuilder0.append(", installVersion=");
        return x.m(stringBuilder0, this.installVersion, ")");
    }
}

