package com.google.android.gms.cast.framework.internal.featurehighlight;

import S1.c;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R.dimen;
import com.google.android.gms.internal.cast.zzgh;
import com.google.android.gms.internal.cast.zzgi;

class OuterHighlightDrawable extends Drawable {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final Rect zzd;
    private final Rect zze;
    private final Paint zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    public OuterHighlightDrawable(Context context0) {
        this.zzd = new Rect();
        this.zze = new Rect();
        Paint paint0 = new Paint();
        this.zzf = paint0;
        this.zzh = 1.0f;
        this.zzk = 0.0f;
        this.zzl = 0.0f;
        this.zzm = 0xF4;
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x1010433, typedValue0, true);
        paint0.setColor(c.k(typedValue0.data, 0xF4));
        this.zzm = paint0.getAlpha();
        paint0.setAntiAlias(true);
        paint0.setStyle(Paint.Style.FILL);
        Resources resources0 = context0.getResources();
        this.zza = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzb = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.zzc = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        canvas0.drawCircle(this.zzi + this.zzk, this.zzj + this.zzl, this.zzg * this.zzh, this.zzf);
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.zzf.getAlpha();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        this.zzf.setAlpha(v);
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.zzf.setColorFilter(colorFilter0);
        this.invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.zzh = f;
        this.invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f) {
        this.zzk = f;
        this.invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f) {
        this.zzl = f;
        this.invalidateSelf();
    }

    public final float zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzf.getColor();
    }

    public final Animator zzd(float f, float f1) {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("translationX", new float[]{f, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{f1, 0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, this.zzm})});
        objectAnimator0.setInterpolator(zzgh.zzc());
        return objectAnimator0.setDuration(350L);
    }

    public final void zze(int v) {
        this.zzf.setColor(v);
        this.zzm = this.zzf.getAlpha();
        this.invalidateSelf();
    }

    public final void zzf(Rect rect0, Rect rect1) {
        this.zzd.set(rect0);
        this.zze.set(rect1);
        float f = rect0.exactCenterX();
        float f1 = rect0.exactCenterY();
        Rect rect2 = this.getBounds();
        if(Math.min(f1 - ((float)rect2.top), ((float)rect2.bottom) - f1) < ((float)this.zza)) {
            this.zzi = f;
        }
        else {
            this.zzi = f <= rect2.exactCenterX() ? rect1.exactCenterX() + ((float)this.zzb) : rect1.exactCenterX() - ((float)this.zzb);
            f1 = rect1.exactCenterY();
        }
        this.zzj = f1;
        float f2 = Math.max(OuterHighlightDrawable.zzh(this.zzi, f1, rect0), OuterHighlightDrawable.zzh(this.zzi, this.zzj, rect1));
        this.zzg = ((float)this.zzc) + f2;
        this.invalidateSelf();
    }

    public final boolean zzg(float f, float f1) {
        return zzgi.zza(f, f1, this.zzi, this.zzj) < this.zzg;
    }

    private static final float zzh(float f, float f1, Rect rect0) {
        float f2 = zzgi.zza(f, f1, rect0.left, rect0.top);
        float f3 = zzgi.zza(f, f1, rect0.right, rect0.top);
        float f4 = zzgi.zza(f, f1, rect0.right, rect0.bottom);
        float f5 = zzgi.zza(f, f1, rect0.left, rect0.bottom);
        if(Float.compare(f2, f3) <= 0 || f2 <= f4 || f2 <= f5) {
            if(f3 > f4 && f3 > f5) {
                return (float)Math.ceil(f3);
            }
            if(f4 <= f5) {
                return (float)Math.ceil(f5);
            }
            f2 = f4;
        }
        return (float)Math.ceil(f2);
    }
}

