package i.n.i.b.a.s.e;

import java.util.NoSuchElementException;

public abstract class o1 implements c8 {
    public final long a;
    public final long b;
    public long c;

    public o1(long v, long v1) {
        this.a = v;
        this.b = v1;
        this.c = v - 1L;
    }

    public final void c() {
        if(this.c < this.a || this.c > this.b) {
            throw new NoSuchElementException();
        }
    }

    @Override  // i.n.i.b.a.s.e.c8
    public final boolean next() {
        long v = this.c + 1L;
        this.c = v;
        return Long.compare(v, this.b) <= 0 ? 1 : 0;
    }
}

