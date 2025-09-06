package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000B\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailResolution {
    private final int height;
    private final int width;

    public ThumbnailResolution(@i(name = "width") int v, @i(name = "height") int v1) {
        this.width = v;
        this.height = v1;
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final ThumbnailResolution copy(@i(name = "width") int v, @i(name = "height") int v1) {
        return new ThumbnailResolution(v, v1);
    }

    public static ThumbnailResolution copy$default(ThumbnailResolution thumbnailResolution0, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = thumbnailResolution0.width;
        }
        if((v2 & 2) != 0) {
            v1 = thumbnailResolution0.height;
        }
        return thumbnailResolution0.copy(v, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ThumbnailResolution)) {
            return false;
        }
        return this.width == ((ThumbnailResolution)object0).width ? this.height == ((ThumbnailResolution)object0).height : false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        return this.height + this.width * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ThumbnailResolution(width=");
        stringBuilder0.append(this.width);
        stringBuilder0.append(", height=");
        return o.q(stringBuilder0, this.height, ')');
    }
}

