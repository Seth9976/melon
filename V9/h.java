package v9;

import va.e;

public final class h {
    public final Object a;
    public static final h b;

    static {
        h.b = new h(null);
    }

    public h(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof h) {
                ((h)object0).getClass();
                Object object1 = ((h)object0).a;
                return this.a == null ? object1 == null : this.a.equals(object1);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0x707F : this.a.hashCode() + 0x707F;
    }

    @Override
    public final String toString() {
        return e.d(new StringBuilder("FetchParam [intParam=-1, intParam2=-1, objParam="), this.a, "]");
    }
}

