package i.n.i.b.a.s.e;

public class n1 {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public n1(n1 n10) {
        this.a = n10.a;
        this.b = n10.b;
        this.c = n10.c;
        this.d = n10.d;
        this.e = n10.e;
    }

    public n1(Object object0, int v, int v1, long v2, int v3) {
        this.a = object0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
    }

    public final boolean a() {
        return this.b != -1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n1 ? this.a.equals(((n1)object0).a) && this.b == ((n1)object0).b && this.c == ((n1)object0).c && this.d == ((n1)object0).d && this.e == ((n1)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return ((((this.a.hashCode() + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F + ((int)this.d)) * 0x1F + this.e;
    }
}

