package gd;

public final class m8 extends Z3 {
    public final int a;

    public m8(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m8 ? this.a == ((m8)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "ChangePage(settledPage=" + this.a + ")";
    }
}

