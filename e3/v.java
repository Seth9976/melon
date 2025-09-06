package e3;

import java.math.RoundingMode;

public final class v {
    public long a;
    public long b;
    public long c;
    public final ThreadLocal d;

    public v(long v) {
        this.d = new ThreadLocal();
        this.f(v);
    }

    public final long a(long v) {
        synchronized(this) {
            if(v == 0x8000000000000001L) {
                return 0x8000000000000001L;
            }
            if(!this.e()) {
                long v2 = this.a;
                if(v2 == 0x7FFFFFFFFFFFFFFEL) {
                    Long long0 = (Long)this.d.get();
                    long0.getClass();
                    v2 = (long)long0;
                }
                this.b = v2 - v;
                this.notifyAll();
            }
            this.c = v;
            return v + this.b;
        }
    }

    public final long b(long v) {
        long v2;
        synchronized(this) {
            if(v != 0x8000000000000001L) {
                long v1 = this.c;
                if(v1 != 0x8000000000000001L) {
                    x.T(v1, 90000L, 1000000L, RoundingMode.DOWN);
                }
                return this.a(x.T(v, 1000000L, 90000L, RoundingMode.DOWN));
            }
            return 0x8000000000000001L;
        }
        return v2;
    }

    public final long c(long v) {
        long v4;
        synchronized(this) {
            if(v != 0x8000000000000001L) {
                long v1 = this.c;
                if(v1 != 0x8000000000000001L) {
                    long v2 = x.T(v1, 90000L, 1000000L, RoundingMode.DOWN);
                    long v3 = v2 / 0x200000000L * 0x200000000L + v;
                    if(v3 >= v2) {
                        v = v3;
                    }
                }
                return this.a(x.T(v, 1000000L, 90000L, RoundingMode.DOWN));
            }
            return 0x8000000000000001L;
        }
        return v4;
    }

    public final long d() {
        synchronized(this) {
        }
        return this.a != 0x7FFFFFFFFFFFFFFFL && this.a != 0x7FFFFFFFFFFFFFFEL ? this.a : 0x8000000000000001L;
    }

    public final boolean e() {
        synchronized(this) {
        }
        return this.b != 0x8000000000000001L;
    }

    public final void f(long v) {
        synchronized(this) {
            this.a = v;
            this.b = Long.compare(v, 0x7FFFFFFFFFFFFFFFL) == 0 ? 0L : 0x8000000000000001L;
            this.c = 0x8000000000000001L;
        }
    }

    public final void g(long v, boolean z) {
        synchronized(this) {
            b.j(this.a == 0x7FFFFFFFFFFFFFFEL);
            if(this.e()) {
                return;
            }
            if(z) {
                this.d.set(v);
            }
            else {
                while(!this.e()) {
                    this.wait();
                }
            }
        }
    }
}

