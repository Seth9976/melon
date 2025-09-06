package com.kakaoent.trevi.ad.data;

import androidx.annotation.Keep;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0007HÆ\u0003J)\u0010\u0012\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2 = {"Lcom/kakaoent/trevi/ad/data/BannerOptions;", "", "bannerAppearance", "Lcom/kakaoent/trevi/ad/data/BannerAppearance;", "autoPlayMode", "Lcom/kakaoent/trevi/ad/data/AutoPlayMode;", "keepStateHashCode", "", "(Lcom/kakaoent/trevi/ad/data/BannerAppearance;Lcom/kakaoent/trevi/ad/data/AutoPlayMode;I)V", "getAutoPlayMode", "()Lcom/kakaoent/trevi/ad/data/AutoPlayMode;", "getBannerAppearance", "()Lcom/kakaoent/trevi/ad/data/BannerAppearance;", "getKeepStateHashCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BannerOptions {
    @NotNull
    private final AutoPlayMode autoPlayMode;
    @Nullable
    private final BannerAppearance bannerAppearance;
    private final int keepStateHashCode;

    public BannerOptions() {
        this(null, null, 0, 7, null);
    }

    public BannerOptions(@Nullable BannerAppearance bannerAppearance0, @NotNull AutoPlayMode autoPlayMode0, int v) {
        q.g(autoPlayMode0, "autoPlayMode");
        super();
        this.bannerAppearance = bannerAppearance0;
        this.autoPlayMode = autoPlayMode0;
        this.keepStateHashCode = v;
    }

    public BannerOptions(BannerAppearance bannerAppearance0, AutoPlayMode autoPlayMode0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            bannerAppearance0 = null;
        }
        if((v1 & 2) != 0) {
            autoPlayMode0 = AutoPlayMode.AUTO_PLAY;
        }
        if((v1 & 4) != 0) {
            v = 0;
        }
        this(bannerAppearance0, autoPlayMode0, v);
    }

    @Nullable
    public final BannerAppearance component1() {
        return this.bannerAppearance;
    }

    @NotNull
    public final AutoPlayMode component2() {
        return this.autoPlayMode;
    }

    public final int component3() {
        return this.keepStateHashCode;
    }

    @NotNull
    public final BannerOptions copy(@Nullable BannerAppearance bannerAppearance0, @NotNull AutoPlayMode autoPlayMode0, int v) {
        q.g(autoPlayMode0, "autoPlayMode");
        return new BannerOptions(bannerAppearance0, autoPlayMode0, v);
    }

    public static BannerOptions copy$default(BannerOptions bannerOptions0, BannerAppearance bannerAppearance0, AutoPlayMode autoPlayMode0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            bannerAppearance0 = bannerOptions0.bannerAppearance;
        }
        if((v1 & 2) != 0) {
            autoPlayMode0 = bannerOptions0.autoPlayMode;
        }
        if((v1 & 4) != 0) {
            v = bannerOptions0.keepStateHashCode;
        }
        return bannerOptions0.copy(bannerAppearance0, autoPlayMode0, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BannerOptions)) {
            return false;
        }
        if(!q.b(this.bannerAppearance, ((BannerOptions)object0).bannerAppearance)) {
            return false;
        }
        return this.autoPlayMode == ((BannerOptions)object0).autoPlayMode ? this.keepStateHashCode == ((BannerOptions)object0).keepStateHashCode : false;
    }

    @NotNull
    public final AutoPlayMode getAutoPlayMode() {
        return this.autoPlayMode;
    }

    @Nullable
    public final BannerAppearance getBannerAppearance() {
        return this.bannerAppearance;
    }

    public final int getKeepStateHashCode() {
        return this.keepStateHashCode;
    }

    @Override
    public int hashCode() {
        return this.bannerAppearance == null ? this.keepStateHashCode + this.autoPlayMode.hashCode() * 0x1F : this.keepStateHashCode + (this.autoPlayMode.hashCode() + this.bannerAppearance.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BannerOptions(bannerAppearance=");
        stringBuilder0.append(this.bannerAppearance);
        stringBuilder0.append(", autoPlayMode=");
        stringBuilder0.append(this.autoPlayMode);
        stringBuilder0.append(", keepStateHashCode=");
        return o.q(stringBuilder0, this.keepStateHashCode, ')');
    }
}

