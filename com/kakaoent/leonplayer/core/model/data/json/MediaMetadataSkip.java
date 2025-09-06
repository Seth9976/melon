package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadataSkip;", "", "begin", "", "type", "", "(DLjava/lang/String;)V", "getBegin", "()D", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaMetadataSkip {
    private final double begin;
    @NotNull
    private final String type;

    public MediaMetadataSkip(@i(name = "begin") double f, @i(name = "type") @NotNull String s) {
        q.g(s, "type");
        super();
        this.begin = f;
        this.type = s;
    }

    public final double component1() {
        return this.begin;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final MediaMetadataSkip copy(@i(name = "begin") double f, @i(name = "type") @NotNull String s) {
        q.g(s, "type");
        return new MediaMetadataSkip(f, s);
    }

    public static MediaMetadataSkip copy$default(MediaMetadataSkip mediaMetadataSkip0, double f, String s, int v, Object object0) {
        if((v & 1) != 0) {
            f = mediaMetadataSkip0.begin;
        }
        if((v & 2) != 0) {
            s = mediaMetadataSkip0.type;
        }
        return mediaMetadataSkip0.copy(f, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaMetadataSkip)) {
            return false;
        }
        return this.begin.equals(((MediaMetadataSkip)object0).begin) ? q.b(this.type, ((MediaMetadataSkip)object0).type) : false;
    }

    public final double getBegin() {
        return this.begin;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return this.type.hashCode() + Double.hashCode(this.begin) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MediaMetadataSkip(begin=");
        stringBuilder0.append(this.begin);
        stringBuilder0.append(", type=");
        return o.r(stringBuilder0, this.type, ')');
    }
}

