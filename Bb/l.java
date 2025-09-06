package bb;

public final class l extends o {
    public final int a;

    public l(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof l && this.a == ((l)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "ShowToast(resId=" + this.a + ")";
    }
}

