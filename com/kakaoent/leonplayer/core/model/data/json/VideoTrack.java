package com.kakaoent.leonplayer.core.model.data.json;

import U4.x;
import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\u0010\b\u0001\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u000E\b\u0001\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J?\u0010\u0014\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\u0010\b\u0003\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u000E\b\u0003\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0019\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\r¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/VideoTrack;", "", "id", "", "dispName", "drm", "", "representations", "Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDispName", "()Ljava/lang/String;", "getDrm", "()Ljava/util/List;", "getId", "getRepresentations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class VideoTrack {
    @NotNull
    private final String dispName;
    @Nullable
    private final List drm;
    @NotNull
    private final String id;
    @NotNull
    private final List representations;

    public VideoTrack(@i(name = "id") @NotNull String s, @i(name = "disp_name") @NotNull String s1, @i(name = "drm") @Nullable List list0, @i(name = "representations") @NotNull List list1) {
        q.g(s, "id");
        q.g(s1, "dispName");
        q.g(list1, "representations");
        super();
        this.id = s;
        this.dispName = s1;
        this.drm = list0;
        this.representations = list1;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.dispName;
    }

    @Nullable
    public final List component3() {
        return this.drm;
    }

    @NotNull
    public final List component4() {
        return this.representations;
    }

    @NotNull
    public final VideoTrack copy(@i(name = "id") @NotNull String s, @i(name = "disp_name") @NotNull String s1, @i(name = "drm") @Nullable List list0, @i(name = "representations") @NotNull List list1) {
        q.g(s, "id");
        q.g(s1, "dispName");
        q.g(list1, "representations");
        return new VideoTrack(s, s1, list0, list1);
    }

    public static VideoTrack copy$default(VideoTrack videoTrack0, String s, String s1, List list0, List list1, int v, Object object0) {
        if((v & 1) != 0) {
            s = videoTrack0.id;
        }
        if((v & 2) != 0) {
            s1 = videoTrack0.dispName;
        }
        if((v & 4) != 0) {
            list0 = videoTrack0.drm;
        }
        if((v & 8) != 0) {
            list1 = videoTrack0.representations;
        }
        return videoTrack0.copy(s, s1, list0, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof VideoTrack)) {
            return false;
        }
        if(!q.b(this.id, ((VideoTrack)object0).id)) {
            return false;
        }
        if(!q.b(this.dispName, ((VideoTrack)object0).dispName)) {
            return false;
        }
        return q.b(this.drm, ((VideoTrack)object0).drm) ? q.b(this.representations, ((VideoTrack)object0).representations) : false;
    }

    @NotNull
    public final String getDispName() {
        return this.dispName;
    }

    @Nullable
    public final List getDrm() {
        return this.drm;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List getRepresentations() {
        return this.representations;
    }

    @Override
    public int hashCode() {
        int v = x.b(this.id.hashCode() * 0x1F, 0x1F, this.dispName);
        return this.drm == null ? this.representations.hashCode() + v * 0x1F : this.representations.hashCode() + (v + this.drm.hashCode()) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "VideoTrack(id=" + this.id + ", dispName=" + this.dispName + ", drm=" + this.drm + ", representations=" + this.representations + ')';
    }
}

