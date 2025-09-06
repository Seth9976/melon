package ud;

public final class m0 extends t0 {
    public final boolean a;

    public m0(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m0 ? this.a == ((m0)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "LikeClickUserEvent(clickToLike=" + this.a + ")";
    }
}

