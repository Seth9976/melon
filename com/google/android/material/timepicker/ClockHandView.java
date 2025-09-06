package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.internal.B;
import d6.a;
import e1.n;
import java.util.ArrayList;

class ClockHandView extends View {
    public final ValueAnimator a;
    public boolean b;
    public final ArrayList c;
    public final int d;
    public final float e;
    public final Paint f;
    public final RectF g;
    public final int h;
    public float i;
    public boolean j;
    public double k;
    public int l;
    public int m;

    public ClockHandView(Context context0) {
        this(context0, null);
    }

    public ClockHandView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040409);  // attr:materialClockStyle
    }

    public ClockHandView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new ValueAnimator();
        this.c = new ArrayList();
        Paint paint0 = new Paint();
        this.f = paint0;
        this.g = new RectF();
        this.m = 1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.n, v, 0x7F1404E5);  // style:Widget.MaterialComponents.TimePicker.Clock
        n.B(context0, 0x7F040454, 200);  // attr:motionDurationLong2
        n.C(context0, 0x7F040464, e6.a.b);  // attr:motionEasingEmphasizedInterpolator
        this.l = typedArray0.getDimensionPixelSize(1, 0);
        this.d = typedArray0.getDimensionPixelSize(2, 0);
        Resources resources0 = this.getResources();
        this.h = resources0.getDimensionPixelSize(0x7F0702D6);  // dimen:material_clock_hand_stroke_width
        this.e = (float)resources0.getDimensionPixelSize(0x7F0702D4);  // dimen:material_clock_hand_center_dot_radius
        int v1 = typedArray0.getColor(0, 0);
        paint0.setAntiAlias(true);
        paint0.setColor(v1);
        this.b(0.0f);
        ViewConfiguration.get(context0).getScaledTouchSlop();
        this.setImportantForAccessibility(2);
        typedArray0.recycle();
    }

    public final int a(int v) {
        return v == 2 ? Math.round(((float)this.l) * 0.66f) : this.l;
    }

    public final void b(float f) {
        ValueAnimator valueAnimator0 = this.a;
        if(valueAnimator0 != null) {
            valueAnimator0.cancel();
        }
        this.i = f % 360.0f;
        this.k = Math.toRadians(f % 360.0f - 90.0f);
        int v = this.getHeight();
        int v1 = this.getWidth();
        float f1 = (float)this.a(this.m);
        float f2 = ((float)Math.cos(this.k)) * f1 + ((float)(v1 / 2));
        float f3 = f1 * ((float)Math.sin(this.k)) + ((float)(v / 2));
        this.g.set(f2 - ((float)this.d), f3 - ((float)this.d), f2 + ((float)this.d), f3 + ((float)this.d));
        for(Object object0: this.c) {
            ClockFaceView clockFaceView0 = (ClockFaceView)(((d)object0));
            if(Math.abs(clockFaceView0.d0 - f % 360.0f) > 0.001f) {
                clockFaceView0.d0 = f % 360.0f;
                clockFaceView0.d();
            }
        }
        this.invalidate();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        int v = this.getHeight();
        int v1 = this.getWidth();
        int v2 = this.a(this.m);
        float f = ((float)Math.cos(this.k)) * ((float)v2) + ((float)(v1 / 2));
        float f1 = ((float)v2) * ((float)Math.sin(this.k)) + ((float)(v / 2));
        this.f.setStrokeWidth(0.0f);
        canvas0.drawCircle(f, f1, ((float)this.d), this.f);
        double f2 = Math.sin(this.k);
        double f3 = Math.cos(this.k);
        double f4 = (double)(((float)(v2 - this.d)));
        this.f.setStrokeWidth(((float)this.h));
        canvas0.drawLine(((float)(v1 / 2)), ((float)(v / 2)), ((float)(v1 / 2 + ((int)(f3 * f4)))), ((float)(v / 2 + ((int)(f4 * f2)))), this.f);
        canvas0.drawCircle(((float)(v1 / 2)), ((float)(v / 2)), this.e, this.f);
    }

    @Override  // android.view.View
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(!this.a.isRunning()) {
            this.b(this.i);
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z2;
        boolean z1;
        int v = motionEvent0.getActionMasked();
        float f = motionEvent0.getX();
        float f1 = motionEvent0.getY();
        boolean z = false;
        switch(v) {
            case 0: {
                this.j = false;
                z2 = true;
                z1 = false;
                break;
            }
            case 1: 
            case 2: {
                z1 = this.j;
                if(this.b) {
                    this.m = e2.a.z(this.getWidth() / 2, this.getHeight() / 2, f, f1) <= ((float)this.a(2)) + B.g(this.getContext(), 12) ? 2 : 1;
                }
                z2 = false;
                break;
            }
            default: {
                z1 = false;
                z2 = false;
            }
        }
        boolean z3 = this.j;
        int v1 = this.getWidth();
        int v2 = (int)Math.toDegrees(Math.atan2(f1 - ((float)(this.getHeight() / 2)), f - ((float)(v1 / 2))));
        int v3 = v2 + 90 >= 0 ? v2 + 90 : v2 + 450;
        boolean z4 = this.i != ((float)v3);
        if(z2 && z4) {
            z = true;
        }
        else if(z4 || z1) {
            this.b(((float)v3));
            z = true;
        }
        this.j = z3 | z;
        return true;
    }
}

