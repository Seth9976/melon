package c2;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;

public abstract class M {
    public static void a(WindowInsets windowInsets0, View view0) {
        View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0 = (View.OnApplyWindowInsetsListener)view0.getTag(0x7F0A0B37);  // id:tag_window_insets_animation_callback
        if(view$OnApplyWindowInsetsListener0 != null) {
            view$OnApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsets0);
        }
    }

    public static B0 b(View view0, B0 b00, Rect rect0) {
        WindowInsets windowInsets0 = b00.g();
        if(windowInsets0 != null) {
            return B0.h(view0, view0.computeSystemWindowInsets(windowInsets0, rect0));
        }
        rect0.setEmpty();
        return b00;
    }

    public static ColorStateList c(View view0) {
        return view0.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view0) {
        return view0.getBackgroundTintMode();
    }

    public static float e(View view0) {
        return view0.getElevation();
    }

    public static String f(View view0) {
        return view0.getTransitionName();
    }

    public static float g(View view0) {
        return view0.getTranslationZ();
    }

    public static float h(View view0) {
        return view0.getZ();
    }

    public static boolean i(View view0) {
        return view0.isNestedScrollingEnabled();
    }

    public static void j(View view0, ColorStateList colorStateList0) {
        view0.setBackgroundTintList(colorStateList0);
    }

    public static void k(View view0, PorterDuff.Mode porterDuff$Mode0) {
        view0.setBackgroundTintMode(porterDuff$Mode0);
    }

    public static void l(View view0, float f) {
        view0.setElevation(f);
    }

    public static void m(View view0, boolean z) {
        view0.setNestedScrollingEnabled(z);
    }

    public static void n(View view0, v v0) {
        L l0 = v0 == null ? null : new L(view0, v0);
        if(Build.VERSION.SDK_INT < 30) {
            view0.setTag(0x7F0A0B2A, l0);  // id:tag_on_apply_window_listener
        }
        if(view0.getTag(0x7F0A0B23) != null) {  // id:tag_compat_insets_dispatch
            return;
        }
        if(l0 != null) {
            view0.setOnApplyWindowInsetsListener(l0);
            return;
        }
        view0.setOnApplyWindowInsetsListener(((View.OnApplyWindowInsetsListener)view0.getTag(0x7F0A0B37)));  // id:tag_window_insets_animation_callback
    }

    public static void o(View view0, String s) {
        view0.setTransitionName(s);
    }

    public static void p(View view0, float f) {
        view0.setTranslationZ(f);
    }

    public static void q(View view0) {
        view0.stopNestedScroll();
    }
}

