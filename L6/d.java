package l6;

import E9.w;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.B;
import com.google.android.material.internal.x;
import com.google.android.material.internal.y;
import e6.f;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import x6.a;
import z6.i;
import z6.m;

public final class d extends i implements Drawable.Callback, x {
    public float A0;
    public final Context B0;
    public final Paint C0;
    public final Paint.FontMetrics D0;
    public final RectF E0;
    public final PointF F0;
    public final Path G0;
    public final y H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public boolean O0;
    public int P0;
    public int Q0;
    public ColorFilter R0;
    public ColorStateList S;
    public PorterDuffColorFilter S0;
    public ColorStateList T;
    public ColorStateList T0;
    public PorterDuff.Mode U0;
    public float V;
    public int[] V0;
    public float W;
    public ColorStateList W0;
    public ColorStateList X;
    public WeakReference X0;
    public float Y;
    public TextUtils.TruncateAt Y0;
    public ColorStateList Z;
    public boolean Z0;
    public int a1;
    public CharSequence b0;
    public boolean b1;
    public boolean c0;
    public static final int[] c1;
    public Drawable d0;
    public static final ShapeDrawable d1;
    public ColorStateList e0;
    public float f0;
    public boolean g0;
    public boolean h0;
    public Drawable i0;
    public RippleDrawable j0;
    public ColorStateList k0;
    public float l0;
    public SpannableStringBuilder m0;
    public boolean n0;
    public boolean o0;
    public Drawable p0;
    public ColorStateList q0;
    public f r0;
    public f s0;
    public float t0;
    public float u0;
    public float v0;
    public float w0;
    public float x0;
    public float y0;
    public float z0;

    static {
        d.c1 = new int[]{0x101009E};
        d.d1 = new ShapeDrawable(new OvalShape());
    }

