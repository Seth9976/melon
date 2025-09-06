package androidx.appcompat.widget;

import android.transition.Transition;
import android.widget.PopupWindow;

public abstract class z0 {
    public static void a(PopupWindow popupWindow0, Transition transition0) {
        popupWindow0.setEnterTransition(transition0);
    }

    public static void b(PopupWindow popupWindow0, Transition transition0) {
        popupWindow0.setExitTransition(transition0);
    }
}

