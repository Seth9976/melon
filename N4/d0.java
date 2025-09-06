package N4;

import android.view.ViewGroup;

public abstract class d0 {
    public static int a(ViewGroup viewGroup0, int v) {
        return viewGroup0.getChildDrawingOrder(v);
    }

    public static void b(ViewGroup viewGroup0, boolean z) {
        viewGroup0.suppressLayout(z);
    }
}

