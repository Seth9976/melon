package com.google.android.material.card;

import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.B;
import d5.w;
import e1.n;
import j6.c;
import z6.i;
import z6.m;
import z6.o;
import z6.y;

public class MaterialCardView extends CardView implements Checkable, y {
    public final c h;
    public final boolean i;
    public boolean j;
    public boolean k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;

    static {
        MaterialCardView.l = new int[]{0x101009F};
        MaterialCardView.m = new int[]{0x10100A0};
        MaterialCardView.n = new int[]{0x7F04059E};  // attr:state_dragged
    }

    public MaterialCardView(Context context0) {
        this(context0, null);
    }

    public MaterialCardView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040407);  // attr:materialCardViewStyle
    }

    public MaterialCardView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F140495), attributeSet0, v);  // style:Widget.MaterialComponents.CardView
        this.j = false;
        this.k = false;
        this.i = true;
        TypedArray typedArray0 = B.m(this.getContext(), attributeSet0, d6.a.E, v, 0x7F140495, new int[0]);  // style:Widget.MaterialComponents.CardView
        c c0 = new c(this, attributeSet0, v);
        this.h = c0;
        i i0 = c0.c;
        i0.m(super.getCardBackgroundColor());
        int v1 = super.getContentPaddingLeft();
        int v2 = super.getContentPaddingTop();
        int v3 = super.getContentPaddingRight();
        int v4 = super.getContentPaddingBottom();
        c0.b.set(v1, v2, v3, v4);
        c0.l();
        MaterialCardView materialCardView0 = c0.a;
        ColorStateList colorStateList0 = n.r(materialCardView0.getContext(), typedArray0, 11);
        c0.n = colorStateList0;
        if(colorStateList0 == null) {
            c0.n = ColorStateList.valueOf(-1);
        }
        c0.h = typedArray0.getDimensionPixelSize(12, 0);
        boolean z = typedArray0.getBoolean(0, false);
        c0.s = z;
        materialCardView0.setLongClickable(z);
        c0.l = n.r(materialCardView0.getContext(), typedArray0, 6);
        c0.g(n.u(materialCardView0.getContext(), typedArray0, 2));
        c0.f = typedArray0.getDimensionPixelSize(5, 0);
        c0.e = typedArray0.getDimensionPixelSize(4, 0);
        c0.g = typedArray0.getInteger(3, 0x800035);
        ColorStateList colorStateList1 = n.r(materialCardView0.getContext(), typedArray0, 7);
        c0.k = colorStateList1;
        if(colorStateList1 == null) {
            c0.k = ColorStateList.valueOf(n.q(materialCardView0, 0x7F040167));  // attr:colorControlHighlight
        }
        ColorStateList colorStateList2 = n.r(materialCardView0.getContext(), typedArray0, 1);
        if(colorStateList2 == null) {
            colorStateList2 = ColorStateList.valueOf(0);
        }
        i i1 = c0.d;
        i1.m(colorStateList2);
        RippleDrawable rippleDrawable0 = c0.o;
        if(rippleDrawable0 != null) {
            rippleDrawable0.setColor(c0.k);
        }
        i0.l(materialCardView0.getCardElevation());
        ColorStateList colorStateList3 = c0.n;
        i1.s(((float)c0.h));
        i1.r(colorStateList3);
        materialCardView0.setBackgroundInternal(c0.d(i0));
        if(c0.j()) {
            i1 = c0.c();
        }
        c0.i = i1;
        materialCardView0.setForeground(c0.d(i1));
        typedArray0.recycle();
    }

    public final void f() {
        if(Build.VERSION.SDK_INT > 26) {
            c c0 = this.h;
            RippleDrawable rippleDrawable0 = c0.o;
            if(rippleDrawable0 != null) {
                Rect rect0 = rippleDrawable0.getBounds();
                int v = rect0.bottom;
                c0.o.setBounds(rect0.left, rect0.top, rect0.right, v - 1);
                c0.o.setBounds(rect0.left, rect0.top, rect0.right, v);
            }
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF0 = new RectF();
        rectF0.set(this.h.c.getBounds());
        return rectF0;
    }

    @Override  // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.h.c.a.c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.h.d.a.c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.h.j;
    }

    public int getCheckedIconGravity() {
        return this.h.g;
    }

    public int getCheckedIconMargin() {
        return this.h.e;
    }

    public int getCheckedIconSize() {
        return this.h.f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.h.l;
    }

    @Override  // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.h.b.bottom;
    }

    @Override  // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.h.b.left;
    }

    @Override  // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.h.b.right;
    }

    @Override  // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.h.b.top;
    }

    public float getProgress() {
        return this.h.c.a.i;
    }

    @Override  // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.h.c.i();
    }

    public ColorStateList getRippleColor() {
        return this.h.k;
    }

    public o getShapeAppearanceModel() {
        return this.h.m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList0 = this.h.n;
        return colorStateList0 == null ? -1 : colorStateList0.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.h.n;
    }

    public int getStrokeWidth() {
        return this.h.h;
    }

    @Override  // android.widget.Checkable
    public final boolean isChecked() {
        return this.j;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h.k();
        d5.n.A(this, this.h.c);
    }

    @Override  // android.view.ViewGroup
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 3);
        if(this.h != null && this.h.s) {
            View.mergeDrawableStates(arr_v, MaterialCardView.l);
        }
        if(this.j) {
            View.mergeDrawableStates(arr_v, MaterialCardView.m);
        }
        if(this.k) {
            View.mergeDrawableStates(arr_v, MaterialCardView.n);
        }
        return arr_v;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent0.setChecked(this.j);
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo0.setCheckable(this.h != null && this.h.s);
        accessibilityNodeInfo0.setClickable(this.isClickable());
        accessibilityNodeInfo0.setChecked(this.j);
    }

    @Override  // androidx.cardview.widget.CardView
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = this.getMeasuredWidth();
        int v3 = this.getMeasuredHeight();
        this.h.e(v2, v3);
    }

    @Override  // android.view.View
    public void setBackground(Drawable drawable0) {
        this.setBackgroundDrawable(drawable0);
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        if(this.i) {
            c c0 = this.h;
            if(!c0.r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                c0.r = true;
            }
            super.setBackgroundDrawable(drawable0);
        }
    }

    public void setBackgroundInternal(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
    }

    @Override  // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int v) {
        ColorStateList colorStateList0 = ColorStateList.valueOf(v);
        this.h.c.m(colorStateList0);
    }

    @Override  // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList0) {
        this.h.c.m(colorStateList0);
    }

    @Override  // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        float f1 = this.h.a.getCardElevation();
        this.h.c.l(f1);
    }

    public void setCardForegroundColor(ColorStateList colorStateList0) {
        i i0 = this.h.d;
        if(colorStateList0 == null) {
            colorStateList0 = ColorStateList.valueOf(0);
        }
        i0.m(colorStateList0);
    }

    public void setCheckable(boolean z) {
        this.h.s = z;
    }

    @Override  // android.widget.Checkable
    public void setChecked(boolean z) {
        if(this.j != z) {
            this.toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable0) {
        this.h.g(drawable0);
    }

    public void setCheckedIconGravity(int v) {
        c c0 = this.h;
        if(c0.g != v) {
            c0.g = v;
            c0.e(c0.a.getMeasuredWidth(), c0.a.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int v) {
        this.h.e = v;
    }

    public void setCheckedIconMarginResource(int v) {
        if(v != -1) {
            this.h.e = this.getResources().getDimensionPixelSize(v);
        }
    }

    public void setCheckedIconResource(int v) {
        Drawable drawable0 = w.B(this.getContext(), v);
        this.h.g(drawable0);
    }

    public void setCheckedIconSize(int v) {
        this.h.f = v;
    }

    public void setCheckedIconSizeResource(int v) {
        if(v != 0) {
            this.h.f = this.getResources().getDimensionPixelSize(v);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList0) {
        this.h.l = colorStateList0;
        Drawable drawable0 = this.h.j;
        if(drawable0 != null) {
            drawable0.setTintList(colorStateList0);
        }
    }

    @Override  // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        c c0 = this.h;
        if(c0 != null) {
            c0.k();
        }
    }

    public void setDragged(boolean z) {
        if(this.k != z) {
            this.k = z;
            this.refreshDrawableState();
            this.f();
            this.invalidate();
        }
    }

    @Override  // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.h.m();
    }

    public void setOnCheckedChangeListener(j6.a a0) {
    }

    @Override  // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.h.m();
        this.h.l();
    }

    public void setProgress(float f) {
        c c0 = this.h;
        c0.c.n(f);
        i i0 = c0.d;
        if(i0 != null) {
            i0.n(f);
        }
        i i1 = c0.q;
        if(i1 != null) {
            i1.n(f);
        }
    }

    @Override  // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        c c0 = this.h;
        m m0 = c0.m.g();
        m0.c(f);
        c0.h(m0.a());
        c0.i.invalidateSelf();
        if(c0.i() || c0.a.getPreventCornerOverlap() && !c0.c.a.a.f(c0.c.g())) {
            c0.l();
        }
        if(c0.i()) {
            c0.m();
        }
    }

    public void setRippleColor(ColorStateList colorStateList0) {
        this.h.k = colorStateList0;
        RippleDrawable rippleDrawable0 = this.h.o;
        if(rippleDrawable0 != null) {
            rippleDrawable0.setColor(colorStateList0);
        }
    }

    public void setRippleColorResource(int v) {
        ColorStateList colorStateList0 = P1.c.getColorStateList(this.getContext(), v);
        this.h.k = colorStateList0;
        RippleDrawable rippleDrawable0 = this.h.o;
        if(rippleDrawable0 != null) {
            rippleDrawable0.setColor(colorStateList0);
        }
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        this.setClipToOutline(o0.f(this.getBoundsAsRectF()));
        this.h.h(o0);
    }

    public void setStrokeColor(int v) {
        this.setStrokeColor(ColorStateList.valueOf(v));
    }

    public void setStrokeColor(ColorStateList colorStateList0) {
        c c0 = this.h;
        if(c0.n != colorStateList0) {
            c0.n = colorStateList0;
            c0.d.s(((float)c0.h));
            c0.d.r(colorStateList0);
        }
        this.invalidate();
    }

    public void setStrokeWidth(int v) {
        c c0 = this.h;
        if(v != c0.h) {
            c0.h = v;
            ColorStateList colorStateList0 = c0.n;
            c0.d.s(((float)v));
            c0.d.r(colorStateList0);
        }
        this.invalidate();
    }

    @Override  // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.h.m();
        this.h.l();
    }

    @Override  // android.widget.Checkable
    public final void toggle() {
        c c0 = this.h;
        if(c0 != null && c0.s && this.isEnabled()) {
            this.j = !this.j;
            this.refreshDrawableState();
            this.f();
            c0.f(this.j, true);
        }
    }
}

