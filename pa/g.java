package Pa;

public final class g extends h {
    public final int a;

    public g(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g && this.a == ((g)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "ShowToast(messageId=" + this.a + ")";
    }
}

