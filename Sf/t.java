package Sf;

import java.util.Iterator;
import kotlin.jvm.internal.q;

public final class t implements k {
    public final k a;
    public final we.k b;

    public t(k k0, we.k k1) {
        q.g(k0, "sequence");
        q.g(k1, "transformer");
        super();
        this.a = k0;
        this.b = k1;
    }

    @Override  // Sf.k
    public final Iterator iterator() {
        return new s(this);
    }
}

