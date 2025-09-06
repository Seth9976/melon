package h7;

import java.util.List;
import k8.Y;

public final class h0 extends J0 {
    public final List a;

    public h0(List list0) {
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof J0 ? this.a.equals(((h0)(((J0)object0))).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return Y.m(new StringBuilder("RolloutsState{rolloutAssignments="), this.a, "}");
    }
}

