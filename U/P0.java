package U;

public final class p0 {
    public final int a;

    public p0(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof p0 && this.a == ((p0)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "MenuItemsAvailability(value=" + this.a + ')';
    }
}

