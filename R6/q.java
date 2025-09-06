package r6;

import P1.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import x6.a;
import z6.i;

public final class q extends o {
    public StateListAnimator N;

    @Override  // r6.o
    public final float e() {
        return this.v.getElevation();
    }

    @Override  // r6.o
    public final void f(Rect rect0) {
        if(((FloatingActionButton)this.w.b).k) {
            super.f(rect0);
            return;
        }
        if(this.f) {
            FloatingActionButton floatingActionButton0 = this.v;
            int v = floatingActionButton0.getSizeDimension();
            int v1 = this.k;
            if(v < v1) {
                int v2 = (v1 - floatingActionButton0.getSizeDimension()) / 2;
                rect0.set(v2, v2, v2, v2);
                return;
            }
        }
        rect0.set(0, 0, 0, 0);
    }

    @Override  // r6.o
    public final void g(ColorStateList colorStateList0, PorterDuff.Mode porterDuff$Mode0, ColorStateList colorStateList1, int v) {
        i i1;
        z6.o o0 = this.a;
        o0.getClass();
        p p0 = new p(o0);  // 初始化器: Lz6/i;-><init>(Lz6/o;)V
        this.b = p0;
        p0.setTintList(colorStateList0);
        if(porterDuff$Mode0 != null) {
            this.b.setTintMode(porterDuff$Mode0);
        }
        FloatingActionButton floatingActionButton0 = this.v;
        this.b.k(floatingActionButton0.getContext());
        if(v > 0) {
            Context context0 = floatingActionButton0.getContext();
            z6.o o1 = this.a;
            o1.getClass();
            b b0 = new b(o1);
            int v1 = c.getColor(context0, 0x7F0600EE);  // color:design_fab_stroke_top_outer_color
            int v2 = c.getColor(context0, 0x7F0600ED);  // color:design_fab_stroke_top_inner_color
            int v3 = c.getColor(context0, 0x7F0600EB);  // color:design_fab_stroke_end_inner_color
            int v4 = c.getColor(context0, 0x7F0600EC);  // color:design_fab_stroke_end_outer_color
            b0.i = v1;
            b0.j = v2;
            b0.k = v3;
            b0.l = v4;
            if(Float.compare(b0.h, v) != 0) {
                b0.h = (float)v;
                b0.b.setStrokeWidth(((float)v) * 1.3333f);
                b0.n = true;
                b0.invalidateSelf();
            }
            if(colorStateList0 != null) {
                b0.m = colorStateList0.getColorForState(b0.getState(), b0.m);
            }
            b0.p = colorStateList0;
            b0.n = true;
            b0.invalidateSelf();
            this.d = b0;
            b b1 = this.d;
            b1.getClass();
            i i0 = this.b;
            i0.getClass();
            i1 = new LayerDrawable(new Drawable[]{b1, i0});
        }
        else {
            this.d = null;
            i1 = this.b;
        }
        RippleDrawable rippleDrawable0 = new RippleDrawable(a.c(colorStateList1), i1, null);
        this.c = rippleDrawable0;
        this.e = rippleDrawable0;
    }

    @Override  // r6.o
    public final void h() {
    }

    @Override  // r6.o
    public final void i() {
        this.r();
    }

    @Override  // r6.o
    public final void j(int[] arr_v) {
    }

    @Override  // r6.o
    public final void k(float f, float f1, float f2) {
        FloatingActionButton floatingActionButton0 = this.v;
        if(floatingActionButton0.getStateListAnimator() == this.N) {
            StateListAnimator stateListAnimator0 = new StateListAnimator();
            AnimatorSet animatorSet0 = this.s(f, f2);
            stateListAnimator0.addState(o.H, animatorSet0);
            AnimatorSet animatorSet1 = this.s(f, f1);
            stateListAnimator0.addState(o.I, animatorSet1);
            AnimatorSet animatorSet2 = this.s(f, f1);
            stateListAnimator0.addState(o.J, animatorSet2);
            AnimatorSet animatorSet3 = this.s(f, f1);
            stateListAnimator0.addState(o.K, animatorSet3);
            AnimatorSet animatorSet4 = new AnimatorSet();
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(ObjectAnimator.ofFloat(floatingActionButton0, "elevation", new float[]{f}).setDuration(0L));
            arrayList0.add(ObjectAnimator.ofFloat(floatingActionButton0, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100L));
            animatorSet4.playSequentially(((Animator[])arrayList0.toArray(new Animator[0])));
            animatorSet4.setInterpolator(o.C);
            stateListAnimator0.addState(o.L, animatorSet4);
            AnimatorSet animatorSet5 = this.s(0.0f, 0.0f);
            stateListAnimator0.addState(o.M, animatorSet5);
            this.N = stateListAnimator0;
            floatingActionButton0.setStateListAnimator(stateListAnimator0);
        }
        if(this.p()) {
            this.r();
        }
    }

    @Override  // r6.o
    public final void n(ColorStateList colorStateList0) {
        Drawable drawable0 = this.c;
        if(drawable0 instanceof RippleDrawable) {
            ((RippleDrawable)drawable0).setColor(a.c(colorStateList0));
            return;
        }
        super.n(colorStateList0);
    }

    // 去混淆评级： 低(20)
    @Override  // r6.o
    public final boolean p() {
        return ((FloatingActionButton)this.w.b).k || this.f && this.v.getSizeDimension() < this.k;
    }

    @Override  // r6.o
    public final void q() {
    }

    public final AnimatorSet s(float f, float f1) {
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.play(ObjectAnimator.ofFloat(this.v, "elevation", new float[]{f}).setDuration(0L)).with(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[]{f1}).setDuration(100L));
        animatorSet0.setInterpolator(o.C);
        return animatorSet0;
    }
}

