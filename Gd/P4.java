package gd;

import kotlin.jvm.internal.q;

public final class p4 extends r4 {
    public final String a;

    public p4(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p4 ? q.b(this.a, ((p4)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "HeaderItemUiState(title=" + this.a + ")";
    }
}

