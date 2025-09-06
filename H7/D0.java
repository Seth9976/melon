package h7;

import U4.x;

public final class d0 extends G0 {
    public final String a;

    public d0(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof G0 ? this.a.equals(((d0)(((G0)object0))).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("Log{content="), this.a, "}");
    }
}

