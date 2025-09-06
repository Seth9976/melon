package H;

import F.C;
import F.e;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import m0.b;
import p0.p;
import we.a;
import we.o;

public final class i {
    public final p a;

    public i() {
        this.a = new p();
    }

    public final void a(c c0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(1320309496);
        int v1 = (((androidx.compose.runtime.p)l0).g(c0) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).g(this) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            p p0 = this.a;
            int v3 = p0.size();
            for(int v2 = 0; v2 < v3; ++v2) {
                ((o)p0.get(v2)).invoke(c0, ((androidx.compose.runtime.p)l0), ((int)(v1 & 14)));
            }
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new B2.p(this, c0, v, 1);
        }
    }

    public static void b(i i0, e e0, a a0) {
        b b0 = new b(0xF9F600C, new C(e0, a0), true);
        i0.a.add(b0);
    }
}

