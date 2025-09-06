package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import d5.f;
import k8.t1;

@Deprecated
public class CircularSeekBar extends View {
    public float A0;
    public float B;
    public float B0;
    public int C0;
    public final RectF D;
    public int D0;
    public final RectF E;
    public boolean E0;
    public float F0;
    public int G;
    public float G0;
    public float H0;
    public int I;
    public float I0;
    public float J0;
    public final Rect K0;
    public static final int L0;
    public int M;
    public static final int M0;
    public int N;
    public static final int N0;
    public static final int O0;
    public static final int P0;
    public static final int Q0;
    public static final int R0;
    public int S;
    public int T;
    public int V;
    public int W;
    public Paint a;
    public Paint b;
    public float b0;
    public Paint c;
    public float c0;
    public Paint d;
    public Path d0;
    public Paint e;
    public Path e0;
    public Paint f;
    public Path f0;
    public Paint g;
    public Path g0;
    public Paint h;
    public int h0;
    public Paint i;
    public int i0;
    public Paint j;
    public boolean j0;
    public float k;
    public boolean k0;
    public float l;
    public boolean l0;
    public float m;
    public boolean m0;
    public float n;
    public boolean n0;
    public float o;
    public boolean o0;
    public boolean p0;
    public float q0;
    public float r;
    public float r0;
    public float s0;
    public float t0;
    public boolean u0;
    public float v0;
    public float w;
    public float w0;
    public float x0;
    public final float[] y0;
    public boolean z0;

    static {
        CircularSeekBar.L0 = ColorUtils.getColorFromHexStr("#dadada");
        CircularSeekBar.M0 = ColorUtils.getColorFromHexStr("#00ad1c");
        CircularSeekBar.N0 = ColorUtils.getColorFromHexStr("#00ad1c");
        CircularSeekBar.O0 = ColorUtils.getColorFromHexStr("#00ad1c");
        CircularSeekBar.P0 = ColorUtils.getColorFromHexStr("#00ad1c");
        CircularSeekBar.Q0 = ColorUtils.getColorFromHexStr("#dadada");
        CircularSeekBar.R0 = ColorUtils.getColorFromHexStr("#00ad1c");
    }

    public CircularSeekBar(Context context0) {
        super(context0);
        this.D = new RectF();
        this.E = new RectF();
        this.G = CircularSeekBar.N0;
        this.I = CircularSeekBar.O0;
        this.M = CircularSeekBar.P0;
        this.N = CircularSeekBar.L0;
        this.S = 0;
        this.T = CircularSeekBar.M0;
        this.V = 100;
        this.W = 0xFF;
        this.m0 = true;
        this.n0 = true;
        this.o0 = false;
        this.p0 = false;
        this.y0 = new float[2];
        this.z0 = false;
        this.E0 = true;
        this.K0 = new Rect();
        this.a(null, 0);
    }

