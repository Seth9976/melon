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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\b\u001A\u00020\u0003\u0012\u000E\b\u0001\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003JU\u0010\u001A\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\u0010\b\u0003\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u00032\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u00032\b\b\u0003\u0010\b\u001A\u00020\u00032\u000E\b\u0003\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000F¨\u0006!"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/AudioTrack;", "", "dispName", "", "drm", "", "id", "label", "lang", "representations", "Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDispName", "()Ljava/lang/String;", "getDrm", "()Ljava/util/List;", "getId", "getLabel", "getLang", "getRepresentations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class AudioTrack {
    @NotNull
    private final String dispName;
    @Nullable
    private final List drm;
    @NotNull
    private final String id;
    @Nullable
    private final String label;
    @NotNull
    private final String lang;
    @NotNull
    private final List representations;

    public AudioTrack(@i(name = "disp_name") @NotNull String s, @i(name = "drm") @Nullable List list0, @i(name = "id") @NotNull String s1, @i(name = "label") @Nullable String s2, @i(name = "lang") @NotNull String s3, @i(name = "representations") @NotNull List list1) {
        q.g(s, "dispName");
        q.g(s1, "id");
        q.g(s3, "lang");
        q.g(list1, "representations");
        super();
        this.dispName = s;
        this.drm = list0;
        this.id = s1;
        this.label = s2;
        this.lang = s3;
        this.representations = list1;
    }

    @NotNull
    public final String component1() {
        return this.dispName;
    }

    @Nullable
    public final List component2() {
        return this.drm;
    }

    @NotNull
    public final String component3() {
        return this.id;
    }

    @Nullable
    public final String component4() {
        return this.label;
    }

    @NotNull
    public final String component5() {
        return this.lang;
    }

    @NotNull
    public final List component6() {
        return this.representations;
    }

    @NotNull
    public final AudioTrack copy(@i(name = "disp_name") @NotNull String s, @i(name = "drm") @Nullable List list0, @i(name = "id") @NotNull String s1, @i(name = "label") @Nullable String s2, @i(name = "lang") @NotNull String s3, @i(name = "representations") @NotNull List list1) {
        q.g(s, "dispName");
        q.g(s1, "id");
        q.g(s3, "lang");
        q.g(list1, "representations");
        return new AudioTrack(s, list0, s1, s2, s3, list1);
    }

    public static AudioTrack copy$default(AudioTrack audioTrack0, String s, List list0, String s1, String s2, String s3, List list1, int v, Object object0) {
        if((v & 1) != 0) {
            s = audioTrack0.dispName;
        }
        if((v & 2) != 0) {
            list0 = audioTrack0.drm;
        }
        if((v & 4) != 0) {
            s1 = audioTrack0.id;
        }
        if((v & 8) != 0) {
            s2 = audioTrack0.label;
        }
        if((v & 16) != 0) {
            s3 = audioTrack0.lang;
        }
        if((v & 0x20) != 0) {
            list1 = audioTrack0.representations;
        }
        return audioTrack0.copy(s, list0, s1, s2, s3, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AudioTrack)) {
            return false;
        }
        if(!q.b(this.dispName, ((AudioTrack)object0).dispName)) {
            return false;
        }
        if(!q.b(this.drm, ((AudioTrack)object0).drm)) {
            return false;
        }
        if(!q.b(this.id, ((AudioTrack)object0).id)) {
            return false;
        }
        if(!q.b(this.label, ((AudioTrack)object0).label)) {
            return false;
        }
        return q.b(this.lang, ((AudioTrack)object0).lang) ? q.b(this.representations, ((AudioTrack)object0).representations) : false;
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

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final List getRepresentations() {
        return this.representations;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = x.b((this.dispName.hashCode() * 0x1F + (this.drm == null ? 0 : this.drm.hashCode())) * 0x1F, 0x1F, this.id);
        String s = this.label;
        if(s != null) {
            v = s.hashCode();
        }
        return this.representations.hashCode() + x.b((v1 + v) * 0x1F, 0x1F, this.lang);
    }

    @Override
    @NotNull
    public String toString() {
        return "AudioTrack(dispName=" + this.dispName + ", drm=" + this.drm + ", id=" + this.id + ", label=" + this.label + ", lang=" + this.lang + ", representations=" + this.representations + ')';
    }
}

