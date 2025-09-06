package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u000E\b\u0001\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J4\u0010\u0014\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u000E\b\u0003\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "", "interval", "", "thumbnailCount", "", "thumbnails", "", "Lcom/kakaoent/leonplayer/core/model/data/json/Thumbnail;", "(DLjava/lang/Integer;Ljava/util/List;)V", "getInterval", "()D", "getThumbnailCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getThumbnails", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(DLjava/lang/Integer;Ljava/util/List;)Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "equals", "", "other", "hashCode", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailData {
    private final double interval;
    @Nullable
    private final Integer thumbnailCount;
    @NotNull
    private final List thumbnails;

    public ThumbnailData(@i(name = "interval") double f, @i(name = "thumbnail_count") @Nullable Integer integer0, @i(name = "thumbnails") @NotNull List list0) {
        q.g(list0, "thumbnails");
        super();
        this.interval = f;
        this.thumbnailCount = integer0;
        this.thumbnails = list0;
    }

    public final double component1() {
        return this.interval;
    }

    @Nullable
    public final Integer component2() {
        return this.thumbnailCount;
    }

    @NotNull
    public final List component3() {
        return this.thumbnails;
    }

    @NotNull
    public final ThumbnailData copy(@i(name = "interval") double f, @i(name = "thumbnail_count") @Nullable Integer integer0, @i(name = "thumbnails") @NotNull List list0) {
        q.g(list0, "thumbnails");
        return new ThumbnailData(f, integer0, list0);
    }

    public static ThumbnailData copy$default(ThumbnailData thumbnailData0, double f, Integer integer0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            f = thumbnailData0.interval;
        }
        if((v & 2) != 0) {
            integer0 = thumbnailData0.thumbnailCount;
        }
        if((v & 4) != 0) {
            list0 = thumbnailData0.thumbnails;
        }
        return thumbnailData0.copy(f, integer0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ThumbnailData)) {
            return false;
        }
        if(!this.interval.equals(((ThumbnailData)object0).interval)) {
            return false;
        }
        return q.b(this.thumbnailCount, ((ThumbnailData)object0).thumbnailCount) ? q.b(this.thumbnails, ((ThumbnailData)object0).thumbnails) : false;
    }

    public final double getInterval() {
        return this.interval;
    }

    @Nullable
    public final Integer getThumbnailCount() {
        return this.thumbnailCount;
    }

    @NotNull
    public final List getThumbnails() {
        return this.thumbnails;
    }

    @Override
    public int hashCode() {
        int v = Double.hashCode(this.interval);
        return this.thumbnailCount == null ? this.thumbnails.hashCode() + v * 961 : this.thumbnails.hashCode() + (v * 0x1F + this.thumbnailCount.hashCode()) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ThumbnailData(interval=" + this.interval + ", thumbnailCount=" + this.thumbnailCount + ", thumbnails=" + this.thumbnails + ')';
    }
}

