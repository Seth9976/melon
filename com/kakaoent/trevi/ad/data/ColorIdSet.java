package com.kakaoent.trevi.ad.data;

import androidx.annotation.Keep;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000B\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/data/ColorIdSet;", "", "lightMode", "", "darkMode", "(II)V", "getDarkMode", "()I", "getLightMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ColorIdSet {
    private final int darkMode;
    private final int lightMode;

    public ColorIdSet(int v, int v1) {
        this.lightMode = v;
        this.darkMode = v1;
    }

    public final int component1() {
        return this.lightMode;
    }

    public final int component2() {
        return this.darkMode;
    }

    @NotNull
    public final ColorIdSet copy(int v, int v1) {
        return new ColorIdSet(v, v1);
    }

    public static ColorIdSet copy$default(ColorIdSet colorIdSet0, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = colorIdSet0.lightMode;
        }
        if((v2 & 2) != 0) {
            v1 = colorIdSet0.darkMode;
        }
        return colorIdSet0.copy(v, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ColorIdSet)) {
            return false;
        }
        return this.lightMode == ((ColorIdSet)object0).lightMode ? this.darkMode == ((ColorIdSet)object0).darkMode : false;
    }

    public final int getDarkMode() {
        return this.darkMode;
    }

    public final int getLightMode() {
        return this.lightMode;
    }

    @Override
    public int hashCode() {
        return this.darkMode + this.lightMode * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ColorIdSet(lightMode=");
        stringBuilder0.append(this.lightMode);
        stringBuilder0.append(", darkMode=");
        return o.q(stringBuilder0, this.darkMode, ')');
    }
}

