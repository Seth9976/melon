package ac;

import kotlin.jvm.internal.q;

public final class k {
    public final String a;
    public final String b;

    static {
        new k("", "");
    }

    public k(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        return q.b(this.a, ((k)object0).a) ? q.b(this.b, ((k)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "CacheInfo(id=" + this.a + ", c=" + this.b + ")";
    }
}

