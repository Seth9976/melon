package com.iloen.melon.playback;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000B\u0010\n\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u000B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/playback/SpecialBgVideo;", "Ljava/io/Serializable;", "bgVideoPath", "", "bgVideoImgPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBgVideoPath", "()Ljava/lang/String;", "getBgVideoImgPath", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SpecialBgVideo implements Serializable {
    public static final int $stable;
    @Nullable
    private final String bgVideoImgPath;
    @Nullable
    private final String bgVideoPath;

    public SpecialBgVideo() {
        this(null, null, 3, null);
    }

    public SpecialBgVideo(@Nullable String s, @Nullable String s1) {
        this.bgVideoPath = s;
        this.bgVideoImgPath = s1;
    }

    public SpecialBgVideo(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        this(s, s1);
    }

    @Nullable
    public final String component1() {
        return this.bgVideoPath;
    }

    @Nullable
    public final String component2() {
        return this.bgVideoImgPath;
    }

    @NotNull
    public final SpecialBgVideo copy(@Nullable String s, @Nullable String s1) {
        return new SpecialBgVideo(s, s1);
    }

    public static SpecialBgVideo copy$default(SpecialBgVideo specialBgVideo0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = specialBgVideo0.bgVideoPath;
        }
        if((v & 2) != 0) {
            s1 = specialBgVideo0.bgVideoImgPath;
        }
        return specialBgVideo0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SpecialBgVideo)) {
            return false;
        }
        return q.b(this.bgVideoPath, ((SpecialBgVideo)object0).bgVideoPath) ? q.b(this.bgVideoImgPath, ((SpecialBgVideo)object0).bgVideoImgPath) : false;
    }

    @Nullable
    public final String getBgVideoImgPath() [...] // 潜在的解密器

    @Nullable
    public final String getBgVideoPath() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.bgVideoPath == null ? 0 : this.bgVideoPath.hashCode();
        String s = this.bgVideoImgPath;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "SpecialBgVideo(bgVideoPath=" + this.bgVideoPath + ", bgVideoImgPath=" + this.bgVideoImgPath + ")";
    }
}

