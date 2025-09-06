package P5;

public final class q extends C {
    public final Integer a;

    public q(Integer integer0) {
        this.a = integer0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof C) {
            return this.a == null ? ((q)(((C)object0))).a == null : this.a.equals(((q)(((C)object0))).a);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 1000003 : this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.a + "}";
    }
}

