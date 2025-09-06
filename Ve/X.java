package Ve;

public final class x extends E {
    public final byte a;

    public x(byte b) {
        this.a = b;
    }

    @Override  // Ve.E
    public final Object a() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? this.a == ((x)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Byte.hashCode(this.a);
    }
}

