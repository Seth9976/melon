package androidx.compose.runtime;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class d0 {
    public final String a;

    public d0(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d0 ? q.b(this.a, ((d0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("OpaqueKey(key="), this.a, ')');
    }
}

