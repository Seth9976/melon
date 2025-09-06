package com.google.android.material.elevation;

import S1.c;
import android.content.Context;
import android.graphics.Color;
import e1.m;
import e1.n;

public class ElevationOverlayProvider {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public static final int f;

    static {
        ElevationOverlayProvider.f = 5;
    }

    public ElevationOverlayProvider(Context context0) {
        boolean z = m.z(context0, 0x7F040233, false);  // attr:elevationOverlayEnabled
        int v = n.o(context0, 0x7F040232, 0);  // attr:elevationOverlayColor
        int v1 = n.o(context0, 0x7F040231, 0);  // attr:elevationOverlayAccentColor
        int v2 = n.o(context0, 0x7F040190, 0);  // attr:colorSurface
        float f = context0.getResources().getDisplayMetrics().density;
        super();
        this.a = z;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = f;
    }

    public final int a(float f, int v) {
        if(this.a && c.k(v, 0xFF) == this.d) {
            float f1 = this.e <= 0.0f || f <= 0.0f ? 0.0f : Math.min((((float)Math.log1p(f / this.e)) * 4.5f + 2.0f) / 100.0f, 1.0f);
            int v1 = Color.alpha(v);
            int v2 = n.A(f1, c.k(v, 0xFF), this.b);
            if(f1 > 0.0f) {
                int v3 = this.c;
                if(v3 != 0) {
                    v2 = c.h(c.k(v3, ElevationOverlayProvider.f), v2);
                }
            }
            return c.k(v2, v1);
        }
        return v;
    }
}

