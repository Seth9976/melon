package com.google.android.material.circularreveal;

import H8.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import m6.d;
import m6.e;

public class CircularRevealGridLayout extends GridLayout implements e {
    public final i a;

    public CircularRevealGridLayout(Context context0) {
        this(context0, null);
    }

    public CircularRevealGridLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new i(this);
    }

    @Override  // m6.e
    public final void a() {
        this.a.getClass();
    }

    @Override  // m6.e
    public final void b() {
        this.a.getClass();
    }

    @Override  // m6.e
    public final void c(Canvas canvas0) {
        super.draw(canvas0);
    }

    @Override  // m6.e
    public final boolean d() {
        return super.isOpaque();
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        i i0 = this.a;
        if(i0 != null) {
            i0.i(canvas0);
            return;
        }
        super.draw(canvas0);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable)this.a.f;
    }

    @Override  // m6.e
    public int getCircularRevealScrimColor() {
        return ((Paint)this.a.d).getColor();
    }

    @Override  // m6.e
    public d getRevealInfo() {
        return this.a.t();
    }

    @Override  // android.view.View
    public final boolean isOpaque() {
        return this.a == null ? super.isOpaque() : this.a.v();
    }

    @Override  // m6.e
    public void setCircularRevealOverlayDrawable(Drawable drawable0) {
        this.a.z(drawable0);
    }

    @Override  // m6.e
    public void setCircularRevealScrimColor(int v) {
        this.a.A(v);
    }

    @Override  // m6.e
    public void setRevealInfo(d d0) {
        this.a.B(d0);
    }
}

