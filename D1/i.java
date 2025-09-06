package d1;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import g1.a;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;

public final class i extends ReplacementSpan {
    public final float a;
    public final int b;
    public final float c;
    public final int d;
    public final float e;
    public final int f;
    public Paint.FontMetricsInt g;
    public int h;
    public int i;
    public boolean j;

    public i(float f, int v, int v1, float f1, float f2, int v2) {
        this.a = f;
        this.b = v;
        this.c = f1;
        this.d = v1;
        this.e = f2;
        this.f = v2;
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt paint$FontMetricsInt0 = this.g;
        if(paint$FontMetricsInt0 != null) {
            return paint$FontMetricsInt0;
        }
        q.m("fontMetrics");
        throw null;
    }

    public final int b() {
        if(!this.j) {
            a.c("PlaceholderSpan is not laid out yet.");
        }
        return this.i;
    }

    @Override  // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
    }

    @Override  // android.text.style.ReplacementSpan
    public final int getSize(Paint paint0, CharSequence charSequence0, int v, int v1, Paint.FontMetricsInt paint$FontMetricsInt0) {
        double f5;
        float f3;
        this.j = true;
        float f = paint0.getTextSize();
        this.g = paint0.getFontMetricsInt();
        if(this.a().descent <= this.a().ascent) {
            a.a("Invalid fontMetrics: line height can not be negative.");
        }
        float f1 = this.e;
        float f2 = this.a;
        switch(this.b) {
            case 0: {
                f3 = f2 * f1;
                break;
            }
            case 1: {
                f3 = f2 * f;
                break;
            }
            default: {
                a.b("Unsupported unit.");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.h = (int)(((float)Math.ceil(f3)));
        float f4 = this.c;
        switch(this.d) {
            case 0: {
                f5 = Math.ceil(f4 * f1);
                break;
            }
            case 1: {
                f5 = Math.ceil(f4 * f);
                break;
            }
            default: {
                a.b("Unsupported unit.");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.i = (int)(((float)f5));
        if(paint$FontMetricsInt0 != null) {
            paint$FontMetricsInt0.ascent = this.a().ascent;
            paint$FontMetricsInt0.descent = this.a().descent;
            paint$FontMetricsInt0.leading = this.a().leading;
            switch(this.f) {
                case 0: {
                    if(paint$FontMetricsInt0.ascent > -this.b()) {
                        paint$FontMetricsInt0.ascent = -this.b();
                    }
                    break;
                }
                case 1: 
                case 4: {
                    int v2 = paint$FontMetricsInt0.ascent;
                    if(this.b() + v2 > paint$FontMetricsInt0.descent) {
                        int v3 = paint$FontMetricsInt0.ascent;
                        paint$FontMetricsInt0.descent = this.b() + v3;
                    }
                    break;
                }
                case 2: 
                case 5: {
                    if(paint$FontMetricsInt0.ascent > paint$FontMetricsInt0.descent - this.b()) {
                        paint$FontMetricsInt0.ascent = paint$FontMetricsInt0.descent - this.b();
                    }
                    break;
                }
                case 3: 
                case 6: {
                    if(paint$FontMetricsInt0.descent - paint$FontMetricsInt0.ascent < this.b()) {
                        int v4 = paint$FontMetricsInt0.ascent - (this.b() - (paint$FontMetricsInt0.descent - paint$FontMetricsInt0.ascent)) / 2;
                        paint$FontMetricsInt0.ascent = v4;
                        paint$FontMetricsInt0.descent = this.b() + v4;
                    }
                    break;
                }
                default: {
                    a.a("Unknown verticalAlign.");
                }
            }
            paint$FontMetricsInt0.top = Math.min(this.a().top, paint$FontMetricsInt0.ascent);
            paint$FontMetricsInt0.bottom = Math.max(this.a().bottom, paint$FontMetricsInt0.descent);
        }
        if(!this.j) {
            a.c("PlaceholderSpan is not laid out yet.");
        }
        return this.h;
    }
}

