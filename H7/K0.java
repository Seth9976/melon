package h7;

import U4.x;

public final class k0 extends M0 {
    public final String a;

    public k0(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof M0 ? this.a.equals(((k0)(((M0)object0))).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("User{identifier="), this.a, "}");
    }
}

