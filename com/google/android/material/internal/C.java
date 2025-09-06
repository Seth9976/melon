package com.google.android.material.internal;

import E9.h;
import H0.b;
import a2.f;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;
import e1.n;
import e1.x;
import w6.a;
import w6.d;

public final class c {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public a D;
    public a E;
    public TextUtils.TruncateAt F;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public boolean J;
    public Bitmap K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int[] R;
    public boolean S;
    public final TextPaint T;
    public final TextPaint U;
    public TimeInterpolator V;
    public TimeInterpolator W;
    public float X;
    public float Y;
    public float Z;
    public final ViewGroup a;
    public ColorStateList a0;
    public float b;
    public float b0;
    public boolean c;
    public float c0;
    public float d;
    public float d0;
    public float e;
    public ColorStateList e0;
    public int f;
    public float f0;
    public final Rect g;
    public float g0;
    public final Rect h;
    public float h0;
    public final RectF i;
    public StaticLayout i0;
    public int j;
    public float j0;
    public int k;
    public float k0;
    public float l;
    public float l0;
    public float m;
    public CharSequence m0;
    public ColorStateList n;
    public int n0;
    public ColorStateList o;
    public float o0;
    public int p;
    public float p0;
    public float q;
    public int q0;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public Typeface w;
    public Typeface x;
    public Typeface y;
    public Typeface z;

    public c(ViewGroup viewGroup0) {
        this.j = 16;
        this.k = 16;
        this.l = 15.0f;
        this.m = 15.0f;
        this.F = TextUtils.TruncateAt.END;
        this.J = true;
        this.n0 = 1;
        this.o0 = 0.0f;
        this.p0 = 1.0f;
        this.q0 = 1;
        this.a = viewGroup0;
        TextPaint textPaint0 = new TextPaint(0x81);
        this.T = textPaint0;
        this.U = new TextPaint(textPaint0);
        this.h = new Rect();
        this.g = new Rect();
        this.i = new RectF();
        this.e = (1.0f - this.d) * 0.5f + this.d;
        this.h(viewGroup0.getContext().getResources().getConfiguration());
    }

    public static int a(float f, int v, int v1) {
        float f1 = ((float)Color.alpha(v)) * (1.0f - f);
        float f2 = ((float)Color.alpha(v1)) * f + f1;
        float f3 = ((float)Color.red(v)) * (1.0f - f);
        float f4 = ((float)Color.red(v1)) * f + f3;
        float f5 = ((float)Color.green(v)) * (1.0f - f);
        float f6 = ((float)Color.green(v1)) * f + f5;
        float f7 = ((float)Color.blue(v)) * (1.0f - f);
        return Color.argb(Math.round(f2), Math.round(f4), Math.round(f6), Math.round(((float)Color.blue(v1)) * f + f7));
    }

    public final boolean b(CharSequence charSequence0) {
        boolean z = this.a.getLayoutDirection() == 1;
        if(this.J) {
            return z ? f.d.f(charSequence0, charSequence0.length()) : f.c.f(charSequence0, charSequence0.length());
        }
        return z;
    }

