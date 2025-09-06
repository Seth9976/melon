package com.iloen.melon.popup;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001B\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ.\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000FJ\u0010\u0010\u0013\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u001A\u0010\u0015\u001A\u00020\u00022\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0003\u0010\u000B\"\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\rR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010\u000F¨\u0006!"}, d2 = {"Lcom/iloen/melon/popup/AlbumDataSet;", "", "", "isChecked", "", "type", "", "title", "<init>", "(ZILjava/lang/String;)V", "component1", "()Z", "component2", "()I", "component3", "()Ljava/lang/String;", "copy", "(ZILjava/lang/String;)Lcom/iloen/melon/popup/AlbumDataSet;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "setChecked", "(Z)V", "b", "I", "getType", "c", "Ljava/lang/String;", "getTitle", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlbumDataSet {
    public static final int $stable = 8;
    public boolean a;
    public final int b;
    public final String c;

    public AlbumDataSet(boolean z, int v, @NotNull String s) {
        q.g(s, "title");
        super();
        this.a = z;
        this.b = v;
        this.c = s;
    }

    public AlbumDataSet(boolean z, int v, String s, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            z = false;
        }
        this(z, v, s);
    }

    public final boolean component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final AlbumDataSet copy(boolean z, int v, @NotNull String s) {
        q.g(s, "title");
        return new AlbumDataSet(z, v, s);
    }

    public static AlbumDataSet copy$default(AlbumDataSet albumDataSet0, boolean z, int v, String s, int v1, Object object0) {
        if((v1 & 1) != 0) {
            z = albumDataSet0.a;
        }
        if((v1 & 2) != 0) {
            v = albumDataSet0.b;
        }
        if((v1 & 4) != 0) {
            s = albumDataSet0.c;
        }
        return albumDataSet0.copy(z, v, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AlbumDataSet)) {
            return false;
        }
        if(this.a != ((AlbumDataSet)object0).a) {
            return false;
        }
        return this.b == ((AlbumDataSet)object0).b ? q.b(this.c, ((AlbumDataSet)object0).c) : false;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    public final int getType() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    public final boolean isChecked() {
        return this.a;
    }

    public final void setChecked(boolean z) {
        this.a = z;
    }

    @Override
    @NotNull
    public String toString() {
        boolean z = this.a;
        StringBuilder stringBuilder0 = new StringBuilder("AlbumDataSet(isChecked=");
        stringBuilder0.append(z);
        stringBuilder0.append(", type=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", title=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

