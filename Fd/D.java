package Fd;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class d extends e {
    public final List a;
    public final List b;

    public d(ArrayList arrayList0, ArrayList arrayList1) {
        this.a = arrayList0;
        this.b = arrayList1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        List list0 = this.b;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "Success(recentSearch=" + this.a + ", contentsList=" + this.b + ")";
    }
}

