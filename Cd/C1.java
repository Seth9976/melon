package cd;

import kotlin.jvm.internal.q;

public final class c1 implements e1 {
    public final String a;
    public final b1 b;

    public c1(String s, b1 b10) {
        q.g(s, "selectedTab");
        q.g(b10, "uiState");
        super();
        this.a = s;
        this.b = b10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c1)) {
            return false;
        }
        return q.b(this.a, ((c1)object0).a) ? q.b(this.b, ((c1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnComponentShown(selectedTab=" + this.a + ", uiState=" + this.b + ")";
    }
}

