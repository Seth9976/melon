package Nf;

import bf.f;

public final class y extends n {
    public final int c;
    public static final y d;
    public static final y e;

    static {
        y.d = new y("must have no value parameters", 0);
        y.e = new y("must have a single value parameter", 1);
    }

    public y(String s, int v) {
        this.c = v;
        super(s, 1);
    }

    @Override  // Nf.e
    public final boolean a(f f0) {
        return this.c == 0 ? f0.F().isEmpty() : f0.F().size() == 1;
    }
}

