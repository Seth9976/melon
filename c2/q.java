package c2;

import android.view.View;

public abstract class Q {
    public static CharSequence a(View view0) {
        return view0.getAccessibilityPaneTitle();
    }

    public static boolean b(View view0) {
        return view0.isAccessibilityHeading();
    }

    public static boolean c(View view0) {
        return view0.isScreenReaderFocusable();
    }

    public static void d(View view0, boolean z) {
        view0.setAccessibilityHeading(z);
    }

    public static void e(View view0, CharSequence charSequence0) {
        view0.setAccessibilityPaneTitle(charSequence0);
    }

    public static void f(View view0, boolean z) {
        view0.setScreenReaderFocusable(z);
    }
}

