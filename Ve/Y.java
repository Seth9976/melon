package Ve;

public final class y extends E {
    public final char a;

    public y(char c) {
        this.a = c;
    }

    @Override  // Ve.E
    public final Object a() {
        return Character.valueOf(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y ? this.a == ((y)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Character.hashCode(this.a);
    }
}

