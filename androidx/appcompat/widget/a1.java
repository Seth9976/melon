package androidx.appcompat.widget;

import S1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import d5.m;
import g.a;

public abstract class a1 {
    public static final ThreadLocal a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;

    static {
        a1.a = new ThreadLocal();
        a1.b = new int[]{0xFEFEFF62};
        a1.c = new int[]{0x101009C};
        a1.d = new int[]{0x10100A7};
        a1.e = new int[]{0x10100A0};
        a1.f = new int[0];
        a1.g = new int[1];
    }

    public static void a(Context context0, View view0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(a.k);
        try {
            if(!typedArray0.hasValue(0x75)) {
                Log.e("ThemeUtils", "View " + view0.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        }
        finally {
            typedArray0.recycle();
        }
    }

    public static int b(Context context0, int v) {
        ColorStateList colorStateList0 = a1.d(context0, v);
        if(colorStateList0 != null && colorStateList0.isStateful()) {
            int v1 = colorStateList0.getDefaultColor();
            return colorStateList0.getColorForState(a1.b, v1);
        }
        ThreadLocal threadLocal0 = a1.a;
        TypedValue typedValue0 = (TypedValue)threadLocal0.get();
        if(typedValue0 == null) {
            typedValue0 = new TypedValue();
            threadLocal0.set(typedValue0);
        }
        context0.getTheme().resolveAttribute(0x1010033, typedValue0, true);
        float f = typedValue0.getFloat();
        int v2 = a1.c(context0, v);
        return c.k(v2, Math.round(((float)Color.alpha(v2)) * f));
    }

    public static int c(Context context0, int v) {
        a1.g[0] = v;
        m m0 = m.q(context0, null, a1.g);
        try {
            return ((TypedArray)m0.c).getColor(0, 0);
        }
        finally {
            m0.t();
        }
    }

    public static ColorStateList d(Context context0, int v) {
        a1.g[0] = v;
        m m0 = m.q(context0, null, a1.g);
        try {
            return m0.j(0);
        }
        finally {
            m0.t();
        }
    }
}

