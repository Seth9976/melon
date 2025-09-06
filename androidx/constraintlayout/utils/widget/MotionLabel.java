package androidx.constraintlayout.utils.widget;

import J1.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.b;
import androidx.constraintlayout.widget.q;
import java.util.Objects;

public class MotionLabel extends View implements b {
    public int B;
    public int D;
    public int E;
    public int G;
    public String I;
    public int M;
    public int N;
    public boolean S;
    public float T;
    public float V;
    public float W;
    public final TextPaint a;
    public Path b;
    public Drawable b0;
    public int c;
    public Matrix c0;
    public int d;
    public Bitmap d0;
    public boolean e;
    public BitmapShader e0;
    public float f;
    public Matrix f0;
    public float g;
    public float g0;
    public ViewOutlineProvider h;
    public float h0;
    public RectF i;
    public float i0;
    public float j;
    public float j0;
    public float k;
    public final Paint k0;
    public int l;
    public int l0;
    public int m;
    public Rect m0;
    public float n;
    public Paint n0;
    public String o;
    public float o0;
    public float p0;
    public float q0;
    public boolean r;
    public float r0;
    public float s0;
    public final Rect w;

    public MotionLabel(Context context0) {
        super(context0);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 0xFFFF;
        this.d = 0xFFFF;
        this.e = false;
        this.f = 0.0f;
        this.g = NaNf;
        this.j = 48.0f;
        this.k = NaNf;
        this.n = 0.0f;
        this.o = "Hello World";
        this.r = true;
        this.w = new Rect();
        this.B = 1;
        this.D = 1;
        this.E = 1;
        this.G = 1;
        this.M = 0x800033;
        this.N = 0;
        this.S = false;
        this.g0 = NaNf;
        this.h0 = NaNf;
        this.i0 = 0.0f;
        this.j0 = 0.0f;
        this.k0 = new Paint();
        this.l0 = 0;
        this.p0 = NaNf;
        this.q0 = NaNf;
        this.r0 = NaNf;
        this.s0 = NaNf;
        this.b(context0, null);
    }

    public MotionLabel(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 0xFFFF;
        this.d = 0xFFFF;
        this.e = false;
        this.f = 0.0f;
        this.g = NaNf;
        this.j = 48.0f;
        this.k = NaNf;
        this.n = 0.0f;
        this.o = "Hello World";
        this.r = true;
        this.w = new Rect();
        this.B = 1;
        this.D = 1;
        this.E = 1;
        this.G = 1;
        this.M = 0x800033;
        this.N = 0;
        this.S = false;
        this.g0 = NaNf;
        this.h0 = NaNf;
        this.i0 = 0.0f;
        this.j0 = 0.0f;
        this.k0 = new Paint();
        this.l0 = 0;
        this.p0 = NaNf;
        this.q0 = NaNf;
        this.r0 = NaNf;
        this.s0 = NaNf;
        this.b(context0, attributeSet0);
    }

    public MotionLabel(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new TextPaint();
        this.b = new Path();
        this.c = 0xFFFF;
        this.d = 0xFFFF;
        this.e = false;
        this.f = 0.0f;
        this.g = NaNf;
        this.j = 48.0f;
        this.k = NaNf;
        this.n = 0.0f;
        this.o = "Hello World";
        this.r = true;
        this.w = new Rect();
        this.B = 1;
        this.D = 1;
        this.E = 1;
        this.G = 1;
        this.M = 0x800033;
        this.N = 0;
        this.S = false;
        this.g0 = NaNf;
        this.h0 = NaNf;
        this.i0 = 0.0f;
        this.j0 = 0.0f;
        this.k0 = new Paint();
        this.l0 = 0;
        this.p0 = NaNf;
        this.q0 = NaNf;
        this.r0 = NaNf;
        this.s0 = NaNf;
        this.b(context0, attributeSet0);
    }

