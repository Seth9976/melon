package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets.Builder;

public abstract class o1 {
    public static void a(View view0, Rect rect0, Rect rect1) {
        Insets insets0 = view0.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect0)).build(), rect1).getSystemWindowInsets();
        rect0.set(insets0.left, insets0.top, insets0.right, insets0.bottom);
    }
}

