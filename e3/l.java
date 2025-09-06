package e3;

public final class l {
    public final Object a;
    public b3.l b;
    public boolean c;
    public boolean d;

    public l(Object object0) {
        this.a = object0;
        this.b = new b3.l(0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return l.class == class0 ? this.a.equals(((l)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

