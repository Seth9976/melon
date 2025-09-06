package com.melon.net.res;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/melon/net/res/BgVideo;", "", "bgVideoPath", "", "bgVideoImagePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBgVideoPath", "()Ljava/lang/String;", "getBgVideoImagePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BgVideo {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/melon/net/res/BgVideo$Companion;", "", "<init>", "()V", "None", "Lcom/melon/net/res/BgVideo;", "getNone", "()Lcom/melon/net/res/BgVideo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final BgVideo getNone() {
            return BgVideo.None;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final BgVideo None;
    @b("BGVIDEOIMGPATH")
    @NotNull
    private final String bgVideoImagePath;
    @b("BGVIDEOPATH")
    @NotNull
    private final String bgVideoPath;

    static {
        BgVideo.Companion = new Companion(null);
        BgVideo.None = new BgVideo("", "");
    }

    public BgVideo() {
        this(null, null, 3, null);
    }

    public BgVideo(@NotNull String s, @NotNull String s1) {
        q.g(s, "bgVideoPath");
        q.g(s1, "bgVideoImagePath");
        super();
        this.bgVideoPath = s;
        this.bgVideoImagePath = s1;
    }

    public BgVideo(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        this(s, s1);
    }

    @NotNull
    public final String component1() {
        return this.bgVideoPath;
    }

    @NotNull
    public final String component2() {
        return this.bgVideoImagePath;
    }

    @NotNull
    public final BgVideo copy(@NotNull String s, @NotNull String s1) {
        q.g(s, "bgVideoPath");
        q.g(s1, "bgVideoImagePath");
        return new BgVideo(s, s1);
    }

    public static BgVideo copy$default(BgVideo bgVideo0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = bgVideo0.bgVideoPath;
        }
        if((v & 2) != 0) {
            s1 = bgVideo0.bgVideoImagePath;
        }
        return bgVideo0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BgVideo)) {
            return false;
        }
        return q.b(this.bgVideoPath, ((BgVideo)object0).bgVideoPath) ? q.b(this.bgVideoImagePath, ((BgVideo)object0).bgVideoImagePath) : false;
    }

    @NotNull
    public final String getBgVideoImagePath() [...] // 潜在的解密器

    @NotNull
    public final String getBgVideoPath() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        return this.bgVideoImagePath.hashCode() + this.bgVideoPath.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "BgVideo(bgVideoPath=" + this.bgVideoPath + ", bgVideoImagePath=" + this.bgVideoImagePath + ")";
    }
}

