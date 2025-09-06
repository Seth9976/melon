package Ce;

public final class d {
    public final float a;
    public final float b;

    public d(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    public static boolean a(Float float0, Float float1) {
        return float0.floatValue() <= float1.floatValue();
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof d && (this.a > this.b && ((d)object0).a > ((d)object0).b || this.a == ((d)object0).a && this.b == ((d)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.a <= this.b ? Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F : -1;
    }

    @Override
    public final String toString() {
        return this.a + ".." + this.b;
    }
}

