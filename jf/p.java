package jf;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class p {
    public final String a;

    public p(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? q.b(this.a, ((p)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("MemberSignature(signature="), this.a, ')');
    }
}

