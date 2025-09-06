package Gf;

import we.a;

public final class g {
    public final Object a;
    public final a b;

    public g(Object object0, a a0) {
        this.a = object0;
        this.b = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return g.class == class0 && this.a.equals(((g)object0).a);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

