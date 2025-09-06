package c2;

import android.view.View;

public abstract class P {
    public static int a(View view0) {
        return view0.getImportantForAutofill();
    }

    public static void b(View view0, int v) {
        view0.setImportantForAutofill(v);
    }
}

