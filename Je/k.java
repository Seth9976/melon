package je;

import java.util.Set;
import kotlin.jvm.internal.q;

public abstract class k extends a implements Set {
    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof Set)) {
            return false;
        }
        q.g(((Set)object0), "other");
        return this.size() == ((Set)object0).size() ? this.containsAll(((Set)object0)) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this) {
            v += (object0 == null ? 0 : object0.hashCode());
        }
        return v;
    }
}

