package c2;

import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver;

public final class x implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    public final View a;
    public ViewTreeObserver b;
    public final Runnable c;

    public x(View view0, Runnable runnable0) {
        this.a = view0;
        this.b = view0.getViewTreeObserver();
        this.c = runnable0;
    }

    public static void a(View view0, Runnable runnable0) {
        if(view0 == null) {
            throw new NullPointerException("view == null");
        }
        x x0 = new x(view0, runnable0);
        view0.getViewTreeObserver().addOnPreDrawListener(x0);
        view0.addOnAttachStateChangeListener(x0);
    }

    @Override  // android.view.ViewTreeObserver$OnPreDrawListener
    public final boolean onPreDraw() {
        boolean z = this.b.isAlive();
        View view0 = this.a;
        if(z) {
            this.b.removeOnPreDrawListener(this);
        }
        else {
            view0.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view0.removeOnAttachStateChangeListener(this);
        this.c.run();
        return true;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        this.b = view0.getViewTreeObserver();
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        boolean z = this.b.isAlive();
        View view1 = this.a;
        if(z) {
            this.b.removeOnPreDrawListener(this);
        }
        else {
            view1.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view1.removeOnAttachStateChangeListener(this);
    }
}

