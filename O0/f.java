package o0;

import F.g;
import androidx.collection.K;
import androidx.compose.foundation.w;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import d5.l;
import ie.H;
import java.util.Map;
import m0.b;

public final class f implements c {
    public final Map a;
    public final K b;
    public i c;
    public final w d;
    public static final l e;

    static {
        f.e = new l(13, d.g, e.g);
    }

    public f(Map map0) {
        this.a = map0;
        this.b = new K();
        this.d = new w(this, 18);
    }

    @Override  // o0.c
    public final void e(Object object0, b b0, androidx.compose.runtime.l l0, int v) {
        ((p)l0).a0(0xB88FC293);
        ((p)l0).d0(object0);
        j j0 = ((p)l0).N();
        V v1 = k.a;
        if(j0 == v1) {
            w w0 = this.d;
            if(!((Boolean)w0.invoke(object0)).booleanValue()) {
                throw new IllegalArgumentException(("Type of the key " + object0 + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
            j j1 = new j(((Map)this.a.get(object0)), w0);
            ((p)l0).l0(j1);
            j0 = j1;
        }
        androidx.compose.runtime.w.a(o0.k.a.a(j0), b0, ((p)l0), v & 0x70 | 8);
        boolean z = ((p)l0).i(this);
        boolean z1 = ((p)l0).i(object0);
        boolean z2 = ((p)l0).i(j0);
        g g0 = ((p)l0).N();
        if((z | z1 | z2) != 0 || g0 == v1) {
            g0 = new g(this, object0, j0, 19);
            ((p)l0).l0(g0);
        }
        J.b(H.a, g0, ((p)l0));
        if(((p)l0).x && ((p)l0).F.i == ((p)l0).y) {
            ((p)l0).y = -1;
            ((p)l0).x = false;
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
    }
}

