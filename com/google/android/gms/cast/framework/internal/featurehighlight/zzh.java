package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import c2.k;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.internal.cast.zzfy;
import com.google.android.gms.internal.cast.zzgh;

public final class zzh extends ViewGroup {
    Animator zza;
    private final int[] zzb;
    private final Rect zzc;
    private final Rect zzd;
    private final OuterHighlightDrawable zze;
    private final InnerZoneDrawable zzf;
    private View zzg;
    private final zzi zzh;
    private final k zzi;
    private k zzj;
    private zzg zzk;
    private boolean zzl;
    private HelpTextView zzm;

    public zzh(Context context0) {
        super(context0);
        this.zzb = new int[2];
        this.zzc = new Rect();
        this.zzd = new Rect();
        this.setId(id.cast_featurehighlight_view);
        this.setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable0 = new InnerZoneDrawable(context0);
        this.zzf = innerZoneDrawable0;
        innerZoneDrawable0.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable0 = new OuterHighlightDrawable(context0);
        this.zze = outerHighlightDrawable0;
        outerHighlightDrawable0.setCallback(this);
        this.zzh = new zzi(this);
        k k0 = new k(context0, new zza(this));
        this.zzi = k0;
        k0.a.setIsLongpressEnabled(false);
        this.setVisibility(8);
    }

    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new ViewGroup.MarginLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        canvas0.save();
        OuterHighlightDrawable outerHighlightDrawable0 = this.zze;
        outerHighlightDrawable0.draw(canvas0);
        this.zzf.draw(canvas0);
        View view0 = this.zzg;
        if(view0 == null) {
            throw new IllegalStateException("Neither target view nor drawable was set");
        }
        if(view0.getParent() != null) {
            Bitmap bitmap0 = Bitmap.createBitmap(this.zzg.getWidth(), this.zzg.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(bitmap0);
            this.zzg.draw(canvas1);
            int v = outerHighlightDrawable0.zzc();
            int v1 = Color.red(v);
            int v2 = Color.green(v);
            int v3 = Color.blue(v);
            for(int v4 = 0; v4 < bitmap0.getHeight(); ++v4) {
                for(int v5 = 0; v5 < bitmap0.getWidth(); ++v5) {
                    int v6 = bitmap0.getPixel(v5, v4);
                    if(Color.alpha(v6) != 0) {
                        bitmap0.setPixel(v5, v4, Color.argb(Color.alpha(v6), v1, v2, v3));
                    }
                }
            }
            canvas0.drawBitmap(bitmap0, ((float)this.zzc.left), ((float)this.zzc.top), null);
        }
        canvas0.restore();
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        View view0 = this.zzg;
        if(view0 == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        if(view0.getParent() != null) {
            View view1 = this.zzg;
            this.getLocationInWindow(this.zzb);
            int v4 = this.zzb[0];
            int v5 = this.zzb[1];
            view1.getLocationInWindow(this.zzb);
            this.zzb[0] -= v4;
            this.zzb[1] -= v5;
        }
        int v6 = this.zzb[0];
        int v7 = this.zzb[1];
        int v8 = this.zzg.getWidth();
        int v9 = this.zzb[1];
        int v10 = this.zzg.getHeight();
        this.zzc.set(v6, v7, v8 + v6, v10 + v9);
        this.zzd.set(v, v1, v2, v3);
        this.zze.setBounds(this.zzd);
        this.zzf.setBounds(this.zzd);
        this.zzh.zza(this.zzc, this.zzd);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getSize(v1);
        this.setMeasuredDimension(View.resolveSize(v2, v), View.resolveSize(v3, v1));
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            int v1 = (int)motionEvent0.getX();
            int v2 = (int)motionEvent0.getY();
            this.zzl = this.zzc.contains(v1, v2);
            v = 0;
        }
        if(this.zzl) {
            k k0 = this.zzj;
            if(k0 != null) {
                k0.a.onTouchEvent(motionEvent0);
                if(v == 1) {
                    motionEvent0 = MotionEvent.obtain(motionEvent0);
                    motionEvent0.setAction(3);
                }
            }
            if(this.zzg.getParent() != null) {
                this.zzg.onTouchEvent(motionEvent0);
            }
            return true;
        }
        this.zzi.a.onTouchEvent(motionEvent0);
        return true;
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.zze || drawable0 == this.zzf || drawable0 == null;
    }