    public final void c(float f, boolean z) {
        Layout.Alignment layout$Alignment0;
        boolean z2;
        Typeface typeface0;
        float f4;
        float f3;
        if(this.G != null) {
            float f1 = (float)this.h.width();
            float f2 = (float)this.g.width();
            if(Float.compare(Math.abs(f - 1.0f), 0.00001f) < 0) {
                f3 = this.m;
                f4 = this.f0;
                this.L = 1.0f;
                typeface0 = this.w;
            }
            else {
                float f5 = this.l;
                float f6 = this.g0;
                Typeface typeface1 = this.z;
                this.L = Math.abs(f - 0.0f) < 0.00001f ? 1.0f : c.g(this.l, this.m, f, this.W) / this.l;
                float f7 = this.m / this.l;
                f1 = z || this.c || f2 * f7 <= f1 ? f2 : Math.min(f1 / f7, f2);
                f3 = f5;
                f4 = f6;
                typeface0 = typeface1;
            }
            TextPaint textPaint0 = this.T;
            if(Float.compare(f1, 0.0f) > 0) {
                boolean z1 = this.C != typeface0;
                z2 = this.M != f3 || this.h0 != f4 || this.i0 != null && f1 != ((float)this.i0.getWidth()) || z1 || this.S;
                this.M = f3;
                this.h0 = f4;
                this.C = typeface0;
                this.S = false;
                textPaint0.setLinearText(this.L != 1.0f);
            }
            else {
                z2 = false;
            }
            if(this.H == null || z2) {
                textPaint0.setTextSize(this.M);
                textPaint0.setTypeface(this.C);
                textPaint0.setLetterSpacing(this.h0);
                boolean z3 = this.b(this.G);
                this.I = z3;
                int v = this.n0 > 1 && (!z3 || this.c) ? this.n0 : 1;
                if(v == 1) {
                    layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                }
                else {
                    switch(Gravity.getAbsoluteGravity(this.j, ((int)z3)) & 7) {
                        case 1: {
                            layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                            break;
                        }
                        case 5: {
                            layout$Alignment0 = this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        }
                        default: {
                            layout$Alignment0 = this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
                        }
                    }
                }
                v v1 = new v(this.G, textPaint0, ((int)f1));
                v1.l = this.F;
                v1.k = z3;
                v1.e = layout$Alignment0;
                v1.j = false;
                v1.f = v;
                v1.g = this.o0;
                v1.h = this.p0;
                v1.i = this.q0;
                StaticLayout staticLayout0 = v1.a();
                staticLayout0.getClass();
                this.i0 = staticLayout0;
                this.H = staticLayout0.getText();
            }
        }
    }

    public final void d(Canvas canvas0) {
        int v = canvas0.save();
        if(this.H != null && (this.i.width() > 0.0f && this.i.height() > 0.0f)) {
            TextPaint textPaint0 = this.T;
            textPaint0.setTextSize(this.M);
            float f = this.u;
            float f1 = this.v;
            float f2 = this.L;
            if(f2 != 1.0f && !this.c) {
                canvas0.scale(f2, f2, f, f1);
            }
            if(this.n0 <= 1 || this.I && !this.c || this.c && this.b <= this.e) {
                canvas0.translate(f, f1);
                this.i0.draw(canvas0);
            }
            else {
                float f3 = this.u - ((float)this.i0.getLineStart(0));
                int v1 = textPaint0.getAlpha();
                canvas0.translate(f3, f1);
                if(!this.c) {
                    textPaint0.setAlpha(((int)(this.l0 * ((float)v1))));
                    if(Build.VERSION.SDK_INT >= 0x1F) {
                        textPaint0.setShadowLayer(this.N, this.O, this.P, n.l(this.Q, textPaint0.getAlpha()));
                    }
                    this.i0.draw(canvas0);
                }
                if(!this.c) {
                    textPaint0.setAlpha(((int)(this.k0 * ((float)v1))));
                }
                int v2 = Build.VERSION.SDK_INT;
                if(v2 >= 0x1F) {
                    textPaint0.setShadowLayer(this.N, this.O, this.P, n.l(this.Q, textPaint0.getAlpha()));
                }
                int v3 = this.i0.getLineBaseline(0);
                canvas0.drawText(this.m0, 0, this.m0.length(), 0.0f, ((float)v3), textPaint0);
                if(v2 >= 0x1F) {
                    textPaint0.setShadowLayer(this.N, this.O, this.P, this.Q);
                }
                if(!this.c) {
                    String s = this.m0.toString().trim();
                    if(s.endsWith("…")) {
                        s = b.d(1, 0, s);
                    }
                    textPaint0.setAlpha(v1);
                    canvas0.drawText(s, 0, Math.min(this.i0.getLineEnd(0), s.length()), 0.0f, ((float)v3), textPaint0);
                }
            }
            canvas0.restoreToCount(v);
        }
    }

    public final float e() {
        this.U.setTextSize(this.m);
        this.U.setTypeface(this.w);
        this.U.setLetterSpacing(this.f0);
        return -this.U.ascent();
    }

    public final int f(ColorStateList colorStateList0) {
        if(colorStateList0 == null) {
            return 0;
        }
        int[] arr_v = this.R;
        return arr_v == null ? colorStateList0.getDefaultColor() : colorStateList0.getColorForState(arr_v, 0);
    }

    public static float g(float f, float f1, float f2, TimeInterpolator timeInterpolator0) {
        if(timeInterpolator0 != null) {
            f2 = timeInterpolator0.getInterpolation(f2);
        }
        return e6.a.a(f, f1, f2);
    }

