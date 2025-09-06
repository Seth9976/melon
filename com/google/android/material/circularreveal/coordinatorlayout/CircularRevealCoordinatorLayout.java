package com.google.android.material.circularreveal.coordinatorlayout;

import H8.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import m6.d;
import m6.e;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements e {
    public final i S;

    public CircularRevealCoordinatorLayout(Context context0) {
        this(context0, null);
    }

    public CircularRevealCoordinatorLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.S = new i(this);
    }

    @Override  // m6.e
    public final void a() {
        this.S.getClass();
    }

    @Override  // m6.e
    public final void b() {
        this.S.getClass();
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
        i i0 = this.S;
        if(i0 != null) {
            i0.i(canvas0);
            return;
        }
        super.draw(canvas0);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable)this.S.f;
    }

    @Override  // m6.e
    public int getCircularRevealScrimColor() {
        return ((Paint)this.S.d).getColor();
    }

    @Override  // m6.e
    public d getRevealInfo() {
        return this.S.t();
    }

    @Override  // android.view.View
    public final boolean isOpaque() {
        return this.S == null ? super.isOpaque() : this.S.v();
    }

    @Override  // m6.e
    public void setCircularRevealOverlayDrawable(Drawable drawable0) {
        this.S.z(drawable0);
    }

    @Override  // m6.e
    public void setCircularRevealScrimColor(int v) {
        this.S.A(v);
    }

    @Override  // m6.e
    public void setRevealInfo(d d0) {
        this.S.B(d0);
    }
}

