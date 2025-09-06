package s3;

public final class z {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public z(Object object0) {
        this(object0, -1L);
    }

    public z(Object object0, int v, int v1, long v2, int v3) {
        this.a = object0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
    }

    public z(Object object0, long v) {
        this(object0, -1, -1, v, -1);
    }

    public z(Object object0, long v, int v1) {
        this(object0, -1, -1, v, v1);
    }

    // 去混淆评级： 低(20)
    public final z a(Object object0) {
        return this.a.equals(object0) ? this : new z(object0, this.b, this.c, this.d, this.e);
    }

    public final boolean b() {
        return this.b != -1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof z ? this.a.equals(((z)object0).a) && this.b == ((z)object0).b && this.c == ((z)object0).c && this.d == ((z)object0).d && this.e == ((z)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return ((((this.a.hashCode() + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F + ((int)this.d)) * 0x1F + this.e;
    }
}

