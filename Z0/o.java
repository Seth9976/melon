package z0;

public final class o implements i {
    public final int a;
    public final r b;

    public o(r r0, int v) {
        this.a = v;
        this.b = r0;
        super();
    }

    @Override  // z0.i
    public final double a(double f) {
        r r0 = this.b;
        switch(this.a) {
            case 0: {
                return d.a(r0, f);
            }
            case 1: {
                return d.c(r0, f);
            }
            case 2: {
                return f >= r0.e ? Math.pow(r0.b * f + r0.c, r0.a) : f * r0.d;
            }
            case 3: {
                return f >= r0.e ? Math.pow(r0.b * f + r0.c, r0.a) + r0.f : r0.d * f + r0.g;
            }
            case 4: {
                return d.b(r0, f);
            }
            case 5: {
                return d.d(r0, f);
            }
            case 6: {
                return f >= r0.e * r0.d ? (Math.pow(f, 1.0 / r0.a) - r0.c) / r0.b : f / r0.d;
            }
            default: {
                return f >= r0.e * r0.d ? (Math.pow(f - r0.f, 1.0 / r0.a) - r0.c) / r0.b : (f - r0.g) / r0.d;
            }
        }
    }
}

