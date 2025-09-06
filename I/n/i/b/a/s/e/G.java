package i.n.i.b.a.s.e;

public final class g {
    public Object a;
    public Object b;
    public int c;
    public long d;
    public long e;
    public boolean f;
    public Ud g;

    public g() {
        this.g = Ud.e;
    }

    public final int a(long v) {
        Ud ud0 = this.g;
        long[] arr_v = ud0.b;
        if(Long.compare(v, 0x8000000000000000L) != 0 && (this.d == 0x8000000000000001L || v < this.d)) {
            int v1;
            for(v1 = 0; v1 < arr_v.length; ++v1) {
                long v2 = arr_v[v1];
                if(v2 == 0x8000000000000000L || v2 > v) {
                    Td td0 = ud0.c[v1];
                    if(td0.a != -1 && td0.a(-1) >= td0.a) {
                        continue;
                    }
                    break;
                }
            }
            return v1 >= arr_v.length ? -1 : v1;
        }
        return -1;
    }

    public final long b(int v, int v1) {
        Td td0 = this.g.c[v];
        return td0.a == -1 ? 0x8000000000000001L : td0.d[v1];
    }

    public final int c(int v) {
        return this.g.c[v].a(-1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return g.class.equals(class0) && L7.p(this.a, ((g)object0).a) && L7.p(this.b, ((g)object0).b) && this.c == ((g)object0).c && this.d == ((g)object0).d && this.e == ((g)object0).e && this.f == ((g)object0).f && L7.p(this.g, ((g)object0).g);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return this.g.hashCode() + ((((((v1 + 0xD9) * 0x1F + v) * 0x1F + this.c) * 0x1F + ((int)(this.d ^ this.d >>> 0x20))) * 0x1F + ((int)(this.e ^ this.e >>> 0x20))) * 0x1F + this.f) * 0x1F;
    }
}

