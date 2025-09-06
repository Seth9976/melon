package v6;

import E9.h;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

public final class p extends n {
    public float b;
    public float c;
    public float d;
    public boolean e;
    public float f;

    @Override  // v6.n
    public final void a(Canvas canvas0, Rect rect0, float f, boolean z, boolean z1) {
        this.b = (float)rect0.width();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec0 = (LinearProgressIndicatorSpec)this.a;
        float f1 = (float)linearProgressIndicatorSpec0.a;
        float f2 = (float)rect0.left;
        float f3 = ((float)rect0.width()) / 2.0f + f2;
        float f4 = (float)rect0.top;
        float f5 = ((float)rect0.height()) / 2.0f + f4;
        canvas0.translate(f3, Math.max(0.0f, (((float)rect0.height()) - f1) / 2.0f) + f5);
        if(linearProgressIndicatorSpec0.j) {
            canvas0.scale(-1.0f, 1.0f);
        }
        canvas0.clipRect(-(this.b / 2.0f), -(f1 / 2.0f), this.b / 2.0f, f1 / 2.0f);
        this.e = linearProgressIndicatorSpec0.a / 2 == linearProgressIndicatorSpec0.b;
        this.c = ((float)linearProgressIndicatorSpec0.a) * f;
        this.d = ((float)Math.min(linearProgressIndicatorSpec0.a / 2, linearProgressIndicatorSpec0.b)) * f;
        if(z || z1) {
            if(z && linearProgressIndicatorSpec0.e == 2 || z1 && linearProgressIndicatorSpec0.f == 1) {
                canvas0.scale(1.0f, -1.0f);
            }
            if(z || z1 && linearProgressIndicatorSpec0.f != 3) {
                canvas0.translate(0.0f, (1.0f - f) * ((float)linearProgressIndicatorSpec0.a) / 2.0f);
            }
        }
        if(z1 && linearProgressIndicatorSpec0.f == 3) {
            this.f = f;
            return;
        }
        this.f = 1.0f;
    }

    @Override  // v6.n
    public final void b(Canvas canvas0, Paint paint0, int v, int v1) {
        int v2 = e1.n.l(v, v1);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec0 = (LinearProgressIndicatorSpec)this.a;
        if(linearProgressIndicatorSpec0.k > 0 && v2 != 0) {
            paint0.setStyle(Paint.Style.FILL);
            paint0.setColor(v2);
            this.h(canvas0, paint0, new PointF(this.b / 2.0f - this.c / 2.0f, 0.0f), null, ((float)linearProgressIndicatorSpec0.k), ((float)linearProgressIndicatorSpec0.k));
        }
    }

    @Override  // v6.n
    public final void c(Canvas canvas0, Paint paint0, m m0, int v) {
        int v1 = e1.n.l(m0.c, v);
        this.g(canvas0, paint0, m0.a, m0.b, v1, m0.d, m0.d);
    }

    @Override  // v6.n
    public final void d(Canvas canvas0, Paint paint0, float f, float f1, int v, int v1, int v2) {
        this.g(canvas0, paint0, f, f1, e1.n.l(v, v1), v2, v2);
    }

    @Override  // v6.n
    public final int e() {
        return ((LinearProgressIndicatorSpec)this.a).a;
    }

    @Override  // v6.n
    public final int f() {
        return -1;
    }

    public final void g(Canvas canvas0, Paint paint0, float f, float f1, int v, int v1, int v2) {
        float f10;
        float f2 = h.q(f, 0.0f, 1.0f) * 1.0f + (1.0f - h.q(f, 0.0f, 1.0f)) * (1.0f - this.f);
        float f3 = h.q(f1, 0.0f, 1.0f) * 1.0f + (1.0f - h.q(f1, 0.0f, 1.0f)) * (1.0f - this.f);
        int v3 = (int)(f2 * this.b + ((float)(((int)(h.q(f2, 0.0f, 0.01f) * ((float)v1) / 0.01f)))));
        int v4 = (int)(f3 * this.b - ((float)(((int)((1.0f - h.q(f3, 0.99f, 1.0f)) * ((float)v2) / 0.01f)))));
        float f4 = -this.b / 2.0f;
        if(v3 <= v4) {
            float f5 = ((float)v3) + this.d;
            float f6 = ((float)v4) - this.d;
            float f7 = this.d * 2.0f;
            paint0.setColor(v);
            paint0.setAntiAlias(true);
            paint0.setStrokeWidth(this.c);
            if(f5 >= f6) {
                this.h(canvas0, paint0, new PointF(f5 + f4, 0.0f), new PointF(f6 + f4, 0.0f), f7, this.c);
                return;
            }
            paint0.setStyle(Paint.Style.STROKE);
            paint0.setStrokeCap((this.e ? Paint.Cap.ROUND : Paint.Cap.BUTT));
            float f8 = f5 + f4;
            float f9 = f6 + f4;
            canvas0.drawLine(f8, 0.0f, f9, 0.0f, paint0);
            if(!this.e && this.d > 0.0f) {
                paint0.setStyle(Paint.Style.FILL);
                if(f5 > 0.0f) {
                    f10 = f7;
                    this.h(canvas0, paint0, new PointF(f8, 0.0f), null, f10, this.c);
                }
                else {
                    f10 = f7;
                }
                if(f6 < this.b) {
                    this.h(canvas0, paint0, new PointF(f9, 0.0f), null, f10, this.c);
                }
            }
        }
    }

    public final void h(Canvas canvas0, Paint paint0, PointF pointF0, PointF pointF1, float f, float f1) {
        float f2 = Math.min(f1, this.c);
        float f3 = Math.min(f / 2.0f, this.d * f2 / this.c);
        RectF rectF0 = new RectF(-f / 2.0f, -f2 / 2.0f, f / 2.0f, f2 / 2.0f);
        paint0.setStyle(Paint.Style.FILL);
        canvas0.save();
        if(pointF1 != null) {
            canvas0.translate(pointF1.x, pointF1.y);
            Path path0 = new Path();
            path0.addRoundRect(rectF0, f3, f3, Path.Direction.CCW);
            canvas0.clipPath(path0);
            canvas0.translate(-pointF1.x, -pointF1.y);
        }
        canvas0.translate(pointF0.x, pointF0.y);
        canvas0.drawRoundRect(rectF0, f3, f3, paint0);
        canvas0.restore();
    }
}

