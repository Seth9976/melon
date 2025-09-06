package N9;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class d {
    public final String a;
    public final String b;

    public d(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RefreshInfo(flag=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", reason=");
        return o.r(stringBuilder0, this.b, ')');
    }
}

