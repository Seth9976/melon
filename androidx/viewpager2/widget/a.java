package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;

public final class a {
    public static final ViewGroup.MarginLayoutParams a;

    static {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = new ViewGroup.MarginLayoutParams(-1, -1);
        a.a = viewGroup$MarginLayoutParams0;
        viewGroup$MarginLayoutParams0.setMargins(0, 0, 0, 0);
    }

    public static boolean a(View view0) {
        if(view0 instanceof ViewGroup) {
            LayoutTransition layoutTransition0 = ((ViewGroup)view0).getLayoutTransition();
            if(layoutTransition0 != null && layoutTransition0.isChangingLayout()) {
                return true;
            }
            int v = ((ViewGroup)view0).getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                if(a.a(((ViewGroup)view0).getChildAt(v1))) {
                    return true;
                }
            }
        }
        return false;
    }
}

