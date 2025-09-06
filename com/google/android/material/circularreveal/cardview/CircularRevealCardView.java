package com.google.android.material.circularreveal.cardview;

import H8.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import m6.d;
import m6.e;

public class CircularRevealCardView extends MaterialCardView implements e {
    public final i o;

    public CircularRevealCardView(Context context0) {
        this(context0, null);
    }

    public CircularRevealCardView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.o = new i(this);
    }

    @Override  // m6.e
    public final void a() {
        this.o.getClass();
    }

    @Override  // m6.e
    public final void b() {
        this.o.getClass();
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
        i i0 = this.o;
        if(i0 != null) {
            i0.i(canvas0);
            return;
        }
        super.draw(canvas0);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable)this.o.f;
    }

    @Override  // m6.e
    public int getCircularRevealScrimColor() {
        return ((Paint)this.o.d).getColor();
    }

    @Override  // m6.e
    public d getRevealInfo() {
        return this.o.t();
    }

    @Override  // android.view.View
    public final boolean isOpaque() {
        return this.o == null ? super.isOpaque() : this.o.v();
    }

    @Override  // m6.e
    public void setCircularRevealOverlayDrawable(Drawable drawable0) {
        this.o.z(drawable0);
    }

    @Override  // m6.e
    public void setCircularRevealScrimColor(int v) {
        this.o.A(v);
    }

    @Override  // m6.e
    public void setRevealInfo(d d0) {
        this.o.B(d0);
    }
}

