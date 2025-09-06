package R;

import G.g;
import I.i;
import I.l;
import N0.v;
import P0.f;
import P0.j0;
import P0.y;
import U0.a;
import ie.H;
import kotlinx.coroutines.CoroutineScopeKt;
import oe.c;
import r0.p;

public final class h extends p implements y, a {
    public l a;
    public boolean b;

    @Override  // U0.a
    public final Object d(j0 j00, g g0, c c0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new R.g(this, j00, g0, new i(this, j00, g0, 4), null), c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // P0.y
    public final void g(v v0) {
        this.b = true;
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public static final x0.c m0(h h0, j0 j00, g g0) {
        if(h0.isAttached() && h0.b) {
            j0 j01 = f.u(h0);
            if(!j00.h()) {
                j00 = null;
            }
            if(j00 != null) {
                x0.c c0 = (x0.c)g0.invoke();
                return c0 == null ? null : c0.h(j01.f(j00, false).c());
            }
        }
        return null;
    }
}

