package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.framework.R.attr;
import com.google.android.gms.cast.framework.R.dimen;
import com.google.android.gms.cast.framework.R.style;
import com.google.android.gms.cast.framework.R.styleable;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

public class CastSeekBar extends View {
    public zze zza;
    public zzc zzb;
    public List zzc;
    public zzd zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(Context context0) {
        this(context0, null);
    }

    public CastSeekBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public CastSeekBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.zzc = new ArrayList();
        this.setAccessibilityDelegate(new zzf(this, null));
        Paint paint0 = new Paint(1);
        this.zzl = paint0;
        paint0.setStyle(Paint.Style.FILL);
        this.zzg = context0.getResources().getDimension(dimen.cast_seek_bar_minimum_width);
        this.zzh = context0.getResources().getDimension(dimen.cast_seek_bar_minimum_height);
        this.zzi = context0.getResources().getDimension(dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context0.getResources().getDimension(dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context0.getResources().getDimension(dimen.cast_seek_bar_ad_break_minimum_width);
        zze zze0 = new zze();
        this.zza = zze0;
        zze0.zzb = 1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, styleable.CastExpandedController, attr.castExpandedControllerStyle, style.CastExpandedController);
        int v1 = typedArray0.getResourceId(styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int v2 = typedArray0.getResourceId(styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int v3 = typedArray0.getResourceId(styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int v4 = typedArray0.getResourceId(styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context0.getResources().getColor(v1);
        this.zzn = context0.getResources().getColor(v2);
        this.zzo = context0.getResources().getColor(v3);
        this.zzp = context0.getResources().getColor(v4);
        typedArray0.recycle();
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        return this.zzf == null ? this.zza.zza : ((int)this.zzf);
    }

    @Override  // android.view.View
    public void onDetachedFromWindow() {
        Runnable runnable0 = this.zzs;
        if(runnable0 != null) {
            this.removeCallbacks(runnable0);
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
        int v15;
        int v14;
        int v9;
        int v = canvas0.save();
        canvas0.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
        zzc zzc0 = this.zzb;
        if(zzc0 == null) {
            int v1 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v2 = this.getMeasuredHeight();
            int v3 = this.getPaddingTop();
            int v4 = this.getPaddingBottom();
            int v5 = this.getProgress();
            int v6 = canvas0.save();
            canvas0.translate(0.0f, ((float)((v2 - v3 - v4) / 2)));
            zze zze0 = this.zza;
            if(zze0.zzf) {
                int v7 = zze0.zzd;
                if(v7 > 0) {
                    this.zzg(canvas0, 0, v7, zze0.zzb, v1, this.zzo);
                }
                zze zze1 = this.zza;
                int v8 = zze1.zzd;
                if(v5 > v8) {
                    this.zzg(canvas0, v8, v5, zze1.zzb, v1, this.zzm);
                }
                v9 = v5;
                zze zze2 = this.zza;
                int v10 = zze2.zze;
                if(v10 > v9) {
                    this.zzg(canvas0, v9, v10, zze2.zzb, v1, this.zzn);
                }
                int v11 = this.zza.zzb;
                int v12 = this.zza.zze;
                if(v11 > v12) {
                    this.zzg(canvas0, v12, v11, v11, v1, this.zzo);
                }
            }
            else {
                int v13 = Math.max(zze0.zzc, 0);
                if(v13 > 0) {
                    v14 = v13;
                    this.zzg(canvas0, 0, v14, this.zza.zzb, v1, this.zzo);
                }
                else {
                    v14 = v13;
                }
                if(v5 > v14) {
                    this.zzg(canvas0, v14, v5, this.zza.zzb, v1, this.zzm);
                }
                v15 = v5;
                int v16 = this.zza.zzb;
                if(v16 > v15) {
                    this.zzg(canvas0, v15, v16, v16, v1, this.zzo);
                }
            }
            canvas0.restoreToCount(v6);
            List list0 = this.zzc;
            if(list0 != null && !list0.isEmpty()) {
                Paint paint0 = this.zzl;
                paint0.setColor(this.zzp);
                int v17 = this.getMeasuredWidth();
                int v18 = this.getPaddingLeft();
                int v19 = this.getPaddingRight();
                int v20 = this.getMeasuredHeight();
                int v21 = this.getPaddingTop();
                int v22 = this.getPaddingBottom();
                int v23 = canvas0.save();
                canvas0.translate(0.0f, ((float)((v20 - v21 - v22) / 2)));
                for(Object object0: list0) {
                    zzb zzb0 = (zzb)object0;
                    if(zzb0 != null) {
                        int v24 = Math.min(zzb0.zza, this.zza.zzb);
                        float f = (float)(v17 - v18 - v19);
                        float f1 = (float)this.zza.zzb;
                        float f2 = this.zzk;
                        float f3 = ((float)((zzb0.zzc ? zzb0.zzb : 1) + v24)) * f / f1;
                        float f4 = ((float)v24) * f / f1;
                        if(f3 - f4 < f2) {
                            f3 = f4 + f2;
                        }
                        if(f3 <= f) {
                            f = f3;
                        }
                        if(f - f4 < f2) {
                            f4 = f - f2;
                        }
                        canvas0.drawRect(f4, -this.zzi, f, this.zzi, paint0);
                    }
                }
                canvas0.restoreToCount(v23);
            }
            if(this.isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int v25 = this.getMeasuredWidth();
                int v26 = this.getPaddingLeft();
                int v27 = this.getPaddingRight();
                int v28 = this.getMeasuredHeight();
                int v29 = this.getPaddingTop();
                int v30 = this.getPaddingBottom();
                double f5 = (double)this.getProgress();
                double f6 = (double)this.zza.zzb;
                int v31 = canvas0.save();
                canvas0.drawCircle(((float)(((int)(f5 / f6 * ((double)(v25 - v26 - v27)))))), ((float)(v28 - v29 - v30)) / 2.0f, this.zzj, this.zzl);
                canvas0.restoreToCount(v31);
            }
        }
        else {
            int v32 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v33 = this.getMeasuredHeight();
            int v34 = this.getPaddingTop();
            int v35 = this.getPaddingBottom();
            int v36 = canvas0.save();
            canvas0.translate(0.0f, ((float)((v33 - v34 - v35) / 2)));
            this.zzg(canvas0, 0, zzc0.zza, zzc0.zzb, v32, this.zzp);
            this.zzg(canvas0, zzc0.zza, zzc0.zzb, zzc0.zzb, v32, this.zzo);
            canvas0.restoreToCount(v36);
        }
        canvas0.restoreToCount(v);
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        synchronized(this) {
            float f = (float)this.getPaddingLeft();
            float f1 = (float)this.getPaddingRight();
            float f2 = (float)this.getPaddingTop();
            float f3 = (float)this.getPaddingBottom();
            this.setMeasuredDimension(View.resolveSizeAndState(((int)(this.zzg + f + f1)), v, 0), View.resolveSizeAndState(((int)(this.zzh + f2 + f3)), v1, 0));
        }
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.isEnabled() && this.zza.zzf) {
            if(this.zzr == null) {
                this.zzr = new Point();
            }
            if(this.zzq == null) {
                this.zzq = new int[2];
            }
            this.getLocationOnScreen(this.zzq);
            this.zzr.set(((int)motionEvent0.getRawX()) - this.zzq[0] - this.getPaddingLeft(), ((int)motionEvent0.getRawY()) - this.zzq[1]);
            int v = motionEvent0.getAction();
            switch(v) {
                case 0: {
                    this.zzi();
                    this.zzh(this.zzf(this.zzr.x));
                    return true;
                }
                case 1: {
                    this.zzh(this.zzf(this.zzr.x));
                    this.zzj();
                    return true;
                }
                case 2: {
                    this.zzh(this.zzf(this.zzr.x));
                    return true;
                label_18:
                    if(v == 3) {
                        this.zze = false;
                        this.zzf = null;
                        zzd zzd0 = this.zzd;
                        if(zzd0 != null) {
                            zzd0.zza(this, this.getProgress(), true);
                            this.zzd.zzc(this);
                        }
                        this.postInvalidate();
                        return true;
                    }
                    break;
                }
                default: {
                    goto label_18;
                }
            }
        }
        return false;
    }

    public final void zzd(List list0) {
        if(Objects.equal(this.zzc, list0)) {
            return;
        }
        this.zzc = list0 == null ? null : new ArrayList(list0);
        this.postInvalidate();
    }

    public final void zze(zze zze0) {
        if(!this.zze) {
            zze zze1 = new zze();
            zze1.zza = zze0.zza;
            zze1.zzb = zze0.zzb;
            zze1.zzc = zze0.zzc;
            zze1.zzd = zze0.zzd;
            zze1.zze = zze0.zze;
            zze1.zzf = zze0.zzf;
            this.zza = zze1;
            this.zzf = null;
            zzd zzd0 = this.zzd;
            if(zzd0 != null) {
                zzd0.zza(this, this.getProgress(), false);
            }
            this.postInvalidate();
        }
    }

    private final int zzf(int v) {
        return (int)(((double)v) / ((double)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight())) * ((double)this.zza.zzb));
    }

    private final void zzg(Canvas canvas0, int v, int v1, int v2, int v3, int v4) {
        this.zzl.setColor(v4);
        canvas0.drawRect(((float)v) / ((float)v2) * ((float)v3), -this.zzi, ((float)v1) / ((float)v2) * ((float)v3), this.zzi, this.zzl);
    }

    private final void zzh(int v) {
        zze zze0 = this.zza;
        if(!zze0.zzf) {
            return;
        }
        this.zzf = Math.min(Math.max(v, zze0.zzd), zze0.zze);
        zzd zzd0 = this.zzd;
        if(zzd0 != null) {
            zzd0.zza(this, this.getProgress(), true);
        }
        Runnable runnable0 = this.zzs;
        if(runnable0 == null) {
            this.zzs = new zza(this);
        }
        else {
            this.removeCallbacks(runnable0);
        }
        this.postDelayed(this.zzs, 200L);
        this.postInvalidate();
    }

    private final void zzi() {
        this.zze = true;
        zzd zzd0 = this.zzd;
        if(zzd0 != null) {
            zzd0.zzb(this);
        }
    }

    private final void zzj() {
        this.zze = false;
        zzd zzd0 = this.zzd;
        if(zzd0 != null) {
            zzd0.zzc(this);
        }
    }
}