    public CircularSeekBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.D = new RectF();
        this.E = new RectF();
        this.G = CircularSeekBar.N0;
        this.I = CircularSeekBar.O0;
        this.M = CircularSeekBar.P0;
        this.N = CircularSeekBar.L0;
        this.S = 0;
        this.T = CircularSeekBar.M0;
        this.V = 100;
        this.W = 0xFF;
        this.m0 = true;
        this.n0 = true;
        this.o0 = false;
        this.p0 = false;
        this.y0 = new float[2];
        this.z0 = false;
        this.E0 = true;
        this.K0 = new Rect();
        this.a(attributeSet0, 0);
    }

    public CircularSeekBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.D = new RectF();
        this.E = new RectF();
        this.G = CircularSeekBar.N0;
        this.I = CircularSeekBar.O0;
        this.M = CircularSeekBar.P0;
        this.N = CircularSeekBar.L0;
        this.S = 0;
        this.T = CircularSeekBar.M0;
        this.V = 100;
        this.W = 0xFF;
        this.m0 = true;
        this.n0 = true;
        this.o0 = false;
        this.p0 = false;
        this.y0 = new float[2];
        this.z0 = false;
        this.E0 = true;
        this.K0 = new Rect();
        this.a(attributeSet0, v);
    }

    public final void a(AttributeSet attributeSet0, int v) {
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.g, v, 0);
        Context context0 = this.getContext();
        this.l = typedArray0.getDimension(6, ((float)ScreenUtils.dipToPixel(context0, 30.0f)));
        this.m = typedArray0.getDimension(7, ((float)ScreenUtils.dipToPixel(context0, 30.0f)));
        this.n = typedArray0.getDimension(18, ((float)ScreenUtils.dipToPixel(context0, 5.0f)));
        this.o = typedArray0.getDimension(17, ((float)ScreenUtils.dipToPixel(context0, 0.0f)));
        this.r = typedArray0.getDimension(14, ((float)ScreenUtils.dipToPixel(context0, 2.0f)));
        this.k = typedArray0.getDimension(5, ((float)ScreenUtils.dipToPixel(context0, 2.0f)));
        this.G = typedArray0.getColor(13, CircularSeekBar.N0);
        this.I = typedArray0.getColor(15, CircularSeekBar.O0);
        this.M = typedArray0.getColor(16, CircularSeekBar.P0);
        this.N = typedArray0.getColor(2, CircularSeekBar.L0);
        this.T = typedArray0.getColor(4, CircularSeekBar.M0);
        this.S = typedArray0.getColor(3, 0);
        this.V = Color.alpha(this.I);
        int v1 = typedArray0.getInt(12, 0xFF);
        this.W = v1;
        if(v1 > 0xFF || v1 < 0) {
            this.W = 0xFF;
        }
        this.h0 = typedArray0.getInt(0, 100);
        this.i0 = typedArray0.getInt(1, 0);
        this.j0 = typedArray0.getBoolean(26, false);
        this.k0 = typedArray0.getBoolean(10, true);
        this.l0 = typedArray0.getBoolean(11, true);
        this.m0 = typedArray0.getBoolean(9, true);
        this.w = (typedArray0.getFloat(20, 270.0f) % 360.0f + 360.0f) % 360.0f;
        float f = (typedArray0.getFloat(8, 270.0f) % 360.0f + 360.0f) % 360.0f;
        this.B = f;
        if(Float.compare(this.w, f) == 0) {
            this.B -= 0.1f;
        }
        this.z0 = typedArray0.getBoolean(19, false);
        this.F0 = typedArray0.getDimension(23, ((float)ScreenUtils.dipToPixel(context0, 14.0f)));
        this.A0 = typedArray0.getDimension(24, ((float)ScreenUtils.dipToPixel(context0, 14.0f)));
        this.B0 = typedArray0.getDimension(25, ((float)ScreenUtils.dipToPixel(context0, 26.0f)));
        this.C0 = typedArray0.getColor(21, CircularSeekBar.Q0);
        this.D0 = typedArray0.getColor(22, CircularSeekBar.R0);
        typedArray0.recycle();
        this.b();
    }

    public final void b() {
        Typeface typeface0 = f.G(this.getContext());
        Paint paint0 = new Paint();
        this.a = paint0;
        paint0.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setColor(this.N);
        this.a.setStrokeWidth(this.k);
        Paint.Style paint$Style0 = Paint.Style.STROKE;
        this.a.setStyle(paint$Style0);
        Paint.Join paint$Join0 = Paint.Join.ROUND;
        this.a.setStrokeJoin(paint$Join0);
        Paint.Cap paint$Cap0 = Paint.Cap.ROUND;
        this.a.setStrokeCap(paint$Cap0);
        Paint paint1 = new Paint();
        this.b = paint1;
        paint1.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setColor(this.S);
        Paint.Style paint$Style1 = Paint.Style.FILL;
        this.b.setStyle(paint$Style1);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.T);
        this.c.setStrokeWidth(this.k);
        this.c.setStyle(paint$Style0);
        this.c.setStrokeJoin(paint$Join0);
        this.c.setStrokeCap(paint$Cap0);
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.set(this.c);
        this.d.setStrokeWidth(this.k);
        Paint paint4 = new Paint();
        this.e = paint4;
        paint4.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setStyle(paint$Style1);
        this.e.setColor(this.G);
        this.e.setStrokeWidth(this.n);
        Paint paint5 = new Paint();
        this.f = paint5;
        paint5.set(this.e);
        this.f.setColor(this.I);
        this.f.setStyle(paint$Style1);
        this.f.setStrokeWidth(this.n + this.o);
        Paint paint6 = new Paint(65);
        this.g = paint6;
        paint6.setTypeface(typeface0);
        this.g.setColor(this.C0);
        Paint.Style paint$Style2 = Paint.Style.FILL_AND_STROKE;
        this.g.setStyle(paint$Style2);
        Paint.Align paint$Align0 = Paint.Align.LEFT;
        this.g.setTextAlign(paint$Align0);
        this.g.setTextSize(this.A0);
        Paint paint7 = new Paint(65);
        this.i = paint7;
        paint7.setTypeface(typeface0);
        this.i.setColor(this.C0);
        this.i.setStyle(paint$Style2);
        this.i.setTextAlign(paint$Align0);
        this.i.setTextSize(this.B0);
        Paint paint8 = new Paint(65);
        this.h = paint8;
        paint8.setTypeface(typeface0);
        this.h.setColor(this.D0);
        this.h.setStyle(paint$Style2);
        this.h.setTextAlign(paint$Align0);
        this.h.setTextSize(this.A0);
        Paint paint9 = new Paint(65);
        this.j = paint9;
        paint9.setTypeface(typeface0);
        this.j.setColor(this.D0);
        this.j.setStyle(paint$Style2);
        this.j.setTextAlign(paint$Align0);
        this.j.setTextSize(this.B0);
    }

    public final void c() {
        float f = this.w;
        float f1 = (360.0f - (f - this.B)) % 360.0f;
        this.b0 = f1;
        if(f1 <= 0.0f) {
            this.b0 = 360.0f;
        }
        float f2 = (((float)this.i0) / ((float)this.h0) * this.b0 + f) % 360.0f;
        this.x0 = f2;
        float f3 = f2 - f;
        this.c0 = f3;
        if(f3 < 0.0f) {
            f3 += 360.0f;
        }
        this.c0 = f3;
        float f4 = this.v0 - this.k - this.n - this.o - this.r;
        float f5 = this.w0 - this.k - this.n - this.o - this.r;
        this.D.set(-f4, -f5, f4, f5);
        this.E.set(-this.v0, -this.w0, this.v0, this.w0);
        Path path0 = new Path();
        this.d0 = path0;
        path0.addArc(this.D, this.w, this.b0);
        Path path1 = new Path();
        this.e0 = path1;
        path1.addArc(this.E, this.w, this.b0);
        Path path2 = new Path();
        this.f0 = path2;
        path2.addArc(this.D, this.w, this.c0);
        Path path3 = new Path();
        this.g0 = path3;
        path3.addArc(this.E, this.w, this.c0);
        PathMeasure pathMeasure0 = new PathMeasure(this.g0, false);
        float f6 = pathMeasure0.getLength();
        float[] arr_f = this.y0;
        if(!pathMeasure0.getPosTan(f6, arr_f, null)) {
            new PathMeasure(this.e0, false).getPosTan(0.0f, arr_f, null);
        }
    }

    public static String d(int v) {
        return String.format("%d:%02d", ((int)(v / 1000 / 60)), ((int)(v / 1000 % 60)));
    }

    public int getCircleColor() {
        return this.N;
    }

    public int getCircleFillColor() {
        return this.S;
    }

    public int getCircleProgressColor() {
        return this.T;
    }

    public int getMax() {
        synchronized(this) {
        }
        return this.h0;
    }

    public o getOnSeekBarChangeListener() {
        return null;
    }

    public int getPointerAlpha() {
        return this.V;
    }

    public int getPointerAlphaOnTouch() {
        return this.W;
    }

    public int getPointerColor() {
        return this.G;
    }

    public int getPointerHaloColor() {
        return this.I;
    }

    public int getProgress() {
        return Math.round(((float)this.h0) * this.c0 / this.b0);
    }

    public int getTextColorProgress() {
        return this.C0;
    }

    public int getTextColorTotal() {
        return this.D0;
    }

    public float getTextSize() {
        return this.A0;
    }

    public float getTextSizeOnTouch() {
        return this.B0;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        canvas0.translate(((float)(this.getWidth() / 2)), ((float)(this.getHeight() / 2)));
        canvas0.drawPath(this.d0, this.a);
        canvas0.drawPath(this.f0, this.c);
        if(this.p0) {
            canvas0.drawPath(this.f0, this.d);
        }
        canvas0.drawPath(this.d0, this.b);
        float[] arr_f = this.y0;
        if(this.p0) {
            canvas0.drawCircle(arr_f[0], arr_f[1], this.n + this.o, this.f);
        }
        canvas0.drawCircle(arr_f[0], arr_f[1], this.n, this.e);
        if(this.z0) {
            Context context0 = this.getContext();
            Rect rect0 = this.K0;
            RectF rectF0 = this.D;
            if(this.p0) {
                float f = (float)ScreenUtils.dipToPixel(context0, 12.5f);
                String s = CircularSeekBar.d(this.getProgress());
                this.i.getTextBounds(s, 0, s.length(), rect0);
                this.I0 = this.i.measureText(s);
                this.J0 = (float)rect0.height();
                float f1 = rectF0.centerX() - this.I0 - f;
                float f2 = rectF0.centerY();
                canvas0.drawText(s, f1, this.J0 / 2.0f + f2, this.i);
                canvas0.drawCircle(rectF0.centerX(), rectF0.centerY(), 5.0f, this.j);
                String s1 = CircularSeekBar.d(this.getMax());
                this.j.getTextBounds(s1, 0, s1.length(), rect0);
                this.I0 = this.j.measureText(s1);
                this.J0 = (float)rect0.height();
                float f3 = rectF0.centerX();
                float f4 = rectF0.centerY();
                canvas0.drawText(s1, f3 + f, this.J0 / 2.0f + f4, this.j);
                return;
            }
            float f5 = (float)ScreenUtils.dipToPixel(context0, 6.5f);
            String s2 = CircularSeekBar.d(this.getProgress());
            this.g.getTextBounds(s2, 0, s2.length(), rect0);
            this.G0 = this.g.measureText(s2);
            this.H0 = (float)rect0.height();
            canvas0.drawText(s2, rectF0.centerX() - this.G0 - f5, this.H0 / 2.0f + (rectF0.top + this.F0), this.g);
            canvas0.drawCircle(rectF0.centerX(), rectF0.top + this.F0, 3.0f, this.h);
            String s3 = CircularSeekBar.d(this.getMax());
            this.h.getTextBounds(s3, 0, s3.length(), rect0);
            this.G0 = this.h.measureText(s3);
            this.H0 = (float)rect0.height();
            canvas0.drawText(s3, rectF0.centerX() + f5, this.H0 / 2.0f + (rectF0.top + this.F0), this.h);
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = View.getDefaultSize(this.getSuggestedMinimumHeight(), v1);
        int v3 = View.getDefaultSize(this.getSuggestedMinimumWidth(), v);
        if(this.k0) {
            int v4 = Math.min(v3, v2);
            this.setMeasuredDimension(v4, v4);
        }
        else {
            this.setMeasuredDimension(v3, v2);
        }
        float f = this.n;
        float f1 = this.o;
        float f2 = this.r;
        float f3 = ((float)v2) / 2.0f - f - f1 - f2 * 1.5f;
        this.w0 = f3;
        float f4 = ((float)v3) / 2.0f - f - f1 - f2 * 1.5f;
        this.v0 = f4;
        if(this.j0) {
            float f5 = this.m;
            if(f5 - f - f1 - f2 < f3) {
                this.w0 = f5 - f - f1 - f2 * 1.5f;
            }
            float f6 = this.l;
            if(f6 - f - f1 - f2 < f4) {
                this.v0 = f6 - f - f1 - f2 * 1.5f;
            }
        }
        if(this.k0) {
            float f7 = Math.min(this.w0, this.v0);
            this.w0 = f7;
            this.v0 = f7;
        }
        this.c();
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((Bundle)parcelable0).getParcelable("PARENT"));
        this.h0 = ((Bundle)parcelable0).getInt("MAX");
        this.i0 = ((Bundle)parcelable0).getInt("PROGRESS");
        this.N = ((Bundle)parcelable0).getInt("mCircleColor");
        this.T = ((Bundle)parcelable0).getInt("mCircleProgressColor");
        this.G = ((Bundle)parcelable0).getInt("mPointerColor");
        this.I = ((Bundle)parcelable0).getInt("mPointerHaloColor");
        this.M = ((Bundle)parcelable0).getInt("mPointerHaloColorOnTouch");
        this.V = ((Bundle)parcelable0).getInt("mPointerAlpha");
        this.W = ((Bundle)parcelable0).getInt("mPointerAlphaOnTouch");
        this.m0 = ((Bundle)parcelable0).getBoolean("lockEnabled");
        this.z0 = ((Bundle)parcelable0).getBoolean("mShowText");
        this.A0 = ((Bundle)parcelable0).getFloat("mTextSize");
        this.B0 = ((Bundle)parcelable0).getFloat("mTextSizeOnTouch");
        this.C0 = ((Bundle)parcelable0).getInt("mTextColorProgress");
        this.D0 = ((Bundle)parcelable0).getInt("mTextColorTotal");
        this.b();
        this.c();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = super.onSaveInstanceState();
        Parcelable parcelable1 = new Bundle();
        ((Bundle)parcelable1).putParcelable("PARENT", parcelable0);
        ((BaseBundle)parcelable1).putInt("MAX", this.h0);
        ((BaseBundle)parcelable1).putInt("PROGRESS", this.i0);
        ((BaseBundle)parcelable1).putInt("mCircleColor", this.N);
        ((BaseBundle)parcelable1).putInt("mCircleProgressColor", this.T);
        ((BaseBundle)parcelable1).putInt("mPointerColor", this.G);
        ((BaseBundle)parcelable1).putInt("mPointerHaloColor", this.I);
        ((BaseBundle)parcelable1).putInt("mPointerHaloColorOnTouch", this.M);
        ((BaseBundle)parcelable1).putInt("mPointerAlpha", this.V);
        ((BaseBundle)parcelable1).putInt("mPointerAlphaOnTouch", this.W);
        ((BaseBundle)parcelable1).putBoolean("lockEnabled", this.m0);
        ((BaseBundle)parcelable1).putBoolean("mShowText", this.z0);
        ((Bundle)parcelable1).putFloat("mTextSize", this.A0);
        ((Bundle)parcelable1).putFloat("mTextSizeOnTouch", this.B0);
        ((BaseBundle)parcelable1).putInt("mTextColorProgress", this.C0);
        ((BaseBundle)parcelable1).putInt("mTextColorTotal", this.D0);
        return parcelable1;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!this.E0) {
            LogU.d("CircularSeekBar", "onTouchEvent: ignore / isAllowSeeking(false)");
            return true;
        }
        float f = motionEvent0.getX() - ((float)(this.getWidth() / 2));
        float f1 = motionEvent0.getY() - ((float)(this.getHeight() / 2));
        float f2 = this.D.centerX();
        float f3 = (float)Math.sqrt(Math.pow(this.D.centerY() - f1, 2.0) + Math.pow(f2 - f, 2.0));
        float f4 = (float)ScreenUtils.dipToPixel(this.getContext(), 32.0f);
        float f5 = Float.compare(this.k, f4) >= 0 ? this.k / 2.0f : f4 / 2.0f;
        float f6 = this.v0 - this.k - this.n - this.o - this.r;
        float f7 = this.w0 - this.k - this.n - this.o - this.r;
        float f8 = Math.max(f7, f6) + f5;
        float f9 = Math.min(f7, f6);
        float f10 = (float)(Math.atan2(f1, f) / 3.141593 * 180.0 % 360.0);
        f10 = Float.compare(f10, 0.0f) >= 0 ? ((float)(Math.atan2(f1, f) / 3.141593 * 180.0 % 360.0)) : f10 + 360.0f;
        float f11 = f10 - this.w;
        this.q0 = f11;
        if(f11 < 0.0f) {
            f11 += 360.0f;
        }
        this.q0 = f11;
        this.r0 = 360.0f - f11;
        float f12 = f10 - this.B;
        this.s0 = f12;
        if(f12 < 0.0f) {
            f12 += 360.0f;
        }
        this.s0 = f12;
        float f13 = f - this.y0[0];
        float f14 = f1 - this.y0[1];
        double f15 = Math.sqrt(f14 * f14 + f13 * f13);
        int v = motionEvent0.getAction();
        switch(v) {
            case 0: {
                float f16 = (float)(((double)(this.n * 180.0f)) / (((double)Math.max(f7, f6)) * 3.141593));
                float f17 = this.x0;
                float f18 = f10 - f17;
                f18 = f18 < 0.0f ? f18 + 360.0f : f10 - f17;
                int v1 = Float.compare(f3, f9 - f5);
                if(v1 >= 0 && f3 <= f8 && (f18 <= f16 || 360.0f - f18 <= f16)) {
                    this.setProgressBasedOnAngle(f17);
                    this.t0 = this.q0;
                    this.u0 = true;
                    this.f.setAlpha(this.W);
                    this.f.setColor(this.M);
                    this.c();
                    this.invalidate();
                    this.p0 = true;
                    this.o0 = false;
                    this.n0 = false;
                    goto label_132;
                }
                if(f15 < ((double)(f4 / 2.0f))) {
                    this.setProgressBasedOnAngle(f10);
                    this.t0 = this.q0;
                    this.u0 = true;
                    this.f.setAlpha(this.W);
                    this.f.setColor(this.M);
                    this.c();
                    this.invalidate();
                    this.p0 = true;
                    this.o0 = false;
                    this.n0 = false;
                    goto label_132;
                }
                if(this.q0 > this.b0) {
                    this.p0 = false;
                    return false;
                }
                if(v1 >= 0 && f3 <= f8) {
                    this.setProgressBasedOnAngle(f10);
                    this.t0 = this.q0;
                    this.u0 = true;
                    this.f.setAlpha(this.W);
                    this.f.setColor(this.M);
                    this.c();
                    this.invalidate();
                    this.p0 = true;
                    this.o0 = false;
                    this.n0 = false;
                    goto label_132;
                }
                this.p0 = false;
                return false;
            }
            case 1: {
                this.f.setAlpha(this.V);
                this.f.setColor(this.I);
                if(this.p0) {
                    this.p0 = false;
                    this.invalidate();
                    goto label_132;
                }
                break;
            }
            case 2: {
                if(this.p0) {
                    float f19 = this.t0;
                    float f20 = this.q0;
                    if(f19 >= f20) {
                        if(f19 - f20 <= 180.0f || !this.u0) {
                            this.u0 = false;
                        }
                        else {
                            this.o0 = true;
                            this.n0 = false;
                        }
                    }
                    else if(f20 - f19 > 180.0f && !this.u0) {
                        this.n0 = true;
                        this.o0 = false;
                    }
                    else {
                        this.u0 = true;
                    }
                    if(this.n0 && this.u0) {
                        this.n0 = false;
                    }
                    if(this.o0 && !this.u0) {
                        this.o0 = false;
                    }
                    if(this.n0 && !this.u0 && this.r0 > 90.0f) {
                        this.n0 = false;
                    }
                    if(this.o0 && this.u0 && this.s0 > 90.0f) {
                        this.o0 = false;
                    }
                    if(!this.o0 && (f20 > this.b0 && this.u0 && f19 < this.b0)) {
                        this.o0 = true;
                    }
                    if(this.n0 && this.m0) {
                        this.i0 = 0;
                        this.c();
                        this.invalidate();
                        this.t0 = this.q0;
                    }
                    else if(this.o0 && this.m0) {
                        this.i0 = this.h0;
                        this.c();
                        this.invalidate();
                        this.t0 = this.q0;
                    }
                    else if(this.l0 || f3 <= f8) {
                        if(f20 <= this.b0) {
                            this.setProgressBasedOnAngle(f10);
                        }
                        this.c();
                        this.invalidate();
                        this.t0 = this.q0;
                    }
                label_132:
                    if(motionEvent0.getAction() == 2 && this.getParent() != null) {
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                break;
            }
            default: {
                if(v != 3) {
                    goto label_132;
                }
                this.f.setAlpha(this.V);
                this.f.setColor(this.I);
                this.p0 = false;
                this.invalidate();
                goto label_132;
            }
        }
        return false;
    }

    public void setAllowSeeking(boolean z) {
        this.E0 = z;
    }

    public void setCircleColor(int v) {
        this.N = v;
        this.a.setColor(v);
        this.invalidate();
    }

    public void setCircleFillColor(int v) {
        this.S = v;
        this.b.setColor(v);
        this.invalidate();
    }

    public void setCircleProgressColor(int v) {
        this.T = v;
        this.c.setColor(v);
        this.invalidate();
    }

    public void setLockEnabled(boolean z) {
        this.m0 = z;
    }

    public void setMax(int v) {
        if(v < 0) {
            v = 0;
        }
        if(v <= this.i0) {
            this.i0 = 0;
        }
        this.h0 = v;
        this.c();
        this.invalidate();
    }

    public void setOnSeekBarChangeListener(o o0) {
    }

    public void setPointerAlpha(int v) {
        if(v >= 0 && v <= 0xFF) {
            this.V = v;
            this.f.setAlpha(v);
            this.invalidate();
        }
    }

    public void setPointerAlphaOnTouch(int v) {
        if(v >= 0 && v <= 0xFF) {
            this.W = v;
        }
    }

    public void setPointerColor(int v) {
        this.G = v;
        this.e.setColor(v);
        this.invalidate();
    }

    public void setPointerHaloColor(int v) {
        this.I = v;
        this.f.setColor(v);
        this.invalidate();
    }

    public void setProgress(int v) {
        if(this.i0 != v) {
            this.i0 = v;
            this.c();
            this.invalidate();
        }
    }

    private void setProgressBasedOnAngle(float f) {
        this.x0 = f;
        float f1 = f - this.w;
        this.c0 = f1;
        if(f1 < 0.0f) {
            f1 += 360.0f;
        }
        this.c0 = f1;
        this.i0 = Math.round(((float)this.h0) * f1 / this.b0);
    }

    public void setShowText(boolean z) {
        this.z0 = z;
    }

    public void setTextColorProgress(int v) {
        this.C0 = v;
    }

    public void setTextColorTotal(int v) {
        this.D0 = v;
    }

    public void setTextSize(float f) {
        this.A0 = f;
        this.g.setTextSize(f);
        this.h.setTextSize(this.A0);
    }

    public void setTextSizeOnTouch(float f) {
        this.B0 = f;
        this.i.setTextSize(f);
        this.j.setTextSize(this.B0);
    }
}

