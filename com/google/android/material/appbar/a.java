package com.google.android.material.appbar;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import e1.n;
import java.util.ArrayList;
import z6.i;

public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final AppBarLayout a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final i d;
    public final Integer e;

    public a(AppBarLayout appBarLayout0, ColorStateList colorStateList0, ColorStateList colorStateList1, i i0, Integer integer0) {
        this.a = appBarLayout0;
        this.b = colorStateList0;
        this.c = colorStateList1;
        this.d = i0;
        this.e = integer0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        AppBarLayout appBarLayout0 = this.a;
        ArrayList arrayList0 = appBarLayout0.B;
        int v = n.A(((float)(((Float)valueAnimator0.getAnimatedValue()))), this.b.getDefaultColor(), this.c.getDefaultColor());
        ColorStateList colorStateList0 = ColorStateList.valueOf(v);
        i i0 = this.d;
        i0.m(colorStateList0);
        if(appBarLayout0.I != null && (appBarLayout0.M != null && appBarLayout0.M.equals(this.e))) {
            appBarLayout0.I.setTint(v);
        }
        if(!arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                if(object0 != null) {
                    throw new ClassCastException();
                }
                if(i0.a.c != null) {
                    throw null;
                }
            }
        }
    }
}

