package r1;

import A7.d;
import androidx.appcompat.app.o;

public final class k {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public static final k e;

    static {
        k.e = new k(0, 0, 0, 0);
    }

    public k(int v, int v1, int v2, int v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    public final long a() {
        return ((long)this.a) << 0x20 | ((long)this.b) & 0xFFFFFFFFL;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        if(this.a != ((k)object0).a) {
            return false;
        }
        if(this.b != ((k)object0).b) {
            return false;
        }
        return this.c == ((k)object0).c ? this.d == ((k)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return this.d + d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("IntRect.fromLTRB(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", ");
        return o.q(stringBuilder0, this.d, ')');
    }
}

