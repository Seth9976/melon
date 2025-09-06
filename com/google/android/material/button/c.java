package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import e1.n;
import x6.a;
import z6.i;
import z6.o;
import z6.y;

public final class c {
    public final MaterialButton a;
    public o b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public i m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public RippleDrawable s;
    public int t;

    public c(MaterialButton materialButton0, o o0) {
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = true;
        this.a = materialButton0;
        this.b = o0;
    }

    public final y a() {
        if(this.s != null && this.s.getNumberOfLayers() > 1) {
            return this.s.getNumberOfLayers() <= 2 ? ((y)this.s.getDrawable(1)) : ((y)this.s.getDrawable(2));
        }
        return null;
    }

    public final i b(boolean z) {
        return this.s == null || this.s.getNumberOfLayers() <= 0 ? null : ((i)((LayerDrawable)((InsetDrawable)this.s.getDrawable(0)).getDrawable()).getDrawable(!z));
    }

    public final void c(o o0) {
        this.b = o0;
        if(this.b(false) != null) {
            this.b(false).setShapeAppearanceModel(o0);
        }
        if(this.b(true) != null) {
            this.b(true).setShapeAppearanceModel(o0);
        }
        if(this.a() != null) {
            this.a().setShapeAppearanceModel(o0);
        }
    }

    public final void d(int v, int v1) {
        MaterialButton materialButton0 = this.a;
        int v2 = materialButton0.getPaddingStart();
        int v3 = materialButton0.getPaddingTop();
        int v4 = materialButton0.getPaddingEnd();
        int v5 = materialButton0.getPaddingBottom();
        int v6 = this.e;
        int v7 = this.f;
        this.f = v1;
        this.e = v;
        if(!this.o) {
            this.e();
        }
        materialButton0.setPaddingRelative(v2, v3 + v - v6, v4, v5 + v1 - v7);
    }

    public final void e() {
        i i0 = new i(this.b);
        MaterialButton materialButton0 = this.a;
        i0.k(materialButton0.getContext());
        i0.setTintList(this.j);
        PorterDuff.Mode porterDuff$Mode0 = this.i;
        if(porterDuff$Mode0 != null) {
            i0.setTintMode(porterDuff$Mode0);
        }
        ColorStateList colorStateList0 = this.k;
        i0.s(((float)this.h));
        i0.r(colorStateList0);
        i i1 = new i(this.b);
        i1.setTint(0);
        float f = (float)this.h;
        int v = this.n ? n.q(materialButton0, 0x7F040190) : 0;  // attr:colorSurface
        i1.s(f);
        i1.r(ColorStateList.valueOf(v));
        i i2 = new i(this.b);
        this.m = i2;
        i2.setTint(-1);
        RippleDrawable rippleDrawable0 = new RippleDrawable(a.c(this.l), new InsetDrawable(new LayerDrawable(new Drawable[]{i1, i0}), this.c, this.e, this.d, this.f), this.m);
        this.s = rippleDrawable0;
        materialButton0.setInternalBackground(rippleDrawable0);
        i i3 = this.b(false);
        if(i3 != null) {
            i3.l(((float)this.t));
            i3.setState(materialButton0.getDrawableState());
        }
    }

    public final void f() {
        int v = 0;
        i i0 = this.b(false);
        i i1 = this.b(true);
        if(i0 != null) {
            ColorStateList colorStateList0 = this.k;
            i0.s(((float)this.h));
            i0.r(colorStateList0);
            if(i1 != null) {
                float f = (float)this.h;
                if(this.n) {
                    v = n.q(this.a, 0x7F040190);  // attr:colorSurface
                }
                i1.s(f);
                i1.r(ColorStateList.valueOf(v));
            }
        }
    }
}

