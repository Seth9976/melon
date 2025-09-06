package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(p.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000E\u001A\u00020\u00002\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0018\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001E\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001A\u001A\u0004\b\u001B\u0010\u0007R\u001E\u0010\r\u001A\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001C\u001A\u0004\b\u001D\u0010\nR\u001E\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u001E\u001A\u0004\b\u001F\u0010\u0004¨\u0006\""}, d2 = {"Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "", "Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "component1", "()Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;", "component2", "()Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;", "Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "component3", "()Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "googleReferrerDetails", "huaweiStoreReferrerDetails", "galaxyStoreReferrerDetails", "copy", "(Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;)Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;", "getHuaweiStoreReferrerDetails", "Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "getGalaxyStoreReferrerDetails", "Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "getGoogleReferrerDetails", "<init>", "(Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class InstallReferrerData {
    @d("galaxyStore")
    @Nullable
    private final GalaxyStoreReferrerDetails galaxyStoreReferrerDetails;
    @d("playStore")
    @Nullable
    private final GoogleReferrerDetails googleReferrerDetails;
    @d("huaweiStore")
    @Nullable
    private final HuaweiStoreReferrerDetails huaweiStoreReferrerDetails;

    public InstallReferrerData() {
        this(null, null, null, 7, null);
    }

    public InstallReferrerData(@Nullable GoogleReferrerDetails googleReferrerDetails0, @Nullable HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0, @Nullable GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0) {
        this.googleReferrerDetails = googleReferrerDetails0;
        this.huaweiStoreReferrerDetails = huaweiStoreReferrerDetails0;
        this.galaxyStoreReferrerDetails = galaxyStoreReferrerDetails0;
    }

    public InstallReferrerData(GoogleReferrerDetails googleReferrerDetails0, HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0, GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            googleReferrerDetails0 = null;
        }
        if((v & 2) != 0) {
            huaweiStoreReferrerDetails0 = null;
        }
        if((v & 4) != 0) {
            galaxyStoreReferrerDetails0 = null;
        }
        this(googleReferrerDetails0, huaweiStoreReferrerDetails0, galaxyStoreReferrerDetails0);
    }

    @Nullable
    public final GoogleReferrerDetails component1() {
        return this.googleReferrerDetails;
    }

    @Nullable
    public final HuaweiStoreReferrerDetails component2() {
        return this.huaweiStoreReferrerDetails;
    }

    @Nullable
    public final GalaxyStoreReferrerDetails component3() {
        return this.galaxyStoreReferrerDetails;
    }

    @NotNull
    public final InstallReferrerData copy(@Nullable GoogleReferrerDetails googleReferrerDetails0, @Nullable HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0, @Nullable GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0) {
        return new InstallReferrerData(googleReferrerDetails0, huaweiStoreReferrerDetails0, galaxyStoreReferrerDetails0);
    }

    public static InstallReferrerData copy$default(InstallReferrerData installReferrerData0, GoogleReferrerDetails googleReferrerDetails0, HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0, GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0, int v, Object object0) {
        if((v & 1) != 0) {
            googleReferrerDetails0 = installReferrerData0.googleReferrerDetails;
        }
        if((v & 2) != 0) {
            huaweiStoreReferrerDetails0 = installReferrerData0.huaweiStoreReferrerDetails;
        }
        if((v & 4) != 0) {
            galaxyStoreReferrerDetails0 = installReferrerData0.galaxyStoreReferrerDetails;
        }
        return installReferrerData0.copy(googleReferrerDetails0, huaweiStoreReferrerDetails0, galaxyStoreReferrerDetails0);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof InstallReferrerData && q.b(this.googleReferrerDetails, ((InstallReferrerData)object0).googleReferrerDetails) && q.b(this.huaweiStoreReferrerDetails, ((InstallReferrerData)object0).huaweiStoreReferrerDetails) && q.b(this.galaxyStoreReferrerDetails, ((InstallReferrerData)object0).galaxyStoreReferrerDetails);
    }

    @Nullable
    public final GalaxyStoreReferrerDetails getGalaxyStoreReferrerDetails() {
        return this.galaxyStoreReferrerDetails;
    }

    @Nullable
    public final GoogleReferrerDetails getGoogleReferrerDetails() {
        return this.googleReferrerDetails;
    }

    @Nullable
    public final HuaweiStoreReferrerDetails getHuaweiStoreReferrerDetails() {
        return this.huaweiStoreReferrerDetails;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.googleReferrerDetails == null ? 0 : this.googleReferrerDetails.hashCode();
        int v2 = this.huaweiStoreReferrerDetails == null ? 0 : this.huaweiStoreReferrerDetails.hashCode();
        GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0 = this.galaxyStoreReferrerDetails;
        if(galaxyStoreReferrerDetails0 != null) {
            v = galaxyStoreReferrerDetails0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "InstallReferrerData(googleReferrerDetails=" + this.googleReferrerDetails + ", huaweiStoreReferrerDetails=" + this.huaweiStoreReferrerDetails + ", galaxyStoreReferrerDetails=" + this.galaxyStoreReferrerDetails + ")";
    }
}

