package c2;

import android.os.Build.VERSION;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;

public final class L implements View.OnApplyWindowInsetsListener {
    public B0 a;
    public final View b;
    public final v c;

    public L(View view0, v v0) {
        this.b = view0;
        this.c = v0;
        super();
        this.a = null;
    }

    @Override  // android.view.View$OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
        B0 b00 = B0.h(view0, windowInsets0);
        int v = Build.VERSION.SDK_INT;
        v v1 = this.c;
        if(v < 30) {
            M.a(windowInsets0, this.b);
            if(b00.equals(this.a)) {
                return v1.s(view0, b00).g();
            }
        }
        this.a = b00;
        B0 b01 = v1.s(view0, b00);
        if(v >= 30) {
            return b01.g();
        }
        K.c(view0);
        return b01.g();
    }
}

