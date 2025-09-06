package c2;

import B0.s;
import N4.z;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

public final class D extends z {
    public View h;
    public WindowInsetsController i;

    @Override  // N4.z
    public final void c() {
        View view0 = this.h;
        WindowInsetsController windowInsetsController0 = this.i;
        if(windowInsetsController0 == null) {
            windowInsetsController0 = view0 == null ? null : view0.getWindowInsetsController();
        }
        if(windowInsetsController0 != null) {
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
            C c0 = new C(atomicBoolean0);
            windowInsetsController0.addOnControllableInsetsChangedListener(c0);
            if(!atomicBoolean0.get() && view0 != null) {
                ((InputMethodManager)view0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view0.getWindowToken(), 0);
            }
            windowInsetsController0.removeOnControllableInsetsChangedListener(c0);
            windowInsetsController0.hide(s.B());
            return;
        }
        super.c();
    }

    @Override  // N4.z
    public final void d() {
        View view0 = this.h;
        if(view0 != null && Build.VERSION.SDK_INT < 33) {
            ((InputMethodManager)view0.getContext().getSystemService("input_method")).isActive();
        }
        WindowInsetsController windowInsetsController0 = this.i;
        if(windowInsetsController0 == null) {
            windowInsetsController0 = view0 == null ? null : view0.getWindowInsetsController();
        }
        if(windowInsetsController0 != null) {
            windowInsetsController0.show(s.B());
        }
        super.d();
    }
}

