package b3;

import I6.V;
import java.util.Collections;
import java.util.List;

public final class r0 {
    public final q0 a;
    public final V b;
    public static final String c;
    public static final String d;

    static {
        r0.c = "0";
        r0.d = "1";
    }

    public r0(q0 q00, List list0) {
        if(!list0.isEmpty() && (((int)(((Integer)Collections.min(list0)))) < 0 || ((int)(((Integer)Collections.max(list0)))) >= q00.a)) {
            throw new IndexOutOfBoundsException();
        }
        this.a = q00;
        this.b = V.p(list0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return r0.class == class0 && this.a.equals(((r0)object0).a) && this.b.equals(((r0)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() * 0x1F + this.a.hashCode();
    }
}

