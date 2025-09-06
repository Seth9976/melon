package d5;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class g {
    public final String a;
    public final int b;
    public final int c;

    public g(String s, int v, int v1) {
        q.g(s, "workSpecId");
        super();
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(!q.b(this.a, ((g)object0).a)) {
            return false;
        }
        return this.b == ((g)object0).b ? this.c == ((g)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SystemIdInfo(workSpecId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", generation=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", systemId=");
        return o.q(stringBuilder0, this.c, ')');
    }
}

