package d5;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class j {
    public final String a;
    public final int b;

    public j(String s, int v) {
        q.g(s, "workSpecId");
        super();
        this.a = s;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        return q.b(this.a, ((j)object0).a) ? this.b == ((j)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("WorkGenerationalId(workSpecId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", generation=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

