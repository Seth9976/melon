package bb;

import java.util.List;
import kotlin.jvm.internal.q;

public final class m extends o {
    public final List a;

    public m(List list0) {
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? q.b(this.a, ((m)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "UpdateLikeState(likeList=" + this.a + ")";
    }
}

