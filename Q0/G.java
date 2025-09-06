package Q0;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final u a;

    public g(u u0) {
        this.a = u0;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.L();
    }
}

