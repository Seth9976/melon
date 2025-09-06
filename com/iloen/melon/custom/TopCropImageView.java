package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/custom/TopCropImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TopCropImageView extends AppCompatImageView {
    public TopCropImageView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public TopCropImageView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public TopCropImageView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public TopCropImageView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // android.widget.ImageView
    public final boolean setFrame(int v, int v1, int v2, int v3) {
        float f1;
        float f;
        if(this.getDrawable() != null) {
            Matrix matrix0 = this.getImageMatrix();
            q.f(matrix0, "getImageMatrix(...)");
            int v4 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v5 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            int v6 = this.getDrawable().getIntrinsicWidth();
            int v7 = this.getDrawable().getIntrinsicHeight();
            if(v6 * v5 > v7 * v4) {
                f = (float)v5;
                f1 = (float)v7;
            }
            else {
                f = (float)v4;
                f1 = (float)v6;
            }
            float f2 = f / f1;
            matrix0.setScale(f2, f2);
            matrix0.postTranslate(Math.abs(((float)v6) * f2 - ((float)v4)) / -2.0f, 0.0f);
            this.setImageMatrix(matrix0);
        }
        return super.setFrame(v, v1, v2, v3);
    }
}

