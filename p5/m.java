package P5;

import java.util.ArrayList;

public final class m extends w {
    public final ArrayList a;

    public m(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof w ? this.a.equals(((m)(((w)object0))).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}

