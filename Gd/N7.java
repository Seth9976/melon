package gd;

import kotlin.jvm.internal.q;

public final class n7 extends Z3 {
    public final String a;
    public final int b;

    public n7(String s, int v) {
        this.a = s;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n7)) {
            return false;
        }
        return q.b(this.a, ((n7)object0).a) ? this.b == ((n7)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "DeleteRecentTagItem(tagName=" + this.a + ", position=" + this.b + ")";
    }
}

