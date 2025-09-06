package gd;

import kotlin.jvm.internal.q;

public final class f8 extends i8 {
    public final String a;

    public f8(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f8 ? q.b(this.a, ((f8)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "TitleItem(title=" + this.a + ")";
    }
}

