package com.iloen.melon.fragments.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/detail/Like;", "Lcom/iloen/melon/fragments/detail/Data;", "count", "", "isLiked", "", "<init>", "(IZ)V", "getCount", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class Like extends Data {
    private final int count;
    private final boolean isLiked;

    public Like() {
        this(0, false, 3, null);
    }

    public Like(int v, boolean z) {
        this.count = v;
        this.isLiked = z;
    }

    public Like(int v, boolean z, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            v = -1;
        }
        if((v1 & 2) != 0) {
            z = false;
        }
        this(v, z);
    }

    public final int component1() {
        return this.count;
    }

    public final boolean component2() {
        return this.isLiked;
    }

    @NotNull
    public final Like copy(int v, boolean z) {
        return new Like(v, z);
    }

    public static Like copy$default(Like like0, int v, boolean z, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = like0.count;
        }
        if((v1 & 2) != 0) {
            z = like0.isLiked;
        }
        return like0.copy(v, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Like)) {
            return false;
        }
        return this.count == ((Like)object0).count ? this.isLiked == ((Like)object0).isLiked : false;
    }

    public final int getCount() {
        return this.count;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.isLiked) + this.count * 0x1F;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    @Override
    @NotNull
    public String toString() {
        return "Like(count=" + this.count + ", isLiked=" + this.isLiked + ")";
    }
}