    public d(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F140497);  // style:Widget.MaterialComponents.Chip.Action
        this.W = -1.0f;
        this.C0 = new Paint(1);
        this.D0 = new Paint.FontMetrics();
        this.E0 = new RectF();
        this.F0 = new PointF();
        this.G0 = new Path();
        this.Q0 = 0xFF;
        this.U0 = PorterDuff.Mode.SRC_IN;
        this.X0 = new WeakReference(null);
        this.k(context0);
        this.B0 = context0;
        y y0 = new y(this);
        this.H0 = y0;
        this.b0 = "";
        y0.a.density = context0.getResources().getDisplayMetrics().density;
        int[] arr_v = d.c1;
        this.setState(arr_v);
        if(!Arrays.equals(this.V0, arr_v)) {
            this.V0 = arr_v;
            if(this.b0()) {
                this.E(this.getState(), arr_v);
            }
        }
        this.Z0 = true;
        d.d1.setTint(-1);
    }

    // 去混淆评级： 低(20)
    public final float A() {
        return this.b1 ? this.i() : this.W;
    }

    public static boolean B(ColorStateList colorStateList0) {
        return colorStateList0 != null && colorStateList0.isStateful();
    }

    public static boolean C(Drawable drawable0) {
        return drawable0 != null && drawable0.isStateful();
    }

    public final void D() {
        c c0 = (c)this.X0.get();
        if(c0 != null) {
            ((Chip)c0).c(((Chip)c0).w);
            ((Chip)c0).requestLayout();
            ((Chip)c0).invalidateOutline();
        }
    }

    public final boolean E(int[] arr_v, int[] arr_v1) {
        boolean z3;
        int v5;
        boolean z = super.onStateChange(arr_v);
        int v = this.c((this.S == null ? 0 : this.S.getColorForState(arr_v, this.I0)));
        boolean z1 = true;
        if(this.I0 != v) {
            this.I0 = v;
            z = true;
        }
        int v1 = this.c((this.T == null ? 0 : this.T.getColorForState(arr_v, this.J0)));
        if(this.J0 != v1) {
            this.J0 = v1;
            z = true;
        }
        int v2 = S1.c.h(v1, v);
        if(((this.K0 == v2 ? 0 : 1) | (this.a.c == null ? 1 : 0)) != 0) {
            this.K0 = v2;
            this.m(ColorStateList.valueOf(v2));
            z = true;
        }
        int v3 = this.X == null ? 0 : this.X.getColorForState(arr_v, this.L0);
        if(this.L0 != v3) {
            this.L0 = v3;
            z = true;
        }
        int v4 = this.W0 == null || !a.d(arr_v) ? 0 : this.W0.getColorForState(arr_v, this.M0);
        if(this.M0 != v4) {
            this.M0 = v4;
        }
        w6.d d0 = this.H0.g;
        if(d0 == null) {
            v5 = 0;
        }
        else {
            ColorStateList colorStateList0 = d0.j;
            v5 = colorStateList0 == null ? 0 : colorStateList0.getColorForState(arr_v, this.N0);
        }
        if(this.N0 != v5) {
            this.N0 = v5;
            z = true;
        }
        boolean z2 = false;
        int[] arr_v2 = this.getState();
        if(arr_v2 != null) {
            for(int v6 = 0; v6 < arr_v2.length; ++v6) {
                if(arr_v2[v6] == 0x10100A0) {
                    if(!this.n0) {
                        break;
                    }
                    z2 = true;
                    break;
                }
            }
        }
        if(this.O0 == z2 || this.p0 == null) {
            z3 = false;
        }
        else {
            float f = this.y();
            this.O0 = z2;
            if(f == this.y()) {
                z3 = false;
                z = true;
            }
            else {
                z = true;
                z3 = true;
            }
        }
        int v7 = this.T0 == null ? 0 : this.T0.getColorForState(arr_v, this.P0);
        if(this.P0 == v7) {
            z1 = z;
        }
        else {
            this.P0 = v7;
            PorterDuff.Mode porterDuff$Mode0 = this.U0;
            this.S0 = this.T0 == null || porterDuff$Mode0 == null ? null : new PorterDuffColorFilter(this.T0.getColorForState(this.getState(), 0), porterDuff$Mode0);
        }
        if(d.C(this.d0)) {
            z1 |= this.d0.setState(arr_v);
        }
        if(d.C(this.p0)) {
            z1 |= this.p0.setState(arr_v);
        }
        if(d.C(this.i0)) {
            int[] arr_v3 = new int[arr_v.length + arr_v1.length];
            System.arraycopy(arr_v, 0, arr_v3, 0, arr_v.length);
            System.arraycopy(arr_v1, 0, arr_v3, arr_v.length, arr_v1.length);
            z1 |= this.i0.setState(arr_v3);
        }
        if(d.C(this.j0)) {
            z1 |= this.j0.setState(arr_v1);
        }
        if(z1) {
            this.invalidateSelf();
        }
        if(z3) {
            this.D();
        }
        return z1;
    }

    public final void F(boolean z) {
        if(this.n0 != z) {
            this.n0 = z;
            float f = this.y();
            if(!z && this.O0) {
                this.O0 = false;
            }
            float f1 = this.y();
            this.invalidateSelf();
            if(f != f1) {
                this.D();
            }
        }
    }

    public final void G(Drawable drawable0) {
        if(this.p0 != drawable0) {
            float f = this.y();
            this.p0 = drawable0;
            float f1 = this.y();
            d.c0(this.p0);
            this.w(this.p0);
            this.invalidateSelf();
            if(f != f1) {
                this.D();
            }
        }
    }

    public final void H(ColorStateList colorStateList0) {
        if(this.q0 != colorStateList0) {
            this.q0 = colorStateList0;
            if(this.o0) {
                Drawable drawable0 = this.p0;
                if(drawable0 != null && this.n0) {
                    drawable0.setTintList(colorStateList0);
                }
            }
            this.onStateChange(this.getState());
        }
    }

    public final void I(boolean z) {
        if(this.o0 != z) {
            boolean z1 = this.Z();
            this.o0 = z;
            boolean z2 = this.Z();
            if(z1 != z2) {
                if(z2) {
                    this.w(this.p0);
                }
                else {
                    d.c0(this.p0);
                }
                this.invalidateSelf();
                this.D();
            }
        }
    }

    public final void J(float f) {
        if(this.W != f) {
            this.W = f;
            m m0 = this.a.a.g();
            m0.c(f);
            this.setShapeAppearanceModel(m0.a());
        }
    }

    public final void K(Drawable drawable0) {
        Drawable drawable1 = null;
        Drawable drawable2 = this.d0 == null ? null : w.V(this.d0);
        if(drawable2 != drawable0) {
            float f = this.y();
            if(drawable0 != null) {
                drawable1 = drawable0.mutate();
            }
            this.d0 = drawable1;
            float f1 = this.y();
            d.c0(drawable2);
            if(this.a0()) {
                this.w(this.d0);
            }
            this.invalidateSelf();
            if(f != f1) {
                this.D();
            }
        }
    }

    public final void L(float f) {
        if(this.f0 != f) {
            float f1 = this.y();
            this.f0 = f;
            float f2 = this.y();
            this.invalidateSelf();
            if(f1 != f2) {
                this.D();
            }
        }
    }

    public final void M(ColorStateList colorStateList0) {
        this.g0 = true;
        if(this.e0 != colorStateList0) {
            this.e0 = colorStateList0;
            if(this.a0()) {
                this.d0.setTintList(colorStateList0);
            }
            this.onStateChange(this.getState());
        }
    }

    public final void N(boolean z) {
        if(this.c0 != z) {
            boolean z1 = this.a0();
            this.c0 = z;
            boolean z2 = this.a0();
            if(z1 != z2) {
                if(z2) {
                    this.w(this.d0);
                }
                else {
                    d.c0(this.d0);
                }
                this.invalidateSelf();
                this.D();
            }
        }
    }

    public final void O(ColorStateList colorStateList0) {
        if(this.X != colorStateList0) {
            this.X = colorStateList0;
            if(this.b1) {
                this.r(colorStateList0);
            }
            this.onStateChange(this.getState());
        }
    }

    public final void P(float f) {
        if(this.Y != f) {
            this.Y = f;
            this.C0.setStrokeWidth(f);
            if(this.b1) {
                this.s(f);
            }
            this.invalidateSelf();
        }
    }

    public final void Q(Drawable drawable0) {
        Drawable drawable1 = null;
        Drawable drawable2 = this.i0 == null ? null : w.V(this.i0);
        if(drawable2 != drawable0) {
            float f = this.z();
            if(drawable0 != null) {
                drawable1 = drawable0.mutate();
            }
            this.i0 = drawable1;
            this.j0 = new RippleDrawable(a.c(this.Z), this.i0, d.d1);
            float f1 = this.z();
            d.c0(drawable2);
            if(this.b0()) {
                this.w(this.i0);
            }
            this.invalidateSelf();
            if(f != f1) {
                this.D();
            }
        }
    }

    public final void R(float f) {
        if(this.z0 != f) {
            this.z0 = f;
            this.invalidateSelf();
            if(this.b0()) {
                this.D();
            }
        }
    }

    public final void S(float f) {
        if(this.l0 != f) {
            this.l0 = f;
            this.invalidateSelf();
            if(this.b0()) {
                this.D();
            }
        }
    }

    public final void T(float f) {
        if(this.y0 != f) {
            this.y0 = f;
            this.invalidateSelf();
            if(this.b0()) {
                this.D();
            }
        }
    }

    public final void U(ColorStateList colorStateList0) {
        if(this.k0 != colorStateList0) {
            this.k0 = colorStateList0;
            if(this.b0()) {
                this.i0.setTintList(colorStateList0);
            }
            this.onStateChange(this.getState());
        }
    }

    public final void V(boolean z) {
        if(this.h0 != z) {
            boolean z1 = this.b0();
            this.h0 = z;
            boolean z2 = this.b0();
            if(z1 != z2) {
                if(z2) {
                    this.w(this.i0);
                }
                else {
                    d.c0(this.i0);
                }
                this.invalidateSelf();
                this.D();
            }
        }
    }

    public final void W(float f) {
        if(this.v0 != f) {
            float f1 = this.y();
            this.v0 = f;
            float f2 = this.y();
            this.invalidateSelf();
            if(f1 != f2) {
                this.D();
            }
        }
    }

    public final void X(float f) {
        if(this.u0 != f) {
            float f1 = this.y();
            this.u0 = f;
            float f2 = this.y();
            this.invalidateSelf();
            if(f1 != f2) {
                this.D();
            }
        }
    }

    public final void Y(ColorStateList colorStateList0) {
        if(this.Z != colorStateList0) {
            this.Z = colorStateList0;
            this.W0 = null;
            this.onStateChange(this.getState());
        }
    }

    // 去混淆评级： 低(20)
    public final boolean Z() {
        return this.o0 && this.p0 != null && this.O0;
    }

    @Override  // z6.i, com.google.android.material.internal.x
    public final void a() {
        this.D();
        this.invalidateSelf();
    }

    public final boolean a0() {
        return this.c0 && this.d0 != null;
    }

    public final boolean b0() {
        return this.h0 && this.i0 != null;
    }

    public static void c0(Drawable drawable0) {
        if(drawable0 != null) {
            drawable0.setCallback(null);
        }
    }

    @Override  // z6.i
    public final void draw(Canvas canvas0) {
        int v3;
        Rect rect0 = this.getBounds();
        if(!rect0.isEmpty()) {
            int v = this.Q0;
            if(v != 0) {
                int v1 = v >= 0xFF ? 0 : canvas0.saveLayerAlpha(((float)rect0.left), ((float)rect0.top), ((float)rect0.right), ((float)rect0.bottom), v);
                Paint paint0 = this.C0;
                RectF rectF0 = this.E0;
                if(!this.b1) {
                    paint0.setColor(this.I0);
                    paint0.setStyle(Paint.Style.FILL);
                    rectF0.set(rect0);
                    canvas0.drawRoundRect(rectF0, this.A(), this.A(), paint0);
                }
                if(!this.b1) {
                    paint0.setColor(this.J0);
                    paint0.setStyle(Paint.Style.FILL);
                    ColorFilter colorFilter0 = this.R0;
                    if(colorFilter0 == null) {
                        colorFilter0 = this.S0;
                    }
                    paint0.setColorFilter(colorFilter0);
                    rectF0.set(rect0);
                    canvas0.drawRoundRect(rectF0, this.A(), this.A(), paint0);
                }
                if(this.b1) {
                    super.draw(canvas0);
                }
                if(Float.compare(this.Y, 0.0f) > 0 && !this.b1) {
                    paint0.setColor(this.L0);
                    paint0.setStyle(Paint.Style.STROKE);
                    if(!this.b1) {
                        ColorFilter colorFilter1 = this.R0;
                        if(colorFilter1 == null) {
                            colorFilter1 = this.S0;
                        }
                        paint0.setColorFilter(colorFilter1);
                    }
                    rectF0.set(((float)rect0.left) + this.Y / 2.0f, ((float)rect0.top) + this.Y / 2.0f, ((float)rect0.right) - this.Y / 2.0f, ((float)rect0.bottom) - this.Y / 2.0f);
                    float f = this.W - this.Y / 2.0f;
                    canvas0.drawRoundRect(rectF0, f, f, paint0);
                }
                paint0.setColor(this.M0);
                paint0.setStyle(Paint.Style.FILL);
                rectF0.set(rect0);
                if(this.b1) {
                    RectF rectF1 = new RectF(rect0);
                    this.B.b(this.a.a, this.a.i, rectF1, this.w, this.G0);
                    RectF rectF2 = this.g();
                    this.e(canvas0, paint0, this.G0, this.a.a, rectF2);
                }
                else {
                    canvas0.drawRoundRect(rectF0, this.A(), this.A(), paint0);
                }
                if(this.a0()) {
                    this.x(rect0, rectF0);
                    float f1 = rectF0.left;
                    float f2 = rectF0.top;
                    canvas0.translate(f1, f2);
                    this.d0.setBounds(0, 0, ((int)rectF0.width()), ((int)rectF0.height()));
                    this.d0.draw(canvas0);
                    canvas0.translate(-f1, -f2);
                }
                if(this.Z()) {
                    this.x(rect0, rectF0);
                    float f3 = rectF0.left;
                    float f4 = rectF0.top;
                    canvas0.translate(f3, f4);
                    this.p0.setBounds(0, 0, ((int)rectF0.width()), ((int)rectF0.height()));
                    this.p0.draw(canvas0);
                    canvas0.translate(-f3, -f4);
                }
                if(this.Z0 && this.b0 != null) {
                    PointF pointF0 = this.F0;
                    pointF0.set(0.0f, 0.0f);
                    Paint.Align paint$Align0 = Paint.Align.LEFT;
                    y y0 = this.H0;
                    if(this.b0 != null) {
                        float f5 = this.t0;
                        float f6 = this.y() + f5 + this.w0;
                        if(this.getLayoutDirection() == 0) {
                            pointF0.x = ((float)rect0.left) + f6;
                        }
                        else {
                            pointF0.x = ((float)rect0.right) - f6;
                            paint$Align0 = Paint.Align.RIGHT;
                        }
                        float f7 = (float)rect0.centerY();
                        y0.a.getFontMetrics(this.D0);
                        pointF0.y = f7 - (this.D0.descent + this.D0.ascent) / 2.0f;
                    }
                    rectF0.setEmpty();
                    if(this.b0 != null) {
                        float f8 = this.t0;
                        float f9 = this.y() + f8 + this.w0;
                        float f10 = this.z() + this.A0 + this.x0;
                        if(this.getLayoutDirection() == 0) {
                            rectF0.left = ((float)rect0.left) + f9;
                            rectF0.right = ((float)rect0.right) - f10;
                        }
                        else {
                            rectF0.left = ((float)rect0.left) + f10;
                            rectF0.right = ((float)rect0.right) - f9;
                        }
                        rectF0.top = (float)rect0.top;
                        rectF0.bottom = (float)rect0.bottom;
                    }
                    TextPaint textPaint0 = y0.a;
                    if(y0.g != null) {
                        textPaint0.drawableState = this.getState();
                        y0.g.e(this.B0, textPaint0, y0.b);
                    }
                    textPaint0.setTextAlign(paint$Align0);
                    boolean z = Math.round(y0.a(this.b0.toString())) > Math.round(rectF0.width());
                    if(z) {
                        int v2 = canvas0.save();
                        canvas0.clipRect(rectF0);
                        v3 = v2;
                    }
                    else {
                        v3 = 0;
                    }
                    CharSequence charSequence0 = !z || this.Y0 == null ? this.b0 : TextUtils.ellipsize(this.b0, textPaint0, rectF0.width(), this.Y0);
                    canvas0.drawText(charSequence0, 0, charSequence0.length(), pointF0.x, pointF0.y, textPaint0);
                    if(z) {
                        canvas0.restoreToCount(v3);
                    }
                }
                if(this.b0()) {
                    rectF0.setEmpty();
                    if(this.b0()) {
                        float f11 = this.A0 + this.z0;
                        if(this.getLayoutDirection() == 0) {
                            float f12 = ((float)rect0.right) - f11;
                            rectF0.right = f12;
                            rectF0.left = f12 - this.l0;
                        }
                        else {
                            float f13 = ((float)rect0.left) + f11;
                            rectF0.left = f13;
                            rectF0.right = f13 + this.l0;
                        }
                        float f14 = rect0.exactCenterY() - this.l0 / 2.0f;
                        rectF0.top = f14;
                        rectF0.bottom = f14 + this.l0;
                    }
                    float f15 = rectF0.left;
                    float f16 = rectF0.top;
                    canvas0.translate(f15, f16);
                    this.i0.setBounds(0, 0, ((int)rectF0.width()), ((int)rectF0.height()));
                    this.j0.setBounds(this.i0.getBounds());
                    this.j0.jumpToCurrentState();
                    this.j0.draw(canvas0);
                    canvas0.translate(-f15, -f16);
                }
                if(this.Q0 < 0xFF) {
                    canvas0.restoreToCount(v1);
                }
            }
        }
    }

    @Override  // z6.i
    public final int getAlpha() {
        return this.Q0;
    }

    @Override  // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.R0;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int)this.V;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f = this.t0;
        float f1 = this.y() + f + this.w0;
        return Math.min(Math.round(this.z() + (this.H0.a(this.b0.toString()) + f1 + this.x0) + this.A0), this.a1);
    }

    @Override  // z6.i
    public final int getOpacity() {
        return -3;
    }

    @Override  // z6.i
    public final void getOutline(Outline outline0) {
        if(this.b1) {
            super.getOutline(outline0);
            return;
        }
        Rect rect0 = this.getBounds();
        if(rect0.isEmpty()) {
            outline0.setRoundRect(0, 0, this.getIntrinsicWidth(), ((int)this.V), this.W);
        }
        else {
            outline0.setRoundRect(rect0, this.W);
        }
        outline0.setAlpha(((float)this.Q0) / 255.0f);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void invalidateDrawable(Drawable drawable0) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 != null) {
            drawable$Callback0.invalidateDrawable(this);
        }
    }

    // 去混淆评级： 低(27)
    @Override  // z6.i
    public final boolean isStateful() {
        if(!d.B(this.S) && !d.B(this.T) && !d.B(this.X)) {
            w6.d d0 = this.H0.g;
            return d0 != null && (d0.j != null && d0.j.isStateful()) || (this.o0 && this.p0 != null && this.n0 || d.C(this.d0) || d.C(this.p0) || d.B(this.T0));
        }
        return true;
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int v) {
        boolean z = super.onLayoutDirectionChanged(v);
        if(this.a0()) {
            z |= this.d0.setLayoutDirection(v);
        }
        if(this.Z()) {
            z |= this.p0.setLayoutDirection(v);
        }
        if(this.b0()) {
            z |= this.i0.setLayoutDirection(v);
        }
        if(z) {
            this.invalidateSelf();
        }
        return true;
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int v) {
        boolean z = super.onLevelChange(v);
        if(this.a0()) {
            z |= this.d0.setLevel(v);
        }
        if(this.Z()) {
            z |= this.p0.setLevel(v);
        }
        if(this.b0()) {
            z |= this.i0.setLevel(v);
        }
        if(z) {
            this.invalidateSelf();
        }
        return z;
    }

    @Override  // z6.i, com.google.android.material.internal.x
    public final boolean onStateChange(int[] arr_v) {
        if(this.b1) {
            super.onStateChange(arr_v);
        }
        return this.E(arr_v, this.V0);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void scheduleDrawable(Drawable drawable0, Runnable runnable0, long v) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 != null) {
            drawable$Callback0.scheduleDrawable(this, runnable0, v);
        }
    }

    @Override  // z6.i
    public final void setAlpha(int v) {
        if(this.Q0 != v) {
            this.Q0 = v;
            this.invalidateSelf();
        }
    }

    @Override  // z6.i
    public final void setColorFilter(ColorFilter colorFilter0) {
        if(this.R0 != colorFilter0) {
            this.R0 = colorFilter0;
            this.invalidateSelf();
        }
    }

    @Override  // z6.i
    public final void setTintList(ColorStateList colorStateList0) {
        if(this.T0 != colorStateList0) {
            this.T0 = colorStateList0;
            this.onStateChange(this.getState());
        }
    }

    @Override  // z6.i
    public final void setTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.U0 != porterDuff$Mode0) {
            this.U0 = porterDuff$Mode0;
            this.S0 = this.T0 == null || porterDuff$Mode0 == null ? null : new PorterDuffColorFilter(this.T0.getColorForState(this.getState(), 0), porterDuff$Mode0);
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z1) {
        boolean z2 = super.setVisible(z, z1);
        if(this.a0()) {
            z2 |= this.d0.setVisible(z, z1);
        }
        if(this.Z()) {
            z2 |= this.p0.setVisible(z, z1);
        }
        if(this.b0()) {
            z2 |= this.i0.setVisible(z, z1);
        }
        if(z2) {
            this.invalidateSelf();
        }
        return z2;
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
        Drawable.Callback drawable$Callback0 = this.getCallback();
        if(drawable$Callback0 != null) {
            drawable$Callback0.unscheduleDrawable(this, runnable0);
        }
    }

    public final void w(Drawable drawable0) {
        if(drawable0 != null) {
            drawable0.setCallback(this);
            drawable0.setLayoutDirection(this.getLayoutDirection());
            drawable0.setLevel(this.getLevel());
            drawable0.setVisible(this.isVisible(), false);
            if(drawable0 == this.i0) {
                if(drawable0.isStateful()) {
                    drawable0.setState(this.V0);
                }
                drawable0.setTintList(this.k0);
                return;
            }
            Drawable drawable1 = this.d0;
            if(drawable0 == drawable1 && this.g0) {
                drawable1.setTintList(this.e0);
            }
            if(drawable0.isStateful()) {
                drawable0.setState(this.getState());
            }
        }
    }

    public final void x(Rect rect0, RectF rectF0) {
        rectF0.setEmpty();
        if(!this.a0() && !this.Z()) {
            return;
        }
        float f = this.t0 + this.u0;
        Drawable drawable0 = this.O0 ? this.p0 : this.d0;
        float f1 = this.f0 > 0.0f || drawable0 == null ? this.f0 : ((float)drawable0.getIntrinsicWidth());
        if(this.getLayoutDirection() == 0) {
            float f2 = ((float)rect0.left) + f;
            rectF0.left = f2;
            rectF0.right = f2 + f1;
        }
        else {
            float f3 = ((float)rect0.right) - f;
            rectF0.right = f3;
            rectF0.left = f3 - f1;
        }
        Drawable drawable1 = this.O0 ? this.p0 : this.d0;
        float f4 = this.f0;
        if(f4 <= 0.0f && drawable1 != null) {
            f4 = (float)Math.ceil(B.g(this.B0, 24));
            if(((float)drawable1.getIntrinsicHeight()) <= f4) {
                f4 = (float)drawable1.getIntrinsicHeight();
            }
        }
        float f5 = rect0.exactCenterY() - f4 / 2.0f;
        rectF0.top = f5;
        rectF0.bottom = f5 + f4;
    }

    public final float y() {
        if(!this.a0() && !this.Z()) {
            return 0.0f;
        }
        float f = this.u0;
        Drawable drawable0 = this.O0 ? this.p0 : this.d0;
        return (this.f0 > 0.0f || drawable0 == null ? this.f0 : ((float)drawable0.getIntrinsicWidth())) + f + this.v0;
    }

    // 去混淆评级： 低(20)
    public final float z() {
        return this.b0() ? this.y0 + this.l0 + this.z0 : 0.0f;
    }
}

