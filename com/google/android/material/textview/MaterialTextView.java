package com.google.android.material.textview;

import E6.a;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import e1.m;
import e1.n;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context0) {
        this(context0, null);
    }

    public MaterialTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010084);
    }

    public MaterialTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0), attributeSet0, v);
        Context context1 = this.getContext();
        if(m.z(context1, 0x7F0405FE, true)) {  // attr:textAppearanceLineHeightEnabled
            Resources.Theme resources$Theme0 = context1.getTheme();
            int[] arr_v = d6.a.L;
            TypedArray typedArray0 = resources$Theme0.obtainStyledAttributes(attributeSet0, arr_v, v, 0);
            int v3 = -1;
            for(int v2 = 0; v2 < 2 && v3 < 0; ++v2) {
                v3 = n.t(context1, typedArray0, new int[]{1, 2}[v2], -1);
            }
            typedArray0.recycle();
            if(v3 == -1) {
                TypedArray typedArray1 = resources$Theme0.obtainStyledAttributes(attributeSet0, arr_v, v, 0);
                int v4 = typedArray1.getResourceId(0, -1);
                typedArray1.recycle();
                if(v4 != -1) {
                    TypedArray typedArray2 = resources$Theme0.obtainStyledAttributes(v4, d6.a.K);
                    Context context2 = this.getContext();
                    int v5 = -1;
                    for(int v1 = 0; v1 < 2 && v5 < 0; ++v1) {
                        v5 = n.t(context2, typedArray2, new int[]{1, 2}[v1], -1);
                    }
                    typedArray2.recycle();
                    if(v5 >= 0) {
                        this.setLineHeight(v5);
                    }
                }
            }
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatTextView
    public final void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        if(m.z(context0, 0x7F0405FE, true)) {  // attr:textAppearanceLineHeightEnabled
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(v, d6.a.K);
            Context context1 = this.getContext();
            int v2 = -1;
            for(int v1 = 0; v1 < 2 && v2 < 0; ++v1) {
                v2 = n.t(context1, typedArray0, new int[]{1, 2}[v1], -1);
            }
            typedArray0.recycle();
            if(v2 >= 0) {
                this.setLineHeight(v2);
            }
        }
    }
}

