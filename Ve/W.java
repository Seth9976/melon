package Ve;

public final class w extends E {
    public final boolean a;

    public w(boolean z) {
        this.a = z;
    }

    @Override  // Ve.E
    public final Object a() {
        return Boolean.valueOf(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? this.a == ((w)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }
}

