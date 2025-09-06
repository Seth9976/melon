package androidx.appcompat.widget;

import android.view.ViewGroup;

public final class n0 implements Runnable {
    public final int a;
    public final ViewGroup b;

    public n0(ViewGroup viewGroup0, int v) {
        this.a = v;
        this.b = viewGroup0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ((Toolbar)this.b).v();
            return;
        }
        ((o0)this.b).l = null;
        ((o0)this.b).drawableStateChanged();
    }
}

