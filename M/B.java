package m;

import java.util.Iterator;

public final class b extends e implements Iterator {
    public c a;
    public c b;
    public final int c;

    public b(c c0, c c1, int v) {
        this.c = v;
        super();
        this.a = c1;
        this.b = c0;
    }

    @Override  // m.e
    public final void a(c c0) {
        c c1 = null;
        if(this.a == c0 && c0 == this.b) {
            this.b = null;
            this.a = null;
        }
        c c2 = this.a;
        if(c2 == c0) {
            this.a = this.c == 0 ? c2.d : c2.c;
        }
        c c3 = this.b;
        if(c3 == c0) {
            if(c3 != this.a && this.a != null) {
                c1 = this.b(c3);
            }
            this.b = c1;
        }
    }

    public final c b(c c0) {
        return this.c == 0 ? c0.c : c0.d;
    }

    @Override
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override
    public final Object next() {
        c c0 = this.b;
        this.b = c0 == this.a || this.a == null ? null : this.b(c0);
        return c0;
    }
}

