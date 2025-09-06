package P7;

import O7.a;

public final class c implements a, b {
    public final Object a;

    public c(Object object0) {
        this.a = object0;
    }

    public static c a(Object object0) {
        if(object0 == null) {
            throw new NullPointerException("instance cannot be null");
        }
        return new c(object0);
    }

    @Override  // O7.a, javax.inject.Provider
    public final Object get() {
        return this.a;
    }
}