    public final void h(Configuration configuration0) {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            Typeface typeface0 = this.y;
            if(typeface0 != null) {
                this.x = x.K(configuration0, typeface0);
            }
            Typeface typeface1 = this.B;
            if(typeface1 != null) {
                this.A = x.K(configuration0, typeface1);
            }
            this.w = this.x == null ? this.y : this.x;
            this.z = this.A == null ? this.B : this.A;
            this.i(true);
        }
    }

    public final void i(boolean z) {
        float f7;
        float f4;
        ViewGroup viewGroup0 = this.a;
        if(viewGroup0.getHeight() > 0 && viewGroup0.getWidth() > 0 || z) {
            this.c(1.0f, z);
            CharSequence charSequence0 = this.H;
            TextPaint textPaint0 = this.T;
            if(charSequence0 != null) {
                StaticLayout staticLayout0 = this.i0;
                if(staticLayout0 != null) {
                    this.m0 = TextUtils.ellipsize(charSequence0, textPaint0, ((float)staticLayout0.getWidth()), this.F);
                }
            }
            CharSequence charSequence1 = this.m0;
            this.j0 = charSequence1 == null ? 0.0f : textPaint0.measureText(charSequence1, 0, charSequence1.length());
            int v = Gravity.getAbsoluteGravity(this.k, ((int)this.I));
            Rect rect0 = this.h;
            switch(v & 0x70) {
                case 0x30: {
                    this.r = (float)rect0.top;
                    break;
                }
                case 80: {
                    float f2 = (float)rect0.bottom;
                    this.r = textPaint0.ascent() + f2;
                    break;
                }
                default: {
                    float f = textPaint0.descent();
                    float f1 = textPaint0.ascent();
                    this.r = ((float)rect0.centerY()) - (f - f1) / 2.0f;
                }
            }
            switch(v & 0x800007) {
                case 1: {
                    this.t = ((float)rect0.centerX()) - this.j0 / 2.0f;
                    break;
                }
                case 5: {
                    this.t = ((float)rect0.right) - this.j0;
                    break;
                }
                default: {
                    this.t = (float)rect0.left;
                }
            }
            this.c(0.0f, z);
            float f3 = this.i0 == null ? 0.0f : ((float)this.i0.getHeight());
            StaticLayout staticLayout1 = this.i0;
            if(staticLayout1 == null || this.n0 <= 1) {
                f4 = this.H == null ? 0.0f : textPaint0.measureText(this.H, 0, this.H.length());
            }
            else {
                f4 = (float)staticLayout1.getWidth();
            }
            this.p = this.i0 == null ? 0 : this.i0.getLineCount();
            int v1 = Gravity.getAbsoluteGravity(this.j, ((int)this.I));
            Rect rect1 = this.g;
            switch(v1 & 0x70) {
                case 0x30: {
                    this.q = (float)rect1.top;
                    break;
                }
                case 80: {
                    float f5 = ((float)rect1.bottom) - f3;
                    this.q = textPaint0.descent() + f5;
                    break;
                }
                default: {
                    this.q = ((float)rect1.centerY()) - f3 / 2.0f;
                }
            }
            switch(v1 & 0x800007) {
                case 1: {
                    this.s = ((float)rect1.centerX()) - f4 / 2.0f;
                    break;
                }
                case 5: {
                    this.s = ((float)rect1.right) - f4;
                    break;
                }
                default: {
                    this.s = (float)rect1.left;
                }
            }
            Bitmap bitmap0 = this.K;
            if(bitmap0 != null) {
                bitmap0.recycle();
                this.K = null;
            }
            this.q(this.b);
            float f6 = this.b;
            RectF rectF0 = this.i;
            if(this.c) {
                if(f6 < this.e) {
                    rect0 = rect1;
                }
                rectF0.set(rect0);
            }
            else {
                rectF0.left = c.g(rect1.left, rect0.left, f6, this.V);
                rectF0.top = c.g(this.q, this.r, f6, this.V);
                rectF0.right = c.g(rect1.right, rect0.right, f6, this.V);
                rectF0.bottom = c.g(rect1.bottom, rect0.bottom, f6, this.V);
            }
            if(!this.c) {
                this.u = c.g(this.s, this.t, f6, this.V);
                this.v = c.g(this.q, this.r, f6, this.V);
                this.q(f6);
                f7 = f6;
            }
            else if(f6 < this.e) {
                this.u = this.s;
                this.v = this.q;
                this.q(0.0f);
                f7 = 0.0f;
            }
            else {
                this.u = this.t;
                this.v = this.r - ((float)Math.max(0, this.f));
                this.q(1.0f);
                f7 = 1.0f;
            }
            P2.a a0 = e6.a.b;
            this.k0 = 1.0f - c.g(0.0f, 1.0f, 1.0f - f6, a0);
            viewGroup0.postInvalidateOnAnimation();
            this.l0 = c.g(1.0f, 0.0f, f6, a0);
            viewGroup0.postInvalidateOnAnimation();
            ColorStateList colorStateList0 = this.o;
            ColorStateList colorStateList1 = this.n;
            if(colorStateList0 == colorStateList1) {
                textPaint0.setColor(this.f(colorStateList0));
            }
            else {
                textPaint0.setColor(c.a(f7, this.f(colorStateList1), this.f(this.o)));
            }
            int v2 = Build.VERSION.SDK_INT;
            float f8 = this.f0;
            float f9 = this.g0;
            if(f8 == f9) {
                textPaint0.setLetterSpacing(f8);
            }
            else {
                textPaint0.setLetterSpacing(c.g(f9, f8, f6, a0));
            }
            this.N = e6.a.a(this.b0, this.X, f6);
            this.O = e6.a.a(this.c0, this.Y, f6);
            this.P = e6.a.a(this.d0, this.Z, f6);
            int v3 = c.a(f6, this.f(this.e0), this.f(this.a0));
            this.Q = v3;
            textPaint0.setShadowLayer(this.N, this.O, this.P, v3);
            if(this.c) {
                int v4 = textPaint0.getAlpha();
                textPaint0.setAlpha(((int)((f6 <= this.e ? e6.a.b(1.0f, 0.0f, this.d, this.e, f6) : e6.a.b(0.0f, 1.0f, this.e, 1.0f, f6)) * ((float)v4))));
                if(v2 >= 0x1F) {
                    textPaint0.setShadowLayer(this.N, this.O, this.P, n.l(this.Q, textPaint0.getAlpha()));
                }
            }
            viewGroup0.postInvalidateOnAnimation();
        }
    }

    public final void j(ColorStateList colorStateList0) {
        if(this.o == colorStateList0 && this.n == colorStateList0) {
            return;
        }
        this.o = colorStateList0;
        this.n = colorStateList0;
        this.i(false);
    }

    public final void k(int v) {
        ViewGroup viewGroup0 = this.a;
        d d0 = new d(viewGroup0.getContext(), v);
        ColorStateList colorStateList0 = d0.j;
        if(colorStateList0 != null) {
            this.o = colorStateList0;
        }
        float f = d0.k;
        if(f != 0.0f) {
            this.m = f;
        }
        ColorStateList colorStateList1 = d0.a;
        if(colorStateList1 != null) {
            this.a0 = colorStateList1;
        }
        this.Y = d0.e;
        this.Z = d0.f;
        this.X = d0.g;
        this.f0 = d0.i;
        a a0 = this.E;
        if(a0 != null) {
            a0.g = true;
        }
        com.google.android.material.internal.b b0 = new com.google.android.material.internal.b(this, 0);
        d0.a();
        this.E = new a(b0, d0.n);
        d0.c(viewGroup0.getContext(), this.E);
        this.i(false);
    }

    public final void l(int v) {
        if(this.k != v) {
            this.k = v;
            this.i(false);
        }
    }

    public final boolean m(Typeface typeface0) {
        a a0 = this.E;
        if(a0 != null) {
            a0.g = true;
        }
        if(this.y != typeface0) {
            this.y = typeface0;
            Typeface typeface1 = x.K(this.a.getContext().getResources().getConfiguration(), typeface0);
            this.x = typeface1;
            if(typeface1 == null) {
                typeface1 = this.y;
            }
            this.w = typeface1;
            return true;
        }
        return false;
    }

    public final void n(int v) {
        ViewGroup viewGroup0 = this.a;
        d d0 = new d(viewGroup0.getContext(), v);
        ColorStateList colorStateList0 = d0.j;
        if(colorStateList0 != null) {
            this.n = colorStateList0;
        }
        float f = d0.k;
        if(f != 0.0f) {
            this.l = f;
        }
        ColorStateList colorStateList1 = d0.a;
        if(colorStateList1 != null) {
            this.e0 = colorStateList1;
        }
        this.c0 = d0.e;
        this.d0 = d0.f;
        this.b0 = d0.g;
        this.g0 = d0.i;
        a a0 = this.D;
        if(a0 != null) {
            a0.g = true;
        }
        com.google.android.material.internal.b b0 = new com.google.android.material.internal.b(this, 1);
        d0.a();
        this.D = new a(b0, d0.n);
        d0.c(viewGroup0.getContext(), this.D);
        this.i(false);
    }

    public final boolean o(Typeface typeface0) {
        a a0 = this.D;
        if(a0 != null) {
            a0.g = true;
        }
        if(this.B != typeface0) {
            this.B = typeface0;
            Typeface typeface1 = x.K(this.a.getContext().getResources().getConfiguration(), typeface0);
            this.A = typeface1;
            if(typeface1 == null) {
                typeface1 = this.B;
            }
            this.z = typeface1;
            return true;
        }
        return false;
    }

    public final void p(float f) {
        float f2;
        float f1 = h.q(f, 0.0f, 1.0f);
        if(f1 != this.b) {
            this.b = f1;
            Rect rect0 = this.h;
            Rect rect1 = this.g;
            RectF rectF0 = this.i;
            if(this.c) {
                if(f1 < this.e) {
                    rect0 = rect1;
                }
                rectF0.set(rect0);
            }
            else {
                rectF0.left = c.g(rect1.left, rect0.left, f1, this.V);
                rectF0.top = c.g(this.q, this.r, f1, this.V);
                rectF0.right = c.g(rect1.right, rect0.right, f1, this.V);
                rectF0.bottom = c.g(rect1.bottom, rect0.bottom, f1, this.V);
            }
            if(!this.c) {
                this.u = c.g(this.s, this.t, f1, this.V);
                this.v = c.g(this.q, this.r, f1, this.V);
                this.q(f1);
                f2 = f1;
            }
            else if(f1 < this.e) {
                this.u = this.s;
                this.v = this.q;
                this.q(0.0f);
                f2 = 0.0f;
            }
            else {
                this.u = this.t;
                this.v = this.r - ((float)Math.max(0, this.f));
                this.q(1.0f);
                f2 = 1.0f;
            }
            P2.a a0 = e6.a.b;
            this.k0 = 1.0f - c.g(0.0f, 1.0f, 1.0f - f1, a0);
            ViewGroup viewGroup0 = this.a;
            viewGroup0.postInvalidateOnAnimation();
            this.l0 = c.g(1.0f, 0.0f, f1, a0);
            viewGroup0.postInvalidateOnAnimation();
            ColorStateList colorStateList0 = this.o;
            ColorStateList colorStateList1 = this.n;
            TextPaint textPaint0 = this.T;
            if(colorStateList0 == colorStateList1) {
                textPaint0.setColor(this.f(colorStateList0));
            }
            else {
                textPaint0.setColor(c.a(f2, this.f(colorStateList1), this.f(this.o)));
            }
            int v = Build.VERSION.SDK_INT;
            float f3 = this.f0;
            float f4 = this.g0;
            if(f3 == f4) {
                textPaint0.setLetterSpacing(f3);
            }
            else {
                textPaint0.setLetterSpacing(c.g(f4, f3, f1, a0));
            }
            this.N = e6.a.a(this.b0, this.X, f1);
            this.O = e6.a.a(this.c0, this.Y, f1);
            this.P = e6.a.a(this.d0, this.Z, f1);
            int v1 = c.a(f1, this.f(this.e0), this.f(this.a0));
            this.Q = v1;
            textPaint0.setShadowLayer(this.N, this.O, this.P, v1);
            if(this.c) {
                int v2 = textPaint0.getAlpha();
                textPaint0.setAlpha(((int)((f1 <= this.e ? e6.a.b(1.0f, 0.0f, this.d, this.e, f1) : e6.a.b(0.0f, 1.0f, this.e, 1.0f, f1)) * ((float)v2))));
                if(v >= 0x1F) {
                    textPaint0.setShadowLayer(this.N, this.O, this.P, n.l(this.Q, textPaint0.getAlpha()));
                }
            }
            viewGroup0.postInvalidateOnAnimation();
        }
    }

    public final void q(float f) {
        this.c(f, false);
        this.a.postInvalidateOnAnimation();
    }
}

