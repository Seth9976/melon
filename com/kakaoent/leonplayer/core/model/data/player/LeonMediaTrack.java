package com.kakaoent.leonplayer.core.model.data.player;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0005HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTrack;", "", "type", "", "name", "", "language", "(ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getName", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonMediaTrack {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTrack$Companion;", "", "()V", "TYPE_AUDIO", "", "TYPE_METADATA", "TYPE_TIMEDTEXT", "TYPE_UNKNOWN", "TYPE_VIDEO", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_METADATA = 5;
    public static final int TYPE_TIMEDTEXT = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 1;
    @NotNull
    private final String language;
    @NotNull
    private final String name;
    private final int type;

    static {
        LeonMediaTrack.Companion = new Companion(null);
    }

    public LeonMediaTrack(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "name");
        q.g(s1, "language");
        super();
        this.type = v;
        this.name = s;
        this.language = s1;
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.language;
    }

    @NotNull
    public final LeonMediaTrack copy(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "name");
        q.g(s1, "language");
        return new LeonMediaTrack(v, s, s1);
    }

    public static LeonMediaTrack copy$default(LeonMediaTrack leonMediaTrack0, int v, String s, String s1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = leonMediaTrack0.type;
        }
        if((v1 & 2) != 0) {
            s = leonMediaTrack0.name;
        }
        if((v1 & 4) != 0) {
            s1 = leonMediaTrack0.language;
        }
        return leonMediaTrack0.copy(v, s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LeonMediaTrack)) {
            return false;
        }
        if(this.type != ((LeonMediaTrack)object0).type) {
            return false;
        }
        return q.b(this.name, ((LeonMediaTrack)object0).name) ? q.b(this.language, ((LeonMediaTrack)object0).language) : false;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return this.language.hashCode() + x.b(this.type * 0x1F, 0x1F, this.name);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LeonMediaTrack(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", name=");
        stringBuilder0.append(this.name);
        stringBuilder0.append(", language=");
        return o.r(stringBuilder0, this.language, ')');
    }
}

