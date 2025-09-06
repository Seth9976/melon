package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.q;

public final class l implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public l(G0 g00, View view0, Rect rect0) {
        this.a = 0;
        super();
        this.b = view0;
        this.c = rect0;
    }

    public l(n n0, ViewGroup viewGroup0) {
        this.a = 1;
        super();
        this.b = n0;
        this.c = viewGroup0;
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ViewGroup viewGroup0 = (ViewGroup)this.c;
            q.g(viewGroup0, "$container");
            for(Object object0: ((n)this.b).c) {
                L0 l00 = ((o)object0).a;
                View view0 = l00.c.getView();
                if(view0 != null) {
                    androidx.appcompat.app.o.a(l00.a, view0, viewGroup0);
                }
            }
            return;
        }
        G0.j(((View)this.b), ((Rect)this.c));
    }
}

