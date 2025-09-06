package l1;

public final class a {
    public final float a;

    public a(float f) {
        this.a = f;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a && Float.compare(this.a, ((a)object0).a) == 0;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "BaselineShift(multiplier=" + this.a + ')';
    }
}

