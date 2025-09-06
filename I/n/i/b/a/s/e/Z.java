package i.n.i.b.a.s.e;

import ea.b;
import x9.a;

public final class z implements B7 {
    public final u a;
    public final a b;
    public long[] c;
    public boolean d;
    public y3 e;
    public boolean f;
    public int g;
    public long h;

    public z(y3 y30, u u0, boolean z) {
        this.a = u0;
        this.e = y30;
        this.b = new a();
        this.h = 0x8000000000000001L;
        this.c = y30.b;
        this.a(y30, z);
    }

    public final void a(y3 y30, boolean z) {
        long v = 0x8000000000000001L;
        long v1 = this.g == 0 ? 0x8000000000000001L : this.c[this.g - 1];
        this.d = z;
        this.e = y30;
        long[] arr_v = y30.b;
        this.c = arr_v;
        long v2 = this.h;
        if(v2 != 0x8000000000000001L) {
            int v3 = L7.g(arr_v, v2, true);
            this.g = v3;
            if(this.d && v3 == this.c.length) {
                v = v2;
            }
            this.h = v;
            return;
        }
        if(v1 != 0x8000000000000001L) {
            this.g = L7.g(arr_v, v1, false);
        }
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        if((v & 2) == 0 && this.f) {
            int v1 = this.g;
            if(v1 == this.c.length) {
                if(!this.d) {
                    i80.b = 4;
                    return -4;
                }
                return -3;
            }
            this.g = v1 + 1;
            byte[] arr_b = this.b.n(this.e.a[v1]);
            i80.r(arr_b.length);
            i80.d.put(arr_b);
            i80.f = this.c[v1];
            i80.b = 1;
            return -4;
        }
        b0.b = this.a;
        this.f = true;
        return -5;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        int v1 = Math.max(this.g, L7.g(this.c, v, true));
        int v2 = v1 - this.g;
        this.g = v1;
        return v2;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return -1;
    }
}

