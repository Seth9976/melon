package B2;

import we.k;

public interface m extends n {
    @Override  // B2.n
    default boolean a() {
        return true;
    }

    @Override  // B2.n
    default boolean any(k k0) {
        return ((Boolean)k0.invoke(this)).booleanValue();
    }

    @Override  // B2.n
    default Object foldIn(Object object0, we.n n0) {
        return n0.invoke(object0, this);
    }
}

