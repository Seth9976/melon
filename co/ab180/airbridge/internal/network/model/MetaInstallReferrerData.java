package co.ab180.airbridge.internal.network.model;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(t.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001F\u0010 J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000B\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\u0004J@\u0010\u0010\u001A\u00020\u00002\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001A\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001E\u0010\u000E\u001A\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000E\u0010\u0019\u001A\u0004\b\u000E\u0010\nR\u001E\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001A\u001A\u0004\b\u001B\u0010\u0004R\u001E\u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001C\u001A\u0004\b\u001D\u0010\u0007R\u001E\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000F\u0010\u001A\u001A\u0004\b\u001E\u0010\u0004¨\u0006!"}, d2 = {"Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/Integer;", "component4", "referrer", "actualTimestampSeconds", "isCT", "error", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "Ljava/lang/String;", "getReferrer", "Ljava/lang/Long;", "getActualTimestampSeconds", "getError", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class MetaInstallReferrerData {
    @d("actualTimestampSeconds")
    @Nullable
    private final Long actualTimestampSeconds;
    @d("error")
    @Nullable
    private final String error;
    @d("isCT")
    @Nullable
    private final Integer isCT;
    @d("installReferrer")
    @Nullable
    private final String referrer;

    public MetaInstallReferrerData(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0, @Nullable String s1) {
        this.referrer = s;
        this.actualTimestampSeconds = long0;
        this.isCT = integer0;
        this.error = s1;
    }

    @Nullable
    public final String component1() {
        return this.referrer;
    }

    @Nullable
    public final Long component2() {
        return this.actualTimestampSeconds;
    }

    @Nullable
    public final Integer component3() {
        return this.isCT;
    }

    @Nullable
    public final String component4() {
        return this.error;
    }

    @NotNull
    public final MetaInstallReferrerData copy(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0, @Nullable String s1) {
        return new MetaInstallReferrerData(s, long0, integer0, s1);
    }

    public static MetaInstallReferrerData copy$default(MetaInstallReferrerData metaInstallReferrerData0, String s, Long long0, Integer integer0, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = metaInstallReferrerData0.referrer;
        }
        if((v & 2) != 0) {
            long0 = metaInstallReferrerData0.actualTimestampSeconds;
        }
        if((v & 4) != 0) {
            integer0 = metaInstallReferrerData0.isCT;
        }
        if((v & 8) != 0) {
            s1 = metaInstallReferrerData0.error;
        }
        return metaInstallReferrerData0.copy(s, long0, integer0, s1);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof MetaInstallReferrerData && q.b(this.referrer, ((MetaInstallReferrerData)object0).referrer) && q.b(this.actualTimestampSeconds, ((MetaInstallReferrerData)object0).actualTimestampSeconds) && q.b(this.isCT, ((MetaInstallReferrerData)object0).isCT) && q.b(this.error, ((MetaInstallReferrerData)object0).error);
    }

    @Nullable
    public final Long getActualTimestampSeconds() {
        return this.actualTimestampSeconds;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final String getReferrer() {
        return this.referrer;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.referrer == null ? 0 : this.referrer.hashCode();
        int v2 = this.actualTimestampSeconds == null ? 0 : this.actualTimestampSeconds.hashCode();
        int v3 = this.isCT == null ? 0 : this.isCT.hashCode();
        String s = this.error;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Nullable
    public final Integer isCT() {
        return this.isCT;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MetaInstallReferrerData(referrer=");
        stringBuilder0.append(this.referrer);
        stringBuilder0.append(", actualTimestampSeconds=");
        stringBuilder0.append(this.actualTimestampSeconds);
        stringBuilder0.append(", isCT=");
        stringBuilder0.append(this.isCT);
        stringBuilder0.append(", error=");
        return x.m(stringBuilder0, this.error, ")");
    }
}

