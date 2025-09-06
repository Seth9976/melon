package c2;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

public abstract class T {
    public static WindowInsets a(View view0, WindowInsets windowInsets0) {
        return view0.dispatchApplyWindowInsets(windowInsets0);
    }

    public static CharSequence b(View view0) {
        return view0.getStateDescription();
    }

    public static F0 c(View view0) {
        WindowInsetsController windowInsetsController0 = view0.getWindowInsetsController();
        return windowInsetsController0 == null ? null : new F0(windowInsetsController0);
    }

    public static void d(View view0, CharSequence charSequence0) {
        view0.setStateDescription(charSequence0);
    }
}

