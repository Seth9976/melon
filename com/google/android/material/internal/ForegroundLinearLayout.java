package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import d6.a;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    public final Rect B;
    public int D;
    public final boolean E;
    public boolean G;
    public Drawable r;
    public final Rect w;

    public ForegroundLinearLayout(Context context0) {
        this(context0, null);
    }

    public ForegroundLinearLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ForegroundLinearLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.w = new Rect();
        this.B = new Rect();
        this.D = 0x77;
        this.E = true;
        this.G = false;
        TypedArray typedArray0 = B.m(context0, attributeSet0, a.v, v, 0, new int[0]);
        this.D = typedArray0.getInt(1, this.D);
        Drawable drawable0 = typedArray0.getDrawable(0);
        if(drawable0 != null) {
            this.setForeground(drawable0);
        }
        this.E = typedArray0.getBoolean(2, true);
        typedArray0.recycle();
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        super.draw(canvas0);
        Drawable drawable0 = this.r;
        if(drawable0 != null) {
            if(this.G) {
                this.G = false;
                int v = this.getRight() - this.getLeft();
                int v1 = this.getBottom() - this.getTop();
                Rect rect0 = this.w;
                if(this.E) {
                    rect0.set(0, 0, v, v1);
                }
                else {
                    rect0.set(this.getPaddingLeft(), this.getPaddingTop(), v - this.getPaddingRight(), v1 - this.getPaddingBottom());
                }
                Gravity.apply(this.D, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight(), rect0, this.B);
                drawable0.setBounds(this.B);
            }
            drawable0.draw(canvas0);
        }
    }

    @Override  // android.view.View
    public final void drawableHotspotChanged(float f, float f1) {
        super.drawableHotspotChanged(f, f1);
        Drawable drawable0 = this.r;
        if(drawable0 != null) {
            drawable0.setHotspot(f, f1);
        }
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.r != null && this.r.isStateful()) {
            this.r.setState(this.getDrawableState());
        }
    }

    @Override  // android.view.View
    public Drawable getForeground() {
        return this.r;
    }

    @Override  // android.view.View
    public int getForegroundGravity() {
        return this.D;
    }

    @Override  // android.view.ViewGroup
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.r;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.G |= z;
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.G = true;
    }

    @Override  // android.view.View
    public void setForeground(Drawable drawable0) {
        Drawable drawable1 = this.r;
        if(drawable1 != drawable0) {
            if(drawable1 != null) {
                drawable1.setCallback(null);
                this.unscheduleDrawable(this.r);
            }
            this.r = drawable0;
            this.G = true;
            if(drawable0 == null) {
                this.setWillNotDraw(true);
            }
            else {
                this.setWillNotDraw(false);
                drawable0.setCallback(this);
                if(drawable0.isStateful()) {
                    drawable0.setState(this.getDrawableState());
                }
                if(this.D == 0x77) {
                    drawable0.getPadding(new Rect());
                }
            }
            this.requestLayout();
            this.invalidate();
        }
    }

    @Override  // android.view.View
    public void setForegroundGravity(int v) {
        if(this.D != v) {
            if((0x800007 & v) == 0) {
                v |= 0x800003;
            }
            if((v & 0x70) == 0) {
                v |= 0x30;
            }
            this.D = v;
            if(v == 0x77 && this.r != null) {
                Rect rect0 = new Rect();
                this.r.getPadding(rect0);
            }
            this.requestLayout();
        }
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.r;
    }
}

