package com.iloen.melon.custom;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import k8.t1;

public class ProgressImageView extends MelonImageView {
    public Path B;
    public float D;
    public float E;
    public final float[] G;
    public float I;
    public float M;
    public float N;
    public float S;
    public int T;
    public int V;
    public Paint f;
    public Paint g;
    public Paint h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final RectF r;
    public Path w;

    public ProgressImageView(Context context0) {
        this(context0, null);
    }

    public ProgressImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = 0.0f;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.r = new RectF();
        this.G = new float[2];
        this.c(attributeSet0);
    }

    public ProgressImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i = 0.0f;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.r = new RectF();
        this.G = new float[2];
        this.c(attributeSet0);
    }

    public final void c(AttributeSet attributeSet0) {
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.y);
        try {
            this.j = typedArray0.getDimension(9, 0.0f);
            this.i = typedArray0.getDimension(6, 0.0f);
            this.o = typedArray0.getColor(8, 0);
            this.k = typedArray0.getColor(2, 0);
            this.l = typedArray0.getColor(3, 0);
            this.m = typedArray0.getColor(5, 0);
            this.n = typedArray0.getColor(4, 0);
            this.T = typedArray0.getInt(0, 100);
            this.V = typedArray0.getInt(1, 0);
            this.I = (typedArray0.getFloat(10, 270.0f) % 360.0f + 360.0f) % 360.0f;
            float f = (typedArray0.getFloat(7, 270.0f) % 360.0f + 360.0f) % 360.0f;
            this.M = f;
            if(Float.compare(this.I, f) == 0) {
                this.M -= 0.1f;
            }
        }
        finally {
            typedArray0.recycle();
        }
        Paint paint0 = new Paint();
        this.f = paint0;
        paint0.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(this.k);
        this.f.setStrokeWidth(this.i);
        Paint.Style paint$Style0 = Paint.Style.STROKE;
        this.f.setStyle(paint$Style0);
        Paint.Join paint$Join0 = Paint.Join.ROUND;
        this.f.setStrokeJoin(paint$Join0);
        Paint.Cap paint$Cap0 = Paint.Cap.ROUND;
        this.f.setStrokeCap(paint$Cap0);
        Paint paint1 = new Paint();
        this.g = paint1;
        paint1.setAntiAlias(true);
        this.g.setDither(true);
        this.g.setColor(this.l);
        this.g.setStrokeWidth(this.i);
        this.g.setStyle(paint$Style0);
        this.g.setStrokeJoin(paint$Join0);
        this.g.setStrokeCap(paint$Cap0);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.o);
        this.h.setStrokeWidth(this.j);
        int v1 = ((int)this.j) - ((int)this.i) / 2;
        this.setPadding(this.getPaddingLeft() + v1, this.getPaddingTop() + v1, this.getPaddingRight() + v1, this.getPaddingBottom() + v1);
    }

    public final void d() {
        int v = this.m;
        if(v != 0) {
            int v1 = this.n;
            if(v1 != 0) {
                int v2 = (int)(((Integer)new ArgbEvaluator().evaluate(((float)this.getProgress()) / ((float)this.getMax()), v, v1)));
                this.o = v2;
                this.h.setColor(v2);
            }
        }
        float f = this.I;
        float f1 = (360.0f - (f - this.M)) % 360.0f;
        this.S = f1;
        if(f1 <= 0.0f) {
            this.S = 360.0f;
        }
        float f2 = (((float)this.V) / ((float)this.T) * this.S + f) % 360.0f - f;
        this.N = f2;
        if(f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.N = f2;
        this.r.set(this.j, this.j, this.D, this.E);
        Path path0 = new Path();
        this.w = path0;
        path0.addArc(this.r, this.I, this.S);
        Path path1 = new Path();
        this.B = path1;
        path1.addArc(this.r, this.I, this.N);
        PathMeasure pathMeasure0 = new PathMeasure(this.B, false);
        float f3 = pathMeasure0.getLength();
        float[] arr_f = this.G;
        if(!pathMeasure0.getPosTan(f3, arr_f, null)) {
            new PathMeasure(this.w, false).getPosTan(0.0f, arr_f, null);
        }
        if(this.m == 0 && this.n == 0) {
            return;
        }
        float f4 = (float)(((int)(this.D / 2.0f)));
        float f5 = (float)(((int)(this.E / 2.0f)));
        SweepGradient sweepGradient0 = new SweepGradient(f4, f5, this.m, this.n);
        Matrix matrix0 = new Matrix();
        matrix0.setRotate(270.0f, f4, f5);
        sweepGradient0.setLocalMatrix(matrix0);
        this.g.setShader(sweepGradient0);
    }

    public int getMax() {
        return this.T;
    }

    public int getProgress() {
        return this.V;
    }

    @Override  // com.iloen.melon.custom.MelonImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        float f = this.getAlpha();
        this.f.setAlpha(((int)(((float)Color.alpha(this.k)) * f)));
        this.g.setAlpha(((int)(((float)Color.alpha(this.l)) * f)));
        this.h.setAlpha(((int)(((float)Color.alpha(this.o)) * f)));
        canvas0.drawPath(this.w, this.f);
        canvas0.drawPath(this.B, this.g);
        canvas0.drawCircle(this.G[0], this.G[1], this.j, this.h);
    }

    @Override  // android.widget.ImageView
    public final void onMeasure(int v, int v1) {
        int v2 = View.getDefaultSize(this.getSuggestedMinimumHeight(), v1);
        int v3 = View.getDefaultSize(this.getSuggestedMinimumWidth(), v);
        int v4 = Math.min(v3, v2);
        this.setMeasuredDimension(v4, v4);
        float f = Math.min(((float)v2) - this.j, ((float)v3) - this.j);
        this.E = f;
        this.D = f;
        this.d();
    }

    @Override  // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
    }

    @Override  // android.view.View
    public void setBackground(Drawable drawable0) {
        super.setBackground(drawable0);
    }

    public void setMax(int v) {
        if(v > 0) {
            if(v <= this.V) {
                this.V = 0;
            }
            this.T = v;
            this.d();
            this.invalidate();
        }
    }

    public void setPointerColor(int v) {
        this.o = v;
        this.h.setColor(v);
    }

    public void setProgress(int v) {
        if(this.V != v) {
            this.V = v;
            this.d();
            this.invalidate();
        }
    }

    public void setProgressColor(int v) {
        this.l = v;
        this.g.setColor(v);
    }
}

