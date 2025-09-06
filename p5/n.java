package P5;

public final class n extends y {
    public final l a;

    public n(l l0) {
        this.a = l0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof y) {
                ((n)(((y)object0))).getClass();
                return x.a.equals(x.a) && this.a.equals(((n)(((y)object0))).a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (x.a.hashCode() ^ 1000003) * 1000003 ^ this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClientInfo{clientType=" + x.a + ", androidClientInfo=" + this.a + "}";
    }
}

