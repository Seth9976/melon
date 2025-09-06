package com.google.android.material.carousel;

import E9.h;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import e6.a;
import i3.d;
import k6.m;
import z6.A;
import z6.B;
import z6.o;
import z6.y;
import z6.z;

public class MaskableFrameLayout extends FrameLayout implements m, y {
    public float a;
    public final RectF b;
    public o c;
    public final z d;
    public Boolean e;
    public static final int f;

    public MaskableFrameLayout(Context context0) {
        this(context0, null);
    }

    public MaskableFrameLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public MaskableFrameLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -1.0f;
        this.b = new RectF();
        B b0 = Build.VERSION.SDK_INT >= 33 ? new B(this) : new A(this);
        this.d = b0;
        this.e = null;
        this.setShapeAppearanceModel(o.d(context0, attributeSet0, v, 0).a());
    }

    public final void a() {
        if(this.a != -1.0f) {
            float f = a.b(0.0f, ((float)this.getWidth()) / 2.0f, 0.0f, 1.0f, this.a);
            this.setMaskRectF(new RectF(f, 0.0f, ((float)this.getWidth()) - f, ((float)this.getHeight())));
        }
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        Path path0 = this.d.e;
        if(this.d.b() && !path0.isEmpty()) {
            canvas0.save();
            canvas0.clipPath(path0);
            super.dispatchDraw(canvas0);
            canvas0.restore();
            return;
        }
        super.dispatchDraw(canvas0);
    }

    @Override  // android.view.View
    public final void getFocusedRect(Rect rect0) {
        rect0.set(((int)this.b.left), ((int)this.b.top), ((int)this.b.right), ((int)this.b.bottom));
    }

    public RectF getMaskRectF() {
        return this.b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.a;
    }

    public o getShapeAppearanceModel() {
        return this.c;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean boolean0 = this.e;
        if(boolean0 != null) {
            boolean z = boolean0.booleanValue();
            z z1 = this.d;
            if(z != z1.a) {
                z1.a = z;
                z1.a(this);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        z z0 = this.d;
        this.e = Boolean.valueOf(z0.a);
        if(!z0.a) {
            z0.a = true;
            z0.a(this);
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        if(this.a != -1.0f) {
            this.a();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.b.isEmpty() || motionEvent0.getAction() != 0 || this.b.contains(motionEvent0.getX(), motionEvent0.getY()) ? super.onTouchEvent(motionEvent0) : false;
    }

    public void setForceCompatClipping(boolean z) {
        z z1 = this.d;
        if(z != z1.a) {
            z1.a = z;
            z1.a(this);
        }
    }

    @Override  // k6.m
    public void setMaskRectF(RectF rectF0) {
        this.b.set(rectF0);
        this.d.d = this.b;
        this.d.c();
        this.d.a(this);
    }

    @Deprecated
    public void setMaskXPercentage(float f) {
        float f1 = h.q(f, 0.0f, 1.0f);
        if(this.a != f1) {
            this.a = f1;
            this.a();
        }
    }

    public void setOnMaskChangedListener(k6.o o0) {
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        o o1 = o0.h(new d(12));
        this.c = o1;
        this.d.c = o1;
        this.d.c();
        this.d.a(this);
    }
}

