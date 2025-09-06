package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ClippableRoundedCornerLayout extends FrameLayout {
    public Path a;
    public float b;

    public ClippableRoundedCornerLayout(Context context0) {
        super(context0);
    }

    public ClippableRoundedCornerLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public ClippableRoundedCornerLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public final void a(float f, float f1, float f2, float f3, float f4) {
        RectF rectF0 = new RectF(f, f1, f2, f3);
        if(this.a == null) {
            this.a = new Path();
        }
        this.b = f4;
        this.a.reset();
        this.a.addRoundRect(rectF0, f4, f4, Path.Direction.CW);
        this.a.close();
        this.invalidate();
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        if(this.a == null) {
            super.dispatchDraw(canvas0);
            return;
        }
        int v = canvas0.save();
        canvas0.clipPath(this.a);
        super.dispatchDraw(canvas0);
        canvas0.restoreToCount(v);
    }

    public float getCornerRadius() {
        return this.b;
    }
}

