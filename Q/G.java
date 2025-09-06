package Q;

import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.a0;
import kotlin.jvm.internal.r;
import we.a;

public final class g extends r implements a {
    public final int f;
    public final K g;

    public g(K k0, int v) {
        this.f = v;
        this.g = k0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return this.g.l();
            }
            case 1: {
                return this.g.l();
            }
            case 2: {
                return this.g.k.b() ? ((K0)this.g.t).m() : this.g.j();
            }
            default: {
                K k0 = this.g;
                a0 a00 = k0.s;
                if(!k0.k.b()) {
                    return k0.i(k0.j());
                }
                if(((K0)a00).m() != -1) {
                    return k0.i(((K0)a00).m());
                }
                if(Math.abs(k0.d.a()) >= Math.abs(Math.min(k0.q.Y(O.a), ((float)k0.m()) / 2.0f) / ((float)k0.m()))) {
                    return ((Boolean)((O0)k0.H).getValue()).booleanValue() ? k0.i(k0.e + 1) : k0.i(k0.e);
                }
                return k0.i(k0.j());
            }
        }
    }
}

