package com.kakaoent.trevi.ad.domain;

import H0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\u00032\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviUserInfo;", "", "userIdExists", "", "userTarget", "(ZZ)V", "getUserIdExists", "()Z", "getUserTarget", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviUserInfo {
    private final boolean userIdExists;
    private final boolean userTarget;

    public TreviUserInfo() {
        this(false, false, 3, null);
    }

    public TreviUserInfo(boolean z, boolean z1) {
        this.userIdExists = z;
        this.userTarget = z1;
    }

    public TreviUserInfo(boolean z, boolean z1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            z = false;
        }
        if((v & 2) != 0) {
            z1 = false;
        }
        this(z, z1);
    }

    public final boolean component1() {
        return this.userIdExists;
    }

    public final boolean component2() {
        return this.userTarget;
    }

    @NotNull
    public final TreviUserInfo copy(boolean z, boolean z1) {
        return new TreviUserInfo(z, z1);
    }

    public static TreviUserInfo copy$default(TreviUserInfo treviUserInfo0, boolean z, boolean z1, int v, Object object0) {
        if((v & 1) != 0) {
            z = treviUserInfo0.userIdExists;
        }
        if((v & 2) != 0) {
            z1 = treviUserInfo0.userTarget;
        }
        return treviUserInfo0.copy(z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviUserInfo)) {
            return false;
        }
        return this.userIdExists == ((TreviUserInfo)object0).userIdExists ? this.userTarget == ((TreviUserInfo)object0).userTarget : false;
    }

    public final boolean getUserIdExists() {
        return this.userIdExists;
    }

    public final boolean getUserTarget() {
        return this.userTarget;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.userTarget) + Boolean.hashCode(this.userIdExists) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviUserInfo(userIdExists=");
        stringBuilder0.append(this.userIdExists);
        stringBuilder0.append(", userTarget=");
        return b.k(stringBuilder0, this.userTarget, ')');
    }
}

