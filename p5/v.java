package P5;

public final class v extends I {
    public final H a;
    public final G b;

    public v(H h0, G g0) {
        this.a = h0;
        this.b = g0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof I) {
            H h0 = this.a;
            if(h0 == null) {
                if(((v)(((I)object0))).a == null) {
                    return this.b == null ? ((v)(((I)object0))).b == null : this.b.equals(((v)(((I)object0))).b);
                }
            }
            else if(h0.equals(((v)(((I)object0))).a)) {
                return this.b == null ? ((v)(((I)object0))).b == null : this.b.equals(((v)(((I)object0))).b);
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        G g0 = this.b;
        if(g0 != null) {
            v = g0.hashCode();
        }
        return v ^ (v1 ^ 1000003) * 1000003;
    }

    @Override
    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }
}

