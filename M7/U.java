package M7;

import P7.b;

public final class u implements b {
    public final int a;

    public u(int v) {
        this.a = v;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return this.a != 0 ? f0.a : e0.a;
    }
}

