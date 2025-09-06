package i.n.i.b.a.s.e;

public final class r6 {
    public boolean a;
    public long b;
    public long c;
    public long d;

    public r6(long v) {
        this.b = v;
        this.d = 0x8000000000000001L;
    }

    public final long a(long v) {
        synchronized(this) {
            if(v == 0x8000000000000001L) {
                return 0x8000000000000001L;
            }
            if(this.d == 0x8000000000000001L) {
                long v2 = this.b;
                if(v2 != 0x7FFFFFFFFFFFFFFFL) {
                    this.c = v2 - v;
                }
                this.d = v;
                this.notifyAll();
            }
            else {
                this.d = v;
            }
            return v + this.c;
        }
    }

    public final long b(long v) {
        synchronized(this) {
            return v == 0x8000000000000001L ? 0x8000000000000001L : this.a(v * 1000000L / 90000L);
        }
    }

    public final long c() {
        long v;
        synchronized(this) {
            if(this.b == 0x7FFFFFFFFFFFFFFFL) {
                v = 0L;
            }
            else {
                v = this.d == 0x8000000000000001L ? 0x8000000000000001L : this.c;
            }
        }
        return v;
    }

    @Override
    public final Object clone() {
        return new r6(this.d);
    }
}

