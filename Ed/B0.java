package ed;

public final class b0 {
    public final int a;
    public final int b;

    public b0(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b0)) {
            return false;
        }
        return this.a == ((b0)object0).a ? this.b == ((b0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "GenreViewSizeInfo(singleItemWidth=" + this.a + ", doubleItemWidth=" + this.b + ")";
    }
}

