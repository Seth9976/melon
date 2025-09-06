package L7;

import java.util.HashSet;

public final class d {
    public final HashSet a;

    public d(HashSet hashSet0) {
        this.a = hashSet0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof d ? this.a.equals(((d)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.a + "}";
    }
}

