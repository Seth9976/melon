package androidx.compose.foundation;

import K.l;
import kotlin.jvm.internal.r;
import we.a;

public final class h0 extends r implements a {
    public final int f;
    public static final h0 g;
    public static final h0 h;

    static {
        h0.g = new h0(0, 0);
        h0.h = new h0(0, 1);
    }

    public h0(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return (l l0) -> new K(l0);
            }
            case 1: {
                return new C0();
            }
            default: {
                return new Q0(0);
            }
        }
    }
}

