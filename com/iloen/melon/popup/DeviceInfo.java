package com.iloen.melon.popup;

import ic.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000BJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/popup/DeviceInfo;", "", "Lic/e;", "device", "", "displayName", "<init>", "(Lic/e;Ljava/lang/String;)V", "component1", "()Lic/e;", "component2", "()Ljava/lang/String;", "copy", "(Lic/e;Ljava/lang/String;)Lcom/iloen/melon/popup/DeviceInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lic/e;", "getDevice", "b", "Ljava/lang/String;", "getDisplayName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DeviceInfo {
    public static final int $stable;
    public final e a;
    public final String b;

    public DeviceInfo(@NotNull e e0, @NotNull String s) {
        q.g(e0, "device");
        q.g(s, "displayName");
        super();
        this.a = e0;
        this.b = s;
    }

    @NotNull
    public final e component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final DeviceInfo copy(@NotNull e e0, @NotNull String s) {
        q.g(e0, "device");
        q.g(s, "displayName");
        return new DeviceInfo(e0, s);
    }

    public static DeviceInfo copy$default(DeviceInfo deviceInfo0, e e0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            e0 = deviceInfo0.a;
        }
        if((v & 2) != 0) {
            s = deviceInfo0.b;
        }
        return deviceInfo0.copy(e0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DeviceInfo)) {
            return false;
        }
        return q.b(this.a, ((DeviceInfo)object0).a) ? q.b(this.b, ((DeviceInfo)object0).b) : false;
    }

    @NotNull
    public final e getDevice() {
        return this.a;
    }

    @NotNull
    public final String getDisplayName() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "DeviceInfo(device=" + this.a + ", displayName=" + this.b + ")";
    }
}

