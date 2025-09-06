package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.b;
import c2.B0;
import c2.M;
import d6.a;

public class ScrimInsetsFrameLayout extends FrameLayout {
    public Drawable a;
    public Rect b;
    public final Rect c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public ScrimInsetsFrameLayout(Context context0) {
        this(context0, null);
    }

    public ScrimInsetsFrameLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ScrimInsetsFrameLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.c = new Rect();
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        TypedArray typedArray0 = B.m(context0, attributeSet0, a.T, v, 0x7F1403C3, new int[0]);  // style:Widget.Design.ScrimInsetsFrameLayout
        this.a = typedArray0.getDrawable(0);
        typedArray0.recycle();
        this.setWillNotDraw(true);
        M.n(this, new b(this, 20));
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        super.draw(canvas0);
        int v = this.getWidth();
        int v1 = this.getHeight();
        if(this.b != null && this.a != null) {
            int v2 = canvas0.save();
            canvas0.translate(((float)this.getScrollX()), ((float)this.getScrollY()));
            Rect rect0 = this.c;
            if(this.d) {
                rect0.set(0, 0, v, this.b.top);
                this.a.setBounds(rect0);
                this.a.draw(canvas0);
            }
            if(this.e) {
                rect0.set(0, v1 - this.b.bottom, v, v1);
                this.a.setBounds(rect0);
                this.a.draw(canvas0);
            }
            if(this.f) {
                rect0.set(0, this.b.top, this.b.left, v1 - this.b.bottom);
                this.a.setBounds(rect0);
                this.a.draw(canvas0);
            }
            if(this.g) {
                rect0.set(v - this.b.right, this.b.top, v, v1 - this.b.bottom);
                this.a.setBounds(rect0);
                this.a.draw(canvas0);
            }
            canvas0.restoreToCount(v2);
        }
    }

    public void e(B0 b00) {
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setCallback(this);
        }
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.e = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.f = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.g = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.d = z;
    }

    public void setScrimInsetForeground(Drawable drawable0) {
        this.a = drawable0;
    }
}

