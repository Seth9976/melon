package nf;

import f0.I;

public final class b extends I {
    @Override  // f0.I
    public final Object d(int v) {
        return this.e(v);
    }

    public final Boolean e(int v) {
        return Boolean.valueOf((v & 1 << this.b) != 0);
    }
}

