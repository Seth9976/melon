package androidx.compose.runtime;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class a1 {
    public final Object a;
    public final int b;

    public a1(Object object0, int v) {
        this.a = object0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a1)) {
            return false;
        }
        return q.b(this.a, ((a1)object0).a) ? this.b == ((a1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SourceInformationSlotTableGroupIdentity(parentIdentity=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", index=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

