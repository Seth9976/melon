package com.google.android.gms.cast.framework.internal.featurehighlight;

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
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R.dimen;
import com.google.android.gms.cast.framework.R.integer;
import com.google.android.gms.internal.cast.zzgh;

class InnerZoneDrawable extends Drawable {
    private final Paint zza;
    private final Paint zzb;
    private final Rect zzc;
    private final int zzd;
    private final int zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;

    public InnerZoneDrawable(Context context0) {
        Paint paint0 = new Paint();
        this.zza = paint0;
        Paint paint1 = new Paint();
        this.zzb = paint1;
        this.zzc = new Rect();
        this.zzg = 1.0f;
        Resources resources0 = context0.getResources();
        this.zzd = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zze = resources0.getInteger(integer.cast_libraries_material_featurehighlight_pulse_base_alpha);
        paint0.setAntiAlias(true);
        Paint.Style paint$Style0 = Paint.Style.FILL;
        paint0.setStyle(paint$Style0);
        paint0.setColor(-1);
        paint1.setAntiAlias(true);
        paint1.setStyle(paint$Style0);
        paint1.setColor(-1);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        float f = this.zzk;
        if(f > 0.0f) {
            float f1 = this.zzf * this.zzj;
            this.zzb.setAlpha(((int)(((float)this.zze) * f)));
            canvas0.drawCircle(this.zzh, this.zzi, f1, this.zzb);
        }
        canvas0.drawCircle(this.zzh, this.zzi, this.zzf * this.zzg, this.zza);
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        this.zza.setAlpha(v);
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.zza.setColorFilter(colorFilter0);
        this.invalidateSelf();
    }

    @Keep
    public void setPulseAlpha(float f) {
        this.zzk = f;
        this.invalidateSelf();
    }

    @Keep
    public void setPulseScale(float f) {
        this.zzj = f;
        this.invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.zzg = f;
        this.invalidateSelf();
    }

    public final Animator zza() {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0}), PropertyValuesHolder.ofFloat("pulseScale", new float[]{0.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{0.0f})});
        objectAnimator0.setInterpolator(zzgh.zza());
        return objectAnimator0.setDuration(200L);
    }

    public final void zzb(Rect rect0) {
        this.zzc.set(rect0);
        this.zzh = this.zzc.exactCenterX();
        this.zzi = this.zzc.exactCenterY();
        float f = Math.max(((float)this.zzc.width()) / 2.0f, ((float)this.zzc.height()) / 2.0f);
        this.zzf = Math.max(this.zzd, f);
        this.invalidateSelf();
    }
}

