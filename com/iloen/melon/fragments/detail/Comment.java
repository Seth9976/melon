package com.iloen.melon.fragments.detail;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00052\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\f\"\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/detail/Comment;", "Lcom/iloen/melon/fragments/detail/Data;", "count", "", "hasHot", "", "hasNew", "<init>", "(IZZ)V", "getCount", "()I", "getHasHot", "()Z", "getHasNew", "setHasNew", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class Comment extends Data {
    private final int count;
    private final boolean hasHot;
    private boolean hasNew;

    public Comment() {
        this(0, false, false, 7, null);
    }

    public Comment(int v, boolean z, boolean z1) {
        this.count = v;
        this.hasHot = z;
        this.hasNew = z1;
    }

    public Comment(int v, boolean z, boolean z1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            v = -1;
        }
        if((v1 & 2) != 0) {
            z = false;
        }
        if((v1 & 4) != 0) {
            z1 = false;
        }
        this(v, z, z1);
    }

    public final int component1() {
        return this.count;
    }

    public final boolean component2() {
        return this.hasHot;
    }

    public final boolean component3() {
        return this.hasNew;
    }

    @NotNull
    public final Comment copy(int v, boolean z, boolean z1) {
        return new Comment(v, z, z1);
    }

    public static Comment copy$default(Comment comment0, int v, boolean z, boolean z1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = comment0.count;
        }
        if((v1 & 2) != 0) {
            z = comment0.hasHot;
        }
        if((v1 & 4) != 0) {
            z1 = comment0.hasNew;
        }
        return comment0.copy(v, z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Comment)) {
            return false;
        }
        if(this.count != ((Comment)object0).count) {
            return false;
        }
        return this.hasHot == ((Comment)object0).hasHot ? this.hasNew == ((Comment)object0).hasNew : false;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasHot() {
        return this.hasHot;
    }

    public final boolean getHasNew() {
        return this.hasNew;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.hasNew) + d.e(this.count * 0x1F, 0x1F, this.hasHot);
    }

    public final void setHasNew(boolean z) {
        this.hasNew = z;
    }

    @Override
    @NotNull
    public String toString() {
        boolean z = this.hasNew;
        StringBuilder stringBuilder0 = new StringBuilder("Comment(count=");
        stringBuilder0.append(this.count);
        stringBuilder0.append(", hasHot=");
        stringBuilder0.append(this.hasHot);
        stringBuilder0.append(", hasNew=");
        return o.s(stringBuilder0, z, ")");
    }
}

