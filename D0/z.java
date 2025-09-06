package D0;

import A7.d;

public final class z extends A {
    public final float c;

    public z(float f) {
        super(3);
        this.c = f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof z ? Float.compare(this.c, ((z)object0).c) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.c);
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("VerticalTo(y="), this.c, ')');
    }
}

