package com.google.android.material.textfield;

import D6.b;
import E6.a;
import E9.t;
import U4.x;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import c2.P;
import c2.W;
import com.google.android.material.internal.B;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import d3.g;
import d5.m;
import e1.n;
import java.util.LinkedHashSet;
import java.util.Locale;
import z6.h;
import z6.i;
import z6.l;

public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public CharSequence c;
        public boolean d;

        static {
            SavedState.CREATOR = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
            this.d = parcel0.readInt() == 1;
        }

        @Override
        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.c + "}";
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            TextUtils.writeToParcel(this.c, parcel0, v);
            parcel0.writeInt(((int)this.d));
        }
    }

    public final LinkedHashSet A0;
    public CharSequence B;
    public ColorDrawable B0;
    public int C0;
    public boolean D;
    public Drawable D0;
    public AppCompatTextView E;
    public ColorStateList E0;
    public ColorStateList F0;
    public ColorStateList G;
    public int G0;
    public int H0;
    public int I;
    public int I0;
    public ColorStateList J0;
    public int K0;
    public int L0;
    public Fade M;
    public int M0;
    public Fade N;
    public int N0;
    public int O0;
    public int P0;
    public boolean Q0;
    public final c R0;
    public ColorStateList S;
    public boolean S0;
    public ColorStateList T;
    public boolean T0;
    public ValueAnimator U0;
    public ColorStateList V;
    public boolean V0;
    public ColorStateList W;
    public boolean W0;
    public boolean X0;
    public static final int[][] Y0;
    public final FrameLayout a;
    public final s b;
    public boolean b0;
    public final k c;
    public CharSequence c0;
    public EditText d;
    public boolean d0;
    public CharSequence e;
    public i e0;
    public int f;
    public i f0;
    public int g;
    public StateListDrawable g0;
    public int h;
    public boolean h0;
    public int i;
    public i i0;
    public final o j;
    public i j0;
    public boolean k;
    public z6.o k0;
    public int l;
    public boolean l0;
    public boolean m;
    public final int m0;
    public v n;
    public int n0;
    public AppCompatTextView o;
    public int o0;
    public int p0;
    public int q0;
    public int r;
    public int r0;
    public int s0;
    public int t0;
    public final Rect u0;
    public final Rect v0;
    public int w;
    public final RectF w0;
    public Typeface x0;
    public ColorDrawable y0;
    public int z0;

    static {
        TextInputLayout.Y0 = new int[][]{new int[]{0x10100A7}, new int[0]};
    }

    public TextInputLayout(Context context0) {
        this(context0, null);
    }

    public TextInputLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04061D);  // attr:textInputStyle
    }

    public TextInputLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1403C7), attributeSet0, v);  // style:Widget.Design.TextInputLayout
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = new o(this);
        this.n = new com.google.android.exoplayer2.upstream.cache.a(5);
        this.u0 = new Rect();
        this.v0 = new Rect();
        this.w0 = new RectF();
        this.A0 = new LinkedHashSet();
        c c0 = new c(this);
        this.R0 = c0;
        this.X0 = false;
        Context context1 = this.getContext();
        this.setOrientation(1);
        this.setWillNotDraw(false);
        this.setAddStatesFromChildren(true);
        FrameLayout frameLayout0 = new FrameLayout(context1);
        this.a = frameLayout0;
        frameLayout0.setAddStatesFromChildren(true);
        c0.W = e6.a.a;
        c0.i(false);
        c0.V = e6.a.a;
        c0.i(false);
        c0.l(0x800033);
        m m0 = B.n(context1, attributeSet0, d6.a.h0, v, 0x7F1403C7, new int[]{22, 20, 40, 45, 49});  // style:Widget.Design.TextInputLayout
        s s0 = new s(this, m0);
        this.b = s0;
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.b0 = typedArray0.getBoolean(0x30, true);
        this.setHint(typedArray0.getText(4));
        this.T0 = typedArray0.getBoolean(0x2F, true);
        this.S0 = typedArray0.getBoolean(42, true);
        if(typedArray0.hasValue(6)) {
            this.setMinEms(typedArray0.getInt(6, -1));
        }
        else if(typedArray0.hasValue(3)) {
            this.setMinWidth(typedArray0.getDimensionPixelSize(3, -1));
        }
        if(typedArray0.hasValue(5)) {
            this.setMaxEms(typedArray0.getInt(5, -1));
        }
        else if(typedArray0.hasValue(2)) {
            this.setMaxWidth(typedArray0.getDimensionPixelSize(2, -1));
        }
        this.k0 = z6.o.d(context1, attributeSet0, v, 0x7F1403C7).a();  // style:Widget.Design.TextInputLayout
        this.m0 = context1.getResources().getDimensionPixelOffset(0x7F0703DF);  // dimen:mtrl_textinput_box_label_cutout_padding
        this.o0 = typedArray0.getDimensionPixelOffset(9, 0);
        this.q0 = typedArray0.getDimensionPixelSize(16, context1.getResources().getDimensionPixelSize(0x7F0703E0));  // dimen:mtrl_textinput_box_stroke_width_default
        this.r0 = typedArray0.getDimensionPixelSize(17, context1.getResources().getDimensionPixelSize(0x7F0703E1));  // dimen:mtrl_textinput_box_stroke_width_focused
        this.p0 = this.q0;
        float f = typedArray0.getDimension(13, -1.0f);
        float f1 = typedArray0.getDimension(12, -1.0f);
        float f2 = typedArray0.getDimension(10, -1.0f);
        float f3 = typedArray0.getDimension(11, -1.0f);
        z6.m m1 = this.k0.g();
        if(f >= 0.0f) {
            m1.e = new z6.a(f);
        }
        if(f1 >= 0.0f) {
            m1.f = new z6.a(f1);
        }
        if(f2 >= 0.0f) {
            m1.g = new z6.a(f2);
        }
        if(f3 >= 0.0f) {
            m1.h = new z6.a(f3);
        }
        this.k0 = m1.a();
        ColorStateList colorStateList0 = n.s(context1, m0, 7);
        if(colorStateList0 == null) {
            this.t0 = 0;
            this.K0 = 0;
            this.L0 = 0;
            this.M0 = 0;
            this.N0 = 0;
        }
        else {
            int v1 = colorStateList0.getDefaultColor();
            this.K0 = v1;
            this.t0 = v1;
            if(colorStateList0.isStateful()) {
                this.L0 = colorStateList0.getColorForState(new int[]{0xFEFEFF62}, -1);
                this.M0 = colorStateList0.getColorForState(new int[]{0x101009C, 0x101009E}, -1);
                this.N0 = colorStateList0.getColorForState(new int[]{0x1010367, 0x101009E}, -1);
            }
            else {
                this.M0 = this.K0;
                ColorStateList colorStateList1 = P1.c.getColorStateList(context1, 0x7F06041C);  // color:mtrl_filled_background_color
                this.L0 = colorStateList1.getColorForState(new int[]{0xFEFEFF62}, -1);
                this.N0 = colorStateList1.getColorForState(new int[]{0x1010367}, -1);
            }
        }
        if(typedArray0.hasValue(1)) {
            ColorStateList colorStateList2 = m0.j(1);
            this.F0 = colorStateList2;
            this.E0 = colorStateList2;
        }
        ColorStateList colorStateList3 = n.s(context1, m0, 14);
        this.I0 = typedArray0.getColor(14, 0);
        this.G0 = P1.c.getColor(context1, 0x7F060437);  // color:mtrl_textinput_default_box_stroke_color
        this.O0 = P1.c.getColor(context1, 0x7F060438);  // color:mtrl_textinput_disabled_color
        this.H0 = P1.c.getColor(context1, 0x7F06043B);  // color:mtrl_textinput_hovered_box_stroke_color
        if(colorStateList3 != null) {
            this.setBoxStrokeColorStateList(colorStateList3);
        }
        if(typedArray0.hasValue(15)) {
            this.setBoxStrokeErrorColor(n.s(context1, m0, 15));
        }
        if(typedArray0.getResourceId(49, -1) != -1) {
            this.setHintTextAppearance(typedArray0.getResourceId(49, 0));
        }
        this.V = m0.j(24);
        this.W = m0.j(25);
        int v2 = typedArray0.getResourceId(40, 0);
        CharSequence charSequence0 = typedArray0.getText(35);
        int v3 = typedArray0.getInt(34, 1);
        boolean z = typedArray0.getBoolean(36, false);
        int v4 = typedArray0.getResourceId(45, 0);
        boolean z1 = typedArray0.getBoolean(44, false);
        CharSequence charSequence1 = typedArray0.getText(43);
        int v5 = typedArray0.getResourceId(57, 0);
        CharSequence charSequence2 = typedArray0.getText(56);
        boolean z2 = typedArray0.getBoolean(18, false);
        this.setCounterMaxLength(typedArray0.getInt(19, -1));
        this.w = typedArray0.getResourceId(22, 0);
        this.r = typedArray0.getResourceId(20, 0);
        this.setBoxBackgroundMode(typedArray0.getInt(8, 0));
        this.setErrorContentDescription(charSequence0);
        this.setErrorAccessibilityLiveRegion(v3);
        this.setCounterOverflowTextAppearance(this.r);
        this.setHelperTextTextAppearance(v4);
        this.setErrorTextAppearance(v2);
        this.setCounterTextAppearance(this.w);
        this.setPlaceholderText(charSequence2);
        this.setPlaceholderTextAppearance(v5);
        if(typedArray0.hasValue(41)) {
            this.setErrorTextColor(m0.j(41));
        }
        if(typedArray0.hasValue(46)) {
            this.setHelperTextColor(m0.j(46));
        }
        if(typedArray0.hasValue(50)) {
            this.setHintTextColor(m0.j(50));
        }
        if(typedArray0.hasValue(23)) {
            this.setCounterTextColor(m0.j(23));
        }
        if(typedArray0.hasValue(21)) {
            this.setCounterOverflowTextColor(m0.j(21));
        }
        if(typedArray0.hasValue(58)) {
            this.setPlaceholderTextColor(m0.j(58));
        }
        k k0 = new k(this, m0);
        this.c = k0;
        boolean z3 = typedArray0.getBoolean(0, true);
        m0.t();
        this.setImportantForAccessibility(2);
        P.b(this, 1);
        frameLayout0.addView(s0);
        frameLayout0.addView(k0);
        this.addView(frameLayout0);
        this.setEnabled(z3);
        this.setHelperTextEnabled(z1);
        this.setErrorEnabled(z);
        this.setCounterEnabled(z2);
        this.setHelperText(charSequence1);
    }

    public final void a(float f) {
        c c0 = this.R0;
        if(c0.b == f) {
            return;
        }
        if(this.U0 == null) {
            ValueAnimator valueAnimator0 = new ValueAnimator();
            this.U0 = valueAnimator0;
            valueAnimator0.setInterpolator(n.C(this.getContext(), 0x7F040464, e6.a.b));  // attr:motionEasingEmphasizedInterpolator
            this.U0.setDuration(((long)n.B(this.getContext(), 0x7F04045A, 0xA7)));  // attr:motionDurationMedium4
            this.U0.addUpdateListener(new b(this, 4));
        }
        this.U0.setFloatValues(new float[]{c0.b, f});
        this.U0.start();
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(view0 instanceof EditText) {
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(viewGroup$LayoutParams0);
            frameLayout$LayoutParams0.gravity = frameLayout$LayoutParams0.gravity & 0xFFFFFF8F | 16;
            this.a.addView(view0, frameLayout$LayoutParams0);
            this.a.setLayoutParams(viewGroup$LayoutParams0);
            this.t();
            this.setEditText(((EditText)view0));
            return;
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public final void b() {
        i i0 = this.e0;
        if(i0 == null) {
            return;
        }
        z6.o o0 = this.k0;
        if(i0.a.a != o0) {
            i0.setShapeAppearanceModel(o0);
        }
        if(this.n0 == 2) {
            int v = this.p0;
            if(v > -1) {
                int v1 = this.s0;
                if(v1 != 0) {
                    i i1 = this.e0;
                    i1.s(((float)v));
                    i1.r(ColorStateList.valueOf(v1));
                }
            }
        }
        int v2 = this.t0;
        if(this.n0 == 1) {
            int v3 = n.o(this.getContext(), 0x7F040190, 0);  // attr:colorSurface
            v2 = S1.c.h(this.t0, v3);
        }
        this.t0 = v2;
        this.e0.m(ColorStateList.valueOf(v2));
        i i2 = this.i0;
        if(i2 != null && this.j0 != null) {
            if(this.p0 > -1 && this.s0 != 0) {
                i2.m((this.d.isFocused() ? ColorStateList.valueOf(this.G0) : ColorStateList.valueOf(this.s0)));
                this.j0.m(ColorStateList.valueOf(this.s0));
            }
            this.invalidate();
        }
        this.s();
    }

    public final int c() {
        if(!this.b0) {
            return 0;
        }
        c c0 = this.R0;
        switch(this.n0) {
            case 0: {
                return (int)c0.e();
            }
            case 2: {
                return (int)(c0.e() / 2.0f);
            }
            default: {
                return 0;
            }
        }
    }

    public final Fade d() {
        Fade fade0 = new Fade();  // 初始化器: Landroidx/transition/Visibility;-><init>()V
        fade0.c = (long)n.B(this.getContext(), 0x7F04045C, 87);  // attr:motionDurationShort2
        fade0.d = n.C(this.getContext(), 0x7F040466, e6.a.a);  // attr:motionEasingLinearInterpolator
        return fade0;
    }

    @Override  // android.view.ViewGroup
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure0, int v) {
        EditText editText0 = this.d;
        if(editText0 == null) {
            super.dispatchProvideAutofillStructure(viewStructure0, v);
            return;
        }
        if(this.e != null) {
            boolean z = this.d0;
            this.d0 = false;
            CharSequence charSequence0 = editText0.getHint();
            this.d.setHint(this.e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure0, v);
            }
            finally {
                this.d.setHint(charSequence0);
                this.d0 = z;
            }
            return;
        }
        viewStructure0.setAutofillId(this.getAutofillId());
        this.onProvideAutofillStructure(viewStructure0, v);
        this.onProvideAutofillVirtualStructure(viewStructure0, v);
        FrameLayout frameLayout0 = this.a;
        viewStructure0.setChildCount(frameLayout0.getChildCount());
        for(int v1 = 0; v1 < frameLayout0.getChildCount(); ++v1) {
            View view0 = frameLayout0.getChildAt(v1);
            ViewStructure viewStructure1 = viewStructure0.newChild(v1);
            view0.dispatchProvideAutofillStructure(viewStructure1, v);
            if(view0 == this.d) {
                viewStructure1.setHint(this.getHint());
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void dispatchRestoreInstanceState(SparseArray sparseArray0) {
        this.W0 = true;
        super.dispatchRestoreInstanceState(sparseArray0);
        this.W0 = false;
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        super.draw(canvas0);
        c c0 = this.R0;
        if(this.b0) {
            c0.d(canvas0);
        }
        if(this.j0 != null) {
            i i0 = this.i0;
            if(i0 != null) {
                i0.draw(canvas0);
                if(this.d.isFocused()) {
                    Rect rect0 = this.j0.getBounds();
                    Rect rect1 = this.i0.getBounds();
                    float f = c0.b;
                    int v = rect1.centerX();
                    rect0.left = e6.a.c(v, rect1.left, f);
                    rect0.right = e6.a.c(v, rect1.right, f);
                    this.j0.draw(canvas0);
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        boolean z1;
        if(this.V0) {
            return;
        }
        boolean z = true;
        this.V0 = true;
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        c c0 = this.R0;
        if(c0 == null) {
            z1 = false;
        }
        else {
            c0.R = arr_v;
            if((c0.o == null || !c0.o.isStateful()) && (c0.n == null || !c0.n.isStateful())) {
                z1 = false;
            }
            else {
                c0.i(false);
                z1 = true;
            }
        }
        if(this.d != null) {
            if(!this.isLaidOut() || !this.isEnabled()) {
                z = false;
            }
            this.u(z, false);
        }
        this.r();
        this.x();
        if(z1) {
            this.invalidate();
        }
        this.V0 = false;
    }

    // 去混淆评级： 低(30)
    public final boolean e() {
        return this.b0 && !TextUtils.isEmpty(this.c0) && this.e0 instanceof f;
    }

    public final i f(boolean z) {
        float f = (float)this.getResources().getDimensionPixelOffset(0x7F0703C5);  // dimen:mtrl_shape_corner_size_small_component
        float f1 = z ? f : 0.0f;
        float f2 = this.d instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView)this.d).getPopupElevation() : ((float)this.getResources().getDimensionPixelOffset(0x7F0701F5));  // dimen:m3_comp_outlined_autocomplete_menu_container_elevation
        int v = this.getResources().getDimensionPixelOffset(0x7F070386);  // dimen:mtrl_exposed_dropdown_menu_popup_vertical_padding
        l l0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l1 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l2 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l3 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        z6.f f3 = new z6.f(0);
        z6.f f4 = new z6.f(0);
        z6.f f5 = new z6.f(0);
        z6.f f6 = new z6.f(0);
        z6.a a0 = new z6.a(f1);
        z6.a a1 = new z6.a(f1);
        z6.a a2 = new z6.a(f);
        z6.a a3 = new z6.a(f);
        z6.o o0 = new z6.o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = l0;
        o0.b = l1;
        o0.c = l2;
        o0.d = l3;
        o0.e = a0;
        o0.f = a1;
        o0.g = a3;
        o0.h = a2;
        o0.i = f3;
        o0.j = f4;
        o0.k = f5;
        o0.l = f6;
        ColorStateList colorStateList0 = this.d instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView)this.d).getDropDownBackgroundTintList() : null;
        Context context0 = this.getContext();
        if(colorStateList0 == null) {
            colorStateList0 = ColorStateList.valueOf(n.p(context0, 0x7F040190, "i"));  // attr:colorSurface
        }
        i i0 = new i();
        i0.k(context0);
        i0.m(colorStateList0);
        i0.l(f2);
        i0.setShapeAppearanceModel(o0);
        h h0 = i0.a;
        if(h0.g == null) {
            h0.g = new Rect();
        }
        i0.a.g.set(0, v, 0, v);
        i0.invalidateSelf();
        return i0;
    }

    public final int g(int v, boolean z) {
        if(!z && this.getPrefixText() != null) {
            return this.b.a() + v;
        }
        return !z || this.getSuffixText() == null ? this.d.getCompoundPaddingLeft() + v : this.c.c() + v;
    }

    @Override  // android.widget.LinearLayout
    public int getBaseline() {
        EditText editText0 = this.d;
        if(editText0 != null) {
            int v = editText0.getBaseline();
            int v1 = this.getPaddingTop();
            return this.c() + (v1 + v);
        }
        return super.getBaseline();
    }

    public i getBoxBackground() {
        if(this.n0 != 1 && this.n0 != 2) {
            throw new IllegalStateException();
        }
        return this.e0;
    }

    public int getBoxBackgroundColor() {
        return this.t0;
    }

    public int getBoxBackgroundMode() {
        return this.n0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.o0;
    }

    // 去混淆评级： 低(20)
    public float getBoxCornerRadiusBottomEnd() {
        return B.l(this) ? this.k0.h.a(this.w0) : this.k0.g.a(this.w0);
    }

    // 去混淆评级： 低(20)
    public float getBoxCornerRadiusBottomStart() {
        return B.l(this) ? this.k0.g.a(this.w0) : this.k0.h.a(this.w0);
    }

    // 去混淆评级： 低(20)
    public float getBoxCornerRadiusTopEnd() {
        return B.l(this) ? this.k0.e.a(this.w0) : this.k0.f.a(this.w0);
    }

    // 去混淆评级： 低(20)
    public float getBoxCornerRadiusTopStart() {
        return B.l(this) ? this.k0.f.a(this.w0) : this.k0.e.a(this.w0);
    }

    public int getBoxStrokeColor() {
        return this.I0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.J0;
    }

    public int getBoxStrokeWidth() {
        return this.q0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.r0;
    }

    public int getCounterMaxLength() {
        return this.l;
    }

    public CharSequence getCounterOverflowDescription() {
        if(this.k && this.m) {
            return this.o == null ? null : this.o.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.T;
    }

    public ColorStateList getCounterTextColor() {
        return this.S;
    }

    public ColorStateList getCursorColor() {
        return this.V;
    }

    public ColorStateList getCursorErrorColor() {
        return this.W;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.E0;
    }

    public EditText getEditText() {
        return this.d;
    }

    private Drawable getEditTextBoxBackground() {
        if(this.d instanceof AutoCompleteTextView && !E9.w.D(this.d)) {
            int v = n.q(this.d, 0x7F040167);  // attr:colorControlHighlight
            int v1 = this.n0;
            int[][] arr2_v = TextInputLayout.Y0;
            if(v1 == 2) {
                Context context0 = this.getContext();
                i i0 = this.e0;
                int v2 = n.p(context0, 0x7F040190, "TextInputLayout");  // attr:colorSurface
                i i1 = new i(i0.a.a);
                int v3 = n.A(0.1f, v, v2);
                i1.m(new ColorStateList(arr2_v, new int[]{v3, 0}));
                i1.setTint(v2);
                ColorStateList colorStateList0 = new ColorStateList(arr2_v, new int[]{v3, v2});
                i i2 = new i(i0.a.a);
                i2.setTint(-1);
                return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList0, i1, i2), i0});
            }
            if(v1 == 1) {
                i i3 = this.e0;
                int v4 = this.t0;
                return new RippleDrawable(new ColorStateList(arr2_v, new int[]{n.A(0.1f, v, v4), v4}), i3, i3);
            }
            return null;
        }
        return this.e0;
    }

    public CharSequence getEndIconContentDescription() {
        return this.c.g.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.c.g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.c.m;
    }

    public int getEndIconMode() {
        return this.c.i;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.c.n;
    }

    public CheckableImageButton getEndIconView() {
        return this.c.g;
    }

    // 去混淆评级： 低(20)
    public CharSequence getError() {
        return this.j.q ? this.j.p : null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.j.t;
    }

    public CharSequence getErrorContentDescription() {
        return this.j.s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView0 = this.j.r;
        return appCompatTextView0 == null ? -1 : appCompatTextView0.getCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.c.c.getDrawable();
    }

    // 去混淆评级： 低(20)
    public CharSequence getHelperText() {
        return this.j.x ? this.j.w : null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView0 = this.j.y;
        return appCompatTextView0 == null ? -1 : appCompatTextView0.getCurrentTextColor();
    }

    // 去混淆评级： 低(20)
    public CharSequence getHint() {
        return this.b0 ? this.c0 : null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.R0.e();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.R0.f(this.R0.o);
    }

    public ColorStateList getHintTextColor() {
        return this.F0;
    }

    public v getLengthCounter() {
        return this.n;
    }

    public int getMaxEms() {
        return this.g;
    }

    public int getMaxWidth() {
        return this.i;
    }

    public int getMinEms() {
        return this.f;
    }

    public int getMinWidth() {
        return this.h;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if(this.g0 == null) {
            StateListDrawable stateListDrawable0 = new StateListDrawable();
            this.g0 = stateListDrawable0;
            Drawable drawable0 = this.getOrCreateOutlinedDropDownMenuBackground();
            stateListDrawable0.addState(new int[]{0x10100AA}, drawable0);
            StateListDrawable stateListDrawable1 = this.g0;
            i i0 = this.f(false);
            stateListDrawable1.addState(new int[0], i0);
        }
        return this.g0;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if(this.f0 == null) {
            this.f0 = this.f(true);
        }
        return this.f0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.c.g.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.c.g.getDrawable();
    }

    // 去混淆评级： 低(20)
    public CharSequence getPlaceholderText() {
        return this.D ? this.B : null;
    }

    public int getPlaceholderTextAppearance() {
        return this.I;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.G;
    }

    public CharSequence getPrefixText() {
        return this.b.c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.b.b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.b.b;
    }

    public z6.o getShapeAppearanceModel() {
        return this.k0;
    }

    public CharSequence getStartIconContentDescription() {
        return this.b.d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.b.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.b.g;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.b.h;
    }

    public CharSequence getSuffixText() {
        return this.c.r;
    }

    public ColorStateList getSuffixTextColor() {
        return this.c.w.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.c.w;
    }

    public Typeface getTypeface() {
        return this.x0;
    }

    public final int h(int v, boolean z) {
        if(!z && this.getSuffixText() != null) {
            return v - this.c.c();
        }
        return !z || this.getPrefixText() == null ? v - this.d.getCompoundPaddingRight() : v - this.b.a();
    }

    public final void i() {
        switch(this.n0) {
            case 0: {
                this.e0 = null;
                this.i0 = null;
                this.j0 = null;
                break;
            }
            case 1: {
                this.e0 = new i(this.k0);
                this.i0 = new i();
                this.j0 = new i();
                break;
            }
            case 2: {
                if(!this.b0 || this.e0 instanceof f) {
                    this.e0 = new i(this.k0);
                }
                else {
                    e e0 = new e((this.k0 == null ? new z6.o() : this.k0), new RectF());
                    f f0 = new f(e0);  // 初始化器: Lz6/i;-><init>(Lz6/h;)V
                    f0.S = e0;
                    this.e0 = f0;
                }
                this.i0 = null;
                this.j0 = null;
                break;
            }
            default: {
                StringBuilder stringBuilder0 = new StringBuilder();
                throw new IllegalArgumentException(x.g(this.n0, " is illegal; only @BoxBackgroundMode constants are supported.", stringBuilder0));
            }
        }
        this.s();
        this.x();
        if(this.n0 == 1) {
            if(this.getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.o0 = this.getResources().getDimensionPixelSize(0x7F0702E9);  // dimen:material_font_2_0_box_collapsed_padding_top
            }
            else if(n.y(this.getContext())) {
                this.o0 = this.getResources().getDimensionPixelSize(0x7F0702E8);  // dimen:material_font_1_3_box_collapsed_padding_top
            }
        }
        if(this.d != null && this.n0 == 1) {
            if(this.getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.d.setPaddingRelative(this.d.getPaddingStart(), this.getResources().getDimensionPixelSize(0x7F0702E7), this.d.getPaddingEnd(), this.getResources().getDimensionPixelSize(0x7F0702E6));  // dimen:material_filled_edittext_font_2_0_padding_top
            }
            else if(n.y(this.getContext())) {
                this.d.setPaddingRelative(this.d.getPaddingStart(), this.getResources().getDimensionPixelSize(0x7F0702E5), this.d.getPaddingEnd(), this.getResources().getDimensionPixelSize(0x7F0702E4));  // dimen:material_filled_edittext_font_1_3_padding_top
            }
        }
        if(this.n0 != 0) {
            this.t();
        }
        EditText editText0 = this.d;
        if(editText0 instanceof AutoCompleteTextView && ((AutoCompleteTextView)editText0).getDropDownBackground() == null) {
            int v = this.n0;
            if(v == 2) {
                ((AutoCompleteTextView)editText0).setDropDownBackgroundDrawable(this.getOrCreateOutlinedDropDownMenuBackground());
                return;
            }
            if(v == 1) {
                ((AutoCompleteTextView)editText0).setDropDownBackgroundDrawable(this.getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    public final void j() {
        float f2;
        float f;
        if(this.e()) {
            int v = this.d.getWidth();
            int v1 = this.d.getGravity();
            c c0 = this.R0;
            boolean z = c0.b(c0.G);
            c0.I = z;
            Rect rect0 = c0.h;
            if(v1 == 17 || (v1 & 7) == 1) {
                f = ((float)v) / 2.0f - c0.j0 / 2.0f;
            }
            else if((v1 & 0x800005) == 0x800005 || (v1 & 5) == 5) {
                f = z ? ((float)rect0.left) : ((float)rect0.right) - c0.j0;
            }
            else if(z) {
                f = ((float)rect0.right) - c0.j0;
            }
            else {
                f = (float)rect0.left;
            }
            float f1 = Math.max(f, rect0.left);
            RectF rectF0 = this.w0;
            rectF0.left = f1;
            rectF0.top = (float)rect0.top;
            if(v1 == 17 || (v1 & 7) == 1) {
                f2 = ((float)v) / 2.0f + c0.j0 / 2.0f;
            }
            else if((v1 & 0x800005) == 0x800005 || (v1 & 5) == 5) {
                f2 = c0.I ? c0.j0 + f1 : ((float)rect0.right);
            }
            else if(c0.I) {
                f2 = (float)rect0.right;
            }
            else {
                f2 = c0.j0 + f1;
            }
            rectF0.right = Math.min(f2, rect0.right);
            float f3 = (float)rect0.top;
            rectF0.bottom = c0.e() + f3;
            if(rectF0.width() > 0.0f && rectF0.height() > 0.0f) {
                rectF0.left -= (float)this.m0;
                rectF0.right += (float)this.m0;
                rectF0.offset(((float)(-this.getPaddingLeft())), ((float)(-this.getPaddingTop())) - rectF0.height() / 2.0f + ((float)this.p0));
                f f4 = (f)this.e0;
                f4.getClass();
                f4.w(rectF0.left, rectF0.top, rectF0.right, rectF0.bottom);
            }
        }
    }

    public static void k(ViewGroup viewGroup0, boolean z) {
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            view0.setEnabled(z);
            if(view0 instanceof ViewGroup) {
                TextInputLayout.k(((ViewGroup)view0), z);
            }
        }
    }

    public final void l(AppCompatTextView appCompatTextView0, int v) {
        try {
            appCompatTextView0.setTextAppearance(v);
            if(appCompatTextView0.getTextColors().getDefaultColor() != 0xFFFF00FF) {
                return;
            }
        }
        catch(Exception unused_ex) {
        }
        appCompatTextView0.setTextAppearance(0x7F140207);  // style:TextAppearance.AppCompat.Caption
        appCompatTextView0.setTextColor(P1.c.getColor(this.getContext(), 0x7F0600E7));  // color:design_error
    }

    public final boolean m() {
        return this.j.o == 1 && this.j.r != null && !TextUtils.isEmpty(this.j.p);
    }

    public final void n(Editable editable0) {
        ((com.google.android.exoplayer2.upstream.cache.a)this.n).getClass();
        int v = editable0 == null ? 0 : editable0.length();
        boolean z = this.m;
        int v1 = this.l;
        String s = null;
        if(v1 == -1) {
            this.o.setText(String.valueOf(v));
            this.o.setContentDescription(null);
            this.m = false;
        }
        else {
            this.m = v > v1;
            Context context0 = this.getContext();
            this.o.setContentDescription(context0.getString((this.m ? 0x7F1301CF : 0x7F1301CE), new Object[]{v, this.l}));  // string:character_counter_overflowed_content_description "Character limit exceeded 
                                                                                                                            // %1$d of %2$d"
            if(z != this.m) {
                this.o();
            }
            a2.b b0 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? a2.b.e : a2.b.d;
            AppCompatTextView appCompatTextView0 = this.o;
            String s1 = this.getContext().getString(0x7F1301D0, new Object[]{v, this.l});  // string:character_counter_pattern "%1$d/%2$d"
            b0.getClass();
            if(s1 != null) {
                s = b0.c(s1).toString();
            }
            appCompatTextView0.setText(s);
        }
        if(this.d != null && z != this.m) {
            this.u(false, false);
            this.x();
            this.r();
        }
    }

    public final void o() {
        AppCompatTextView appCompatTextView0 = this.o;
        if(appCompatTextView0 != null) {
            this.l(appCompatTextView0, (this.m ? this.r : this.w));
            if(!this.m) {
                ColorStateList colorStateList0 = this.S;
                if(colorStateList0 != null) {
                    this.o.setTextColor(colorStateList0);
                }
            }
            if(this.m) {
                ColorStateList colorStateList1 = this.T;
                if(colorStateList1 != null) {
                    this.o.setTextColor(colorStateList1);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.R0.h(configuration0);
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        k k0 = this.c;
        k0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.X0 = false;
        if(this.d != null) {
            int v = Math.max(k0.getMeasuredHeight(), this.b.getMeasuredHeight());
            if(this.d.getMeasuredHeight() < v) {
                this.d.setMinimumHeight(v);
                z = true;
            }
        }
        if(!z && !this.q()) {
            return;
        }
        this.d.post(new com.facebook.appevents.c(this, 17));
    }

    @Override  // android.widget.LinearLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        EditText editText0 = this.d;
        if(editText0 != null) {
            Rect rect0 = this.u0;
            d.a(this, editText0, rect0);
            i i0 = this.i0;
            if(i0 != null) {
                i0.setBounds(rect0.left, rect0.bottom - this.q0, rect0.right, rect0.bottom);
            }
            i i1 = this.j0;
            if(i1 != null) {
                i1.setBounds(rect0.left, rect0.bottom - this.r0, rect0.right, rect0.bottom);
            }
            if(this.b0) {
                float f = this.d.getTextSize();
                c c0 = this.R0;
                if(Float.compare(c0.l, f) != 0) {
                    c0.l = f;
                    c0.i(false);
                }
                int v4 = this.d.getGravity();
                c0.l(v4 & 0xFFFFFF8F | 0x30);
                if(c0.j != v4) {
                    c0.j = v4;
                    c0.i(false);
                }
                if(this.d == null) {
                    throw new IllegalStateException();
                }
                boolean z1 = B.l(this);
                Rect rect1 = this.v0;
                rect1.bottom = rect0.bottom;
                switch(this.n0) {
                    case 1: {
                        rect1.left = this.g(rect0.left, z1);
                        rect1.top = rect0.top + this.o0;
                        rect1.right = this.h(rect0.right, z1);
                        break;
                    }
                    case 2: {
                        int v5 = rect0.left;
                        rect1.left = this.d.getPaddingLeft() + v5;
                        rect1.top = rect0.top - this.c();
                        rect1.right = rect0.right - this.d.getPaddingRight();
                        break;
                    }
                    default: {
                        rect1.left = this.g(rect0.left, z1);
                        rect1.top = this.getPaddingTop();
                        rect1.right = this.h(rect0.right, z1);
                    }
                }
                int v6 = rect1.left;
                int v7 = rect1.top;
                int v8 = rect1.right;
                int v9 = rect1.bottom;
                Rect rect2 = c0.h;
                if(rect2.left != v6 || rect2.top != v7 || rect2.right != v8 || rect2.bottom != v9) {
                    rect2.set(v6, v7, v8, v9);
                    c0.S = true;
                }
                if(this.d == null) {
                    throw new IllegalStateException();
                }
                c0.U.setTextSize(c0.l);
                c0.U.setTypeface(c0.z);
                c0.U.setLetterSpacing(c0.g0);
                float f1 = c0.U.ascent();
                int v10 = rect0.left;
                rect1.left = this.d.getCompoundPaddingLeft() + v10;
                rect1.top = this.n0 != 1 || this.d.getMinLines() > 1 ? rect0.top + this.d.getCompoundPaddingTop() : ((int)(((float)rect0.centerY()) - -f1 / 2.0f));
                rect1.right = rect0.right - this.d.getCompoundPaddingRight();
                int v11 = this.n0 != 1 || this.d.getMinLines() > 1 ? rect0.bottom - this.d.getCompoundPaddingBottom() : ((int)(((float)rect1.top) + -f1));
                rect1.bottom = v11;
                int v12 = rect1.left;
                int v13 = rect1.top;
                int v14 = rect1.right;
                Rect rect3 = c0.g;
                if(rect3.left != v12 || rect3.top != v13 || rect3.right != v14 || rect3.bottom != v11) {
                    rect3.set(v12, v13, v14, v11);
                    c0.S = true;
                }
                c0.i(false);
                if(this.e() && !this.Q0) {
                    this.j();
                }
            }
        }
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        k k0 = this.c;
        if(!this.X0) {
            k0.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.X0 = true;
        }
        if(this.E != null) {
            EditText editText0 = this.d;
            if(editText0 != null) {
                int v2 = editText0.getGravity();
                this.E.setGravity(v2);
                this.E.setPadding(this.d.getCompoundPaddingLeft(), this.d.getCompoundPaddingTop(), this.d.getCompoundPaddingRight(), this.d.getCompoundPaddingBottom());
            }
        }
        k0.m();
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.setError(((SavedState)parcelable0).c);
        if(((SavedState)parcelable0).d) {
            this.post(new t(this, 14));
        }
        this.requestLayout();
    }

    @Override  // android.widget.LinearLayout
    public final void onRtlPropertiesChanged(int v) {
        super.onRtlPropertiesChanged(v);
        if(v == 1 != this.l0) {
            float f = this.k0.e.a(this.w0);
            float f1 = this.k0.f.a(this.w0);
            float f2 = this.k0.h.a(this.w0);
            float f3 = this.k0.g.a(this.w0);
            g g0 = this.k0.a;
            g g1 = this.k0.b;
            g g2 = this.k0.d;
            g g3 = this.k0.c;
            z6.f f4 = new z6.f(0);
            z6.f f5 = new z6.f(0);
            z6.f f6 = new z6.f(0);
            z6.f f7 = new z6.f(0);
            z6.m.b(g1);
            z6.m.b(g0);
            z6.m.b(g3);
            z6.m.b(g2);
            z6.a a0 = new z6.a(f1);
            z6.a a1 = new z6.a(f);
            z6.a a2 = new z6.a(f3);
            z6.a a3 = new z6.a(f2);
            z6.o o0 = new z6.o();  // 初始化器: Ljava/lang/Object;-><init>()V
            o0.a = g1;
            o0.b = g0;
            o0.c = g2;
            o0.d = g3;
            o0.e = a0;
            o0.f = a1;
            o0.g = a3;
            o0.h = a2;
            o0.i = f4;
            o0.j = f5;
            o0.k = f6;
            o0.l = f7;
            this.l0 = v == 1;
            this.setShapeAppearanceModel(o0);
        }
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        if(this.m()) {
            parcelable0.c = this.getError();
        }
        parcelable0.d = this.c.i != 0 && this.c.g.d;
        return parcelable0;
    }

    public final void p() {
        ColorStateList colorStateList0 = this.V;
        if(colorStateList0 == null) {
            Context context0 = this.getContext();
            TypedValue typedValue0 = e1.m.y(context0, 0x7F040166);  // attr:colorControlActivated
            if(typedValue0 == null) {
                colorStateList0 = null;
            }
            else {
                int v = typedValue0.resourceId;
                if(v == 0) {
                    int v1 = typedValue0.data;
                    colorStateList0 = v1 == 0 ? null : ColorStateList.valueOf(v1);
                }
                else {
                    colorStateList0 = P1.c.getColorStateList(context0, v);
                }
            }
        }
        if(this.d != null && this.d.getTextCursorDrawable() != null) {
            Drawable drawable0 = this.d.getTextCursorDrawable().mutate();
            if(this.m() || this.o != null && this.m) {
                ColorStateList colorStateList1 = this.W;
                if(colorStateList1 != null) {
                    colorStateList0 = colorStateList1;
                }
            }
            drawable0.setTintList(colorStateList0);
        }
    }

    public final boolean q() {
        boolean z1;
        if(this.d == null) {
            return false;
        }
        CheckableImageButton checkableImageButton0 = null;
        boolean z = true;
        if(this.getStartIconDrawable() == null && (this.getPrefixText() == null || this.getPrefixTextView().getVisibility() != 0)) {
        label_21:
            if(this.y0 == null) {
                z1 = false;
            }
            else {
                Drawable[] arr_drawable1 = this.d.getCompoundDrawablesRelative();
                this.d.setCompoundDrawablesRelative(null, arr_drawable1[1], arr_drawable1[2], arr_drawable1[3]);
                this.y0 = null;
                z1 = true;
            }
        }
        else {
            s s0 = this.b;
            if(s0.getMeasuredWidth() > 0) {
                int v = s0.getMeasuredWidth() - this.d.getPaddingLeft();
                if(this.y0 == null || this.z0 != v) {
                    ColorDrawable colorDrawable0 = new ColorDrawable();
                    this.y0 = colorDrawable0;
                    this.z0 = v;
                    colorDrawable0.setBounds(0, 0, v, 1);
                }
                Drawable[] arr_drawable = this.d.getCompoundDrawablesRelative();
                ColorDrawable colorDrawable1 = this.y0;
                if(arr_drawable[0] == colorDrawable1) {
                    z1 = false;
                }
                else {
                    this.d.setCompoundDrawablesRelative(colorDrawable1, arr_drawable[1], arr_drawable[2], arr_drawable[3]);
                    z1 = true;
                }
            }
            else {
                goto label_21;
            }
        }
        k k0 = this.c;
        if((k0.e() || k0.i != 0 && k0.d() || k0.r != null) && k0.getMeasuredWidth() > 0) {
            int v1 = k0.w.getMeasuredWidth() - this.d.getPaddingRight();
            if(k0.e()) {
                checkableImageButton0 = k0.c;
            }
            else if(k0.i != 0 && k0.d()) {
                checkableImageButton0 = k0.g;
            }
            if(checkableImageButton0 != null) {
                int v2 = checkableImageButton0.getMeasuredWidth();
                v1 = ((ViewGroup.MarginLayoutParams)checkableImageButton0.getLayoutParams()).getMarginStart() + (v2 + v1);
            }
            Drawable[] arr_drawable2 = this.d.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable2 = this.B0;
            if(colorDrawable2 != null && this.C0 != v1) {
                this.C0 = v1;
                colorDrawable2.setBounds(0, 0, v1, 1);
                this.d.setCompoundDrawablesRelative(arr_drawable2[0], arr_drawable2[1], this.B0, arr_drawable2[3]);
                return true;
            }
            if(colorDrawable2 == null) {
                ColorDrawable colorDrawable3 = new ColorDrawable();
                this.B0 = colorDrawable3;
                this.C0 = v1;
                colorDrawable3.setBounds(0, 0, v1, 1);
            }
            Drawable drawable0 = arr_drawable2[2];
            ColorDrawable colorDrawable4 = this.B0;
            if(drawable0 != colorDrawable4) {
                this.D0 = drawable0;
                this.d.setCompoundDrawablesRelative(arr_drawable2[0], arr_drawable2[1], colorDrawable4, arr_drawable2[3]);
                return true;
            }
        }
        else if(this.B0 != null) {
            Drawable[] arr_drawable3 = this.d.getCompoundDrawablesRelative();
            if(arr_drawable3[2] == this.B0) {
                this.d.setCompoundDrawablesRelative(arr_drawable3[0], arr_drawable3[1], this.D0, arr_drawable3[3]);
            }
            else {
                z = z1;
            }
            this.B0 = null;
            return z;
        }
        return z1;
    }

    public final void r() {
        EditText editText0 = this.d;
        if(editText0 != null && this.n0 == 0) {
            Drawable drawable0 = editText0.getBackground();
            if(drawable0 != null) {
                Drawable drawable1 = drawable0.mutate();
                if(this.m()) {
                    drawable1.setColorFilter(androidx.appcompat.widget.x.c(this.getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
                    return;
                }
                if(this.m) {
                    AppCompatTextView appCompatTextView0 = this.o;
                    if(appCompatTextView0 != null) {
                        drawable1.setColorFilter(androidx.appcompat.widget.x.c(appCompatTextView0.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
                        return;
                    }
                }
                drawable1.clearColorFilter();
                this.d.refreshDrawableState();
            }
        }
    }

    public final void s() {
        if(this.d != null && this.e0 != null && (this.h0 || this.d.getBackground() == null) && this.n0 != 0) {
            Drawable drawable0 = this.getEditTextBoxBackground();
            this.d.setBackground(drawable0);
            this.h0 = true;
        }
    }

    public void setBoxBackgroundColor(int v) {
        if(this.t0 != v) {
            this.t0 = v;
            this.K0 = v;
            this.M0 = v;
            this.N0 = v;
            this.b();
        }
    }

    public void setBoxBackgroundColorResource(int v) {
        this.setBoxBackgroundColor(P1.c.getColor(this.getContext(), v));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList0) {
        int v = colorStateList0.getDefaultColor();
        this.K0 = v;
        this.t0 = v;
        this.L0 = colorStateList0.getColorForState(new int[]{0xFEFEFF62}, -1);
        this.M0 = colorStateList0.getColorForState(new int[]{0x101009C, 0x101009E}, -1);
        this.N0 = colorStateList0.getColorForState(new int[]{0x1010367, 0x101009E}, -1);
        this.b();
    }

    public void setBoxBackgroundMode(int v) {
        if(v != this.n0) {
            this.n0 = v;
            if(this.d != null) {
                this.i();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int v) {
        this.o0 = v;
    }

    public void setBoxCornerFamily(int v) {
        z6.m m0 = this.k0.g();
        z6.d d0 = this.k0.e;
        g g0 = d5.n.s(v);
        m0.a = g0;
        z6.m.b(g0);
        m0.e = d0;
        z6.d d1 = this.k0.f;
        g g1 = d5.n.s(v);
        m0.b = g1;
        z6.m.b(g1);
        m0.f = d1;
        z6.d d2 = this.k0.h;
        g g2 = d5.n.s(v);
        m0.d = g2;
        z6.m.b(g2);
        m0.h = d2;
        z6.d d3 = this.k0.g;
        g g3 = d5.n.s(v);
        m0.c = g3;
        z6.m.b(g3);
        m0.g = d3;
        this.k0 = m0.a();
        this.b();
    }

    public void setBoxStrokeColor(int v) {
        if(this.I0 != v) {
            this.I0 = v;
            this.x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList0) {
        if(colorStateList0.isStateful()) {
            this.G0 = colorStateList0.getDefaultColor();
            this.O0 = colorStateList0.getColorForState(new int[]{0xFEFEFF62}, -1);
            this.H0 = colorStateList0.getColorForState(new int[]{0x1010367, 0x101009E}, -1);
            this.I0 = colorStateList0.getColorForState(new int[]{0x101009C, 0x101009E}, -1);
        }
        else if(this.I0 != colorStateList0.getDefaultColor()) {
            this.I0 = colorStateList0.getDefaultColor();
        }
        this.x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList0) {
        if(this.J0 != colorStateList0) {
            this.J0 = colorStateList0;
            this.x();
        }
    }

    public void setBoxStrokeWidth(int v) {
        this.q0 = v;
        this.x();
    }

    public void setBoxStrokeWidthFocused(int v) {
        this.r0 = v;
        this.x();
    }

    public void setBoxStrokeWidthFocusedResource(int v) {
        this.setBoxStrokeWidthFocused(this.getResources().getDimensionPixelSize(v));
    }

    public void setBoxStrokeWidthResource(int v) {
        this.setBoxStrokeWidth(this.getResources().getDimensionPixelSize(v));
    }

    public void setCounterEnabled(boolean z) {
        if(this.k != z) {
            Editable editable0 = null;
            o o0 = this.j;
            if(z) {
                AppCompatTextView appCompatTextView0 = new AppCompatTextView(this.getContext());
                this.o = appCompatTextView0;
                appCompatTextView0.setId(0x7F0A0B62);  // id:textinput_counter
                Typeface typeface0 = this.x0;
                if(typeface0 != null) {
                    this.o.setTypeface(typeface0);
                }
                this.o.setMaxLines(1);
                o0.a(this.o, 2);
                ((ViewGroup.MarginLayoutParams)this.o.getLayoutParams()).setMarginStart(this.getResources().getDimensionPixelOffset(0x7F0703E2));  // dimen:mtrl_textinput_counter_margin_start
                this.o();
                if(this.o != null) {
                    EditText editText0 = this.d;
                    if(editText0 != null) {
                        editable0 = editText0.getText();
                    }
                    this.n(editable0);
                }
            }
            else {
                o0.g(this.o, 2);
                this.o = null;
            }
            this.k = z;
        }
    }

    public void setCounterMaxLength(int v) {
        if(this.l != v) {
            this.l = v > 0 ? v : -1;
            if(this.k && this.o != null) {
                this.n((this.d == null ? null : this.d.getText()));
            }
        }
    }

    public void setCounterOverflowTextAppearance(int v) {
        if(this.r != v) {
            this.r = v;
            this.o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList0) {
        if(this.T != colorStateList0) {
            this.T = colorStateList0;
            this.o();
        }
    }

    public void setCounterTextAppearance(int v) {
        if(this.w != v) {
            this.w = v;
            this.o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList0) {
        if(this.S != colorStateList0) {
            this.S = colorStateList0;
            this.o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList0) {
        if(this.V != colorStateList0) {
            this.V = colorStateList0;
            this.p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList0) {
        if(this.W != colorStateList0) {
            this.W = colorStateList0;
            if(!this.m() && (this.o == null || !this.m)) {
                return;
            }
            this.p();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList0) {
        this.E0 = colorStateList0;
        this.F0 = colorStateList0;
        if(this.d != null) {
            this.u(false, false);
        }
    }

    private void setEditText(EditText editText0) {
        if(this.d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if(this.getEndIconMode() != 3 && !(editText0 instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.d = editText0;
        int v = this.f;
        if(v == -1) {
            this.setMinWidth(this.h);
        }
        else {
            this.setMinEms(v);
        }
        int v1 = this.g;
        if(v1 == -1) {
            this.setMaxWidth(this.i);
        }
        else {
            this.setMaxEms(v1);
        }
        this.h0 = false;
        this.i();
        this.setTextInputAccessibilityDelegate(new u(this));
        Typeface typeface0 = this.d.getTypeface();
        c c0 = this.R0;
        if(c0.m(typeface0) || c0.o(typeface0)) {
            c0.i(false);
        }
        float f = this.d.getTextSize();
        if(c0.l != f) {
            c0.l = f;
            c0.i(false);
        }
        int v2 = Build.VERSION.SDK_INT;
        float f1 = this.d.getLetterSpacing();
        if(c0.g0 != f1) {
            c0.g0 = f1;
            c0.i(false);
        }
        int v3 = this.d.getGravity();
        c0.l(v3 & 0xFFFFFF8F | 0x30);
        if(c0.j != v3) {
            c0.j = v3;
            c0.i(false);
        }
        this.P0 = editText0.getMinimumHeight();
        this.d.addTextChangedListener(new com.google.android.material.textfield.t(this, editText0));
        if(this.E0 == null) {
            this.E0 = this.d.getHintTextColors();
        }
        if(this.b0) {
            if(TextUtils.isEmpty(this.c0)) {
                CharSequence charSequence0 = this.d.getHint();
                this.e = charSequence0;
                this.setHint(charSequence0);
                this.d.setHint(null);
            }
            this.d0 = true;
        }
        if(v2 >= 29) {
            this.p();
        }
        if(this.o != null) {
            this.n(this.d.getText());
        }
        this.r();
        this.j.b();
        this.b.bringToFront();
        k k0 = this.c;
        k0.bringToFront();
        for(Object object0: this.A0) {
            ((j)object0).a(this);
        }
        k0.m();
        if(!this.isEnabled()) {
            editText0.setEnabled(false);
        }
        this.u(false, true);
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        TextInputLayout.k(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.c.g.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.c.g.setCheckable(z);
    }

    public void setEndIconContentDescription(int v) {
        CharSequence charSequence0 = v == 0 ? null : this.c.getResources().getText(v);
        CheckableImageButton checkableImageButton0 = this.c.g;
        if(checkableImageButton0.getContentDescription() != charSequence0) {
            checkableImageButton0.setContentDescription(charSequence0);
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence0) {
        CheckableImageButton checkableImageButton0 = this.c.g;
        if(checkableImageButton0.getContentDescription() != charSequence0) {
            checkableImageButton0.setContentDescription(charSequence0);
        }
    }

    public void setEndIconDrawable(int v) {
        k k0 = this.c;
        Drawable drawable0 = v == 0 ? null : d5.w.B(k0.getContext(), v);
        TextInputLayout textInputLayout0 = k0.a;
        CheckableImageButton checkableImageButton0 = k0.g;
        checkableImageButton0.setImageDrawable(drawable0);
        if(drawable0 != null) {
            H0.e.v(textInputLayout0, checkableImageButton0, k0.k, k0.l);
            H0.e.S(textInputLayout0, checkableImageButton0, k0.k);
        }
    }

    public void setEndIconDrawable(Drawable drawable0) {
        k k0 = this.c;
        TextInputLayout textInputLayout0 = k0.a;
        CheckableImageButton checkableImageButton0 = k0.g;
        checkableImageButton0.setImageDrawable(drawable0);
        if(drawable0 != null) {
            H0.e.v(textInputLayout0, checkableImageButton0, k0.k, k0.l);
            H0.e.S(textInputLayout0, checkableImageButton0, k0.k);
        }
    }

    public void setEndIconMinSize(int v) {
        k k0 = this.c;
        if(v >= 0) {
            if(v != k0.m) {
                k0.m = v;
                k0.g.setMinimumWidth(v);
                k0.g.setMinimumHeight(v);
                k0.c.setMinimumWidth(v);
                k0.c.setMinimumHeight(v);
            }
            return;
        }
        k0.getClass();
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public void setEndIconMode(int v) {
        this.c.g(v);
    }

    public void setEndIconOnClickListener(View.OnClickListener view$OnClickListener0) {
        View.OnLongClickListener view$OnLongClickListener0 = this.c.o;
        this.c.g.setOnClickListener(view$OnClickListener0);
        H0.e.X(this.c.g, view$OnLongClickListener0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener0) {
        this.c.o = view$OnLongClickListener0;
        this.c.g.setOnLongClickListener(view$OnLongClickListener0);
        H0.e.X(this.c.g, view$OnLongClickListener0);
    }

    public void setEndIconScaleType(ImageView.ScaleType imageView$ScaleType0) {
        this.c.n = imageView$ScaleType0;
        this.c.g.setScaleType(imageView$ScaleType0);
        this.c.c.setScaleType(imageView$ScaleType0);
    }

    public void setEndIconTintList(ColorStateList colorStateList0) {
        k k0 = this.c;
        if(k0.k != colorStateList0) {
            k0.k = colorStateList0;
            H0.e.v(k0.a, k0.g, colorStateList0, k0.l);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        k k0 = this.c;
        if(k0.l != porterDuff$Mode0) {
            k0.l = porterDuff$Mode0;
            H0.e.v(k0.a, k0.g, k0.k, porterDuff$Mode0);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.c.h(z);
    }

    public void setError(CharSequence charSequence0) {
        o o0 = this.j;
        if(!o0.q) {
            if(TextUtils.isEmpty(charSequence0)) {
                return;
            }
            this.setErrorEnabled(true);
        }
        if(!TextUtils.isEmpty(charSequence0)) {
            o0.c();
            o0.p = charSequence0;
            o0.r.setText(charSequence0);
            int v = o0.n;
            if(v != 1) {
                o0.o = 1;
            }
            o0.i(v, o0.o, o0.h(o0.r, charSequence0));
            return;
        }
        o0.f();
    }

    public void setErrorAccessibilityLiveRegion(int v) {
        this.j.t = v;
        AppCompatTextView appCompatTextView0 = this.j.r;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setAccessibilityLiveRegion(v);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence0) {
        this.j.s = charSequence0;
        AppCompatTextView appCompatTextView0 = this.j.r;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setContentDescription(charSequence0);
        }
    }

    public void setErrorEnabled(boolean z) {
        o o0 = this.j;
        TextInputLayout textInputLayout0 = o0.h;
        if(o0.q == z) {
            return;
        }
        o0.c();
        if(z) {
            AppCompatTextView appCompatTextView0 = new AppCompatTextView(o0.g);
            o0.r = appCompatTextView0;
            appCompatTextView0.setId(0x7F0A0B63);  // id:textinput_error
            o0.r.setTextAlignment(5);
            Typeface typeface0 = o0.B;
            if(typeface0 != null) {
                o0.r.setTypeface(typeface0);
            }
            int v = o0.u;
            o0.u = v;
            AppCompatTextView appCompatTextView1 = o0.r;
            if(appCompatTextView1 != null) {
                o0.h.l(appCompatTextView1, v);
            }
            ColorStateList colorStateList0 = o0.v;
            o0.v = colorStateList0;
            AppCompatTextView appCompatTextView2 = o0.r;
            if(appCompatTextView2 != null && colorStateList0 != null) {
                appCompatTextView2.setTextColor(colorStateList0);
            }
            CharSequence charSequence0 = o0.s;
            o0.s = charSequence0;
            AppCompatTextView appCompatTextView3 = o0.r;
            if(appCompatTextView3 != null) {
                appCompatTextView3.setContentDescription(charSequence0);
            }
            int v1 = o0.t;
            o0.t = v1;
            AppCompatTextView appCompatTextView4 = o0.r;
            if(appCompatTextView4 != null) {
                appCompatTextView4.setAccessibilityLiveRegion(v1);
            }
            o0.r.setVisibility(4);
            o0.a(o0.r, 0);
        }
        else {
            o0.f();
            o0.g(o0.r, 0);
            o0.r = null;
            textInputLayout0.r();
            textInputLayout0.x();
        }
        o0.q = z;
    }

    public void setErrorIconDrawable(int v) {
        Drawable drawable0 = v == 0 ? null : d5.w.B(this.c.getContext(), v);
        this.c.i(drawable0);
        H0.e.S(this.c.a, this.c.c, this.c.d);
    }

    public void setErrorIconDrawable(Drawable drawable0) {
        this.c.i(drawable0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener view$OnClickListener0) {
        View.OnLongClickListener view$OnLongClickListener0 = this.c.f;
        this.c.c.setOnClickListener(view$OnClickListener0);
        H0.e.X(this.c.c, view$OnLongClickListener0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener0) {
        this.c.f = view$OnLongClickListener0;
        this.c.c.setOnLongClickListener(view$OnLongClickListener0);
        H0.e.X(this.c.c, view$OnLongClickListener0);
    }

    public void setErrorIconTintList(ColorStateList colorStateList0) {
        k k0 = this.c;
        if(k0.d != colorStateList0) {
            k0.d = colorStateList0;
            H0.e.v(k0.a, k0.c, colorStateList0, k0.e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        k k0 = this.c;
        if(k0.e != porterDuff$Mode0) {
            k0.e = porterDuff$Mode0;
            H0.e.v(k0.a, k0.c, k0.d, porterDuff$Mode0);
        }
    }

    public void setErrorTextAppearance(int v) {
        o o0 = this.j;
        o0.u = v;
        AppCompatTextView appCompatTextView0 = o0.r;
        if(appCompatTextView0 != null) {
            o0.h.l(appCompatTextView0, v);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList0) {
        this.j.v = colorStateList0;
        AppCompatTextView appCompatTextView0 = this.j.r;
        if(appCompatTextView0 != null && colorStateList0 != null) {
            appCompatTextView0.setTextColor(colorStateList0);
        }
    }

    public void setExpandedHintEnabled(boolean z) {
        if(this.S0 != z) {
            this.S0 = z;
            this.u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence0) {
        boolean z = TextUtils.isEmpty(charSequence0);
        o o0 = this.j;
        if(z) {
            if(o0.x) {
                this.setHelperTextEnabled(false);
            }
            return;
        }
        if(!o0.x) {
            this.setHelperTextEnabled(true);
        }
        o0.c();
        o0.w = charSequence0;
        o0.y.setText(charSequence0);
        int v = o0.n;
        if(v != 2) {
            o0.o = 2;
        }
        o0.i(v, o0.o, o0.h(o0.y, charSequence0));
    }

    public void setHelperTextColor(ColorStateList colorStateList0) {
        this.j.A = colorStateList0;
        AppCompatTextView appCompatTextView0 = this.j.y;
        if(appCompatTextView0 != null && colorStateList0 != null) {
            appCompatTextView0.setTextColor(colorStateList0);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        o o0 = this.j;
        TextInputLayout textInputLayout0 = o0.h;
        if(o0.x == z) {
            return;
        }
        o0.c();
        if(z) {
            AppCompatTextView appCompatTextView0 = new AppCompatTextView(o0.g);
            o0.y = appCompatTextView0;
            appCompatTextView0.setId(0x7F0A0B64);  // id:textinput_helper_text
            o0.y.setTextAlignment(5);
            Typeface typeface0 = o0.B;
            if(typeface0 != null) {
                o0.y.setTypeface(typeface0);
            }
            o0.y.setVisibility(4);
            o0.y.setAccessibilityLiveRegion(1);
            int v = o0.z;
            o0.z = v;
            AppCompatTextView appCompatTextView1 = o0.y;
            if(appCompatTextView1 != null) {
                appCompatTextView1.setTextAppearance(v);
            }
            ColorStateList colorStateList0 = o0.A;
            o0.A = colorStateList0;
            AppCompatTextView appCompatTextView2 = o0.y;
            if(appCompatTextView2 != null && colorStateList0 != null) {
                appCompatTextView2.setTextColor(colorStateList0);
            }
            o0.a(o0.y, 1);
            o0.y.setAccessibilityDelegate(new com.google.android.material.textfield.n(o0, 0));
        }
        else {
            o0.c();
            int v1 = o0.n;
            if(v1 == 2) {
                o0.o = 0;
            }
            o0.i(v1, o0.o, o0.h(o0.y, ""));
            o0.g(o0.y, 1);
            o0.y = null;
            textInputLayout0.r();
            textInputLayout0.x();
        }
        o0.x = z;
    }

    public void setHelperTextTextAppearance(int v) {
        this.j.z = v;
        AppCompatTextView appCompatTextView0 = this.j.y;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setTextAppearance(v);
        }
    }

    public void setHint(int v) {
        this.setHint((v == 0 ? null : this.getResources().getText(v)));
    }

    public void setHint(CharSequence charSequence0) {
        if(this.b0) {
            this.setHintInternal(charSequence0);
            this.sendAccessibilityEvent(0x800);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.T0 = z;
    }

    public void setHintEnabled(boolean z) {
        if(z != this.b0) {
            this.b0 = z;
            if(z) {
                CharSequence charSequence0 = this.d.getHint();
                if(!TextUtils.isEmpty(charSequence0)) {
                    if(TextUtils.isEmpty(this.c0)) {
                        this.setHint(charSequence0);
                    }
                    this.d.setHint(null);
                }
                this.d0 = true;
            }
            else {
                this.d0 = false;
                if(!TextUtils.isEmpty(this.c0) && TextUtils.isEmpty(this.d.getHint())) {
                    this.d.setHint(this.c0);
                }
                this.setHintInternal(null);
            }
            if(this.d != null) {
                this.t();
            }
        }
    }

    private void setHintInternal(CharSequence charSequence0) {
        if(!TextUtils.equals(charSequence0, this.c0)) {
            this.c0 = charSequence0;
            c c0 = this.R0;
            if(charSequence0 == null || !TextUtils.equals(c0.G, charSequence0)) {
                c0.G = charSequence0;
                c0.H = null;
                Bitmap bitmap0 = c0.K;
                if(bitmap0 != null) {
                    bitmap0.recycle();
                    c0.K = null;
                }
                c0.i(false);
            }
            if(!this.Q0) {
                this.j();
            }
        }
    }

    public void setHintTextAppearance(int v) {
        this.R0.k(v);
        this.F0 = this.R0.o;
        if(this.d != null) {
            this.u(false, false);
            this.t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList0) {
        if(this.F0 != colorStateList0) {
            if(this.E0 == null) {
                c c0 = this.R0;
                if(c0.o != colorStateList0) {
                    c0.o = colorStateList0;
                    c0.i(false);
                }
            }
            this.F0 = colorStateList0;
            if(this.d != null) {
                this.u(false, false);
            }
        }
    }

    public void setLengthCounter(v v0) {
        this.n = v0;
    }

    public void setMaxEms(int v) {
        this.g = v;
        EditText editText0 = this.d;
        if(editText0 != null && v != -1) {
            editText0.setMaxEms(v);
        }
    }

    public void setMaxWidth(int v) {
        this.i = v;
        EditText editText0 = this.d;
        if(editText0 != null && v != -1) {
            editText0.setMaxWidth(v);
        }
    }

    public void setMaxWidthResource(int v) {
        this.setMaxWidth(this.getContext().getResources().getDimensionPixelSize(v));
    }

    public void setMinEms(int v) {
        this.f = v;
        EditText editText0 = this.d;
        if(editText0 != null && v != -1) {
            editText0.setMinEms(v);
        }
    }

    public void setMinWidth(int v) {
        this.h = v;
        EditText editText0 = this.d;
        if(editText0 != null && v != -1) {
            editText0.setMinWidth(v);
        }
    }

    public void setMinWidthResource(int v) {
        this.setMinWidth(this.getContext().getResources().getDimensionPixelSize(v));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int v) {
        CharSequence charSequence0 = v == 0 ? null : this.c.getResources().getText(v);
        this.c.g.setContentDescription(charSequence0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence0) {
        this.c.g.setContentDescription(charSequence0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int v) {
        Drawable drawable0 = v == 0 ? null : d5.w.B(this.c.getContext(), v);
        this.c.g.setImageDrawable(drawable0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable0) {
        this.c.g.setImageDrawable(drawable0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        k k0 = this.c;
        if(z && k0.i != 1) {
            k0.g(1);
            return;
        }
        if(!z) {
            k0.g(0);
            return;
        }
        k0.getClass();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList0) {
        this.c.k = colorStateList0;
        H0.e.v(this.c.a, this.c.g, colorStateList0, this.c.l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.c.l = porterDuff$Mode0;
        H0.e.v(this.c.a, this.c.g, this.c.k, porterDuff$Mode0);
    }

    public void setPlaceholderText(CharSequence charSequence0) {
        if(this.E == null) {
            AppCompatTextView appCompatTextView0 = new AppCompatTextView(this.getContext());
            this.E = appCompatTextView0;
            appCompatTextView0.setId(0x7F0A0B65);  // id:textinput_placeholder
            this.E.setImportantForAccessibility(2);
            Fade fade0 = this.d();
            this.M = fade0;
            fade0.b = 67L;
            this.N = this.d();
            this.setPlaceholderTextAppearance(this.I);
            this.setPlaceholderTextColor(this.G);
        }
        if(TextUtils.isEmpty(charSequence0)) {
            this.setPlaceholderTextEnabled(false);
        }
        else {
            if(!this.D) {
                this.setPlaceholderTextEnabled(true);
            }
            this.B = charSequence0;
        }
        this.v((this.d == null ? null : this.d.getText()));
    }

    public void setPlaceholderTextAppearance(int v) {
        this.I = v;
        AppCompatTextView appCompatTextView0 = this.E;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setTextAppearance(v);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList0) {
        if(this.G != colorStateList0) {
            this.G = colorStateList0;
            AppCompatTextView appCompatTextView0 = this.E;
            if(appCompatTextView0 != null && colorStateList0 != null) {
                appCompatTextView0.setTextColor(colorStateList0);
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if(this.D == z) {
            return;
        }
        if(z) {
            AppCompatTextView appCompatTextView0 = this.E;
            if(appCompatTextView0 != null) {
                this.a.addView(appCompatTextView0);
                this.E.setVisibility(0);
            }
        }
        else {
            AppCompatTextView appCompatTextView1 = this.E;
            if(appCompatTextView1 != null) {
                appCompatTextView1.setVisibility(8);
            }
            this.E = null;
        }
        this.D = z;
    }

    public void setPrefixText(CharSequence charSequence0) {
        this.b.getClass();
        this.b.c = TextUtils.isEmpty(charSequence0) ? null : charSequence0;
        this.b.b.setText(charSequence0);
        this.b.e();
    }

    public void setPrefixTextAppearance(int v) {
        this.b.b.setTextAppearance(v);
    }

    public void setPrefixTextColor(ColorStateList colorStateList0) {
        this.b.b.setTextColor(colorStateList0);
    }

    public void setShapeAppearanceModel(z6.o o0) {
        if(this.e0 != null && this.e0.a.a != o0) {
            this.k0 = o0;
            this.b();
        }
    }

    public void setStartIconCheckable(boolean z) {
        this.b.d.setCheckable(z);
    }

    public void setStartIconContentDescription(int v) {
        this.setStartIconContentDescription((v == 0 ? null : this.getResources().getText(v)));
    }

    public void setStartIconContentDescription(CharSequence charSequence0) {
        CheckableImageButton checkableImageButton0 = this.b.d;
        if(checkableImageButton0.getContentDescription() != charSequence0) {
            checkableImageButton0.setContentDescription(charSequence0);
        }
    }

    public void setStartIconDrawable(int v) {
        this.setStartIconDrawable((v == 0 ? null : d5.w.B(this.getContext(), v)));
    }

    public void setStartIconDrawable(Drawable drawable0) {
        this.b.b(drawable0);
    }

    public void setStartIconMinSize(int v) {
        s s0 = this.b;
        if(v >= 0) {
            if(v != s0.g) {
                s0.g = v;
                s0.d.setMinimumWidth(v);
                s0.d.setMinimumHeight(v);
            }
            return;
        }
        s0.getClass();
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public void setStartIconOnClickListener(View.OnClickListener view$OnClickListener0) {
        View.OnLongClickListener view$OnLongClickListener0 = this.b.i;
        this.b.d.setOnClickListener(view$OnClickListener0);
        H0.e.X(this.b.d, view$OnLongClickListener0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener0) {
        this.b.i = view$OnLongClickListener0;
        this.b.d.setOnLongClickListener(view$OnLongClickListener0);
        H0.e.X(this.b.d, view$OnLongClickListener0);
    }

    public void setStartIconScaleType(ImageView.ScaleType imageView$ScaleType0) {
        this.b.h = imageView$ScaleType0;
        this.b.d.setScaleType(imageView$ScaleType0);
    }

    public void setStartIconTintList(ColorStateList colorStateList0) {
        s s0 = this.b;
        if(s0.e != colorStateList0) {
            s0.e = colorStateList0;
            H0.e.v(s0.a, s0.d, colorStateList0, s0.f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        s s0 = this.b;
        if(s0.f != porterDuff$Mode0) {
            s0.f = porterDuff$Mode0;
            H0.e.v(s0.a, s0.d, s0.e, porterDuff$Mode0);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.b.c(z);
    }

    public void setSuffixText(CharSequence charSequence0) {
        this.c.getClass();
        this.c.r = TextUtils.isEmpty(charSequence0) ? null : charSequence0;
        this.c.w.setText(charSequence0);
        this.c.n();
    }

    public void setSuffixTextAppearance(int v) {
        this.c.w.setTextAppearance(v);
    }

    public void setSuffixTextColor(ColorStateList colorStateList0) {
        this.c.w.setTextColor(colorStateList0);
    }

    public void setTextInputAccessibilityDelegate(u u0) {
        EditText editText0 = this.d;
        if(editText0 != null) {
            W.o(editText0, u0);
        }
    }

    public void setTypeface(Typeface typeface0) {
        if(typeface0 != this.x0) {
            this.x0 = typeface0;
            c c0 = this.R0;
            if(c0.m(typeface0) || c0.o(typeface0)) {
                c0.i(false);
            }
            o o0 = this.j;
            if(typeface0 != o0.B) {
                o0.B = typeface0;
                AppCompatTextView appCompatTextView0 = o0.r;
                if(appCompatTextView0 != null) {
                    appCompatTextView0.setTypeface(typeface0);
                }
                AppCompatTextView appCompatTextView1 = o0.y;
                if(appCompatTextView1 != null) {
                    appCompatTextView1.setTypeface(typeface0);
                }
            }
            AppCompatTextView appCompatTextView2 = this.o;
            if(appCompatTextView2 != null) {
                appCompatTextView2.setTypeface(typeface0);
            }
        }
    }

    public final void t() {
        if(this.n0 != 1) {
            FrameLayout frameLayout0 = this.a;
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)frameLayout0.getLayoutParams();
            int v = this.c();
            if(v != linearLayout$LayoutParams0.topMargin) {
                linearLayout$LayoutParams0.topMargin = v;
                frameLayout0.requestLayout();
            }
        }
    }

    public final void u(boolean z, boolean z1) {
        boolean z2 = this.isEnabled();
        boolean z3 = this.d != null && !TextUtils.isEmpty(this.d.getText());
        boolean z4 = this.d != null && this.d.hasFocus();
        ColorStateList colorStateList0 = this.E0;
        c c0 = this.R0;
        if(colorStateList0 != null) {
            c0.j(colorStateList0);
        }
        Editable editable0 = null;
        if(!z2) {
            c0.j(ColorStateList.valueOf((this.E0 == null ? this.O0 : this.E0.getColorForState(new int[]{0xFEFEFF62}, this.O0))));
        }
        else if(this.m()) {
            AppCompatTextView appCompatTextView0 = this.j.r;
            c0.j((appCompatTextView0 == null ? null : appCompatTextView0.getTextColors()));
        }
        else if(this.m) {
            AppCompatTextView appCompatTextView1 = this.o;
            if(appCompatTextView1 != null) {
                c0.j(appCompatTextView1.getTextColors());
                goto label_25;
            }
            goto label_20;
        }
        else {
        label_20:
            if(z4) {
                ColorStateList colorStateList1 = this.F0;
                if(colorStateList1 != null && c0.o != colorStateList1) {
                    c0.o = colorStateList1;
                    c0.i(false);
                }
            }
        }
    label_25:
        k k0 = this.c;
        s s0 = this.b;
        if(!z3 && this.S0 && (!this.isEnabled() || !z4)) {
            if(!z1 && this.Q0) {
                return;
            }
            if(this.U0 != null && this.U0.isRunning()) {
                this.U0.cancel();
            }
            if(!z || !this.T0) {
                c0.p(0.0f);
            }
            else {
                this.a(0.0f);
            }
            if(this.e() && !((f)this.e0).S.s.isEmpty() && this.e()) {
                ((f)this.e0).w(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.Q0 = true;
            AppCompatTextView appCompatTextView2 = this.E;
            if(appCompatTextView2 != null && this.D) {
                appCompatTextView2.setText(null);
                N4.W.a(this.a, this.N);
                this.E.setVisibility(4);
            }
            s0.j = true;
            s0.e();
            k0.B = true;
            k0.n();
            return;
        }
        if(!z1 && !this.Q0) {
            return;
        }
        if(this.U0 != null && this.U0.isRunning()) {
            this.U0.cancel();
        }
        if(!z || !this.T0) {
            c0.p(1.0f);
        }
        else {
            this.a(1.0f);
        }
        this.Q0 = false;
        if(this.e()) {
            this.j();
        }
        EditText editText0 = this.d;
        if(editText0 != null) {
            editable0 = editText0.getText();
        }
        this.v(editable0);
        s0.j = false;
        s0.e();
        k0.B = false;
        k0.n();
    }

    public final void v(Editable editable0) {
        ((com.google.android.exoplayer2.upstream.cache.a)this.n).getClass();
        int v = editable0 == null ? 0 : editable0.length();
        FrameLayout frameLayout0 = this.a;
        if(v != 0 || this.Q0) {
            AppCompatTextView appCompatTextView0 = this.E;
            if(appCompatTextView0 != null && this.D) {
                appCompatTextView0.setText(null);
                N4.W.a(frameLayout0, this.N);
                this.E.setVisibility(4);
            }
        }
        else if(this.E != null && this.D && !TextUtils.isEmpty(this.B)) {
            this.E.setText(this.B);
            N4.W.a(frameLayout0, this.M);
            this.E.setVisibility(0);
            this.E.bringToFront();
            this.announceForAccessibility(this.B);
        }
    }

    public final void w(boolean z, boolean z1) {
        int v = this.J0.getDefaultColor();
        int v1 = this.J0.getColorForState(new int[]{0x1010367, 0x101009E}, v);
        int v2 = this.J0.getColorForState(new int[]{0x10102FE, 0x101009E}, v);
        if(z) {
            this.s0 = v2;
            return;
        }
        if(z1) {
            this.s0 = v1;
            return;
        }
        this.s0 = v;
    }

    public final void x() {
        boolean z = false;
        if(this.e0 != null && this.n0 != 0) {
            boolean z1 = this.isFocused() || this.d != null && this.d.hasFocus();
            if(this.isHovered() || this.d != null && this.d.isHovered()) {
                z = true;
            }
            if(!this.isEnabled()) {
                this.s0 = this.O0;
            }
            else if(!this.m()) {
                if(this.m) {
                    AppCompatTextView appCompatTextView0 = this.o;
                    if(appCompatTextView0 == null) {
                        goto label_22;
                    }
                    else if(this.J0 != null) {
                        this.w(z1, z);
                    }
                    else {
                        this.s0 = appCompatTextView0.getCurrentTextColor();
                    }
                }
                else {
                label_22:
                    if(z1) {
                        this.s0 = this.I0;
                    }
                    else if(z) {
                        this.s0 = this.H0;
                    }
                    else {
                        this.s0 = this.G0;
                    }
                }
            }
            else if(this.J0 != null) {
                this.w(z1, z);
            }
            else {
                this.s0 = this.getErrorCurrentTextColors();
            }
            if(Build.VERSION.SDK_INT >= 29) {
                this.p();
            }
            k k0 = this.c;
            TextInputLayout textInputLayout0 = k0.a;
            CheckableImageButton checkableImageButton0 = k0.g;
            k0.l();
            H0.e.S(k0.a, k0.c, k0.d);
            H0.e.S(k0.a, checkableImageButton0, k0.k);
            if(k0.b() instanceof com.google.android.material.textfield.h) {
                if(!textInputLayout0.m() || checkableImageButton0.getDrawable() == null) {
                    H0.e.v(textInputLayout0, checkableImageButton0, k0.k, k0.l);
                }
                else {
                    Drawable drawable0 = checkableImageButton0.getDrawable().mutate();
                    drawable0.setTint(textInputLayout0.getErrorCurrentTextColors());
                    checkableImageButton0.setImageDrawable(drawable0);
                }
            }
            H0.e.S(this.b.a, this.b.d, this.b.e);
            if(this.n0 == 2) {
                int v = this.p0;
                this.p0 = !z1 || !this.isEnabled() ? this.q0 : this.r0;
                if(this.p0 != v && this.e() && !this.Q0) {
                    if(this.e()) {
                        ((f)this.e0).w(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    this.j();
                }
            }
            if(this.n0 == 1) {
                if(!this.isEnabled()) {
                    this.t0 = this.L0;
                }
                else if(z && !z1) {
                    this.t0 = this.N0;
                }
                else if(z1) {
                    this.t0 = this.M0;
                }
                else {
                    this.t0 = this.K0;
                }
            }
            this.b();
        }
    }
}

