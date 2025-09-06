package d1;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import g1.a;

public final class h implements LineHeightSpan {
    public final float a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final float e;
    public final boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public h(float f, int v, boolean z, boolean z1, float f1, boolean z2) {
        this.a = f;
        this.b = v;
        this.c = z;
        this.d = z1;
        this.e = f1;
        this.f = z2;
        this.g = 0x80000000;
        this.h = 0x80000000;
        this.i = 0x80000000;
        this.j = 0x80000000;
        if(0.0f <= f1 && f1 <= 1.0f || f1 == -1.0f) {
            return;
        }
        a.c("topRatio should be in [0..1] range or -1");
    }

    @Override  // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence0, int v, int v1, int v2, int v3, Paint.FontMetricsInt paint$FontMetricsInt0) {
        boolean z = true;
        int v4 = paint$FontMetricsInt0.descent;
        int v5 = paint$FontMetricsInt0.ascent;
        if(v4 - v5 > 0) {
            if(v1 != this.b) {
                z = false;
            }
            boolean z1 = this.d;
            boolean z2 = this.c;
            if(v != 0 || !z || !z2 || !z1) {
                if(this.g == 0x80000000) {
                    int v6 = (int)(((float)Math.ceil(this.a)));
                    int v7 = v6 - (v4 - v5);
                    if(!this.f || v7 > 0) {
                        float f = this.e == -1.0f ? Math.abs(paint$FontMetricsInt0.ascent) / ((float)(paint$FontMetricsInt0.descent - paint$FontMetricsInt0.ascent)) : this.e;
                        int v8 = paint$FontMetricsInt0.descent;
                        int v9 = ((int)(((float)(v7 > 0 ? Math.ceil((1.0f - f) * ((float)v7)) : Math.ceil(((float)v7) * f))))) + v8;
                        this.i = v9;
                        int v10 = v9 - v6;
                        this.h = v10;
                        if(z2) {
                            v10 = paint$FontMetricsInt0.ascent;
                        }
                        this.g = v10;
                        if(z1) {
                            v9 = v8;
                        }
                        this.j = v9;
                        this.k = paint$FontMetricsInt0.ascent - v10;
                        this.l = v9 - v8;
                    }
                    else {
                        this.h = paint$FontMetricsInt0.ascent;
                        this.i = paint$FontMetricsInt0.descent;
                        this.g = paint$FontMetricsInt0.ascent;
                        this.j = paint$FontMetricsInt0.descent;
                        this.k = 0;
                        this.l = 0;
                    }
                }
                paint$FontMetricsInt0.ascent = v == 0 ? this.h : this.g;
                paint$FontMetricsInt0.descent = z ? this.j : this.i;
            }
        }
    }
}

