package x6;

import S1.c;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;

public abstract class a {
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final String f;

    static {
        a.a = new int[]{0x10100A7};
        a.b = new int[]{0x101009C};
        a.c = new int[]{0x10100A1, 0x10100A7};
        a.d = new int[]{0x10100A1};
        a.e = new int[]{0x101009E, 0x10100A7};
        a.f = "a";
    }

    public static ColorStateList a(ColorStateList colorStateList0) {
        int[][] arr2_v = new int[3][];
        int[] arr_v = new int[3];
        arr2_v[0] = a.d;
        arr_v[0] = a.b(colorStateList0, a.c);
        arr2_v[1] = a.b;
        arr_v[1] = a.b(colorStateList0, a.b);
        arr2_v[2] = StateSet.NOTHING;
        arr_v[2] = a.b(colorStateList0, a.a);
        return new ColorStateList(arr2_v, arr_v);
    }

    public static int b(ColorStateList colorStateList0, int[] arr_v) {
        if(colorStateList0 != null) {
            int v = colorStateList0.getColorForState(arr_v, colorStateList0.getDefaultColor());
            return c.k(v, Math.min(Color.alpha(v) * 2, 0xFF));
        }
        return c.k(0, 0);
    }

    public static ColorStateList c(ColorStateList colorStateList0) {
        if(colorStateList0 != null) {
            if(Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList0.getDefaultColor()) == 0 && Color.alpha(colorStateList0.getColorForState(a.e, 0)) != 0) {
                Log.w("a", "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList0;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean d(int[] arr_v) {
        boolean z = false;
        boolean z1 = false;
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            if(v1 == 0x101009E) {
                z = true;
            }
            else if(v1 == 0x101009C || v1 == 0x10100A7 || v1 == 0x1010367) {
                z1 = true;
            }
        }
        return z && z1;
    }
}

