package com.kakaoent.leonplayer.core.model.data.json;

import U4.x;
import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J3\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/SubtitleTrack;", "", "id", "", "dispName", "label", "lang", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDispName", "()Ljava/lang/String;", "getId", "getLabel", "getLang", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubtitleTrack {
    @NotNull
    private final String dispName;
    @NotNull
    private final String id;
    @Nullable
    private final String label;
    @NotNull
    private final String lang;

    public SubtitleTrack(@i(name = "id") @NotNull String s, @i(name = "disp_name") @NotNull String s1, @i(name = "label") @Nullable String s2, @i(name = "lang") @NotNull String s3) {
        q.g(s, "id");
        q.g(s1, "dispName");
        q.g(s3, "lang");
        super();
        this.id = s;
        this.dispName = s1;
        this.label = s2;
        this.lang = s3;
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
    public final String component3() {
        return this.label;
    }

    @NotNull
    public final String component4() {
        return this.lang;
    }

    @NotNull
    public final SubtitleTrack copy(@i(name = "id") @NotNull String s, @i(name = "disp_name") @NotNull String s1, @i(name = "label") @Nullable String s2, @i(name = "lang") @NotNull String s3) {
        q.g(s, "id");
        q.g(s1, "dispName");
        q.g(s3, "lang");
        return new SubtitleTrack(s, s1, s2, s3);
    }

    public static SubtitleTrack copy$default(SubtitleTrack subtitleTrack0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 1) != 0) {
            s = subtitleTrack0.id;
        }
        if((v & 2) != 0) {
            s1 = subtitleTrack0.dispName;
        }
        if((v & 4) != 0) {
            s2 = subtitleTrack0.label;
        }
        if((v & 8) != 0) {
            s3 = subtitleTrack0.lang;
        }
        return subtitleTrack0.copy(s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SubtitleTrack)) {
            return false;
        }
        if(!q.b(this.id, ((SubtitleTrack)object0).id)) {
            return false;
        }
        if(!q.b(this.dispName, ((SubtitleTrack)object0).dispName)) {
            return false;
        }
        return q.b(this.label, ((SubtitleTrack)object0).label) ? q.b(this.lang, ((SubtitleTrack)object0).lang) : false;
    }

    @NotNull
    public final String getDispName() {
        return this.dispName;
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

    @Override
    public int hashCode() {
        int v = x.b(this.id.hashCode() * 0x1F, 0x1F, this.dispName);
        return this.label == null ? this.lang.hashCode() + v * 0x1F : this.lang.hashCode() + (v + this.label.hashCode()) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SubtitleTrack(id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", dispName=");
        stringBuilder0.append(this.dispName);
        stringBuilder0.append(", label=");
        stringBuilder0.append(this.label);
        stringBuilder0.append(", lang=");
        return o.r(stringBuilder0, this.lang, ')');
    }
}

