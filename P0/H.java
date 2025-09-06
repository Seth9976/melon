package p0;

import we.k;

public abstract class h {
    public l a;
    public long b;
    public boolean c;
    public int d;

    public h(long v, l l0) {
        int v5;
        this.a = l0;
        this.b = v;
        if(v == 0L) {
            v5 = -1;
        }
        else {
            l l1 = this.d();
            long v1 = l1.c;
            long[] arr_v = l1.d;
            if(arr_v == null) {
                long v2 = l1.b;
                if(v2 == 0L) {
                    long v3 = l1.a;
                    if(v3 != 0L) {
                        v = ((long)Long.numberOfTrailingZeros(v3)) + (v1 + 0x40L);
                    }
                }
                else {
                    v = ((long)Long.numberOfTrailingZeros(v2)) + v1;
                }
            }
            else {
                v = arr_v[0];
            }
            synchronized(m.b) {
                v5 = m.e.g(v);
            }
        }
        this.d = v5;
    }

    public final void a() {
        synchronized(m.b) {
            this.b();
            this.p();
        }
    }

    public void b() {
        m.c = m.c.b(this.g());
    }

    public abstract void c();

    public l d() {
        return this.a;
    }

    public abstract k e();

    public abstract boolean f();

    public long g() {
        return this.b;
    }

    public int h() {
        return 0;
    }

    public abstract k i();

    public final h j() {
        h h0 = (h)m.a.i();
        m.a.v(this);
        return h0;
    }

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n(t arg1);

    public final void o() {
        int v = this.d;
        if(v >= 0) {
            m.u(v);
            this.d = -1;
        }
    }

    public void p() {
        this.o();
    }

    public static void q(h h0) {
        m.a.v(h0);
    }

    public void r(l l0) {
        this.a = l0;
    }

    public void s(long v) {
        this.b = v;
    }

    public void t(int v) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract h u(k arg1);
}

