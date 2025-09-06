package com.melon.net.res;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/melon/net/res/BgImage;", "", "bgImagePath", "", "dpOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBgImagePath", "()Ljava/lang/String;", "getDpOrder", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BgImage {
    public static final int $stable;
    @b("BGIMGPATH")
    @NotNull
    private final String bgImagePath;
    @b("DPORDER")
    @NotNull
    private final String dpOrder;

    public BgImage() {
        this(null, null, 3, null);
    }

    public BgImage(@NotNull String s, @NotNull String s1) {
        q.g(s, "bgImagePath");
        q.g(s1, "dpOrder");
        super();
        this.bgImagePath = s;
        this.dpOrder = s1;
    }

    public BgImage(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
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
        return this.bgImagePath;
    }

    @NotNull
    public final String component2() {
        return this.dpOrder;
    }

    @NotNull
    public final BgImage copy(@NotNull String s, @NotNull String s1) {
        q.g(s, "bgImagePath");
        q.g(s1, "dpOrder");
        return new BgImage(s, s1);
    }

    public static BgImage copy$default(BgImage bgImage0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = bgImage0.bgImagePath;
        }
        if((v & 2) != 0) {
            s1 = bgImage0.dpOrder;
        }
        return bgImage0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BgImage)) {
            return false;
        }
        return q.b(this.bgImagePath, ((BgImage)object0).bgImagePath) ? q.b(this.dpOrder, ((BgImage)object0).dpOrder) : false;
    }

    @NotNull
    public final String getBgImagePath() [...] // 潜在的解密器

    @NotNull
    public final String getDpOrder() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        return this.dpOrder.hashCode() + this.bgImagePath.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "BgImage(bgImagePath=" + this.bgImagePath + ", dpOrder=" + this.dpOrder + ")";
    }
}

