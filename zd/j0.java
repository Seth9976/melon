package zd;

import Ad.C;
import com.melon.ui.k2;
import kotlin.jvm.internal.q;

public final class j0 extends C {
    public final k2 a;

    public j0(k2 k20) {
        this.a = k20;
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
        return "ClickShare(sharableEvent=" + this.a + ")";
    }
}

