package cd;

import Pc.e;
import kotlin.jvm.internal.q;

public final class v2 implements e {
    public final u2 a;

    public v2(u2 u20) {
        q.g(u20, "middleBannerSlotUiState");
        super();
        this.a = u20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v2 ? q.b(this.a, ((v2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnBannerClick(middleBannerSlotUiState=" + this.a + ")";
    }
}

