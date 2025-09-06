package v6;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

public final class f extends n {
    public float b;
    public float c;
    public float d;
    public boolean e;
    public float f;

    @Override  // v6.n
    public final void a(Canvas canvas0, Rect rect0, float f, boolean z, boolean z1) {
        float f1 = ((float)rect0.width()) / ((float)this.i());
        float f2 = ((float)rect0.height()) / ((float)this.i());
        CircularProgressIndicatorSpec circularProgressIndicatorSpec0 = (CircularProgressIndicatorSpec)this.a;
        float f3 = ((float)circularProgressIndicatorSpec0.h) / 2.0f + ((float)circularProgressIndicatorSpec0.i);
        canvas0.translate(f3 * f1 + ((float)rect0.left), f3 * f2 + ((float)rect0.top));
        canvas0.rotate(-90.0f);
        canvas0.scale(f1, f2);
        if(circularProgressIndicatorSpec0.j != 0) {
            canvas0.scale(1.0f, -1.0f);
        }
        canvas0.clipRect(-f3, -f3, f3, f3);
        int v = circularProgressIndicatorSpec0.b;
        this.e = circularProgressIndicatorSpec0.a / 2 <= v;
        this.b = ((float)circularProgressIndicatorSpec0.a) * f;
        this.c = ((float)Math.min(circularProgressIndicatorSpec0.a / 2, v)) * f;
        int v1 = circularProgressIndicatorSpec0.a;
        float f4 = ((float)(circularProgressIndicatorSpec0.h - v1)) / 2.0f;
        this.d = f4;
        if(z || z1) {
            if(z && circularProgressIndicatorSpec0.e == 2 || z1 && circularProgressIndicatorSpec0.f == 1) {
                this.d = (1.0f - f) * ((float)v1) / 2.0f + f4;
            }
            else if(z && circularProgressIndicatorSpec0.e == 1 || z1 && circularProgressIndicatorSpec0.f == 2) {
                this.d = f4 - (1.0f - f) * ((float)v1) / 2.0f;
            }
        }
        if(z1 && circularProgressIndicatorSpec0.f == 3) {
            this.f = f;
            return;
        }
        this.f = 1.0f;
    }

    @Override  // v6.n
    public final void b(Canvas canvas0, Paint paint0, int v, int v1) {
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
        return this.i();
    }

    @Override  // v6.n
    public final int f() {
        return this.i();
    }

    public final void g(Canvas canvas0, Paint paint0, float f, float f1, int v, int v1, int v2) {
        float f2 = Float.compare(f1, f) < 0 ? f1 + 1.0f - f : f1 - f;
        if(this.f < 1.0f) {
            float f3 = f % 1.0f + f2;
            if(f3 > 1.0f) {
                this.g(canvas0, paint0, f % 1.0f, 1.0f, v, v1, 0);
                this.g(canvas0, paint0, 1.0f, f3, v, 0, v2);
                return;
            }
        }
        float f4 = (float)Math.toDegrees(this.c / this.d);
        if(Float.compare(f % 1.0f, 0.0f) == 0 && f2 >= 0.99f) {
            f2 += f4 * 2.0f / 360.0f * (f2 - 0.99f) / 0.01f;
        }
        float f5 = f % 1.0f * 1.0f + (1.0f - f % 1.0f) * (1.0f - this.f);
        float f6 = f2 * this.f + (1.0f - f2) * 0.0f;
        float f7 = (float)Math.toDegrees(((float)v1) / this.d);
        float f8 = f6 * 360.0f - f7 - ((float)Math.toDegrees(((float)v2) / this.d));
        float f9 = f5 * 360.0f + f7;
        if(f8 > 0.0f) {
            paint0.setAntiAlias(true);
            paint0.setColor(v);
            paint0.setStrokeWidth(this.b);
            if(f8 < f4 * 2.0f) {
                float f10 = f8 / (f4 * 2.0f);
                paint0.setStyle(Paint.Style.FILL);
                this.h(canvas0, paint0, f4 * f10 + f9, this.c * 2.0f, this.b, f10);
                return;
            }
            float f11 = -this.d;
            RectF rectF0 = new RectF(f11, f11, this.d, this.d);
            paint0.setStyle(Paint.Style.STROKE);
            paint0.setStrokeCap((this.e ? Paint.Cap.ROUND : Paint.Cap.BUTT));
            float f12 = f9 + f4;
            canvas0.drawArc(rectF0, f12, f8 - f4 * 2.0f, false, paint0);
            if(!this.e && this.c > 0.0f) {
                paint0.setStyle(Paint.Style.FILL);
                this.h(canvas0, paint0, f12, this.c * 2.0f, this.b, 1.0f);
                this.h(canvas0, paint0, f9 + f8 - f4, this.c * 2.0f, this.b, 1.0f);
            }
        }
    }

    public final void h(Canvas canvas0, Paint paint0, float f, float f1, float f2, float f3) {
        float f4 = (float)(((int)Math.min(f2, this.b)));
        float f5 = Math.min(f1 / 2.0f, this.c * f4 / this.b);
        RectF rectF0 = new RectF(-f4 / 2.0f, -f1 / 2.0f, f4 / 2.0f, f1 / 2.0f);
        canvas0.save();
        canvas0.translate(((float)(Math.cos(Math.toRadians(f)) * ((double)this.d))), ((float)(Math.sin(Math.toRadians(f)) * ((double)this.d))));
        canvas0.rotate(f);
        canvas0.scale(f3, f3);
        canvas0.drawRoundRect(rectF0, f5, f5, paint0);
        canvas0.restore();
    }

    public final int i() {
        return ((CircularProgressIndicatorSpec)this.a).i * 2 + ((CircularProgressIndicatorSpec)this.a).h;
    }
}

