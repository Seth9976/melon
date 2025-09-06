package N5;

import U4.x;

public final class c {
    public final String a;

    public c(String s) {
        if(s == null) {
            throw new NullPointerException("name is null");
        }
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? this.a.equals(((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("Encoding{name=\""), this.a, "\"}");
    }
}

