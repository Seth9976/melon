package com.iloen.melon.eventbus;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/eventbus/EventPermission;", "", "hasStoragePermission", "", "hasPhonePermission", "<init>", "(ZZ)V", "getHasStoragePermission", "()Z", "getHasPhonePermission", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventPermission {
    public static final int $stable;
    private final boolean hasPhonePermission;
    private final boolean hasStoragePermission;

    public EventPermission(boolean z, boolean z1) {
        this.hasStoragePermission = z;
        this.hasPhonePermission = z1;
    }

    public final boolean component1() {
        return this.hasStoragePermission;
    }

    public final boolean component2() {
        return this.hasPhonePermission;
    }

    @NotNull
    public final EventPermission copy(boolean z, boolean z1) {
        return new EventPermission(z, z1);
    }

    public static EventPermission copy$default(EventPermission eventPermission0, boolean z, boolean z1, int v, Object object0) {
        if((v & 1) != 0) {
            z = eventPermission0.hasStoragePermission;
        }
        if((v & 2) != 0) {
            z1 = eventPermission0.hasPhonePermission;
        }
        return eventPermission0.copy(z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EventPermission)) {
            return false;
        }
        return this.hasStoragePermission == ((EventPermission)object0).hasStoragePermission ? this.hasPhonePermission == ((EventPermission)object0).hasPhonePermission : false;
    }

    public final boolean getHasPhonePermission() {
        return this.hasPhonePermission;
    }

    public final boolean getHasStoragePermission() {
        return this.hasStoragePermission;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.hasPhonePermission) + Boolean.hashCode(this.hasStoragePermission) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "EventPermission(hasStoragePermission=" + this.hasStoragePermission + ", hasPhonePermission=" + this.hasPhonePermission + ")";
    }
}

