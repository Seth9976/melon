package B6;

import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import c2.K;
import c2.M;
import com.google.android.material.internal.B;
import e1.n;
import z6.i;
import z6.o;

public abstract class c extends FrameLayout {
    public final o a;
    public int b;
    public final float c;
    public final float d;
    public final int e;
    public final int f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public static final b i;

    static {
        c.i = new b(0);
    }

    public c(Context context0, AttributeSet attributeSet0) {
        super(a.a(context0, attributeSet0, 0, 0), attributeSet0);
        i i0;
        Context context1 = this.getContext();
        TypedArray typedArray0 = context1.obtainStyledAttributes(attributeSet0, d6.a.b0);
        if(typedArray0.hasValue(6)) {
            M.l(this, ((float)typedArray0.getDimensionPixelSize(6, 0)));
        }
        this.b = typedArray0.getInt(2, 0);
        if(typedArray0.hasValue(8) || typedArray0.hasValue(9)) {
            this.a = o.d(context1, attributeSet0, 0, 0).a();
        }
        this.c = typedArray0.getFloat(3, 1.0f);
        this.setBackgroundTintList(n.r(context1, typedArray0, 4));
        this.setBackgroundTintMode(B.o(typedArray0.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.d = typedArray0.getFloat(1, 1.0f);
        this.e = typedArray0.getDimensionPixelSize(0, -1);
        this.f = typedArray0.getDimensionPixelSize(7, -1);
        typedArray0.recycle();
        this.setOnTouchListener(c.i);
        this.setFocusable(true);
        if(this.getBackground() == null) {
            int v = n.A(this.getBackgroundOverlayColorAlpha(), n.q(this, 0x7F040190), n.q(this, 0x7F040179));  // attr:colorSurface
            o o0 = this.a;
            if(o0 == null) {
                float f = this.getResources().getDimension(0x7F0703D2);  // dimen:mtrl_snackbar_background_corner_radius
                GradientDrawable gradientDrawable0 = new GradientDrawable();
                gradientDrawable0.setShape(0);
                gradientDrawable0.setCornerRadius(f);
                gradientDrawable0.setColor(v);
                i0 = gradientDrawable0;
            }
            else {
                i0 = new i(o0);
                i0.m(ColorStateList.valueOf(v));
            }
            ColorStateList colorStateList0 = this.g;
            if(colorStateList0 != null) {
                i0.setTintList(colorStateList0);
            }
            this.setBackground(i0);
        }
    }

    public float getActionTextColorAlpha() {
        return this.d;
    }

    public int getAnimationMode() {
        return this.b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.c;
    }

    public int getMaxInlineActionWidth() {
        return this.f;
    }

    public int getMaxWidth() {
        return this.e;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        K.c(this);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
    }

    @Override  // android.widget.FrameLayout
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = this.e;
        if(v2 > 0 && this.getMeasuredWidth() > v2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(v2, 0x40000000), v1);
        }
    }

    public void setAnimationMode(int v) {
        this.b = v;
    }

    @Override  // android.view.View
    public void setBackground(Drawable drawable0) {
        this.setBackgroundDrawable(drawable0);
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        if(drawable0 != null && this.g != null) {
            drawable0 = drawable0.mutate();
            drawable0.setTintList(this.g);
            drawable0.setTintMode(this.h);
        }
        super.setBackgroundDrawable(drawable0);
    }

    @Override  // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList0) {
        this.g = colorStateList0;
        if(this.getBackground() != null) {
            Drawable drawable0 = this.getBackground().mutate();
            drawable0.setTintList(colorStateList0);
            drawable0.setTintMode(this.h);
            if(drawable0 != this.getBackground()) {
                super.setBackgroundDrawable(drawable0);
            }
        }
    }

    @Override  // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.h = porterDuff$Mode0;
        if(this.getBackground() != null) {
            Drawable drawable0 = this.getBackground().mutate();
            drawable0.setTintMode(porterDuff$Mode0);
            if(drawable0 != this.getBackground()) {
                super.setBackgroundDrawable(drawable0);
            }
        }
    }

    private void setBaseTransientBottomBar(d d0) {
    }

    @Override  // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.setLayoutParams(viewGroup$LayoutParams0);
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            new Rect(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin);
        }
    }

    @Override  // android.view.View
    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.setOnTouchListener((view$OnClickListener0 == null ? c.i : null));
        super.setOnClickListener(view$OnClickListener0);
    }
}

