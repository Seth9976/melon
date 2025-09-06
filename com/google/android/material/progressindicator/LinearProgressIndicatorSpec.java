package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.B;
import d6.a;
import v6.e;

public final class LinearProgressIndicatorSpec extends e {
    public int h;
    public int i;
    public boolean j;
    public int k;

    public LinearProgressIndicatorSpec(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403B8);  // attr:linearProgressIndicatorStyle
    }

    public LinearProgressIndicatorSpec(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F1404A8);  // style:Widget.MaterialComponents.LinearProgressIndicator
        boolean z = false;
        B.c(context0, attributeSet0, 0x7F0403B8, 0x7F1404A8);  // attr:linearProgressIndicatorStyle
        B.d(context0, attributeSet0, a.x, 0x7F0403B8, 0x7F1404A8, new int[0]);  // attr:linearProgressIndicatorStyle
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.x, 0x7F0403B8, 0x7F1404A8);  // attr:linearProgressIndicatorStyle
        this.h = typedArray0.getInt(0, 1);
        this.i = typedArray0.getInt(1, 0);
        this.k = Math.min(typedArray0.getDimensionPixelSize(2, 0), this.a);
        typedArray0.recycle();
        this.a();
        if(this.i == 1) {
            z = true;
        }
        this.j = z;
    }

    @Override  // v6.e
    public final void a() {
        super.a();
        if(this.k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if(this.h == 0) {
            if(this.b > 0 && this.g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if(this.c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}

