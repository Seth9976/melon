package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public final class u {
    public float[] a;
    public final int[] b;
    public final float[] c;
    public Path d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public final float[] j;
    public int k;
    public final Rect l;
    public final int m;
    public final MotionLayout n;

    public u(MotionLayout motionLayout0) {
        this.n = motionLayout0;
        this.l = new Rect();
        this.m = 1;
        Paint paint0 = new Paint();
        this.e = paint0;
        paint0.setAntiAlias(true);
        paint0.setColor(0xFFFFAA33);
        paint0.setStrokeWidth(2.0f);
        Paint.Style paint$Style0 = Paint.Style.STROKE;
        paint0.setStyle(paint$Style0);
        Paint paint1 = new Paint();
        this.f = paint1;
        paint1.setAntiAlias(true);
        paint1.setColor(-2067046);
        paint1.setStrokeWidth(2.0f);
        paint1.setStyle(paint$Style0);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(0xFF33AA00);
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(paint$Style0);
        Paint paint3 = new Paint();
        this.h = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(0xFF33AA00);
        paint3.setTextSize(motionLayout0.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.j = new float[8];
        Paint paint4 = new Paint();
        this.i = paint4;
        paint4.setAntiAlias(true);
        paint2.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
        this.c = new float[100];
        this.b = new int[50];
    }

    public final void a(Canvas canvas0, int v, int v1, q q0) {
        float f2;
        int v5;
        int v4;
        int[] arr_v = this.b;
        if(v == 4) {
            boolean z = false;
            boolean z1 = false;
            for(int v2 = 0; v2 < this.k; ++v2) {
                int v3 = arr_v[v2];
                if(v3 == 1) {
                    z = true;
                }
                if(v3 == 0) {
                    z1 = true;
                }
            }
            if(z) {
                canvas0.drawLine(this.a[0], this.a[1], this.a[this.a.length - 2], this.a[this.a.length - 1], this.g);
            }
            if(z1) {
                this.b(canvas0);
            }
        }
        if(v == 2) {
            canvas0.drawLine(this.a[0], this.a[1], this.a[this.a.length - 2], this.a[this.a.length - 1], this.g);
        }
        if(v == 3) {
            this.b(canvas0);
        }
        canvas0.drawLines(this.a, this.e);
        View view0 = q0.b;
        if(view0 == null) {
            v4 = 0;
            v5 = 0;
        }
        else {
            v4 = view0.getWidth();
            v5 = q0.b.getHeight();
        }
        int v6 = 1;
        while(v6 < v1 - 1) {
            if(v != 4 || arr_v[v6 - 1] != 0) {
                float f = this.c[v6 * 2];
                float f1 = this.c[v6 * 2 + 1];
                this.d.reset();
                this.d.moveTo(f, f1 + 10.0f);
                this.d.lineTo(f + 10.0f, f1);
                this.d.lineTo(f, f1 - 10.0f);
                this.d.lineTo(f - 10.0f, f1);
                this.d.close();
                B b0 = (B)q0.u.get(v6 - 1);
                Paint paint0 = this.i;
                if(v == 4) {
                    int v7 = arr_v[v6 - 1];
                    if(v7 == 1) {
                        this.d(canvas0, f - 0.0f, f1 - 0.0f);
                    }
                    else if(v7 == 0) {
                        this.c(canvas0, f - 0.0f, f1 - 0.0f);
                    }
                    else if(v7 == 2) {
                        f2 = f1;
                        this.e(canvas0, f - 0.0f, f2 - 0.0f, v4, v5);
                        goto label_55;
                    }
                    f2 = f1;
                label_55:
                    canvas0.drawPath(this.d, paint0);
                }
                else {
                    f2 = f1;
                }
                if(v == 2) {
                    this.d(canvas0, f - 0.0f, f2 - 0.0f);
                }
                if(v == 3) {
                    this.c(canvas0, f - 0.0f, f2 - 0.0f);
                }
                if(v == 6) {
                    this.e(canvas0, f - 0.0f, f2 - 0.0f, v4, v5);
                }
                canvas0.drawPath(this.d, paint0);
            }
            ++v6;
        }
        float[] arr_f = this.a;
        if(arr_f.length > 1) {
            canvas0.drawCircle(arr_f[0], arr_f[1], 8.0f, this.f);
            canvas0.drawCircle(this.a[this.a.length - 2], this.a[this.a.length - 1], 8.0f, this.f);
        }
    }

    public final void b(Canvas canvas0) {
        float[] arr_f = this.a;
        float f = arr_f[0];
        float f1 = arr_f[1];
        float f2 = arr_f[arr_f.length - 2];
        float f3 = arr_f[arr_f.length - 1];
        canvas0.drawLine(Math.min(f, f2), Math.max(f1, f3), Math.max(f, f2), Math.max(f1, f3), this.g);
        canvas0.drawLine(Math.min(f, f2), Math.min(f1, f3), Math.min(f, f2), Math.max(f1, f3), this.g);
    }

    public final void c(Canvas canvas0, float f, float f1) {
        float[] arr_f = this.a;
        float f2 = arr_f[0];
        float f3 = arr_f[1];
        float f4 = arr_f[arr_f.length - 2];
        float f5 = arr_f[arr_f.length - 1];
        float f6 = f - Math.min(f2, f4);
        float f7 = Math.max(f3, f5) - f1;
        String s = "" + ((float)(((int)(((double)(f6 * 100.0f / Math.abs(f4 - f2))) + 0.5)))) / 100.0f;
        this.h.getTextBounds(s, 0, s.length(), this.l);
        canvas0.drawText(s, f6 / 2.0f - ((float)(this.l.width() / 2)) + Math.min(f2, f4), f1 - 20.0f, this.h);
        canvas0.drawLine(f, f1, Math.min(f2, f4), f1, this.g);
        String s1 = "" + ((float)(((int)(((double)(f7 * 100.0f / Math.abs(f5 - f3))) + 0.5)))) / 100.0f;
        this.h.getTextBounds(s1, 0, s1.length(), this.l);
        canvas0.drawText(s1, f + 5.0f, Math.max(f3, f5) - (f7 / 2.0f - ((float)(this.l.height() / 2))), this.h);
        canvas0.drawLine(f, f1, f, Math.max(f3, f5), this.g);
    }

    public final void d(Canvas canvas0, float f, float f1) {
        float[] arr_f = this.a;
        float f2 = arr_f[0];
        float f3 = arr_f[1];
        float f4 = arr_f[arr_f.length - 2];
        float f5 = arr_f[arr_f.length - 1];
        float f6 = (float)Math.hypot(f2 - f4, f3 - f5);
        float f7 = f4 - f2;
        float f8 = f5 - f3;
        float f9 = ((f1 - f3) * f8 + (f - f2) * f7) / (f6 * f6);
        float f10 = f7 * f9 + f2;
        float f11 = f9 * f8 + f3;
        Path path0 = new Path();
        path0.moveTo(f, f1);
        path0.lineTo(f10, f11);
        float f12 = (float)Math.hypot(f10 - f, f11 - f1);
        String s = "" + ((float)(((int)(f12 * 100.0f / f6)))) / 100.0f;
        this.h.getTextBounds(s, 0, s.length(), this.l);
        canvas0.drawTextOnPath(s, path0, f12 / 2.0f - ((float)(this.l.width() / 2)), -20.0f, this.h);
        canvas0.drawLine(f, f1, f10, f11, this.g);
    }

    public final void e(Canvas canvas0, float f, float f1, int v, int v1) {
        String s = "" + ((float)(((int)(((double)((f - ((float)(v / 2))) * 100.0f / ((float)(this.n.getWidth() - v)))) + 0.5)))) / 100.0f;
        this.h.getTextBounds(s, 0, s.length(), this.l);
        canvas0.drawText(s, f / 2.0f - ((float)(this.l.width() / 2)) + 0.0f, f1 - 20.0f, this.h);
        canvas0.drawLine(f, f1, 0.0f, f1, this.g);
        String s1 = "" + ((float)(((int)(((double)((f1 - ((float)(v1 / 2))) * 100.0f / ((float)(this.n.getHeight() - v1)))) + 0.5)))) / 100.0f;
        this.h.getTextBounds(s1, 0, s1.length(), this.l);
        canvas0.drawText(s1, f + 5.0f, 0.0f - (f1 / 2.0f - ((float)(this.l.height() / 2))), this.h);
        canvas0.drawLine(f, f1, f, 1.0f, this.g);
    }
}

