package I6;

public final class x extends z {
    public final int f;
    public final B g;

    public x(B b0, int v) {
        this.f = v;
        this.g = b0;
        super(b0);
    }

    @Override  // I6.z
    public final Object b(int v) {
        switch(this.f) {
            case 0: {
                return this.g.k()[v];
            }
            case 1: {
                return new A(this.g, v);
            }
            default: {
                return this.g.l()[v];
            }
        }
    }
}

