package d5;

import kotlin.jvm.internal.q;

public final class d {
    public final String a;
    public final Long b;

    public d(String s, Long long0) {
        this.a = s;
        this.b = long0;
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
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "Preference(key=" + this.a + ", value=" + this.b + ')';
    }
}

