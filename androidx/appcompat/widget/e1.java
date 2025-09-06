package androidx.appcompat.widget;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.v;
import java.util.Objects;

public abstract class e1 {
    public static OnBackInvokedDispatcher a(View view0) {
        return view0.findOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Runnable runnable0) {
        Objects.requireNonNull(runnable0);
        return new v(runnable0, 1);
    }

    public static void c(Object object0, Object object1) {
        ((OnBackInvokedDispatcher)object0).registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)object1));
    }

    public static void d(Object object0, Object object1) {
        ((OnBackInvokedDispatcher)object0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)object1));
    }
}

