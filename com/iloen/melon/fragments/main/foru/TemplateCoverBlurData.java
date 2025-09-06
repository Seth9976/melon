package com.iloen.melon.fragments.main.foru;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/TemplateCoverBlurData;", "", "bgBitmap", "Landroid/graphics/Bitmap;", "shadowColor", "", "<init>", "(Landroid/graphics/Bitmap;I)V", "getBgBitmap", "()Landroid/graphics/Bitmap;", "getShadowColor", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverBlurData {
    public static final int $stable = 8;
    @NotNull
    private final Bitmap bgBitmap;
    private final int shadowColor;

    public TemplateCoverBlurData(@NotNull Bitmap bitmap0, int v) {
        q.g(bitmap0, "bgBitmap");
        super();
        this.bgBitmap = bitmap0;
        this.shadowColor = v;
    }

    @NotNull
    public final Bitmap component1() {
        return this.bgBitmap;
    }

    public final int component2() {
        return this.shadowColor;
    }

    @NotNull
    public final TemplateCoverBlurData copy(@NotNull Bitmap bitmap0, int v) {
        q.g(bitmap0, "bgBitmap");
        return new TemplateCoverBlurData(bitmap0, v);
    }

    public static TemplateCoverBlurData copy$default(TemplateCoverBlurData templateCoverBlurData0, Bitmap bitmap0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            bitmap0 = templateCoverBlurData0.bgBitmap;
        }
        if((v1 & 2) != 0) {
            v = templateCoverBlurData0.shadowColor;
        }
        return templateCoverBlurData0.copy(bitmap0, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TemplateCoverBlurData)) {
            return false;
        }
        return q.b(this.bgBitmap, ((TemplateCoverBlurData)object0).bgBitmap) ? this.shadowColor == ((TemplateCoverBlurData)object0).shadowColor : false;
    }

    @NotNull
    public final Bitmap getBgBitmap() {
        return this.bgBitmap;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    @Override
    public int hashCode() {
        return this.shadowColor + this.bgBitmap.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "TemplateCoverBlurData(bgBitmap=" + this.bgBitmap + ", shadowColor=" + this.shadowColor + ")";
    }
}

