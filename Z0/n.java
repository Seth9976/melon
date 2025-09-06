package z0;

public final class n implements i {
    public final int a;
    public final double b;

    public n(double f, int v) {
        this.a = v;
        this.b = f;
        super();
    }

    @Override  // z0.i
    public final double a(double f) {
        if(this.a != 0) {
            if(f < 0.0) {
                f = 0.0;
            }
            return Math.pow(f, this.b);
        }
        if(f < 0.0) {
            f = 0.0;
        }
        return Math.pow(f, 1.0 / this.b);
    }
}