    public static Animator zza(zzh zzh0) {
        Animator animator0 = new AnimatorSet();
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(zzh0.zzf, "scale", new float[]{1.0f, 1.1f}).setDuration(500L);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(zzh0.zzf, "scale", new float[]{1.1f, 1.0f}).setDuration(500L);
        PropertyValuesHolder[] arr_propertyValuesHolder = {PropertyValuesHolder.ofFloat("pulseScale", new float[]{1.1f, 2.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{1.0f, 0.0f})};
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(zzh0.zzf, arr_propertyValuesHolder).setDuration(500L);
        ((AnimatorSet)animator0).play(objectAnimator0);
        ((AnimatorSet)animator0).play(objectAnimator1).with(objectAnimator2).after(objectAnimator0);
        ((AnimatorSet)animator0).setInterpolator(zzgh.zzb());
        ((AnimatorSet)animator0).setStartDelay(500L);
        zzfy.zzd(animator0, -1, null);
        return animator0;
    }

    public final View zzb() {
        return this.zzm;
    }

    public static zzg zzc(zzh zzh0) {
        return zzh0.zzk;
    }

    public final InnerZoneDrawable zzd() {
        return this.zzf;
    }

    public static OuterHighlightDrawable zze(zzh zzh0) {
        return zzh0.zze;
    }

    public final OuterHighlightDrawable zzf() {
        return this.zze;
    }

    public final void zzg(Runnable runnable0) {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this.zzm, "alpha", new float[]{0.0f}).setDuration(200L);
        objectAnimator0.setInterpolator(zzgh.zza());
        PropertyValuesHolder[] arr_propertyValuesHolder = {PropertyValuesHolder.ofFloat("scale", new float[]{1.125f}), PropertyValuesHolder.ofInt("alpha", new int[]{0})};
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this.zze, arr_propertyValuesHolder);
        objectAnimator1.setInterpolator(zzgh.zza());
        Animator animator0 = objectAnimator1.setDuration(200L);
        Animator animator1 = this.zzf.zza();
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.playTogether(new Animator[]{objectAnimator0, animator0, animator1});
        animatorSet0.addListener(new zze(this, runnable0));
        this.zzo(animatorSet0);
    }

    public final void zzh(Runnable runnable0) {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this.zzm, "alpha", new float[]{0.0f}).setDuration(200L);
        objectAnimator0.setInterpolator(zzgh.zza());
        float f = this.zzc.exactCenterX();
        float f1 = this.zzc.exactCenterY();
        PropertyValuesHolder propertyValuesHolder0 = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f});
        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofInt("alpha", new int[]{0});
        PropertyValuesHolder[] arr_propertyValuesHolder = {propertyValuesHolder0, PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, f - this.zze.zza()}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, f1 - this.zze.zzb()}), propertyValuesHolder1};
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this.zze, arr_propertyValuesHolder);
        objectAnimator1.setInterpolator(zzgh.zza());
        Animator animator0 = objectAnimator1.setDuration(200L);
        Animator animator1 = this.zzf.zza();
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.playTogether(new Animator[]{objectAnimator0, animator0, animator1});
        animatorSet0.addListener(new zzf(this, runnable0));
        this.zzo(animatorSet0);
    }

    public final void zzi(View view0, View view1, boolean z, zzg zzg0) {
        this.zzg = view0;
        this.zzk = zzg0;
        zzb zzb0 = new zzb(this, view0, true, zzg0);
        k k0 = new k(this.getContext(), zzb0);
        this.zzj = k0;
        k0.a.setIsLongpressEnabled(false);
        this.setVisibility(4);
    }

    public final void zzj(int v) {
        this.zze.zze(v);
    }

    public final void zzk() {
        if(this.zzg == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        this.setVisibility(0);
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this.zzm, "alpha", new float[]{0.0f, 1.0f}).setDuration(350L);
        objectAnimator0.setInterpolator(zzgh.zzc());
        float f = this.zzc.exactCenterX();
        float f1 = this.zzc.exactCenterY();
        Animator animator0 = this.zze.zzd(f - this.zze.zza(), f1 - this.zze.zzb());
        PropertyValuesHolder[] arr_propertyValuesHolder = {PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, 0xFF})};
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this.zzf, arr_propertyValuesHolder);
        objectAnimator1.setInterpolator(zzgh.zzc());
        Animator animator1 = objectAnimator1.setDuration(350L);
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.playTogether(new Animator[]{objectAnimator0, animator0, animator1});
        animatorSet0.addListener(new zzd(this));
        this.zzo(animatorSet0);
    }

    public final void zzl(Runnable runnable0) {
        this.addOnLayoutChangeListener(new zzc(this, null));
    }

    public static boolean zzm(zzh zzh0, float f, float f1) {
        return zzh0.zzd.contains(Math.round(f), Math.round(f1));
    }

    public final void zzn(HelpTextView helpTextView0) {
        helpTextView0.getClass();
        this.zzm = helpTextView0;
        this.addView(helpTextView0, 0);
    }

    private final void zzo(Animator animator0) {
        Animator animator1 = this.zza;
        if(animator1 != null) {
            animator1.cancel();
        }
        this.zza = animator0;
        animator0.start();
    }
}

