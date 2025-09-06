package l3;

import java.util.List;
import java.util.NoSuchElementException;
import m3.g;
import t3.c;

public final class e implements c {
    public final long a;
    public long b;
    public final List c;
    public final long d;

    public e(long v, List list0) {
        this.a = (long)(list0.size() - 1);
        this.b = -1L;
        this.d = v;
        this.c = list0;
    }

    @Override  // t3.c
    public final long getChunkEndTimeUs() {
        long v = this.b;
        if(v < 0L || v > this.a) {
            throw new NoSuchElementException();
        }
        g g0 = (g)this.c.get(((int)v));
        return this.d + g0.e + g0.c;
    }

    @Override  // t3.c
    public final long getChunkStartTimeUs() {
        long v = this.b;
        if(v < 0L || v > this.a) {
            throw new NoSuchElementException();
        }
        long v1 = ((g)this.c.get(((int)v))).e;
        return this.d + v1;
    }

    @Override  // t3.c
    public final boolean next() {
        long v = this.b + 1L;
        this.b = v;
        return Long.compare(v, this.a) <= 0 ? 1 : 0;
    }
}

