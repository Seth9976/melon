package r0;

import we.k;
import we.n;

public interface o extends q {
    @Override  // r0.q
    default boolean all(k k0) {
        return ((Boolean)k0.invoke(this)).booleanValue();
    }

    @Override  // r0.q
    default boolean any(k k0) {
        return ((Boolean)k0.invoke(this)).booleanValue();
    }

    @Override  // r0.q
    default Object foldIn(Object object0, n n0) {
        return n0.invoke(object0, this);
    }
}

