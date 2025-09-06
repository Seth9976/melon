package com.google.android.material.switchmaterial;

import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SwitchCompat;
import c2.M;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.B;
import e1.n;

public class SwitchMaterial extends SwitchCompat {
    public final ElevationOverlayProvider s0;
    public ColorStateList t0;
    public ColorStateList u0;
    public boolean v0;
    public static final int[][] w0;

    static {
        SwitchMaterial.w0 = new int[][]{new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};
    }

    public SwitchMaterial(Context context0) {
        this(context0, null);
    }

    public SwitchMaterial(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0405BF);  // attr:switchStyle
    }

    public SwitchMaterial(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404A3), attributeSet0, v);  // style:Widget.MaterialComponents.CompoundButton.Switch
        Context context1 = this.getContext();
        this.s0 = new ElevationOverlayProvider(context1);
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.c0, v, 0x7F1404A3, new int[0]);  // style:Widget.MaterialComponents.CompoundButton.Switch
        this.v0 = typedArray0.getBoolean(0, false);
        typedArray0.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if(this.t0 == null) {
            int v = n.q(this, 0x7F040190);  // attr:colorSurface
            int v1 = n.q(this, 0x7F040166);  // attr:colorControlActivated
            float f = this.getResources().getDimension(0x7F0703D8);  // dimen:mtrl_switch_thumb_elevation
            ElevationOverlayProvider elevationOverlayProvider0 = this.s0;
            if(elevationOverlayProvider0.a) {
                ViewParent viewParent0 = this.getParent();
                float f1 = 0.0f;
                while(viewParent0 instanceof View) {
                    f1 += M.e(((View)viewParent0));
                    viewParent0 = viewParent0.getParent();
                }
                f += f1;
            }
            int v2 = elevationOverlayProvider0.a(f, v);
            int[] arr_v = {n.A(1.0f, v, v1), v2, n.A(0.38f, v, v1), v2};
            this.t0 = new ColorStateList(SwitchMaterial.w0, arr_v);
        }
        return this.t0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if(this.u0 == null) {
            int v = n.q(this, 0x7F040190);  // attr:colorSurface
            int v1 = n.q(this, 0x7F040166);  // attr:colorControlActivated
            int v2 = n.q(this, 0x7F040179);  // attr:colorOnSurface
            int[] arr_v = {n.A(0.54f, v, v1), n.A(0.32f, v, v2), n.A(0.12f, v, v1), n.A(0.12f, v, v2)};
            this.u0 = new ColorStateList(SwitchMaterial.w0, arr_v);
        }
        return this.u0;
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.v0 && this.getThumbTintList() == null) {
            this.setThumbTintList(this.getMaterialThemeColorsThumbTintList());
        }
        if(this.v0 && this.getTrackTintList() == null) {
            this.setTrackTintList(this.getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.v0 = z;
        if(z) {
            this.setThumbTintList(this.getMaterialThemeColorsThumbTintList());
            this.setTrackTintList(this.getMaterialThemeColorsTrackTintList());
            return;
        }
        this.setThumbTintList(null);
        this.setTrackTintList(null);
    }
}

