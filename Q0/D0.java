package Q0;

import G.g;
import P0.j0;
import U0.a;
import android.view.ViewGroup;
import ie.H;
import oe.c;
import r0.p;
import y0.M;

public final class d0 extends p implements a {
    public ViewGroup a;

    @Override  // U0.a
    public final Object d(j0 j00, g g0, c c0) {
        long v = j00.j0(0L);
        x0.c c1 = (x0.c)g0.invoke();
        x0.c c2 = c1 == null ? null : c1.h(v);
        if(c2 != null) {
            this.a.requestRectangleOnScreen(M.w(c2), false);
        }
        return H.a;
    }
}

