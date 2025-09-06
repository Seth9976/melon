package N5;

public final class b {
    public final Integer a;

    public b(Integer integer0) {
        this.a = integer0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof b) {
            return this.a == null ? ((b)object0).a == null : this.a.equals(((b)object0).a);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 1000003 : this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return "ProductData{productId=" + this.a + "}";
    }
}

