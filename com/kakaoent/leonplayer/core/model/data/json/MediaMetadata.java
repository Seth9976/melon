package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000E\b\u0001\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000F\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001A\u00020\u00002\u000E\b\u0003\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "", "skips", "", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadataSkip;", "(Ljava/util/List;)V", "getSkips", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaMetadata {
    @NotNull
    private final List skips;

    public MediaMetadata(@i(name = "skips") @NotNull List list0) {
        q.g(list0, "skips");
        super();
        this.skips = list0;
    }

    @NotNull
    public final List component1() {
        return this.skips;
    }

    @NotNull
    public final MediaMetadata copy(@i(name = "skips") @NotNull List list0) {
        q.g(list0, "skips");
        return new MediaMetadata(list0);
    }

    public static MediaMetadata copy$default(MediaMetadata mediaMetadata0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = mediaMetadata0.skips;
        }
        return mediaMetadata0.copy(list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaMetadata ? q.b(this.skips, ((MediaMetadata)object0).skips) : false;
    }

    @NotNull
    public final List getSkips() {
        return this.skips;
    }

    @Override
    public int hashCode() {
        return this.skips.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "MediaMetadata(skips=" + this.skips + ')';
    }
}

