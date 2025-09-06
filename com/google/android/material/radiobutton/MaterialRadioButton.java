package com.google.android.material.radiobutton;

import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.google.android.material.internal.B;
import e1.n;

public class MaterialRadioButton extends AppCompatRadioButton {
    public ColorStateList e;
    public boolean f;
    public static final int[][] g;

    static {
        MaterialRadioButton.g = new int[][]{new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};
    }

    public MaterialRadioButton(Context context0) {
        this(context0, null);
    }

    public MaterialRadioButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0404F8);  // attr:radioButtonStyle
    }

    public MaterialRadioButton(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404A2), attributeSet0, v);  // style:Widget.MaterialComponents.CompoundButton.RadioButton
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.H, v, 0x7F1404A2, new int[0]);  // style:Widget.MaterialComponents.CompoundButton.RadioButton
        if(typedArray0.hasValue(0)) {
            this.setButtonTintList(n.r(context1, typedArray0, 0));
        }
        this.f = typedArray0.getBoolean(1, false);
        typedArray0.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if(this.e == null) {
            int v = n.q(this, 0x7F040166);  // attr:colorControlActivated
            int v1 = n.q(this, 0x7F040179);  // attr:colorOnSurface
            int v2 = n.q(this, 0x7F040190);  // attr:colorSurface
            int[] arr_v = {n.A(1.0f, v2, v), n.A(0.54f, v2, v1), n.A(0.38f, v2, v1), n.A(0.38f, v2, v1)};
            this.e = new ColorStateList(MaterialRadioButton.g, arr_v);
        }
        return this.e;
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.f && this.getButtonTintList() == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        if(z) {
            this.setButtonTintList(this.getMaterialThemeColorsTintList());
            return;
        }
        this.setButtonTintList(null);
    }
}

