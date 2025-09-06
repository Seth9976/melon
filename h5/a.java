package h5;

import java.io.Serializable;

public final class a implements Serializable {
    public double a;
    public double b;
    public double c;
    public double d;
    private static final long serialVersionUID = 0x9CD72D9C508FADACL;

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof a && this.a == ((a)object0).a && this.c == ((a)object0).c && this.b == ((a)object0).b && this.d == ((a)object0).d;
    }

    @Override
    public final int hashCode() {
        long v = Double.doubleToLongBits(this.a);
        long v1 = Double.doubleToLongBits(this.b);
        long v2 = Double.doubleToLongBits(this.c);
        long v3 = Double.doubleToLongBits(this.d);
        return ((int)(v3 >>> 0x20 ^ v3)) + (((int)(v2 ^ v2 >>> 0x20)) + (((int)(v1 ^ v1 >>> 0x20)) + (((int)(v ^ v >>> 0x20)) + 629) * 37) * 37) * 37;
    }

    @Override
    public final String toString() {
        return new c(this.b, this.c) + " -> " + new c(this.a, this.d);
    }
}

