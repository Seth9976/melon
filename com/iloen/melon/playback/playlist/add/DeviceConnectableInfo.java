package com.iloen.melon.playback.playlist.add;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "", "canChromeCast", "", "canDlna", "<init>", "(ZZ)V", "getCanChromeCast", "()Z", "getCanDlna", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DeviceConnectableInfo {
    public static final int $stable;
    private final boolean canChromeCast;
    private final boolean canDlna;

    public DeviceConnectableInfo(boolean z, boolean z1) {
        this.canChromeCast = z;
        this.canDlna = z1;
    }

    public final boolean component1() {
        return this.canChromeCast;
    }

    public final boolean component2() {
        return this.canDlna;
    }

    @NotNull
    public final DeviceConnectableInfo copy(boolean z, boolean z1) {
        return new DeviceConnectableInfo(z, z1);
    }

    public static DeviceConnectableInfo copy$default(DeviceConnectableInfo deviceConnectableInfo0, boolean z, boolean z1, int v, Object object0) {
        if((v & 1) != 0) {
            z = deviceConnectableInfo0.canChromeCast;
        }
        if((v & 2) != 0) {
            z1 = deviceConnectableInfo0.canDlna;
        }
        return deviceConnectableInfo0.copy(z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DeviceConnectableInfo)) {
            return false;
        }
        return this.canChromeCast == ((DeviceConnectableInfo)object0).canChromeCast ? this.canDlna == ((DeviceConnectableInfo)object0).canDlna : false;
    }

    public final boolean getCanChromeCast() {
        return this.canChromeCast;
    }

    public final boolean getCanDlna() {
        return this.canDlna;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.canDlna) + Boolean.hashCode(this.canChromeCast) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "DeviceConnectableInfo(canChromeCast=" + this.canChromeCast + ", canDlna=" + this.canDlna + ")";
    }
}

