package va;

import A8.r;

public final class m1 implements n1 {
    public final r a;

    public m1(r r0) {
        this.a = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m1 ? this.a == ((m1)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(resLoginType=" + this.a + ")";
    }
}

