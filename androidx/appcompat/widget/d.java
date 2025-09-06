package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import c2.W;
import d5.m;
import g.a;

public final class D extends B {
    public final AppCompatSeekBar e;
    public Drawable f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public boolean i;
    public boolean j;

    public D(AppCompatSeekBar appCompatSeekBar0) {
        super(appCompatSeekBar0);
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.e = appCompatSeekBar0;
    }

    @Override  // androidx.appcompat.widget.B
    public final void b(AttributeSet attributeSet0, int v) {
        super.b(attributeSet0, v);
        AppCompatSeekBar appCompatSeekBar0 = this.e;
        m m0 = m.r(appCompatSeekBar0.getContext(), attributeSet0, a.h, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        W.n(appCompatSeekBar0, appCompatSeekBar0.getContext(), a.h, attributeSet0, ((TypedArray)m0.c), v);
        Drawable drawable0 = m0.l(0);
        if(drawable0 != null) {
            appCompatSeekBar0.setThumb(drawable0);
        }
        Drawable drawable1 = m0.k(1);
        Drawable drawable2 = this.f;
        if(drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f = drawable1;
        if(drawable1 != null) {
            drawable1.setCallback(appCompatSeekBar0);
            drawable1.setLayoutDirection(appCompatSeekBar0.getLayoutDirection());
            if(drawable1.isStateful()) {
                drawable1.setState(appCompatSeekBar0.getDrawableState());
            }
            this.f();
        }
        appCompatSeekBar0.invalidate();
        if(typedArray0.hasValue(3)) {
            this.h = h0.c(typedArray0.getInt(3, -1), this.h);
            this.j = true;
        }
        if(typedArray0.hasValue(2)) {
            this.g = m0.j(2);
            this.i = true;
        }
        m0.t();
        this.f();
    }

    public final void f() {
        Drawable drawable0 = this.f;
        if(drawable0 != null && (this.i || this.j)) {
            Drawable drawable1 = drawable0.mutate();
            this.f = drawable1;
            if(this.i) {
                drawable1.setTintList(this.g);
            }
            if(this.j) {
                this.f.setTintMode(this.h);
            }
            if(this.f.isStateful()) {
                this.f.setState(this.e.getDrawableState());
            }
        }
    }

    public final void g(Canvas canvas0) {
        if(this.f != null) {
            AppCompatSeekBar appCompatSeekBar0 = this.e;
            int v = appCompatSeekBar0.getMax();
            int v1 = 1;
            if(v > 1) {
                int v2 = this.f.getIntrinsicWidth();
                int v3 = this.f.getIntrinsicHeight();
                int v4 = v2 < 0 ? 1 : v2 / 2;
                if(v3 >= 0) {
                    v1 = v3 / 2;
                }
                this.f.setBounds(-v4, -v1, v4, v1);
                int v5 = appCompatSeekBar0.getWidth();
                int v6 = appCompatSeekBar0.getPaddingLeft();
                int v7 = appCompatSeekBar0.getPaddingRight();
                int v8 = canvas0.save();
                canvas0.translate(((float)appCompatSeekBar0.getPaddingLeft()), ((float)(appCompatSeekBar0.getHeight() / 2)));
                for(int v9 = 0; v9 <= v; ++v9) {
                    this.f.draw(canvas0);
                    canvas0.translate(((float)(v5 - v6 - v7)) / ((float)v), 0.0f);
                }
                canvas0.restoreToCount(v8);
            }
        }
    }
}

