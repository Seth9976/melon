package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(u.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0011\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u0002\u0012\u0006\u0010\u000F\u001A\u00020\u0002\u0012\u0006\u0010\u0010\u001A\u00020\u0007\u0012\u0006\u0010\u0011\u001A\u00020\u0007\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000B\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u000B\u0010\fJN\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\r\u001A\u00020\u00022\b\b\u0002\u0010\u000E\u001A\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u00072\b\b\u0002\u0010\u0011\u001A\u00020\u00072\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001A\u00020\u0016H\u00D6\u0001\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001A\u0010\u001A\u001A\u00020\u00072\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u001C\u0010\r\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\r\u0010\u001C\u001A\u0004\b\u001D\u0010\u0004R\u001E\u0010\u0012\u001A\u0004\u0018\u00010\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0012\u0010\u001E\u001A\u0004\b\u001F\u0010\fR\u001C\u0010\u000F\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u000F\u0010\u001C\u001A\u0004\b \u0010\u0004R\u001C\u0010\u0011\u001A\u00020\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0011\u0010!\u001A\u0004\b\"\u0010\tR\u001C\u0010\u0010\u001A\u00020\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0010\u0010!\u001A\u0004\b#\u0010\tR\u001C\u0010\u000E\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u000E\u0010\u001C\u001A\u0004\b$\u0010\u0004\u00A8\u0006\'"}, d2 = {"Lco/ab180/airbridge/internal/network/model/NetworkInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "component5", "component6", "()Ljava/lang/Boolean;", "carrier", "mobileCountryCode", "mobileNetworkCode", "cellular", "wifi", "bluetooth", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;)Lco/ab180/airbridge/internal/network/model/NetworkInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCarrier", "Ljava/lang/Boolean;", "getBluetooth", "getMobileNetworkCode", "Z", "getWifi", "getCellular", "getMobileCountryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkInfo {
    @d("bluetooth")
    @Nullable
    private final Boolean bluetooth;
    @d("carrier")
    @NotNull
    private final String carrier;
    @d("cellular")
    private final boolean cellular;
    @d("mcc")
    @NotNull
    private final String mobileCountryCode;
    @d("mnc")
    @NotNull
    private final String mobileNetworkCode;
    @d("wifi")
    private final boolean wifi;

    public NetworkInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, boolean z1, @Nullable Boolean boolean0) {
        this.carrier = s;
        this.mobileCountryCode = s1;
        this.mobileNetworkCode = s2;
        this.cellular = z;
        this.wifi = z1;
        this.bluetooth = boolean0;
    }

    @NotNull
    public final String component1() {
        return this.carrier;
    }

    @NotNull
    public final String component2() {
        return this.mobileCountryCode;
    }

    @NotNull
    public final String component3() {
        return this.mobileNetworkCode;
    }

    public final boolean component4() {
        return this.cellular;
    }

    public final boolean component5() {
        return this.wifi;
    }

    @Nullable
    public final Boolean component6() {
        return this.bluetooth;
    }

    @NotNull
    public final NetworkInfo copy(@NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, boolean z1, @Nullable Boolean boolean0) {
        return new NetworkInfo(s, s1, s2, z, z1, boolean0);
    }

    public static NetworkInfo copy$default(NetworkInfo networkInfo0, String s, String s1, String s2, boolean z, boolean z1, Boolean boolean0, int v, Object object0) {
        if((v & 1) != 0) {
            s = networkInfo0.carrier;
        }
        if((v & 2) != 0) {
            s1 = networkInfo0.mobileCountryCode;
        }
        if((v & 4) != 0) {
            s2 = networkInfo0.mobileNetworkCode;
        }
        if((v & 8) != 0) {
            z = networkInfo0.cellular;
        }
        if((v & 16) != 0) {
            z1 = networkInfo0.wifi;
        }
        if((v & 0x20) != 0) {
            boolean0 = networkInfo0.bluetooth;
        }
        return networkInfo0.copy(s, s1, s2, z, z1, boolean0);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof NetworkInfo && q.b(this.carrier, ((NetworkInfo)object0).carrier) && q.b(this.mobileCountryCode, ((NetworkInfo)object0).mobileCountryCode) && q.b(this.mobileNetworkCode, ((NetworkInfo)object0).mobileNetworkCode) && this.cellular == ((NetworkInfo)object0).cellular && this.wifi == ((NetworkInfo)object0).wifi && q.b(this.bluetooth, ((NetworkInfo)object0).bluetooth);
    }

    @Nullable
    public final Boolean getBluetooth() {
        return this.bluetooth;
    }

    @NotNull
    public final String getCarrier() {
        return this.carrier;
    }

    public final boolean getCellular() {
        return this.cellular;
    }

    @NotNull
    public final String getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    @NotNull
    public final String getMobileNetworkCode() {
        return this.mobileNetworkCode;
    }

    public final boolean getWifi() {
        return this.wifi;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.carrier == null ? 0 : this.carrier.hashCode();
        int v2 = this.mobileCountryCode == null ? 0 : this.mobileCountryCode.hashCode();
        int v3 = this.mobileNetworkCode == null ? 0 : this.mobileNetworkCode.hashCode();
        int v4 = this.cellular;
        int v5 = 1;
        if(v4) {
            v4 = 1;
        }
        if(!this.wifi) {
            v5 = false;
        }
        Boolean boolean0 = this.bluetooth;
        if(boolean0 != null) {
            v = boolean0.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "NetworkInfo(carrier=" + this.carrier + ", mobileCountryCode=" + this.mobileCountryCode + ", mobileNetworkCode=" + this.mobileNetworkCode + ", cellular=" + this.cellular + ", wifi=" + this.wifi + ", bluetooth=" + this.bluetooth + ")";
    }
}

