package com.iloen.melon.popup;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ.\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0017\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\nR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u0005\u0010\fR\u0017\u0010\u0006\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001D\u001A\u0004\b\u0006\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/popup/DeviceInfoWrapper;", "", "Lcom/iloen/melon/popup/DeviceInfo;", "deviceInfo", "", "isConnected", "isPlaying", "<init>", "(Lcom/iloen/melon/popup/DeviceInfo;ZZ)V", "component1", "()Lcom/iloen/melon/popup/DeviceInfo;", "component2", "()Z", "component3", "copy", "(Lcom/iloen/melon/popup/DeviceInfo;ZZ)Lcom/iloen/melon/popup/DeviceInfoWrapper;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/popup/DeviceInfo;", "getDeviceInfo", "b", "Z", "c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DeviceInfoWrapper {
    public static final int $stable;
    public final DeviceInfo a;
    public final boolean b;
    public final boolean c;

    public DeviceInfoWrapper(@NotNull DeviceInfo deviceInfo0, boolean z, boolean z1) {
        q.g(deviceInfo0, "deviceInfo");
        super();
        this.a = deviceInfo0;
        this.b = z;
        this.c = z1;
    }

    @NotNull
    public final DeviceInfo component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final DeviceInfoWrapper copy(@NotNull DeviceInfo deviceInfo0, boolean z, boolean z1) {
        q.g(deviceInfo0, "deviceInfo");
        return new DeviceInfoWrapper(deviceInfo0, z, z1);
    }

    public static DeviceInfoWrapper copy$default(DeviceInfoWrapper deviceInfoWrapper0, DeviceInfo deviceInfo0, boolean z, boolean z1, int v, Object object0) {
        if((v & 1) != 0) {
            deviceInfo0 = deviceInfoWrapper0.a;
        }
        if((v & 2) != 0) {
            z = deviceInfoWrapper0.b;
        }
        if((v & 4) != 0) {
            z1 = deviceInfoWrapper0.c;
        }
        return deviceInfoWrapper0.copy(deviceInfo0, z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DeviceInfoWrapper)) {
            return false;
        }
        if(!q.b(this.a, ((DeviceInfoWrapper)object0).a)) {
            return false;
        }
        return this.b == ((DeviceInfoWrapper)object0).b ? this.c == ((DeviceInfoWrapper)object0).c : false;
    }

    @NotNull
    public final DeviceInfo getDeviceInfo() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.c) + d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    public final boolean isConnected() {
        return this.b;
    }

    public final boolean isPlaying() {
        return this.c;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeviceInfoWrapper(deviceInfo=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isConnected=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isPlaying=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

