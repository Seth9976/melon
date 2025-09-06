package m0;

import h7.u0;
import kotlin.jvm.internal.q;

public final class d {
    public int a;

    public d() {
        this.a = 0;
    }

    @Override
    public final String toString() {
        u0.l(16);
        String s = Integer.toString(this.hashCode(), 16);
        q.f(s, "toString(...)");
        return "IntRef(element = " + this.a + ")@" + s;
    }
}

