package u7;

public final class a implements e {
    public final int a;

    public a(int v) {
        this.a = v;
    }

    @Override
    public final Class annotationType() {
        return e.class;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof e && this.a == ((a)(((e)object0))).a) {
                ((a)(((e)object0))).getClass();
                return d.a.equals(d.a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (0xDE0D66 ^ this.a) + (d.a.hashCode() ^ 2041407134);
    }

    @Override
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + d.a + ')';
    }
}

