package z6;

public final class j extends f {
    public final g b;
    public final float c;

    public j(g g0, float f) {
        super(0);
        this.b = g0;
        this.c = f;
    }

    @Override  // z6.f
    public final boolean d() {
        return true;
    }

    @Override  // z6.f
    public final void l(float f, float f1, float f2, x x0) {
        this.b.l(f, f1 - this.c, f2, x0);
    }
}

