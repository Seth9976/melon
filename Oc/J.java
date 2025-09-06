package oc;

public final class j implements l {
    public final int a;
    public final boolean b;

    public j(int v, boolean z) {
        this.a = v;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        return this.a == ((j)object0).a ? this.b == ((j)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "IndexChanged(index=" + this.a + ", play=" + this.b + ")";
    }
}

