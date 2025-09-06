package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.iloen.melon.utils.image.ImageUtils;
import k8.t1;

public class BlurImageView extends MelonImageView {
    public final float f;
    public int g;
    public boolean h;

    public BlurImageView(Context context0) {
        this(context0, null);
    }

    public BlurImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.f = 25.0f;
        this.g = 0;
        this.h = true;
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.c);
        try {
            this.f = typedArray0.getFloat(1, 25.0f);
            this.g = typedArray0.getColor(2, 0);
            Drawable drawable0 = typedArray0.getDrawable(0);
            if(drawable0 != null) {
                this.setImageDrawable(drawable0);
            }
        }
        finally {
            typedArray0.recycle();
        }
    }

    public static void c(BlurImageView blurImageView0, Bitmap bitmap0) {
        blurImageView0.super.setImageDrawable(new BitmapDrawable(blurImageView0.getResources(), bitmap0));
    }

    public int getDimmedColor() {
        return this.g;
    }

    public i getOnBlurUpdateListener() {
        return null;
    }

    @Override  // com.iloen.melon.custom.MelonImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.h) {
            int v = this.g;
            if(v != 0) {
                canvas0.drawColor(v);
            }
        }
    }

    public void setBlured(boolean z) {
        this.h = z;
    }

    public void setDimmedColor(int v) {
        this.g = v;
        this.requestLayout();
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable0) {
        Bitmap bitmap0 = ImageUtils.drawableToBitmap(drawable0);
        if(bitmap0 != null) {
            new h(this, this.getContext()).execute(bitmap0);
            return;
        }
        super.setImageDrawable(drawable0);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int v) {
        Context context0 = this.getContext();
        Bitmap bitmap0 = BitmapFactory.decodeResource(this.getResources(), v);
        new h(this, context0).execute(bitmap0);
    }

    public void setOnBlurUpdateListener(i i0) {
    }
}

