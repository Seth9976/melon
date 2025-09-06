package com.google.android.material.materialswitch;

import E6.a;
import S1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.B;
import d5.m;
import d5.w;

public class MaterialSwitch extends SwitchCompat {
    public ColorStateList A0;
    public ColorStateList B0;
    public PorterDuff.Mode C0;
    public int[] D0;
    public int[] E0;
    public static final int[] F0;
    public Drawable s0;
    public Drawable t0;
    public int u0;
    public Drawable v0;
    public Drawable w0;
    public ColorStateList x0;
    public ColorStateList y0;
    public PorterDuff.Mode z0;

    static {
        MaterialSwitch.F0 = new int[]{0x7F0405A3};  // attr:state_with_icon
    }

    public MaterialSwitch(Context context0) {
        this(context0, null);
    }

    public MaterialSwitch(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040416);  // attr:materialSwitchStyle
    }

    public MaterialSwitch(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F140409), attributeSet0, v);  // style:Widget.Material3.CompoundButton.MaterialSwitch
        this.u0 = -1;
        Context context1 = this.getContext();
        this.s0 = super.getThumbDrawable();
        this.x0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.v0 = super.getTrackDrawable();
        this.A0 = super.getTrackTintList();
        super.setTrackTintList(null);
        m m0 = B.n(context1, attributeSet0, d6.a.J, v, 0x7F140409, new int[0]);  // style:Widget.Material3.CompoundButton.MaterialSwitch
        this.t0 = m0.k(0);
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.u0 = typedArray0.getDimensionPixelSize(1, -1);
        this.y0 = m0.j(2);
        int v1 = typedArray0.getInt(3, -1);
        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
        this.z0 = B.o(v1, porterDuff$Mode0);
        this.w0 = m0.k(4);
        this.B0 = m0.j(5);
        this.C0 = B.o(typedArray0.getInt(6, -1), porterDuff$Mode0);
        m0.t();
        this.setEnforceSwitchWidth(false);
        this.e();
        this.f();
    }

    public final void e() {
        this.s0 = e2.a.x(this.s0, this.x0, this.getThumbTintMode());
        this.t0 = e2.a.x(this.t0, this.y0, this.z0);
        this.h();
        super.setThumbDrawable(e2.a.v(this.s0, this.t0, this.u0, this.u0));
        this.refreshDrawableState();
    }

    public final void f() {
        this.v0 = e2.a.x(this.v0, this.A0, this.getTrackTintMode());
        this.w0 = e2.a.x(this.w0, this.B0, this.C0);
        this.h();
        Drawable drawable0 = this.v0;
        if(drawable0 != null && this.w0 != null) {
            drawable0 = new LayerDrawable(new Drawable[]{this.v0, this.w0});
        }
        else if(drawable0 == null) {
            drawable0 = this.w0;
        }
        if(drawable0 != null) {
            this.setSwitchMinWidth(drawable0.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable0);
    }

    public static void g(Drawable drawable0, ColorStateList colorStateList0, int[] arr_v, int[] arr_v1, float f) {
        if(drawable0 != null && colorStateList0 != null) {
            drawable0.setTint(c.d(f, colorStateList0.getColorForState(arr_v, 0), colorStateList0.getColorForState(arr_v1, 0)));
        }
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.s0;
    }

    public Drawable getThumbIconDrawable() {
        return this.t0;
    }

    public int getThumbIconSize() {
        return this.u0;
    }

    public ColorStateList getThumbIconTintList() {
        return this.y0;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.z0;
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.x0;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.w0;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.B0;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.C0;
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.v0;
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.A0;
    }

    public final void h() {
        if(this.x0 != null || this.y0 != null || this.A0 != null || this.B0 != null) {
            float f = this.getThumbPosition();
            ColorStateList colorStateList0 = this.x0;
            if(colorStateList0 != null) {
                MaterialSwitch.g(this.s0, colorStateList0, this.D0, this.E0, f);
            }
            ColorStateList colorStateList1 = this.y0;
            if(colorStateList1 != null) {
                MaterialSwitch.g(this.t0, colorStateList1, this.D0, this.E0, f);
            }
            ColorStateList colorStateList2 = this.A0;
            if(colorStateList2 != null) {
                MaterialSwitch.g(this.v0, colorStateList2, this.D0, this.E0, f);
            }
            ColorStateList colorStateList3 = this.B0;
            if(colorStateList3 != null) {
                MaterialSwitch.g(this.w0, colorStateList3, this.D0, this.E0, f);
            }
        }
    }

    @Override  // android.view.View
    public final void invalidate() {
        this.h();
        super.invalidate();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.t0 != null) {
            View.mergeDrawableStates(arr_v, MaterialSwitch.F0);
        }
        int[] arr_v1 = new int[arr_v.length];
        int v2 = 0;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v3 = arr_v[v1];
            if(v3 != 0x10100A0) {
                arr_v1[v2] = v3;
                ++v2;
            }
        }
        this.D0 = arr_v1;
        this.E0 = e2.a.E(arr_v);
        return arr_v;
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable0) {
        this.s0 = drawable0;
        this.e();
    }

    public void setThumbIconDrawable(Drawable drawable0) {
        this.t0 = drawable0;
        this.e();
    }

    public void setThumbIconResource(int v) {
        this.setThumbIconDrawable(w.B(this.getContext(), v));
    }

    public void setThumbIconSize(int v) {
        if(this.u0 != v) {
            this.u0 = v;
            this.e();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList0) {
        this.y0 = colorStateList0;
        this.e();
    }

    public void setThumbIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.z0 = porterDuff$Mode0;
        this.e();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList0) {
        this.x0 = colorStateList0;
        this.e();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode porterDuff$Mode0) {
        super.setThumbTintMode(porterDuff$Mode0);
        this.e();
    }

    public void setTrackDecorationDrawable(Drawable drawable0) {
        this.w0 = drawable0;
        this.f();
    }

    public void setTrackDecorationResource(int v) {
        this.setTrackDecorationDrawable(w.B(this.getContext(), v));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList0) {
        this.B0 = colorStateList0;
        this.f();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.C0 = porterDuff$Mode0;
        this.f();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable0) {
        this.v0 = drawable0;
        this.f();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList0) {
        this.A0 = colorStateList0;
        this.f();
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode porterDuff$Mode0) {
        super.setTrackTintMode(porterDuff$Mode0);
        this.f();
    }
}

