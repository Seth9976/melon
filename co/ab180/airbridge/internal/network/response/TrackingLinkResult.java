package co.ab180.airbridge.internal.network.response;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(b0.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001A\u00020\u00002\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001E\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004R\u001E\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001A\u0004\b\u0016\u0010\u0004R\u001E\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001A\u0004\b\u0017\u0010\u0004¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "appName", "deeplink", "fallback", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeeplink", "getFallback", "getAppName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class TrackingLinkResult {
    @d("appName")
    @Nullable
    private final String appName;
    @d("deeplink")
    @Nullable
    private final String deeplink;
    @d("fallback")
    @Nullable
    private final String fallback;

    public TrackingLinkResult(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        this.appName = s;
        this.deeplink = s1;
        this.fallback = s2;
    }

    @Nullable
    public final String component1() {
        return this.appName;
    }

    @Nullable
    public final String component2() {
        return this.deeplink;
    }

    @Nullable
    public final String component3() {
        return this.fallback;
    }

    @NotNull
    public final TrackingLinkResult copy(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        return new TrackingLinkResult(s, s1, s2);
    }

    public static TrackingLinkResult copy$default(TrackingLinkResult trackingLinkResult0, String s, String s1, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = trackingLinkResult0.appName;
        }
        if((v & 2) != 0) {
            s1 = trackingLinkResult0.deeplink;
        }
        if((v & 4) != 0) {
            s2 = trackingLinkResult0.fallback;
        }
        return trackingLinkResult0.copy(s, s1, s2);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof TrackingLinkResult && q.b(this.appName, ((TrackingLinkResult)object0).appName) && q.b(this.deeplink, ((TrackingLinkResult)object0).deeplink) && q.b(this.fallback, ((TrackingLinkResult)object0).fallback);
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final String getFallback() {
        return this.fallback;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.appName == null ? 0 : this.appName.hashCode();
        int v2 = this.deeplink == null ? 0 : this.deeplink.hashCode();
        String s = this.fallback;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TrackingLinkResult(appName=");
        stringBuilder0.append(this.appName);
        stringBuilder0.append(", deeplink=");
        stringBuilder0.append(this.deeplink);
        stringBuilder0.append(", fallback=");
        return x.m(stringBuilder0, this.fallback, ")");
    }
}

