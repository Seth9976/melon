package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\u0010\b\u0003\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/Video;", "", "track", "", "representations", "", "(Ljava/lang/String;Ljava/util/List;)V", "getRepresentations", "()Ljava/util/List;", "getTrack", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Video {
    @Nullable
    private final List representations;
    @NotNull
    private final String track;

    public Video(@i(name = "track") @NotNull String s, @i(name = "representations") @Nullable List list0) {
        q.g(s, "track");
        super();
        this.track = s;
        this.representations = list0;
    }

    @NotNull
    public final String component1() {
        return this.track;
    }

    @Nullable
    public final List component2() {
        return this.representations;
    }

    @NotNull
    public final Video copy(@i(name = "track") @NotNull String s, @i(name = "representations") @Nullable List list0) {
        q.g(s, "track");
        return new Video(s, list0);
    }

    public static Video copy$default(Video video0, String s, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = video0.track;
        }
        if((v & 2) != 0) {
            list0 = video0.representations;
        }
        return video0.copy(s, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Video)) {
            return false;
        }
        return q.b(this.track, ((Video)object0).track) ? q.b(this.representations, ((Video)object0).representations) : false;
    }

    @Nullable
    public final List getRepresentations() {
        return this.representations;
    }

    @NotNull
    public final String getTrack() {
        return this.track;
    }

    @Override
    public int hashCode() {
        int v = this.track.hashCode();
        return this.representations == null ? v * 0x1F : v * 0x1F + this.representations.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "Video(track=" + this.track + ", representations=" + this.representations + ')';
    }
}

