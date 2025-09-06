package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000E\b\u0001\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000F\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J5\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\u0010\b\u0003\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u000E\b\u0003\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/PlaybackUrl;", "", "type", "", "drm", "", "media", "Lcom/kakaoent/leonplayer/core/model/data/json/Media;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDrm", "()Ljava/util/List;", "getMedia", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PlaybackUrl {
    @Nullable
    private final List drm;
    @NotNull
    private final List media;
    @NotNull
    private final String type;

    public PlaybackUrl(@i(name = "type") @NotNull String s, @i(name = "drm") @Nullable List list0, @i(name = "media") @NotNull List list1) {
        q.g(s, "type");
        q.g(list1, "media");
        super();
        this.type = s;
        this.drm = list0;
        this.media = list1;
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final List component2() {
        return this.drm;
    }

    @NotNull
    public final List component3() {
        return this.media;
    }

    @NotNull
    public final PlaybackUrl copy(@i(name = "type") @NotNull String s, @i(name = "drm") @Nullable List list0, @i(name = "media") @NotNull List list1) {
        q.g(s, "type");
        q.g(list1, "media");
        return new PlaybackUrl(s, list0, list1);
    }

    public static PlaybackUrl copy$default(PlaybackUrl playbackUrl0, String s, List list0, List list1, int v, Object object0) {
        if((v & 1) != 0) {
            s = playbackUrl0.type;
        }
        if((v & 2) != 0) {
            list0 = playbackUrl0.drm;
        }
        if((v & 4) != 0) {
            list1 = playbackUrl0.media;
        }
        return playbackUrl0.copy(s, list0, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaybackUrl)) {
            return false;
        }
        if(!q.b(this.type, ((PlaybackUrl)object0).type)) {
            return false;
        }
        return q.b(this.drm, ((PlaybackUrl)object0).drm) ? q.b(this.media, ((PlaybackUrl)object0).media) : false;
    }

    @Nullable
    public final List getDrm() {
        return this.drm;
    }

    @NotNull
    public final List getMedia() {
        return this.media;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int v = this.type.hashCode();
        return this.drm == null ? this.media.hashCode() + v * 961 : this.media.hashCode() + (v * 0x1F + this.drm.hashCode()) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "PlaybackUrl(type=" + this.type + ", drm=" + this.drm + ", media=" + this.media + ')';
    }
}

