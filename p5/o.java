package P5;

public final class o extends A {
    public final r a;

    public o(r r0) {
        this.a = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof A && this.a.equals(((o)(((A)object0))).a)) {
                ((o)(((A)object0))).getClass();
                return z.a.equals(z.a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ z.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ComplianceData{privacyContext=" + this.a + ", productIdOrigin=" + z.a + "}";
    }
}

