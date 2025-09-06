package c2;

import android.os.Build.VERSION;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class I implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    public final WeakHashMap a;

    public I() {
        this.a = new WeakHashMap();
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if(Build.VERSION.SDK_INT < 28) {
            for(Object object0: this.a.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                View view0 = (View)map$Entry0.getKey();
                boolean z = ((Boolean)map$Entry0.getValue()).booleanValue();
                boolean z1 = view0.isShown() && view0.getWindowVisibility() == 0;
                if(z != z1) {
                    W.i(view0, (z1 ? 16 : 0x20));
                    map$Entry0.setValue(Boolean.valueOf(z1));
                }
            }
        }
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        view0.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
    }
}

