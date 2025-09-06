package androidx.fragment.app;

import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import c2.K;

public final class s0 implements View.OnAttachStateChangeListener {
    public final View a;

    public s0(View view0) {
        this.a = view0;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        this.a.removeOnAttachStateChangeListener(this);
        K.c(this.a);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
    }
}

