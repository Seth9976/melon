package m;

import java.util.Iterator;

public final class d extends e implements Iterator {
    public c a;
    public boolean b;
    public final f c;

    public d(f f0) {
        this.c = f0;
        this.b = true;
    }

    @Override  // m.e
    public final void a(c c0) {
        c c1 = this.a;
        if(c0 == c1) {
            this.a = c1.d;
            this.b = c1.d == null;
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean hasNext() {
        return this.b ? this.c.a != null : this.a != null && this.a.c != null;
    }

    @Override
    public final Object next() {
        if(this.b) {
            this.b = false;
            this.a = this.c.a;
            return this.a;
        }
        this.a = this.a == null ? null : this.a.c;
        return this.a;
    }
}

