package M7;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class v {
    public final String a;

    public v(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v ? q.b(this.a, ((v)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("FirebaseSessionsData(sessionId="), this.a, ')');
    }
}

