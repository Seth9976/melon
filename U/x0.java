package U;

import a1.U;
import a1.a;
import a1.t;
import e1.i;
import r1.b;
import r1.c;

public abstract class x0 {
    public static final String a;

    static {
        x0.a = "HHHHHHHHHH";
    }

    public static final long a(U u0, c c0, i i0, String s, int v) {
        a a0 = t.a(s, u0, b.b(0, 0, 15), c0, i0, v, 0x40);
        return ((long)b0.r(a0.a.d())) << 0x20 | ((long)b0.r(a0.b())) & 0xFFFFFFFFL;
    }

    public static long b(U u0, c c0, i i0) {
        return x0.a(u0, c0, i0, "HHHHHHHHHH", 1);
    }
}

