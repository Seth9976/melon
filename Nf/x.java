package Nf;

import bf.f;

public final class x extends n {
    public final int c;
    public final int d;

    public x() {
        this.c = 1;
        super("must have exactly 2 value parameters", 1);
        this.d = 2;
    }

    public x(int v) {
        this.c = 0;
        StringBuilder stringBuilder0 = U4.x.n(v, "must have at least ", " value parameter");
        stringBuilder0.append((v <= 1 ? "" : "s"));
        super(stringBuilder0.toString(), 1);
        this.d = v;
    }

    @Override  // Nf.e
    public final boolean a(f f0) {
        return this.c == 0 ? f0.F().size() >= this.d : f0.F().size() == this.d;
    }
}

