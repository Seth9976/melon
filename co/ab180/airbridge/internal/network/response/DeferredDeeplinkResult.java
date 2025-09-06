package co.ab180.airbridge.internal.network.response;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(b.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001E\u0010\t\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007R\u001C\u0010\b\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001A\u0004\b\u0017\u0010\u0004¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/network/response/DeferredDeeplinkResult;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "timestamp", "deeplink", "copy", "(JLjava/lang/String;)Lco/ab180/airbridge/internal/network/response/DeferredDeeplinkResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeeplink", "J", "getTimestamp", "<init>", "(JLjava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class DeferredDeeplinkResult {
    @d("deeplink")
    @Nullable
    private final String deeplink;
    @d("at")
    private final long timestamp;

    public DeferredDeeplinkResult(long v, @Nullable String s) {
        this.timestamp = v;
        this.deeplink = s;
    }

    public final long component1() {
        return this.timestamp;
    }

    @Nullable
    public final String component2() {
        return this.deeplink;
    }

    @NotNull
    public final DeferredDeeplinkResult copy(long v, @Nullable String s) {
        return new DeferredDeeplinkResult(v, s);
    }

    public static DeferredDeeplinkResult copy$default(DeferredDeeplinkResult deferredDeeplinkResult0, long v, String s, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = deferredDeeplinkResult0.timestamp;
        }
        if((v1 & 2) != 0) {
            s = deferredDeeplinkResult0.deeplink;
        }
        return deferredDeeplinkResult0.copy(v, s);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof DeferredDeeplinkResult && this.timestamp == ((DeferredDeeplinkResult)object0).timestamp && q.b(this.deeplink, ((DeferredDeeplinkResult)object0).deeplink);
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int hashCode() {
        int v = Long.hashCode(this.timestamp);
        return this.deeplink == null ? v * 0x1F : v * 0x1F + this.deeplink.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeferredDeeplinkResult(timestamp=");
        stringBuilder0.append(this.timestamp);
        stringBuilder0.append(", deeplink=");
        return x.m(stringBuilder0, this.deeplink, ")");
    }
}

