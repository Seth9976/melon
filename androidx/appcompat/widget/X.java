package androidx.appcompat.widget;

import E9.u;
import Y1.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

public final class x {
    public E0 a;
    public static final PorterDuff.Mode b;
    public static x c;

    static {
        x.b = PorterDuff.Mode.SRC_IN;
    }

    public static x a() {
        synchronized(x.class) {
            if(x.c == null) {
                x.d();
            }
            return x.c;
        }
    }

    public final Drawable b(Context context0, int v) {
        synchronized(this) {
            return this.a.c(context0, v);
        }
    }

    public static PorterDuffColorFilter c(int v, PorterDuff.Mode porterDuff$Mode0) {
        synchronized(x.class) {
            return E0.e(v, porterDuff$Mode0);
        }
    }

    public static void d() {
        synchronized(x.class) {
            if(x.c == null) {
                x x0 = new x();  // 初始化器: Ljava/lang/Object;-><init>()V
                x.c = x0;
                x0.a = E0.b();
                E0 e00 = x.c.a;
                synchronized(e00) {
                    e00.e = new u(2);
                }
            }
        }
    }

    public static void e(Drawable drawable0, b b0, int[] arr_v) {
        int[] arr_v1 = drawable0.getState();
        if(drawable0.mutate() == drawable0) {
            if(drawable0 instanceof LayerDrawable && drawable0.isStateful()) {
                drawable0.setState(new int[0]);
                drawable0.setState(arr_v1);
            }
            ColorFilter colorFilter0 = null;
            boolean z = b0.b;
            if(!z && !b0.a) {
                drawable0.clearColorFilter();
                return;
            }
            ColorStateList colorStateList0 = z ? ((ColorStateList)b0.c) : null;
            PorterDuff.Mode porterDuff$Mode0 = b0.a ? ((PorterDuff.Mode)b0.d) : E0.f;
            if(colorStateList0 != null && porterDuff$Mode0 != null) {
                colorFilter0 = E0.e(colorStateList0.getColorForState(arr_v, 0), porterDuff$Mode0);
            }
            drawable0.setColorFilter(colorFilter0);
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }
}

