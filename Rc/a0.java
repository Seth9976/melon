package Rc;

import b3.Z;

public final class a0 extends d0 {
    public final int a;
    public final long b;

    public a0(int v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a0)) {
            return false;
        }
        return this.a == ((a0)object0).a ? this.b == ((a0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.n(this.a, "PrevLongClick(repCnt=", ", howLong=", this.b);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

