package qb;

import e1.u;
import java.util.List;
import kotlin.jvm.internal.q;

public final class b extends u {
    public final List e;

    public b(List list0) {
        q.g(list0, "dataList");
        super();
        this.e = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.e, ((b)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode();
    }

    @Override
    public final String toString() {
        return "ItemList(dataList=" + this.e + ")";
    }
}

