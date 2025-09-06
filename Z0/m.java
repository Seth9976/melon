package z0;

import P4.a;

public final class m implements i {
    public final int a;
    public final q b;

    public m(q q0, int v) {
        this.a = v;
        this.b = q0;
        super();
    }

    @Override  // z0.i
    public final double a(double f) {
        if(this.a != 0) {
            double f1 = a.h(f, this.b.e, this.b.f);
            return this.b.n.a(f1);
        }
        return a.h(this.b.k.a(f), this.b.e, this.b.f);
    }
}

