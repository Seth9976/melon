package com.kakaoent.trevi.ad.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0006HÆ\u0003J+\u0010\u0010\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/trevi/ad/data/BannerAppearance;", "", "textColor", "Lcom/kakaoent/trevi/ad/data/ColorIdSet;", "strokeColor", "uiMode", "Lcom/kakaoent/trevi/ad/data/UiMode;", "(Lcom/kakaoent/trevi/ad/data/ColorIdSet;Lcom/kakaoent/trevi/ad/data/ColorIdSet;Lcom/kakaoent/trevi/ad/data/UiMode;)V", "getStrokeColor", "()Lcom/kakaoent/trevi/ad/data/ColorIdSet;", "getTextColor", "getUiMode", "()Lcom/kakaoent/trevi/ad/data/UiMode;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BannerAppearance {
    @Nullable
    private final ColorIdSet strokeColor;
    @Nullable
    private final ColorIdSet textColor;
    @NotNull
    private final UiMode uiMode;

    public BannerAppearance() {
        this(null, null, null, 7, null);
    }

    public BannerAppearance(@Nullable ColorIdSet colorIdSet0, @Nullable ColorIdSet colorIdSet1, @NotNull UiMode uiMode0) {
        q.g(uiMode0, "uiMode");
        super();
        this.textColor = colorIdSet0;
        this.strokeColor = colorIdSet1;
        this.uiMode = uiMode0;
    }

    public BannerAppearance(ColorIdSet colorIdSet0, ColorIdSet colorIdSet1, UiMode uiMode0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            colorIdSet0 = null;
        }
        if((v & 2) != 0) {
            colorIdSet1 = null;
        }
        if((v & 4) != 0) {
            uiMode0 = UiMode.SYSTEM;
        }
        this(colorIdSet0, colorIdSet1, uiMode0);
    }

    @Nullable
    public final ColorIdSet component1() {
        return this.textColor;
    }

    @Nullable
    public final ColorIdSet component2() {
        return this.strokeColor;
    }

    @NotNull
    public final UiMode component3() {
        return this.uiMode;
    }

    @NotNull
    public final BannerAppearance copy(@Nullable ColorIdSet colorIdSet0, @Nullable ColorIdSet colorIdSet1, @NotNull UiMode uiMode0) {
        q.g(uiMode0, "uiMode");
        return new BannerAppearance(colorIdSet0, colorIdSet1, uiMode0);
    }

    public static BannerAppearance copy$default(BannerAppearance bannerAppearance0, ColorIdSet colorIdSet0, ColorIdSet colorIdSet1, UiMode uiMode0, int v, Object object0) {
        if((v & 1) != 0) {
            colorIdSet0 = bannerAppearance0.textColor;
        }
        if((v & 2) != 0) {
            colorIdSet1 = bannerAppearance0.strokeColor;
        }
        if((v & 4) != 0) {
            uiMode0 = bannerAppearance0.uiMode;
        }
        return bannerAppearance0.copy(colorIdSet0, colorIdSet1, uiMode0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BannerAppearance)) {
            return false;
        }
        if(!q.b(this.textColor, ((BannerAppearance)object0).textColor)) {
            return false;
        }
        return q.b(this.strokeColor, ((BannerAppearance)object0).strokeColor) ? this.uiMode == ((BannerAppearance)object0).uiMode : false;
    }

    @Nullable
    public final ColorIdSet getStrokeColor() {
        return this.strokeColor;
    }

    @Nullable
    public final ColorIdSet getTextColor() {
        return this.textColor;
    }

    @NotNull
    public final UiMode getUiMode() {
        return this.uiMode;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.textColor == null ? 0 : this.textColor.hashCode();
        ColorIdSet colorIdSet0 = this.strokeColor;
        if(colorIdSet0 != null) {
            v = colorIdSet0.hashCode();
        }
        return this.uiMode.hashCode() + (v1 * 0x1F + v) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "BannerAppearance(textColor=" + this.textColor + ", strokeColor=" + this.strokeColor + ", uiMode=" + this.uiMode + ')';
    }
}

