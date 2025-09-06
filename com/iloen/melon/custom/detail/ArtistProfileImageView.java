package com.iloen.melon.custom.detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.iloen.melon.custom.MelonImageView;
import k8.t1;

public class ArtistProfileImageView extends MelonImageView {
    public float B;
    public final float[] D;
    public float E;
    public float G;
    public float I;
    public float M;
    public int N;
    public int S;
    public Paint f;
    public Paint g;
    public Paint h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public final RectF n;
    public Path o;
    public Path r;
    public float w;

    public ArtistProfileImageView(Context context0) {
        this(context0, null);
    }

    public ArtistProfileImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = 0.0f;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = new RectF();
        this.D = new float[2];
        this.c(attributeSet0);
    }

    public ArtistProfileImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i = 0.0f;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = new RectF();
        this.D = new float[2];
        this.c(attributeSet0);
    }

    public final void c(AttributeSet attributeSet0) {
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.y);
        try {
            this.j = typedArray0.getDimension(9, 0.0f);
            this.i = typedArray0.getDimension(6, 0.0f);
            this.m = typedArray0.getColor(8, 0);
            this.k = typedArray0.getColor(2, 0);
            this.l = typedArray0.getColor(3, 0);
            this.N = typedArray0.getInt(0, 100);
            this.S = typedArray0.getInt(1, 0);
            this.E = (typedArray0.getFloat(10, 270.0f) % 360.0f + 360.0f) % 360.0f;
            float f = (typedArray0.getFloat(7, 270.0f) % 360.0f + 360.0f) % 360.0f;
            this.G = f;
            if(Float.compare(this.E, f) == 0) {
                this.G -= 0.1f;
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
        this.h.setColor(this.m);
        this.h.setStrokeWidth(this.j);
        int v1 = ((int)this.i) / 2 + ((int)this.j) / 2;
        this.setPadding(this.getPaddingLeft() + v1, this.getPaddingTop() + v1, this.getPaddingRight() + v1, this.getPaddingBottom() + v1);
    }

    public final void d() {
        float f = this.E;
        float f1 = (360.0f - (f - this.G)) % 360.0f;
        this.M = f1;
        if(f1 <= 0.0f) {
            this.M = 360.0f;
        }
        float f2 = (((float)this.S) / ((float)this.N) * this.M + f) % 360.0f - f;
        this.I = f2;
        if(f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.I = f2;
        this.n.set(this.j, this.j, this.w, this.B);
        Path path0 = new Path();
        this.o = path0;
        path0.addArc(this.n, this.E, this.M);
        Path path1 = new Path();
        this.r = path1;
        path1.addArc(this.n, this.E, this.I);
        PathMeasure pathMeasure0 = new PathMeasure(this.r, false);
        float f3 = pathMeasure0.getLength();
        float[] arr_f = this.D;
        if(!pathMeasure0.getPosTan(f3, arr_f, null)) {
            new PathMeasure(this.o, false).getPosTan(0.0f, arr_f, null);
        }
    }

    public int getMax() {
        return this.N;
    }

    public int getProgress() {
        return this.S;
    }

    @Override  // com.iloen.melon.custom.MelonImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        float f = this.getAlpha();
        this.f.setAlpha(((int)(((float)Color.alpha(this.k)) * f)));
        this.g.setAlpha(((int)(((float)Color.alpha(this.l)) * f)));
        this.h.setAlpha(((int)(((float)Color.alpha(this.m)) * f)));
        canvas0.drawPath(this.o, this.f);
        canvas0.drawPath(this.r, this.g);
        canvas0.drawCircle(this.D[0], this.D[1], this.j, this.h);
    }

    @Override  // android.widget.ImageView
    public final void onMeasure(int v, int v1) {
        int v2 = View.getDefaultSize(this.getSuggestedMinimumHeight(), v1);
        int v3 = View.getDefaultSize(this.getSuggestedMinimumWidth(), v);
        int v4 = Math.min(v3, v2);
        this.setMeasuredDimension(v4, v4);
        float f = Math.min(((float)v2) - this.j, ((float)v3) - this.j);
        this.B = f;
        this.w = f;
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
            if(v <= this.S) {
                this.S = 0;
            }
            this.N = v;
            this.d();
            this.invalidate();
        }
    }

    public void setPointerColor(int v) {
        this.m = v;
        this.h.setColor(v);
    }

    public void setProgress(int v) {
        if(this.S != v) {
            this.S = v;
            this.d();
            this.invalidate();
        }
    }

    public void setProgressColor(int v) {
        this.l = v;
        this.g.setColor(v);
    }
}

