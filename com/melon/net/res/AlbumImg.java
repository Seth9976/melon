package com.melon.net.res;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/melon/net/res/AlbumImg;", "", "albumImgPath", "", "dpOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlbumImgPath", "()Ljava/lang/String;", "getDpOrder", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlbumImg {
    public static final int $stable;
    @b("ALBUMIMGPATH")
    @NotNull
    private final String albumImgPath;
    @b("DPORDER")
    @NotNull
    private final String dpOrder;

    public AlbumImg() {
        this(null, null, 3, null);
    }

    public AlbumImg(@NotNull String s, @NotNull String s1) {
        q.g(s, "albumImgPath");
        q.g(s1, "dpOrder");
        super();
        this.albumImgPath = s;
        this.dpOrder = s1;
    }

    public AlbumImg(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        this(s, s1);
    }

    @NotNull
    public final String component1() {
        return this.albumImgPath;
    }

    @NotNull
    public final String component2() {
        return this.dpOrder;
    }

    @NotNull
    public final AlbumImg copy(@NotNull String s, @NotNull String s1) {
        q.g(s, "albumImgPath");
        q.g(s1, "dpOrder");
        return new AlbumImg(s, s1);
    }

    public static AlbumImg copy$default(AlbumImg albumImg0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = albumImg0.albumImgPath;
        }
        if((v & 2) != 0) {
            s1 = albumImg0.dpOrder;
        }
        return albumImg0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AlbumImg)) {
            return false;
        }
        return q.b(this.albumImgPath, ((AlbumImg)object0).albumImgPath) ? q.b(this.dpOrder, ((AlbumImg)object0).dpOrder) : false;
    }

    @NotNull
    public final String getAlbumImgPath() [...] // 潜在的解密器

    @NotNull
    public final String getDpOrder() {
        return this.dpOrder;
    }

    @Override
    public int hashCode() {
        return this.dpOrder.hashCode() + this.albumImgPath.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "AlbumImg(albumImgPath=" + this.albumImgPath + ", dpOrder=" + this.dpOrder + ")";
    }
}

