package androidx.compose.ui.draw;

import C0.c;
import r0.d;
import r0.e;
import r0.q;
import we.k;
import y0.t;

public abstract class a {
    public static final q a(q q0, k k0) {
        return q0.then(new DrawBehindElement(k0));
    }

    public static final q b(q q0, k k0) {
        return q0.then(new DrawWithCacheElement(k0));
    }

    public static final q c(q q0, k k0) {
        return q0.then(new DrawWithContentElement(k0));
    }

    public static q d(q q0, c c0, e e0, N0.k k0, float f, t t0, int v) {
        if((v & 4) != 0) {
            e0 = d.e;
        }
        if((v & 16) != 0) {
            f = 1.0f;
        }
        return q0.then(new PainterElement(c0, e0, k0, f, t0));
    }
}

