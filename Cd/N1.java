package cd;

import kotlin.jvm.internal.q;

public final class n1 implements p1 {
    public final m1 a;

    public n1(m1 m10) {
        q.g(m10, "uiState");
        super();
        this.a = m10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n1 ? q.b(this.a, ((n1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnBannerClick(uiState=" + this.a + ")";
    }
}

