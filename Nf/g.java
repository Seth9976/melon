package nf;

import A7.d;

public final class g {
    public final int a;
    public final int b;
    public final int c;
    public static final g d;

    static {
        g.d = new g(0x100, 0x100, 0x100);
    }

    public g(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(this.a != ((g)object0).a) {
            return false;
        }
        return this.b == ((g)object0).b ? this.c == ((g)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return this.c == 0 ? this.a + '.' + this.b : this.a + '.' + this.b + '.' + this.c;
    }
}

