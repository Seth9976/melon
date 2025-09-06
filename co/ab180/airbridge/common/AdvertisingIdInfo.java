package co.ab180.airbridge.common;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0011\u001A\u00020\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\t\u0010\u0007¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/common/AdvertisingIdInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "id", "isLimitAdTrackingEnabled", "copy", "(Ljava/lang/String;Z)Lco/ab180/airbridge/common/AdvertisingIdInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getId", "b", "Z", "<init>", "(Ljava/lang/String;Z)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AdvertisingIdInfo {
    @NotNull
    private final String a;
    private final boolean b;

    public AdvertisingIdInfo(@NotNull String s, boolean z) {
        this.a = s;
        this.b = z;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final AdvertisingIdInfo copy(@NotNull String s, boolean z) {
        return new AdvertisingIdInfo(s, z);
    }

    public static AdvertisingIdInfo copy$default(AdvertisingIdInfo advertisingIdInfo0, String s, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = advertisingIdInfo0.a;
        }
        if((v & 2) != 0) {
            z = advertisingIdInfo0.b;
        }
        return advertisingIdInfo0.copy(s, z);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof AdvertisingIdInfo && q.b(this.a, ((AdvertisingIdInfo)object0).a) && this.b == ((AdvertisingIdInfo)object0).b;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = this.a == null ? 0 : this.a.hashCode();
        int v1 = this.b;
        if(v1) {
            v1 = 1;
        }
        return v * 0x1F + v1;
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.b;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AdvertisingIdInfo(id=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isLimitAdTrackingEnabled=");
        return o.s(stringBuilder0, this.b, ")");
    }
}

