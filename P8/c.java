package p8;

import kotlin.jvm.internal.q;

public final class c {
    public final String a;
    public final String b;

    public c(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        return q.b(this.a, ((c)object0).a) ? q.b(this.b, ((c)object0).b) : false;
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
        return "TiaraCommCode(codeName=" + this.a + ", commCode=" + this.b + ")";
    }
}

