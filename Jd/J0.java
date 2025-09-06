package jd;

import gd.Z3;
import java.util.List;
import kotlin.jvm.internal.q;

public final class j0 extends Z3 {
    public final List a;

    public j0(List list0) {
        q.g(list0, "list");
        super();
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j0 ? q.b(this.a, ((j0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "UploadImage(list=" + this.a + ")";
    }
}

