package com.google.android.material.slider;

import E9.h;
import F6.b;
import P1.c;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import c2.W;
import com.google.android.material.internal.B;
import com.google.android.material.internal.y;
import d3.g;
import e1.n;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import z6.i;
import z6.m;
import z6.o;

abstract class BaseSlider extends View {
    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public float a;
        public float b;
        public ArrayList c;
        public float d;
        public boolean e;

        static {
            SliderState.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeFloat(this.a);
            parcel0.writeFloat(this.b);
            parcel0.writeList(this.c);
            parcel0.writeFloat(this.d);
            parcel0.writeBooleanArray(new boolean[]{this.e});
        }
    }

    public boolean A0;
    public final int B;
    public boolean B0;
    public ColorStateList C0;
    public final int D;
    public ColorStateList D0;
    public final int E;
    public ColorStateList E0;
    public ColorStateList F0;
    public final int G;
    public ColorStateList G0;
    public final Path H0;
    public final int I;
    public final RectF I0;
    public final RectF J0;
    public final i K0;
    public Drawable L0;
    public final int M;
    public List M0;
    public final int N;
    public float N0;
    public int O0;
    public final a P0;
    public static final int Q0;
    public final int S;
    public final int T;
    public int V;
    public int W;
    public final Paint a;
    public final Paint b;
    public int b0;
    public final Paint c;
    public int c0;
    public final Paint d;
    public int d0;
    public final Paint e;
    public int e0;
    public final Paint f;
    public int f0;
    public final Paint g;
    public int g0;
    public final e h;
    public int h0;
    public final AccessibilityManager i;
    public int i0;
    public d j;
    public int j0;
    public final int k;
    public int k0;
    public final ArrayList l;
    public final int l0;
    public final ArrayList m;
    public float m0;
    public final ArrayList n;
    public MotionEvent n0;
    public boolean o;
    public boolean o0;
    public float p0;
    public float q0;
    public ValueAnimator r;
    public ArrayList r0;
    public int s0;
    public int t0;
    public float u0;
    public float[] v0;
    public ValueAnimator w;
    public boolean w0;
    public int x0;
    public int y0;
    public int z0;

    public BaseSlider(Context context0) {
        this(context0, null);
    }

    public BaseSlider(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040572);  // attr:sliderStyle
    }

    public BaseSlider(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1404CF), attributeSet0, v);  // style:Widget.MaterialComponents.Slider
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = false;
        this.h0 = -1;
        this.i0 = -1;
        this.o0 = false;
        this.r0 = new ArrayList();
        this.s0 = -1;
        this.t0 = -1;
        this.u0 = 0.0f;
        this.w0 = true;
        this.A0 = false;
        this.H0 = new Path();
        this.I0 = new RectF();
        this.J0 = new RectF();
        i i0 = new i();
        this.K0 = i0;
        this.M0 = Collections.EMPTY_LIST;
        this.O0 = 0;
        this.P0 = () -> switch(this.W) {
            case 0: 
            case 1: {
                if(this.s0 != -1 && this.isEnabled()) {
                    this.e();
                    return;
                }
                this.f();
                return;
            }
            case 2: {
                this.f();
                return;
            }
            case 3: {
                if(this.isEnabled()) {
                    Rect rect0 = new Rect();
                    B.i(this).getHitRect(rect0);
                    if(this.getLocalVisibleRect(rect0)) {
                        this.e();
                        return;
                    }
                }
                this.f();
                return;
            }
            default: {
                throw new IllegalArgumentException("Unexpected labelBehavior: " + this.W);
            }
        };
        Context context1 = this.getContext();
        this.a = new Paint();
        this.b = new Paint();
        Paint paint0 = new Paint(1);
        this.c = paint0;
        Paint.Style paint$Style0 = Paint.Style.FILL;
        paint0.setStyle(paint$Style0);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint1 = new Paint(1);
        this.d = paint1;
        paint1.setStyle(paint$Style0);
        Paint paint2 = new Paint();
        this.e = paint2;
        Paint.Style paint$Style1 = Paint.Style.STROKE;
        paint2.setStyle(paint$Style1);
        Paint.Cap paint$Cap0 = Paint.Cap.ROUND;
        paint2.setStrokeCap(paint$Cap0);
        Paint paint3 = new Paint();
        this.f = paint3;
        paint3.setStyle(paint$Style1);
        paint3.setStrokeCap(paint$Cap0);
        Paint paint4 = new Paint();
        this.g = paint4;
        paint4.setStyle(paint$Style0);
        paint4.setStrokeCap(paint$Cap0);
        Resources resources0 = context1.getResources();
        this.T = resources0.getDimensionPixelSize(0x7F0703D0);  // dimen:mtrl_slider_widget_height
        int v1 = resources0.getDimensionPixelOffset(0x7F0703CF);  // dimen:mtrl_slider_track_side_padding
        this.D = v1;
        this.c0 = v1;
        this.E = resources0.getDimensionPixelSize(0x7F0703CB);  // dimen:mtrl_slider_thumb_radius
        this.G = resources0.getDimensionPixelSize(0x7F0703CE);  // dimen:mtrl_slider_track_height
        this.I = resources0.getDimensionPixelSize(0x7F0703CD);  // dimen:mtrl_slider_tick_radius
        this.M = resources0.getDimensionPixelSize(0x7F0703CD);  // dimen:mtrl_slider_tick_radius
        this.N = resources0.getDimensionPixelSize(0x7F0703CC);  // dimen:mtrl_slider_tick_min_spacing
        this.l0 = resources0.getDimensionPixelSize(0x7F0703C7);  // dimen:mtrl_slider_label_padding
        B.c(context1, attributeSet0, v, 0x7F1404CF);  // style:Widget.MaterialComponents.Slider
        B.d(context1, attributeSet0, d6.a.a0, v, 0x7F1404CF, new int[0]);  // style:Widget.MaterialComponents.Slider
        TypedArray typedArray0 = context1.obtainStyledAttributes(attributeSet0, d6.a.a0, v, 0x7F1404CF);  // style:Widget.MaterialComponents.Slider
        this.k = typedArray0.getResourceId(8, 0x7F1404F1);  // style:Widget.MaterialComponents.Tooltip
        this.p0 = typedArray0.getFloat(3, 0.0f);
        this.q0 = typedArray0.getFloat(4, 1.0f);
        this.setValues(new Float[]{this.p0});
        this.u0 = typedArray0.getFloat(2, 0.0f);
        this.S = (int)Math.ceil(typedArray0.getDimension(9, ((float)Math.ceil(B.g(this.getContext(), 0x30)))));
        int v2 = 24;
        boolean z = typedArray0.hasValue(24);
        if(!z) {
            v2 = 25;
        }
        ColorStateList colorStateList0 = n.r(context1, typedArray0, (z ? 24 : 26));
        if(colorStateList0 == null) {
            colorStateList0 = c.getColorStateList(context1, 0x7F0603EB);  // color:material_slider_inactive_track_color
        }
        this.setTrackInactiveTintList(colorStateList0);
        ColorStateList colorStateList1 = n.r(context1, typedArray0, v2);
        if(colorStateList1 == null) {
            colorStateList1 = c.getColorStateList(context1, 0x7F0603E8);  // color:material_slider_active_track_color
        }
        this.setTrackActiveTintList(colorStateList1);
        i0.m(n.r(context1, typedArray0, 10));
        if(typedArray0.hasValue(14)) {
            this.setThumbStrokeColor(n.r(context1, typedArray0, 14));
        }
        this.setThumbStrokeWidth(typedArray0.getDimension(15, 0.0f));
        ColorStateList colorStateList2 = n.r(context1, typedArray0, 5);
        if(colorStateList2 == null) {
            colorStateList2 = c.getColorStateList(context1, 0x7F0603E9);  // color:material_slider_halo_color
        }
        this.setHaloTintList(colorStateList2);
        this.w0 = typedArray0.getBoolean(23, true);
        int v3 = 18;
        boolean z1 = typedArray0.hasValue(18);
        if(!z1) {
            v3 = 19;
        }
        ColorStateList colorStateList3 = n.r(context1, typedArray0, (z1 ? 18 : 20));
        if(colorStateList3 == null) {
            colorStateList3 = c.getColorStateList(context1, 0x7F0603EA);  // color:material_slider_inactive_tick_marks_color
        }
        this.setTickInactiveTintList(colorStateList3);
        ColorStateList colorStateList4 = n.r(context1, typedArray0, v3);
        if(colorStateList4 == null) {
            colorStateList4 = c.getColorStateList(context1, 0x7F0603E7);  // color:material_slider_active_tick_marks_color
        }
        this.setTickActiveTintList(colorStateList4);
        this.setThumbTrackGapSize(typedArray0.getDimensionPixelSize(16, 0));
        this.setTrackStopIndicatorSize(typedArray0.getDimensionPixelSize(29, 0));
        this.setTrackInsideCornerSize(typedArray0.getDimensionPixelSize(28, 0));
        int v4 = typedArray0.getDimensionPixelSize(13, 0);
        int v5 = typedArray0.getDimensionPixelSize(17, v4 * 2);
        int v6 = typedArray0.getDimensionPixelSize(12, v4 * 2);
        this.setThumbWidth(v5);
        this.setThumbHeight(v6);
        this.setHaloRadius(typedArray0.getDimensionPixelSize(6, 0));
        this.setThumbElevation(typedArray0.getDimension(11, 0.0f));
        this.setTrackHeight(typedArray0.getDimensionPixelSize(27, 0));
        this.setTickActiveRadius(typedArray0.getDimensionPixelSize(21, this.j0 / 2));
        this.setTickInactiveRadius(typedArray0.getDimensionPixelSize(22, this.j0 / 2));
        this.setLabelBehavior(typedArray0.getInt(7, 0));
        if(!typedArray0.getBoolean(0, true)) {
            this.setEnabled(false);
        }
        typedArray0.recycle();
        this.setFocusable(true);
        this.setClickable(true);
        i0.q(2);
        this.B = ViewConfiguration.get(context1).getScaledTouchSlop();
        e e0 = new e(this);
        this.h = e0;
        W.o(this, e0);
        this.i = (AccessibilityManager)this.getContext().getSystemService("accessibility");
    }

    public final void A() {
        boolean z1;
        int v = this.getPaddingTop();
        int v1 = this.getPaddingBottom();
        int v2 = this.b0 + (v1 + v);
        int v3 = this.e0;
        int v4 = this.getPaddingTop();
        int v5 = Math.max(v2, this.getPaddingBottom() + (v4 + v3));
        int v6 = Math.max(this.T, v5);
        boolean z = true;
        if(v6 == this.V) {
            z1 = false;
        }
        else {
            this.V = v6;
            z1 = true;
        }
        int v7 = Math.max(Math.max(Math.max(this.d0 / 2 - this.E, 0), Math.max((this.b0 - this.G) / 2, 0)), Math.max(Math.max(this.x0 - this.I, 0), Math.max(this.y0 - this.M, 0))) + this.D;
        if(this.c0 == v7) {
            z = false;
        }
        else {
            this.c0 = v7;
            if(this.isLaidOut()) {
                this.z0 = Math.max(this.getWidth() - this.c0 * 2, 0);
                this.m();
            }
        }
        if(z1) {
            this.requestLayout();
            return;
        }
        if(z) {
            this.postInvalidate();
        }
    }

    public final void B() {
        if(this.B0) {
            float f = this.p0;
            float f1 = this.q0;
            if(Float.compare(f, f1) >= 0) {
                throw new IllegalStateException("valueFrom(" + this.p0 + ") must be smaller than valueTo(" + this.q0 + ")");
            }
            if(f1 <= f) {
                throw new IllegalStateException("valueTo(" + this.q0 + ") must be greater than valueFrom(" + this.p0 + ")");
            }
            if(this.u0 > 0.0f && !this.C(f1)) {
                throw new IllegalStateException("The stepSize(" + this.u0 + ") must be 0, or a factor of the valueFrom(" + this.p0 + ")-valueTo(" + this.q0 + ") range");
            }
            for(Object object0: this.r0) {
                Float float0 = (Float)object0;
                if(((float)float0) < this.p0 || ((float)float0) > this.q0) {
                    throw new IllegalStateException("Slider value(" + float0 + ") must be greater or equal to valueFrom(" + this.p0 + "), and lower or equal to valueTo(" + this.q0 + ")");
                }
                if(this.u0 > 0.0f && !this.C(((float)float0))) {
                    throw new IllegalStateException("Value(" + float0 + ") must be equal to valueFrom(" + this.p0 + ") plus a multiple of stepSize(" + this.u0 + ") when using stepSize(" + this.u0 + ")");
                }
            }
            float f2 = this.getMinSeparation();
            if(Float.compare(f2, 0.0f) < 0) {
                throw new IllegalStateException("minSeparation(" + f2 + ") must be greater or equal to 0");
            }
            float f3 = this.u0;
            if(f3 > 0.0f && f2 > 0.0f) {
                if(this.O0 != 1) {
                    throw new IllegalStateException("minSeparation(" + f2 + ") cannot be set as a dimension when using stepSize(" + this.u0 + ")");
                }
                if(f2 < f3 || !this.j(((double)f2))) {
                    throw new IllegalStateException("minSeparation(" + f2 + ") must be greater or equal and a multiple of stepSize(" + this.u0 + ") when using stepSize(" + this.u0 + ")");
                }
            }
            float f4 = this.u0;
            if(f4 != 0.0f) {
                if(Float.compare(((int)f4), f4) != 0) {
                    Log.w("BaseSlider", "Floating point value used for stepSize(" + f4 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f5 = this.p0;
                if(((float)(((int)f5))) != f5) {
                    Log.w("BaseSlider", "Floating point value used for valueFrom(" + f5 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f6 = this.q0;
                if(((float)(((int)f6))) != f6) {
                    Log.w("BaseSlider", "Floating point value used for valueTo(" + f6 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.B0 = false;
        }
    }

    public final boolean C(float f) {
        return this.j(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.p0)), MathContext.DECIMAL64).doubleValue());
    }

    public final float D(float f) {
        return this.p(f) * ((float)this.z0) + ((float)this.c0);
    }

    public final void a(Drawable drawable0) {
        int v = drawable0.getIntrinsicWidth();
        int v1 = drawable0.getIntrinsicHeight();
        if(v == -1 && v1 == -1) {
            drawable0.setBounds(0, 0, this.d0, this.e0);
            return;
        }
        float f = ((float)Math.max(this.d0, this.e0)) / ((float)Math.max(v, v1));
        drawable0.setBounds(0, 0, ((int)(((float)v) * f)), ((int)(((float)v1) * f)));
    }

    public final int b() {
        return this.V / 2 + (this.W != 1 && this.W != 3 ? 0 : ((b)this.l.get(0)).getIntrinsicHeight());
    }

    public final ValueAnimator c(boolean z) {
        TimeInterpolator timeInterpolator0;
        int v;
        float f = 1.0f;
        float f1 = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator0 = z ? this.w : this.r;
        if(valueAnimator0 != null && valueAnimator0.isRunning()) {
            f1 = (float)(((Float)valueAnimator0.getAnimatedValue()));
            valueAnimator0.cancel();
        }
        if(!z) {
            f = 0.0f;
        }
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{f1, f});
        if(z) {
            v = n.B(this.getContext(), 0x7F04045A, 83);  // attr:motionDurationMedium4
            timeInterpolator0 = n.C(this.getContext(), 0x7F040464, e6.a.e);  // attr:motionEasingEmphasizedInterpolator
        }
        else {
            v = n.B(this.getContext(), 0x7F04045D, 0x75);  // attr:motionDurationShort3
            timeInterpolator0 = n.C(this.getContext(), 0x7F040462, e6.a.c);  // attr:motionEasingEmphasizedAccelerateInterpolator
        }
        valueAnimator1.setDuration(((long)v));
        valueAnimator1.setInterpolator(timeInterpolator0);
        valueAnimator1.addUpdateListener(new com.google.android.material.slider.b(this));
        return valueAnimator1;
    }

    public final void d(Canvas canvas0, int v, int v1, float f, Drawable drawable0) {
        canvas0.save();
        canvas0.translate(((float)(this.c0 + ((int)(this.p(f) * ((float)v))))) - ((float)drawable0.getBounds().width()) / 2.0f, ((float)v1) - ((float)drawable0.getBounds().height()) / 2.0f);
        drawable0.draw(canvas0);
        canvas0.restore();
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent0) {
        return this.h.d(motionEvent0) || super.dispatchHoverEvent(motionEvent0);
    }

    @Override  // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int v = this.i(this.G0);
        this.a.setColor(v);
        int v1 = this.i(this.F0);
        this.b.setColor(v1);
        int v2 = this.i(this.E0);
        this.e.setColor(v2);
        int v3 = this.i(this.D0);
        this.f.setColor(v3);
        int v4 = this.i(this.F0);
        this.g.setColor(v4);
        for(Object object0: this.l) {
            b b0 = (b)object0;
            if(b0.isStateful()) {
                b0.setState(this.getDrawableState());
            }
        }
        i i0 = this.K0;
        if(i0.isStateful()) {
            i0.setState(this.getDrawableState());
        }
        int v5 = this.i(this.C0);
        this.d.setColor(v5);
        this.d.setAlpha(0x3F);
    }

    public final void e() {
        if(!this.o) {
            this.o = true;
            ValueAnimator valueAnimator0 = this.c(true);
            this.r = valueAnimator0;
            this.w = null;
            valueAnimator0.start();
        }
        ArrayList arrayList0 = this.l;
        Iterator iterator0 = arrayList0.iterator();
        for(int v = 0; v < this.r0.size() && iterator0.hasNext(); ++v) {
            if(v != this.t0) {
                Object object0 = iterator0.next();
                this.s(((b)object0), ((float)(((Float)this.r0.get(v)))));
            }
        }
        if(!iterator0.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", arrayList0.size(), this.r0.size()));
        }
        Object object1 = iterator0.next();
        this.s(((b)object1), ((float)(((Float)this.r0.get(this.t0)))));
    }

    public final void f() {
        if(this.o) {
            this.o = false;
            ValueAnimator valueAnimator0 = this.c(false);
            this.w = valueAnimator0;
            this.r = null;
            valueAnimator0.addListener(new com.google.android.material.slider.c(this));
            this.w.start();
        }
    }

    public final String g(float f) {
        return ((float)(((int)f))) == f ? String.format("%.0f", f) : String.format("%.2f", f);
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public CharSequence getAccessibilityClassName() {
        return "android.widget.SeekBar";
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.h.h;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public int getThumbRadius() {
        return this.d0 / 2;
    }

    public float getValueFrom() {
        return this.p0;
    }

    public float getValueTo() {
        return this.q0;
    }

    public List getValues() {
        return new ArrayList(this.r0);
    }

    public final float[] h() {
        float f = (float)(((Float)this.r0.get(0)));
        float f1 = (float)(((Float)com.iloen.melon.utils.a.i(1, this.r0)));
        if(this.r0.size() == 1) {
            f = this.p0;
        }
        float f2 = this.p(f);
        float f3 = this.p(f1);
        return this.l() ? new float[]{f3, f2} : new float[]{f2, f3};
    }

    public final int i(ColorStateList colorStateList0) {
        return colorStateList0.getColorForState(this.getDrawableState(), colorStateList0.getDefaultColor());
    }

    public final boolean j(double f) {
        double f1 = new BigDecimal(Double.toString(f)).divide(new BigDecimal(Float.toString(this.u0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double)Math.round(f1)) - f1) < 0.0001;
    }

    public final boolean k(MotionEvent motionEvent0) {
        if(motionEvent0.getToolType(0) != 3) {
            for(ViewParent viewParent0 = this.getParent(); viewParent0 instanceof ViewGroup; viewParent0 = viewParent0.getParent()) {
                if((((ViewGroup)viewParent0).canScrollVertically(1) || ((ViewGroup)viewParent0).canScrollVertically(-1)) && ((ViewGroup)viewParent0).shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l() {
        return this.getLayoutDirection() == 1;
    }

    public final void m() {
        if(this.u0 > 0.0f) {
            this.B();
            int v = Math.min(((int)((this.q0 - this.p0) / this.u0 + 1.0f)), this.z0 / this.N + 1);
            if(this.v0 == null || this.v0.length != v * 2) {
                this.v0 = new float[v * 2];
            }
            float f = ((float)this.z0) / ((float)(v - 1));
            for(int v1 = 0; v1 < v * 2; v1 += 2) {
                float[] arr_f = this.v0;
                arr_f[v1] = ((float)v1) / 2.0f * f + ((float)this.c0);
                arr_f[v1 + 1] = (float)this.b();
            }
        }
    }

    public final boolean n(int v) {
        int v1 = this.t0;
        long v2 = ((long)v1) + ((long)v);
        int v3 = this.r0.size();
        if(v2 < 0L) {
            v2 = 0L;
        }
        else if(v2 > ((long)(v3 - 1))) {
            v2 = (long)(v3 - 1);
        }
        this.t0 = (int)v2;
        if(((int)v2) == v1) {
            return false;
        }
        if(this.s0 != -1) {
            this.s0 = (int)v2;
        }
        this.x();
        this.postInvalidate();
        return true;
    }

    public final void o(int v) {
        if(this.l()) {
            v = v == 0x80000000 ? 0x7FFFFFFF : -v;
        }
        this.n(v);
    }

    @Override  // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getViewTreeObserver().addOnScrollChangedListener(this.P0);
        for(Object object0: this.l) {
            b b0 = (b)object0;
            ViewGroup viewGroup0 = B.i(this);
            if(viewGroup0 == null) {
                b0.getClass();
            }
            else {
                b0.getClass();
                int[] arr_v = new int[2];
                viewGroup0.getLocationOnScreen(arr_v);
                b0.g0 = arr_v[0];
                viewGroup0.getWindowVisibleDisplayFrame(b0.Y);
                viewGroup0.addOnLayoutChangeListener(b0.X);
            }
        }
    }

    @Override  // android.view.View
    public final void onDetachedFromWindow() {
        d d0 = this.j;
        if(d0 != null) {
            this.removeCallbacks(d0);
        }
        this.o = false;
        for(Object object0: this.l) {
            b b0 = (b)object0;
            ViewGroup viewGroup0 = B.i(this);
            androidx.lifecycle.b b1 = viewGroup0 == null ? null : new androidx.lifecycle.b(viewGroup0);
            if(b1 != null) {
                ((ViewOverlay)b1.b).remove(b0);
                ViewGroup viewGroup1 = B.i(this);
                if(viewGroup1 == null) {
                    b0.getClass();
                }
                else {
                    viewGroup1.removeOnLayoutChangeListener(b0.X);
                }
            }
        }
        this.getViewTreeObserver().removeOnScrollChangedListener(this.P0);
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        int v16;
        int v12;
        int v7;
        if(this.B0) {
            this.B();
            this.m();
        }
        super.onDraw(canvas0);
        int v = this.b();
        float f = (float)(((Float)this.r0.get(0)));
        float f1 = (float)(((Float)com.iloen.melon.utils.a.i(1, this.r0)));
        RectF rectF0 = this.I0;
        if(Float.compare(f1, this.q0) < 0 || this.r0.size() > 1 && f > this.p0) {
            int v1 = this.z0;
            float[] arr_f = this.h();
            int v2 = this.c0;
            float f2 = arr_f[1] * ((float)v1) + ((float)v2);
            Paint paint0 = this.a;
            if(Float.compare(f2, v2 + v1) < 0) {
                int v3 = this.g0;
                if(v3 > 0) {
                    float f3 = ((float)this.b0) / 2.0f;
                    rectF0.set(f2 + ((float)v3), ((float)v) - f3, ((float)(v2 + v1)) + f3, f3 + ((float)v));
                    this.z(canvas0, rectF0, paint0, 3);
                }
                else {
                    paint0.setStyle(Paint.Style.STROKE);
                    paint0.setStrokeCap(Paint.Cap.ROUND);
                    canvas0.drawLine(f2, ((float)v), ((float)(this.c0 + v1)), ((float)v), paint0);
                }
            }
            int v4 = this.c0;
            float f4 = arr_f[0] * ((float)v1) + ((float)v4);
            if(f4 > ((float)v4)) {
                int v5 = this.g0;
                if(v5 > 0) {
                    float f5 = ((float)this.b0) / 2.0f;
                    rectF0.set(((float)v4) - f5, ((float)v) - f5, f4 - ((float)v5), f5 + ((float)v));
                    this.z(canvas0, rectF0, paint0, 2);
                }
                else {
                    paint0.setStyle(Paint.Style.STROKE);
                    paint0.setStrokeCap(Paint.Cap.ROUND);
                    canvas0.drawLine(((float)this.c0), ((float)v), f4, ((float)v), paint0);
                }
            }
        }
        if(f1 > this.p0) {
            int v6 = this.z0;
            float[] arr_f1 = this.h();
            float f6 = (float)this.c0;
            float f7 = arr_f1[1] * ((float)v6) + f6;
            float f8 = arr_f1[0] * ((float)v6) + f6;
            Paint paint1 = this.b;
            if(this.g0 > 0) {
                if(this.r0.size() != 1) {
                    v7 = 4;
                }
                else if(this.l()) {
                    v7 = 3;
                }
                else {
                    v7 = 2;
                }
                for(int v8 = 0; v8 < this.r0.size(); ++v8) {
                    if(this.r0.size() > 1) {
                        if(v8 > 0) {
                            f8 = this.D(((float)(((Float)this.r0.get(v8 - 1)))));
                        }
                        f7 = this.D(((float)(((Float)this.r0.get(v8)))));
                        if(this.l()) {
                            float f9 = f7;
                            f7 = f8;
                            f8 = f9;
                        }
                    }
                    switch(e0.b.b(v7)) {
                        case 1: {
                            f8 -= ((float)this.b0) / 2.0f;
                            f7 -= (float)this.g0;
                            break;
                        }
                        case 2: {
                            f8 += (float)this.g0;
                            f7 = ((float)this.b0) / 2.0f + f7;
                            break;
                        }
                        case 3: {
                            f8 += (float)this.g0;
                            f7 -= (float)this.g0;
                        }
                    }
                    if(f8 < f7) {
                        float f10 = ((float)this.b0) / 2.0f;
                        rectF0.set(f8, ((float)v) - f10, f7, f10 + ((float)v));
                        this.z(canvas0, rectF0, paint1, v7);
                    }
                }
            }
            else {
                paint1.setStyle(Paint.Style.STROKE);
                paint1.setStrokeCap(Paint.Cap.ROUND);
                canvas0.drawLine(f8, ((float)v), f7, ((float)v), paint1);
            }
        }
        if(this.w0 && this.u0 > 0.0f) {
            float[] arr_f2 = this.h();
            int v9 = (int)Math.ceil((((float)this.v0.length) / 2.0f - 1.0f) * arr_f2[0]);
            int v10 = (int)Math.floor((((float)this.v0.length) / 2.0f - 1.0f) * arr_f2[1]);
            Paint paint2 = this.e;
            if(v9 > 0) {
                canvas0.drawPoints(this.v0, 0, v9 * 2, paint2);
            }
            if(v9 <= v10) {
                canvas0.drawPoints(this.v0, v9 * 2, (v10 - v9 + 1) * 2, this.f);
            }
            int v11 = (v10 + 1) * 2;
            float[] arr_f3 = this.v0;
            if(v11 < arr_f3.length) {
                canvas0.drawPoints(arr_f3, v11, arr_f3.length - v11, paint2);
            }
        }
        if(this.j0 > 0) {
            Paint paint3 = this.g;
            if(this.r0.size() >= 1) {
                float f11 = (float)(((Float)com.iloen.melon.utils.a.i(1, this.r0)));
                float f12 = this.q0;
                if(f11 < f12) {
                    canvas0.drawPoint(this.D(f12), ((float)v), paint3);
                }
            }
            if(this.r0.size() > 1) {
                v12 = 0;
                float f13 = (float)(((Float)this.r0.get(0)));
                float f14 = this.p0;
                if(f13 > f14) {
                    canvas0.drawPoint(this.D(f14), ((float)v), paint3);
                }
            }
            else {
                v12 = 0;
            }
        }
        else {
            v12 = 0;
        }
        if((this.o0 || this.isFocused()) && this.isEnabled()) {
            int v13 = this.z0;
            if(!(this.getBackground() instanceof RippleDrawable)) {
                float f15 = (float)this.c0;
                int v14 = (int)(this.p(((float)(((Float)this.r0.get(this.t0))))) * ((float)v13) + f15);
                if(Build.VERSION.SDK_INT < 28) {
                    canvas0.clipRect(((float)(v14 - this.f0)), ((float)(v - this.f0)), ((float)(v14 + this.f0)), ((float)(this.f0 + v)), Region.Op.UNION);
                }
                canvas0.drawCircle(((float)v14), ((float)v), ((float)this.f0), this.d);
            }
        }
        this.y();
        int v15 = this.z0;
        while(v12 < this.r0.size()) {
            float f16 = (float)(((Float)this.r0.get(v12)));
            Drawable drawable0 = this.L0;
            if(drawable0 == null) {
                v16 = v;
                if(v12 < this.M0.size()) {
                    this.d(canvas0, v15, v16, f16, ((Drawable)this.M0.get(v12)));
                }
                else {
                    if(!this.isEnabled()) {
                        float f17 = (float)this.c0;
                        canvas0.drawCircle(this.p(f16) * ((float)v15) + f17, ((float)v16), ((float)this.getThumbRadius()), this.c);
                    }
                    this.d(canvas0, v15, v16, f16, this.K0);
                }
            }
            else {
                v16 = v;
                this.d(canvas0, v15, v16, f16, drawable0);
            }
            ++v12;
            v = v16;
        }
    }

    @Override  // android.view.View
    public final void onFocusChanged(boolean z, int v, Rect rect0) {
        super.onFocusChanged(z, v, rect0);
        e e0 = this.h;
        if(!z) {
            this.s0 = -1;
            e0.a(this.t0);
            return;
        }
        switch(v) {
            case 1: {
                this.n(0x7FFFFFFF);
                break;
            }
            case 2: {
                this.n(0x80000000);
                break;
            }
            case 17: {
                this.o(0x7FFFFFFF);
                break;
            }
            case 66: {
                this.o(0x80000000);
            }
        }
        e0.n(this.t0);
    }

    @Override  // android.view.View
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(!this.isEnabled()) {
            return super.onKeyDown(v, keyEvent0);
        }
        if(this.r0.size() == 1) {
            this.s0 = 0;
        }
        Boolean boolean0 = null;
        if(this.s0 == -1) {
            switch(v) {
                case 21: {
                    this.o(-1);
                    return true;
                }
                case 22: {
                    this.o(1);
                    return true;
                }
                case 61: {
                    if(keyEvent0.hasNoModifiers()) {
                        boolean0 = Boolean.valueOf(this.n(1));
                        return boolean0 == null ? super.onKeyDown(61, keyEvent0) : boolean0.booleanValue();
                    }
                    boolean0 = keyEvent0.isShiftPressed() ? Boolean.valueOf(this.n(-1)) : Boolean.FALSE;
                    return boolean0 == null ? super.onKeyDown(61, keyEvent0) : boolean0.booleanValue();
                }
                case 23: 
                case 66: {
                    this.s0 = this.t0;
                    this.postInvalidate();
                    return true;
                }
                case 69: {
                    this.n(-1);
                    return true;
                }
                case 70: 
                case 81: {
                    this.n(1);
                    return true;
                }
                default: {
                    return super.onKeyDown(v, keyEvent0);
                }
            }
        }
        int v1 = this.A0 | keyEvent0.isLongPress();
        this.A0 = v1;
        float f = 1.0f;
        if(v1 == 0) {
            float f3 = this.u0;
            if(f3 != 0.0f) {
                f = f3;
            }
        }
        else {
            float f1 = this.u0;
            if(f1 != 0.0f) {
                f = f1;
            }
            float f2 = (this.q0 - this.p0) / f;
            if(f2 > 20.0f) {
                f *= (float)Math.round(f2 / 20.0f);
            }
        }
        if(v == 21) {
            if(!this.l()) {
                f = -f;
            }
            boolean0 = f;
        }
        else {
            switch(v) {
                case 22: {
                    if(this.l()) {
                        f = -f;
                    }
                    boolean0 = f;
                    break;
                }
                case 69: {
                    boolean0 = (float)(-f);
                    break;
                }
                case 70: 
                case 81: {
                    boolean0 = f;
                }
            }
        }
        if(boolean0 != null) {
            if(this.u(((float)(((Float)boolean0))) + ((float)(((Float)this.r0.get(this.s0)))), this.s0)) {
                this.x();
                this.postInvalidate();
            }
            return true;
        }
        switch(v) {
            case 61: {
                if(keyEvent0.hasNoModifiers()) {
                    return this.n(1);
                }
                return keyEvent0.isShiftPressed() ? this.n(-1) : false;
            }
            case 23: 
            case 66: {
                this.s0 = -1;
                this.postInvalidate();
                return true;
            }
            default: {
                return super.onKeyDown(v, keyEvent0);
            }
        }
    }

    @Override  // android.view.View
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        this.A0 = false;
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, View.MeasureSpec.makeMeasureSpec(this.V + (this.W != 1 && this.W != 3 ? 0 : ((b)this.l.get(0)).getIntrinsicHeight()), 0x40000000));
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SliderState)parcelable0).getSuperState());
        this.p0 = ((SliderState)parcelable0).a;
        this.q0 = ((SliderState)parcelable0).b;
        this.t(((SliderState)parcelable0).c);
        this.u0 = ((SliderState)parcelable0).d;
        if(((SliderState)parcelable0).e) {
            this.requestFocus();
        }
    }

    @Override  // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SliderState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.p0;
        parcelable0.b = this.q0;
        parcelable0.c = new ArrayList(this.r0);
        parcelable0.d = this.u0;
        parcelable0.e = this.hasFocus();
        return parcelable0;
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        this.z0 = Math.max(v - this.c0 * 2, 0);
        this.m();
        this.x();
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.isEnabled()) {
            float f = motionEvent0.getX();
            this.N0 = Math.min(1.0f, Math.max(0.0f, (f - ((float)this.c0)) / ((float)this.z0)));
            int v = motionEvent0.getActionMasked();
            if(v == 0) {
                goto label_35;
            }
            int v1 = this.B;
            switch(v) {
                case 1: {
                label_8:
                    this.o0 = false;
                    if(this.n0 != null && this.n0.getActionMasked() == 0 && Math.abs(this.n0.getX() - motionEvent0.getX()) <= ((float)v1) && Math.abs(this.n0.getY() - motionEvent0.getY()) <= ((float)v1) && this.r()) {
                        this.q();
                    }
                    if(this.s0 != -1) {
                        this.v();
                        this.x();
                        if(this.g0 > 0) {
                            int v2 = this.h0;
                            if(v2 != -1 && this.i0 != -1) {
                                this.setThumbWidth(v2);
                                this.setThumbTrackGapSize(this.i0);
                            }
                        }
                        this.s0 = -1;
                        Iterator iterator0 = this.n.iterator();
                        if(iterator0.hasNext()) {
                            throw H0.b.b(iterator0);
                        }
                    }
                    this.invalidate();
                    this.setPressed(this.o0);
                    this.n0 = MotionEvent.obtain(motionEvent0);
                    return true;
                }
                case 2: {
                    break;
                }
                default: {
                    if(v == 3) {
                        goto label_8;
                    }
                    this.setPressed(this.o0);
                    this.n0 = MotionEvent.obtain(motionEvent0);
                    return true;
                }
            }
            boolean z = false;
            if(this.o0) {
                z = true;
            }
            else if(!this.k(motionEvent0) || Math.abs(f - this.m0) >= ((float)v1)) {
                z = true;
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.q();
            }
            if(z) {
                if(this.r()) {
                    this.o0 = true;
                    this.v();
                    this.x();
                    this.invalidate();
                    this.setPressed(this.o0);
                    this.n0 = MotionEvent.obtain(motionEvent0);
                    return true;
                label_35:
                    this.m0 = f;
                    if(!this.k(motionEvent0)) {
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                        if(this.r()) {
                            this.requestFocus();
                            this.o0 = true;
                            this.v();
                            this.x();
                            int v3 = this.g0;
                            if(v3 > 0) {
                                this.h0 = this.d0;
                                this.i0 = v3;
                                int v4 = Math.round(((float)this.d0) * 0.5f);
                                int v5 = this.d0 - v4;
                                this.setThumbWidth(v4);
                                this.setThumbTrackGapSize(this.g0 - v5 / 2);
                            }
                            this.invalidate();
                            this.q();
                        }
                    }
                }
                this.setPressed(this.o0);
                this.n0 = MotionEvent.obtain(motionEvent0);
                return true;
            }
        }
        return false;
    }

    @Override  // android.view.View
    public final void onVisibilityChanged(View view0, int v) {
        super.onVisibilityChanged(view0, v);
        if(v != 0) {
            ViewGroup viewGroup0 = B.i(this);
            androidx.lifecycle.b b0 = viewGroup0 == null ? null : new androidx.lifecycle.b(viewGroup0);
            if(b0 != null) {
                for(Object object0: this.l) {
                    ((ViewOverlay)b0.b).remove(((b)object0));
                }
            }
        }
    }

    public final float p(float f) {
        float f1 = (f - this.p0) / (this.q0 - this.p0);
        return this.l() ? 1.0f - f1 : f1;
    }

    public final void q() {
        Iterator iterator0 = this.n.iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
    }

    public boolean r() {
        boolean z;
        if(this.s0 != -1) {
            return true;
        }
        float f = this.N0;
        f = this.l() ? 1.0f - f : this.N0;
        float f1 = (this.q0 - this.p0) * f + this.p0;
        float f2 = this.D(f1);
        this.s0 = 0;
        float f3 = Math.abs(((float)(((Float)this.r0.get(0)))) - f1);
        for(int v = 1; v < this.r0.size(); ++v) {
            float f4 = Math.abs(((float)(((Float)this.r0.get(v)))) - f1);
            float f5 = this.D(((float)(((Float)this.r0.get(v)))));
            if(Float.compare(f4, f3) > 0) {
                break;
            }
            if(!this.l()) {
                if(f5 - f2 < 0.0f) {
                    z = true;
                }
            }
            else if(f5 - f2 > 0.0f) {
                z = true;
            }
            else {
                z = false;
            }
            if(Float.compare(f4, f3) < 0) {
                this.s0 = v;
                f3 = f4;
            }
            else if(Float.compare(f4, f3) == 0) {
                if(Math.abs(f5 - f2) < ((float)this.B)) {
                    this.s0 = -1;
                    return false;
                }
                if(z) {
                    this.s0 = v;
                    f3 = f4;
                }
            }
        }
        return this.s0 != -1;
    }

    public final void s(b b0, float f) {
        String s = this.g(f);
        if(!TextUtils.equals(b0.S, s)) {
            b0.S = s;
            b0.W.e = true;
            b0.invalidateSelf();
        }
        int v = this.c0 + ((int)(this.p(f) * ((float)this.z0))) - b0.getIntrinsicWidth() / 2;
        int v1 = this.b() - (this.e0 / 2 + this.l0);
        b0.setBounds(v, v1 - b0.getIntrinsicHeight(), b0.getIntrinsicWidth() + v, v1);
        Rect rect0 = new Rect(b0.getBounds());
        com.google.android.material.internal.d.c(B.i(this), this, rect0);
        b0.setBounds(rect0);
        ViewGroup viewGroup0 = B.i(this);
        ((ViewOverlay)(viewGroup0 == null ? null : new androidx.lifecycle.b(viewGroup0)).b).add(b0);
    }

    public void setActiveThumbIndex(int v) {
        this.s0 = v;
    }

    public void setCustomThumbDrawable(Drawable drawable0) {
        Drawable drawable1 = drawable0.mutate().getConstantState().newDrawable();
        this.a(drawable1);
        this.L0 = drawable1;
        this.M0.clear();
        this.postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(int[] arr_v) {
        Drawable[] arr_drawable = new Drawable[arr_v.length];
        for(int v = 0; v < arr_v.length; ++v) {
            arr_drawable[v] = this.getResources().getDrawable(arr_v[v]);
        }
        this.setCustomThumbDrawablesForValues(arr_drawable);
    }

    public void setCustomThumbDrawablesForValues(Drawable[] arr_drawable) {
        this.L0 = null;
        this.M0 = new ArrayList();
        for(int v = 0; v < arr_drawable.length; ++v) {
            List list0 = this.M0;
            Drawable drawable0 = arr_drawable[v].mutate().getConstantState().newDrawable();
            this.a(drawable0);
            list0.add(drawable0);
        }
        this.postInvalidate();
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.setLayerType((z ? 0 : 2), null);
    }

    public void setFocusedThumbIndex(int v) {
        if(v < 0 || v >= this.r0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.t0 = v;
        this.h.n(v);
        this.postInvalidate();
    }

    public void setHaloRadius(int v) {
        if(v == this.f0) {
            return;
        }
        this.f0 = v;
        Drawable drawable0 = this.getBackground();
        if(this.getBackground() instanceof RippleDrawable && drawable0 instanceof RippleDrawable) {
            ((RippleDrawable)drawable0).setRadius(this.f0);
            return;
        }
        this.postInvalidate();
    }

    public void setHaloTintList(ColorStateList colorStateList0) {
        if(colorStateList0.equals(this.C0)) {
            return;
        }
        this.C0 = colorStateList0;
        Drawable drawable0 = this.getBackground();
        if(this.getBackground() instanceof RippleDrawable && drawable0 instanceof RippleDrawable) {
            ((RippleDrawable)drawable0).setColor(colorStateList0);
            return;
        }
        int v = this.i(colorStateList0);
        this.d.setColor(v);
        this.d.setAlpha(0x3F);
        this.invalidate();
    }

    public void setLabelBehavior(int v) {
        if(this.W != v) {
            this.W = v;
            this.requestLayout();
        }
    }

    public void setSeparationUnit(int v) {
        this.O0 = v;
        this.B0 = true;
        this.postInvalidate();
    }

    public void setStepSize(float f) {
        if(f < 0.0f) {
            throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + this.p0 + ")-valueTo(" + this.q0 + ") range");
        }
        if(this.u0 != f) {
            this.u0 = f;
            this.B0 = true;
            this.postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        this.K0.l(f);
    }

    public void setThumbHeight(int v) {
        if(v == this.e0) {
            return;
        }
        this.e0 = v;
        this.K0.setBounds(0, 0, this.d0, v);
        Drawable drawable0 = this.L0;
        if(drawable0 != null) {
            this.a(drawable0);
        }
        for(Object object0: this.M0) {
            this.a(((Drawable)object0));
        }
        this.A();
    }

    public void setThumbRadius(int v) {
        this.setThumbWidth(v * 2);
        this.setThumbHeight(v * 2);
    }

    public void setThumbStrokeColor(ColorStateList colorStateList0) {
        this.K0.r(colorStateList0);
        this.postInvalidate();
    }

    public void setThumbStrokeWidth(float f) {
        this.K0.s(f);
        this.postInvalidate();
    }

    public void setThumbTrackGapSize(int v) {
        if(this.g0 == v) {
            return;
        }
        this.g0 = v;
        this.invalidate();
    }

    public void setThumbWidth(int v) {
        if(v == this.d0) {
            return;
        }
        this.d0 = v;
        z6.f f0 = new z6.f(0);
        z6.f f1 = new z6.f(0);
        z6.f f2 = new z6.f(0);
        z6.f f3 = new z6.f(0);
        float f4 = ((float)this.d0) / 2.0f;
        g g0 = d5.n.s(0);
        m.b(g0);
        m.b(g0);
        m.b(g0);
        m.b(g0);
        z6.a a0 = new z6.a(f4);
        z6.a a1 = new z6.a(f4);
        z6.a a2 = new z6.a(f4);
        z6.a a3 = new z6.a(f4);
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = g0;
        o0.b = g0;
        o0.c = g0;
        o0.d = g0;
        o0.e = a0;
        o0.f = a1;
        o0.g = a2;
        o0.h = a3;
        o0.i = f0;
        o0.j = f1;
        o0.k = f2;
        o0.l = f3;
        this.K0.setShapeAppearanceModel(o0);
        this.K0.setBounds(0, 0, this.d0, this.e0);
        Drawable drawable0 = this.L0;
        if(drawable0 != null) {
            this.a(drawable0);
        }
        for(Object object0: this.M0) {
            this.a(((Drawable)object0));
        }
        this.A();
    }

    public void setTickActiveRadius(int v) {
        if(this.x0 != v) {
            this.x0 = v;
            this.f.setStrokeWidth(((float)(v * 2)));
            this.A();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList0) {
        if(colorStateList0.equals(this.D0)) {
            return;
        }
        this.D0 = colorStateList0;
        int v = this.i(colorStateList0);
        this.f.setColor(v);
        this.invalidate();
    }

    public void setTickInactiveRadius(int v) {
        if(this.y0 != v) {
            this.y0 = v;
            this.e.setStrokeWidth(((float)(v * 2)));
            this.A();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList0) {
        if(colorStateList0.equals(this.E0)) {
            return;
        }
        this.E0 = colorStateList0;
        int v = this.i(colorStateList0);
        this.e.setColor(v);
        this.invalidate();
    }

    public void setTrackActiveTintList(ColorStateList colorStateList0) {
        if(colorStateList0.equals(this.F0)) {
            return;
        }
        this.F0 = colorStateList0;
        int v = this.i(colorStateList0);
        this.b.setColor(v);
        int v1 = this.i(this.F0);
        this.g.setColor(v1);
        this.invalidate();
    }

    public void setTrackHeight(int v) {
        if(this.b0 != v) {
            this.b0 = v;
            this.a.setStrokeWidth(((float)v));
            this.b.setStrokeWidth(((float)this.b0));
            this.A();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList0) {
        if(colorStateList0.equals(this.G0)) {
            return;
        }
        this.G0 = colorStateList0;
        int v = this.i(colorStateList0);
        this.a.setColor(v);
        this.invalidate();
    }

    public void setTrackInsideCornerSize(int v) {
        if(this.k0 == v) {
            return;
        }
        this.k0 = v;
        this.invalidate();
    }

    public void setTrackStopIndicatorSize(int v) {
        if(this.j0 == v) {
            return;
        }
        this.j0 = v;
        this.g.setStrokeWidth(((float)v));
        this.invalidate();
    }

    public void setValues(List list0) {
        this.t(new ArrayList(list0));
    }

    public void setValues(Float[] arr_float) {
        ArrayList arrayList0 = new ArrayList();
        Collections.addAll(arrayList0, arr_float);
        this.t(arrayList0);
    }

    public final void t(ArrayList arrayList0) {
        w6.d d0;
        if(arrayList0.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList0);
        if(this.r0.size() == arrayList0.size() && this.r0.equals(arrayList0)) {
            return;
        }
        this.r0 = arrayList0;
        int v = 1;
        this.B0 = true;
        this.t0 = 0;
        this.x();
        ArrayList arrayList1 = this.l;
        if(arrayList1.size() > this.r0.size()) {
            List list0 = arrayList1.subList(this.r0.size(), arrayList1.size());
            for(Object object0: list0) {
                b b0 = (b)object0;
                if(this.isAttachedToWindow()) {
                    ViewGroup viewGroup0 = B.i(this);
                    androidx.lifecycle.b b1 = viewGroup0 == null ? null : new androidx.lifecycle.b(viewGroup0);
                    if(b1 != null) {
                        ((ViewOverlay)b1.b).remove(b0);
                        ViewGroup viewGroup1 = B.i(this);
                        if(viewGroup1 == null) {
                            b0.getClass();
                        }
                        else {
                            viewGroup1.removeOnLayoutChangeListener(b0.X);
                        }
                    }
                }
            }
            list0.clear();
        }
        while(arrayList1.size() < this.r0.size()) {
            b b2 = new b(this.getContext(), this.k);
            TypedArray typedArray0 = B.m(b2.T, null, d6.a.j0, 0, this.k, new int[0]);
            Context context0 = b2.T;
            b2.f0 = context0.getResources().getDimensionPixelSize(0x7F0703E7);  // dimen:mtrl_tooltip_arrowSize
            boolean z = typedArray0.getBoolean(8, true);
            b2.e0 = z;
            if(z) {
                m m0 = b2.a.a.g();
                m0.k = b2.x();
                b2.setShapeAppearanceModel(m0.a());
            }
            else {
                b2.f0 = 0;
            }
            CharSequence charSequence0 = typedArray0.getText(6);
            boolean z1 = TextUtils.equals(b2.S, charSequence0);
            y y0 = b2.W;
            if(!z1) {
                b2.S = charSequence0;
                y0.e = true;
                b2.invalidateSelf();
            }
            if(typedArray0.hasValue(0)) {
                int v1 = typedArray0.getResourceId(0, 0);
                if(v1 != 0) {
                    d0 = new w6.d(context0, v1);
                }
            }
            else {
                d0 = null;
            }
            if(d0 != null && typedArray0.hasValue(1)) {
                d0.j = n.r(context0, typedArray0, 1);
            }
            y0.c(d0, context0);
            int v2 = n.p(context0, 0x7F04016B, b.class.getCanonicalName());  // attr:colorOnBackground
            int v3 = S1.c.k(n.p(context0, 0x1010031, b.class.getCanonicalName()), 0xE5);
            b2.m(ColorStateList.valueOf(typedArray0.getColor(7, S1.c.h(S1.c.k(v2, 0x99), v3))));
            b2.r(ColorStateList.valueOf(n.p(context0, 0x7F040190, b.class.getCanonicalName())));  // attr:colorSurface
            b2.Z = typedArray0.getDimensionPixelSize(2, 0);
            b2.b0 = typedArray0.getDimensionPixelSize(4, 0);
            b2.c0 = typedArray0.getDimensionPixelSize(5, 0);
            b2.d0 = typedArray0.getDimensionPixelSize(3, 0);
            typedArray0.recycle();
            arrayList1.add(b2);
            if(this.isAttachedToWindow()) {
                ViewGroup viewGroup2 = B.i(this);
                if(viewGroup2 != null) {
                    int[] arr_v = new int[2];
                    viewGroup2.getLocationOnScreen(arr_v);
                    b2.g0 = arr_v[0];
                    viewGroup2.getWindowVisibleDisplayFrame(b2.Y);
                    viewGroup2.addOnLayoutChangeListener(b2.X);
                }
            }
        }
        if(arrayList1.size() == 1) {
            v = 0;
        }
        for(Object object1: arrayList1) {
            ((b)object1).s(((float)v));
        }
        for(Object object2: this.m) {
            if(object2 != null) {
                throw new ClassCastException();
            }
            Iterator iterator3 = this.r0.iterator();
            if(!iterator3.hasNext()) {
                continue;
            }
            Object object3 = iterator3.next();
            ((Float)object3).getClass();
            throw null;
        }
        this.postInvalidate();
    }

    public final boolean u(float f, int v) {
        this.t0 = v;
        if(((double)Math.abs(f - ((float)(((Float)this.r0.get(v)))))) < 0.0001) {
            return false;
        }
        float f1 = this.getMinSeparation();
        if(this.O0 == 0) {
            f1 = f1 == 0.0f ? 0.0f : com.iloen.melon.utils.a.c(this.p0, this.q0, (f1 - ((float)this.c0)) / ((float)this.z0), this.p0);
        }
        if(this.l()) {
            f1 = -f1;
        }
        float f2 = v + 1 < this.r0.size() ? ((float)(((Float)this.r0.get(v + 1)))) - f1 : this.q0;
        float f3 = v - 1 >= 0 ? f1 + ((float)(((Float)this.r0.get(v - 1)))) : this.p0;
        this.r0.set(v, h.q(f, f3, f2));
        Iterator iterator0 = this.m.iterator();
        if(!iterator0.hasNext()) {
            if(this.i != null && this.i.isEnabled()) {
                d d0 = this.j;
                if(d0 == null) {
                    this.j = new d(this);
                }
                else {
                    this.removeCallbacks(d0);
                }
                this.j.a = v;
                this.postDelayed(this.j, 200L);
            }
            return true;
        }
        Object object0 = iterator0.next();
        if(object0 != null) {
            throw new ClassCastException();
        }
        ((Float)this.r0.get(v)).getClass();
        throw null;
    }

    public final void v() {
        double f2;
        float f = this.N0;
        float f1 = this.u0;
        if(f1 > 0.0f) {
            int v = (int)((this.q0 - this.p0) / f1);
            f2 = ((double)Math.round(f * ((float)v))) / ((double)v);
        }
        else {
            f2 = (double)f;
        }
        if(this.l()) {
            f2 = 1.0 - f2;
        }
        this.u(((float)(f2 * ((double)(this.q0 - this.p0)) + ((double)this.p0))), this.s0);
    }

    public final void w(int v, Rect rect0) {
        int v1 = this.c0 + ((int)(this.p(((float)(((Float)this.getValues().get(v))))) * ((float)this.z0)));
        int v2 = this.b();
        int v3 = Math.max(this.d0 / 2, this.S / 2);
        int v4 = Math.max(this.e0 / 2, this.S / 2);
        rect0.set(v1 - v3, v2 - v4, v1 + v3, v2 + v4);
    }

    public final void x() {
        if(this.getBackground() instanceof RippleDrawable && this.getMeasuredWidth() > 0) {
            Drawable drawable0 = this.getBackground();
            if(drawable0 instanceof RippleDrawable) {
                int v = (int)(this.p(((float)(((Float)this.r0.get(this.t0))))) * ((float)this.z0) + ((float)this.c0));
                int v1 = this.b();
                drawable0.setHotspotBounds(v - this.f0, v1 - this.f0, v + this.f0, v1 + this.f0);
            }
        }
    }

    // 检测为 Lambda 实现
    public final void y() [...]

    public final void z(Canvas canvas0, RectF rectF0, Paint paint0, int v) {
        float f1;
        float f = ((float)this.b0) / 2.0f;
        switch(e0.b.b(v)) {
            case 1: {
                f1 = (float)this.k0;
                break;
            }
            case 2: {
                f1 = f;
                f = (float)this.k0;
                break;
            }
            case 3: {
                f = (float)this.k0;
                f1 = f;
                break;
            }
            default: {
                f1 = f;
            }
        }
        paint0.setStyle(Paint.Style.FILL);
        paint0.setStrokeCap(Paint.Cap.BUTT);
        paint0.setAntiAlias(true);
        Path path0 = this.H0;
        path0.reset();
        if(rectF0.width() >= f + f1) {
            path0.addRoundRect(rectF0, new float[]{f, f, f1, f1, f1, f1, f, f}, Path.Direction.CW);
            canvas0.drawPath(path0, paint0);
            return;
        }
        float f2 = Math.min(f, f1);
        float f3 = Math.max(f, f1);
        canvas0.save();
        path0.addRoundRect(rectF0, f2, f2, Path.Direction.CW);
        canvas0.clipPath(path0);
        int v1 = e0.b.b(v);
        RectF rectF1 = this.J0;
        switch(v1) {
            case 1: {
                rectF1.set(rectF0.left, rectF0.top, 2.0f * f3 + rectF0.left, rectF0.bottom);
                break;
            }
            case 2: {
                rectF1.set(rectF0.right - 2.0f * f3, rectF0.top, rectF0.right, rectF0.bottom);
                break;
            }
            default: {
                rectF1.set(rectF0.centerX() - f3, rectF0.top, rectF0.centerX() + f3, rectF0.bottom);
            }
        }
        canvas0.drawRoundRect(rectF1, f3, f3, paint0);
        canvas0.restore();
    }
}

