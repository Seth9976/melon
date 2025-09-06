package vd;

import kotlin.jvm.internal.q;

public final class w {
    public final int a;
    public final String b;

    public w(int v, String s) {
        q.g(s, "text");
        super();
        this.a = v;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        return this.a == ((w)object0).a ? q.b(this.b, ((w)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickListItem(position=" + this.a + ", text=" + this.b + ")";
    }
}

