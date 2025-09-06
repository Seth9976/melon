package Ve;

import A7.d;

public final class f0 {
    public final int a;
    public final int b;
    public final int c;

    public f0(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f0)) {
            return false;
        }
        if(this.a != ((f0)object0).a) {
            return false;
        }
        return this.b == ((f0)object0).b ? this.c == ((f0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return this.a + '.' + this.b + '.' + this.c;
    }
}

