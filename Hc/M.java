package hc;

import com.google.android.gms.cast.framework.CastContext;
import kotlin.jvm.internal.q;

public final class m implements o {
    public final CastContext a;

    public m(CastContext castContext0) {
        this.a = castContext0;
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
        return "Cast(context=" + this.a + ")";
    }
}