    public final void a(float f) {
        if(!this.e && f == 1.0f) {
            return;
        }
        this.b.reset();
        String s = this.o;
        int v = s.length();
        Rect rect0 = this.w;
        this.a.getTextBounds(s, 0, v, rect0);
        this.a.getTextPath(s, 0, v, 0.0f, 0.0f, this.b);
        if(f != 1.0f) {
            Log.v("MotionLabel", ".(null:-1) a() scale " + f);
            Matrix matrix0 = new Matrix();
            matrix0.postScale(f, f);
            this.b.transform(matrix0);
        }
        --rect0.right;
        ++rect0.left;
        ++rect0.bottom;
        --rect0.top;
        RectF rectF0 = new RectF();
        rectF0.bottom = (float)this.getHeight();
        rectF0.right = (float)this.getWidth();
        this.r = false;
    }

    public final void b(Context context0, AttributeSet attributeSet0) {
        Typeface typeface0;
        this.setUpTheme(context0);
        boolean z = false;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.u);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 5) {
                    this.setText(typedArray0.getText(5));
                }
                else if(v2 == 7) {
                    this.I = typedArray0.getString(7);
                }
                else {
                    switch(v2) {
                        case 0: {
                            this.j = (float)typedArray0.getDimensionPixelSize(0, ((int)this.j));
                            break;
                        }
                        case 1: {
                            this.m = typedArray0.getInt(1, this.m);
                            break;
                        }
                        case 2: {
                            this.l = typedArray0.getInt(2, this.l);
                            break;
                        }
                        case 3: {
                            this.c = typedArray0.getColor(3, this.c);
                            break;
                        }
                        case 4: {
                            this.setGravity(typedArray0.getInt(4, -1));
                            break;
                        }
                        case 8: {
                            this.N = typedArray0.getInt(8, 0);
                            break;
                        }
                        case 9: {
                            float f = typedArray0.getDimension(9, this.g);
                            this.g = f;
                            this.setRound(f);
                            break;
                        }
                        case 10: {
                            float f1 = typedArray0.getFloat(10, this.f);
                            this.f = f1;
                            this.setRoundPercent(f1);
                            break;
                        }
                        case 11: {
                            this.k = (float)typedArray0.getDimensionPixelSize(11, ((int)this.k));
                            break;
                        }
                        case 12: {
                            this.b0 = typedArray0.getDrawable(12);
                            this.e = true;
                            break;
                        }
                        case 13: {
                            this.p0 = typedArray0.getFloat(13, this.p0);
                            break;
                        }
                        case 14: {
                            this.q0 = typedArray0.getFloat(14, this.q0);
                            break;
                        }
                        case 15: {
                            this.s0 = typedArray0.getFloat(15, this.s0);
                            break;
                        }
                        case 16: {
                            this.r0 = typedArray0.getFloat(16, this.r0);
                            break;
                        }
                        case 17: {
                            this.d = typedArray0.getInt(17, this.d);
                            this.e = true;
                            break;
                        }
                        case 18: {
                            this.n = typedArray0.getDimension(18, this.n);
                            this.e = true;
                            break;
                        }
                        case 19: {
                            this.i0 = typedArray0.getFloat(19, this.i0);
                            break;
                        }
                        case 20: {
                            this.j0 = typedArray0.getFloat(20, this.j0);
                            break;
                        }
                        case 22: {
                            this.l0 = typedArray0.getInt(22, this.l0);
                            break;
                        }
                        case 23: {
                            this.g0 = typedArray0.getDimension(23, this.g0);
                            break;
                        }
                        case 24: {
                            this.h0 = typedArray0.getDimension(24, this.h0);
                        }
                    }
                }
            }
            typedArray0.recycle();
        }
        if(this.b0 != null) {
            this.f0 = new Matrix();
            int v3 = this.b0.getIntrinsicWidth();
            int v4 = this.b0.getIntrinsicHeight();
            if(v3 <= 0) {
                v3 = this.getWidth();
                if(v3 == 0) {
                    v3 = Float.isNaN(this.h0) ? 0x80 : ((int)this.h0);
                }
            }
            if(v4 <= 0) {
                v4 = this.getHeight();
                if(v4 == 0) {
                    v4 = Float.isNaN(this.g0) ? 0x80 : ((int)this.g0);
                }
            }
            if(this.l0 != 0) {
                v3 /= 2;
                v4 /= 2;
            }
            this.d0 = Bitmap.createBitmap(v3, v4, Bitmap.Config.ARGB_8888);
            Canvas canvas0 = new Canvas(this.d0);
            this.b0.setBounds(0, 0, canvas0.getWidth(), canvas0.getHeight());
            this.b0.setFilterBitmap(true);
            this.b0.draw(canvas0);
            if(this.l0 != 0) {
                Bitmap bitmap0 = this.d0;
                int v5 = bitmap0.getWidth() / 2;
                int v6 = bitmap0.getHeight() / 2;
                Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v5, v6, true);
                for(int v7 = 0; v7 < 4 && v5 >= 0x20 && v6 >= 0x20; ++v7) {
                    v5 /= 2;
                    v6 /= 2;
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, v5, v6, true);
                }
                this.d0 = bitmap1;
            }
            this.e0 = new BitmapShader(this.d0, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
        this.B = this.getPaddingLeft();
        this.D = this.getPaddingRight();
        this.E = this.getPaddingTop();
        this.G = this.getPaddingBottom();
        String s = this.I;
        int v8 = this.m;
        int v9 = this.l;
        TextPaint textPaint0 = this.a;
        if(s == null) {
            typeface0 = null;
        label_115:
            switch(v8) {
                case 1: {
                    typeface0 = Typeface.SANS_SERIF;
                    break;
                }
                case 2: {
                    typeface0 = Typeface.SERIF;
                    break;
                }
                case 3: {
                    typeface0 = Typeface.MONOSPACE;
                }
            }
            float f2 = 0.0f;
            if(v9 > 0) {
                Typeface typeface1 = typeface0 == null ? Typeface.defaultFromStyle(v9) : Typeface.create(typeface0, v9);
                this.setTypeface(typeface1);
                int v10 = ~(typeface1 == null ? 0 : typeface1.getStyle()) & v9;
                if((v10 & 1) != 0) {
                    z = true;
                }
                textPaint0.setFakeBoldText(z);
                if((v10 & 2) != 0) {
                    f2 = -0.25f;
                }
                textPaint0.setTextSkewX(f2);
            }
            else {
                textPaint0.setFakeBoldText(false);
                textPaint0.setTextSkewX(0.0f);
                this.setTypeface(typeface0);
            }
        }
        else {
            typeface0 = Typeface.create(s, v9);
            if(typeface0 == null) {
                goto label_115;
            }
            else {
                this.setTypeface(typeface0);
            }
        }
        textPaint0.setColor(this.c);
        textPaint0.setStrokeWidth(this.n);
        textPaint0.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint0.setFlags(0x80);
        this.setTextSize(this.j);
        textPaint0.setAntiAlias(true);
    }

    public final void c(float f, float f1, float f2, float f3) {
        this.T = f - ((float)(((int)(f + 0.5f))));
        int v = ((int)(f2 + 0.5f)) - ((int)(f + 0.5f));
        int v1 = ((int)(f3 + 0.5f)) - ((int)(f1 + 0.5f));
        float f4 = f2 - f;
        this.V = f4;
        float f5 = f3 - f1;
        this.W = f5;
        if(this.f0 != null) {
            this.V = f4;
            this.W = f5;
            this.d();
        }
        if(this.getMeasuredHeight() != v1 || this.getMeasuredWidth() != v) {
            this.measure(View.MeasureSpec.makeMeasureSpec(v, 0x40000000), View.MeasureSpec.makeMeasureSpec(v1, 0x40000000));
        }
        super.layout(((int)(f + 0.5f)), ((int)(f1 + 0.5f)), ((int)(f2 + 0.5f)), ((int)(f3 + 0.5f)));
        if(this.S) {
            TextPaint textPaint0 = this.a;
            if(this.m0 == null) {
                this.n0 = new Paint();
                this.m0 = new Rect();
                this.n0.set(textPaint0);
                this.o0 = this.n0.getTextSize();
            }
            this.V = f4;
            this.W = f5;
            this.n0.getTextBounds(this.o, 0, this.o.length(), this.m0);
            int v2 = this.m0.width();
            float f6 = ((float)this.m0.height()) * 1.3f;
            float f7 = f4 - ((float)this.D) - ((float)this.B);
            float f8 = f5 - ((float)this.G) - ((float)this.E);
            if(((float)v2) * f8 > f6 * f7) {
                textPaint0.setTextSize(this.o0 * f7 / ((float)v2));
            }
            else {
                textPaint0.setTextSize(this.o0 * f8 / f6);
            }
            if(this.e || !Float.isNaN(this.k)) {
                this.a((Float.isNaN(this.k) ? 1.0f : this.j / this.k));
            }
        }
    }

    public final void d() {
        float f = 0.0f;
        float f1 = Float.isNaN(this.p0) ? 0.0f : this.p0;
        float f2 = Float.isNaN(this.q0) ? 0.0f : this.q0;
        float f3 = Float.isNaN(this.r0) ? 1.0f : this.r0;
        if(!Float.isNaN(this.s0)) {
            f = this.s0;
        }
        this.f0.reset();
        float f4 = (float)this.d0.getWidth();
        float f5 = (float)this.d0.getHeight();
        float f6 = Float.isNaN(this.h0) ? this.V : this.h0;
        float f7 = Float.isNaN(this.g0) ? this.W : this.g0;
        float f8 = f3 * (f4 * f7 < f5 * f6 ? f6 / f4 : f7 / f5);
        this.f0.postScale(f8, f8);
        float f9 = f4 * f8;
        float f10 = f6 - f9;
        float f11 = f8 * f5;
        float f12 = Float.isNaN(this.g0) ? f7 - f11 : this.g0 / 2.0f;
        if(!Float.isNaN(this.h0)) {
            f10 = this.h0 / 2.0f;
        }
        this.f0.postTranslate((f1 * f10 + f6 - f9) * 0.5f, (f2 * f12 + f7 - f11) * 0.5f);
        this.f0.postRotate(f, f6 / 2.0f, f7 / 2.0f);
        this.e0.setLocalMatrix(this.f0);
    }

    private float getHorizontalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        float f1 = this.a.measureText(this.o, 0, this.o.length());
        float f2 = (Float.isNaN(this.V) ? ((float)this.getMeasuredWidth()) : this.V) - ((float)this.getPaddingLeft()) - ((float)this.getPaddingRight()) - f1 * f;
        return (this.i0 + 1.0f) * f2 / 2.0f;
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getScaleFromTextSize() {
        return this.k;
    }

    public float getTextBackgroundPanX() {
        return this.p0;
    }

    public float getTextBackgroundPanY() {
        return this.q0;
    }

    public float getTextBackgroundRotate() {
        return this.s0;
    }

    public float getTextBackgroundZoom() {
        return this.r0;
    }

    public int getTextOutlineColor() {
        return this.d;
    }

    public float getTextPanX() {
        return this.i0;
    }

    public float getTextPanY() {
        return this.j0;
    }

    public float getTextureHeight() {
        return this.g0;
    }

    public float getTextureWidth() {
        return this.h0;
    }

    public Typeface getTypeface() {
        return this.a.getTypeface();
    }

    private float getVerticalOffset() {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        Paint.FontMetrics paint$FontMetrics0 = this.a.getFontMetrics();
        float f1 = (Float.isNaN(this.W) ? ((float)this.getMeasuredHeight()) : this.W) - ((float)this.getPaddingTop()) - ((float)this.getPaddingBottom());
        return (1.0f - this.j0) * (f1 - (paint$FontMetrics0.descent - paint$FontMetrics0.ascent) * f) / 2.0f - f * paint$FontMetrics0.ascent;
    }

    @Override  // android.view.View
    public final void layout(int v, int v1, int v2, int v3) {
        super.layout(v, v1, v2, v3);
        boolean z = Float.isNaN(this.k);
        float f = z ? 1.0f : this.j / this.k;
        this.V = (float)(v2 - v);
        this.W = (float)(v3 - v1);
        if(this.S) {
            TextPaint textPaint0 = this.a;
            if(this.m0 == null) {
                this.n0 = new Paint();
                this.m0 = new Rect();
                this.n0.set(textPaint0);
                this.o0 = this.n0.getTextSize();
            }
            this.n0.getTextBounds(this.o, 0, this.o.length(), this.m0);
            int v4 = this.m0.width();
            int v5 = (int)(((float)this.m0.height()) * 1.3f);
            float f1 = this.V - ((float)this.D) - ((float)this.B);
            float f2 = this.W - ((float)this.G) - ((float)this.E);
            if(!z) {
                f = ((float)v4) * f2 > ((float)v5) * f1 ? f1 / ((float)v4) : f2 / ((float)v5);
            }
            else if(((float)v4) * f2 > ((float)v5) * f1) {
                textPaint0.setTextSize(this.o0 * f1 / ((float)v4));
            }
            else {
                textPaint0.setTextSize(this.o0 * f2 / ((float)v5));
            }
        }
        if(!this.e && z) {
            return;
        }
        if(this.f0 != null) {
            this.V = ((float)v2) - ((float)v);
            this.W = ((float)v3) - ((float)v1);
            this.d();
        }
        this.a(f);
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        float f = Float.isNaN(this.k) ? 1.0f : this.j / this.k;
        super.onDraw(canvas0);
        TextPaint textPaint0 = this.a;
        if(!this.e && f == 1.0f) {
            float f1 = (float)this.B;
            float f2 = this.getHorizontalOffset();
            float f3 = (float)this.E;
            float f4 = this.getVerticalOffset();
            canvas0.drawText(this.o, this.T + (f1 + f2), f3 + f4, textPaint0);
            return;
        }
        if(this.r) {
            this.a(f);
        }
        if(this.c0 == null) {
            this.c0 = new Matrix();
        }
        if(this.e) {
            Paint paint0 = this.k0;
            paint0.set(textPaint0);
            this.c0.reset();
            float f5 = ((float)this.B) + this.getHorizontalOffset();
            float f6 = ((float)this.E) + this.getVerticalOffset();
            this.c0.postTranslate(f5, f6);
            this.c0.preScale(f, f);
            this.b.transform(this.c0);
            if(this.e0 == null) {
                textPaint0.setColor(this.c);
            }
            else {
                textPaint0.setFilterBitmap(true);
                textPaint0.setShader(this.e0);
            }
            textPaint0.setStyle(Paint.Style.FILL);
            textPaint0.setStrokeWidth(this.n);
            canvas0.drawPath(this.b, textPaint0);
            if(this.e0 != null) {
                textPaint0.setShader(null);
            }
            textPaint0.setColor(this.d);
            textPaint0.setStyle(Paint.Style.STROKE);
            textPaint0.setStrokeWidth(this.n);
            canvas0.drawPath(this.b, textPaint0);
            this.c0.reset();
            this.c0.postTranslate(-f5, -f6);
            this.b.transform(this.c0);
            textPaint0.set(paint0);
            return;
        }
        float f7 = ((float)this.B) + this.getHorizontalOffset();
        float f8 = ((float)this.E) + this.getVerticalOffset();
        this.c0.reset();
        this.c0.preTranslate(f7, f8);
        this.b.transform(this.c0);
        textPaint0.setColor(this.c);
        textPaint0.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint0.setStrokeWidth(this.n);
        canvas0.drawPath(this.b, textPaint0);
        this.c0.reset();
        this.c0.preTranslate(-f7, -f8);
        this.b.transform(this.c0);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getMode(v1);
        int v4 = View.MeasureSpec.getSize(v);
        int v5 = View.MeasureSpec.getSize(v1);
        this.S = false;
        this.B = this.getPaddingLeft();
        this.D = this.getPaddingRight();
        this.E = this.getPaddingTop();
        this.G = this.getPaddingBottom();
        if(v2 != 0x40000000 || v3 != 0x40000000) {
            TextPaint textPaint0 = this.a;
            Rect rect0 = this.w;
            textPaint0.getTextBounds(this.o, 0, this.o.length(), rect0);
            if(v2 != 0x40000000) {
                v4 = (int)(((float)rect0.width()) + 0.99999f);
            }
            v4 += this.B + this.D;
            if(v3 != 0x40000000) {
                int v6 = (int)(((float)textPaint0.getFontMetricsInt(null)) + 0.99999f);
                if(v3 == 0x80000000) {
                    v6 = Math.min(v5, v6);
                }
                v5 = this.E + this.G + v6;
            }
        }
        else if(this.N != 0) {
            this.S = true;
        }
        this.setMeasuredDimension(v4, v5);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int v) {
        if((v & 0x800007) == 0) {
            v |= 0x800003;
        }
        if((v & 0x70) == 0) {
            v |= 0x30;
        }
        if(v != this.M) {
            this.invalidate();
        }
        this.M = v;
        switch(v & 0x70) {
            case 0x30: {
                this.j0 = -1.0f;
                break;
            }
            case 80: {
                this.j0 = 1.0f;
                break;
            }
            default: {
                this.j0 = 0.0f;
            }
        }
        if((v & 0x800007) != 3) {
            switch(v & 0x800007) {
                case 5: {
                    this.i0 = 1.0f;
                    return;
                }
                case 0x800003: {
                    break;
                }
                default: {
                    if((v & 0x800007) != 0x800005) {
                        this.i0 = 0.0f;
                        return;
                    }
                    this.i0 = 1.0f;
                    return;
                }
            }
        }
        this.i0 = -1.0f;
    }

    public void setRound(float f) {
        if(Float.isNaN(f)) {
            this.g = f;
            float f1 = this.f;
            this.f = -1.0f;
            this.setRoundPercent(f1);
            return;
        }
        boolean z = Float.compare(this.g, f) != 0;
        this.g = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.b == null) {
                this.b = new Path();
            }
            if(this.i == null) {
                this.i = new RectF();
            }
            if(this.h == null) {
                e e0 = new e(this, 1);
                this.h = e0;
                this.setOutlineProvider(e0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            this.i.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.b.reset();
            this.b.addRoundRect(this.i, this.g, this.g, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = Float.compare(this.f, f) != 0;
        this.f = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.b == null) {
                this.b = new Path();
            }
            if(this.i == null) {
                this.i = new RectF();
            }
            if(this.h == null) {
                e e0 = new e(this, 0);
                this.h = e0;
                this.setOutlineProvider(e0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            float f1 = ((float)Math.min(v, v1)) * this.f / 2.0f;
            this.i.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.b.reset();
            this.b.addRoundRect(this.i, f1, f1, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f) {
        this.k = f;
    }

    public void setText(CharSequence charSequence0) {
        this.o = charSequence0.toString();
        this.invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.p0 = f;
        this.d();
        this.invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.q0 = f;
        this.d();
        this.invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.s0 = f;
        this.d();
        this.invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.r0 = f;
        this.d();
        this.invalidate();
    }

    public void setTextFillColor(int v) {
        this.c = v;
        this.invalidate();
    }

    public void setTextOutlineColor(int v) {
        this.d = v;
        this.e = true;
        this.invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.n = f;
        this.e = true;
        if(Float.isNaN(f)) {
            this.n = 1.0f;
            this.e = false;
        }
        this.invalidate();
    }

    public void setTextPanX(float f) {
        this.i0 = f;
        this.invalidate();
    }

    public void setTextPanY(float f) {
        this.j0 = f;
        this.invalidate();
    }

    public void setTextSize(float f) {
        this.j = f;
        if(!Float.isNaN(this.k)) {
            f = this.k;
        }
        this.a.setTextSize(f);
        this.a((Float.isNaN(this.k) ? 1.0f : this.j / this.k));
        this.requestLayout();
        this.invalidate();
    }

    public void setTextureHeight(float f) {
        this.g0 = f;
        this.d();
        this.invalidate();
    }

    public void setTextureWidth(float f) {
        this.h0 = f;
        this.d();
        this.invalidate();
    }

    public void setTypeface(Typeface typeface0) {
        TextPaint textPaint0 = this.a;
        if(!Objects.equals(textPaint0.getTypeface(), typeface0)) {
            textPaint0.setTypeface(typeface0);
        }
    }

    private void setUpTheme(Context context0) {
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x7F040182, typedValue0, true);  // attr:colorPrimary
        this.c = typedValue0.data;
        this.a.setColor(typedValue0.data);
    }
}

