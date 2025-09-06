package Z;

import P0.f;
import P0.l;
import P0.n0;
import P0.n;
import a0.b;
import y0.u;

public final class s extends n implements l, n0 {
    public final int c;
    public final K.l d;
    public final boolean e;
    public final float f;
    public final u g;
    public b h;

    public s(K.l l0, boolean z, u u0, int v) {
        this.c = v;
        super();
        this.d = l0;
        this.e = z;
        this.f = NaNf;
        this.g = u0;
    }

    @Override  // r0.p
    public final void onAttach() {
        if(this.c != 0) {
            f.r(this, new b0.l(this, 1));
            return;
        }
        f.r(this, new r(this, 1));
    }

    @Override  // P0.n0
    public final void y() {
        if(this.c != 0) {
            f.r(this, new b0.l(this, 1));
            return;
        }
        f.r(this, new r(this, 1));
    }
}

