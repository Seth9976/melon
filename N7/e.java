package N7;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class e {
    public final String a;

    public e(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e ? q.b(this.a, ((e)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("SessionDetails(sessionId="), this.a, ')');
    }
}

