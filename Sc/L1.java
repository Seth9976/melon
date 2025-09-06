package sc;

import kotlin.jvm.internal.q;

public final class l1 {
    public final String a;
    public final String b;

    public l1(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l1)) {
            return false;
        }
        return q.b(this.a, ((l1)object0).a) ? q.b(this.b, ((l1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "UserData(memberKey=" + this.a + ", token=" + this.b + ")";
    }
}

