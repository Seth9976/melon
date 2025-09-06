package Vc;

public final class k implements o {
    public final boolean a;

    public k(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && this.a == ((k)object0).a;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "OnAnimationCompleted(isCompleted=" + this.a + ")";
    }
}

