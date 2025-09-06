package c2;

import G6.c;
import android.view.View;
import java.lang.ref.WeakReference;

public final class c0 {
    public final WeakReference a;

    public c0(View view0) {
        this.a = new WeakReference(view0);
    }

    public final void a(float f) {
        View view0 = (View)this.a.get();
        if(view0 != null) {
            view0.animate().alpha(f);
        }
    }

    public final void b() {
        View view0 = (View)this.a.get();
        if(view0 != null) {
            view0.animate().cancel();
        }
    }

    public final void c(long v) {
        View view0 = (View)this.a.get();
        if(view0 != null) {
            view0.animate().setDuration(v);
        }
    }

    public final void d(d0 d00) {
        View view0 = (View)this.a.get();
        if(view0 != null) {
            if(d00 != null) {
                view0.animate().setListener(new c(2, d00, view0));
                return;
            }
            view0.animate().setListener(null);
        }
    }

    public final void e(float f) {
        View view0 = (View)this.a.get();
        if(view0 != null) {
            view0.animate().translationY(f);
        }
    }
}

