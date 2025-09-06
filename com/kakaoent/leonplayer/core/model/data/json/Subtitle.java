package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000B\u0010\u0007\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001A\u00020\u00002\n\b\u0003\u0010\u0002\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/Subtitle;", "", "track", "", "(Ljava/lang/String;)V", "getTrack", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Subtitle {
    @Nullable
    private final String track;

    public Subtitle(@i(name = "track") @Nullable String s) {
        this.track = s;
    }

    @Nullable
    public final String component1() {
        return this.track;
    }

    @NotNull
    public final Subtitle copy(@i(name = "track") @Nullable String s) {
        return new Subtitle(s);
    }

    public static Subtitle copy$default(Subtitle subtitle0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = subtitle0.track;
        }
        return subtitle0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Subtitle ? q.b(this.track, ((Subtitle)object0).track) : false;
    }

    @Nullable
    public final String getTrack() {
        return this.track;
    }

    @Override
    public int hashCode() {
        return this.track == null ? 0 : this.track.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("Subtitle(track="), this.track, ')');
    }
}

