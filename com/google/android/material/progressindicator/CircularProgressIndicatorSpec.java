package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.B;
import d6.a;
import e1.n;
import v6.e;

public final class CircularProgressIndicatorSpec extends e {
    public int h;
    public int i;
    public int j;

    public CircularProgressIndicatorSpec(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040136);  // attr:circularProgressIndicatorStyle
    }

    public CircularProgressIndicatorSpec(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F14049C);  // style:Widget.MaterialComponents.CircularProgressIndicator
        int v1 = context0.getResources().getDimensionPixelSize(0x7F0703BC);  // dimen:mtrl_progress_circular_size_medium
        int v2 = context0.getResources().getDimensionPixelSize(0x7F0703B7);  // dimen:mtrl_progress_circular_inset_medium
        B.c(context0, attributeSet0, v, 0x7F14049C);  // style:Widget.MaterialComponents.CircularProgressIndicator
        B.d(context0, attributeSet0, a.l, v, 0x7F14049C, new int[0]);  // style:Widget.MaterialComponents.CircularProgressIndicator
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.l, v, 0x7F14049C);  // style:Widget.MaterialComponents.CircularProgressIndicator
        this.h = Math.max(n.t(context0, typedArray0, 2, v1), this.a * 2);
        this.i = n.t(context0, typedArray0, 1, v2);
        this.j = typedArray0.getInt(0, 0);
        typedArray0.recycle();
        this.a();
    }
}

