package com.kakaoent.leonplayer.core.model.data.json;

import A7.d;
import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0006\u0012\u000E\b\u0001\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\u000F\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\b\b\u0003\u0010\u0005\u001A\u00020\u00062\u000E\b\u0003\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001D"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/Thumbnail;", "", "horizontalCount", "", "verticalCount", "thumbnailResolution", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;", "urls", "", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailUrl;", "(IILcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;Ljava/util/List;)V", "getHorizontalCount", "()I", "getThumbnailResolution", "()Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;", "getUrls", "()Ljava/util/List;", "getVerticalCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Thumbnail {
    private final int horizontalCount;
    @NotNull
    private final ThumbnailResolution thumbnailResolution;
    @NotNull
    private final List urls;
    private final int verticalCount;

    public Thumbnail(@i(name = "horizontal_count") int v, @i(name = "vertical_count") int v1, @i(name = "thumbnail_resolution") @NotNull ThumbnailResolution thumbnailResolution0, @i(name = "urls") @NotNull List list0) {
        q.g(thumbnailResolution0, "thumbnailResolution");
        q.g(list0, "urls");
        super();
        this.horizontalCount = v;
        this.verticalCount = v1;
        this.thumbnailResolution = thumbnailResolution0;
        this.urls = list0;
    }

    public final int component1() {
        return this.horizontalCount;
    }

    public final int component2() {
        return this.verticalCount;
    }

    @NotNull
    public final ThumbnailResolution component3() {
        return this.thumbnailResolution;
    }

    @NotNull
    public final List component4() {
        return this.urls;
    }

    @NotNull
    public final Thumbnail copy(@i(name = "horizontal_count") int v, @i(name = "vertical_count") int v1, @i(name = "thumbnail_resolution") @NotNull ThumbnailResolution thumbnailResolution0, @i(name = "urls") @NotNull List list0) {
        q.g(thumbnailResolution0, "thumbnailResolution");
        q.g(list0, "urls");
        return new Thumbnail(v, v1, thumbnailResolution0, list0);
    }

    public static Thumbnail copy$default(Thumbnail thumbnail0, int v, int v1, ThumbnailResolution thumbnailResolution0, List list0, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = thumbnail0.horizontalCount;
        }
        if((v2 & 2) != 0) {
            v1 = thumbnail0.verticalCount;
        }
        if((v2 & 4) != 0) {
            thumbnailResolution0 = thumbnail0.thumbnailResolution;
        }
        if((v2 & 8) != 0) {
            list0 = thumbnail0.urls;
        }
        return thumbnail0.copy(v, v1, thumbnailResolution0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Thumbnail)) {
            return false;
        }
        if(this.horizontalCount != ((Thumbnail)object0).horizontalCount) {
            return false;
        }
        if(this.verticalCount != ((Thumbnail)object0).verticalCount) {
            return false;
        }
        return q.b(this.thumbnailResolution, ((Thumbnail)object0).thumbnailResolution) ? q.b(this.urls, ((Thumbnail)object0).urls) : false;
    }

    public final int getHorizontalCount() {
        return this.horizontalCount;
    }

    @NotNull
    public final ThumbnailResolution getThumbnailResolution() {
        return this.thumbnailResolution;
    }

    @NotNull
    public final List getUrls() {
        return this.urls;
    }

    public final int getVerticalCount() {
        return this.verticalCount;
    }

    @Override
    public int hashCode() {
        return this.urls.hashCode() + (this.thumbnailResolution.hashCode() + d.b(this.verticalCount, this.horizontalCount * 0x1F, 0x1F)) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "Thumbnail(horizontalCount=" + this.horizontalCount + ", verticalCount=" + this.verticalCount + ", thumbnailResolution=" + this.thumbnailResolution + ", urls=" + this.urls + ')';
    }
}

