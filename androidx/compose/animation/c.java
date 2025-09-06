package androidx.compose.animation;

import G.a0;
import G.f;
import d5.n;
import r0.q;
import r1.l;

public abstract class c {
    public static final long a;

    static {
        c.a = 0x8000000080000000L;
    }

    public static q a(q q0) {
        a0 a00 = f.q(400.0f, 1, new l(0x100000001L));
        return n.p(q0).then(new SizeAnimationModifierElement(a00));
    }
}

