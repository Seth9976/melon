package Ke;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class l {
    public final k a;
    public final int b;

    public l(k k0, int v) {
        this.a = k0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        return q.b(this.a, ((l)object0).a) ? this.b == ((l)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("KindWithArity(kind=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", arity=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

