package h0;

import i0.b;
import java.util.List;
import je.f;

public final class a extends f {
    public final b a;
    public final int b;
    public final int c;

    public a(b b0, int v, int v1) {
        this.a = b0;
        this.b = v;
        e2.a.u(v, v1, b0.size());
        this.c = v1 - v;
    }

    @Override
    public final Object get(int v) {
        e2.a.s(v, this.c);
        return this.a.get(this.b + v);
    }

    @Override  // je.a
    public final int getSize() {
        return this.c;
    }

    @Override  // je.f
    public final List subList(int v, int v1) {
        e2.a.u(v, v1, this.c);
        return new a(this.a, v + this.b, this.b + v1);
    }
}

