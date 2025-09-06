package I;

import G.S;

public final class b1 implements F0 {
    public final g1 a;
    public final d1 b;

    public b1(g1 g10, d1 d10) {
        this.a = g10;
        this.b = d10;
    }

    @Override  // I.F0
    public final float a(float f) {
        g1 g10 = this.a;
        if(Float.compare(Math.abs(f), 0.0f) != 0 && (f > 0.0f && !g10.a.d() || f < 0.0f && !g10.a.c() || !((Boolean)g10.g.invoke()).booleanValue())) {
            throw new S("The fling animation was cancelled", 1);
        }
        long v = g10.d(g10.g(f));
        return g10.c(g10.f(this.b.a(2, v)));
    }
}

