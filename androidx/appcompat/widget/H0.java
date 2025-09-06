package androidx.appcompat.widget;

import E9.w;
import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;

public abstract class h0 {
    public static final int[] a;
    public static final int[] b;
    public static final Rect c;

    static {
        h0.a = new int[]{0x10100A0};
        h0.b = new int[0];
        h0.c = new Rect();
    }

    public static void a(Drawable drawable0) {
        String s = drawable0.getClass().getName();
        if(Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT < 0x1F && "android.graphics.drawable.ColorStateListDrawable".equals(s)) {
            int[] arr_v = drawable0.getState();
            if(arr_v == null || arr_v.length == 0) {
                drawable0.setState(h0.a);
            }
            else {
                drawable0.setState(h0.b);
            }
            drawable0.setState(arr_v);
        }
    }

    public static Rect b(Drawable drawable0) {
        int v = Build.VERSION.SDK_INT;
        if(v >= 29) {
            Insets insets0 = g0.a(drawable0);
            return new Rect(insets0.left, insets0.top, insets0.right, insets0.bottom);
        }
        Drawable drawable1 = w.V(drawable0);
        if(v < 29 && f0.a) {
            try {
                Object object0 = f0.b.invoke(drawable1, null);
                return object0 == null ? h0.c : new Rect(f0.c.getInt(object0), f0.d.getInt(object0), f0.e.getInt(object0), f0.f.getInt(object0));
            }
            catch(IllegalAccessException | InvocationTargetException unused_ex) {
            }
        }
        return h0.c;
    }

    public static PorterDuff.Mode c(int v, PorterDuff.Mode porterDuff$Mode0) {
        switch(v) {
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            default: {
                return porterDuff$Mode0;
            }
        }
    }
}

