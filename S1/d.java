package S1;

import android.graphics.Insets;
import androidx.appcompat.app.o;

public final class d {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public static final d e;

    static {
        d.e = new d(0, 0, 0, 0);
    }

    public d(int v, int v1, int v2, int v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    public static d a(d d0, d d1) {
        return d.c(Math.max(d0.a, d1.a), Math.max(d0.b, d1.b), Math.max(d0.c, d1.c), Math.max(d0.d, d1.d));
    }

    public static d b(d d0, d d1) {
        return d.c(Math.min(d0.a, d1.a), Math.min(d0.b, d1.b), Math.min(d0.c, d1.c), Math.min(d0.d, d1.d));
    }

    public static d c(int v, int v1, int v2, int v3) {
        return v != 0 || v1 != 0 || v2 != 0 || v3 != 0 ? new d(v, v1, v2, v3) : d.e;
    }

    public static d d(Insets insets0) {
        return d.c(insets0.left, insets0.top, insets0.right, insets0.bottom);
    }

    public final Insets e() {
        return b.j(this.a, this.b, this.c, this.d);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(d.class != class0 || this.d != ((d)object0).d) {
                return false;
            }
            if(this.a != ((d)object0).a) {
                return false;
            }
            return this.c == ((d)object0).c ? this.b == ((d)object0).b : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((this.a * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Insets{left=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", top=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", right=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", bottom=");
        return o.q(stringBuilder0, this.d, '}');
    }
}

