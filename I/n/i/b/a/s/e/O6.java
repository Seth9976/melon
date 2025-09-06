package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class o6 {
    public final q2[] a;
    public int b;

    public o6(q2[] arr_q2) {
        this.a = arr_q2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return o6.class == class0 ? Arrays.equals(this.a, ((o6)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.b == 0) {
            this.b = Arrays.hashCode(this.a) + 0x20F;
        }
        return this.b;
    }
}

