package com.google.android.material.chip;

import E6.a;
import F8.D;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import c2.M;
import c2.W;
import com.google.android.material.internal.B;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;
import com.google.android.material.internal.w;
import e1.n;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import l6.b;
import l6.c;
import l6.d;
import z6.o;
import z6.y;

public class Chip extends AppCompatCheckBox implements g, c, y {
    public CharSequence B;
    public final b D;
    public boolean E;
    public final Rect G;
    public final RectF I;
    public final w M;
    public static final Rect N;
    public static final int[] S;
    public static final int[] T;
    public d e;
    public InsetDrawable f;
    public RippleDrawable g;
    public View.OnClickListener h;
    public CompoundButton.OnCheckedChangeListener i;
    public f j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int r;
    public int w;

    static {
        Chip.N = new Rect();
        Chip.S = new int[]{0x10100A1};
        Chip.T = new int[]{0x101009F};
    }

    public Chip(Context context0) {
        this(context0, null);
    }

    public Chip(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040128);  // attr:chipStyle
    }

    public Chip(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F140497), attributeSet0, v);  // style:Widget.MaterialComponents.Chip.Action
        w6.d d1;
        this.G = new Rect();
        this.I = new RectF();
        this.M = new w(this, 1);
        Context context1 = this.getContext();
        if(attributeSet0 != null) {
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null || attributeSet0.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if(!attributeSet0.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet0.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet0.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet0.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if(attributeSet0.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 0x800013) != 0x800013) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        d d0 = new d(context1, attributeSet0, v);
        int[] arr_v = d6.a.j;
        TypedArray typedArray0 = B.m(d0.B0, attributeSet0, arr_v, v, 0x7F140497, new int[0]);  // style:Widget.MaterialComponents.Chip.Action
        d0.b1 = typedArray0.hasValue(37);
        Context context2 = d0.B0;
        ColorStateList colorStateList0 = n.r(context2, typedArray0, 24);
        if(d0.S != colorStateList0) {
            d0.S = colorStateList0;
            d0.onStateChange(d0.getState());
        }
        ColorStateList colorStateList1 = n.r(context2, typedArray0, 11);
        if(d0.T != colorStateList1) {
            d0.T = colorStateList1;
            d0.onStateChange(d0.getState());
        }
        float f = typedArray0.getDimension(19, 0.0f);
        if(d0.V != f) {
            d0.V = f;
            d0.invalidateSelf();
            d0.D();
        }
        if(typedArray0.hasValue(12)) {
            d0.J(typedArray0.getDimension(12, 0.0f));
        }
        d0.O(n.r(context2, typedArray0, 22));
        d0.P(typedArray0.getDimension(23, 0.0f));
        d0.Y(n.r(context2, typedArray0, 36));
        CharSequence charSequence0 = typedArray0.getText(5);
        if(charSequence0 == null) {
            charSequence0 = "";
        }
        boolean z = TextUtils.equals(d0.b0, charSequence0);
        com.google.android.material.internal.y y0 = d0.H0;
        if(!z) {
            d0.b0 = charSequence0;
            y0.e = true;
            d0.invalidateSelf();
            d0.D();
        }
        if(typedArray0.hasValue(0)) {
            int v1 = typedArray0.getResourceId(0, 0);
            d1 = v1 == 0 ? null : new w6.d(context2, v1);
        }
        else {
            d1 = null;
        }
        d1.k = typedArray0.getDimension(1, d1.k);
        y0.c(d1, context2);
        switch(typedArray0.getInt(3, 0)) {
            case 1: {
                d0.Y0 = TextUtils.TruncateAt.START;
                break;
            }
            case 2: {
                d0.Y0 = TextUtils.TruncateAt.MIDDLE;
                break;
            }
            case 3: {
                d0.Y0 = TextUtils.TruncateAt.END;
            }
        }
        d0.N(typedArray0.getBoolean(18, false));
        if(attributeSet0 != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            d0.N(typedArray0.getBoolean(15, false));
        }
        d0.K(n.u(context2, typedArray0, 14));
        if(typedArray0.hasValue(17)) {
            d0.M(n.r(context2, typedArray0, 17));
        }
        d0.L(typedArray0.getDimension(16, -1.0f));
        d0.V(typedArray0.getBoolean(0x1F, false));
        if(attributeSet0 != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            d0.V(typedArray0.getBoolean(26, false));
        }
        d0.Q(n.u(context2, typedArray0, 25));
        d0.U(n.r(context2, typedArray0, 30));
        d0.S(typedArray0.getDimension(28, 0.0f));
        d0.F(typedArray0.getBoolean(6, false));
        d0.I(typedArray0.getBoolean(10, false));
        if(attributeSet0 != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            d0.I(typedArray0.getBoolean(8, false));
        }
        d0.G(n.u(context2, typedArray0, 7));
        if(typedArray0.hasValue(9)) {
            d0.H(n.r(context2, typedArray0, 9));
        }
        d0.r0 = e6.f.a(context2, typedArray0, 39);
        d0.s0 = e6.f.a(context2, typedArray0, 33);
        float f1 = typedArray0.getDimension(21, 0.0f);
        if(d0.t0 != f1) {
            d0.t0 = f1;
            d0.invalidateSelf();
            d0.D();
        }
        d0.X(typedArray0.getDimension(35, 0.0f));
        d0.W(typedArray0.getDimension(34, 0.0f));
        float f2 = typedArray0.getDimension(41, 0.0f);
        if(d0.w0 != f2) {
            d0.w0 = f2;
            d0.invalidateSelf();
            d0.D();
        }
        float f3 = typedArray0.getDimension(40, 0.0f);
        if(d0.x0 != f3) {
            d0.x0 = f3;
            d0.invalidateSelf();
            d0.D();
        }
        d0.T(typedArray0.getDimension(29, 0.0f));
        d0.R(typedArray0.getDimension(27, 0.0f));
        float f4 = typedArray0.getDimension(13, 0.0f);
        if(d0.A0 != f4) {
            d0.A0 = f4;
            d0.invalidateSelf();
            d0.D();
        }
        d0.a1 = typedArray0.getDimensionPixelSize(4, 0x7FFFFFFF);
        typedArray0.recycle();
        B.c(context1, attributeSet0, v, 0x7F140497);  // style:Widget.MaterialComponents.Chip.Action
        B.d(context1, attributeSet0, arr_v, v, 0x7F140497, new int[0]);  // style:Widget.MaterialComponents.Chip.Action
        TypedArray typedArray1 = context1.obtainStyledAttributes(attributeSet0, arr_v, v, 0x7F140497);  // style:Widget.MaterialComponents.Chip.Action
        this.o = typedArray1.getBoolean(0x20, false);
        this.w = (int)Math.ceil(typedArray1.getDimension(20, ((float)Math.ceil(B.g(this.getContext(), 0x30)))));
        typedArray1.recycle();
        this.setChipDrawable(d0);
        d0.l(M.e(this));
        B.c(context1, attributeSet0, v, 0x7F140497);  // style:Widget.MaterialComponents.Chip.Action
        B.d(context1, attributeSet0, arr_v, v, 0x7F140497, new int[0]);  // style:Widget.MaterialComponents.Chip.Action
        TypedArray typedArray2 = context1.obtainStyledAttributes(attributeSet0, arr_v, v, 0x7F140497);  // style:Widget.MaterialComponents.Chip.Action
        boolean z1 = typedArray2.hasValue(37);
        typedArray2.recycle();
        this.D = new b(this, this);
        this.e();
        if(!z1) {
            this.setOutlineProvider(new l6.a(this, 0));
        }
        this.setChecked(this.k);
        this.setText(d0.b0);
        this.setEllipsize(d0.Y0);
        this.h();
        if(!this.e.Z0) {
            this.setLines(1);
            this.setHorizontallyScrolling(true);
        }
        this.setGravity(0x800013);
        this.g();
        if(this.o) {
            this.setMinHeight(this.w);
        }
        this.r = this.getLayoutDirection();
        super.setOnCheckedChangeListener(new D(this, 2));
    }

    public final void c(int v) {
        this.w = v;
        int v1 = 0;
        if(!this.o) {
            if(this.f != null) {
                this.f = null;
                this.setMinWidth(0);
                this.setMinHeight(((int)this.getChipMinHeight()));
                this.f();
                return;
            }
            this.f();
            return;
        }
        int v2 = Math.max(0, v - ((int)this.e.V));
        int v3 = Math.max(0, v - this.e.getIntrinsicWidth());
        if(v3 <= 0 && v2 <= 0) {
            if(this.f != null) {
                this.f = null;
                this.setMinWidth(0);
                this.setMinHeight(((int)this.getChipMinHeight()));
                this.f();
                return;
            }
            this.f();
            return;
        }
        int v4 = v3 <= 0 ? 0 : v3 / 2;
        if(v2 > 0) {
            v1 = v2 / 2;
        }
        if(this.f != null) {
            Rect rect0 = new Rect();
            this.f.getPadding(rect0);
            if(rect0.top == v1 && rect0.bottom == v1 && rect0.left == v4 && rect0.right == v4) {
                this.f();
                return;
            }
        }
        if(this.getMinHeight() != v) {
            this.setMinHeight(v);
        }
        if(this.getMinWidth() != v) {
            this.setMinWidth(v);
        }
        this.f = new InsetDrawable(this.e, v4, v1, v4, v1);
        this.f();
    }

    public final boolean d() {
        return this.e == null ? false : (this.e.i0 == null ? null : E9.w.V(this.e.i0)) != null;
    }

    // 去混淆评级： 低(30)
    @Override  // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent0) {
        return this.E ? this.D.d(motionEvent0) || super.dispatchHoverEvent(motionEvent0) : super.dispatchHoverEvent(motionEvent0);
    }

    @Override  // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(!this.E) {
            return super.dispatchKeyEvent(keyEvent0);
        }
        b b0 = this.D;
        b0.getClass();
        int v = 0;
        if(keyEvent0.getAction() != 1) {
            int v1 = 66;
            int v2 = keyEvent0.getKeyCode();
            switch(v2) {
                case 19: 
                case 20: 
                case 21: 
                case 22: {
                    if(keyEvent0.hasNoModifiers()) {
                        switch(v2) {
                            case 19: {
                                v1 = 33;
                                break;
                            }
                            case 21: {
                                v1 = 17;
                                break;
                            }
                            case 22: {
                                break;
                            }
                            default: {
                                v1 = 130;
                            }
                        }
                        int v3 = keyEvent0.getRepeatCount();
                        boolean z;
                        for(z = false; v < v3 + 1 && b0.h(v1, null); z = true) {
                            ++v;
                        }
                        return !z || b0.i == 0x80000000 ? super.dispatchKeyEvent(keyEvent0) : true;
                    }
                    break;
                }
                case 61: {
                    if(keyEvent0.hasNoModifiers()) {
                        return !b0.h(2, null) || b0.i == 0x80000000 ? super.dispatchKeyEvent(keyEvent0) : true;
                    }
                    if(keyEvent0.hasModifiers(1)) {
                        v = b0.h(1, null);
                    }
                    break;
                }
                case 23: 
                case 66: {
                    if(keyEvent0.hasNoModifiers() && keyEvent0.getRepeatCount() == 0) {
                        int v4 = b0.i;
                        if(v4 != 0x80000000) {
                            b0.j(v4, 16, null);
                        }
                        return b0.i == 0x80000000 ? super.dispatchKeyEvent(keyEvent0) : true;
                    }
                    break;
                }
                default: {
                    return super.dispatchKeyEvent(keyEvent0);
                }
            }
        }
        return v == 0 || b0.i == 0x80000000 ? super.dispatchKeyEvent(keyEvent0) : true;
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public final void drawableStateChanged() {
        int v1;
        super.drawableStateChanged();
        boolean z = false;
        if(this.e != null && d.C(this.e.i0)) {
            d d0 = this.e;
            int v = this.isEnabled();
            if(this.n) {
                ++v;
            }
            if(this.m) {
                ++v;
            }
            if(this.l) {
                ++v;
            }
            if(this.isChecked()) {
                ++v;
            }
            int[] arr_v = new int[v];
            if(this.isEnabled()) {
                arr_v[0] = 0x101009E;
                v1 = 1;
            }
            else {
                v1 = 0;
            }
            if(this.n) {
                arr_v[v1] = 0x101009C;
                ++v1;
            }
            if(this.m) {
                arr_v[v1] = 0x1010367;
                ++v1;
            }
            if(this.l) {
                arr_v[v1] = 0x10100A7;
                ++v1;
            }
            if(this.isChecked()) {
                arr_v[v1] = 0x10100A1;
            }
            if(!Arrays.equals(d0.V0, arr_v)) {
                d0.V0 = arr_v;
                if(d0.b0()) {
                    z = d0.E(d0.getState(), arr_v);
                }
            }
        }
        if(z) {
            this.invalidate();
        }
    }

    public final void e() {
        if(this.d() && (this.e != null && this.e.h0 && this.h != null)) {
            W.o(this, this.D);
            this.E = true;
            return;
        }
        W.o(this, null);
        this.E = false;
    }

    public final void f() {
        this.g = new RippleDrawable(x6.a.c(this.e.Z), this.getBackgroundDrawable(), null);
        this.e.getClass();
        this.setBackground(this.g);
        this.g();
    }

    public final void g() {
        if(!TextUtils.isEmpty(this.getText())) {
            d d0 = this.e;
            if(d0 != null) {
                int v = (int)(d0.z() + (d0.A0 + d0.x0));
                float f = this.e.t0 + this.e.w0;
                int v1 = (int)(this.e.y() + f);
                if(this.f != null) {
                    Rect rect0 = new Rect();
                    this.f.getPadding(rect0);
                    v1 += rect0.left;
                    v += rect0.right;
                }
                this.setPaddingRelative(v1, this.getPaddingTop(), v, this.getPaddingBottom());
            }
        }
    }

    @Override  // android.widget.CheckBox
    public CharSequence getAccessibilityClassName() {
        if(!TextUtils.isEmpty(this.B)) {
            return this.B;
        }
        if(this.e != null && this.e.n0) {
            ViewParent viewParent0 = this.getParent();
            return !(viewParent0 instanceof ChipGroup) || !((ChipGroup)viewParent0).h.a ? "android.widget.Button" : "android.widget.RadioButton";
        }
        return this.isClickable() ? "android.widget.Button" : "android.view.View";
    }

    public Drawable getBackgroundDrawable() {
        Drawable drawable0 = this.f;
        return drawable0 == null ? this.e : drawable0;
    }

    public Drawable getCheckedIcon() {
        return this.e == null ? null : this.e.p0;
    }

    public ColorStateList getCheckedIconTint() {
        return this.e == null ? null : this.e.q0;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.e == null ? null : this.e.T;
    }

    public float getChipCornerRadius() {
        return this.e == null ? 0.0f : Math.max(0.0f, this.e.A());
    }

    public Drawable getChipDrawable() {
        return this.e;
    }

    public float getChipEndPadding() {
        return this.e == null ? 0.0f : this.e.A0;
    }

    public Drawable getChipIcon() {
        d d0 = this.e;
        if(d0 != null) {
            return d0.d0 == null ? null : E9.w.V(d0.d0);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.e == null ? 0.0f : this.e.f0;
    }

    public ColorStateList getChipIconTint() {
        return this.e == null ? null : this.e.e0;
    }

    public float getChipMinHeight() {
        return this.e == null ? 0.0f : this.e.V;
    }

    public float getChipStartPadding() {
        return this.e == null ? 0.0f : this.e.t0;
    }

    public ColorStateList getChipStrokeColor() {
        return this.e == null ? null : this.e.X;
    }

    public float getChipStrokeWidth() {
        return this.e == null ? 0.0f : this.e.Y;
    }

    @Deprecated
    public CharSequence getChipText() {
        return this.getText();
    }

    public Drawable getCloseIcon() {
        d d0 = this.e;
        if(d0 != null) {
            return d0.i0 == null ? null : E9.w.V(d0.i0);
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        d d0 = this.e;
        return d0 != null ? d0.m0 : null;
    }

    public float getCloseIconEndPadding() {
        return this.e == null ? 0.0f : this.e.z0;
    }

    public float getCloseIconSize() {
        return this.e == null ? 0.0f : this.e.l0;
    }

    public float getCloseIconStartPadding() {
        return this.e == null ? 0.0f : this.e.y0;
    }

    public ColorStateList getCloseIconTint() {
        return this.e == null ? null : this.e.k0;
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF0 = this.I;
        rectF0.setEmpty();
        if(this.d() && this.h != null) {
            d d0 = this.e;
            Rect rect0 = d0.getBounds();
            rectF0.setEmpty();
            if(d0.b0()) {
                float f = d0.A0 + d0.z0 + d0.l0 + d0.y0 + d0.x0;
                if(d0.getLayoutDirection() == 0) {
                    float f1 = (float)rect0.right;
                    rectF0.right = f1;
                    rectF0.left = f1 - f;
                }
                else {
                    float f2 = (float)rect0.left;
                    rectF0.left = f2;
                    rectF0.right = f2 + f;
                }
                rectF0.top = (float)rect0.top;
                rectF0.bottom = (float)rect0.bottom;
            }
        }
        return rectF0;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF rectF0 = this.getCloseIconTouchBounds();
        this.G.set(((int)rectF0.left), ((int)rectF0.top), ((int)rectF0.right), ((int)rectF0.bottom));
        return this.G;
    }

    @Override  // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        return this.e == null ? null : this.e.Y0;
    }

    @Override  // android.widget.TextView
    public final void getFocusedRect(Rect rect0) {
        if(this.E && (this.D.i == 1 || this.D.h == 1)) {
            rect0.set(this.getCloseIconTouchBoundsInt());
            return;
        }
        super.getFocusedRect(rect0);
    }

    public e6.f getHideMotionSpec() {
        return this.e == null ? null : this.e.s0;
    }

    public float getIconEndPadding() {
        return this.e == null ? 0.0f : this.e.v0;
    }

    public float getIconStartPadding() {
        return this.e == null ? 0.0f : this.e.u0;
    }

    public ColorStateList getRippleColor() {
        return this.e == null ? null : this.e.Z;
    }

    public o getShapeAppearanceModel() {
        return this.e.a.a;
    }

    public e6.f getShowMotionSpec() {
        return this.e == null ? null : this.e.r0;
    }

    private w6.d getTextAppearance() {
        return this.e == null ? null : this.e.H0.g;
    }

    public float getTextEndPadding() {
        return this.e == null ? 0.0f : this.e.x0;
    }

    public float getTextStartPadding() {
        return this.e == null ? 0.0f : this.e.w0;
    }

    public final void h() {
        TextPaint textPaint0 = this.getPaint();
        d d0 = this.e;
        if(d0 != null) {
            textPaint0.drawableState = d0.getState();
        }
        w6.d d1 = this.getTextAppearance();
        if(d1 != null) {
            d1.e(this.getContext(), textPaint0, this.M);
        }
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.A(this, this.e);
    }

    @Override  // android.widget.CompoundButton
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 2);
        if(this.isChecked()) {
            View.mergeDrawableStates(arr_v, Chip.S);
        }
        if(this.e != null && this.e.n0) {
            View.mergeDrawableStates(arr_v, Chip.T);
        }
        return arr_v;
    }

    @Override  // android.widget.TextView
    public final void onFocusChanged(boolean z, int v, Rect rect0) {
        super.onFocusChanged(z, v, rect0);
        if(this.E) {
            b b0 = this.D;
            int v1 = b0.i;
            if(v1 != 0x80000000) {
                b0.a(v1);
            }
            if(z) {
                b0.h(v, rect0);
            }
        }
    }

    @Override  // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getActionMasked()) {
            case 7: {
                this.setCloseIconHovered(this.getCloseIconTouchBounds().contains(motionEvent0.getX(), motionEvent0.getY()));
                return super.onHoverEvent(motionEvent0);
            }
            case 10: {
                this.setCloseIconHovered(false);
                return super.onHoverEvent(motionEvent0);
            }
            default: {
                return super.onHoverEvent(motionEvent0);
            }
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        int v3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName(this.getAccessibilityClassName());
        accessibilityNodeInfo0.setCheckable(this.e != null && this.e.n0);
        accessibilityNodeInfo0.setClickable(this.isClickable());
        if(this.getParent() instanceof ChipGroup) {
            ChipGroup chipGroup0 = (ChipGroup)this.getParent();
            int v1 = -1;
            if(chipGroup0.c) {
                int v2 = 0;
                for(int v = 0; true; ++v) {
                    if(v >= chipGroup0.getChildCount()) {
                        v2 = -1;
                        break;
                    }
                    View view0 = chipGroup0.getChildAt(v);
                    if(view0 instanceof Chip && chipGroup0.getChildAt(v).getVisibility() == 0) {
                        if(((Chip)view0) == this) {
                            break;
                        }
                        ++v2;
                    }
                }
                v3 = v2;
            }
            else {
                v3 = -1;
            }
            Object object0 = this.getTag(0x7F0A0A17);  // id:row_index_key
            if(object0 instanceof Integer) {
                v1 = (int)(((Integer)object0));
            }
            accessibilityNodeInfo0.setCollectionItemInfo(((AccessibilityNodeInfo.CollectionItemInfo)B6.f.c(v1, 1, v3, 1, false, this.isChecked()).a));
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.Button
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent0, int v) {
        return !this.getCloseIconTouchBounds().contains(motionEvent0.getX(), motionEvent0.getY()) || !this.isEnabled() ? super.onResolvePointerIcon(motionEvent0, v) : PointerIcon.getSystemIcon(this.getContext(), 1002);
    }

    @Override  // android.widget.TextView
    public final void onRtlPropertiesChanged(int v) {
        super.onRtlPropertiesChanged(v);
        if(this.r != v) {
            this.r = v;
            this.g();
        }
    }

    @Override  // android.widget.TextView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z1;
        int v = motionEvent0.getActionMasked();
        boolean z = this.getCloseIconTouchBounds().contains(motionEvent0.getX(), motionEvent0.getY());
        switch(v) {
            case 0: {
                if(!z) {
                    return super.onTouchEvent(motionEvent0);
                }
                this.setCloseIconPressed(true);
                return true;
            }
            case 1: {
                if(this.l) {
                    this.playSoundEffect(0);
                    View.OnClickListener view$OnClickListener0 = this.h;
                    if(view$OnClickListener0 != null) {
                        view$OnClickListener0.onClick(this);
                    }
                    if(this.E) {
                        this.D.o(1, 1);
                    }
                    z1 = true;
                }
                else {
                    z1 = false;
                }
                break;
            }
            case 2: {
                if(this.l) {
                    if(!z) {
                        this.setCloseIconPressed(false);
                    }
                    return true;
                }
                return super.onTouchEvent(motionEvent0);
            }
            case 3: {
                z1 = false;
                break;
            }
            default: {
                return super.onTouchEvent(motionEvent0);
            }
        }
        this.setCloseIconPressed(false);
        return z1 || super.onTouchEvent(motionEvent0);
    }

    public void setAccessibilityClassName(CharSequence charSequence0) {
        this.B = charSequence0;
    }

    @Override  // android.view.View
    public void setBackground(Drawable drawable0) {
        if(drawable0 != this.getBackgroundDrawable() && drawable0 != this.g) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            return;
        }
        super.setBackground(drawable0);
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundDrawable(Drawable drawable0) {
        if(drawable0 != this.getBackgroundDrawable() && drawable0 != this.g) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
            return;
        }
        super.setBackgroundDrawable(drawable0);
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundResource(int v) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override  // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList0) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override  // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        d d0 = this.e;
        if(d0 != null) {
            d0.F(z);
        }
    }

    public void setCheckableResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.F(d0.B0.getResources().getBoolean(v));
        }
    }

    @Override  // android.widget.Checkable, android.widget.CompoundButton
    public void setChecked(boolean z) {
        d d0 = this.e;
        if(d0 == null) {
            this.k = z;
            return;
        }
        if(d0.n0) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(Drawable drawable0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.G(drawable0);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        this.setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int v) {
        this.setCheckedIconVisible(v);
    }

    public void setCheckedIconResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.G(d5.w.B(d0.B0, v));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.H(colorStateList0);
        }
    }

    public void setCheckedIconTintResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.H(P1.c.getColorStateList(d0.B0, v));
        }
    }

    public void setCheckedIconVisible(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.I(d0.B0.getResources().getBoolean(v));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        d d0 = this.e;
        if(d0 != null) {
            d0.I(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null && d0.T != colorStateList0) {
            d0.T = colorStateList0;
            d0.onStateChange(d0.getState());
        }
    }

    public void setChipBackgroundColorResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            ColorStateList colorStateList0 = P1.c.getColorStateList(d0.B0, v);
            if(d0.T != colorStateList0) {
                d0.T = colorStateList0;
                d0.onStateChange(d0.getState());
            }
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.J(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.J(d0.B0.getResources().getDimension(v));
        }
    }

    public void setChipDrawable(d d0) {
        d d1 = this.e;
        if(d1 != d0) {
            if(d1 != null) {
                d1.X0 = new WeakReference(null);
            }
            this.e = d0;
            d0.Z0 = false;
            d0.X0 = new WeakReference(this);
            this.c(this.w);
        }
    }

    public void setChipEndPadding(float f) {
        d d0 = this.e;
        if(d0 != null && d0.A0 != f) {
            d0.A0 = f;
            d0.invalidateSelf();
            d0.D();
        }
    }

    public void setChipEndPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            float f = d0.B0.getResources().getDimension(v);
            if(d0.A0 != f) {
                d0.A0 = f;
                d0.invalidateSelf();
                d0.D();
            }
        }
    }

    public void setChipIcon(Drawable drawable0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.K(drawable0);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        this.setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int v) {
        this.setChipIconVisible(v);
    }

    public void setChipIconResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.K(d5.w.B(d0.B0, v));
        }
    }

    public void setChipIconSize(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.L(f);
        }
    }

    public void setChipIconSizeResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.L(d0.B0.getResources().getDimension(v));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.M(colorStateList0);
        }
    }

    public void setChipIconTintResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.M(P1.c.getColorStateList(d0.B0, v));
        }
    }

    public void setChipIconVisible(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.N(d0.B0.getResources().getBoolean(v));
        }
    }

    public void setChipIconVisible(boolean z) {
        d d0 = this.e;
        if(d0 != null) {
            d0.N(z);
        }
    }

    public void setChipMinHeight(float f) {
        d d0 = this.e;
        if(d0 != null && d0.V != f) {
            d0.V = f;
            d0.invalidateSelf();
            d0.D();
        }
    }

    public void setChipMinHeightResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            float f = d0.B0.getResources().getDimension(v);
            if(d0.V != f) {
                d0.V = f;
                d0.invalidateSelf();
                d0.D();
            }
        }
    }

    public void setChipStartPadding(float f) {
        d d0 = this.e;
        if(d0 != null && d0.t0 != f) {
            d0.t0 = f;
            d0.invalidateSelf();
            d0.D();
        }
    }

    public void setChipStartPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            float f = d0.B0.getResources().getDimension(v);
            if(d0.t0 != f) {
                d0.t0 = f;
                d0.invalidateSelf();
                d0.D();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.O(colorStateList0);
        }
    }

    public void setChipStrokeColorResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.O(P1.c.getColorStateList(d0.B0, v));
        }
    }

    public void setChipStrokeWidth(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.P(f);
        }
    }

    public void setChipStrokeWidthResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.P(d0.B0.getResources().getDimension(v));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence0) {
        this.setText(charSequence0);
    }

    @Deprecated
    public void setChipTextResource(int v) {
        this.setText(this.getResources().getString(v));
    }

    public void setCloseIcon(Drawable drawable0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.Q(drawable0);
        }
        this.e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence0) {
        d d0 = this.e;
        if(d0 != null && d0.m0 != charSequence0) {
            a2.b b0 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? a2.b.e : a2.b.d;
            b0.getClass();
            d0.m0 = b0.c(charSequence0);
            d0.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        this.setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int v) {
        this.setCloseIconVisible(v);
    }

    public void setCloseIconEndPadding(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.R(f);
        }
    }

    public void setCloseIconEndPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.R(d0.B0.getResources().getDimension(v));
        }
    }

    private void setCloseIconHovered(boolean z) {
        if(this.m != z) {
            this.m = z;
            this.refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if(this.l != z) {
            this.l = z;
            this.refreshDrawableState();
        }
    }

    public void setCloseIconResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.Q(d5.w.B(d0.B0, v));
        }
        this.e();
    }

    public void setCloseIconSize(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.S(f);
        }
    }

    public void setCloseIconSizeResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.S(d0.B0.getResources().getDimension(v));
        }
    }

    public void setCloseIconStartPadding(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.T(f);
        }
    }

    public void setCloseIconStartPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.T(d0.B0.getResources().getDimension(v));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.U(colorStateList0);
        }
    }

    public void setCloseIconTintResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.U(P1.c.getColorStateList(d0.B0, v));
        }
    }

    public void setCloseIconVisible(int v) {
        this.setCloseIconVisible(this.getResources().getBoolean(v));
    }

    public void setCloseIconVisible(boolean z) {
        d d0 = this.e;
        if(d0 != null) {
            d0.V(z);
        }
        this.e();
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public final void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        if(drawable0 != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if(drawable2 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(null, drawable1, null, drawable3);
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public final void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        if(drawable0 != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if(drawable2 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(null, drawable1, null, drawable3);
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        if(v != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if(v2 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(0, v1, 0, v3);
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        if(drawable0 != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if(drawable2 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable1, null, drawable3);
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        if(v != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if(v2 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(0, v1, 0, v3);
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        if(drawable0 != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if(drawable2 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(null, drawable1, null, drawable3);
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d d0 = this.e;
        if(d0 != null) {
            d0.l(f);
        }
    }

    @Override  // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt textUtils$TruncateAt0) {
        if(this.e != null) {
            if(textUtils$TruncateAt0 == TextUtils.TruncateAt.MARQUEE) {
                throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
            }
            super.setEllipsize(textUtils$TruncateAt0);
            d d0 = this.e;
            if(d0 != null) {
                d0.Y0 = textUtils$TruncateAt0;
            }
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.o = z;
        this.c(this.w);
    }

    @Override  // android.widget.TextView
    public void setGravity(int v) {
        if(v != 0x800013) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
            return;
        }
        super.setGravity(0x800013);
    }

    public void setHideMotionSpec(e6.f f0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.s0 = f0;
        }
    }

    public void setHideMotionSpecResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.s0 = e6.f.b(d0.B0, v);
        }
    }

    public void setIconEndPadding(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.W(f);
        }
    }

    public void setIconEndPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.W(d0.B0.getResources().getDimension(v));
        }
    }

    public void setIconStartPadding(float f) {
        d d0 = this.e;
        if(d0 != null) {
            d0.X(f);
        }
    }

    public void setIconStartPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.X(d0.B0.getResources().getDimension(v));
        }
    }

    @Override  // com.google.android.material.internal.g
    public void setInternalOnCheckedChangeListener(f f0) {
        this.j = f0;
    }

    @Override  // android.view.View
    public void setLayoutDirection(int v) {
        if(this.e == null) {
            return;
        }
        super.setLayoutDirection(v);
    }

    @Override  // android.widget.TextView
    public void setLines(int v) {
        if(v > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(v);
    }

    @Override  // android.widget.TextView
    public void setMaxLines(int v) {
        if(v > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(v);
    }

    @Override  // android.widget.TextView
    public void setMaxWidth(int v) {
        super.setMaxWidth(v);
        d d0 = this.e;
        if(d0 != null) {
            d0.a1 = v;
        }
    }

    @Override  // android.widget.TextView
    public void setMinLines(int v) {
        if(v > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(v);
    }

    @Override  // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener0) {
        this.i = compoundButton$OnCheckedChangeListener0;
    }

    public void setOnCloseIconClickListener(View.OnClickListener view$OnClickListener0) {
        this.h = view$OnClickListener0;
        this.e();
    }

    public void setRippleColor(ColorStateList colorStateList0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.Y(colorStateList0);
        }
        this.e.getClass();
        this.f();
    }

    public void setRippleColorResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.Y(P1.c.getColorStateList(d0.B0, v));
            this.e.getClass();
            this.f();
        }
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        this.e.setShapeAppearanceModel(o0);
    }

    public void setShowMotionSpec(e6.f f0) {
        d d0 = this.e;
        if(d0 != null) {
            d0.r0 = f0;
        }
    }

    public void setShowMotionSpecResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            d0.r0 = e6.f.b(d0.B0, v);
        }
    }

    @Override  // android.widget.TextView
    public void setSingleLine(boolean z) {
        if(!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(true);
    }

    @Override  // android.widget.TextView
    public final void setText(CharSequence charSequence0, TextView.BufferType textView$BufferType0) {
        d d0 = this.e;
        if(d0 != null) {
            if(charSequence0 == null) {
                charSequence0 = "";
            }
            super.setText((d0.Z0 ? null : charSequence0), textView$BufferType0);
            d d1 = this.e;
            if(d1 != null && !TextUtils.equals(d1.b0, charSequence0)) {
                d1.b0 = charSequence0;
                d1.H0.e = true;
                d1.invalidateSelf();
                d1.D();
            }
        }
    }

    @Override  // android.widget.TextView
    public void setTextAppearance(int v) {
        super.setTextAppearance(v);
        d d0 = this.e;
        if(d0 != null) {
            w6.d d1 = new w6.d(d0.B0, v);
            d0.H0.c(d1, d0.B0);
        }
        this.h();
    }

    @Override  // android.widget.TextView
    public final void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        d d0 = this.e;
        if(d0 != null) {
            w6.d d1 = new w6.d(d0.B0, v);
            d0.H0.c(d1, d0.B0);
        }
        this.h();
    }

    public void setTextAppearance(w6.d d0) {
        d d1 = this.e;
        if(d1 != null) {
            d1.H0.c(d0, d1.B0);
        }
        this.h();
    }

    public void setTextAppearanceResource(int v) {
        this.setTextAppearance(this.getContext(), v);
    }

    public void setTextEndPadding(float f) {
        d d0 = this.e;
        if(d0 != null && d0.x0 != f) {
            d0.x0 = f;
            d0.invalidateSelf();
            d0.D();
        }
    }

    public void setTextEndPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            float f = d0.B0.getResources().getDimension(v);
            if(d0.x0 != f) {
                d0.x0 = f;
                d0.invalidateSelf();
                d0.D();
            }
        }
    }

    @Override  // android.widget.TextView
    public final void setTextSize(int v, float f) {
        super.setTextSize(v, f);
        d d0 = this.e;
        if(d0 != null) {
            float f1 = TypedValue.applyDimension(v, f, this.getResources().getDisplayMetrics());
            com.google.android.material.internal.y y0 = d0.H0;
            w6.d d1 = y0.g;
            if(d1 != null) {
                d1.k = f1;
                y0.a.setTextSize(f1);
                d0.a();
            }
        }
        this.h();
    }

    public void setTextStartPadding(float f) {
        d d0 = this.e;
        if(d0 != null && d0.w0 != f) {
            d0.w0 = f;
            d0.invalidateSelf();
            d0.D();
        }
    }

    public void setTextStartPaddingResource(int v) {
        d d0 = this.e;
        if(d0 != null) {
            float f = d0.B0.getResources().getDimension(v);
            if(d0.w0 != f) {
                d0.w0 = f;
                d0.invalidateSelf();
                d0.D();
            }
        }
    }
}

