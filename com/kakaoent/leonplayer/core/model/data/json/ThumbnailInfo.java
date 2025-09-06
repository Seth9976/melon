package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "", "type", "", "data", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "(Ljava/lang/String;Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;)V", "getData", "()Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailInfo {
    @NotNull
    private final ThumbnailData data;
    @NotNull
    private final String type;

    public ThumbnailInfo(@i(name = "type") @NotNull String s, @i(name = "data") @NotNull ThumbnailData thumbnailData0) {
        q.g(s, "type");
        q.g(thumbnailData0, "data");
        super();
        this.type = s;
        this.data = thumbnailData0;
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final ThumbnailData component2() {
        return this.data;
    }

    @NotNull
    public final ThumbnailInfo copy(@i(name = "type") @NotNull String s, @i(name = "data") @NotNull ThumbnailData thumbnailData0) {
        q.g(s, "type");
        q.g(thumbnailData0, "data");
        return new ThumbnailInfo(s, thumbnailData0);
    }

    public static ThumbnailInfo copy$default(ThumbnailInfo thumbnailInfo0, String s, ThumbnailData thumbnailData0, int v, Object object0) {
        if((v & 1) != 0) {
            s = thumbnailInfo0.type;
        }
        if((v & 2) != 0) {
            thumbnailData0 = thumbnailInfo0.data;
        }
        return thumbnailInfo0.copy(s, thumbnailData0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ThumbnailInfo)) {
            return false;
        }
        return q.b(this.type, ((ThumbnailInfo)object0).type) ? q.b(this.data, ((ThumbnailInfo)object0).data) : false;
    }

    @NotNull
    public final ThumbnailData getData() {
        return this.data;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return this.data.hashCode() + this.type.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ThumbnailInfo(type=" + this.type + ", data=" + this.data + ')';
    }
}

