package Ac;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class u3 {
    public final String a;
    public final int b;
    public final boolean c;

    public u3(String s, int v, boolean z) {
        this.a = s;
        this.b = v;
        this.c = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u3)) {
            return false;
        }
        if(!q.b(this.a, ((u3)object0).a)) {
            return false;
        }
        return this.b == ((u3)object0).b ? this.c == ((u3)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return o.s(o.u(this.b, "FilterData(name=", this.a, ", code=", ", isSelected="), this.c, ")");
    }
}

