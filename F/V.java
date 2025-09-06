package F;

import G.t0;
import androidx.compose.runtime.O0;
import kotlin.jvm.internal.r;
import we.a;

public final class v extends r implements a {
    public final int f;
    public final t0 g;

    public v(t0 t00, int v) {
        this.f = v;
        this.g = t00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            return this.g.b();
        }
        return this.g.c() != L.c || ((O0)this.g.d).getValue() != L.c ? false : true;
    }
}

