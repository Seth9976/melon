package androidx.compose.foundation;

import N0.v;
import androidx.compose.runtime.O0;
import ie.H;
import kotlin.jvm.internal.r;
import we.a;
import x0.b;

public final class m0 extends r implements a {
    public final int f;
    public final o0 g;

    public m0(o0 o00, int v) {
        this.f = v;
        this.g = o00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                v v0 = (v)((O0)this.g.g).getValue();
                return v0 == null ? new b(0x7FC000007FC00000L) : new b(v0.j0(0L));
            }
            case 1: {
                return new b(this.g.i);
            }
            default: {
                this.g.o0();
                return H.a;
            }
        }
    }
}

