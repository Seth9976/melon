package h5;

import java.io.Serializable;

public final class c implements Serializable {
    public final double a;
    public final double b;
    private static final long serialVersionUID = 0x678001DBCF4E3048L;

    public c(double f, double f1) {
        this.b = f;
        this.a = f1;
        if(Math.abs(f) > 90.0 || Math.abs(f1) > 180.0) {
            throw new IllegalArgumentException("The supplied coordinates " + this + " are out of range.");
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c && this.b == ((c)object0).b && this.a == ((c)object0).a;
    }

    @Override
    public final int hashCode() {
        long v = Double.doubleToLongBits(this.b);
        long v1 = Double.doubleToLongBits(this.a);
        return (1302 + ((int)(v ^ v >>> 0x20))) * 0x1F + ((int)(v1 ^ v1 >>> 0x20));
    }

    @Override
    public final String toString() {
        return String.format(("(" + this.b + "," + this.a + ")"));
    }
}

